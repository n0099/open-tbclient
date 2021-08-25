package c.a.q0.m2;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.personExtra.SmartAppBrowseHistoryHttpResponsedMessage;
import com.baidu.tieba.personExtra.SmartAppBrowseHistoryRequestMessage;
import com.baidu.tieba.personExtra.SmartAppBrowseHistorySocketResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f22421a;

    /* renamed from: b  reason: collision with root package name */
    public b f22422b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.e.c.g.a f22423c;

    /* loaded from: classes3.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f22424a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(h hVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f22424a = hVar;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f22424a.f22421a = false;
                if (responsedMessage == null || responsedMessage.getError() != 0) {
                    this.f22424a.c(false, null);
                } else if (responsedMessage instanceof SmartAppBrowseHistorySocketResponsedMessage) {
                    this.f22424a.c(true, ((SmartAppBrowseHistorySocketResponsedMessage) responsedMessage).getData());
                } else if (responsedMessage instanceof SmartAppBrowseHistoryHttpResponsedMessage) {
                    this.f22424a.c(true, ((SmartAppBrowseHistoryHttpResponsedMessage) responsedMessage).getData());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z, c.a.q0.m2.a aVar);
    }

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22421a = false;
        this.f22423c = new a(this, CmdConfigHttp.CMD_HISTORY_SWAN, 309638);
        e();
        d();
    }

    public final void c(boolean z, c.a.q0.m2.a aVar) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048576, this, z, aVar) == null) || (bVar = this.f22422b) == null) {
            return;
        }
        bVar.a(z, aVar);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().registerListener(this.f22423c);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.q0.i3.d0.a.f(309638, SmartAppBrowseHistorySocketResponsedMessage.class, false);
            c.a.q0.i3.d0.a.c(309638, CmdConfigHttp.CMD_HISTORY_SWAN, TbConfig.URL_HISTORY_SWAN, SmartAppBrowseHistoryHttpResponsedMessage.class, false, false, true, false);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f22421a) {
            return;
        }
        this.f22421a = true;
        MessageManager.getInstance().sendMessage(new SmartAppBrowseHistoryRequestMessage());
    }

    public void g(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f22422b = bVar;
        }
    }
}
