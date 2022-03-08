package c.a.r0.m3;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.searchrecforum.message.SearchRecForumRequestMessage;
import com.baidu.tieba.searchrecforum.message.SearchRecForumResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f19338b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f19339c;

    /* renamed from: d  reason: collision with root package name */
    public HttpResponsedMessage f19340d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC1210b f19341e;

    /* renamed from: f  reason: collision with root package name */
    public final HttpMessageListener f19342f;

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
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (this.a.f19339c) {
                    this.a.f19340d = httpResponsedMessage;
                } else {
                    this.a.f(httpResponsedMessage);
                }
            }
        }
    }

    /* renamed from: c.a.r0.m3.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC1210b {
        void a(c.a.r0.m3.e.a aVar);

        void onFail();
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
        this.a = BdUniqueId.gen();
        this.f19338b = false;
        this.f19339c = false;
        this.f19342f = new a(this, CmdConfigHttp.CMD_GET_SEARCH_BACK_INTEREST_FORUM);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_SEARCH_BACK_INTEREST_FORUM, TbConfig.SERVER_ADDRESS + "c/f/excellent/getRecomForum");
        tbHttpMessageTask.setResponsedClass(SearchRecForumResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.f19342f);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f19339c) {
            f(this.f19340d);
            this.f19339c = false;
            this.f19340d = null;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f19339c = true;
        }
    }

    public final void f(HttpResponsedMessage httpResponsedMessage) {
        InterfaceC1210b interfaceC1210b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, httpResponsedMessage) == null) {
            this.f19338b = false;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003526 && (httpResponsedMessage instanceof SearchRecForumResponsedMessage)) {
                if (httpResponsedMessage.getError() != 0 && (interfaceC1210b = this.f19341e) != null) {
                    interfaceC1210b.onFail();
                    return;
                }
                c.a.r0.m3.a.d().i(false);
                InterfaceC1210b interfaceC1210b2 = this.f19341e;
                if (interfaceC1210b2 != null) {
                    interfaceC1210b2.a(((SearchRecForumResponsedMessage) httpResponsedMessage).data);
                }
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && c.a.r0.m3.a.d().e()) {
            if (this.f19338b) {
                MessageManager.getInstance().removeHttpMessage(this.a);
            }
            this.f19338b = true;
            SearchRecForumRequestMessage searchRecForumRequestMessage = new SearchRecForumRequestMessage();
            searchRecForumRequestMessage.setParams(c.a.r0.m3.a.d().c());
            searchRecForumRequestMessage.setTag(this.a);
            MessageManager.getInstance().sendMessage(searchRecForumRequestMessage);
        }
    }

    public void h(InterfaceC1210b interfaceC1210b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, interfaceC1210b) == null) {
            this.f19341e = interfaceC1210b;
        }
    }
}
