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
    public p f13947a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC0700b f13948b;

    /* renamed from: c  reason: collision with root package name */
    public int f13949c;

    /* renamed from: d  reason: collision with root package name */
    public int f13950d;

    /* renamed from: e  reason: collision with root package name */
    public o f13951e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f13952f;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f13953a;

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
            this.f13953a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof ChannelConfigResponseMessage)) {
                ChannelConfigResponseMessage channelConfigResponseMessage = (ChannelConfigResponseMessage) httpResponsedMessage;
                this.f13953a.f13947a = channelConfigResponseMessage.getData();
                if (this.f13953a.f13948b != null) {
                    this.f13953a.f13948b.a(channelConfigResponseMessage.isSuccess(), channelConfigResponseMessage.getData());
                }
                if (channelConfigResponseMessage.isSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921493, null));
                }
            }
        }
    }

    /* renamed from: b.a.q0.t.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0700b {
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
        this.f13952f = new a(this, CmdConfigHttp.CMD_GET_CHANNEL_CONFIG);
        MessageManager.getInstance().registerListener(this.f13952f);
        this.f13949c = b.a.q0.s.e0.b.j().k("key_common_category_version", 0);
        this.f13950d = b.a.q0.s.e0.b.j().k("key_special_category_version", 0);
    }

    public o c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            o oVar = this.f13951e;
            if (oVar != null) {
                return oVar;
            }
            if (this.f13947a == null) {
                return null;
            }
            o oVar2 = new o();
            p pVar = this.f13947a;
            if (pVar != null && pVar.b() != null && this.f13950d < this.f13947a.b().e()) {
                oVar2.g(this.f13947a.b().a());
                oVar2.h(this.f13947a.b().b());
                oVar2.i(this.f13947a.b().c());
                oVar2.j(this.f13947a.b().d());
                oVar2.f(o.f13831h);
            } else {
                p pVar2 = this.f13947a;
                if (pVar2 != null && pVar2.a() > 0 && this.f13949c < this.f13947a.a()) {
                    oVar2.f(o.f13830g);
                } else {
                    oVar2.f(o.f13829f);
                }
            }
            this.f13951e = oVar2;
            return oVar2;
        }
        return (o) invokeV.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (i2 == o.f13831h) {
                if (this.f13947a.b() != null) {
                    b.a.q0.s.e0.b.j().v("key_special_category_version", this.f13947a.b().e());
                }
            } else if (i2 == o.f13830g) {
                b.a.q0.s.e0.b.j().v("key_common_category_version", this.f13947a.a());
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
