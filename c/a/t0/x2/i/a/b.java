package c.a.t0.x2.i.a;

import c.a.d.f.p.n;
import c.a.s0.s.q.d2;
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
    public BdUniqueId f26274b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.t0.x2.i.b.a f26275c;

    /* renamed from: d  reason: collision with root package name */
    public int f26276d;

    /* renamed from: e  reason: collision with root package name */
    public final CustomMessageListener f26277e;

    /* renamed from: f  reason: collision with root package name */
    public final CustomMessageListener f26278f;

    /* renamed from: g  reason: collision with root package name */
    public final CustomMessageListener f26279g;

    /* loaded from: classes8.dex */
    public class a implements s.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d2 a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f26280b;

        public a(b bVar, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, d2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26280b = bVar;
            this.a = d2Var;
        }

        @Override // c.a.t0.g0.s.j
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    n.L(this.f26280b.a.getPageActivity(), g.thread_has_hide);
                }
                this.f26280b.h(z, this.a);
            }
        }
    }

    /* renamed from: c.a.t0.x2.i.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1517b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1517b(b bVar, int i2) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d2) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == this.a.f26274b && this.a.f26275c != null && this.a.f26275c.isAvaliableToShowManageWindow()) {
                this.a.k((d2) customResponsedMessage.getData());
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
        this.f26277e = new C1517b(this, 2921428);
        this.f26278f = new c(this, 2016557);
        this.f26279g = new d(this, 2921436);
        this.a = tbPageContext;
        this.f26274b = bdUniqueId;
        this.f26275c = aVar;
        this.f26276d = i2;
        this.f26277e.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f26277e);
        this.f26278f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f26278f);
        this.f26279g.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f26279g);
    }

    public final void h(boolean z, d2 d2Var) {
        c.a.t0.x2.i.b.a aVar;
        d2 e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048576, this, z, d2Var) == null) || d2Var == null || (aVar = this.f26275c) == null || ListUtils.isEmpty(aVar.getListData()) || this.f26275c.getMainView() == null || this.f26275c.getMainView().e() == null) {
            return;
        }
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= this.f26275c.getListData().size()) {
                break;
            }
            c.a.d.n.e.n nVar = this.f26275c.getListData().get(i2);
            if (nVar != null && (e2 = c.a.t0.x2.i.c.a.e(nVar)) != null && !StringUtils.isNull(e2.E) && e2.E.equals(d2Var.E)) {
                e2.m2 = z;
                c.a.t0.g0.f0.b d2 = c.a.t0.x2.i.c.a.d(e2);
                if (d2 != null) {
                    this.f26275c.getListData().set(i2, d2);
                    z2 = true;
                    break;
                }
            }
            i2++;
        }
        if (z2) {
            this.f26275c.getMainView().n(this.f26275c.getListData());
        }
    }

    public final void i(String str) {
        c.a.t0.x2.i.b.a aVar;
        d2 e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || StringUtils.isNull(str) || (aVar = this.f26275c) == null || ListUtils.isEmpty(aVar.getListData()) || this.f26275c.getMainView() == null || this.f26275c.getMainView().e() == null) {
            return;
        }
        boolean z = false;
        Iterator<c.a.d.n.e.n> it = this.f26275c.getListData().iterator();
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
            this.f26275c.getMainView().n(this.f26275c.getListData());
        }
    }

    public final void j(String str) {
        c.a.t0.x2.i.b.a aVar;
        d2 e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || StringUtils.isNull(str) || (aVar = this.f26275c) == null || ListUtils.isEmpty(aVar.getListData()) || this.f26275c.getMainView() == null || this.f26275c.getMainView().e() == null) {
            return;
        }
        boolean z = false;
        Iterator<c.a.d.n.e.n> it = this.f26275c.getListData().iterator();
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
            this.f26275c.getMainView().n(this.f26275c.getListData());
        }
    }

    public final void k(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, d2Var) == null) {
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.t = d2Var;
            cardPersonDynamicThreadData.f43964e = String.valueOf(d2Var.U());
            cardPersonDynamicThreadData.f43965f = d2Var.E;
            cardPersonDynamicThreadData.f43968i = d2Var.n2;
            cardPersonDynamicThreadData.s = d2Var.m2;
            if (d2Var != null && d2Var.L() != null) {
                cardPersonDynamicThreadData.K = d2Var.L().oriUgcNid;
            }
            s sVar = new s(this.a);
            sVar.t(this.f26276d == 1);
            sVar.o();
            sVar.s(new a(this, d2Var));
            sVar.n(cardPersonDynamicThreadData, false);
            sVar.u();
        }
    }
}
