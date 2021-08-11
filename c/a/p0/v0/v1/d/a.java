package c.a.p0.v0.v1.d;

import c.a.e.k.e.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity;
import com.baidu.tieba.frs.gamesubpb.model.FrsAddSubCommentResponseMessage;
import com.baidu.tieba.frs.gamesubpb.model.FrsDeleteSubCommentResponseMessage;
import com.baidu.tieba.frs.gamesubpb.model.FrsSelectSubCommentReponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsGameSubPbActivity f26917a;

    /* renamed from: b  reason: collision with root package name */
    public d f26918b;

    /* renamed from: c  reason: collision with root package name */
    public List<n> f26919c;

    /* renamed from: d  reason: collision with root package name */
    public String f26920d;

    /* renamed from: e  reason: collision with root package name */
    public String f26921e;

    /* renamed from: f  reason: collision with root package name */
    public int f26922f;

    /* renamed from: g  reason: collision with root package name */
    public int f26923g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f26924h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f26925i;

    /* renamed from: j  reason: collision with root package name */
    public HttpMessageListener f26926j;
    public HttpMessageListener k;
    public HttpMessageListener l;

    /* renamed from: c.a.p0.v0.v1.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1267a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f26927a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1267a(a aVar, int i2) {
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
            this.f26927a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || this.f26927a.f26918b == null) {
                return;
            }
            if (httpResponsedMessage != null && !httpResponsedMessage.hasError() && (httpResponsedMessage instanceof FrsSelectSubCommentReponseMessage)) {
                FrsSelectSubCommentReponseMessage frsSelectSubCommentReponseMessage = (FrsSelectSubCommentReponseMessage) httpResponsedMessage;
                if (frsSelectSubCommentReponseMessage.getSelectSubCommentData() != null) {
                    if (1003379 == httpResponsedMessage.getCmd()) {
                        this.f26927a.f26924h = frsSelectSubCommentReponseMessage.getSelectSubCommentData().f26933b;
                        if (!this.f26927a.f26925i || 1 == frsSelectSubCommentReponseMessage.getSelectSubCommentData().f26932a) {
                            this.f26927a.f26919c.clear();
                        } else {
                            a.f(this.f26927a);
                        }
                        if (!ListUtils.isEmpty(frsSelectSubCommentReponseMessage.getSelectSubCommentData().f26935d)) {
                            this.f26927a.f26919c.addAll(frsSelectSubCommentReponseMessage.getSelectSubCommentData().f26935d);
                        }
                        this.f26927a.f26918b.a(true, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), this.f26927a.f26924h, this.f26927a.f26925i, frsSelectSubCommentReponseMessage.getSelectSubCommentData().f26934c, this.f26927a.f26919c);
                    }
                    this.f26927a.f26925i = false;
                }
            }
            this.f26927a.f26918b.a(false, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), false, this.f26927a.f26925i, null, null);
            this.f26927a.f26925i = false;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f26928a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, int i2) {
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
            this.f26928a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || this.f26928a.f26918b == null) {
                return;
            }
            if (httpResponsedMessage != null && !httpResponsedMessage.hasError() && (httpResponsedMessage instanceof FrsAddSubCommentResponseMessage)) {
                FrsAddSubCommentResponseMessage frsAddSubCommentResponseMessage = (FrsAddSubCommentResponseMessage) httpResponsedMessage;
                if (frsAddSubCommentResponseMessage.getSubCommentData() != null) {
                    if (1003380 == httpResponsedMessage.getCmd()) {
                        this.f26928a.f26918b.b(true, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), frsAddSubCommentResponseMessage.getSubCommentData());
                        return;
                    }
                    return;
                }
            }
            this.f26928a.f26918b.b(false, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), null);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f26929a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, int i2) {
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
            this.f26929a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || this.f26929a.f26918b == null) {
                return;
            }
            if (httpResponsedMessage != null && !httpResponsedMessage.hasError() && (httpResponsedMessage instanceof FrsDeleteSubCommentResponseMessage)) {
                FrsDeleteSubCommentResponseMessage frsDeleteSubCommentResponseMessage = (FrsDeleteSubCommentResponseMessage) httpResponsedMessage;
                if (frsDeleteSubCommentResponseMessage.getSubCommentData() != null) {
                    if (1003381 == httpResponsedMessage.getCmd()) {
                        this.f26929a.f26918b.c(true, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), frsDeleteSubCommentResponseMessage.getSubCommentData());
                        return;
                    }
                    return;
                }
            }
            this.f26929a.f26918b.c(false, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), null);
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(boolean z, int i2, String str, boolean z2, boolean z3, c.a.p0.v0.v1.d.b bVar, List<n> list);

        void b(boolean z, int i2, String str, c.a.p0.v0.v1.d.d dVar);

        void c(boolean z, int i2, String str, c.a.p0.v0.v1.d.d dVar);
    }

    public a(FrsGameSubPbActivity frsGameSubPbActivity, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsGameSubPbActivity, Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26920d = "0";
        this.f26923g = 1;
        this.f26926j = new C1267a(this, 0);
        this.k = new b(this, 0);
        this.l = new c(this, 0);
        this.f26917a = frsGameSubPbActivity;
        this.f26922f = i2;
        this.f26921e = str;
        this.f26919c = new ArrayList();
        k();
        i();
        j();
    }

    public static /* synthetic */ int f(a aVar) {
        int i2 = aVar.f26923g;
        aVar.f26923g = i2 + 1;
        return i2;
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (!z || this.f26924h) {
                this.f26925i = z;
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SELECT_SUB_COMMENT);
                httpMessage.addParam("pn", z ? 1 + this.f26923g : 1);
                httpMessage.addParam("ps", 20);
                httpMessage.addParam("forum_id", this.f26922f);
                httpMessage.addParam("main_tower_id", this.f26921e);
                httpMessage.addParam(ImageViewerConfig.LAST_ID, this.f26920d);
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_SUB_COMMENT, TbConfig.SERVER_ADDRESS + "game/client/addSubComment");
            tbHttpMessageTask.setResponsedClass(FrsAddSubCommentResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.f26917a.registerListener(CmdConfigHttp.CMD_ADD_SUB_COMMENT, this.k);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_DELETE_SUB_COMMENT, TbConfig.SERVER_ADDRESS + "game/client/deleteSubComment");
            tbHttpMessageTask.setResponsedClass(FrsDeleteSubCommentResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.f26917a.registerListener(CmdConfigHttp.CMD_DELETE_SUB_COMMENT, this.l);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SELECT_SUB_COMMENT, TbConfig.SERVER_ADDRESS + "game/client/selectSubComment");
            tbHttpMessageTask.setResponsedClass(FrsSelectSubCommentReponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.f26917a.registerListener(CmdConfigHttp.CMD_SELECT_SUB_COMMENT, this.f26926j);
        }
    }

    public void l(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.f26918b = dVar;
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f26920d = str;
        }
    }
}
