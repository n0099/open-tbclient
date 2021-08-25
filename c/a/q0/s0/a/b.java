package c.a.q0.s0.a;

import c.a.p0.s.q.b1;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.forbidden.fans.GetForbiddenFansResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b1 f24257a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<c.a.q0.s0.a.a> f24258b;

    /* renamed from: c  reason: collision with root package name */
    public InterfaceC1119b f24259c;

    /* renamed from: d  reason: collision with root package name */
    public HttpMessageListener f24260d;

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f24261a;

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
            this.f24261a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof GetForbiddenFansResponse)) {
                GetForbiddenFansResponse getForbiddenFansResponse = (GetForbiddenFansResponse) httpResponsedMessage;
                this.f24261a.f24257a = getForbiddenFansResponse.getPageData();
                if (this.f24261a.f24258b == null) {
                    this.f24261a.f24258b = new ArrayList();
                }
                if (this.f24261a.f24257a != null) {
                    if (this.f24261a.f24257a.a() == 1) {
                        this.f24261a.f24258b.clear();
                    }
                    if (getForbiddenFansResponse.getFansList() != null) {
                        this.f24261a.f24258b.addAll(getForbiddenFansResponse.getFansList());
                    }
                }
                if (this.f24261a.f24259c != null) {
                    this.f24261a.f24259c.a(getForbiddenFansResponse.getError(), getForbiddenFansResponse.getErrorString(), this.f24261a.f24258b);
                }
            }
        }
    }

    /* renamed from: c.a.q0.s0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1119b {
        void a(int i2, String str, ArrayList<c.a.q0.s0.a.a> arrayList);
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
        this.f24260d = new a(this, CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS, TbConfig.SERVER_ADDRESS + TbConfig.GET_FORBIDDEN_FANS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GetForbiddenFansResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.f24260d);
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b1 b1Var = this.f24257a;
            return b1Var != null && b1Var.b() == 1;
        }
        return invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam("pn", 1);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b1 b1Var = this.f24257a;
            if (b1Var == null || b1Var.b() == 1) {
                b1 b1Var2 = this.f24257a;
                int a2 = b1Var2 != null ? 1 + b1Var2.a() : 1;
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
                httpMessage.addParam("rn", 20);
                httpMessage.addParam("pn", a2);
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f24260d);
        }
    }

    public void j(InterfaceC1119b interfaceC1119b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, interfaceC1119b) == null) {
            this.f24259c = interfaceC1119b;
        }
    }
}
