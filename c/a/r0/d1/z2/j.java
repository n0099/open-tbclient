package c.a.r0.d1.z2;

import c.a.r0.d1.a0;
import c.a.r0.d1.q;
import c.a.r0.d1.s0;
import c.a.r0.d1.t;
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
/* loaded from: classes5.dex */
public class j extends c.a.r0.d1.q2.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.d1.t2.a f16529h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f16530i;

    /* renamed from: j  reason: collision with root package name */
    public HashMap<Integer, a0> f16531j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f16532k;
    public CustomMessageListener l;
    public final CustomMessageListener m;
    public final CustomMessageListener n;
    public final CustomMessageListener o;
    public final CustomMessageListener p;
    public s0 q;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

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
            this.a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.a.f16532k = false;
                return;
            }
            this.a.f16532k = true;
            this.a.f15875b.getTabController().L();
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

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
            this.a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.a == null) {
                return;
            }
            this.a.a.Q1();
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

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
            this.a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof a0)) {
                this.a.a.S1();
                a0 a0Var = (a0) customResponsedMessage.getData();
                s0 s0Var = a0Var.f15163b;
                if (s0Var != null) {
                    this.a.c0(a0Var.a, s0Var);
                } else {
                    int i2 = a0Var.a;
                    if (i2 != 1) {
                        this.a.c0(i2, null);
                    } else {
                        j jVar = this.a;
                        jVar.c0(i2, jVar.q);
                    }
                }
                this.a.f0(a0Var.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

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
            this.a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof a0)) {
                a0 a0Var = (a0) customResponsedMessage.getData();
                this.a.d0(a0Var.a, a0Var.f15164c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

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
            this.a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof t)) {
                t tVar = (t) customResponsedMessage.getData();
                this.a.e0(tVar.a, tVar.f16010b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements s0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f16533e;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f16534e;

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
                this.f16534e = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f16534e.f16533e.a.f0() == null || this.f16534e.f16533e.f15879f == null || this.f16534e.f16533e.a.f0().getVisibility() == 0) {
                    return;
                }
                this.f16534e.f16533e.f15879f.o();
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
            this.f16533e = jVar;
        }

        @Override // c.a.r0.d1.s0
        public void onLoadingComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f16533e.f15875b != null && this.f16533e.f15875b.isAdded()) {
                if (this.f16533e.f16530i && this.f16533e.f15875b.getTabController() != null) {
                    if (!this.f16533e.f16532k && !this.f16533e.a0()) {
                        this.f16533e.f15875b.getTabController().f0();
                    }
                    this.f16533e.f16530i = false;
                }
                if (this.f16533e.f16529h != null && this.f16533e.f15875b.getFrsView() != null && this.f16533e.f15875b.getFrsView().X() != null && !this.f16533e.f15875b.getFrsView().X().o() && this.f16533e.f15875b.getTabController() != null && !this.f16533e.f15875b.getTabController().W()) {
                    this.f16533e.f16529h.b();
                }
                if (this.f16533e.a == null || this.f16533e.f15879f == null || this.f16533e.f15877d == null || this.f16533e.f16529h == null) {
                    return;
                }
                this.f16533e.a.h0().n(0, 0, true, true);
                this.f16533e.f15875b.requestLoadLiveTip();
                this.f16533e.f15875b.setNavigationBarMoveEnable(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                this.f16533e.f15877d.o0();
                if (!TbadkCoreApplication.isLogin() || this.f16533e.f15875b.getListView().getVisibility() != 0 || ListUtils.isEmpty(this.f16533e.f15875b.getFrsViewData().getThreadList())) {
                }
            }
        }

        @Override // c.a.r0.d1.s0
        public void onPullRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f16533e.f16530i = true;
                if (this.f16533e.a == null || this.f16533e.f15879f == null || this.f16533e.f15877d == null || this.f16533e.f15875b == null || !this.f16533e.f15875b.isAdded()) {
                    return;
                }
                if (this.f16533e.a != null && this.f16533e.a.h0() != null) {
                    this.f16533e.a.h0().w();
                }
                this.f16533e.f15875b.setNavigationBarMoveEnable(false);
                c.a.d.f.m.e.a().postDelayed(new a(this), 110L);
                this.f16533e.a.o1(1, true);
                if (c.a.d.f.p.j.z()) {
                    this.f16533e.f15875b.refresh();
                    this.f16533e.f15875b.setNavigationBarMoveEnable(true);
                } else {
                    this.f16533e.f15875b.showLoadFinishedUI();
                }
                TiebaStatic.log(new StatisticItem("c11749").param("fid", this.f16533e.f15875b.getFid()).param("obj_locate", "1"));
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
        this.f16530i = false;
        this.f16532k = false;
        this.l = new a(this, 2921468);
        this.m = new b(this, 2003003);
        this.n = new c(this, 2921448);
        this.o = new d(this, 9205410);
        this.p = new e(this, 2921449);
        this.q = new f(this);
        this.f16529h = frsFragment.getFrsSmartSortController();
        this.f16531j = new HashMap<>();
        this.a.c1(1);
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
            if (this.f15875b.getFrsViewData() == null || this.f15875b.getFrsViewData().getUserData() == null || this.f15875b.getFrsViewData().forumRule == null || this.f15875b.getFrsViewData().getForum() == null || !this.f15875b.getFrsViewData().getForum().getIsShowRule()) {
                return false;
            }
            return this.f15875b.getFrsViewData().getUserData().getIs_manager() == 1 ? this.f15875b.getFrsViewData().forumRule.has_forum_rule.intValue() != 1 && this.f15875b.getFrsViewData().forumRule.audit_status.intValue() == 0 && c.a.q0.s.e0.b.j().k("key_forum_rule_first_show_frs_manager", 0) <= 0 : this.f15875b.getFrsViewData().forumRule.has_forum_rule.intValue() == 1 && c.a.q0.s.e0.b.j().k("key_forum_rule_first_show_frs", 0) <= 0;
        }
        return invokeV.booleanValue;
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a == null) {
            return;
        }
        n nVar = this.f15876c;
        if ((nVar instanceof FrsTabViewController) && ((FrsTabViewController) nVar).z() != null && (((FrsTabViewController) this.f15876c).z().f44719b instanceof s0)) {
            FrsTabViewController.o z = ((FrsTabViewController) this.f15876c).z();
            c0(z.a, (s0) z.f44719b);
            f0(z.a);
            return;
        }
        this.a.j1(this.q);
    }

    public final void c0(int i2, s0 s0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, s0Var) == null) {
            a0 a0Var = this.f16531j.get(Integer.valueOf(i2));
            if (a0Var == null) {
                a0 a0Var2 = new a0();
                a0Var2.a = i2;
                a0Var2.f15163b = s0Var;
                this.f16531j.put(Integer.valueOf(i2), a0Var2);
            } else {
                a0Var.f15163b = s0Var;
            }
            q qVar = this.a;
            if (qVar != null) {
                qVar.j1(s0Var);
            }
        }
    }

    public final void d0(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            a0 a0Var = this.f16531j.get(Integer.valueOf(i2));
            if (a0Var == null) {
                a0 a0Var2 = new a0();
                a0Var2.a = i2;
                a0Var2.f15164c = z;
                this.f16531j.put(Integer.valueOf(i2), a0Var2);
            } else {
                a0Var.f15164c = z;
            }
            q qVar = this.a;
            if (qVar != null) {
                qVar.z1(z);
            }
        }
    }

    public final void e0(int i2, boolean z) {
        q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (qVar = this.a) == null) {
            return;
        }
        qVar.o1(i2, z);
    }

    public final void f0(int i2) {
        a0 a0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || this.a == null || (a0Var = this.f16531j.get(Integer.valueOf(i2))) == null) {
            return;
        }
        this.a.c1(i2);
        this.a.j1(a0Var.f15163b);
        this.a.z1(a0Var.f15164c);
        if (a0Var.f15163b == null) {
            this.a.z1(false);
        }
    }
}
