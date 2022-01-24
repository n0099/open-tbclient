package c.a.t0.y2.i.a;

import c.a.d.f.p.n;
import c.a.s0.s.q.e2;
import c.a.t0.g0.s;
import c.a.t0.z2.g;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f25775b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.t0.y2.i.b.a f25776c;

    /* renamed from: d  reason: collision with root package name */
    public int f25777d;

    /* renamed from: e  reason: collision with root package name */
    public final CustomMessageListener f25778e;

    /* renamed from: f  reason: collision with root package name */
    public final CustomMessageListener f25779f;

    /* renamed from: g  reason: collision with root package name */
    public final CustomMessageListener f25780g;

    /* loaded from: classes9.dex */
    public class a implements s.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e2 a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f25781b;

        public a(b bVar, e2 e2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, e2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25781b = bVar;
            this.a = e2Var;
        }

        @Override // c.a.t0.g0.s.j
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    n.M(this.f25781b.a.getPageActivity(), g.thread_has_hide);
                }
                this.f25781b.h(z, this.a);
            }
        }
    }

    /* renamed from: c.a.t0.y2.i.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1553b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1553b(b bVar, int i2) {
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
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof e2) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == this.a.f25775b && this.a.f25776c != null && this.a.f25776c.isAvaliableToShowManageWindow()) {
                this.a.k((e2) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

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
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.j((String) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

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
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.i((String) customResponsedMessage.getData());
            }
        }
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, c.a.t0.y2.i.b.a aVar, int i2) {
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
        this.f25778e = new C1553b(this, 2921428);
        this.f25779f = new c(this, 2016557);
        this.f25780g = new d(this, 2921436);
        this.a = tbPageContext;
        this.f25775b = bdUniqueId;
        this.f25776c = aVar;
        this.f25777d = i2;
        this.f25778e.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f25778e);
        this.f25779f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f25779f);
        this.f25780g.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f25780g);
    }

    public final void h(boolean z, e2 e2Var) {
        c.a.t0.y2.i.b.a aVar;
        e2 e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048576, this, z, e2Var) == null) || e2Var == null || (aVar = this.f25776c) == null || ListUtils.isEmpty(aVar.getListData()) || this.f25776c.getMainView() == null || this.f25776c.getMainView().e() == null) {
            return;
        }
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= this.f25776c.getListData().size()) {
                break;
            }
            c.a.d.n.e.n nVar = this.f25776c.getListData().get(i2);
            if (nVar != null && (e2 = c.a.t0.y2.i.c.a.e(nVar)) != null && !StringUtils.isNull(e2.E) && e2.E.equals(e2Var.E)) {
                e2.l2 = z;
                c.a.t0.g0.f0.b d2 = c.a.t0.y2.i.c.a.d(e2);
                if (d2 != null) {
                    this.f25776c.getListData().set(i2, d2);
                    z2 = true;
                    break;
                }
            }
            i2++;
        }
        if (z2) {
            this.f25776c.getMainView().n(this.f25776c.getListData());
        }
    }

    public final void i(String str) {
        c.a.t0.y2.i.b.a aVar;
        e2 e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || StringUtils.isNull(str) || (aVar = this.f25776c) == null || ListUtils.isEmpty(aVar.getListData()) || this.f25776c.getMainView() == null || this.f25776c.getMainView().e() == null) {
            return;
        }
        boolean z = false;
        Iterator<c.a.d.n.e.n> it = this.f25776c.getListData().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            c.a.d.n.e.n next = it.next();
            if (next != null && (e2 = c.a.t0.y2.i.c.a.e(next)) != null && e2.L() != null && !StringUtils.isNull(e2.L().oriUgcNid) && e2.L().oriUgcNid.equals(str)) {
                it.remove();
                z = true;
                break;
            }
        }
        if (z) {
            this.f25776c.getMainView().n(this.f25776c.getListData());
        }
    }

    public final void j(String str) {
        c.a.t0.y2.i.b.a aVar;
        e2 e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || StringUtils.isNull(str) || (aVar = this.f25776c) == null || ListUtils.isEmpty(aVar.getListData()) || this.f25776c.getMainView() == null || this.f25776c.getMainView().e() == null) {
            return;
        }
        boolean z = false;
        Iterator<c.a.d.n.e.n> it = this.f25776c.getListData().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            c.a.d.n.e.n next = it.next();
            if (next != null && (e2 = c.a.t0.y2.i.c.a.e(next)) != null && !StringUtils.isNull(e2.E) && e2.E.equals(str)) {
                it.remove();
                z = true;
                break;
            }
        }
        if (z) {
            this.f25776c.getMainView().n(this.f25776c.getListData());
        }
    }

    public final void k(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, e2Var) == null) {
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.t = e2Var;
            cardPersonDynamicThreadData.f42382e = String.valueOf(e2Var.U());
            cardPersonDynamicThreadData.f42383f = e2Var.E;
            cardPersonDynamicThreadData.f42386i = e2Var.m2;
            cardPersonDynamicThreadData.s = e2Var.l2;
            if (e2Var != null && e2Var.L() != null) {
                cardPersonDynamicThreadData.K = e2Var.L().oriUgcNid;
            }
            s sVar = new s(this.a);
            sVar.t(this.f25777d == 1);
            sVar.o();
            sVar.s(new a(this, e2Var));
            sVar.n(cardPersonDynamicThreadData, false);
            sVar.u();
        }
    }
}
