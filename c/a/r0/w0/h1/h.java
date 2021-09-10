package c.a.r0.w0.h1;

import c.a.e.e.p.j;
import c.a.r0.w0.h1.g;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f26839a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f26840b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.q0.t.e.a f26841c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f26842d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f26843e;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f26844a;

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
            this.f26844a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            UpdateAttentionMessage.a data;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !(customResponsedMessage instanceof UpdateAttentionMessage) || this.f26844a.f26839a == null || (data = (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage).getData()) == null) {
                return;
            }
            if (!data.f48082a) {
                this.f26844a.f26839a.showMsg(updateAttentionMessage.getData().f48083b);
            } else {
                this.f26844a.f26839a.c(data.f48085d);
            }
        }
    }

    public h(TbPageContext tbPageContext, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26842d = BdUniqueId.gen();
        this.f26843e = new a(this, 2001115);
        this.f26840b = tbPageContext;
        this.f26839a = cVar;
        this.f26841c = new c.a.q0.t.e.a(tbPageContext);
        this.f26843e.setSelfListener(true);
        this.f26843e.setTag(this.f26842d);
        MessageManager.getInstance().registerListener(this.f26843e);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.q0.t.e.a aVar = this.f26841c;
            if (aVar != null) {
                aVar.g();
            }
            MessageManager.getInstance().unRegisterListener(this.f26843e);
        }
    }

    public void c(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) {
            if (!j.z()) {
                this.f26840b.showToast(R.string.no_network);
            } else if (gVar == null || gVar.y == null || this.f26841c == null || !ViewHelper.checkUpIsLogin(this.f26840b.getPageActivity())) {
            } else {
                c.a.q0.t.e.a aVar = this.f26841c;
                g.b bVar = gVar.y;
                aVar.l(!bVar.f26819e, bVar.f26818d, bVar.f26815a, this.f26842d);
            }
        }
    }

    public void d(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            if (!j.z()) {
                this.f26840b.showToast(R.string.no_network);
            } else if (gVar == null || this.f26839a == null || !ViewHelper.checkUpIsLogin(this.f26840b.getPageActivity())) {
            } else {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
                httpMessage.addParam("thread_id", gVar.f26804f);
                httpMessage.addParam("op_type", Boolean.valueOf(gVar.p));
                httpMessage.addParam("obj_type", 3);
                httpMessage.addParam("agree_type", 2);
                httpMessage.addParam("forum_id", gVar.f26803e);
                httpMessage.addParam("z_id", TbadkCoreApplication.getInst().getZid());
                if (!StringUtil.isEmpty(gVar.u)) {
                    httpMessage.addParam("obj_source", gVar.u);
                }
                httpMessage.addHeader("needSig", "1");
                MessageManager.getInstance().sendMessage(httpMessage);
                this.f26839a.b();
            }
        }
    }
}
