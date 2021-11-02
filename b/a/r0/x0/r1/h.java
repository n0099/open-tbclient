package b.a.r0.x0.r1;

import b.a.e.e.p.j;
import b.a.r0.x0.r1.g;
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
/* loaded from: classes5.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f26289a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f26290b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.q0.t.e.a f26291c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f26292d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f26293e;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f26294a;

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
            this.f26294a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            UpdateAttentionMessage.a data;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !(customResponsedMessage instanceof UpdateAttentionMessage) || this.f26294a.f26289a == null || (data = (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage).getData()) == null) {
                return;
            }
            if (!data.f45667a) {
                this.f26294a.f26289a.showMsg(updateAttentionMessage.getData().f45668b);
            } else {
                this.f26294a.f26289a.c(data.f45670d);
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
        this.f26292d = BdUniqueId.gen();
        this.f26293e = new a(this, 2001115);
        this.f26290b = tbPageContext;
        this.f26289a = cVar;
        this.f26291c = new b.a.q0.t.e.a(tbPageContext);
        this.f26293e.setSelfListener(true);
        this.f26293e.setTag(this.f26292d);
        MessageManager.getInstance().registerListener(this.f26293e);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b.a.q0.t.e.a aVar = this.f26291c;
            if (aVar != null) {
                aVar.g();
            }
            MessageManager.getInstance().unRegisterListener(this.f26293e);
        }
    }

    public void c(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) {
            if (!j.z()) {
                this.f26290b.showToast(R.string.no_network);
            } else if (gVar == null || gVar.y == null || this.f26291c == null || !ViewHelper.checkUpIsLogin(this.f26290b.getPageActivity())) {
            } else {
                b.a.q0.t.e.a aVar = this.f26291c;
                g.b bVar = gVar.y;
                aVar.k(!bVar.f26270e, bVar.f26269d, bVar.f26266a, this.f26292d);
            }
        }
    }

    public void d(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            if (!j.z()) {
                this.f26290b.showToast(R.string.no_network);
            } else if (gVar == null || this.f26289a == null || !ViewHelper.checkUpIsLogin(this.f26290b.getPageActivity())) {
            } else {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
                httpMessage.addParam("thread_id", gVar.f26256f);
                httpMessage.addParam("op_type", Boolean.valueOf(gVar.p));
                httpMessage.addParam("obj_type", 3);
                httpMessage.addParam("agree_type", 2);
                httpMessage.addParam("forum_id", gVar.f26255e);
                httpMessage.addParam("z_id", TbadkCoreApplication.getInst().getZid());
                if (!StringUtil.isEmpty(gVar.u)) {
                    httpMessage.addParam("obj_source", gVar.u);
                }
                httpMessage.addHeader("needSig", "1");
                MessageManager.getInstance().sendMessage(httpMessage);
                this.f26289a.b();
            }
        }
    }
}
