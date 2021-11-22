package b.a.q0.t.e;

import b.a.q0.t.c.o;
import b.a.q0.t.c.p;
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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public p f14720a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC0736b f14721b;

    /* renamed from: c  reason: collision with root package name */
    public int f14722c;

    /* renamed from: d  reason: collision with root package name */
    public int f14723d;

    /* renamed from: e  reason: collision with root package name */
    public o f14724e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f14725f;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f14726a;

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
            this.f14726a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof ChannelConfigResponseMessage)) {
                ChannelConfigResponseMessage channelConfigResponseMessage = (ChannelConfigResponseMessage) httpResponsedMessage;
                this.f14726a.f14720a = channelConfigResponseMessage.getData();
                if (this.f14726a.f14721b != null) {
                    this.f14726a.f14721b.a(channelConfigResponseMessage.isSuccess(), channelConfigResponseMessage.getData());
                }
                if (channelConfigResponseMessage.isSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921493, null));
                }
            }
        }
    }

    /* renamed from: b.a.q0.t.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0736b {
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
        this.f14725f = new a(this, CmdConfigHttp.CMD_GET_CHANNEL_CONFIG);
        MessageManager.getInstance().registerListener(this.f14725f);
        this.f14722c = b.a.q0.s.e0.b.j().k("key_common_category_version", 0);
        this.f14723d = b.a.q0.s.e0.b.j().k("key_special_category_version", 0);
    }

    public o c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            o oVar = this.f14724e;
            if (oVar != null) {
                return oVar;
            }
            if (this.f14720a == null) {
                return null;
            }
            o oVar2 = new o();
            p pVar = this.f14720a;
            if (pVar != null && pVar.b() != null && this.f14723d < this.f14720a.b().e()) {
                oVar2.g(this.f14720a.b().a());
                oVar2.h(this.f14720a.b().b());
                oVar2.i(this.f14720a.b().c());
                oVar2.j(this.f14720a.b().d());
                oVar2.f(o.f14599h);
            } else {
                p pVar2 = this.f14720a;
                if (pVar2 != null && pVar2.a() > 0 && this.f14722c < this.f14720a.a()) {
                    oVar2.f(o.f14598g);
                } else {
                    oVar2.f(o.f14597f);
                }
            }
            this.f14724e = oVar2;
            return oVar2;
        }
        return (o) invokeV.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (i2 == o.f14599h) {
                if (this.f14720a.b() != null) {
                    b.a.q0.s.e0.b.j().v("key_special_category_version", this.f14720a.b().e());
                }
            } else if (i2 == o.f14598g) {
                b.a.q0.s.e0.b.j().v("key_common_category_version", this.f14720a.a());
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
