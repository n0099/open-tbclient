package c.a.q0.s.e;

import c.a.q0.s.c.n;
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
    public InterfaceC0885b f13786b;

    /* renamed from: c  reason: collision with root package name */
    public int f13787c;

    /* renamed from: d  reason: collision with root package name */
    public int f13788d;

    /* renamed from: e  reason: collision with root package name */
    public ChannelIconConfigFinalData f13789e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f13790f;

    /* loaded from: classes2.dex */
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
                if (this.a.f13786b != null) {
                    this.a.f13786b.a(channelConfigResponseMessage.isSuccess(), channelConfigResponseMessage.getData());
                }
                if (channelConfigResponseMessage.isSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921493, null));
                }
            }
        }
    }

    /* renamed from: c.a.q0.s.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0885b {
        void a(boolean z, n nVar);
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
        this.f13790f = new a(this, CmdConfigHttp.CMD_GET_CHANNEL_CONFIG);
        MessageManager.getInstance().registerListener(this.f13790f);
        this.f13787c = c.a.q0.r.j0.b.k().l("key_common_category_version", 0);
        this.f13788d = c.a.q0.r.j0.b.k().l("key_special_category_version", 0);
    }

    public ChannelIconConfigFinalData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ChannelIconConfigFinalData channelIconConfigFinalData = this.f13789e;
            if (channelIconConfigFinalData != null) {
                return channelIconConfigFinalData;
            }
            if (this.a == null) {
                return null;
            }
            ChannelIconConfigFinalData channelIconConfigFinalData2 = new ChannelIconConfigFinalData();
            n nVar = this.a;
            if (nVar != null && nVar.b() != null && this.f13788d < this.a.b().e()) {
                channelIconConfigFinalData2.setIcon(this.a.b().a());
                channelIconConfigFinalData2.setPopText(this.a.b().b());
                channelIconConfigFinalData2.setTabCode(this.a.b().c());
                channelIconConfigFinalData2.setTid(this.a.b().d());
                channelIconConfigFinalData2.setChannelConfigDataType(ChannelIconConfigFinalData.FRAG_TIP_SPECIAL);
            } else {
                n nVar2 = this.a;
                if (nVar2 != null && nVar2.a() > 0 && this.f13787c < this.a.a()) {
                    channelIconConfigFinalData2.setChannelConfigDataType(ChannelIconConfigFinalData.FRAG_TIP_COMMON);
                } else {
                    channelIconConfigFinalData2.setChannelConfigDataType(ChannelIconConfigFinalData.FRAG_TIP_NONE);
                }
            }
            this.f13789e = channelIconConfigFinalData2;
            return channelIconConfigFinalData2;
        }
        return (ChannelIconConfigFinalData) invokeV.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (i2 == ChannelIconConfigFinalData.FRAG_TIP_SPECIAL) {
                if (this.a.b() != null) {
                    c.a.q0.r.j0.b.k().w("key_special_category_version", this.a.b().e());
                }
            } else if (i2 == ChannelIconConfigFinalData.FRAG_TIP_COMMON) {
                c.a.q0.r.j0.b.k().w("key_common_category_version", this.a.a());
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
