package c.a.r0.x0.h1;

import c.a.e.e.p.j;
import c.a.r0.x0.h1.g;
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
    public c f27034a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f27035b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.q0.t.e.a f27036c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f27037d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f27038e;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f27039a;

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
            this.f27039a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            UpdateAttentionMessage.a data;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !(customResponsedMessage instanceof UpdateAttentionMessage) || this.f27039a.f27034a == null || (data = (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage).getData()) == null) {
                return;
            }
            if (!data.f48111a) {
                this.f27039a.f27034a.showMsg(updateAttentionMessage.getData().f48112b);
            } else {
                this.f27039a.f27034a.c(data.f48114d);
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
        this.f27037d = BdUniqueId.gen();
        this.f27038e = new a(this, 2001115);
        this.f27035b = tbPageContext;
        this.f27034a = cVar;
        this.f27036c = new c.a.q0.t.e.a(tbPageContext);
        this.f27038e.setSelfListener(true);
        this.f27038e.setTag(this.f27037d);
        MessageManager.getInstance().registerListener(this.f27038e);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.q0.t.e.a aVar = this.f27036c;
            if (aVar != null) {
                aVar.g();
            }
            MessageManager.getInstance().unRegisterListener(this.f27038e);
        }
    }

    public void c(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) {
            if (!j.z()) {
                this.f27035b.showToast(R.string.no_network);
            } else if (gVar == null || gVar.y == null || this.f27036c == null || !ViewHelper.checkUpIsLogin(this.f27035b.getPageActivity())) {
            } else {
                c.a.q0.t.e.a aVar = this.f27036c;
                g.b bVar = gVar.y;
                aVar.l(!bVar.f27014e, bVar.f27013d, bVar.f27010a, this.f27037d);
            }
        }
    }

    public void d(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            if (!j.z()) {
                this.f27035b.showToast(R.string.no_network);
            } else if (gVar == null || this.f27034a == null || !ViewHelper.checkUpIsLogin(this.f27035b.getPageActivity())) {
            } else {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
                httpMessage.addParam("thread_id", gVar.f26999f);
                httpMessage.addParam("op_type", Boolean.valueOf(gVar.p));
                httpMessage.addParam("obj_type", 3);
                httpMessage.addParam("agree_type", 2);
                httpMessage.addParam("forum_id", gVar.f26998e);
                httpMessage.addParam("z_id", TbadkCoreApplication.getInst().getZid());
                if (!StringUtil.isEmpty(gVar.u)) {
                    httpMessage.addParam("obj_source", gVar.u);
                }
                httpMessage.addHeader("needSig", "1");
                MessageManager.getInstance().sendMessage(httpMessage);
                this.f27034a.b();
            }
        }
    }
}
