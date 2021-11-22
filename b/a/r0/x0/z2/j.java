package b.a.r0.x0.z2;

import b.a.r0.x0.a0;
import b.a.r0.x0.q;
import b.a.r0.x0.s0;
import b.a.r0.x0.t;
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
/* loaded from: classes6.dex */
public class j extends b.a.r0.x0.q2.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public b.a.r0.x0.t2.a f28502h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f28503i;
    public HashMap<Integer, a0> j;
    public boolean k;
    public CustomMessageListener l;
    public final CustomMessageListener m;
    public final CustomMessageListener n;
    public final CustomMessageListener o;
    public final CustomMessageListener p;
    public s0 q;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f28504a;

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
            this.f28504a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.f28504a.k = false;
                return;
            }
            this.f28504a.k = true;
            this.f28504a.f27762b.getTabController().L();
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f28505a;

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
            this.f28505a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f28505a.f27761a == null) {
                return;
            }
            this.f28505a.f27761a.Q1();
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f28506a;

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
            this.f28506a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof a0)) {
                this.f28506a.f27761a.S1();
                a0 a0Var = (a0) customResponsedMessage.getData();
                s0 s0Var = a0Var.f26958b;
                if (s0Var != null) {
                    this.f28506a.c0(a0Var.f26957a, s0Var);
                } else {
                    int i2 = a0Var.f26957a;
                    if (i2 != 1) {
                        this.f28506a.c0(i2, null);
                    } else {
                        j jVar = this.f28506a;
                        jVar.c0(i2, jVar.q);
                    }
                }
                this.f28506a.f0(a0Var.f26957a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f28507a;

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
            this.f28507a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof a0)) {
                a0 a0Var = (a0) customResponsedMessage.getData();
                this.f28507a.d0(a0Var.f26957a, a0Var.f26959c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f28508a;

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
            this.f28508a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof t)) {
                t tVar = (t) customResponsedMessage.getData();
                this.f28508a.e0(tVar.f27908a, tVar.f27909b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements s0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f28509e;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f28510e;

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
                this.f28510e = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f28510e.f28509e.f27761a.f0() == null || this.f28510e.f28509e.f27766f == null || this.f28510e.f28509e.f27761a.f0().getVisibility() == 0) {
                    return;
                }
                this.f28510e.f28509e.f27766f.o();
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
            this.f28509e = jVar;
        }

        @Override // b.a.r0.x0.s0
        public void onLoadingComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f28509e.f27762b != null && this.f28509e.f27762b.isAdded()) {
                if (this.f28509e.f28503i && this.f28509e.f27762b.getTabController() != null) {
                    if (!this.f28509e.k && !this.f28509e.a0()) {
                        this.f28509e.f27762b.getTabController().f0();
                    }
                    this.f28509e.f28503i = false;
                }
                if (this.f28509e.f28502h != null && this.f28509e.f27762b.getFrsView() != null && this.f28509e.f27762b.getFrsView().X() != null && !this.f28509e.f27762b.getFrsView().X().o() && this.f28509e.f27762b.getTabController() != null && !this.f28509e.f27762b.getTabController().W()) {
                    this.f28509e.f28502h.b();
                }
                if (this.f28509e.f27761a == null || this.f28509e.f27766f == null || this.f28509e.f27764d == null || this.f28509e.f28502h == null) {
                    return;
                }
                this.f28509e.f27761a.h0().n(0, 0, true, true);
                this.f28509e.f27762b.requestLoadLiveTip();
                this.f28509e.f27762b.setNavigationBarMoveEnable(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                this.f28509e.f27764d.o0();
                if (!TbadkCoreApplication.isLogin() || this.f28509e.f27762b.getListView().getVisibility() != 0 || ListUtils.isEmpty(this.f28509e.f27762b.getFrsViewData().getThreadList())) {
                }
            }
        }

        @Override // b.a.r0.x0.s0
        public void onPullRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f28509e.f28503i = true;
                if (this.f28509e.f27761a == null || this.f28509e.f27766f == null || this.f28509e.f27764d == null || this.f28509e.f27762b == null || !this.f28509e.f27762b.isAdded()) {
                    return;
                }
                if (this.f28509e.f27761a != null && this.f28509e.f27761a.h0() != null) {
                    this.f28509e.f27761a.h0().w();
                }
                this.f28509e.f27762b.setNavigationBarMoveEnable(false);
                b.a.e.f.m.e.a().postDelayed(new a(this), 110L);
                this.f28509e.f27761a.o1(1, true);
                if (b.a.e.f.p.j.z()) {
                    this.f28509e.f27762b.refresh();
                    this.f28509e.f27762b.setNavigationBarMoveEnable(true);
                } else {
                    this.f28509e.f27762b.showLoadFinishedUI();
                }
                TiebaStatic.log(new StatisticItem("c11749").param("fid", this.f28509e.f27762b.getFid()).param("obj_locate", "1"));
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
        this.f28503i = false;
        this.k = false;
        this.l = new a(this, 2921468);
        this.m = new b(this, 2003003);
        this.n = new c(this, 2921448);
        this.o = new d(this, 9205410);
        this.p = new e(this, 2921449);
        this.q = new f(this);
        this.f28502h = frsFragment.getFrsSmartSortController();
        this.j = new HashMap<>();
        this.f27761a.c1(1);
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
            if (this.f27762b.getFrsViewData() == null || this.f27762b.getFrsViewData().getUserData() == null || this.f27762b.getFrsViewData().forumRule == null || this.f27762b.getFrsViewData().getForum() == null || !this.f27762b.getFrsViewData().getForum().getIsShowRule()) {
                return false;
            }
            return this.f27762b.getFrsViewData().getUserData().getIs_manager() == 1 ? this.f27762b.getFrsViewData().forumRule.has_forum_rule.intValue() != 1 && this.f27762b.getFrsViewData().forumRule.audit_status.intValue() == 0 && b.a.q0.s.e0.b.j().k("key_forum_rule_first_show_frs_manager", 0) <= 0 : this.f27762b.getFrsViewData().forumRule.has_forum_rule.intValue() == 1 && b.a.q0.s.e0.b.j().k("key_forum_rule_first_show_frs", 0) <= 0;
        }
        return invokeV.booleanValue;
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f27761a == null) {
            return;
        }
        n nVar = this.f27763c;
        if ((nVar instanceof FrsTabViewController) && ((FrsTabViewController) nVar).z() != null && (((FrsTabViewController) this.f27763c).z().f49890b instanceof s0)) {
            FrsTabViewController.o z = ((FrsTabViewController) this.f27763c).z();
            c0(z.f49889a, (s0) z.f49890b);
            f0(z.f49889a);
            return;
        }
        this.f27761a.j1(this.q);
    }

    public final void c0(int i2, s0 s0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, s0Var) == null) {
            a0 a0Var = this.j.get(Integer.valueOf(i2));
            if (a0Var == null) {
                a0 a0Var2 = new a0();
                a0Var2.f26957a = i2;
                a0Var2.f26958b = s0Var;
                this.j.put(Integer.valueOf(i2), a0Var2);
            } else {
                a0Var.f26958b = s0Var;
            }
            q qVar = this.f27761a;
            if (qVar != null) {
                qVar.j1(s0Var);
            }
        }
    }

    public final void d0(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            a0 a0Var = this.j.get(Integer.valueOf(i2));
            if (a0Var == null) {
                a0 a0Var2 = new a0();
                a0Var2.f26957a = i2;
                a0Var2.f26959c = z;
                this.j.put(Integer.valueOf(i2), a0Var2);
            } else {
                a0Var.f26959c = z;
            }
            q qVar = this.f27761a;
            if (qVar != null) {
                qVar.z1(z);
            }
        }
    }

    public final void e0(int i2, boolean z) {
        q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (qVar = this.f27761a) == null) {
            return;
        }
        qVar.o1(i2, z);
    }

    public final void f0(int i2) {
        a0 a0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || this.f27761a == null || (a0Var = this.j.get(Integer.valueOf(i2))) == null) {
            return;
        }
        this.f27761a.c1(i2);
        this.f27761a.j1(a0Var.f26958b);
        this.f27761a.z1(a0Var.f26959c);
        if (a0Var.f26958b == null) {
            this.f27761a.z1(false);
        }
    }
}
