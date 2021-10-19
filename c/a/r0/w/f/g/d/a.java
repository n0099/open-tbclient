package c.a.r0.w.f.g.d;

import c.a.r0.w.f.g.c.h;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.alasquare.special_forum.data.SpecialLiveResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f26006a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f26007b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26008c;

    /* renamed from: d  reason: collision with root package name */
    public HttpMessageListener f26009d;

    /* renamed from: c.a.r0.w.f.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1212a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f26010a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1212a(a aVar, int i2) {
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
            this.f26010a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.f26010a.f26008c = false;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021093 && (httpResponsedMessage instanceof SpecialLiveResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == this.f26010a.f26007b) {
                    SpecialLiveResponseMessage specialLiveResponseMessage = (SpecialLiveResponseMessage) httpResponsedMessage;
                    if (!specialLiveResponseMessage.isSuccess() || specialLiveResponseMessage.getData() == null) {
                        if (this.f26010a.f26006a != null) {
                            this.f26010a.f26006a.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        }
                    } else if (this.f26010a.f26006a != null) {
                        this.f26010a.f26006a.b(specialLiveResponseMessage.getData());
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i2, String str);

        void b(h hVar);
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
        this.f26009d = new C1212a(this, AlaCmdConfigHttp.CMD_ALA_SPECIAL_LIVE_DATA);
        this.f26006a = bVar;
        this.f26007b = BdUniqueId.gen();
        h();
        g();
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f26008c : invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f26008c) {
            return;
        }
        this.f26008c = true;
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SPECIAL_LIVE_DATA);
        httpMessage.setTag(this.f26007b);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.CMD_ALA_SPECIAL_LIVE_DATA);
            MessageManager.getInstance().unRegisterListener(this.f26009d);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().registerListener(this.f26009d);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_SPECIAL_LIVE_DATA, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_SPECIAL_LIVE_DATA);
            tbHttpMessageTask.setResponsedClass(SpecialLiveResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }
}
