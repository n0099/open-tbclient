package c.a.p0.q1.i.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes2.dex */
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
    public c.a.p0.q1.i.h.c H;
    public a0 I;
    public c.a.p0.q1.d.e.a0 J;
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
    public c.a.d.o.e.s f17406b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.d.o.e.n> f17407c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext<?> f17408d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.q1.i.h.a f17409e;

    /* renamed from: f  reason: collision with root package name */
    public b0 f17410f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.q1.i.h.b f17411g;

    /* renamed from: h  reason: collision with root package name */
    public n f17412h;
    public y i;
    public h j;
    public i k;
    public j l;
    public s m;
    public k n;
    public p o;
    public m p;
    public o q;
    public c.a.p0.q1.i.h.g r;
    public c.a.p0.q1.i.h.f s;
    public c.a.p0.q1.i.h.e t;
    public z u;
    public c.a.p0.q1.i.h.d v;
    public l w;
    public HomePageAlaLiveThreadAdapter x;
    public HomePageAlaFriendRoomAdapter y;
    public w z;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d0 f17413b;

        public a(d0 d0Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d0Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17413b = d0Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f17413b.f17406b.setData(this.a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d0 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d0 d0Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d0Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (this.a.f17407c != null) {
                d0 d0Var = this.a;
                d0Var.A(d0Var.f17407c);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d0 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(d0 d0Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d0Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes2.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d0 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(d0 d0Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d0Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                c.a.p0.b2.p.b bVar = new c.a.p0.b2.p.b();
                bVar.a = String.valueOf(customResponsedMessage.getData());
                bVar.f12556b = true;
                this.a.h(bVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d0 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(d0 d0Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d0Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                c.a.p0.b2.p.b bVar = new c.a.p0.b2.p.b();
                bVar.a = String.valueOf(customResponsedMessage.getData());
                bVar.f12556b = false;
                this.a.h(bVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d0 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(d0 d0Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d0Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            c.a.e.m.e.b j;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (StringUtils.isNull(str, true) || (j = this.a.j(str)) == null) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, j));
            }
        }
    }

    /* loaded from: classes2.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.f17406b = sVar;
        this.f17408d = (TbPageContext) c.a.d.a.j.a(context);
        k(context);
        z(sVar);
        sVar.a(this.a);
    }

    public void A(List<c.a.d.o.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            c.a.p0.a4.x.f(list, 2);
            this.f17406b.setData(list);
            this.f17407c = list;
            g gVar = this.U;
            if (gVar != null) {
                gVar.a();
            }
        }
    }

    public void B(List<c.a.d.o.e.n> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, i) == null) {
            c.a.p0.a4.x.f(list, 2);
            ViewGroup listView = this.f17406b.getListView();
            if (i > 0 && (listView instanceof BdRecyclerView)) {
                BdRecyclerView bdRecyclerView = (BdRecyclerView) listView;
                int firstVisiblePosition = bdRecyclerView.getFirstVisiblePosition();
                View childAt = bdRecyclerView.getChildAt(0);
                int top = childAt != null ? childAt.getTop() : 0;
                RecyclerView.LayoutManager layoutManager = bdRecyclerView.getLayoutManager();
                int i2 = firstVisiblePosition - i;
                if (layoutManager instanceof LinearLayoutManager) {
                    bdRecyclerView.A();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top);
                    bdRecyclerView.B();
                }
            }
            c.a.d.f.m.i.b(new a(this, list));
            this.f17407c = list;
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
                ArrayList<BdUniqueId> g2 = c.a.p0.a4.x.g();
                if (g2 == null || g2.size() <= 0) {
                    return false;
                }
                int size = g2.size();
                for (int i = 0; i < size; i++) {
                    c.a.p0.b2.o.g.a b2 = c.a.p0.b2.r.b.d().b(this.f17408d, g2.get(i), 2);
                    if (this.S) {
                        b2.Z(3);
                    }
                    n nVar = this.f17412h;
                    if (nVar != null && (bdUniqueId = nVar.j) != null) {
                        b2.setUniqueId(bdUniqueId);
                    }
                    this.R.add(b2);
                }
                this.f17406b.a(this.R);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void h(Object obj) {
        List<c.a.d.o.e.n> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, obj) == null) || (list = this.f17407c) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f17407c : (List) invokeV.objValue;
    }

    public final c.a.e.m.e.b j(String str) {
        InterceptResult invokeL;
        int i;
        c.a.p0.h0.e0.l lVar;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            List<c.a.d.o.e.n> list = this.f17407c;
            if (list == null || list.isEmpty() || str == null) {
                return null;
            }
            c.a.e.m.e.b bVar = new c.a.e.m.e.b();
            int i2 = 0;
            int i3 = 0;
            boolean z = false;
            int i4 = 0;
            int i5 = -1;
            int i6 = -1;
            while (true) {
                if (i2 >= this.f17407c.size()) {
                    i = -1;
                    break;
                }
                if (this.f17407c.get(i2) instanceof c.a.p0.q1.i.j.h) {
                    i3++;
                }
                if (this.f17407c.get(i2) instanceof c.a.p0.q1.i.j.a) {
                    if (m(this.f17407c.get(i2))) {
                        if (z) {
                            i = ((c.a.p0.q1.i.j.a) this.f17407c.get(i2)).position;
                            break;
                        }
                        i5 = ((c.a.p0.q1.i.j.a) this.f17407c.get(i2)).position;
                    } else if (z) {
                        i4++;
                    }
                }
                if ((this.f17407c.get(i2) instanceof c.a.p0.h0.e0.l) && (lVar = (c.a.p0.h0.e0.l) this.f17407c.get(i2)) != null && (threadData = lVar.a) != null && str.equals(threadData.getId())) {
                    i6 = ((c.a.p0.h0.e0.l) this.f17407c.get(i2)).position;
                    z = true;
                }
                i2++;
            }
            if (i != -1 && (i = i - i4) < -1) {
                i = -1;
            }
            bVar.h(str);
            int i7 = i6 - i3;
            bVar.e(i7 >= -1 ? i7 : -1);
            bVar.g(i5);
            bVar.f(i);
            return bVar;
        }
        return (c.a.e.m.e.b) invokeL.objValue;
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            this.f17409e = new c.a.p0.q1.i.h.a(this.f17408d);
            this.f17410f = new b0(this.f17408d);
            this.f17411g = new c.a.p0.q1.i.h.b(this.f17408d, c.a.p0.q1.i.j.f.f17448b);
            this.f17412h = new n(this.f17408d, c.a.p0.h0.e0.k.o0);
            this.i = new y(this.f17408d, c.a.p0.h0.e0.k.z0);
            this.j = new h(this.f17408d, c.a.p0.h0.e0.k.H0);
            this.k = new i(this.f17408d, c.a.p0.h0.e0.k.A0);
            this.l = new j(this.f17408d, c.a.p0.h0.e0.k.I0);
            this.m = new s(this.f17408d, c.a.p0.h0.e0.k.G0);
            this.n = new k(this.f17408d, c.a.p0.h0.e0.k.J0);
            this.o = new p(this.f17408d, c.a.p0.h0.e0.k.K0);
            this.p = new m(this.f17408d, c.a.p0.h0.e0.k.L0);
            this.q = new o(this.f17408d, c.a.p0.h0.e0.k.M0);
            this.r = new c.a.p0.q1.i.h.g(this.f17408d, c.a.p0.h0.e0.k.B0);
            this.s = new c.a.p0.q1.i.h.f(this.f17408d, c.a.p0.h0.e0.k.C0);
            this.t = new c.a.p0.q1.i.h.e(this.f17408d, c.a.p0.h0.e0.k.D0);
            this.u = new z(this.f17408d, c.a.p0.h0.e0.l.U);
            this.w = new l(this.f17408d, c.a.p0.h0.e0.k.q0);
            this.x = new HomePageAlaLiveThreadAdapter(this.f17408d, c.a.p0.h0.e0.j.N0);
            this.I = new a0(this.f17408d, c.a.p0.h0.e0.k.F0);
            this.y = new HomePageAlaFriendRoomAdapter(this.f17408d, c.a.p0.h0.e0.j.O0);
            this.z = new w(this.f17408d, c.a.p0.h0.e0.k.r0);
            this.A = new v(this.f17408d, c.a.p0.h0.e0.k.s0);
            this.B = new x(this.f17408d, c.a.p0.h0.e0.k.u0);
            this.C = new u(this.f17408d, c.a.p0.h0.e0.k.t0);
            this.D = new n(this.f17408d, c.a.p0.h0.e0.k.p0);
            this.E = new q(this.f17408d, c.a.p0.h0.e0.k.v0);
            this.F = new r(this.f17408d, c.a.p0.h0.e0.k.w0);
            this.G = new t(this.f17408d, c.a.p0.q1.l.c.c.a.j0);
            this.H = new c.a.p0.q1.i.h.c(this.f17408d, c.a.p0.h0.e0.e.N0);
            this.v = new c.a.p0.q1.i.h.d(this.f17408d, c.a.p0.h0.e0.k.E0);
            this.J = new c.a.p0.q1.d.e.a0(this.f17408d, c.a.p0.h0.e0.k.x0, (byte) 3);
            this.a.add(this.f17409e);
            this.a.add(this.f17410f);
            this.a.add(this.f17411g);
            this.a.add(this.f17412h);
            this.a.add(this.i);
            this.a.add(this.j);
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
            this.a.add(new ReadProgessDelegetAdapter(this.f17408d, c.a.p0.q1.i.l.b.f17478c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.A);
            this.a.add(this.C);
            this.a.add(this.B);
            this.a.add(new c0(this.f17408d, c.a.p0.q1.i.j.h.f17449e));
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
            if (!ThreadData.isRecAppLoaded.get()) {
                AdvertAppInfo.v.set(false);
                return;
            }
            this.K = c.a.p0.l3.z.q().j(this.f17408d, AdvertAppInfo.y, "INDEX");
            this.L = c.a.p0.l3.z.q().j(this.f17408d, AdvertAppInfo.z, "INDEX");
            this.M = c.a.p0.l3.z.q().j(this.f17408d, AdvertAppInfo.A, "INDEX");
            this.N = c.a.p0.l3.z.q().j(this.f17408d, AdvertAppInfo.B, "INDEX");
            this.O = c.a.p0.l3.z.q().j(this.f17408d, AdvertAppInfo.C, "INDEX");
            this.P = c.a.p0.l3.z.q().j(this.f17408d, AdvertAppInfo.E, "INDEX");
            this.Q = c.a.p0.l3.z.q().j(this.f17408d, AdvertAppInfo.D, "INDEX");
            this.a.add(this.K);
            this.a.add(this.L);
            this.a.add(this.M);
            this.a.add(this.N);
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            if (this.f17408d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(c.a.p0.g1.c.e().c((BaseFragmentActivity) this.f17408d.getPageActivity(), AdvertAppInfo.H));
                this.a.add(c.a.p0.g1.c.e().c((BaseFragmentActivity) this.f17408d.getPageActivity(), AdvertAppInfo.G));
            }
            AdvertAppInfo.v.set(true);
        }
    }

    public final boolean m(c.a.d.o.e.n nVar) {
        InterceptResult invokeL;
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, nVar)) == null) ? nVar != null && (nVar instanceof c.a.p0.q1.i.j.a) && (advertAppInfo = ((c.a.p0.q1.i.j.a) nVar).a) != null && advertAppInfo.q() == 0 : invokeL.booleanValue;
    }

    public void n() {
        c.a.d.o.e.s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (sVar = this.f17406b) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            n();
            this.f17409e.Z(i);
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
            if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                return;
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
            if (aVar instanceof c.a.p0.v.f) {
                ((c.a.p0.v.f) aVar).g(str);
            }
        }
    }

    public void t(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            for (c.a.d.o.e.a aVar2 : this.a) {
                if (aVar2 instanceof c.a.p0.q1.a) {
                    ((c.a.p0.q1.a) aVar2).Z(aVar);
                }
            }
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            n nVar = this.f17412h;
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
            c.a.p0.q1.i.h.d dVar = this.v;
            if (dVar != null) {
                dVar.setFromCDN(z);
            }
            c.a.d.o.e.a aVar = this.L;
            if (aVar == null || !(aVar instanceof c.a.p0.l3.u)) {
                return;
            }
            ((c.a.p0.l3.u) aVar).k(z);
        }
    }

    public void v(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            n nVar = this.f17412h;
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
            c.a.p0.q1.i.h.c cVar = this.H;
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
            c.a.p0.q1.i.h.b bVar = this.f17411g;
            if (bVar != null) {
                bVar.b0(bdUniqueId);
            }
            n nVar = this.f17412h;
            if (nVar != null) {
                nVar.j = bdUniqueId;
            }
            y yVar = this.i;
            if (yVar != null) {
                yVar.j = bdUniqueId;
            }
            h hVar = this.j;
            if (hVar != null) {
                hVar.i = bdUniqueId;
            }
            i iVar = this.k;
            if (iVar != null) {
                iVar.i = bdUniqueId;
            }
            j jVar = this.l;
            if (jVar != null) {
                jVar.i = bdUniqueId;
            }
            s sVar = this.m;
            if (sVar != null) {
                sVar.i = bdUniqueId;
            }
            k kVar = this.n;
            if (kVar != null) {
                kVar.i = bdUniqueId;
            }
            p pVar = this.o;
            if (pVar != null) {
                pVar.i = bdUniqueId;
            }
            m mVar = this.p;
            if (mVar != null) {
                mVar.i = bdUniqueId;
            }
            o oVar = this.q;
            if (oVar != null) {
                oVar.i = bdUniqueId;
            }
            c.a.p0.q1.i.h.g gVar = this.r;
            if (gVar != null) {
                gVar.i = bdUniqueId;
            }
            c.a.p0.q1.i.h.f fVar = this.s;
            if (fVar != null) {
                fVar.i = bdUniqueId;
            }
            c.a.p0.q1.i.h.e eVar = this.t;
            if (eVar != null) {
                eVar.i = bdUniqueId;
            }
            l lVar = this.w;
            if (lVar != null) {
                lVar.j = bdUniqueId;
            }
            z zVar = this.u;
            if (zVar != null) {
                zVar.i = bdUniqueId;
            }
            c.a.p0.q1.i.h.a aVar = this.f17409e;
            if (aVar != null) {
                aVar.c0(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.i = bdUniqueId;
            }
            a0 a0Var = this.I;
            if (a0Var != null) {
                a0Var.i = bdUniqueId;
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.i = bdUniqueId;
            }
            w wVar = this.z;
            if (wVar != null) {
                wVar.j = bdUniqueId;
            }
            v vVar = this.A;
            if (vVar != null) {
                vVar.j = bdUniqueId;
            }
            u uVar = this.C;
            if (uVar != null) {
                uVar.j = bdUniqueId;
            }
            x xVar = this.B;
            if (xVar != null) {
                xVar.j = bdUniqueId;
            }
            n nVar2 = this.D;
            if (nVar2 != null) {
                nVar2.j = bdUniqueId;
            }
            q qVar = this.E;
            if (qVar != null) {
                qVar.i = bdUniqueId;
            }
            r rVar = this.F;
            if (rVar != null) {
                rVar.i = bdUniqueId;
            }
            t tVar = this.G;
            if (tVar != null) {
                tVar.i = bdUniqueId;
            }
            c.a.p0.q1.i.h.c cVar = this.H;
            if (cVar != null) {
                cVar.j = bdUniqueId;
            }
            c.a.p0.q1.i.h.d dVar = this.v;
            if (dVar != null) {
                dVar.i = bdUniqueId;
            }
            c.a.p0.q1.d.e.a0 a0Var2 = this.J;
            if (a0Var2 != null) {
                a0Var2.j = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.R)) {
                for (c.a.d.o.e.a aVar2 : this.R) {
                    if (aVar2 instanceof c.a.p0.b2.o.g.a) {
                        ((c.a.p0.b2.o.g.a) aVar2).setUniqueId(bdUniqueId);
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

    public void y(c.a.p0.q1.i.k.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, fVar) == null) {
            this.f17412h.j0(fVar);
            this.i.i0(fVar);
            this.j.g0(fVar);
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
            this.i.j0(sVar);
            this.j.h0(sVar);
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
