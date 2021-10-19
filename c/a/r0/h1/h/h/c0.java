package c.a.r0.h1.h.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.q0.s.q.d2;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.homepage.personalize.adapter.HomePageAlaFriendRoomAdapter;
import com.baidu.tieba.homepage.personalize.adapter.HomePageAlaLiveThreadAdapter;
import com.baidu.tieba.homepage.personalize.readProgressBar.ReadProgessDelegetAdapter;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public v A;
    public x B;
    public u C;
    public n D;
    public q E;
    public r F;
    public t G;
    public c.a.r0.h1.h.h.c H;
    public c.a.r0.h1.c.e.z I;
    public c.a.e.l.e.a J;
    public c.a.e.l.e.a K;
    public c.a.e.l.e.a L;
    public c.a.e.l.e.a M;
    public c.a.e.l.e.a N;
    public c.a.e.l.e.a O;
    public c.a.e.l.e.a P;
    public List<c.a.e.l.e.a> Q;
    public boolean R;
    public boolean S;
    public f T;
    public CustomMessageListener U;
    public CustomMessageListener V;
    public CustomMessageListener W;
    public CustomMessageListener X;
    public CustomMessageListener Y;

    /* renamed from: a  reason: collision with root package name */
    public List<c.a.e.l.e.a> f18434a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.e.l.e.s f18435b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.e.l.e.n> f18436c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext<?> f18437d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.h1.h.h.a f18438e;

    /* renamed from: f  reason: collision with root package name */
    public a0 f18439f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.h1.h.h.b f18440g;

    /* renamed from: h  reason: collision with root package name */
    public n f18441h;

    /* renamed from: i  reason: collision with root package name */
    public y f18442i;

    /* renamed from: j  reason: collision with root package name */
    public h f18443j;
    public i k;
    public j l;
    public s m;
    public k n;
    public p o;
    public m p;
    public o q;
    public g r;
    public c.a.r0.h1.h.h.f s;
    public c.a.r0.h1.h.h.e t;
    public z u;
    public c.a.r0.h1.h.h.d v;
    public l w;
    public HomePageAlaLiveThreadAdapter x;
    public HomePageAlaFriendRoomAdapter y;
    public w z;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c0 f18444a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c0 c0Var, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0Var, Integer.valueOf(i2)};
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
            this.f18444a = c0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f18444a.f();
            if (this.f18444a.f18436c != null) {
                c0 c0Var = this.f18444a;
                c0Var.z(c0Var.f18436c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c0 f18445a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c0 c0Var, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0Var, Integer.valueOf(i2)};
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
            this.f18445a = c0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().f48111a) {
                return;
            }
            this.f18445a.g(updateAttentionMessage.getData());
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c0 f18446a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(c0 c0Var, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0Var, Integer.valueOf(i2)};
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
            this.f18446a = c0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                c.a.r0.q1.p.b bVar = new c.a.r0.q1.p.b();
                bVar.f23833a = String.valueOf(customResponsedMessage.getData());
                bVar.f23834b = true;
                this.f18446a.g(bVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c0 f18447a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(c0 c0Var, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0Var, Integer.valueOf(i2)};
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
            this.f18447a = c0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                c.a.r0.q1.p.b bVar = new c.a.r0.q1.p.b();
                bVar.f23833a = String.valueOf(customResponsedMessage.getData());
                bVar.f23834b = false;
                this.f18447a.g(bVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c0 f18448a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(c0 c0Var, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0Var, Integer.valueOf(i2)};
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
            this.f18448a = c0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.a.f.m.e.b i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (StringUtils.isNull(str, true) || (i2 = this.f18448a.i(str)) == null) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, i2));
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a();
    }

    public c0(Context context, c.a.e.l.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, sVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.U = new a(this, 2016470);
        this.V = new b(this, 2001115);
        this.W = new c(this, 2001335);
        this.X = new d(this, 2001336);
        this.Y = new e(this, 2921394);
        this.f18434a = new ArrayList();
        this.f18435b = sVar;
        this.f18437d = (TbPageContext) c.a.e.a.j.a(context);
        j(context);
        y(sVar);
        sVar.addAdapters(this.f18434a);
    }

    public void A(List<c.a.e.l.e.n> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, list, i2) == null) {
            c.a.r0.k3.w.f(list, 2);
            ViewGroup listView = this.f18435b.getListView();
            if (i2 > 0 && (listView instanceof BdRecyclerView)) {
                BdRecyclerView bdRecyclerView = (BdRecyclerView) listView;
                int firstVisiblePosition = bdRecyclerView.getFirstVisiblePosition();
                View childAt = bdRecyclerView.getChildAt(0);
                int top = childAt != null ? childAt.getTop() : 0;
                RecyclerView.LayoutManager layoutManager = bdRecyclerView.getLayoutManager();
                int i3 = firstVisiblePosition - i2;
                if (layoutManager instanceof LinearLayoutManager) {
                    bdRecyclerView.startInterceptLayout();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i3, top);
                    bdRecyclerView.stopIntercerceptLayout();
                }
            }
            this.f18435b.setData(list);
            this.f18436c = list;
            f fVar = this.T;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.S = f();
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<c.a.e.l.e.a> list = this.Q;
            if (list == null || list.size() <= 0) {
                this.Q = new ArrayList();
                ArrayList<BdUniqueId> g2 = c.a.r0.k3.w.g();
                if (g2 == null || g2.size() <= 0) {
                    return false;
                }
                int size = g2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    c.a.r0.q1.o.g.a b2 = c.a.r0.q1.r.b.d().b(this.f18437d, g2.get(i2), 2);
                    if (this.R) {
                        b2.h0(3);
                    }
                    n nVar = this.f18441h;
                    if (nVar != null && (bdUniqueId = nVar.n) != null) {
                        b2.setUniqueId(bdUniqueId);
                    }
                    this.Q.add(b2);
                }
                this.f18435b.addAdapters(this.Q);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void g(Object obj) {
        List<c.a.e.l.e.n> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, obj) == null) || (list = this.f18436c) == null) {
            return;
        }
        boolean z = false;
        for (c.a.e.l.e.n nVar : list) {
            if ((nVar instanceof ICardInfo) && ((ICardInfo) nVar).responseAttention(obj)) {
                z = true;
            }
        }
        if (z) {
            m();
        }
    }

    public List<c.a.e.l.e.n> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f18436c : (List) invokeV.objValue;
    }

    public final c.a.f.m.e.b i(String str) {
        InterceptResult invokeL;
        int i2;
        c.a.r0.b0.e0.l lVar;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            List<c.a.e.l.e.n> list = this.f18436c;
            if (list == null || list.isEmpty() || str == null) {
                return null;
            }
            c.a.f.m.e.b bVar = new c.a.f.m.e.b();
            int i3 = 0;
            int i4 = 0;
            boolean z = false;
            int i5 = 0;
            int i6 = -1;
            int i7 = -1;
            while (true) {
                if (i3 >= this.f18436c.size()) {
                    i2 = -1;
                    break;
                }
                if (this.f18436c.get(i3) instanceof c.a.r0.h1.h.j.h) {
                    i4++;
                }
                if (this.f18436c.get(i3) instanceof c.a.r0.h1.h.j.a) {
                    if (l(this.f18436c.get(i3))) {
                        if (z) {
                            i2 = ((c.a.r0.h1.h.j.a) this.f18436c.get(i3)).position;
                            break;
                        }
                        i6 = ((c.a.r0.h1.h.j.a) this.f18436c.get(i3)).position;
                    } else if (z) {
                        i5++;
                    }
                }
                if ((this.f18436c.get(i3) instanceof c.a.r0.b0.e0.l) && (lVar = (c.a.r0.b0.e0.l) this.f18436c.get(i3)) != null && (d2Var = lVar.f15721e) != null && str.equals(d2Var.f0())) {
                    i7 = ((c.a.r0.b0.e0.l) this.f18436c.get(i3)).position;
                    z = true;
                }
                i3++;
            }
            if (i2 != -1 && (i2 = i2 - i5) < -1) {
                i2 = -1;
            }
            bVar.h(str);
            int i8 = i7 - i4;
            bVar.e(i8 >= -1 ? i8 : -1);
            bVar.g(i6);
            bVar.f(i2);
            return bVar;
        }
        return (c.a.f.m.e.b) invokeL.objValue;
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            this.f18438e = new c.a.r0.h1.h.h.a(this.f18437d);
            this.f18439f = new a0(this.f18437d);
            this.f18440g = new c.a.r0.h1.h.h.b(this.f18437d, c.a.r0.h1.h.j.f.f18523f);
            this.f18441h = new n(this.f18437d, c.a.r0.b0.e0.k.s0);
            this.f18442i = new y(this.f18437d, c.a.r0.b0.e0.k.C0);
            this.f18443j = new h(this.f18437d, c.a.r0.b0.e0.k.J0);
            this.k = new i(this.f18437d, c.a.r0.b0.e0.k.D0);
            this.l = new j(this.f18437d, c.a.r0.b0.e0.k.K0);
            this.m = new s(this.f18437d, c.a.r0.b0.e0.k.I0);
            this.n = new k(this.f18437d, c.a.r0.b0.e0.k.L0);
            this.o = new p(this.f18437d, c.a.r0.b0.e0.k.M0);
            this.p = new m(this.f18437d, c.a.r0.b0.e0.k.N0);
            this.q = new o(this.f18437d, c.a.r0.b0.e0.k.O0);
            this.r = new g(this.f18437d, c.a.r0.b0.e0.k.E0);
            this.s = new c.a.r0.h1.h.h.f(this.f18437d, c.a.r0.b0.e0.k.F0);
            this.t = new c.a.r0.h1.h.h.e(this.f18437d, c.a.r0.b0.e0.k.G0);
            this.u = new z(this.f18437d, c.a.r0.b0.e0.l.X);
            this.w = new l(this.f18437d, c.a.r0.b0.e0.k.u0);
            this.x = new HomePageAlaLiveThreadAdapter(this.f18437d, c.a.r0.b0.e0.j.P0);
            this.y = new HomePageAlaFriendRoomAdapter(this.f18437d, c.a.r0.b0.e0.j.Q0);
            this.z = new w(this.f18437d, c.a.r0.b0.e0.k.v0);
            this.A = new v(this.f18437d, c.a.r0.b0.e0.k.w0);
            this.B = new x(this.f18437d, c.a.r0.b0.e0.k.y0);
            this.C = new u(this.f18437d, c.a.r0.b0.e0.k.x0);
            this.D = new n(this.f18437d, c.a.r0.b0.e0.k.t0);
            this.E = new q(this.f18437d, c.a.r0.b0.e0.k.z0);
            this.F = new r(this.f18437d, c.a.r0.b0.e0.k.A0);
            this.G = new t(this.f18437d, c.a.r0.h1.k.b.c.a.k0);
            this.H = new c.a.r0.h1.h.h.c(this.f18437d, c.a.r0.b0.e0.e.P0);
            this.v = new c.a.r0.h1.h.h.d(this.f18437d, c.a.r0.b0.e0.k.H0);
            this.I = new c.a.r0.h1.c.e.z(this.f18437d, c.a.r0.b0.e0.k.B0, (byte) 3);
            this.f18434a.add(this.f18438e);
            this.f18434a.add(this.f18439f);
            this.f18434a.add(this.f18440g);
            this.f18434a.add(this.f18441h);
            this.f18434a.add(this.f18442i);
            this.f18434a.add(this.f18443j);
            this.f18434a.add(this.k);
            this.f18434a.add(this.l);
            this.f18434a.add(this.m);
            this.f18434a.add(this.n);
            this.f18434a.add(this.o);
            this.f18434a.add(this.p);
            this.f18434a.add(this.q);
            this.f18434a.add(this.r);
            this.f18434a.add(this.s);
            this.f18434a.add(this.t);
            this.f18434a.add(this.u);
            this.f18434a.add(this.w);
            this.f18434a.add(this.D);
            this.f18434a.add(new ReadProgessDelegetAdapter(this.f18437d, c.a.r0.h1.h.l.b.f18568g));
            this.f18434a.add(this.x);
            this.f18434a.add(this.y);
            this.f18434a.add(this.z);
            this.f18434a.add(this.A);
            this.f18434a.add(this.C);
            this.f18434a.add(this.B);
            this.f18434a.add(new b0(this.f18437d, c.a.r0.h1.h.j.h.f18525i));
            this.f18434a.add(this.E);
            this.f18434a.add(this.F);
            this.f18434a.add(this.G);
            this.f18434a.add(this.H);
            this.f18434a.add(this.v);
            this.f18434a.add(this.I);
            e();
            k();
            r("page_recommend");
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (!d2.N3.get()) {
                AdvertAppInfo.q4.set(false);
                return;
            }
            this.J = c.a.r0.z2.y.o().j(this.f18437d, AdvertAppInfo.t4, "INDEX");
            this.K = c.a.r0.z2.y.o().j(this.f18437d, AdvertAppInfo.u4, "INDEX");
            this.L = c.a.r0.z2.y.o().j(this.f18437d, AdvertAppInfo.v4, "INDEX");
            this.M = c.a.r0.z2.y.o().j(this.f18437d, AdvertAppInfo.w4, "INDEX");
            this.N = c.a.r0.z2.y.o().j(this.f18437d, AdvertAppInfo.x4, "INDEX");
            this.O = c.a.r0.z2.y.o().j(this.f18437d, AdvertAppInfo.z4, "INDEX");
            this.P = c.a.r0.z2.y.o().j(this.f18437d, AdvertAppInfo.y4, "INDEX");
            this.f18434a.add(this.J);
            this.f18434a.add(this.K);
            this.f18434a.add(this.L);
            this.f18434a.add(this.M);
            this.f18434a.add(this.N);
            this.f18434a.add(this.O);
            this.f18434a.add(this.P);
            if (this.f18437d.getPageActivity() instanceof BaseFragmentActivity) {
                this.f18434a.add(c.a.r0.y0.b.e().c((BaseFragmentActivity) this.f18437d.getPageActivity(), AdvertAppInfo.C4));
                this.f18434a.add(c.a.r0.y0.b.e().c((BaseFragmentActivity) this.f18437d.getPageActivity(), AdvertAppInfo.B4));
            }
            AdvertAppInfo.q4.set(true);
        }
    }

    public final boolean l(c.a.e.l.e.n nVar) {
        InterceptResult invokeL;
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nVar)) == null) ? nVar != null && (nVar instanceof c.a.r0.h1.h.j.a) && (advertAppInfo = ((c.a.r0.h1.h.j.a) nVar).f15727e) != null && advertAppInfo.S4() == 0 : invokeL.booleanValue;
    }

    public void m() {
        c.a.e.l.e.s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (sVar = this.f18435b) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            m();
            this.f18438e.h0(i2);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    public void p() {
        z zVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (zVar = this.u) == null) {
            return;
        }
        zVar.onPause();
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            z zVar = this.u;
            if (zVar != null) {
                zVar.onResume();
            }
            m();
        }
    }

    public final void r(String str) {
        List<c.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || (list = this.f18434a) == null) {
            return;
        }
        for (c.a.e.l.e.a aVar : list) {
            if (aVar instanceof c.a.r0.p.f) {
                ((c.a.r0.p.f) aVar).g(str);
            }
        }
    }

    public void s(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
            for (c.a.e.l.e.a aVar2 : this.f18434a) {
                if (aVar2 instanceof c.a.r0.h1.a) {
                    ((c.a.r0.h1.a) aVar2).h0(aVar);
                }
            }
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            n nVar = this.f18441h;
            if (nVar != null) {
                nVar.setFromCDN(z);
                this.D.setFromCDN(z);
                this.w.setFromCDN(z);
                this.z.setFromCDN(z);
            }
            j jVar = this.l;
            if (jVar != null) {
                jVar.setFromCDN(z);
            }
            c.a.r0.h1.h.h.d dVar = this.v;
            if (dVar != null) {
                dVar.setFromCDN(z);
            }
            c.a.e.l.e.a aVar = this.K;
            if (aVar == null || !(aVar instanceof c.a.r0.z2.t)) {
                return;
            }
            ((c.a.r0.z2.t) aVar).k(z);
        }
    }

    public void u(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            n nVar = this.f18441h;
            if (nVar != null) {
                nVar.q0(bVar);
            }
            s sVar = this.m;
            if (sVar != null) {
                sVar.o0(bVar);
            }
            i iVar = this.k;
            if (iVar != null) {
                iVar.n0(bVar);
            }
            l lVar = this.w;
            if (lVar != null) {
                lVar.m0(bVar);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.m0(bVar);
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.m0(bVar);
            }
            w wVar = this.z;
            if (wVar != null) {
                wVar.m0(bVar);
            }
            v vVar = this.A;
            if (vVar != null) {
                vVar.r0(bVar);
            }
            u uVar = this.C;
            if (uVar != null) {
                uVar.o0(bVar);
            }
            x xVar = this.B;
            if (xVar != null) {
                xVar.p0(bVar);
            }
            n nVar2 = this.D;
            if (nVar2 != null) {
                nVar2.q0(bVar);
            }
            q qVar = this.E;
            if (qVar != null) {
                qVar.p0(bVar);
            }
            r rVar = this.F;
            if (rVar != null) {
                rVar.o0(bVar);
            }
            t tVar = this.G;
            if (tVar != null) {
                tVar.k0(bVar);
            }
            c.a.r0.h1.h.h.c cVar = this.H;
            if (cVar != null) {
                cVar.o0(bVar);
            }
        }
    }

    public void v(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, fVar) == null) {
            this.T = fVar;
        }
    }

    public void w(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bdUniqueId) == null) {
            c.a.r0.h1.h.h.b bVar = this.f18440g;
            if (bVar != null) {
                bVar.j0(bdUniqueId);
            }
            n nVar = this.f18441h;
            if (nVar != null) {
                nVar.n = bdUniqueId;
            }
            y yVar = this.f18442i;
            if (yVar != null) {
                yVar.n = bdUniqueId;
            }
            h hVar = this.f18443j;
            if (hVar != null) {
                hVar.m = bdUniqueId;
            }
            i iVar = this.k;
            if (iVar != null) {
                iVar.m = bdUniqueId;
            }
            j jVar = this.l;
            if (jVar != null) {
                jVar.m = bdUniqueId;
            }
            s sVar = this.m;
            if (sVar != null) {
                sVar.m = bdUniqueId;
            }
            k kVar = this.n;
            if (kVar != null) {
                kVar.m = bdUniqueId;
            }
            p pVar = this.o;
            if (pVar != null) {
                pVar.m = bdUniqueId;
            }
            m mVar = this.p;
            if (mVar != null) {
                mVar.m = bdUniqueId;
            }
            o oVar = this.q;
            if (oVar != null) {
                oVar.m = bdUniqueId;
            }
            g gVar = this.r;
            if (gVar != null) {
                gVar.m = bdUniqueId;
            }
            c.a.r0.h1.h.h.f fVar = this.s;
            if (fVar != null) {
                fVar.m = bdUniqueId;
            }
            c.a.r0.h1.h.h.e eVar = this.t;
            if (eVar != null) {
                eVar.m = bdUniqueId;
            }
            l lVar = this.w;
            if (lVar != null) {
                lVar.n = bdUniqueId;
            }
            z zVar = this.u;
            if (zVar != null) {
                zVar.m = bdUniqueId;
            }
            c.a.r0.h1.h.h.a aVar = this.f18438e;
            if (aVar != null) {
                aVar.k0(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.m = bdUniqueId;
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.m = bdUniqueId;
            }
            w wVar = this.z;
            if (wVar != null) {
                wVar.n = bdUniqueId;
            }
            v vVar = this.A;
            if (vVar != null) {
                vVar.n = bdUniqueId;
            }
            u uVar = this.C;
            if (uVar != null) {
                uVar.n = bdUniqueId;
            }
            x xVar = this.B;
            if (xVar != null) {
                xVar.n = bdUniqueId;
            }
            n nVar2 = this.D;
            if (nVar2 != null) {
                nVar2.n = bdUniqueId;
            }
            q qVar = this.E;
            if (qVar != null) {
                qVar.m = bdUniqueId;
            }
            r rVar = this.F;
            if (rVar != null) {
                rVar.m = bdUniqueId;
            }
            t tVar = this.G;
            if (tVar != null) {
                tVar.m = bdUniqueId;
            }
            c.a.r0.h1.h.h.c cVar = this.H;
            if (cVar != null) {
                cVar.n = bdUniqueId;
            }
            c.a.r0.h1.h.h.d dVar = this.v;
            if (dVar != null) {
                dVar.m = bdUniqueId;
            }
            c.a.r0.h1.c.e.z zVar2 = this.I;
            if (zVar2 != null) {
                zVar2.n = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.Q)) {
                for (c.a.e.l.e.a aVar2 : this.Q) {
                    if (aVar2 instanceof c.a.r0.q1.o.g.a) {
                        ((c.a.r0.q1.o.g.a) aVar2).setUniqueId(bdUniqueId);
                    }
                }
            }
            this.V.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.V);
            this.W.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.W);
            this.X.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.X);
            this.Y.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.Y);
            if (this.S) {
                return;
            }
            this.U.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.U);
        }
    }

    public void x(c.a.r0.h1.h.k.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, fVar) == null) {
            this.f18441h.r0(fVar);
            this.f18442i.p0(fVar);
            this.f18443j.o0(fVar);
            this.l.o0(fVar);
            this.m.p0(fVar);
            this.q.n0(fVar);
            this.r.o0(fVar);
            this.s.o0(fVar);
            this.t.o0(fVar);
            this.u.r0(fVar);
            this.v.p0(fVar);
        }
    }

    public final void y(c.a.e.l.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, sVar) == null) {
            this.f18442i.q0(sVar);
            this.f18443j.p0(sVar);
            this.k.o0(sVar);
            this.l.p0(sVar);
            this.m.q0(sVar);
            this.n.j0(sVar);
            this.o.k0(sVar);
            this.p.j0(sVar);
            this.q.o0(sVar);
            this.r.p0(sVar);
            this.s.p0(sVar);
            this.t.p0(sVar);
            this.v.q0(sVar);
            this.u.s0(sVar);
            this.H.p0(sVar);
            this.A.s0(sVar);
            this.A.s0(sVar);
            this.C.p0(sVar);
            this.I.j0(sVar);
        }
    }

    public void z(List<c.a.e.l.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, list) == null) {
            c.a.r0.k3.w.f(list, 2);
            this.f18435b.setData(list);
            this.f18436c = list;
            f fVar = this.T;
            if (fVar != null) {
                fVar.a();
            }
        }
    }
}
