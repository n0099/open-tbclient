package c.a.t0.x2.i.a;

import c.a.d.f.p.n;
import c.a.s0.s.q.e2;
import c.a.t0.g0.s;
import c.a.t0.y2.g;
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
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f25494b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.t0.x2.i.b.a f25495c;

    /* renamed from: d  reason: collision with root package name */
    public int f25496d;

    /* renamed from: e  reason: collision with root package name */
    public final CustomMessageListener f25497e;

    /* renamed from: f  reason: collision with root package name */
    public final CustomMessageListener f25498f;

    /* renamed from: g  reason: collision with root package name */
    public final CustomMessageListener f25499g;

    /* loaded from: classes8.dex */
    public class a implements s.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e2 a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f25500b;

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
            this.f25500b = bVar;
            this.a = e2Var;
        }

        @Override // c.a.t0.g0.s.j
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    n.M(this.f25500b.a.getPageActivity(), g.thread_has_hide);
                }
                this.f25500b.h(z, this.a);
            }
        }
    }

    /* renamed from: c.a.t0.x2.i.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1533b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1533b(b bVar, int i2) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof e2) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == this.a.f25494b && this.a.f25495c != null && this.a.f25495c.isAvaliableToShowManageWindow()) {
                this.a.k((e2) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
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

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, c.a.t0.x2.i.b.a aVar, int i2) {
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
        this.f25497e = new C1533b(this, 2921428);
        this.f25498f = new c(this, 2016557);
        this.f25499g = new d(this, 2921436);
        this.a = tbPageContext;
        this.f25494b = bdUniqueId;
        this.f25495c = aVar;
        this.f25496d = i2;
        this.f25497e.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f25497e);
        this.f25498f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f25498f);
        this.f25499g.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f25499g);
    }

    public final void h(boolean z, e2 e2Var) {
        c.a.t0.x2.i.b.a aVar;
        e2 e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048576, this, z, e2Var) == null) || e2Var == null || (aVar = this.f25495c) == null || ListUtils.isEmpty(aVar.getListData()) || this.f25495c.getMainView() == null || this.f25495c.getMainView().e() == null) {
            return;
        }
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= this.f25495c.getListData().size()) {
                break;
            }
            c.a.d.n.e.n nVar = this.f25495c.getListData().get(i2);
            if (nVar != null && (e2 = c.a.t0.x2.i.c.a.e(nVar)) != null && !StringUtils.isNull(e2.E) && e2.E.equals(e2Var.E)) {
                e2.l2 = z;
                c.a.t0.g0.f0.b d2 = c.a.t0.x2.i.c.a.d(e2);
                if (d2 != null) {
                    this.f25495c.getListData().set(i2, d2);
                    z2 = true;
                    break;
                }
            }
            i2++;
        }
        if (z2) {
            this.f25495c.getMainView().n(this.f25495c.getListData());
        }
    }

    public final void i(String str) {
        c.a.t0.x2.i.b.a aVar;
        e2 e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || StringUtils.isNull(str) || (aVar = this.f25495c) == null || ListUtils.isEmpty(aVar.getListData()) || this.f25495c.getMainView() == null || this.f25495c.getMainView().e() == null) {
            return;
        }
        boolean z = false;
        Iterator<c.a.d.n.e.n> it = this.f25495c.getListData().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            c.a.d.n.e.n next = it.next();
            if (next != null && (e2 = c.a.t0.x2.i.c.a.e(next)) != null && e2.L() != null && !StringUtils.isNull(e2.L().oriUgcNid) && e2.L().oriUgcNid.equals(str)) {
                it.remove();
                z = true;
                break;
            }
        }
        if (z) {
            this.f25495c.getMainView().n(this.f25495c.getListData());
        }
    }

    public final void j(String str) {
        c.a.t0.x2.i.b.a aVar;
        e2 e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || StringUtils.isNull(str) || (aVar = this.f25495c) == null || ListUtils.isEmpty(aVar.getListData()) || this.f25495c.getMainView() == null || this.f25495c.getMainView().e() == null) {
            return;
        }
        boolean z = false;
        Iterator<c.a.d.n.e.n> it = this.f25495c.getListData().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            c.a.d.n.e.n next = it.next();
            if (next != null && (e2 = c.a.t0.x2.i.c.a.e(next)) != null && !StringUtils.isNull(e2.E) && e2.E.equals(str)) {
                it.remove();
                z = true;
                break;
            }
        }
        if (z) {
            this.f25495c.getMainView().n(this.f25495c.getListData());
        }
    }

    public final void k(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, e2Var) == null) {
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.t = e2Var;
            cardPersonDynamicThreadData.f42361e = String.valueOf(e2Var.U());
            cardPersonDynamicThreadData.f42362f = e2Var.E;
            cardPersonDynamicThreadData.f42365i = e2Var.m2;
            cardPersonDynamicThreadData.s = e2Var.l2;
            if (e2Var != null && e2Var.L() != null) {
                cardPersonDynamicThreadData.K = e2Var.L().oriUgcNid;
            }
            s sVar = new s(this.a);
            sVar.t(this.f25496d == 1);
            sVar.o();
            sVar.s(new a(this, e2Var));
            sVar.n(cardPersonDynamicThreadData, false);
            sVar.u();
        }
    }
}
