package c.a.r0.x0.o2;

import c.a.r0.x0.q;
import c.a.r0.x0.r0;
import c.a.r0.x0.t;
import c.a.r0.x0.z;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class j extends c.a.r0.x0.f2.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.x0.i2.a f27651h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f27652i;

    /* renamed from: j  reason: collision with root package name */
    public HashMap<Integer, z> f27653j;
    public boolean k;
    public CustomMessageListener l;
    public final CustomMessageListener m;
    public final CustomMessageListener n;
    public final CustomMessageListener o;
    public final CustomMessageListener p;
    public r0 q;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f27654a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(j jVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i2)};
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
            this.f27654a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.f27654a.k = false;
                return;
            }
            this.f27654a.k = true;
            this.f27654a.f26896b.getTabController().L();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f27655a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(j jVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i2)};
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
            this.f27655a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f27655a.f26895a == null) {
                return;
            }
            this.f27655a.f26895a.R1();
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f27656a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(j jVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i2)};
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
            this.f27656a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof z)) {
                this.f27656a.f26895a.T1();
                z zVar = (z) customResponsedMessage.getData();
                r0 r0Var = zVar.f28241b;
                if (r0Var != null) {
                    this.f27656a.c0(zVar.f28240a, r0Var);
                } else {
                    int i2 = zVar.f28240a;
                    if (i2 != 1) {
                        this.f27656a.c0(i2, null);
                    } else {
                        j jVar = this.f27656a;
                        jVar.c0(i2, jVar.q);
                    }
                }
                this.f27656a.f0(zVar.f28240a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f27657a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(j jVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i2)};
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
            this.f27657a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof z)) {
                z zVar = (z) customResponsedMessage.getData();
                this.f27657a.d0(zVar.f28240a, zVar.f28242c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f27658a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(j jVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i2)};
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
            this.f27658a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof t)) {
                t tVar = (t) customResponsedMessage.getData();
                this.f27658a.e0(tVar.f28018a, tVar.f28019b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements r0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f27659e;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f27660e;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f27660e = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f27660e.f27659e.f26895a.g0() == null || this.f27660e.f27659e.f26900f == null || this.f27660e.f27659e.f26895a.g0().getVisibility() == 0) {
                    return;
                }
                this.f27660e.f27659e.f26900f.o();
            }
        }

        public f(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27659e = jVar;
        }

        @Override // c.a.r0.x0.r0
        public void onLoadingComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f27659e.f26896b != null && this.f27659e.f26896b.isAdded()) {
                if (this.f27659e.f27652i && this.f27659e.f26896b.getTabController() != null) {
                    if (!this.f27659e.k && !this.f27659e.a0()) {
                        this.f27659e.f26896b.getTabController().f0();
                    }
                    this.f27659e.f27652i = false;
                }
                if (this.f27659e.f27651h != null && this.f27659e.f26896b.getFrsView() != null && this.f27659e.f26896b.getFrsView().Y() != null && !this.f27659e.f26896b.getFrsView().Y().o() && this.f27659e.f26896b.getTabController() != null && !this.f27659e.f26896b.getTabController().W()) {
                    this.f27659e.f27651h.b();
                }
                if (this.f27659e.f26895a == null || this.f27659e.f26900f == null || this.f27659e.f26898d == null || this.f27659e.f27651h == null) {
                    return;
                }
                this.f27659e.f26895a.i0().n(0, 0, true, true);
                this.f27659e.f26896b.requestLoadLiveTip();
                this.f27659e.f26896b.setNavigationBarMoveEnable(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                this.f27659e.f26898d.o0();
                if (!TbadkCoreApplication.isLogin() || this.f27659e.f26896b.getListView().getVisibility() != 0 || ListUtils.isEmpty(this.f27659e.f26896b.getFrsViewData().getThreadList())) {
                }
            }
        }

        @Override // c.a.r0.x0.r0
        public void onPullRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f27659e.f27652i = true;
                if (this.f27659e.f26895a == null || this.f27659e.f26900f == null || this.f27659e.f26898d == null || this.f27659e.f26896b == null || !this.f27659e.f26896b.isAdded()) {
                    return;
                }
                if (this.f27659e.f26895a != null && this.f27659e.f26895a.i0() != null) {
                    this.f27659e.f26895a.i0().w();
                }
                this.f27659e.f26896b.setNavigationBarMoveEnable(false);
                c.a.e.e.m.e.a().postDelayed(new a(this), 110L);
                this.f27659e.f26895a.p1(1, true);
                if (c.a.e.e.p.j.z()) {
                    this.f27659e.f26896b.refresh();
                    this.f27659e.f26896b.setNavigationBarMoveEnable(true);
                } else {
                    this.f27659e.f26896b.showLoadFinishedUI();
                }
                TiebaStatic.log(new StatisticItem("c11749").param("fid", this.f27659e.f26896b.getFid()).param("obj_locate", "1"));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(FrsFragment frsFragment) {
        super(frsFragment);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((FrsFragment) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27652i = false;
        this.k = false;
        this.l = new a(this, 2921468);
        this.m = new b(this, 2003003);
        this.n = new c(this, 2921448);
        this.o = new d(this, 9205410);
        this.p = new e(this, 2921449);
        this.q = new f(this);
        this.f27651h = frsFragment.getFrsSmartSortController();
        this.f27653j = new HashMap<>();
        this.f26895a.d1(1);
        frsFragment.registerListener(this.m);
        frsFragment.registerListener(this.n);
        frsFragment.registerListener(this.o);
        frsFragment.registerListener(this.p);
        frsFragment.registerListener(this.l);
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    public final boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f26896b.getFrsViewData() == null || this.f26896b.getFrsViewData().getUserData() == null || this.f26896b.getFrsViewData().forumRule == null || this.f26896b.getFrsViewData().getForum() == null || !this.f26896b.getFrsViewData().getForum().getIsShowRule()) {
                return false;
            }
            return this.f26896b.getFrsViewData().getUserData().getIs_manager() == 1 ? this.f26896b.getFrsViewData().forumRule.has_forum_rule.intValue() != 1 && this.f26896b.getFrsViewData().forumRule.audit_status.intValue() == 0 && c.a.q0.s.d0.b.j().k("key_forum_rule_first_show_frs_manager", 0) <= 0 : this.f26896b.getFrsViewData().forumRule.has_forum_rule.intValue() == 1 && c.a.q0.s.d0.b.j().k("key_forum_rule_first_show_frs", 0) <= 0;
        }
        return invokeV.booleanValue;
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f26895a == null) {
            return;
        }
        n nVar = this.f26897c;
        if ((nVar instanceof FrsTabViewController) && ((FrsTabViewController) nVar).z() != null && (((FrsTabViewController) this.f26897c).z().f51682b instanceof r0)) {
            FrsTabViewController.o z = ((FrsTabViewController) this.f26897c).z();
            c0(z.f51681a, (r0) z.f51682b);
            f0(z.f51681a);
            return;
        }
        this.f26895a.k1(this.q);
    }

    public final void c0(int i2, r0 r0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, r0Var) == null) {
            z zVar = this.f27653j.get(Integer.valueOf(i2));
            if (zVar == null) {
                z zVar2 = new z();
                zVar2.f28240a = i2;
                zVar2.f28241b = r0Var;
                this.f27653j.put(Integer.valueOf(i2), zVar2);
            } else {
                zVar.f28241b = r0Var;
            }
            q qVar = this.f26895a;
            if (qVar != null) {
                qVar.k1(r0Var);
            }
        }
    }

    public final void d0(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            z zVar = this.f27653j.get(Integer.valueOf(i2));
            if (zVar == null) {
                z zVar2 = new z();
                zVar2.f28240a = i2;
                zVar2.f28242c = z;
                this.f27653j.put(Integer.valueOf(i2), zVar2);
            } else {
                zVar.f28242c = z;
            }
            q qVar = this.f26895a;
            if (qVar != null) {
                qVar.A1(z);
            }
        }
    }

    public final void e0(int i2, boolean z) {
        q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (qVar = this.f26895a) == null) {
            return;
        }
        qVar.p1(i2, z);
    }

    public final void f0(int i2) {
        z zVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || this.f26895a == null || (zVar = this.f27653j.get(Integer.valueOf(i2))) == null) {
            return;
        }
        this.f26895a.d1(i2);
        this.f26895a.k1(zVar.f28241b);
        this.f26895a.A1(zVar.f28242c);
        if (zVar.f28241b == null) {
            this.f26895a.A1(false);
        }
    }
}
