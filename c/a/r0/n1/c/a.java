package c.a.r0.n1.c;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.d.m.e.n;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.v1;
import c.a.r0.n1.c.e.a0;
import c.a.r0.n1.c.e.e;
import c.a.r0.n1.c.e.f;
import c.a.r0.n1.c.e.g;
import c.a.r0.n1.c.e.h;
import c.a.r0.n1.c.e.i;
import c.a.r0.n1.c.e.j;
import c.a.r0.n1.c.e.k;
import c.a.r0.n1.c.e.l;
import c.a.r0.n1.c.e.m;
import c.a.r0.n1.c.e.o;
import c.a.r0.n1.c.e.p;
import c.a.r0.n1.c.e.q;
import c.a.r0.n1.c.e.r;
import c.a.r0.n1.c.e.s;
import c.a.r0.n1.c.e.t;
import c.a.r0.n1.c.e.u;
import c.a.r0.n1.c.e.v;
import c.a.r0.n1.c.e.w;
import c.a.r0.n1.c.e.x;
import c.a.r0.n1.c.e.y;
import c.a.r0.n1.c.e.z;
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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public s A;
    public c.a.r0.n1.c.e.d B;
    public p C;
    public e D;
    public q E;
    public ConcernEmotionTipAdapter F;
    public a0 G;
    public ArrayList<c.a.d.m.e.a> H;
    public List<n> I;
    public List<c.a.d.m.e.a> a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f20099b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f20100c;

    /* renamed from: d  reason: collision with root package name */
    public ConcernTipAdapter f20101d;

    /* renamed from: e  reason: collision with root package name */
    public ConcernEmotionTipAdapter f20102e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.n1.c.e.b f20103f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.n1.c.e.a f20104g;

    /* renamed from: h  reason: collision with root package name */
    public v f20105h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<r> f20106i;

    /* renamed from: j  reason: collision with root package name */
    public x f20107j;

    /* renamed from: k  reason: collision with root package name */
    public x f20108k;
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
    public c.a.r0.n1.c.e.n w;
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
        this.f20106i = new ArrayList<>();
        this.a = new ArrayList();
        this.f20099b = bdTypeRecyclerView;
        this.f20100c = (TbPageContext) c.a.d.a.j.a(context);
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
            for (int i2 = 0; i2 < c.a.r0.g0.f0.b.T.size(); i2++) {
                for (int i3 = 0; i3 < c.a.r0.g0.f0.b.U.size(); i3++) {
                    this.f20106i.add(new r(this.f20100c, c.a.r0.g0.f0.b.V[i2][i3], c.a.r0.g0.f0.b.T.get(i2), c.a.r0.g0.f0.b.U.get(i3)));
                }
            }
            this.f20107j = new x(this.f20100c, d2.D3, c.a.r0.g0.f0.b.I);
            this.f20108k = new x(this.f20100c, d2.g3, c.a.r0.g0.f0.b.J);
            this.l = new j(this.f20100c, d2.V3, c.a.r0.g0.f0.b.I);
            this.m = new w(this.f20100c, c.a.r0.g0.f0.k.F0);
            this.n = new l(this.f20100c, c.a.r0.g0.f0.k.G0);
            this.u = new k(this.f20100c, c.a.r0.g0.f0.k.N0);
            this.v = new m(this.f20100c, c.a.r0.g0.f0.k.O0);
            this.o = new u(this.f20100c, c.a.r0.g0.f0.k.M0);
            this.p = new i(this.f20100c, c.a.r0.g0.f0.k.H0);
            this.q = new h(this.f20100c, c.a.r0.g0.f0.k.I0);
            this.r = new g(this.f20100c, c.a.r0.g0.f0.k.J0);
            this.t = new y(this.f20100c, c.a.r0.g0.f0.l.Z);
            this.B = new c.a.r0.n1.c.e.d(this.f20100c, c.a.r0.g0.f0.e.T0);
            this.s = new f(this.f20100c, c.a.r0.g0.f0.k.K0);
            this.A = new s(this.f20100c, v1.f13067i);
            this.w = new c.a.r0.n1.c.e.n(this.f20100c, c.a.r0.g0.f0.k.P0);
            this.x = new t(this.f20100c, c.a.r0.g0.f0.k.Q0);
            this.y = new o(this.f20100c, c.a.r0.g0.f0.k.R0);
            this.z = new z(this.f20100c, d2.r3);
            this.a.addAll(this.f20106i);
            this.a.add(this.f20107j);
            this.a.add(this.f20108k);
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
            this.f20101d = new ConcernTipAdapter(this.f20100c.getContext());
            this.f20102e = new ConcernEmotionTipAdapter(this.f20100c.getContext());
            this.f20103f = new c.a.r0.n1.c.e.b(this.f20100c, c.a.r0.g0.f0.j.T0);
            this.f20104g = new c.a.r0.n1.c.e.a(this.f20100c, c.a.r0.g0.f0.j.U0);
            this.f20105h = new v(this.f20100c, c.a.r0.g0.f0.k.y0);
            this.C = new p(this.f20100c, c.a.r0.g0.f0.k.z0);
            this.D = new e(this.f20100c, c.a.r0.g0.f0.k.A0);
            this.E = new q(this.f20100c, c.a.r0.g0.f0.k.B0);
            this.F = new ConcernEmotionTipAdapter(this.f20100c.getContext(), c.a.r0.n1.c.f.b.f20202j);
            this.G = new a0(this.f20100c, c.a.r0.g0.f0.k.E0, (byte) 4);
            this.a.add(this.f20101d);
            this.a.add(this.f20102e);
            this.a.add(this.f20103f);
            this.a.add(this.f20104g);
            this.a.add(this.f20105h);
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
            if (!d2.T3.get()) {
                AdvertAppInfo.w4.set(false);
                return;
            }
            this.H = new ArrayList<>();
            c.a.d.m.e.a<?, ?> j2 = c.a.r0.h3.y.q().j(this.f20100c, AdvertAppInfo.z4, "CONCERN");
            c.a.d.m.e.a<?, ?> j3 = c.a.r0.h3.y.q().j(this.f20100c, AdvertAppInfo.A4, "CONCERN");
            c.a.d.m.e.a<?, ?> j4 = c.a.r0.h3.y.q().j(this.f20100c, AdvertAppInfo.B4, "CONCERN");
            c.a.d.m.e.a<?, ?> j5 = c.a.r0.h3.y.q().j(this.f20100c, AdvertAppInfo.C4, "CONCERN");
            c.a.d.m.e.a<?, ?> j6 = c.a.r0.h3.y.q().j(this.f20100c, AdvertAppInfo.D4, "CONCERN");
            c.a.d.m.e.a<?, ?> j7 = c.a.r0.h3.y.q().j(this.f20100c, AdvertAppInfo.F4, "CONCERN");
            c.a.d.m.e.a<?, ?> j8 = c.a.r0.h3.y.q().j(this.f20100c, AdvertAppInfo.E4, "CONCERN");
            this.H.add(j2);
            this.H.add(j3);
            this.H.add(j4);
            this.H.add(j5);
            this.H.add(j6);
            this.H.add(j7);
            this.H.add(j8);
            this.a.addAll(this.H);
            AdvertAppInfo.w4.set(true);
        }
    }

    public void d() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdTypeRecyclerView = this.f20099b) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || c.a.r0.w1.o.k.a.e(this.I)) {
            return;
        }
        Iterator<c.a.d.m.e.a> it = this.H.iterator();
        while (it.hasNext()) {
            c.a.d.m.e.a next = it.next();
            if (next instanceof c.a.r0.h3.p) {
                ((c.a.r0.h3.p) next).onDestroy();
            }
        }
    }

    public final void g(String str) {
        List<c.a.d.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (list = this.a) == null) {
            return;
        }
        for (c.a.d.m.e.a aVar : list) {
            if (aVar instanceof c.a.r0.t.f) {
                ((c.a.r0.t.f) aVar).g(str);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<r> it = this.f20106i.iterator();
            while (it.hasNext()) {
                it.next().m = bdUniqueId;
            }
            this.f20103f.m = bdUniqueId;
            this.f20104g.m = bdUniqueId;
            this.f20105h.m = bdUniqueId;
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

    public final void i(c.a.d.m.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sVar) == null) {
            Iterator<r> it = this.f20106i.iterator();
            while (it.hasNext()) {
                it.next().v0(sVar);
            }
            this.f20107j.q0(sVar);
            this.f20108k.q0(sVar);
            this.l.l0(sVar);
            this.m.l0(sVar);
            this.n.m0(sVar);
            this.u.l0(sVar);
            this.v.l0(sVar);
            this.o.l0(sVar);
            this.A.j0(sVar);
            this.w.i0(sVar);
            this.x.j0(sVar);
            this.y.i0(sVar);
            this.z.l0(sVar);
            this.p.l0(sVar);
            this.q.l0(sVar);
            this.r.l0(sVar);
            this.t.o0(sVar);
            this.s.m0(sVar);
            this.B.m0(sVar);
            this.D.l0(sVar);
            this.C.m0(sVar);
            this.E.m0(sVar);
            this.G.i0(sVar);
        }
    }

    public void j(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.I = list;
            this.f20099b.setData(list);
        }
    }
}
