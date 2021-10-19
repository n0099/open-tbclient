package c.a.r0.w.l.g;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.personcenter.privilege.AlaTDouBuyPrivilegeResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f26360a;

    /* renamed from: b  reason: collision with root package name */
    public b f26361b;

    /* renamed from: c  reason: collision with root package name */
    public HttpMessageListener f26362c;

    /* renamed from: c.a.r0.w.l.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1228a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f26363a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1228a(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
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
            this.f26363a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof AlaTDouBuyPrivilegeResponsedMessage)) {
                AlaTDouBuyPrivilegeResponsedMessage alaTDouBuyPrivilegeResponsedMessage = (AlaTDouBuyPrivilegeResponsedMessage) httpResponsedMessage;
                boolean z = alaTDouBuyPrivilegeResponsedMessage.getError() == 0;
                String errorString = alaTDouBuyPrivilegeResponsedMessage.getErrorString();
                if (this.f26363a.f26361b != null) {
                    this.f26363a.f26361b.a(z, errorString);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(boolean z, String str);
    }

    public a(TbPageContext tbPageContext, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        C1228a c1228a = new C1228a(this, AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP);
        this.f26362c = c1228a;
        this.f26360a = tbPageContext;
        this.f26361b = bVar;
        tbPageContext.registerListener(c1228a);
    }

    public void b(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP);
            httpMessage.addParam("props_id", i2);
            httpMessage.addParam("effect_id", str);
            httpMessage.addParam("buy_action", 0);
            this.f26360a.sendMessage(httpMessage);
        }
    }

    public void c(int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP);
            httpMessage.addParam("props_id", i3);
            httpMessage.addParam("mark_id", i2);
            httpMessage.addParam("buy_action", z ? 1 : 0);
            this.f26360a.sendMessage(httpMessage);
        }
    }
}
