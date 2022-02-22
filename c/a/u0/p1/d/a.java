package c.a.u0.p1.d;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.t0.s.r.e2;
import c.a.t0.s.r.v1;
import c.a.u0.p1.d.e.a0;
import c.a.u0.p1.d.e.e;
import c.a.u0.p1.d.e.f;
import c.a.u0.p1.d.e.g;
import c.a.u0.p1.d.e.h;
import c.a.u0.p1.d.e.i;
import c.a.u0.p1.d.e.j;
import c.a.u0.p1.d.e.k;
import c.a.u0.p1.d.e.l;
import c.a.u0.p1.d.e.m;
import c.a.u0.p1.d.e.o;
import c.a.u0.p1.d.e.p;
import c.a.u0.p1.d.e.q;
import c.a.u0.p1.d.e.r;
import c.a.u0.p1.d.e.s;
import c.a.u0.p1.d.e.t;
import c.a.u0.p1.d.e.u;
import c.a.u0.p1.d.e.v;
import c.a.u0.p1.d.e.w;
import c.a.u0.p1.d.e.x;
import c.a.u0.p1.d.e.y;
import c.a.u0.p1.d.e.z;
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
    public c.a.u0.p1.d.e.d B;
    public p C;
    public e D;
    public q E;
    public ConcernEmotionTipAdapter F;
    public a0 G;
    public ArrayList<c.a.d.o.e.a> H;
    public List<n> I;
    public List<c.a.d.o.e.a> a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f20320b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f20321c;

    /* renamed from: d  reason: collision with root package name */
    public ConcernTipAdapter f20322d;

    /* renamed from: e  reason: collision with root package name */
    public ConcernEmotionTipAdapter f20323e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.u0.p1.d.e.b f20324f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.u0.p1.d.e.a f20325g;

    /* renamed from: h  reason: collision with root package name */
    public v f20326h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<r> f20327i;

    /* renamed from: j  reason: collision with root package name */
    public x f20328j;
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
    public c.a.u0.p1.d.e.n w;
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
        this.f20327i = new ArrayList<>();
        this.a = new ArrayList();
        this.f20320b = bdTypeRecyclerView;
        this.f20321c = (TbPageContext) c.a.d.a.j.a(context);
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
            for (int i2 = 0; i2 < c.a.u0.g0.d0.b.S.size(); i2++) {
                for (int i3 = 0; i3 < c.a.u0.g0.d0.b.T.size(); i3++) {
                    this.f20327i.add(new r(this.f20321c, c.a.u0.g0.d0.b.U[i2][i3], c.a.u0.g0.d0.b.S.get(i2), c.a.u0.g0.d0.b.T.get(i3)));
                }
            }
            this.f20328j = new x(this.f20321c, e2.H3, c.a.u0.g0.d0.b.H);
            this.k = new x(this.f20321c, e2.k3, c.a.u0.g0.d0.b.I);
            this.l = new j(this.f20321c, e2.Z3, c.a.u0.g0.d0.b.H);
            this.m = new w(this.f20321c, c.a.u0.g0.d0.k.D0);
            this.n = new l(this.f20321c, c.a.u0.g0.d0.k.E0);
            this.u = new k(this.f20321c, c.a.u0.g0.d0.k.L0);
            this.v = new m(this.f20321c, c.a.u0.g0.d0.k.M0);
            this.o = new u(this.f20321c, c.a.u0.g0.d0.k.K0);
            this.p = new i(this.f20321c, c.a.u0.g0.d0.k.F0);
            this.q = new h(this.f20321c, c.a.u0.g0.d0.k.G0);
            this.r = new g(this.f20321c, c.a.u0.g0.d0.k.H0);
            this.t = new y(this.f20321c, c.a.u0.g0.d0.l.Y);
            this.B = new c.a.u0.p1.d.e.d(this.f20321c, c.a.u0.g0.d0.e.R0);
            this.s = new f(this.f20321c, c.a.u0.g0.d0.k.I0);
            this.A = new s(this.f20321c, v1.f13975i);
            this.w = new c.a.u0.p1.d.e.n(this.f20321c, c.a.u0.g0.d0.k.N0);
            this.x = new t(this.f20321c, c.a.u0.g0.d0.k.O0);
            this.y = new o(this.f20321c, c.a.u0.g0.d0.k.P0);
            this.z = new z(this.f20321c, e2.v3);
            this.a.addAll(this.f20327i);
            this.a.add(this.f20328j);
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
            this.f20322d = new ConcernTipAdapter(this.f20321c.getContext());
            this.f20323e = new ConcernEmotionTipAdapter(this.f20321c.getContext());
            this.f20324f = new c.a.u0.p1.d.e.b(this.f20321c, c.a.u0.g0.d0.j.R0);
            this.f20325g = new c.a.u0.p1.d.e.a(this.f20321c, c.a.u0.g0.d0.j.S0);
            this.f20326h = new v(this.f20321c, c.a.u0.g0.d0.k.v0);
            this.C = new p(this.f20321c, c.a.u0.g0.d0.k.w0);
            this.D = new e(this.f20321c, c.a.u0.g0.d0.k.x0);
            this.E = new q(this.f20321c, c.a.u0.g0.d0.k.y0);
            this.F = new ConcernEmotionTipAdapter(this.f20321c.getContext(), c.a.u0.p1.d.f.b.f20419j);
            this.G = new a0(this.f20321c, c.a.u0.g0.d0.k.B0, (byte) 4);
            this.a.add(this.f20322d);
            this.a.add(this.f20323e);
            this.a.add(this.f20324f);
            this.a.add(this.f20325g);
            this.a.add(this.f20326h);
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
            if (!e2.X3.get()) {
                AdvertAppInfo.A4.set(false);
                return;
            }
            this.H = new ArrayList<>();
            c.a.d.o.e.a<?, ?> j2 = c.a.u0.l3.y.q().j(this.f20321c, AdvertAppInfo.D4, "CONCERN");
            c.a.d.o.e.a<?, ?> j3 = c.a.u0.l3.y.q().j(this.f20321c, AdvertAppInfo.E4, "CONCERN");
            c.a.d.o.e.a<?, ?> j4 = c.a.u0.l3.y.q().j(this.f20321c, AdvertAppInfo.F4, "CONCERN");
            c.a.d.o.e.a<?, ?> j5 = c.a.u0.l3.y.q().j(this.f20321c, AdvertAppInfo.G4, "CONCERN");
            c.a.d.o.e.a<?, ?> j6 = c.a.u0.l3.y.q().j(this.f20321c, AdvertAppInfo.H4, "CONCERN");
            c.a.d.o.e.a<?, ?> j7 = c.a.u0.l3.y.q().j(this.f20321c, AdvertAppInfo.J4, "CONCERN");
            c.a.d.o.e.a<?, ?> j8 = c.a.u0.l3.y.q().j(this.f20321c, AdvertAppInfo.I4, "CONCERN");
            this.H.add(j2);
            this.H.add(j3);
            this.H.add(j4);
            this.H.add(j5);
            this.H.add(j6);
            this.H.add(j7);
            this.H.add(j8);
            this.a.addAll(this.H);
            AdvertAppInfo.A4.set(true);
        }
    }

    public void d() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdTypeRecyclerView = this.f20320b) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || c.a.u0.z1.o.k.a.e(this.I)) {
            return;
        }
        Iterator<c.a.d.o.e.a> it = this.H.iterator();
        while (it.hasNext()) {
            c.a.d.o.e.a next = it.next();
            if (next instanceof c.a.u0.l3.p) {
                ((c.a.u0.l3.p) next).onDestroy();
            }
        }
    }

    public final void g(String str) {
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (list = this.a) == null) {
            return;
        }
        for (c.a.d.o.e.a aVar : list) {
            if (aVar instanceof c.a.u0.t.f) {
                ((c.a.u0.t.f) aVar).g(str);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<r> it = this.f20327i.iterator();
            while (it.hasNext()) {
                it.next().m = bdUniqueId;
            }
            this.f20324f.m = bdUniqueId;
            this.f20325g.m = bdUniqueId;
            this.f20326h.m = bdUniqueId;
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

    public final void i(c.a.d.o.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sVar) == null) {
            Iterator<r> it = this.f20327i.iterator();
            while (it.hasNext()) {
                it.next().o0(sVar);
            }
            this.f20328j.j0(sVar);
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
            this.f20320b.setData(list);
        }
    }
}
