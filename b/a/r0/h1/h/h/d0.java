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
    public b.a.r0.h1.h.h.c H;
    public a0 I;
    public b.a.r0.h1.c.e.a0 J;
    public b.a.e.m.e.a K;
    public b.a.e.m.e.a L;
    public b.a.e.m.e.a M;
    public b.a.e.m.e.a N;
    public b.a.e.m.e.a O;
    public b.a.e.m.e.a P;
    public b.a.e.m.e.a Q;
    public List<b.a.e.m.e.a> R;
    public boolean S;
    public boolean T;
    public f U;
    public CustomMessageListener V;
    public CustomMessageListener W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public CustomMessageListener Z;

    /* renamed from: a  reason: collision with root package name */
    public List<b.a.e.m.e.a> f18842a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.e.m.e.s f18843b;

    /* renamed from: c  reason: collision with root package name */
    public List<b.a.e.m.e.n> f18844c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext<?> f18845d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.h1.h.h.a f18846e;

    /* renamed from: f  reason: collision with root package name */
    public b0 f18847f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.h1.h.h.b f18848g;

    /* renamed from: h  reason: collision with root package name */
    public n f18849h;

    /* renamed from: i  reason: collision with root package name */
    public y f18850i;
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
        public final /* synthetic */ d0 f18851a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d0 d0Var, int i2) {
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
            this.f18851a = d0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f18851a.f();
            if (this.f18851a.f18844c != null) {
                d0 d0Var = this.f18851a;
                d0Var.z(d0Var.f18844c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d0 f18852a;

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
            this.f18852a = d0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().f46517a) {
                return;
            }
            this.f18852a.g(updateAttentionMessage.getData());
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d0 f18853a;

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
            this.f18853a = d0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                b.a.r0.q1.p.b bVar = new b.a.r0.q1.p.b();
                bVar.f24240a = String.valueOf(customResponsedMessage.getData());
                bVar.f24241b = true;
                this.f18853a.g(bVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d0 f18854a;

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
            this.f18854a = d0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                b.a.r0.q1.p.b bVar = new b.a.r0.q1.p.b();
                bVar.f24240a = String.valueOf(customResponsedMessage.getData());
                bVar.f24241b = false;
                this.f18854a.g(bVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d0 f18855a;

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
            this.f18855a = d0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.a.f.m.e.b i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (StringUtils.isNull(str, true) || (i2 = this.f18855a.i(str)) == null) {
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

    public d0(Context context, b.a.e.m.e.s sVar) {
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
        this.V = new a(this, 2016470);
        this.W = new b(this, 2001115);
        this.X = new c(this, 2001335);
        this.Y = new d(this, 2001336);
        this.Z = new e(this, 2921394);
        this.f18842a = new ArrayList();
        this.f18843b = sVar;
        this.f18845d = (TbPageContext) b.a.e.a.j.a(context);
        j(context);
        y(sVar);
        sVar.addAdapters(this.f18842a);
    }

    public void A(List<b.a.e.m.e.n> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, list, i2) == null) {
            b.a.r0.m3.w.f(list, 2);
            ViewGroup listView = this.f18843b.getListView();
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
            this.f18843b.setData(list);
            this.f18844c = list;
            f fVar = this.U;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.T = f();
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<b.a.e.m.e.a> list = this.R;
            if (list == null || list.size() <= 0) {
                this.R = new ArrayList();
                ArrayList<BdUniqueId> g2 = b.a.r0.m3.w.g();
                if (g2 == null || g2.size() <= 0) {
                    return false;
                }
                int size = g2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    b.a.r0.q1.o.g.a b2 = b.a.r0.q1.r.b.d().b(this.f18845d, g2.get(i2), 2);
                    if (this.S) {
                        b2.g0(3);
                    }
                    n nVar = this.f18849h;
                    if (nVar != null && (bdUniqueId = nVar.n) != null) {
                        b2.setUniqueId(bdUniqueId);
                    }
                    this.R.add(b2);
                }
                this.f18843b.addAdapters(this.R);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void g(Object obj) {
        List<b.a.e.m.e.n> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, obj) == null) || (list = this.f18844c) == null) {
            return;
        }
        boolean z = false;
        for (b.a.e.m.e.n nVar : list) {
            if ((nVar instanceof ICardInfo) && ((ICardInfo) nVar).responseAttention(obj)) {
                z = true;
            }
        }
        if (z) {
            m();
        }
    }

    public List<b.a.e.m.e.n> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f18844c : (List) invokeV.objValue;
    }

    public final b.a.f.m.e.b i(String str) {
        InterceptResult invokeL;
        int i2;
        b.a.r0.b0.f0.l lVar;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            List<b.a.e.m.e.n> list = this.f18844c;
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
                if (i3 >= this.f18844c.size()) {
                    i2 = -1;
                    break;
                }
                if (this.f18844c.get(i3) instanceof b.a.r0.h1.h.j.h) {
                    i4++;
                }
                if (this.f18844c.get(i3) instanceof b.a.r0.h1.h.j.a) {
                    if (l(this.f18844c.get(i3))) {
                        if (z) {
                            i2 = ((b.a.r0.h1.h.j.a) this.f18844c.get(i3)).position;
                            break;
                        }
                        i6 = ((b.a.r0.h1.h.j.a) this.f18844c.get(i3)).position;
                    } else if (z) {
                        i5++;
                    }
                }
                if ((this.f18844c.get(i3) instanceof b.a.r0.b0.f0.l) && (lVar = (b.a.r0.b0.f0.l) this.f18844c.get(i3)) != null && (d2Var = lVar.f16235e) != null && str.equals(d2Var.f0())) {
                    i7 = ((b.a.r0.b0.f0.l) this.f18844c.get(i3)).position;
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
            this.f18846e = new b.a.r0.h1.h.h.a(this.f18845d);
            this.f18847f = new b0(this.f18845d);
            this.f18848g = new b.a.r0.h1.h.h.b(this.f18845d, b.a.r0.h1.h.j.f.f18925f);
            this.f18849h = new n(this.f18845d, b.a.r0.b0.f0.k.u0);
            this.f18850i = new y(this.f18845d, b.a.r0.b0.f0.k.E0);
            this.j = new h(this.f18845d, b.a.r0.b0.f0.k.M0);
            this.k = new i(this.f18845d, b.a.r0.b0.f0.k.F0);
            this.l = new j(this.f18845d, b.a.r0.b0.f0.k.N0);
            this.m = new s(this.f18845d, b.a.r0.b0.f0.k.L0);
            this.n = new k(this.f18845d, b.a.r0.b0.f0.k.O0);
            this.o = new p(this.f18845d, b.a.r0.b0.f0.k.P0);
            this.p = new m(this.f18845d, b.a.r0.b0.f0.k.Q0);
            this.q = new o(this.f18845d, b.a.r0.b0.f0.k.R0);
            this.r = new g(this.f18845d, b.a.r0.b0.f0.k.G0);
            this.s = new b.a.r0.h1.h.h.f(this.f18845d, b.a.r0.b0.f0.k.H0);
            this.t = new b.a.r0.h1.h.h.e(this.f18845d, b.a.r0.b0.f0.k.I0);
            this.u = new z(this.f18845d, b.a.r0.b0.f0.l.Z);
            this.w = new l(this.f18845d, b.a.r0.b0.f0.k.w0);
            this.x = new HomePageAlaLiveThreadAdapter(this.f18845d, b.a.r0.b0.f0.j.S0);
            this.I = new a0(this.f18845d, b.a.r0.b0.f0.k.K0);
            this.y = new HomePageAlaFriendRoomAdapter(this.f18845d, b.a.r0.b0.f0.j.T0);
            this.z = new w(this.f18845d, b.a.r0.b0.f0.k.x0);
            this.A = new v(this.f18845d, b.a.r0.b0.f0.k.y0);
            this.B = new x(this.f18845d, b.a.r0.b0.f0.k.A0);
            this.C = new u(this.f18845d, b.a.r0.b0.f0.k.z0);
            this.D = new n(this.f18845d, b.a.r0.b0.f0.k.v0);
            this.E = new q(this.f18845d, b.a.r0.b0.f0.k.B0);
            this.F = new r(this.f18845d, b.a.r0.b0.f0.k.C0);
            this.G = new t(this.f18845d, b.a.r0.h1.k.b.c.a.n0);
            this.H = new b.a.r0.h1.h.h.c(this.f18845d, b.a.r0.b0.f0.e.S0);
            this.v = new b.a.r0.h1.h.h.d(this.f18845d, b.a.r0.b0.f0.k.J0);
            this.J = new b.a.r0.h1.c.e.a0(this.f18845d, b.a.r0.b0.f0.k.D0, (byte) 3);
            this.f18842a.add(this.f18846e);
            this.f18842a.add(this.f18847f);
            this.f18842a.add(this.f18848g);
            this.f18842a.add(this.f18849h);
            this.f18842a.add(this.f18850i);
            this.f18842a.add(this.j);
            this.f18842a.add(this.k);
            this.f18842a.add(this.l);
            this.f18842a.add(this.m);
            this.f18842a.add(this.n);
            this.f18842a.add(this.o);
            this.f18842a.add(this.p);
            this.f18842a.add(this.q);
            this.f18842a.add(this.r);
            this.f18842a.add(this.s);
            this.f18842a.add(this.t);
            this.f18842a.add(this.u);
            this.f18842a.add(this.w);
            this.f18842a.add(this.D);
            this.f18842a.add(new ReadProgessDelegetAdapter(this.f18845d, b.a.r0.h1.h.l.b.f18969g));
            this.f18842a.add(this.x);
            this.f18842a.add(this.y);
            this.f18842a.add(this.z);
            this.f18842a.add(this.A);
            this.f18842a.add(this.C);
            this.f18842a.add(this.B);
            this.f18842a.add(new c0(this.f18845d, b.a.r0.h1.h.j.h.f18927i));
            this.f18842a.add(this.E);
            this.f18842a.add(this.F);
            this.f18842a.add(this.G);
            this.f18842a.add(this.H);
            this.f18842a.add(this.v);
            this.f18842a.add(this.J);
            this.f18842a.add(this.I);
            e();
            k();
            r("page_recommend");
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (!d2.P3.get()) {
                AdvertAppInfo.r4.set(false);
                return;
            }
            this.K = b.a.r0.a3.y.o().j(this.f18845d, AdvertAppInfo.u4, "INDEX");
            this.L = b.a.r0.a3.y.o().j(this.f18845d, AdvertAppInfo.v4, "INDEX");
            this.M = b.a.r0.a3.y.o().j(this.f18845d, AdvertAppInfo.w4, "INDEX");
            this.N = b.a.r0.a3.y.o().j(this.f18845d, AdvertAppInfo.x4, "INDEX");
            this.O = b.a.r0.a3.y.o().j(this.f18845d, AdvertAppInfo.y4, "INDEX");
            this.P = b.a.r0.a3.y.o().j(this.f18845d, AdvertAppInfo.A4, "INDEX");
            this.Q = b.a.r0.a3.y.o().j(this.f18845d, AdvertAppInfo.z4, "INDEX");
            this.f18842a.add(this.K);
            this.f18842a.add(this.L);
            this.f18842a.add(this.M);
            this.f18842a.add(this.N);
            this.f18842a.add(this.O);
            this.f18842a.add(this.P);
            this.f18842a.add(this.Q);
            if (this.f18845d.getPageActivity() instanceof BaseFragmentActivity) {
                this.f18842a.add(b.a.r0.y0.b.e().c((BaseFragmentActivity) this.f18845d.getPageActivity(), AdvertAppInfo.D4));
                this.f18842a.add(b.a.r0.y0.b.e().c((BaseFragmentActivity) this.f18845d.getPageActivity(), AdvertAppInfo.C4));
            }
            AdvertAppInfo.r4.set(true);
        }
    }

    public final boolean l(b.a.e.m.e.n nVar) {
        InterceptResult invokeL;
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nVar)) == null) ? nVar != null && (nVar instanceof b.a.r0.h1.h.j.a) && (advertAppInfo = ((b.a.r0.h1.h.j.a) nVar).f16240e) != null && advertAppInfo.W4() == 0 : invokeL.booleanValue;
    }

    public void m() {
        b.a.e.m.e.s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (sVar = this.f18843b) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            m();
            this.f18846e.g0(i2);
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
        List<b.a.e.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || (list = this.f18842a) == null) {
            return;
        }
        for (b.a.e.m.e.a aVar : list) {
            if (aVar instanceof b.a.r0.p.f) {
                ((b.a.r0.p.f) aVar).g(str);
            }
        }
    }

    public void s(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
            for (b.a.e.m.e.a aVar2 : this.f18842a) {
                if (aVar2 instanceof b.a.r0.h1.a) {
                    ((b.a.r0.h1.a) aVar2).g0(aVar);
                }
            }
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            n nVar = this.f18849h;
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
            b.a.e.m.e.a aVar = this.L;
            if (aVar == null || !(aVar instanceof b.a.r0.a3.t)) {
                return;
            }
            ((b.a.r0.a3.t) aVar).k(z);
        }
    }

    public void u(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            n nVar = this.f18849h;
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
            this.U = fVar;
        }
    }

    public void w(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bdUniqueId) == null) {
            b.a.r0.h1.h.h.b bVar = this.f18848g;
            if (bVar != null) {
                bVar.i0(bdUniqueId);
            }
            n nVar = this.f18849h;
            if (nVar != null) {
                nVar.n = bdUniqueId;
            }
            y yVar = this.f18850i;
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
            b.a.r0.h1.h.h.a aVar = this.f18846e;
            if (aVar != null) {
                aVar.j0(bdUniqueId);
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
            b.a.r0.h1.h.h.c cVar = this.H;
            if (cVar != null) {
                cVar.n = bdUniqueId;
            }
            b.a.r0.h1.h.h.d dVar = this.v;
            if (dVar != null) {
                dVar.m = bdUniqueId;
            }
            b.a.r0.h1.c.e.a0 a0Var2 = this.J;
            if (a0Var2 != null) {
                a0Var2.n = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.R)) {
                for (b.a.e.m.e.a aVar2 : this.R) {
                    if (aVar2 instanceof b.a.r0.q1.o.g.a) {
                        ((b.a.r0.q1.o.g.a) aVar2).setUniqueId(bdUniqueId);
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

    public void x(b.a.r0.h1.h.k.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, fVar) == null) {
            this.f18849h.q0(fVar);
            this.f18850i.p0(fVar);
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

    public final void y(b.a.e.m.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, sVar) == null) {
            this.f18850i.q0(sVar);
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
            this.J.i0(sVar);
        }
    }

    public void z(List<b.a.e.m.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, list) == null) {
            b.a.r0.m3.w.f(list, 2);
            this.f18843b.setData(list);
            this.f18844c = list;
            f fVar = this.U;
            if (fVar != null) {
                fVar.a();
            }
        }
    }
}
