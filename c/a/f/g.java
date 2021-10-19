package c.a.f;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.afd.AfdSyncRequestMessage;
import com.baidu.afd.AfdSyncResponseMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class g implements j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f3286a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3287b;

    /* renamed from: c  reason: collision with root package name */
    public final HttpMessageListener f3288c;

    /* loaded from: classes.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f3289a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(g gVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Integer.valueOf(i2)};
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
            this.f3289a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                this.f3289a.f3286a.t(eVar);
                if (!eVar.f3282a || eVar.f3285d == null) {
                    return;
                }
                c.a.r0.z2.l0.e.b().d(c.a.r0.z2.l0.g.o(this.f3289a.f3286a, eVar.f3285d));
            }
        }
    }

    public g(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this, CmdConfigHttp.CMD_AFD_REQUEST_ASYNC);
        this.f3288c = aVar;
        this.f3286a = dVar;
        aVar.setSelfListener(true);
        this.f3288c.setTag(dVar.p());
        MessageManager.getInstance().registerListener(this.f3288c);
    }

    @Override // c.a.f.j
    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f3287b) {
            return;
        }
        this.f3287b = true;
        AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.f3286a.f3278g);
        afdSyncRequestMessage.setTag(this.f3286a.p());
        MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
    }
}
