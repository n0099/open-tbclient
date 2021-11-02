package b.a.r0.x0.y2;

import b.a.r0.x0.q;
import b.a.r0.x0.r0;
import b.a.r0.x0.t;
import b.a.r0.x0.z;
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
public class j extends b.a.r0.x0.p2.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public b.a.r0.x0.s2.a f26907h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f26908i;
    public HashMap<Integer, z> j;
    public boolean k;
    public CustomMessageListener l;
    public final CustomMessageListener m;
    public final CustomMessageListener n;
    public final CustomMessageListener o;
    public final CustomMessageListener p;
    public r0 q;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f26909a;

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
            this.f26909a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.f26909a.k = false;
                return;
            }
            this.f26909a.k = true;
            this.f26909a.f26144b.getTabController().L();
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f26910a;

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
            this.f26910a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f26910a.f26143a == null) {
                return;
            }
            this.f26910a.f26143a.Q1();
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f26911a;

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
            this.f26911a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof z)) {
                this.f26911a.f26143a.S1();
                z zVar = (z) customResponsedMessage.getData();
                r0 r0Var = zVar.f26944b;
                if (r0Var != null) {
                    this.f26911a.c0(zVar.f26943a, r0Var);
                } else {
                    int i2 = zVar.f26943a;
                    if (i2 != 1) {
                        this.f26911a.c0(i2, null);
                    } else {
                        j jVar = this.f26911a;
                        jVar.c0(i2, jVar.q);
                    }
                }
                this.f26911a.f0(zVar.f26943a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f26912a;

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
            this.f26912a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof z)) {
                z zVar = (z) customResponsedMessage.getData();
                this.f26912a.d0(zVar.f26943a, zVar.f26945c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f26913a;

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
            this.f26913a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof t)) {
                t tVar = (t) customResponsedMessage.getData();
                this.f26913a.e0(tVar.f26328a, tVar.f26329b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements r0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f26914e;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f26915e;

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
                this.f26915e = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f26915e.f26914e.f26143a.f0() == null || this.f26915e.f26914e.f26148f == null || this.f26915e.f26914e.f26143a.f0().getVisibility() == 0) {
                    return;
                }
                this.f26915e.f26914e.f26148f.o();
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
            this.f26914e = jVar;
        }

        @Override // b.a.r0.x0.r0
        public void onLoadingComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f26914e.f26144b != null && this.f26914e.f26144b.isAdded()) {
                if (this.f26914e.f26908i && this.f26914e.f26144b.getTabController() != null) {
                    if (!this.f26914e.k && !this.f26914e.a0()) {
                        this.f26914e.f26144b.getTabController().f0();
                    }
                    this.f26914e.f26908i = false;
                }
                if (this.f26914e.f26907h != null && this.f26914e.f26144b.getFrsView() != null && this.f26914e.f26144b.getFrsView().X() != null && !this.f26914e.f26144b.getFrsView().X().o() && this.f26914e.f26144b.getTabController() != null && !this.f26914e.f26144b.getTabController().W()) {
                    this.f26914e.f26907h.b();
                }
                if (this.f26914e.f26143a == null || this.f26914e.f26148f == null || this.f26914e.f26146d == null || this.f26914e.f26907h == null) {
                    return;
                }
                this.f26914e.f26143a.h0().n(0, 0, true, true);
                this.f26914e.f26144b.requestLoadLiveTip();
                this.f26914e.f26144b.setNavigationBarMoveEnable(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                this.f26914e.f26146d.o0();
                if (!TbadkCoreApplication.isLogin() || this.f26914e.f26144b.getListView().getVisibility() != 0 || ListUtils.isEmpty(this.f26914e.f26144b.getFrsViewData().getThreadList())) {
                }
            }
        }

        @Override // b.a.r0.x0.r0
        public void onPullRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f26914e.f26908i = true;
                if (this.f26914e.f26143a == null || this.f26914e.f26148f == null || this.f26914e.f26146d == null || this.f26914e.f26144b == null || !this.f26914e.f26144b.isAdded()) {
                    return;
                }
                if (this.f26914e.f26143a != null && this.f26914e.f26143a.h0() != null) {
                    this.f26914e.f26143a.h0().w();
                }
                this.f26914e.f26144b.setNavigationBarMoveEnable(false);
                b.a.e.e.m.e.a().postDelayed(new a(this), 110L);
                this.f26914e.f26143a.o1(1, true);
                if (b.a.e.e.p.j.z()) {
                    this.f26914e.f26144b.refresh();
                    this.f26914e.f26144b.setNavigationBarMoveEnable(true);
                } else {
                    this.f26914e.f26144b.showLoadFinishedUI();
                }
                TiebaStatic.log(new StatisticItem("c11749").param("fid", this.f26914e.f26144b.getFid()).param("obj_locate", "1"));
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
        this.f26908i = false;
        this.k = false;
        this.l = new a(this, 2921468);
        this.m = new b(this, 2003003);
        this.n = new c(this, 2921448);
        this.o = new d(this, 9205410);
        this.p = new e(this, 2921449);
        this.q = new f(this);
        this.f26907h = frsFragment.getFrsSmartSortController();
        this.j = new HashMap<>();
        this.f26143a.c1(1);
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
            if (this.f26144b.getFrsViewData() == null || this.f26144b.getFrsViewData().getUserData() == null || this.f26144b.getFrsViewData().forumRule == null || this.f26144b.getFrsViewData().getForum() == null || !this.f26144b.getFrsViewData().getForum().getIsShowRule()) {
                return false;
            }
            return this.f26144b.getFrsViewData().getUserData().getIs_manager() == 1 ? this.f26144b.getFrsViewData().forumRule.has_forum_rule.intValue() != 1 && this.f26144b.getFrsViewData().forumRule.audit_status.intValue() == 0 && b.a.q0.s.e0.b.j().k("key_forum_rule_first_show_frs_manager", 0) <= 0 : this.f26144b.getFrsViewData().forumRule.has_forum_rule.intValue() == 1 && b.a.q0.s.e0.b.j().k("key_forum_rule_first_show_frs", 0) <= 0;
        }
        return invokeV.booleanValue;
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f26143a == null) {
            return;
        }
        n nVar = this.f26145c;
        if ((nVar instanceof FrsTabViewController) && ((FrsTabViewController) nVar).z() != null && (((FrsTabViewController) this.f26145c).z().f49027b instanceof r0)) {
            FrsTabViewController.o z = ((FrsTabViewController) this.f26145c).z();
            c0(z.f49026a, (r0) z.f49027b);
            f0(z.f49026a);
            return;
        }
        this.f26143a.j1(this.q);
    }

    public final void c0(int i2, r0 r0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, r0Var) == null) {
            z zVar = this.j.get(Integer.valueOf(i2));
            if (zVar == null) {
                z zVar2 = new z();
                zVar2.f26943a = i2;
                zVar2.f26944b = r0Var;
                this.j.put(Integer.valueOf(i2), zVar2);
            } else {
                zVar.f26944b = r0Var;
            }
            q qVar = this.f26143a;
            if (qVar != null) {
                qVar.j1(r0Var);
            }
        }
    }

    public final void d0(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            z zVar = this.j.get(Integer.valueOf(i2));
            if (zVar == null) {
                z zVar2 = new z();
                zVar2.f26943a = i2;
                zVar2.f26945c = z;
                this.j.put(Integer.valueOf(i2), zVar2);
            } else {
                zVar.f26945c = z;
            }
            q qVar = this.f26143a;
            if (qVar != null) {
                qVar.z1(z);
            }
        }
    }

    public final void e0(int i2, boolean z) {
        q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (qVar = this.f26143a) == null) {
            return;
        }
        qVar.o1(i2, z);
    }

    public final void f0(int i2) {
        z zVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || this.f26143a == null || (zVar = this.j.get(Integer.valueOf(i2))) == null) {
            return;
        }
        this.f26143a.c1(i2);
        this.f26143a.j1(zVar.f26944b);
        this.f26143a.z1(zVar.f26945c);
        if (zVar.f26944b == null) {
            this.f26143a.z1(false);
        }
    }
}
