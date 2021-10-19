package c.a.r0.d4.u.m.a;

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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f17185a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f17186b;

    /* renamed from: c  reason: collision with root package name */
    public final String f17187c;

    /* renamed from: d  reason: collision with root package name */
    public b f17188d;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f17189e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f17190f;

    /* renamed from: c.a.r0.d4.u.m.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0825a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f17191a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0825a(a aVar, int i2) {
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
            this.f17191a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null || this.f17191a.f17188d == null) {
                return;
            }
            if (httpResponsedMessage.getOrginalMessage() == null || httpResponsedMessage.getOrginalMessage().getTag() == this.f17191a.f17186b) {
                RelevanceItemSearchData responseData = httpResponsedMessage instanceof RelevanceItemSearchResponse ? ((RelevanceItemSearchResponse) httpResponsedMessage).getResponseData() : null;
                if (responseData != null && responseData.getData() != null) {
                    if (!ListUtils.equalList(this.f17191a.f17189e, responseData.getData().getTab_option())) {
                        this.f17191a.f17189e = responseData.getData().getTab_option();
                        MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemUpdatedMessage(this.f17191a.f17189e));
                    }
                    if (httpResponsedMessage.getError() != 0) {
                        this.f17191a.f17188d.onError(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        this.f17191a.l();
                        return;
                    } else if (ListUtils.isEmpty(responseData.getData().getItem_list())) {
                        if (this.f17191a.f17185a == 1) {
                            this.f17191a.f17188d.a();
                            return;
                        } else {
                            this.f17191a.f17188d.d();
                            return;
                        }
                    } else if (responseData != null) {
                        this.f17191a.f17188d.c(responseData);
                        if (this.f17191a.f17185a == 1 && responseData.getData().getItem_list().size() < 20) {
                            this.f17191a.f17188d.d();
                        }
                        a.f(this.f17191a);
                        return;
                    } else {
                        return;
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemUpdatedMessage(null));
                this.f17191a.f17188d.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                this.f17191a.l();
            }
        }
    }

    /* loaded from: classes3.dex */
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
        this.f17185a = 1;
        C0825a c0825a = new C0825a(this, CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH);
        this.f17190f = c0825a;
        this.f17186b = bdUniqueId;
        this.f17187c = str;
        c0825a.setTag(bdUniqueId);
        k();
        MessageManager.getInstance().registerListener(this.f17190f);
    }

    public static /* synthetic */ int f(a aVar) {
        int i2 = aVar.f17185a;
        aVar.f17185a = i2 + 1;
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
            httpMessage.addParam("tab_name", this.f17187c);
            httpMessage.addParam("pn", this.f17185a);
            httpMessage.addParam("rn", 20);
            httpMessage.setTag(this.f17186b);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH);
            httpMessage.addParam("tab_name", this.f17187c);
            httpMessage.addParam("keyword", str);
            httpMessage.addParam("pn", this.f17185a);
            httpMessage.addParam("rn", 20);
            httpMessage.setTag(this.f17186b);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().removeMessage(this.f17186b);
            MessageManager.getInstance().unRegisterListener(this.f17186b);
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
            this.f17185a = 1;
        }
    }

    public void m(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f17188d = bVar;
        }
    }
}
