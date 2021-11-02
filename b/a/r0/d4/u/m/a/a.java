package b.a.r0.d4.u.m.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.EvaluateRelevanceItemUpdatedMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.relevance.RelevanceItemSearchData;
import com.baidu.tieba.write.write.relevance.RelevanceItemSearchResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f16164a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f16165b;

    /* renamed from: c  reason: collision with root package name */
    public final String f16166c;

    /* renamed from: d  reason: collision with root package name */
    public b f16167d;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f16168e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f16169f;

    /* renamed from: b.a.r0.d4.u.m.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0820a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f16170a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0820a(a aVar, int i2) {
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
            this.f16170a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null || this.f16170a.f16167d == null) {
                return;
            }
            if (httpResponsedMessage.getOrginalMessage() == null || httpResponsedMessage.getOrginalMessage().getTag() == this.f16170a.f16165b) {
                RelevanceItemSearchData responseData = httpResponsedMessage instanceof RelevanceItemSearchResponse ? ((RelevanceItemSearchResponse) httpResponsedMessage).getResponseData() : null;
                if (responseData != null && responseData.getData() != null) {
                    if (!ListUtils.equalList(this.f16170a.f16168e, responseData.getData().getTab_option())) {
                        this.f16170a.f16168e = responseData.getData().getTab_option();
                        MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemUpdatedMessage(this.f16170a.f16168e));
                    }
                    if (httpResponsedMessage.getError() != 0) {
                        this.f16170a.f16167d.onError(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        this.f16170a.l();
                        return;
                    } else if (ListUtils.isEmpty(responseData.getData().getItem_list())) {
                        if (this.f16170a.f16164a == 1) {
                            this.f16170a.f16167d.a();
                            return;
                        } else {
                            this.f16170a.f16167d.d();
                            return;
                        }
                    } else if (responseData != null) {
                        this.f16170a.f16167d.c(responseData);
                        if (this.f16170a.f16164a == 1 && responseData.getData().getItem_list().size() < 20) {
                            this.f16170a.f16167d.d();
                        }
                        a.f(this.f16170a);
                        return;
                    } else {
                        return;
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemUpdatedMessage(null));
                this.f16170a.f16167d.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                this.f16170a.l();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a();

        void c(RelevanceItemSearchData relevanceItemSearchData);

        void d();

        void onError(int i2, String str);
    }

    public a(BdUniqueId bdUniqueId, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16164a = 1;
        C0820a c0820a = new C0820a(this, CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH);
        this.f16169f = c0820a;
        this.f16165b = bdUniqueId;
        this.f16166c = str;
        c0820a.setTag(bdUniqueId);
        k();
        MessageManager.getInstance().registerListener(this.f16169f);
    }

    public static /* synthetic */ int f(a aVar) {
        int i2 = aVar.f16164a;
        aVar.f16164a = i2 + 1;
        return i2;
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            l();
            i(str);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH);
            httpMessage.addParam("tab_name", this.f16166c);
            httpMessage.addParam("pn", this.f16164a);
            httpMessage.addParam("rn", 20);
            httpMessage.setTag(this.f16165b);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH);
            httpMessage.addParam("tab_name", this.f16166c);
            httpMessage.addParam("keyword", str);
            httpMessage.addParam("pn", this.f16164a);
            httpMessage.addParam("rn", 20);
            httpMessage.setTag(this.f16165b);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().removeMessage(this.f16165b);
            MessageManager.getInstance().unRegisterListener(this.f16165b);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH, TbConfig.SERVER_ADDRESS + TbConfig.RELEVANCE_ITEM_SEARCH_URL);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(RelevanceItemSearchResponse.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f16164a = 1;
        }
    }

    public void m(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f16167d = bVar;
        }
    }
}
