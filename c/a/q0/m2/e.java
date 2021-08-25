package c.a.q0.m2;

import c.a.e.e.p.j;
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
/* loaded from: classes3.dex */
public class e implements c.a.q0.n2.d.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.q0.r2.n.a f22414a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f22415b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f22416c;

    /* renamed from: d  reason: collision with root package name */
    public HttpMessageListener f22417d;

    /* renamed from: e  reason: collision with root package name */
    public int f22418e;

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f22419a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f22419a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage().getTag() == this.f22419a.f22416c) {
                if (!httpResponsedMessage.isSuccess() || httpResponsedMessage.getError() != 0) {
                    if (this.f22419a.f22415b == null || StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                        return;
                    }
                    this.f22419a.f22415b.showToast(httpResponsedMessage.getErrorString());
                    return;
                }
                if (this.f22419a.f22415b != null) {
                    this.f22419a.f22415b.showToast(R.string.privacy_setting_toast);
                }
                this.f22419a.f22418e = 1;
                this.f22419a.f22414a.e();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f22420a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f22420a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921065 || customResponsedMessage.getData() == null || this.f22420a.f22418e == (intValue = ((Integer) customResponsedMessage.getData()).intValue())) {
                return;
            }
            this.f22420a.f22418e = intValue;
            if (intValue != 1) {
                return;
            }
            this.f22420a.f22414a.e();
        }
    }

    public e(TbPageContext tbPageContext, c.a.q0.r2.n.a aVar, BdUniqueId bdUniqueId) {
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
        this.f22418e = 0;
        this.f22415b = tbPageContext;
        this.f22414a = aVar;
        this.f22416c = bdUniqueId;
        this.f22417d = new a(this, CmdConfigHttp.SET_PRIVATE_CMD);
        b bVar = new b(this, 2921065);
        this.f22417d.setTag(this.f22416c);
        bVar.setTag(this.f22416c);
        MessageManager.getInstance().registerListener(this.f22417d);
        MessageManager.getInstance().registerListener(bVar);
    }

    @Override // c.a.q0.n2.d.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!j.z()) {
                TbPageContext tbPageContext = this.f22415b;
                if (tbPageContext != null) {
                    tbPageContext.showToast(R.string.neterror);
                    return;
                }
                return;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
            httpMessage.addParam("opt", "post");
            httpMessage.addParam("val", String.valueOf(1));
            httpMessage.setTag(this.f22416c);
            MessageManager.getInstance().sendMessage(httpMessage);
            TiebaStatic.log(new StatisticItem("c12515").param("obj_locate", 1));
        }
    }
}
