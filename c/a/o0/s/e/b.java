package c.a.o0.s.e;

import c.a.o0.s.c.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.data.ChannelIconConfigFinalData;
import com.baidu.tbadk.coreExtra.message.ChannelConfigResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public n a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC0852b f11325b;

    /* renamed from: c  reason: collision with root package name */
    public int f11326c;

    /* renamed from: d  reason: collision with root package name */
    public int f11327d;

    /* renamed from: e  reason: collision with root package name */
    public ChannelIconConfigFinalData f11328e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f11329f;

    /* loaded from: classes2.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                if (this.a.f11325b != null) {
                    this.a.f11325b.a(channelConfigResponseMessage.isSuccess(), channelConfigResponseMessage.getData());
                }
                if (channelConfigResponseMessage.isSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921493, null));
                }
            }
        }
    }

    /* renamed from: c.a.o0.s.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0852b {
        void a(boolean z, n nVar);
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11329f = new a(this, CmdConfigHttp.CMD_GET_CHANNEL_CONFIG);
        MessageManager.getInstance().registerListener(this.f11329f);
        this.f11326c = c.a.o0.r.j0.b.k().l("key_common_category_version", 0);
        this.f11327d = c.a.o0.r.j0.b.k().l("key_special_category_version", 0);
    }

    public ChannelIconConfigFinalData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ChannelIconConfigFinalData channelIconConfigFinalData = this.f11328e;
            if (channelIconConfigFinalData != null) {
                return channelIconConfigFinalData;
            }
            if (this.a == null) {
                return null;
            }
            ChannelIconConfigFinalData channelIconConfigFinalData2 = new ChannelIconConfigFinalData();
            n nVar = this.a;
            if (nVar != null && nVar.b() != null && this.f11327d < this.a.b().e()) {
                channelIconConfigFinalData2.setIcon(this.a.b().a());
                channelIconConfigFinalData2.setPopText(this.a.b().b());
                channelIconConfigFinalData2.setTabCode(this.a.b().c());
                channelIconConfigFinalData2.setTid(this.a.b().d());
                channelIconConfigFinalData2.setChannelConfigDataType(ChannelIconConfigFinalData.FRAG_TIP_SPECIAL);
            } else {
                n nVar2 = this.a;
                if (nVar2 != null && nVar2.a() > 0 && this.f11326c < this.a.a()) {
                    channelIconConfigFinalData2.setChannelConfigDataType(ChannelIconConfigFinalData.FRAG_TIP_COMMON);
                } else {
                    channelIconConfigFinalData2.setChannelConfigDataType(ChannelIconConfigFinalData.FRAG_TIP_NONE);
                }
            }
            this.f11328e = channelIconConfigFinalData2;
            return channelIconConfigFinalData2;
        }
        return (ChannelIconConfigFinalData) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG));
        }
    }
}
