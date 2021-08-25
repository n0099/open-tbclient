package c.a.q0.n2.i.a;

import c.a.e.e.p.l;
import c.a.e.l.e.n;
import c.a.p0.s.q.c2;
import c.a.q0.a0.q;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f22704a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f22705b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.q0.n2.i.b.a f22706c;

    /* renamed from: d  reason: collision with root package name */
    public int f22707d;

    /* renamed from: e  reason: collision with root package name */
    public final CustomMessageListener f22708e;

    /* renamed from: f  reason: collision with root package name */
    public final CustomMessageListener f22709f;

    /* renamed from: g  reason: collision with root package name */
    public final CustomMessageListener f22710g;

    /* loaded from: classes3.dex */
    public class a implements q.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c2 f22711a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f22712b;

        public a(b bVar, c2 c2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, c2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22712b = bVar;
            this.f22711a = c2Var;
        }

        @Override // c.a.q0.a0.q.j
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    l.L(this.f22712b.f22704a.getPageActivity(), R.string.thread_has_hide);
                }
                this.f22712b.h(z, this.f22711a);
            }
        }
    }

    /* renamed from: c.a.q0.n2.i.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1050b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f22713a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1050b(b bVar, int i2) {
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
            this.f22713a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c2) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == this.f22713a.f22705b && this.f22713a.f22706c != null && this.f22713a.f22706c.isAvaliableToShowManageWindow()) {
                this.f22713a.k((c2) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f22714a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(b bVar, int i2) {
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
            this.f22714a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.f22714a.j((String) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f22715a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(b bVar, int i2) {
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
            this.f22715a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.f22715a.i((String) customResponsedMessage.getData());
            }
        }
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, c.a.q0.n2.i.b.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, aVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22708e = new C1050b(this, 2921428);
        this.f22709f = new c(this, 2016557);
        this.f22710g = new d(this, 2921436);
        this.f22704a = tbPageContext;
        this.f22705b = bdUniqueId;
        this.f22706c = aVar;
        this.f22707d = i2;
        this.f22708e.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f22708e);
        this.f22709f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f22709f);
        this.f22710g.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f22710g);
    }

    public final void h(boolean z, c2 c2Var) {
        c.a.q0.n2.i.b.a aVar;
        c2 e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048576, this, z, c2Var) == null) || c2Var == null || (aVar = this.f22706c) == null || ListUtils.isEmpty(aVar.getListData()) || this.f22706c.getMainView() == null || this.f22706c.getMainView().e() == null) {
            return;
        }
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= this.f22706c.getListData().size()) {
                break;
            }
            n nVar = this.f22706c.getListData().get(i2);
            if (nVar != null && (e2 = c.a.q0.n2.i.c.a.e(nVar)) != null && !StringUtils.isNull(e2.B) && e2.B.equals(c2Var.B)) {
                e2.g2 = z;
                c.a.q0.a0.d0.b d2 = c.a.q0.n2.i.c.a.d(e2);
                if (d2 != null) {
                    this.f22706c.getListData().set(i2, d2);
                    z2 = true;
                    break;
                }
            }
            i2++;
        }
        if (z2) {
            this.f22706c.getMainView().n(this.f22706c.getListData());
        }
    }

    public final void i(String str) {
        c.a.q0.n2.i.b.a aVar;
        c2 e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || StringUtils.isNull(str) || (aVar = this.f22706c) == null || ListUtils.isEmpty(aVar.getListData()) || this.f22706c.getMainView() == null || this.f22706c.getMainView().e() == null) {
            return;
        }
        boolean z = false;
        Iterator<n> it = this.f22706c.getListData().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            n next = it.next();
            if (next != null && (e2 = c.a.q0.n2.i.c.a.e(next)) != null && e2.L() != null && !StringUtils.isNull(e2.L().oriUgcNid) && e2.L().oriUgcNid.equals(str)) {
                it.remove();
                z = true;
                break;
            }
        }
        if (z) {
            this.f22706c.getMainView().n(this.f22706c.getListData());
        }
    }

    public final void j(String str) {
        c.a.q0.n2.i.b.a aVar;
        c2 e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || StringUtils.isNull(str) || (aVar = this.f22706c) == null || ListUtils.isEmpty(aVar.getListData()) || this.f22706c.getMainView() == null || this.f22706c.getMainView().e() == null) {
            return;
        }
        boolean z = false;
        Iterator<n> it = this.f22706c.getListData().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            n next = it.next();
            if (next != null && (e2 = c.a.q0.n2.i.c.a.e(next)) != null && !StringUtils.isNull(e2.B) && e2.B.equals(str)) {
                it.remove();
                z = true;
                break;
            }
        }
        if (z) {
            this.f22706c.getMainView().n(this.f22706c.getListData());
        }
    }

    public final void k(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, c2Var) == null) {
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.r = c2Var;
            cardPersonDynamicThreadData.f49874e = String.valueOf(c2Var.T());
            cardPersonDynamicThreadData.f49875f = c2Var.B;
            cardPersonDynamicThreadData.f49876g = c2Var.h2;
            cardPersonDynamicThreadData.q = c2Var.g2;
            if (c2Var != null && c2Var.L() != null) {
                cardPersonDynamicThreadData.I = c2Var.L().oriUgcNid;
            }
            q qVar = new q(this.f22704a);
            qVar.t(this.f22707d == 1);
            qVar.o();
            qVar.s(new a(this, c2Var));
            qVar.n(cardPersonDynamicThreadData, false);
            qVar.u();
        }
    }
}
