package c.a.o0.t.e;

import c.a.o0.t.c.n;
import c.a.o0.t.c.o;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.message.ChannelConfigResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public o f14523a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC0693b f14524b;

    /* renamed from: c  reason: collision with root package name */
    public int f14525c;

    /* renamed from: d  reason: collision with root package name */
    public int f14526d;

    /* renamed from: e  reason: collision with root package name */
    public n f14527e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f14528f;

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f14529a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14529a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof ChannelConfigResponseMessage)) {
                ChannelConfigResponseMessage channelConfigResponseMessage = (ChannelConfigResponseMessage) httpResponsedMessage;
                this.f14529a.f14523a = channelConfigResponseMessage.getData();
                if (this.f14529a.f14524b != null) {
                    this.f14529a.f14524b.a(channelConfigResponseMessage.isSuccess(), channelConfigResponseMessage.getData());
                }
                if (channelConfigResponseMessage.isSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921493, null));
                }
            }
        }
    }

    /* renamed from: c.a.o0.t.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0693b {
        void a(boolean z, o oVar);
    }

    public b() {
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
        this.f14528f = new a(this, CmdConfigHttp.CMD_GET_CHANNEL_CONFIG);
        MessageManager.getInstance().registerListener(this.f14528f);
        this.f14525c = c.a.o0.s.d0.b.j().k("key_common_category_version", 0);
        this.f14526d = c.a.o0.s.d0.b.j().k("key_special_category_version", 0);
    }

    public n c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            n nVar = this.f14527e;
            if (nVar != null) {
                return nVar;
            }
            if (this.f14523a == null) {
                return null;
            }
            n nVar2 = new n();
            o oVar = this.f14523a;
            if (oVar != null && oVar.b() != null && this.f14526d < this.f14523a.b().e()) {
                nVar2.g(this.f14523a.b().a());
                nVar2.h(this.f14523a.b().b());
                nVar2.i(this.f14523a.b().c());
                nVar2.j(this.f14523a.b().d());
                nVar2.f(n.f14405h);
            } else {
                o oVar2 = this.f14523a;
                if (oVar2 != null && oVar2.a() > 0 && this.f14525c < this.f14523a.a()) {
                    nVar2.f(n.f14404g);
                } else {
                    nVar2.f(n.f14403f);
                }
            }
            this.f14527e = nVar2;
            return nVar2;
        }
        return (n) invokeV.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (i2 == n.f14405h) {
                if (this.f14523a.b() != null) {
                    c.a.o0.s.d0.b.j().v("key_special_category_version", this.f14523a.b().e());
                }
            } else if (i2 == n.f14404g) {
                c.a.o0.s.d0.b.j().v("key_common_category_version", this.f14523a.a());
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG));
        }
    }
}
