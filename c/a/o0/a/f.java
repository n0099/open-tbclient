package c.a.o0.a;

import android.util.Base64;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.GetTokenHttpResponsedMessage;
import com.baidu.tbadk.BdToken.GetTokenRequestMessage;
import com.baidu.tbadk.BdToken.GetTokenSocketResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f12327a;

    /* renamed from: b  reason: collision with root package name */
    public b f12328b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.e.c.g.a f12329c;

    /* loaded from: classes3.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f12330a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f fVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f12330a = fVar;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f12330a.f12327a = false;
                if (responsedMessage == null || responsedMessage.getError() != 0) {
                    this.f12330a.d(false, null);
                } else if (responsedMessage instanceof GetTokenSocketResponsedMessage) {
                    this.f12330a.d(true, ((GetTokenSocketResponsedMessage) responsedMessage).getData());
                } else if (responsedMessage instanceof GetTokenHttpResponsedMessage) {
                    this.f12330a.d(true, ((GetTokenHttpResponsedMessage) responsedMessage).getData());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z, a0 a0Var);
    }

    public f() {
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
        this.f12327a = false;
        this.f12329c = new a(this, CmdConfigHttp.CMD_GET_TOKEN, 309608);
        f();
        e();
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f12327a) {
            return;
        }
        this.f12327a = true;
        GetTokenRequestMessage getTokenRequestMessage = new GetTokenRequestMessage();
        getTokenRequestMessage.setToken(Base64.encodeToString(str.getBytes(), 2));
        getTokenRequestMessage.setBaiduCuid(TbadkCoreApplication.getInst().getCuidGalaxy2());
        MessageManager.getInstance().sendMessage(getTokenRequestMessage);
    }

    public final void d(boolean z, a0 a0Var) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, a0Var) == null) || (bVar = this.f12328b) == null) {
            return;
        }
        bVar.a(z, a0Var);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().registerListener(this.f12329c);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.p0.i3.d0.a.h(309608, GetTokenSocketResponsedMessage.class, false, false);
            c.a.p0.i3.d0.a.c(309608, CmdConfigHttp.CMD_GET_TOKEN, TbConfig.URL_GET_TOKEN, GetTokenHttpResponsedMessage.class, false, false, false, false);
        }
    }

    public void g(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f12328b = bVar;
        }
    }
}
