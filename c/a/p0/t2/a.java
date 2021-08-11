package c.a.p0.t2;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.pushdialog.data.PushDialogHttpResMsg;
import com.baidu.tieba.pushdialog.data.PushDialogReqNetMsg;
import com.baidu.tieba.pushdialog.data.PushDialogSocketResMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PushDialogActivity f24411a;

    /* renamed from: b  reason: collision with root package name */
    public String f24412b;

    /* renamed from: c  reason: collision with root package name */
    public long f24413c;

    /* renamed from: c.a.p0.t2.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1133a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f24414a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1133a(a aVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24414a = aVar;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage instanceof PushDialogHttpResMsg) {
                    this.f24414a.f((PushDialogHttpResMsg) responsedMessage);
                } else if (responsedMessage instanceof PushDialogSocketResMsg) {
                    this.f24414a.g((PushDialogSocketResMsg) responsedMessage);
                }
            }
        }
    }

    public a(PushDialogActivity pushDialogActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pushDialogActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24411a = pushDialogActivity;
        pushDialogActivity.registerListener(new C1133a(this, CmdConfigHttp.CMD_GET_PUSH_DIALOG_DATA, 309614));
        Intent intent = this.f24411a.getIntent();
        if (intent != null) {
            this.f24412b = intent.getStringExtra("thread_id");
            this.f24413c = intent.getLongExtra("task_id", 0L);
            if (StringUtils.isNull(this.f24412b)) {
                this.f24411a.finish();
            }
        }
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f24413c : invokeV.longValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f24412b : (String) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            long f2 = c.a.e.e.m.b.f(this.f24412b, 0L);
            if (f2 == 0) {
                PushDialogActivity pushDialogActivity = this.f24411a;
                if (pushDialogActivity != null) {
                    pushDialogActivity.onNetCallback(false, null);
                    return;
                }
                return;
            }
            PushDialogReqNetMsg pushDialogReqNetMsg = new PushDialogReqNetMsg();
            pushDialogReqNetMsg.setTask_id(this.f24413c);
            pushDialogReqNetMsg.setTid(f2);
            MessageManager.getInstance().sendMessage(pushDialogReqNetMsg);
        }
    }

    public final void f(PushDialogHttpResMsg pushDialogHttpResMsg) {
        PushDialogActivity pushDialogActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, pushDialogHttpResMsg) == null) || (pushDialogActivity = this.f24411a) == null) {
            return;
        }
        pushDialogActivity.onNetCallback(pushDialogHttpResMsg.getError() == 0, pushDialogHttpResMsg.getData());
    }

    public final void g(PushDialogSocketResMsg pushDialogSocketResMsg) {
        PushDialogActivity pushDialogActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, pushDialogSocketResMsg) == null) || (pushDialogActivity = this.f24411a) == null) {
            return;
        }
        pushDialogActivity.onNetCallback(!pushDialogSocketResMsg.hasError(), pushDialogSocketResMsg.getData());
    }
}
