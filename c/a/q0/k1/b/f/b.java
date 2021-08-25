package c.a.q0.k1.b.f;

import c.a.p0.s.s.f;
import c.a.p0.s.s.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.DelReplyAtMsgResMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PopupDialog f21355a;

    /* renamed from: b  reason: collision with root package name */
    public i f21356b;

    /* renamed from: c  reason: collision with root package name */
    public List<f> f21357c;

    /* renamed from: d  reason: collision with root package name */
    public f f21358d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.k1.b.f.a f21359e;

    /* renamed from: f  reason: collision with root package name */
    public c f21360f;

    /* renamed from: g  reason: collision with root package name */
    public i.d f21361g;

    /* loaded from: classes3.dex */
    public class a implements i.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f21362a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21362a = bVar;
        }

        @Override // c.a.p0.s.s.i.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21362a.d();
            }
        }
    }

    /* renamed from: c.a.q0.k1.b.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0998b implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f21363a;

        public C0998b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21363a = bVar;
        }

        @Override // c.a.p0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21363a.c();
                if (this.f21363a.f21360f != null) {
                    this.f21363a.f21360f.a();
                }
                this.f21363a.d();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a();
    }

    public b(c.a.e.a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21361g = new C0998b(this);
        this.f21356b = new i(fVar.getPageActivity());
        f fVar2 = new f(fVar.getString(R.string.delete), this.f21356b);
        this.f21358d = fVar2;
        fVar2.l(this.f21361g);
        ArrayList arrayList = new ArrayList();
        this.f21357c = arrayList;
        arrayList.add(this.f21358d);
        this.f21356b.m(new a(this));
        this.f21356b.k(this.f21357c);
        this.f21355a = new PopupDialog(fVar, this.f21356b);
        e();
        f();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21359e == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG);
        httpMessage.addParam("type", this.f21359e.f21351a);
        httpMessage.addParam("thread_id", this.f21359e.f21352b);
        httpMessage.addParam("post_id", this.f21359e.f21353c);
        httpMessage.addParam("ori_ugc_nid", this.f21359e.f21354d);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void d() {
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (popupDialog = this.f21355a) != null && popupDialog.isShowing()) {
            this.f21355a.dismiss();
        }
    }

    public void e() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (iVar = this.f21356b) == null) {
            return;
        }
        iVar.j();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG, TbConfig.SERVER_ADDRESS + TbConfig.URL_DELETE_REPLY_AT_MSG);
            tbHttpMessageTask.setResponsedClass(DelReplyAtMsgResMsg.class);
            tbHttpMessageTask.setIsNeedTbs(true);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }

    public void g(c.a.q0.k1.b.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f21359e = aVar;
        }
    }

    public void h(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f21360f = cVar;
        }
    }

    public void i() {
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (popupDialog = this.f21355a) == null) {
            return;
        }
        popupDialog.show();
    }
}
