package c.a.t0.o1.c;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.d.n.e.n;
import c.a.s0.s.q.e2;
import c.a.s0.s.q.v1;
import c.a.t0.o1.c.e.a0;
import c.a.t0.o1.c.e.e;
import c.a.t0.o1.c.e.f;
import c.a.t0.o1.c.e.g;
import c.a.t0.o1.c.e.h;
import c.a.t0.o1.c.e.i;
import c.a.t0.o1.c.e.j;
import c.a.t0.o1.c.e.k;
import c.a.t0.o1.c.e.l;
import c.a.t0.o1.c.e.m;
import c.a.t0.o1.c.e.o;
import c.a.t0.o1.c.e.p;
import c.a.t0.o1.c.e.q;
import c.a.t0.o1.c.e.r;
import c.a.t0.o1.c.e.s;
import c.a.t0.o1.c.e.t;
import c.a.t0.o1.c.e.u;
import c.a.t0.o1.c.e.v;
import c.a.t0.o1.c.e.w;
import c.a.t0.o1.c.e.x;
import c.a.t0.o1.c.e.y;
import c.a.t0.o1.c.e.z;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.homepage.concern.adapter.ConcernEmotionTipAdapter;
import com.baidu.tieba.homepage.concern.adapter.ConcernTipAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public s A;
    public c.a.t0.o1.c.e.d B;
    public p C;
    public e D;
    public q E;
    public ConcernEmotionTipAdapter F;
    public a0 G;
    public ArrayList<c.a.d.n.e.a> H;
    public List<n> I;
    public List<c.a.d.n.e.a> a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f20113b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f20114c;

    /* renamed from: d  reason: collision with root package name */
    public ConcernTipAdapter f20115d;

    /* renamed from: e  reason: collision with root package name */
    public ConcernEmotionTipAdapter f20116e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.o1.c.e.b f20117f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.t0.o1.c.e.a f20118g;

    /* renamed from: h  reason: collision with root package name */
    public v f20119h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<r> f20120i;

    /* renamed from: j  reason: collision with root package name */
    public x f20121j;
    public x k;
    public j l;
    public w m;
    public l n;
    public u o;
    public i p;
    public h q;
    public g r;
    public f s;
    public y t;
    public k u;
    public m v;
    public c.a.t0.o1.c.e.n w;
    public t x;
    public o y;
    public z z;

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20120i = new ArrayList<>();
        this.a = new ArrayList();
        this.f20113b = bdTypeRecyclerView;
        this.f20114c = (TbPageContext) c.a.d.a.j.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.a);
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.I : (List) invokeV.objValue;
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            for (int i2 = 0; i2 < c.a.t0.g0.f0.b.T.size(); i2++) {
                for (int i3 = 0; i3 < c.a.t0.g0.f0.b.U.size(); i3++) {
                    this.f20120i.add(new r(this.f20114c, c.a.t0.g0.f0.b.V[i2][i3], c.a.t0.g0.f0.b.T.get(i2), c.a.t0.g0.f0.b.U.get(i3)));
                }
            }
            this.f20121j = new x(this.f20114c, e2.G3, c.a.t0.g0.f0.b.I);
            this.k = new x(this.f20114c, e2.j3, c.a.t0.g0.f0.b.J);
            this.l = new j(this.f20114c, e2.Y3, c.a.t0.g0.f0.b.I);
            this.m = new w(this.f20114c, c.a.t0.g0.f0.k.G0);
            this.n = new l(this.f20114c, c.a.t0.g0.f0.k.H0);
            this.u = new k(this.f20114c, c.a.t0.g0.f0.k.O0);
            this.v = new m(this.f20114c, c.a.t0.g0.f0.k.P0);
            this.o = new u(this.f20114c, c.a.t0.g0.f0.k.N0);
            this.p = new i(this.f20114c, c.a.t0.g0.f0.k.I0);
            this.q = new h(this.f20114c, c.a.t0.g0.f0.k.J0);
            this.r = new g(this.f20114c, c.a.t0.g0.f0.k.K0);
            this.t = new y(this.f20114c, c.a.t0.g0.f0.l.Z);
            this.B = new c.a.t0.o1.c.e.d(this.f20114c, c.a.t0.g0.f0.e.U0);
            this.s = new f(this.f20114c, c.a.t0.g0.f0.k.L0);
            this.A = new s(this.f20114c, v1.f13510i);
            this.w = new c.a.t0.o1.c.e.n(this.f20114c, c.a.t0.g0.f0.k.Q0);
            this.x = new t(this.f20114c, c.a.t0.g0.f0.k.R0);
            this.y = new o(this.f20114c, c.a.t0.g0.f0.k.S0);
            this.z = new z(this.f20114c, e2.u3);
            this.a.addAll(this.f20120i);
            this.a.add(this.f20121j);
            this.a.add(this.k);
            this.a.add(this.l);
            this.a.add(this.m);
            this.a.add(this.n);
            this.a.add(this.u);
            this.a.add(this.v);
            this.a.add(this.o);
            this.a.add(this.p);
            this.a.add(this.q);
            this.a.add(this.r);
            this.a.add(this.t);
            this.a.add(this.s);
            this.a.add(this.A);
            this.a.add(this.w);
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.f20115d = new ConcernTipAdapter(this.f20114c.getContext());
            this.f20116e = new ConcernEmotionTipAdapter(this.f20114c.getContext());
            this.f20117f = new c.a.t0.o1.c.e.b(this.f20114c, c.a.t0.g0.f0.j.U0);
            this.f20118g = new c.a.t0.o1.c.e.a(this.f20114c, c.a.t0.g0.f0.j.V0);
            this.f20119h = new v(this.f20114c, c.a.t0.g0.f0.k.y0);
            this.C = new p(this.f20114c, c.a.t0.g0.f0.k.z0);
            this.D = new e(this.f20114c, c.a.t0.g0.f0.k.A0);
            this.E = new q(this.f20114c, c.a.t0.g0.f0.k.B0);
            this.F = new ConcernEmotionTipAdapter(this.f20114c.getContext(), c.a.t0.o1.c.f.b.f20212j);
            this.G = new a0(this.f20114c, c.a.t0.g0.f0.k.E0, (byte) 4);
            this.a.add(this.f20115d);
            this.a.add(this.f20116e);
            this.a.add(this.f20117f);
            this.a.add(this.f20118g);
            this.a.add(this.f20119h);
            this.a.add(this.C);
            this.a.add(this.D);
            this.a.add(this.E);
            this.a.add(this.B);
            this.a.add(this.F);
            this.a.add(this.G);
            g("page_concern");
            c();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!e2.W3.get()) {
                AdvertAppInfo.z4.set(false);
                return;
            }
            this.H = new ArrayList<>();
            c.a.d.n.e.a<?, ?> j2 = c.a.t0.j3.y.q().j(this.f20114c, AdvertAppInfo.C4, "CONCERN");
            c.a.d.n.e.a<?, ?> j3 = c.a.t0.j3.y.q().j(this.f20114c, AdvertAppInfo.D4, "CONCERN");
            c.a.d.n.e.a<?, ?> j4 = c.a.t0.j3.y.q().j(this.f20114c, AdvertAppInfo.E4, "CONCERN");
            c.a.d.n.e.a<?, ?> j5 = c.a.t0.j3.y.q().j(this.f20114c, AdvertAppInfo.F4, "CONCERN");
            c.a.d.n.e.a<?, ?> j6 = c.a.t0.j3.y.q().j(this.f20114c, AdvertAppInfo.G4, "CONCERN");
            c.a.d.n.e.a<?, ?> j7 = c.a.t0.j3.y.q().j(this.f20114c, AdvertAppInfo.I4, "CONCERN");
            c.a.d.n.e.a<?, ?> j8 = c.a.t0.j3.y.q().j(this.f20114c, AdvertAppInfo.H4, "CONCERN");
            this.H.add(j2);
            this.H.add(j3);
            this.H.add(j4);
            this.H.add(j5);
            this.H.add(j6);
            this.H.add(j7);
            this.H.add(j8);
            this.a.addAll(this.H);
            AdvertAppInfo.z4.set(true);
        }
    }

    public void d() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdTypeRecyclerView = this.f20113b) == null) {
            return;
        }
        bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            d();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || c.a.t0.x1.o.k.a.e(this.I)) {
            return;
        }
        Iterator<c.a.d.n.e.a> it = this.H.iterator();
        while (it.hasNext()) {
            c.a.d.n.e.a next = it.next();
            if (next instanceof c.a.t0.j3.p) {
                ((c.a.t0.j3.p) next).onDestroy();
            }
        }
    }

    public final void g(String str) {
        List<c.a.d.n.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (list = this.a) == null) {
            return;
        }
        for (c.a.d.n.e.a aVar : list) {
            if (aVar instanceof c.a.t0.t.f) {
                ((c.a.t0.t.f) aVar).g(str);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<r> it = this.f20120i.iterator();
            while (it.hasNext()) {
                it.next().m = bdUniqueId;
            }
            this.f20117f.m = bdUniqueId;
            this.f20118g.m = bdUniqueId;
            this.f20119h.m = bdUniqueId;
            this.E.m = bdUniqueId;
            this.C.m = bdUniqueId;
            this.D.m = bdUniqueId;
            this.B.m = bdUniqueId;
            this.s.m = bdUniqueId;
            this.A.m = bdUniqueId;
            this.G.n = bdUniqueId;
            this.z.m = bdUniqueId;
        }
    }

    public final void i(c.a.d.n.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sVar) == null) {
            Iterator<r> it = this.f20120i.iterator();
            while (it.hasNext()) {
                it.next().o0(sVar);
            }
            this.f20121j.j0(sVar);
            this.k.j0(sVar);
            this.l.e0(sVar);
            this.m.e0(sVar);
            this.n.f0(sVar);
            this.u.e0(sVar);
            this.v.e0(sVar);
            this.o.e0(sVar);
            this.A.c0(sVar);
            this.w.b0(sVar);
            this.x.c0(sVar);
            this.y.b0(sVar);
            this.z.e0(sVar);
            this.p.e0(sVar);
            this.q.e0(sVar);
            this.r.e0(sVar);
            this.t.h0(sVar);
            this.s.f0(sVar);
            this.B.f0(sVar);
            this.D.e0(sVar);
            this.C.f0(sVar);
            this.E.f0(sVar);
            this.G.b0(sVar);
        }
    }

    public void j(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.I = list;
            this.f20113b.setData(list);
        }
    }
}
