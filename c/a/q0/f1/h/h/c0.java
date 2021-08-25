package c.a.q0.f1.h.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.p0.s.q.c2;
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
    public c.a.q0.f1.h.h.c H;
    public c.a.q0.f1.c.e.z I;
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
    public List<c.a.e.l.e.a> f17732a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.e.l.e.s f17733b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.e.l.e.n> f17734c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext<?> f17735d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.f1.h.h.a f17736e;

    /* renamed from: f  reason: collision with root package name */
    public a0 f17737f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.f1.h.h.b f17738g;

    /* renamed from: h  reason: collision with root package name */
    public n f17739h;

    /* renamed from: i  reason: collision with root package name */
    public y f17740i;

    /* renamed from: j  reason: collision with root package name */
    public h f17741j;
    public i k;
    public j l;
    public s m;
    public k n;
    public p o;
    public m p;
    public o q;
    public g r;
    public c.a.q0.f1.h.h.f s;
    public c.a.q0.f1.h.h.e t;
    public z u;
    public c.a.q0.f1.h.h.d v;
    public l w;
    public HomePageAlaLiveThreadAdapter x;
    public HomePageAlaFriendRoomAdapter y;
    public w z;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c0 f17742a;

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
            this.f17742a = c0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f17742a.f();
            if (this.f17742a.f17734c != null) {
                c0 c0Var = this.f17742a;
                c0Var.z(c0Var.f17734c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c0 f17743a;

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
            this.f17743a = c0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().f47954a) {
                return;
            }
            this.f17743a.g(updateAttentionMessage.getData());
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c0 f17744a;

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
            this.f17744a = c0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                c.a.q0.o1.p.b bVar = new c.a.q0.o1.p.b();
                bVar.f23052a = String.valueOf(customResponsedMessage.getData());
                bVar.f23053b = true;
                this.f17744a.g(bVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c0 f17745a;

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
            this.f17745a = c0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                c.a.q0.o1.p.b bVar = new c.a.q0.o1.p.b();
                bVar.f23052a = String.valueOf(customResponsedMessage.getData());
                bVar.f23053b = false;
                this.f17745a.g(bVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c0 f17746a;

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
            this.f17746a = c0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.a.f.m.e.b i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (StringUtils.isNull(str, true) || (i2 = this.f17746a.i(str)) == null) {
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
        this.f17732a = new ArrayList();
        this.f17733b = sVar;
        this.f17735d = (TbPageContext) c.a.e.a.j.a(context);
        j(context);
        y(sVar);
        sVar.addAdapters(this.f17732a);
    }

    public void A(List<c.a.e.l.e.n> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, list, i2) == null) {
            c.a.q0.i3.v.f(list, 2);
            ViewGroup listView = this.f17733b.getListView();
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
            this.f17733b.setData(list);
            this.f17734c = list;
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
                ArrayList<BdUniqueId> g2 = c.a.q0.i3.v.g();
                if (g2 == null || g2.size() <= 0) {
                    return false;
                }
                int size = g2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    c.a.q0.o1.o.g.a b2 = c.a.q0.o1.r.b.d().b(this.f17735d, g2.get(i2), 2);
                    if (this.R) {
                        b2.h0(3);
                    }
                    n nVar = this.f17739h;
                    if (nVar != null && (bdUniqueId = nVar.n) != null) {
                        b2.setUniqueId(bdUniqueId);
                    }
                    this.Q.add(b2);
                }
                this.f17733b.addAdapters(this.Q);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void g(Object obj) {
        List<c.a.e.l.e.n> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, obj) == null) || (list = this.f17734c) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f17734c : (List) invokeV.objValue;
    }

    public final c.a.f.m.e.b i(String str) {
        InterceptResult invokeL;
        int i2;
        c.a.q0.a0.d0.l lVar;
        c2 c2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            List<c.a.e.l.e.n> list = this.f17734c;
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
                if (i3 >= this.f17734c.size()) {
                    i2 = -1;
                    break;
                }
                if (this.f17734c.get(i3) instanceof c.a.q0.f1.h.j.h) {
                    i4++;
                }
                if (this.f17734c.get(i3) instanceof c.a.q0.f1.h.j.a) {
                    if (l(this.f17734c.get(i3))) {
                        if (z) {
                            i2 = ((c.a.q0.f1.h.j.a) this.f17734c.get(i3)).position;
                            break;
                        }
                        i6 = ((c.a.q0.f1.h.j.a) this.f17734c.get(i3)).position;
                    } else if (z) {
                        i5++;
                    }
                }
                if ((this.f17734c.get(i3) instanceof c.a.q0.a0.d0.l) && (lVar = (c.a.q0.a0.d0.l) this.f17734c.get(i3)) != null && (c2Var = lVar.f15245e) != null && str.equals(c2Var.f0())) {
                    i7 = ((c.a.q0.a0.d0.l) this.f17734c.get(i3)).position;
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
            this.f17736e = new c.a.q0.f1.h.h.a(this.f17735d);
            this.f17737f = new a0(this.f17735d);
            this.f17738g = new c.a.q0.f1.h.h.b(this.f17735d, c.a.q0.f1.h.j.f.f17820f);
            this.f17739h = new n(this.f17735d, c.a.q0.a0.d0.k.s0);
            this.f17740i = new y(this.f17735d, c.a.q0.a0.d0.k.C0);
            this.f17741j = new h(this.f17735d, c.a.q0.a0.d0.k.J0);
            this.k = new i(this.f17735d, c.a.q0.a0.d0.k.D0);
            this.l = new j(this.f17735d, c.a.q0.a0.d0.k.K0);
            this.m = new s(this.f17735d, c.a.q0.a0.d0.k.I0);
            this.n = new k(this.f17735d, c.a.q0.a0.d0.k.L0);
            this.o = new p(this.f17735d, c.a.q0.a0.d0.k.M0);
            this.p = new m(this.f17735d, c.a.q0.a0.d0.k.N0);
            this.q = new o(this.f17735d, c.a.q0.a0.d0.k.O0);
            this.r = new g(this.f17735d, c.a.q0.a0.d0.k.E0);
            this.s = new c.a.q0.f1.h.h.f(this.f17735d, c.a.q0.a0.d0.k.F0);
            this.t = new c.a.q0.f1.h.h.e(this.f17735d, c.a.q0.a0.d0.k.G0);
            this.u = new z(this.f17735d, c.a.q0.a0.d0.l.X);
            this.w = new l(this.f17735d, c.a.q0.a0.d0.k.u0);
            this.x = new HomePageAlaLiveThreadAdapter(this.f17735d, c.a.q0.a0.d0.j.P0);
            this.y = new HomePageAlaFriendRoomAdapter(this.f17735d, c.a.q0.a0.d0.j.Q0);
            this.z = new w(this.f17735d, c.a.q0.a0.d0.k.v0);
            this.A = new v(this.f17735d, c.a.q0.a0.d0.k.w0);
            this.B = new x(this.f17735d, c.a.q0.a0.d0.k.y0);
            this.C = new u(this.f17735d, c.a.q0.a0.d0.k.x0);
            this.D = new n(this.f17735d, c.a.q0.a0.d0.k.t0);
            this.E = new q(this.f17735d, c.a.q0.a0.d0.k.z0);
            this.F = new r(this.f17735d, c.a.q0.a0.d0.k.A0);
            this.G = new t(this.f17735d, c.a.q0.f1.k.b.c.a.k0);
            this.H = new c.a.q0.f1.h.h.c(this.f17735d, c.a.q0.a0.d0.e.P0);
            this.v = new c.a.q0.f1.h.h.d(this.f17735d, c.a.q0.a0.d0.k.H0);
            this.I = new c.a.q0.f1.c.e.z(this.f17735d, c.a.q0.a0.d0.k.B0, (byte) 3);
            this.f17732a.add(this.f17736e);
            this.f17732a.add(this.f17737f);
            this.f17732a.add(this.f17738g);
            this.f17732a.add(this.f17739h);
            this.f17732a.add(this.f17740i);
            this.f17732a.add(this.f17741j);
            this.f17732a.add(this.k);
            this.f17732a.add(this.l);
            this.f17732a.add(this.m);
            this.f17732a.add(this.n);
            this.f17732a.add(this.o);
            this.f17732a.add(this.p);
            this.f17732a.add(this.q);
            this.f17732a.add(this.r);
            this.f17732a.add(this.s);
            this.f17732a.add(this.t);
            this.f17732a.add(this.u);
            this.f17732a.add(this.w);
            this.f17732a.add(this.D);
            this.f17732a.add(new ReadProgessDelegetAdapter(this.f17735d, c.a.q0.f1.h.l.b.f17855g));
            this.f17732a.add(this.x);
            this.f17732a.add(this.y);
            this.f17732a.add(this.z);
            this.f17732a.add(this.A);
            this.f17732a.add(this.C);
            this.f17732a.add(this.B);
            this.f17732a.add(new b0(this.f17735d, c.a.q0.f1.h.j.h.f17822i));
            this.f17732a.add(this.E);
            this.f17732a.add(this.F);
            this.f17732a.add(this.G);
            this.f17732a.add(this.H);
            this.f17732a.add(this.v);
            this.f17732a.add(this.I);
            e();
            k();
            r("page_recommend");
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (!c2.J3.get()) {
                AdvertAppInfo.m4.set(false);
                return;
            }
            this.J = c.a.q0.x2.y.o().j(this.f17735d, AdvertAppInfo.p4, "INDEX");
            this.K = c.a.q0.x2.y.o().j(this.f17735d, AdvertAppInfo.q4, "INDEX");
            this.L = c.a.q0.x2.y.o().j(this.f17735d, AdvertAppInfo.r4, "INDEX");
            this.M = c.a.q0.x2.y.o().j(this.f17735d, AdvertAppInfo.s4, "INDEX");
            this.N = c.a.q0.x2.y.o().j(this.f17735d, AdvertAppInfo.t4, "INDEX");
            this.O = c.a.q0.x2.y.o().j(this.f17735d, AdvertAppInfo.v4, "INDEX");
            this.P = c.a.q0.x2.y.o().j(this.f17735d, AdvertAppInfo.u4, "INDEX");
            this.f17732a.add(this.J);
            this.f17732a.add(this.K);
            this.f17732a.add(this.L);
            this.f17732a.add(this.M);
            this.f17732a.add(this.N);
            this.f17732a.add(this.O);
            this.f17732a.add(this.P);
            if (this.f17735d.getPageActivity() instanceof BaseFragmentActivity) {
                this.f17732a.add(c.a.q0.w0.b.e().c((BaseFragmentActivity) this.f17735d.getPageActivity(), AdvertAppInfo.y4));
                this.f17732a.add(c.a.q0.w0.b.e().c((BaseFragmentActivity) this.f17735d.getPageActivity(), AdvertAppInfo.x4));
            }
            AdvertAppInfo.m4.set(true);
        }
    }

    public final boolean l(c.a.e.l.e.n nVar) {
        InterceptResult invokeL;
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nVar)) == null) ? nVar != null && (nVar instanceof c.a.q0.f1.h.j.a) && (advertAppInfo = ((c.a.q0.f1.h.j.a) nVar).f15251e) != null && advertAppInfo.I4() == 0 : invokeL.booleanValue;
    }

    public void m() {
        c.a.e.l.e.s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (sVar = this.f17733b) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            m();
            this.f17736e.h0(i2);
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
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || (list = this.f17732a) == null) {
            return;
        }
        for (c.a.e.l.e.a aVar : list) {
            if (aVar instanceof c.a.q0.o.f) {
                ((c.a.q0.o.f) aVar).g(str);
            }
        }
    }

    public void s(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
            for (c.a.e.l.e.a aVar2 : this.f17732a) {
                if (aVar2 instanceof c.a.q0.f1.a) {
                    ((c.a.q0.f1.a) aVar2).h0(aVar);
                }
            }
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            n nVar = this.f17739h;
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
            c.a.q0.f1.h.h.d dVar = this.v;
            if (dVar != null) {
                dVar.setFromCDN(z);
            }
            c.a.e.l.e.a aVar = this.K;
            if (aVar == null || !(aVar instanceof c.a.q0.x2.t)) {
                return;
            }
            ((c.a.q0.x2.t) aVar).k(z);
        }
    }

    public void u(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            n nVar = this.f17739h;
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
            c.a.q0.f1.h.h.c cVar = this.H;
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
            c.a.q0.f1.h.h.b bVar = this.f17738g;
            if (bVar != null) {
                bVar.j0(bdUniqueId);
            }
            n nVar = this.f17739h;
            if (nVar != null) {
                nVar.n = bdUniqueId;
            }
            y yVar = this.f17740i;
            if (yVar != null) {
                yVar.n = bdUniqueId;
            }
            h hVar = this.f17741j;
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
            c.a.q0.f1.h.h.f fVar = this.s;
            if (fVar != null) {
                fVar.m = bdUniqueId;
            }
            c.a.q0.f1.h.h.e eVar = this.t;
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
            c.a.q0.f1.h.h.a aVar = this.f17736e;
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
            c.a.q0.f1.h.h.c cVar = this.H;
            if (cVar != null) {
                cVar.n = bdUniqueId;
            }
            c.a.q0.f1.h.h.d dVar = this.v;
            if (dVar != null) {
                dVar.m = bdUniqueId;
            }
            c.a.q0.f1.c.e.z zVar2 = this.I;
            if (zVar2 != null) {
                zVar2.n = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.Q)) {
                for (c.a.e.l.e.a aVar2 : this.Q) {
                    if (aVar2 instanceof c.a.q0.o1.o.g.a) {
                        ((c.a.q0.o1.o.g.a) aVar2).setUniqueId(bdUniqueId);
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

    public void x(c.a.q0.f1.h.k.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, eVar) == null) {
            this.f17739h.r0(eVar);
            this.f17740i.p0(eVar);
            this.f17741j.o0(eVar);
            this.l.o0(eVar);
            this.m.p0(eVar);
            this.q.n0(eVar);
            this.r.o0(eVar);
            this.s.o0(eVar);
            this.t.o0(eVar);
            this.u.r0(eVar);
            this.v.p0(eVar);
        }
    }

    public final void y(c.a.e.l.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, sVar) == null) {
            this.f17740i.q0(sVar);
            this.f17741j.p0(sVar);
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
            c.a.q0.i3.v.f(list, 2);
            this.f17733b.setData(list);
            this.f17734c = list;
            f fVar = this.T;
            if (fVar != null) {
                fVar.a();
            }
        }
    }
}
