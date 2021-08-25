package c.a.q0.v0.n2;

import c.a.q0.v0.q;
import c.a.q0.v0.r0;
import c.a.q0.v0.t;
import c.a.q0.v0.z;
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
public class j extends c.a.q0.v0.e2.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.v0.h2.a f26786h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f26787i;

    /* renamed from: j  reason: collision with root package name */
    public HashMap<Integer, z> f26788j;
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
        public final /* synthetic */ j f26789a;

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
            this.f26789a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.f26789a.k = false;
                return;
            }
            this.f26789a.k = true;
            this.f26789a.f26011b.getTabController().L();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f26790a;

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
            this.f26790a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f26790a.f26010a == null) {
                return;
            }
            this.f26790a.f26010a.R1();
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f26791a;

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
            this.f26791a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof z)) {
                this.f26791a.f26010a.T1();
                z zVar = (z) customResponsedMessage.getData();
                r0 r0Var = zVar.f27380b;
                if (r0Var != null) {
                    this.f26791a.c0(zVar.f27379a, r0Var);
                } else {
                    int i2 = zVar.f27379a;
                    if (i2 != 1) {
                        this.f26791a.c0(i2, null);
                    } else {
                        j jVar = this.f26791a;
                        jVar.c0(i2, jVar.q);
                    }
                }
                this.f26791a.f0(zVar.f27379a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f26792a;

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
            this.f26792a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof z)) {
                z zVar = (z) customResponsedMessage.getData();
                this.f26792a.d0(zVar.f27379a, zVar.f27381c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f26793a;

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
            this.f26793a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof t)) {
                t tVar = (t) customResponsedMessage.getData();
                this.f26793a.e0(tVar.f27158a, tVar.f27159b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements r0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f26794e;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f26795e;

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
                this.f26795e = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f26795e.f26794e.f26010a.g0() == null || this.f26795e.f26794e.f26015f == null || this.f26795e.f26794e.f26010a.g0().getVisibility() == 0) {
                    return;
                }
                this.f26795e.f26794e.f26015f.o();
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
            this.f26794e = jVar;
        }

        @Override // c.a.q0.v0.r0
        public void onLoadingComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f26794e.f26011b != null && this.f26794e.f26011b.isAdded()) {
                if (this.f26794e.f26787i && this.f26794e.f26011b.getTabController() != null) {
                    if (!this.f26794e.k && !this.f26794e.a0()) {
                        this.f26794e.f26011b.getTabController().f0();
                    }
                    this.f26794e.f26787i = false;
                }
                if (this.f26794e.f26786h != null && this.f26794e.f26011b.getFrsView() != null && this.f26794e.f26011b.getFrsView().Y() != null && !this.f26794e.f26011b.getFrsView().Y().o() && this.f26794e.f26011b.getTabController() != null && !this.f26794e.f26011b.getTabController().W()) {
                    this.f26794e.f26786h.b();
                }
                if (this.f26794e.f26010a == null || this.f26794e.f26015f == null || this.f26794e.f26013d == null || this.f26794e.f26786h == null) {
                    return;
                }
                this.f26794e.f26010a.i0().n(0, 0, true, true);
                this.f26794e.f26011b.requestLoadLiveTip();
                this.f26794e.f26011b.setNavigationBarMoveEnable(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                this.f26794e.f26013d.o0();
                if (!TbadkCoreApplication.isLogin() || this.f26794e.f26011b.getListView().getVisibility() != 0 || ListUtils.isEmpty(this.f26794e.f26011b.getFrsViewData().getThreadList())) {
                }
            }
        }

        @Override // c.a.q0.v0.r0
        public void onPullRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f26794e.f26787i = true;
                if (this.f26794e.f26010a == null || this.f26794e.f26015f == null || this.f26794e.f26013d == null || this.f26794e.f26011b == null || !this.f26794e.f26011b.isAdded()) {
                    return;
                }
                if (this.f26794e.f26010a != null && this.f26794e.f26010a.i0() != null) {
                    this.f26794e.f26010a.i0().w();
                }
                this.f26794e.f26011b.setNavigationBarMoveEnable(false);
                c.a.e.e.m.e.a().postDelayed(new a(this), 110L);
                this.f26794e.f26010a.p1(1, true);
                if (c.a.e.e.p.j.z()) {
                    this.f26794e.f26011b.refresh();
                    this.f26794e.f26011b.setNavigationBarMoveEnable(true);
                } else {
                    this.f26794e.f26011b.showLoadFinishedUI();
                }
                TiebaStatic.log(new StatisticItem("c11749").param("fid", this.f26794e.f26011b.getFid()).param("obj_locate", "1"));
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
        this.f26787i = false;
        this.k = false;
        this.l = new a(this, 2921468);
        this.m = new b(this, 2003003);
        this.n = new c(this, 2921448);
        this.o = new d(this, 9205410);
        this.p = new e(this, 2921449);
        this.q = new f(this);
        this.f26786h = frsFragment.getFrsSmartSortController();
        this.f26788j = new HashMap<>();
        this.f26010a.d1(1);
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
            if (this.f26011b.getFrsViewData() == null || this.f26011b.getFrsViewData().getUserData() == null || this.f26011b.getFrsViewData().forumRule == null || this.f26011b.getFrsViewData().getForum() == null || !this.f26011b.getFrsViewData().getForum().getIsShowRule()) {
                return false;
            }
            return this.f26011b.getFrsViewData().getUserData().getIs_manager() == 1 ? this.f26011b.getFrsViewData().forumRule.has_forum_rule.intValue() != 1 && this.f26011b.getFrsViewData().forumRule.audit_status.intValue() == 0 && c.a.p0.s.d0.b.j().k("key_forum_rule_first_show_frs_manager", 0) <= 0 : this.f26011b.getFrsViewData().forumRule.has_forum_rule.intValue() == 1 && c.a.p0.s.d0.b.j().k("key_forum_rule_first_show_frs", 0) <= 0;
        }
        return invokeV.booleanValue;
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f26010a == null) {
            return;
        }
        n nVar = this.f26012c;
        if ((nVar instanceof FrsTabViewController) && ((FrsTabViewController) nVar).z() != null && (((FrsTabViewController) this.f26012c).z().f51476b instanceof r0)) {
            FrsTabViewController.o z = ((FrsTabViewController) this.f26012c).z();
            c0(z.f51475a, (r0) z.f51476b);
            f0(z.f51475a);
            return;
        }
        this.f26010a.k1(this.q);
    }

    public final void c0(int i2, r0 r0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, r0Var) == null) {
            z zVar = this.f26788j.get(Integer.valueOf(i2));
            if (zVar == null) {
                z zVar2 = new z();
                zVar2.f27379a = i2;
                zVar2.f27380b = r0Var;
                this.f26788j.put(Integer.valueOf(i2), zVar2);
            } else {
                zVar.f27380b = r0Var;
            }
            q qVar = this.f26010a;
            if (qVar != null) {
                qVar.k1(r0Var);
            }
        }
    }

    public final void d0(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            z zVar = this.f26788j.get(Integer.valueOf(i2));
            if (zVar == null) {
                z zVar2 = new z();
                zVar2.f27379a = i2;
                zVar2.f27381c = z;
                this.f26788j.put(Integer.valueOf(i2), zVar2);
            } else {
                zVar.f27381c = z;
            }
            q qVar = this.f26010a;
            if (qVar != null) {
                qVar.A1(z);
            }
        }
    }

    public final void e0(int i2, boolean z) {
        q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (qVar = this.f26010a) == null) {
            return;
        }
        qVar.p1(i2, z);
    }

    public final void f0(int i2) {
        z zVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || this.f26010a == null || (zVar = this.f26788j.get(Integer.valueOf(i2))) == null) {
            return;
        }
        this.f26010a.d1(i2);
        this.f26010a.k1(zVar.f27380b);
        this.f26010a.A1(zVar.f27381c);
        if (zVar.f27380b == null) {
            this.f26010a.A1(false);
        }
    }
}
