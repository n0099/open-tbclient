package b.a.r0.o2;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f implements b.a.r0.p2.d.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.r0.u2.n.a f23537a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f23538b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f23539c;

    /* renamed from: d  reason: collision with root package name */
    public HttpMessageListener f23540d;

    /* renamed from: e  reason: collision with root package name */
    public int f23541e;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f23542a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f fVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2)};
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
            this.f23542a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage().getTag() == this.f23542a.f23539c) {
                if (!httpResponsedMessage.isSuccess() || httpResponsedMessage.getError() != 0) {
                    if (this.f23542a.f23538b == null || StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                        return;
                    }
                    this.f23542a.f23538b.showToast(httpResponsedMessage.getErrorString());
                    return;
                }
                if (this.f23542a.f23538b != null) {
                    this.f23542a.f23538b.showToast(R.string.privacy_setting_toast);
                }
                this.f23542a.f23541e = 1;
                this.f23542a.f23537a.e();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f23543a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(f fVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2)};
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
            this.f23543a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921065 || customResponsedMessage.getData() == null || this.f23543a.f23541e == (intValue = ((Integer) customResponsedMessage.getData()).intValue())) {
                return;
            }
            this.f23543a.f23541e = intValue;
            if (intValue != 1) {
                return;
            }
            this.f23543a.f23537a.e();
        }
    }

    public f(TbPageContext tbPageContext, b.a.r0.u2.n.a aVar, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, aVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23541e = 0;
        this.f23538b = tbPageContext;
        this.f23537a = aVar;
        this.f23539c = bdUniqueId;
        this.f23540d = new a(this, CmdConfigHttp.SET_PRIVATE_CMD);
        b bVar = new b(this, 2921065);
        this.f23540d.setTag(this.f23539c);
        bVar.setTag(this.f23539c);
        MessageManager.getInstance().registerListener(this.f23540d);
        MessageManager.getInstance().registerListener(bVar);
    }

    @Override // b.a.r0.p2.d.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!b.a.e.f.p.j.z()) {
                TbPageContext tbPageContext = this.f23538b;
                if (tbPageContext != null) {
                    tbPageContext.showToast(R.string.neterror);
                    return;
                }
                return;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
            httpMessage.addParam("opt", "post");
            httpMessage.addParam("val", String.valueOf(1));
            httpMessage.setTag(this.f23539c);
            MessageManager.getInstance().sendMessage(httpMessage);
            TiebaStatic.log(new StatisticItem("c12515").param("obj_locate", 1));
        }
    }
}
