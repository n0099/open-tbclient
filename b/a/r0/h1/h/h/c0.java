package b.a.r0.h1.h.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.q0.s.q.d2;
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
/* loaded from: classes4.dex */
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
    public b.a.r0.h1.h.h.c H;
    public b.a.r0.h1.c.e.z I;
    public b.a.e.l.e.a J;
    public b.a.e.l.e.a K;
    public b.a.e.l.e.a L;
    public b.a.e.l.e.a M;
    public b.a.e.l.e.a N;
    public b.a.e.l.e.a O;
    public b.a.e.l.e.a P;
    public List<b.a.e.l.e.a> Q;
    public boolean R;
    public boolean S;
    public f T;
    public CustomMessageListener U;
    public CustomMessageListener V;
    public CustomMessageListener W;
    public CustomMessageListener X;
    public CustomMessageListener Y;

    /* renamed from: a  reason: collision with root package name */
    public List<b.a.e.l.e.a> f17369a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.e.l.e.s f17370b;

    /* renamed from: c  reason: collision with root package name */
    public List<b.a.e.l.e.n> f17371c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext<?> f17372d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.h1.h.h.a f17373e;

    /* renamed from: f  reason: collision with root package name */
    public a0 f17374f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.h1.h.h.b f17375g;

    /* renamed from: h  reason: collision with root package name */
    public n f17376h;

    /* renamed from: i  reason: collision with root package name */
    public y f17377i;
    public h j;
    public i k;
    public j l;
    public s m;
    public k n;
    public p o;
    public m p;
    public o q;
    public g r;
    public b.a.r0.h1.h.h.f s;
    public b.a.r0.h1.h.h.e t;
    public z u;
    public b.a.r0.h1.h.h.d v;
    public l w;
    public HomePageAlaLiveThreadAdapter x;
    public HomePageAlaFriendRoomAdapter y;
    public w z;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c0 f17378a;

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
            this.f17378a = c0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f17378a.f();
            if (this.f17378a.f17371c != null) {
                c0 c0Var = this.f17378a;
                c0Var.z(c0Var.f17371c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c0 f17379a;

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
            this.f17379a = c0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().f45667a) {
                return;
            }
            this.f17379a.g(updateAttentionMessage.getData());
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c0 f17380a;

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
            this.f17380a = c0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                b.a.r0.q1.p.b bVar = new b.a.r0.q1.p.b();
                bVar.f22719a = String.valueOf(customResponsedMessage.getData());
                bVar.f22720b = true;
                this.f17380a.g(bVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c0 f17381a;

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
            this.f17381a = c0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                b.a.r0.q1.p.b bVar = new b.a.r0.q1.p.b();
                bVar.f22719a = String.valueOf(customResponsedMessage.getData());
                bVar.f22720b = false;
                this.f17381a.g(bVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c0 f17382a;

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
            this.f17382a = c0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.a.f.m.e.b i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (StringUtils.isNull(str, true) || (i2 = this.f17382a.i(str)) == null) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, i2));
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a();
    }

    public c0(Context context, b.a.e.l.e.s sVar) {
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
        this.f17369a = new ArrayList();
        this.f17370b = sVar;
        this.f17372d = (TbPageContext) b.a.e.a.j.a(context);
        j(context);
        y(sVar);
        sVar.addAdapters(this.f17369a);
    }

    public void A(List<b.a.e.l.e.n> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, list, i2) == null) {
            b.a.r0.l3.w.f(list, 2);
            ViewGroup listView = this.f17370b.getListView();
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
            this.f17370b.setData(list);
            this.f17371c = list;
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
            List<b.a.e.l.e.a> list = this.Q;
            if (list == null || list.size() <= 0) {
                this.Q = new ArrayList();
                ArrayList<BdUniqueId> g2 = b.a.r0.l3.w.g();
                if (g2 == null || g2.size() <= 0) {
                    return false;
                }
                int size = g2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    b.a.r0.q1.o.g.a b2 = b.a.r0.q1.r.b.d().b(this.f17372d, g2.get(i2), 2);
                    if (this.R) {
                        b2.g0(3);
                    }
                    n nVar = this.f17376h;
                    if (nVar != null && (bdUniqueId = nVar.n) != null) {
                        b2.setUniqueId(bdUniqueId);
                    }
                    this.Q.add(b2);
                }
                this.f17370b.addAdapters(this.Q);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void g(Object obj) {
        List<b.a.e.l.e.n> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, obj) == null) || (list = this.f17371c) == null) {
            return;
        }
        boolean z = false;
        for (b.a.e.l.e.n nVar : list) {
            if ((nVar instanceof ICardInfo) && ((ICardInfo) nVar).responseAttention(obj)) {
                z = true;
            }
        }
        if (z) {
            m();
        }
    }

    public List<b.a.e.l.e.n> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f17371c : (List) invokeV.objValue;
    }

    public final b.a.f.m.e.b i(String str) {
        InterceptResult invokeL;
        int i2;
        b.a.r0.b0.e0.l lVar;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            List<b.a.e.l.e.n> list = this.f17371c;
            if (list == null || list.isEmpty() || str == null) {
                return null;
            }
            b.a.f.m.e.b bVar = new b.a.f.m.e.b();
            int i3 = 0;
            int i4 = 0;
            boolean z = false;
            int i5 = 0;
            int i6 = -1;
            int i7 = -1;
            while (true) {
                if (i3 >= this.f17371c.size()) {
                    i2 = -1;
                    break;
                }
                if (this.f17371c.get(i3) instanceof b.a.r0.h1.h.j.h) {
                    i4++;
                }
                if (this.f17371c.get(i3) instanceof b.a.r0.h1.h.j.a) {
                    if (l(this.f17371c.get(i3))) {
                        if (z) {
                            i2 = ((b.a.r0.h1.h.j.a) this.f17371c.get(i3)).position;
                            break;
                        }
                        i6 = ((b.a.r0.h1.h.j.a) this.f17371c.get(i3)).position;
                    } else if (z) {
                        i5++;
                    }
                }
                if ((this.f17371c.get(i3) instanceof b.a.r0.b0.e0.l) && (lVar = (b.a.r0.b0.e0.l) this.f17371c.get(i3)) != null && (d2Var = lVar.f14748e) != null && str.equals(d2Var.f0())) {
                    i7 = ((b.a.r0.b0.e0.l) this.f17371c.get(i3)).position;
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
        return (b.a.f.m.e.b) invokeL.objValue;
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            this.f17373e = new b.a.r0.h1.h.h.a(this.f17372d);
            this.f17374f = new a0(this.f17372d);
            this.f17375g = new b.a.r0.h1.h.h.b(this.f17372d, b.a.r0.h1.h.j.f.f17456f);
            this.f17376h = new n(this.f17372d, b.a.r0.b0.e0.k.s0);
            this.f17377i = new y(this.f17372d, b.a.r0.b0.e0.k.C0);
            this.j = new h(this.f17372d, b.a.r0.b0.e0.k.J0);
            this.k = new i(this.f17372d, b.a.r0.b0.e0.k.D0);
            this.l = new j(this.f17372d, b.a.r0.b0.e0.k.K0);
            this.m = new s(this.f17372d, b.a.r0.b0.e0.k.I0);
            this.n = new k(this.f17372d, b.a.r0.b0.e0.k.L0);
            this.o = new p(this.f17372d, b.a.r0.b0.e0.k.M0);
            this.p = new m(this.f17372d, b.a.r0.b0.e0.k.N0);
            this.q = new o(this.f17372d, b.a.r0.b0.e0.k.O0);
            this.r = new g(this.f17372d, b.a.r0.b0.e0.k.E0);
            this.s = new b.a.r0.h1.h.h.f(this.f17372d, b.a.r0.b0.e0.k.F0);
            this.t = new b.a.r0.h1.h.h.e(this.f17372d, b.a.r0.b0.e0.k.G0);
            this.u = new z(this.f17372d, b.a.r0.b0.e0.l.X);
            this.w = new l(this.f17372d, b.a.r0.b0.e0.k.u0);
            this.x = new HomePageAlaLiveThreadAdapter(this.f17372d, b.a.r0.b0.e0.j.P0);
            this.y = new HomePageAlaFriendRoomAdapter(this.f17372d, b.a.r0.b0.e0.j.Q0);
            this.z = new w(this.f17372d, b.a.r0.b0.e0.k.v0);
            this.A = new v(this.f17372d, b.a.r0.b0.e0.k.w0);
            this.B = new x(this.f17372d, b.a.r0.b0.e0.k.y0);
            this.C = new u(this.f17372d, b.a.r0.b0.e0.k.x0);
            this.D = new n(this.f17372d, b.a.r0.b0.e0.k.t0);
            this.E = new q(this.f17372d, b.a.r0.b0.e0.k.z0);
            this.F = new r(this.f17372d, b.a.r0.b0.e0.k.A0);
            this.G = new t(this.f17372d, b.a.r0.h1.k.b.c.a.k0);
            this.H = new b.a.r0.h1.h.h.c(this.f17372d, b.a.r0.b0.e0.e.P0);
            this.v = new b.a.r0.h1.h.h.d(this.f17372d, b.a.r0.b0.e0.k.H0);
            this.I = new b.a.r0.h1.c.e.z(this.f17372d, b.a.r0.b0.e0.k.B0, (byte) 3);
            this.f17369a.add(this.f17373e);
            this.f17369a.add(this.f17374f);
            this.f17369a.add(this.f17375g);
            this.f17369a.add(this.f17376h);
            this.f17369a.add(this.f17377i);
            this.f17369a.add(this.j);
            this.f17369a.add(this.k);
            this.f17369a.add(this.l);
            this.f17369a.add(this.m);
            this.f17369a.add(this.n);
            this.f17369a.add(this.o);
            this.f17369a.add(this.p);
            this.f17369a.add(this.q);
            this.f17369a.add(this.r);
            this.f17369a.add(this.s);
            this.f17369a.add(this.t);
            this.f17369a.add(this.u);
            this.f17369a.add(this.w);
            this.f17369a.add(this.D);
            this.f17369a.add(new ReadProgessDelegetAdapter(this.f17372d, b.a.r0.h1.h.l.b.f17500g));
            this.f17369a.add(this.x);
            this.f17369a.add(this.y);
            this.f17369a.add(this.z);
            this.f17369a.add(this.A);
            this.f17369a.add(this.C);
            this.f17369a.add(this.B);
            this.f17369a.add(new b0(this.f17372d, b.a.r0.h1.h.j.h.f17458i));
            this.f17369a.add(this.E);
            this.f17369a.add(this.F);
            this.f17369a.add(this.G);
            this.f17369a.add(this.H);
            this.f17369a.add(this.v);
            this.f17369a.add(this.I);
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
            this.J = b.a.r0.z2.y.o().j(this.f17372d, AdvertAppInfo.t4, "INDEX");
            this.K = b.a.r0.z2.y.o().j(this.f17372d, AdvertAppInfo.u4, "INDEX");
            this.L = b.a.r0.z2.y.o().j(this.f17372d, AdvertAppInfo.v4, "INDEX");
            this.M = b.a.r0.z2.y.o().j(this.f17372d, AdvertAppInfo.w4, "INDEX");
            this.N = b.a.r0.z2.y.o().j(this.f17372d, AdvertAppInfo.x4, "INDEX");
            this.O = b.a.r0.z2.y.o().j(this.f17372d, AdvertAppInfo.z4, "INDEX");
            this.P = b.a.r0.z2.y.o().j(this.f17372d, AdvertAppInfo.y4, "INDEX");
            this.f17369a.add(this.J);
            this.f17369a.add(this.K);
            this.f17369a.add(this.L);
            this.f17369a.add(this.M);
            this.f17369a.add(this.N);
            this.f17369a.add(this.O);
            this.f17369a.add(this.P);
            if (this.f17372d.getPageActivity() instanceof BaseFragmentActivity) {
                this.f17369a.add(b.a.r0.y0.b.e().c((BaseFragmentActivity) this.f17372d.getPageActivity(), AdvertAppInfo.C4));
                this.f17369a.add(b.a.r0.y0.b.e().c((BaseFragmentActivity) this.f17372d.getPageActivity(), AdvertAppInfo.B4));
            }
            AdvertAppInfo.q4.set(true);
        }
    }

    public final boolean l(b.a.e.l.e.n nVar) {
        InterceptResult invokeL;
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nVar)) == null) ? nVar != null && (nVar instanceof b.a.r0.h1.h.j.a) && (advertAppInfo = ((b.a.r0.h1.h.j.a) nVar).f14753e) != null && advertAppInfo.U4() == 0 : invokeL.booleanValue;
    }

    public void m() {
        b.a.e.l.e.s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (sVar = this.f17370b) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            m();
            this.f17373e.g0(i2);
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
        List<b.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || (list = this.f17369a) == null) {
            return;
        }
        for (b.a.e.l.e.a aVar : list) {
            if (aVar instanceof b.a.r0.p.f) {
                ((b.a.r0.p.f) aVar).g(str);
            }
        }
    }

    public void s(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
            for (b.a.e.l.e.a aVar2 : this.f17369a) {
                if (aVar2 instanceof b.a.r0.h1.a) {
                    ((b.a.r0.h1.a) aVar2).g0(aVar);
                }
            }
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            n nVar = this.f17376h;
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
            b.a.r0.h1.h.h.d dVar = this.v;
            if (dVar != null) {
                dVar.setFromCDN(z);
            }
            b.a.e.l.e.a aVar = this.K;
            if (aVar == null || !(aVar instanceof b.a.r0.z2.t)) {
                return;
            }
            ((b.a.r0.z2.t) aVar).k(z);
        }
    }

    public void u(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            n nVar = this.f17376h;
            if (nVar != null) {
                nVar.p0(bVar);
            }
            s sVar = this.m;
            if (sVar != null) {
                sVar.n0(bVar);
            }
            i iVar = this.k;
            if (iVar != null) {
                iVar.m0(bVar);
            }
            l lVar = this.w;
            if (lVar != null) {
                lVar.l0(bVar);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.l0(bVar);
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.l0(bVar);
            }
            w wVar = this.z;
            if (wVar != null) {
                wVar.l0(bVar);
            }
            v vVar = this.A;
            if (vVar != null) {
                vVar.q0(bVar);
            }
            u uVar = this.C;
            if (uVar != null) {
                uVar.n0(bVar);
            }
            x xVar = this.B;
            if (xVar != null) {
                xVar.o0(bVar);
            }
            n nVar2 = this.D;
            if (nVar2 != null) {
                nVar2.p0(bVar);
            }
            q qVar = this.E;
            if (qVar != null) {
                qVar.o0(bVar);
            }
            r rVar = this.F;
            if (rVar != null) {
                rVar.n0(bVar);
            }
            t tVar = this.G;
            if (tVar != null) {
                tVar.j0(bVar);
            }
            b.a.r0.h1.h.h.c cVar = this.H;
            if (cVar != null) {
                cVar.n0(bVar);
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
            b.a.r0.h1.h.h.b bVar = this.f17375g;
            if (bVar != null) {
                bVar.i0(bdUniqueId);
            }
            n nVar = this.f17376h;
            if (nVar != null) {
                nVar.n = bdUniqueId;
            }
            y yVar = this.f17377i;
            if (yVar != null) {
                yVar.n = bdUniqueId;
            }
            h hVar = this.j;
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
            b.a.r0.h1.h.h.f fVar = this.s;
            if (fVar != null) {
                fVar.m = bdUniqueId;
            }
            b.a.r0.h1.h.h.e eVar = this.t;
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
            b.a.r0.h1.h.h.a aVar = this.f17373e;
            if (aVar != null) {
                aVar.j0(bdUniqueId);
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
            b.a.r0.h1.h.h.c cVar = this.H;
            if (cVar != null) {
                cVar.n = bdUniqueId;
            }
            b.a.r0.h1.h.h.d dVar = this.v;
            if (dVar != null) {
                dVar.m = bdUniqueId;
            }
            b.a.r0.h1.c.e.z zVar2 = this.I;
            if (zVar2 != null) {
                zVar2.n = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.Q)) {
                for (b.a.e.l.e.a aVar2 : this.Q) {
                    if (aVar2 instanceof b.a.r0.q1.o.g.a) {
                        ((b.a.r0.q1.o.g.a) aVar2).setUniqueId(bdUniqueId);
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

    public void x(b.a.r0.h1.h.k.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, fVar) == null) {
            this.f17376h.q0(fVar);
            this.f17377i.o0(fVar);
            this.j.n0(fVar);
            this.l.n0(fVar);
            this.m.o0(fVar);
            this.q.m0(fVar);
            this.r.n0(fVar);
            this.s.n0(fVar);
            this.t.n0(fVar);
            this.u.q0(fVar);
            this.v.o0(fVar);
        }
    }

    public final void y(b.a.e.l.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, sVar) == null) {
            this.f17377i.p0(sVar);
            this.j.o0(sVar);
            this.k.n0(sVar);
            this.l.o0(sVar);
            this.m.p0(sVar);
            this.n.i0(sVar);
            this.o.j0(sVar);
            this.p.i0(sVar);
            this.q.n0(sVar);
            this.r.o0(sVar);
            this.s.o0(sVar);
            this.t.o0(sVar);
            this.v.p0(sVar);
            this.u.r0(sVar);
            this.H.o0(sVar);
            this.A.r0(sVar);
            this.A.r0(sVar);
            this.C.o0(sVar);
            this.I.i0(sVar);
        }
    }

    public void z(List<b.a.e.l.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, list) == null) {
            b.a.r0.l3.w.f(list, 2);
            this.f17370b.setData(list);
            this.f17371c = list;
            f fVar = this.T;
            if (fVar != null) {
                fVar.a();
            }
        }
    }
}
