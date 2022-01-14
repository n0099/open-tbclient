package c.a.s0.t.e;

import c.a.s0.t.c.o;
import c.a.s0.t.c.p;
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
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public p a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC0892b f13977b;

    /* renamed from: c  reason: collision with root package name */
    public int f13978c;

    /* renamed from: d  reason: collision with root package name */
    public int f13979d;

    /* renamed from: e  reason: collision with root package name */
    public o f13980e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f13981f;

    /* loaded from: classes6.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

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
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof ChannelConfigResponseMessage)) {
                ChannelConfigResponseMessage channelConfigResponseMessage = (ChannelConfigResponseMessage) httpResponsedMessage;
                this.a.a = channelConfigResponseMessage.getData();
                if (this.a.f13977b != null) {
                    this.a.f13977b.a(channelConfigResponseMessage.isSuccess(), channelConfigResponseMessage.getData());
                }
                if (channelConfigResponseMessage.isSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921493, null));
                }
            }
        }
    }

    /* renamed from: c.a.s0.t.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0892b {
        void a(boolean z, p pVar);
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
        this.f13981f = new a(this, CmdConfigHttp.CMD_GET_CHANNEL_CONFIG);
        MessageManager.getInstance().registerListener(this.f13981f);
        this.f13978c = c.a.s0.s.h0.b.k().l("key_common_category_version", 0);
        this.f13979d = c.a.s0.s.h0.b.k().l("key_special_category_version", 0);
    }

    public o c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            o oVar = this.f13980e;
            if (oVar != null) {
                return oVar;
            }
            if (this.a == null) {
                return null;
            }
            o oVar2 = new o();
            p pVar = this.a;
            if (pVar != null && pVar.b() != null && this.f13979d < this.a.b().e()) {
                oVar2.g(this.a.b().a());
                oVar2.h(this.a.b().b());
                oVar2.i(this.a.b().c());
                oVar2.j(this.a.b().d());
                oVar2.f(o.f13867h);
            } else {
                p pVar2 = this.a;
                if (pVar2 != null && pVar2.a() > 0 && this.f13978c < this.a.a()) {
                    oVar2.f(o.f13866g);
                } else {
                    oVar2.f(o.f13865f);
                }
            }
            this.f13980e = oVar2;
            return oVar2;
        }
        return (o) invokeV.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (i2 == o.f13867h) {
                if (this.a.b() != null) {
                    c.a.s0.s.h0.b.k().w("key_special_category_version", this.a.b().e());
                }
            } else if (i2 == o.f13866g) {
                c.a.s0.s.h0.b.k().w("key_common_category_version", this.a.a());
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
