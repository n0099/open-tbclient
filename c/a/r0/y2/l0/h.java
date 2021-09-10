package c.a.r0.y2.l0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.recapp.report.AdUploadHttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class h implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HttpMessageListener f29601a;

    /* renamed from: b  reason: collision with root package name */
    public TbHttpMessageTask f29602b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<c> f29603c;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f29604a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(h hVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i2)};
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
            this.f29604a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003062) {
                if (httpResponsedMessage.getError() == 0) {
                    return;
                }
                Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                if (orginalMessage instanceof AdUploadHttpRequest) {
                    this.f29604a.f(((AdUploadHttpRequest) orginalMessage).getDataArray());
                }
            }
        }
    }

    public h() {
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
        this.f29601a = new a(this, CmdConfigHttp.CMD_AD_UPLOAD);
        this.f29603c = new ArrayList<>();
        g();
        MessageManager.getInstance().registerListener(this.f29601a);
    }

    @Override // c.a.r0.y2.l0.f
    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null) {
            return;
        }
        c.a.q0.t.c.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (!(adAdSense == null || adAdSense.d())) {
            this.f29602b.setUrl("http://als.baidu.com/clog/clog");
        }
        e(cVar);
        h();
    }

    @Override // c.a.r0.y2.l0.f
    public void b(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || cVar == null) {
            return;
        }
        e(cVar);
    }

    @Override // c.a.r0.y2.l0.f
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            h();
        }
    }

    public final void e(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) || cVar == null) {
            return;
        }
        if (ListUtils.getCount(this.f29603c) >= 20) {
            this.f29603c.remove(0);
        }
        this.f29603c.add(cVar);
    }

    public final void f(List<c> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || ListUtils.getCount(list) <= 0) {
            return;
        }
        for (c cVar : list) {
            if (cVar != null) {
                e(cVar);
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_UPLOAD, "https://als.baidu.com/clog/clog");
            this.f29602b = tbHttpMessageTask;
            tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
            this.f29602b.setIsNeedAddCommenParam(true);
            this.f29602b.setResponsedClass(JsonHttpResponsedMessage.class);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || ListUtils.getCount(this.f29603c) <= 0) {
            return;
        }
        MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.f29603c), this.f29602b);
        this.f29603c.clear();
    }
}
