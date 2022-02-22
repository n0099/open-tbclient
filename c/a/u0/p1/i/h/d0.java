package c.a.u0.p1.i.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.t0.s.r.e2;
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
/* loaded from: classes8.dex */
public class d0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public v A;
    public x B;
    public u C;
    public n D;
    public q E;
    public r F;
    public t G;
    public c.a.u0.p1.i.h.c H;
    public a0 I;
    public c.a.u0.p1.d.e.a0 J;
    public c.a.d.o.e.a K;
    public c.a.d.o.e.a L;
    public c.a.d.o.e.a M;
    public c.a.d.o.e.a N;
    public c.a.d.o.e.a O;
    public c.a.d.o.e.a P;
    public c.a.d.o.e.a Q;
    public List<c.a.d.o.e.a> R;
    public boolean S;
    public boolean T;
    public g U;
    public CustomMessageListener V;
    public CustomMessageListener W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public CustomMessageListener Z;
    public List<c.a.d.o.e.a> a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.d.o.e.s f20683b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.d.o.e.n> f20684c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext<?> f20685d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.u0.p1.i.h.a f20686e;

    /* renamed from: f  reason: collision with root package name */
    public b0 f20687f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.u0.p1.i.h.b f20688g;

    /* renamed from: h  reason: collision with root package name */
    public n f20689h;

    /* renamed from: i  reason: collision with root package name */
    public y f20690i;

    /* renamed from: j  reason: collision with root package name */
    public h f20691j;
    public i k;
    public j l;
    public s m;
    public k n;
    public p o;
    public m p;
    public o q;
    public c.a.u0.p1.i.h.g r;
    public c.a.u0.p1.i.h.f s;
    public c.a.u0.p1.i.h.e t;
    public z u;
    public c.a.u0.p1.i.h.d v;
    public l w;
    public HomePageAlaLiveThreadAdapter x;
    public HomePageAlaFriendRoomAdapter y;
    public w z;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f20692e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d0 f20693f;

        public a(d0 d0Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d0Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20693f = d0Var;
            this.f20692e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20693f.f20683b.setData(this.f20692e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d0 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d0 d0Var, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d0Var, Integer.valueOf(i2)};
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
            this.a = d0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.a.g();
            if (this.a.f20684c != null) {
                d0 d0Var = this.a;
                d0Var.A(d0Var.f20684c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d0 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(d0 d0Var, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d0Var, Integer.valueOf(i2)};
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
            this.a = d0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().a) {
                return;
            }
            this.a.h(updateAttentionMessage.getData());
        }
    }

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d0 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(d0 d0Var, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d0Var, Integer.valueOf(i2)};
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
            this.a = d0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                c.a.u0.z1.p.b bVar = new c.a.u0.z1.p.b();
                bVar.a = String.valueOf(customResponsedMessage.getData());
                bVar.f25803b = true;
                this.a.h(bVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d0 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(d0 d0Var, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d0Var, Integer.valueOf(i2)};
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
            this.a = d0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                c.a.u0.z1.p.b bVar = new c.a.u0.z1.p.b();
                bVar.a = String.valueOf(customResponsedMessage.getData());
                bVar.f25803b = false;
                this.a.h(bVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d0 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(d0 d0Var, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d0Var, Integer.valueOf(i2)};
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
            this.a = d0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.a.e.m.e.b j2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (StringUtils.isNull(str, true) || (j2 = this.a.j(str)) == null) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, j2));
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface g {
        void a();
    }

    public d0(Context context, c.a.d.o.e.s sVar) {
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
        this.V = new b(this, 2016470);
        this.W = new c(this, 2001115);
        this.X = new d(this, 2001335);
        this.Y = new e(this, 2001336);
        this.Z = new f(this, 2921394);
        this.a = new ArrayList();
        this.f20683b = sVar;
        this.f20685d = (TbPageContext) c.a.d.a.j.a(context);
        k(context);
        z(sVar);
        sVar.addAdapters(this.a);
    }

    public void A(List<c.a.d.o.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            c.a.u0.z3.x.f(list, 2);
            this.f20683b.setData(list);
            this.f20684c = list;
            g gVar = this.U;
            if (gVar != null) {
                gVar.a();
            }
        }
    }

    public void B(List<c.a.d.o.e.n> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, i2) == null) {
            c.a.u0.z3.x.f(list, 2);
            ViewGroup listView = this.f20683b.getListView();
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
            c.a.d.f.m.i.b(new a(this, list));
            this.f20684c = list;
            g gVar = this.U;
            if (gVar != null) {
                gVar.a();
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.T = g();
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<c.a.d.o.e.a> list = this.R;
            if (list == null || list.size() <= 0) {
                this.R = new ArrayList();
                ArrayList<BdUniqueId> g2 = c.a.u0.z3.x.g();
                if (g2 == null || g2.size() <= 0) {
                    return false;
                }
                int size = g2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    c.a.u0.z1.o.g.a b2 = c.a.u0.z1.r.b.d().b(this.f20685d, g2.get(i2), 2);
                    if (this.S) {
                        b2.Z(3);
                    }
                    n nVar = this.f20689h;
                    if (nVar != null && (bdUniqueId = nVar.n) != null) {
                        b2.setUniqueId(bdUniqueId);
                    }
                    this.R.add(b2);
                }
                this.f20683b.addAdapters(this.R);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void h(Object obj) {
        List<c.a.d.o.e.n> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, obj) == null) || (list = this.f20684c) == null) {
            return;
        }
        boolean z = false;
        for (c.a.d.o.e.n nVar : list) {
            if ((nVar instanceof ICardInfo) && ((ICardInfo) nVar).responseAttention(obj)) {
                z = true;
            }
        }
        if (z) {
            n();
        }
    }

    public List<c.a.d.o.e.n> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f20684c : (List) invokeV.objValue;
    }

    public final c.a.e.m.e.b j(String str) {
        InterceptResult invokeL;
        int i2;
        c.a.u0.g0.d0.l lVar;
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            List<c.a.d.o.e.n> list = this.f20684c;
            if (list == null || list.isEmpty() || str == null) {
                return null;
            }
            c.a.e.m.e.b bVar = new c.a.e.m.e.b();
            int i3 = 0;
            int i4 = 0;
            boolean z = false;
            int i5 = 0;
            int i6 = -1;
            int i7 = -1;
            while (true) {
                if (i3 >= this.f20684c.size()) {
                    i2 = -1;
                    break;
                }
                if (this.f20684c.get(i3) instanceof c.a.u0.p1.i.j.h) {
                    i4++;
                }
                if (this.f20684c.get(i3) instanceof c.a.u0.p1.i.j.a) {
                    if (m(this.f20684c.get(i3))) {
                        if (z) {
                            i2 = ((c.a.u0.p1.i.j.a) this.f20684c.get(i3)).position;
                            break;
                        }
                        i6 = ((c.a.u0.p1.i.j.a) this.f20684c.get(i3)).position;
                    } else if (z) {
                        i5++;
                    }
                }
                if ((this.f20684c.get(i3) instanceof c.a.u0.g0.d0.l) && (lVar = (c.a.u0.g0.d0.l) this.f20684c.get(i3)) != null && (e2Var = lVar.f17886e) != null && str.equals(e2Var.h0())) {
                    i7 = ((c.a.u0.g0.d0.l) this.f20684c.get(i3)).position;
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
        return (c.a.e.m.e.b) invokeL.objValue;
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            this.f20686e = new c.a.u0.p1.i.h.a(this.f20685d);
            this.f20687f = new b0(this.f20685d);
            this.f20688g = new c.a.u0.p1.i.h.b(this.f20685d, c.a.u0.p1.i.j.f.f20747f);
            this.f20689h = new n(this.f20685d, c.a.u0.g0.d0.k.s0);
            this.f20690i = new y(this.f20685d, c.a.u0.g0.d0.k.D0);
            this.f20691j = new h(this.f20685d, c.a.u0.g0.d0.k.L0);
            this.k = new i(this.f20685d, c.a.u0.g0.d0.k.E0);
            this.l = new j(this.f20685d, c.a.u0.g0.d0.k.M0);
            this.m = new s(this.f20685d, c.a.u0.g0.d0.k.K0);
            this.n = new k(this.f20685d, c.a.u0.g0.d0.k.N0);
            this.o = new p(this.f20685d, c.a.u0.g0.d0.k.O0);
            this.p = new m(this.f20685d, c.a.u0.g0.d0.k.P0);
            this.q = new o(this.f20685d, c.a.u0.g0.d0.k.Q0);
            this.r = new c.a.u0.p1.i.h.g(this.f20685d, c.a.u0.g0.d0.k.F0);
            this.s = new c.a.u0.p1.i.h.f(this.f20685d, c.a.u0.g0.d0.k.G0);
            this.t = new c.a.u0.p1.i.h.e(this.f20685d, c.a.u0.g0.d0.k.H0);
            this.u = new z(this.f20685d, c.a.u0.g0.d0.l.Y);
            this.w = new l(this.f20685d, c.a.u0.g0.d0.k.u0);
            this.x = new HomePageAlaLiveThreadAdapter(this.f20685d, c.a.u0.g0.d0.j.R0);
            this.I = new a0(this.f20685d, c.a.u0.g0.d0.k.J0);
            this.y = new HomePageAlaFriendRoomAdapter(this.f20685d, c.a.u0.g0.d0.j.S0);
            this.z = new w(this.f20685d, c.a.u0.g0.d0.k.v0);
            this.A = new v(this.f20685d, c.a.u0.g0.d0.k.w0);
            this.B = new x(this.f20685d, c.a.u0.g0.d0.k.y0);
            this.C = new u(this.f20685d, c.a.u0.g0.d0.k.x0);
            this.D = new n(this.f20685d, c.a.u0.g0.d0.k.t0);
            this.E = new q(this.f20685d, c.a.u0.g0.d0.k.z0);
            this.F = new r(this.f20685d, c.a.u0.g0.d0.k.A0);
            this.G = new t(this.f20685d, c.a.u0.p1.l.c.c.a.h0);
            this.H = new c.a.u0.p1.i.h.c(this.f20685d, c.a.u0.g0.d0.e.R0);
            this.v = new c.a.u0.p1.i.h.d(this.f20685d, c.a.u0.g0.d0.k.I0);
            this.J = new c.a.u0.p1.d.e.a0(this.f20685d, c.a.u0.g0.d0.k.B0, (byte) 3);
            this.a.add(this.f20686e);
            this.a.add(this.f20687f);
            this.a.add(this.f20688g);
            this.a.add(this.f20689h);
            this.a.add(this.f20690i);
            this.a.add(this.f20691j);
            this.a.add(this.k);
            this.a.add(this.l);
            this.a.add(this.m);
            this.a.add(this.n);
            this.a.add(this.o);
            this.a.add(this.p);
            this.a.add(this.q);
            this.a.add(this.r);
            this.a.add(this.s);
            this.a.add(this.t);
            this.a.add(this.u);
            this.a.add(this.w);
            this.a.add(this.D);
            this.a.add(new ReadProgessDelegetAdapter(this.f20685d, c.a.u0.p1.i.l.b.f20793g));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.A);
            this.a.add(this.C);
            this.a.add(this.B);
            this.a.add(new c0(this.f20685d, c.a.u0.p1.i.j.h.f20749i));
            this.a.add(this.E);
            this.a.add(this.F);
            this.a.add(this.G);
            this.a.add(this.H);
            this.a.add(this.v);
            this.a.add(this.J);
            this.a.add(this.I);
            f();
            l();
            s("page_recommend");
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (!e2.X3.get()) {
                AdvertAppInfo.A4.set(false);
                return;
            }
            this.K = c.a.u0.l3.y.q().j(this.f20685d, AdvertAppInfo.D4, "INDEX");
            this.L = c.a.u0.l3.y.q().j(this.f20685d, AdvertAppInfo.E4, "INDEX");
            this.M = c.a.u0.l3.y.q().j(this.f20685d, AdvertAppInfo.F4, "INDEX");
            this.N = c.a.u0.l3.y.q().j(this.f20685d, AdvertAppInfo.G4, "INDEX");
            this.O = c.a.u0.l3.y.q().j(this.f20685d, AdvertAppInfo.H4, "INDEX");
            this.P = c.a.u0.l3.y.q().j(this.f20685d, AdvertAppInfo.J4, "INDEX");
            this.Q = c.a.u0.l3.y.q().j(this.f20685d, AdvertAppInfo.I4, "INDEX");
            this.a.add(this.K);
            this.a.add(this.L);
            this.a.add(this.M);
            this.a.add(this.N);
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            if (this.f20685d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(c.a.u0.f1.b.e().c((BaseFragmentActivity) this.f20685d.getPageActivity(), AdvertAppInfo.M4));
                this.a.add(c.a.u0.f1.b.e().c((BaseFragmentActivity) this.f20685d.getPageActivity(), AdvertAppInfo.L4));
            }
            AdvertAppInfo.A4.set(true);
        }
    }

    public final boolean m(c.a.d.o.e.n nVar) {
        InterceptResult invokeL;
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, nVar)) == null) ? nVar != null && (nVar instanceof c.a.u0.p1.i.j.a) && (advertAppInfo = ((c.a.u0.p1.i.j.a) nVar).f17892e) != null && advertAppInfo.Z4() == 0 : invokeL.booleanValue;
    }

    public void n() {
        c.a.d.o.e.s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (sVar = this.f20683b) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            n();
            this.f20686e.Z(i2);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    public void q() {
        z zVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (zVar = this.u) == null) {
            return;
        }
        zVar.onPause();
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            z zVar = this.u;
            if (zVar != null) {
                zVar.onResume();
            }
            n();
        }
    }

    public final void s(String str) {
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || (list = this.a) == null) {
            return;
        }
        for (c.a.d.o.e.a aVar : list) {
            if (aVar instanceof c.a.u0.t.f) {
                ((c.a.u0.t.f) aVar).g(str);
            }
        }
    }

    public void t(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            for (c.a.d.o.e.a aVar2 : this.a) {
                if (aVar2 instanceof c.a.u0.p1.a) {
                    ((c.a.u0.p1.a) aVar2).Z(aVar);
                }
            }
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            n nVar = this.f20689h;
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
            c.a.u0.p1.i.h.d dVar = this.v;
            if (dVar != null) {
                dVar.setFromCDN(z);
            }
            c.a.d.o.e.a aVar = this.L;
            if (aVar == null || !(aVar instanceof c.a.u0.l3.t)) {
                return;
            }
            ((c.a.u0.l3.t) aVar).k(z);
        }
    }

    public void v(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            n nVar = this.f20689h;
            if (nVar != null) {
                nVar.i0(bVar);
            }
            s sVar = this.m;
            if (sVar != null) {
                sVar.g0(bVar);
            }
            i iVar = this.k;
            if (iVar != null) {
                iVar.f0(bVar);
            }
            l lVar = this.w;
            if (lVar != null) {
                lVar.e0(bVar);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.e0(bVar);
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.e0(bVar);
            }
            w wVar = this.z;
            if (wVar != null) {
                wVar.e0(bVar);
            }
            v vVar = this.A;
            if (vVar != null) {
                vVar.j0(bVar);
            }
            u uVar = this.C;
            if (uVar != null) {
                uVar.g0(bVar);
            }
            x xVar = this.B;
            if (xVar != null) {
                xVar.h0(bVar);
            }
            n nVar2 = this.D;
            if (nVar2 != null) {
                nVar2.i0(bVar);
            }
            q qVar = this.E;
            if (qVar != null) {
                qVar.h0(bVar);
            }
            r rVar = this.F;
            if (rVar != null) {
                rVar.g0(bVar);
            }
            t tVar = this.G;
            if (tVar != null) {
                tVar.c0(bVar);
            }
            c.a.u0.p1.i.h.c cVar = this.H;
            if (cVar != null) {
                cVar.g0(bVar);
            }
        }
    }

    public void w(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, gVar) == null) {
            this.U = gVar;
        }
    }

    public void x(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bdUniqueId) == null) {
            c.a.u0.p1.i.h.b bVar = this.f20688g;
            if (bVar != null) {
                bVar.b0(bdUniqueId);
            }
            n nVar = this.f20689h;
            if (nVar != null) {
                nVar.n = bdUniqueId;
            }
            y yVar = this.f20690i;
            if (yVar != null) {
                yVar.n = bdUniqueId;
            }
            h hVar = this.f20691j;
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
            c.a.u0.p1.i.h.g gVar = this.r;
            if (gVar != null) {
                gVar.m = bdUniqueId;
            }
            c.a.u0.p1.i.h.f fVar = this.s;
            if (fVar != null) {
                fVar.m = bdUniqueId;
            }
            c.a.u0.p1.i.h.e eVar = this.t;
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
            c.a.u0.p1.i.h.a aVar = this.f20686e;
            if (aVar != null) {
                aVar.c0(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.m = bdUniqueId;
            }
            a0 a0Var = this.I;
            if (a0Var != null) {
                a0Var.m = bdUniqueId;
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
            c.a.u0.p1.i.h.c cVar = this.H;
            if (cVar != null) {
                cVar.n = bdUniqueId;
            }
            c.a.u0.p1.i.h.d dVar = this.v;
            if (dVar != null) {
                dVar.m = bdUniqueId;
            }
            c.a.u0.p1.d.e.a0 a0Var2 = this.J;
            if (a0Var2 != null) {
                a0Var2.n = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.R)) {
                for (c.a.d.o.e.a aVar2 : this.R) {
                    if (aVar2 instanceof c.a.u0.z1.o.g.a) {
                        ((c.a.u0.z1.o.g.a) aVar2).setUniqueId(bdUniqueId);
                    }
                }
            }
            this.W.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.W);
            this.X.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.X);
            this.Y.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.Y);
            this.Z.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.Z);
            if (this.T) {
                return;
            }
            this.V.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.V);
        }
    }

    public void y(c.a.u0.p1.i.k.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, fVar) == null) {
            this.f20689h.j0(fVar);
            this.f20690i.i0(fVar);
            this.f20691j.g0(fVar);
            this.l.g0(fVar);
            this.m.h0(fVar);
            this.q.f0(fVar);
            this.r.g0(fVar);
            this.s.g0(fVar);
            this.t.g0(fVar);
            this.u.j0(fVar);
            this.v.h0(fVar);
        }
    }

    public final void z(c.a.d.o.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, sVar) == null) {
            this.f20690i.j0(sVar);
            this.f20691j.h0(sVar);
            this.k.g0(sVar);
            this.l.h0(sVar);
            this.m.i0(sVar);
            this.n.b0(sVar);
            this.o.c0(sVar);
            this.p.b0(sVar);
            this.q.g0(sVar);
            this.r.h0(sVar);
            this.s.h0(sVar);
            this.t.h0(sVar);
            this.v.i0(sVar);
            this.u.k0(sVar);
            this.H.h0(sVar);
            this.A.k0(sVar);
            this.A.k0(sVar);
            this.C.h0(sVar);
            this.J.b0(sVar);
        }
    }
}
