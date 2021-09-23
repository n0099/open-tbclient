package c.a.r0.g1.c;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.e.l.e.n;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.v1;
import c.a.r0.g1.c.e.e;
import c.a.r0.g1.c.e.f;
import c.a.r0.g1.c.e.g;
import c.a.r0.g1.c.e.h;
import c.a.r0.g1.c.e.i;
import c.a.r0.g1.c.e.j;
import c.a.r0.g1.c.e.k;
import c.a.r0.g1.c.e.l;
import c.a.r0.g1.c.e.m;
import c.a.r0.g1.c.e.o;
import c.a.r0.g1.c.e.p;
import c.a.r0.g1.c.e.q;
import c.a.r0.g1.c.e.r;
import c.a.r0.g1.c.e.s;
import c.a.r0.g1.c.e.t;
import c.a.r0.g1.c.e.u;
import c.a.r0.g1.c.e.v;
import c.a.r0.g1.c.e.w;
import c.a.r0.g1.c.e.x;
import c.a.r0.g1.c.e.y;
import c.a.r0.g1.c.e.z;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.g1.c.e.d A;
    public p B;
    public e C;
    public q D;
    public ConcernEmotionTipAdapter E;
    public z F;
    public ArrayList<c.a.e.l.e.a> G;
    public List<n> H;

    /* renamed from: a  reason: collision with root package name */
    public List<c.a.e.l.e.a> f17777a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f17778b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f17779c;

    /* renamed from: d  reason: collision with root package name */
    public ConcernTipAdapter f17780d;

    /* renamed from: e  reason: collision with root package name */
    public ConcernEmotionTipAdapter f17781e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.g1.c.e.b f17782f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.g1.c.e.a f17783g;

    /* renamed from: h  reason: collision with root package name */
    public v f17784h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<r> f17785i;

    /* renamed from: j  reason: collision with root package name */
    public x f17786j;
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
    public c.a.r0.g1.c.e.n w;
    public t x;
    public o y;
    public s z;

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
        this.f17785i = new ArrayList<>();
        this.f17777a = new ArrayList();
        this.f17778b = bdTypeRecyclerView;
        this.f17779c = (TbPageContext) c.a.e.a.j.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.f17777a);
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.H : (List) invokeV.objValue;
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            for (int i2 = 0; i2 < c.a.r0.a0.d0.b.R.size(); i2++) {
                for (int i3 = 0; i3 < c.a.r0.a0.d0.b.S.size(); i3++) {
                    this.f17785i.add(new r(this.f17779c, c.a.r0.a0.d0.b.T[i2][i3], c.a.r0.a0.d0.b.R.get(i2), c.a.r0.a0.d0.b.S.get(i3)));
                }
            }
            this.f17786j = new x(this.f17779c, d2.x3, c.a.r0.a0.d0.b.H);
            this.k = new x(this.f17779c, d2.b3, c.a.r0.a0.d0.b.I);
            this.l = new j(this.f17779c, d2.Q3, c.a.r0.a0.d0.b.H);
            this.m = new w(this.f17779c, c.a.r0.a0.d0.k.C0);
            this.n = new l(this.f17779c, c.a.r0.a0.d0.k.D0);
            this.u = new k(this.f17779c, c.a.r0.a0.d0.k.J0);
            this.v = new m(this.f17779c, c.a.r0.a0.d0.k.K0);
            this.o = new u(this.f17779c, c.a.r0.a0.d0.k.I0);
            this.p = new i(this.f17779c, c.a.r0.a0.d0.k.E0);
            this.q = new h(this.f17779c, c.a.r0.a0.d0.k.F0);
            this.r = new g(this.f17779c, c.a.r0.a0.d0.k.G0);
            this.t = new y(this.f17779c, c.a.r0.a0.d0.l.X);
            this.A = new c.a.r0.g1.c.e.d(this.f17779c, c.a.r0.a0.d0.e.P0);
            this.s = new f(this.f17779c, c.a.r0.a0.d0.k.H0);
            this.z = new s(this.f17779c, v1.f14328i);
            this.w = new c.a.r0.g1.c.e.n(this.f17779c, c.a.r0.a0.d0.k.L0);
            this.x = new t(this.f17779c, c.a.r0.a0.d0.k.M0);
            this.y = new o(this.f17779c, c.a.r0.a0.d0.k.N0);
            this.f17777a.addAll(this.f17785i);
            this.f17777a.add(this.f17786j);
            this.f17777a.add(this.k);
            this.f17777a.add(this.l);
            this.f17777a.add(this.m);
            this.f17777a.add(this.n);
            this.f17777a.add(this.u);
            this.f17777a.add(this.v);
            this.f17777a.add(this.o);
            this.f17777a.add(this.p);
            this.f17777a.add(this.q);
            this.f17777a.add(this.r);
            this.f17777a.add(this.t);
            this.f17777a.add(this.s);
            this.f17777a.add(this.z);
            this.f17777a.add(this.w);
            this.f17777a.add(this.x);
            this.f17777a.add(this.y);
            this.f17780d = new ConcernTipAdapter(this.f17779c.getContext());
            this.f17781e = new ConcernEmotionTipAdapter(this.f17779c.getContext());
            this.f17782f = new c.a.r0.g1.c.e.b(this.f17779c, c.a.r0.a0.d0.j.P0);
            this.f17783g = new c.a.r0.g1.c.e.a(this.f17779c, c.a.r0.a0.d0.j.Q0);
            this.f17784h = new v(this.f17779c, c.a.r0.a0.d0.k.v0);
            this.B = new p(this.f17779c, c.a.r0.a0.d0.k.w0);
            this.C = new e(this.f17779c, c.a.r0.a0.d0.k.x0);
            this.D = new q(this.f17779c, c.a.r0.a0.d0.k.y0);
            this.E = new ConcernEmotionTipAdapter(this.f17779c.getContext(), c.a.r0.g1.c.f.b.f17908j);
            this.F = new z(this.f17779c, c.a.r0.a0.d0.k.B0, (byte) 4);
            this.f17777a.add(this.f17780d);
            this.f17777a.add(this.f17781e);
            this.f17777a.add(this.f17782f);
            this.f17777a.add(this.f17783g);
            this.f17777a.add(this.f17784h);
            this.f17777a.add(this.B);
            this.f17777a.add(this.C);
            this.f17777a.add(this.D);
            this.f17777a.add(this.A);
            this.f17777a.add(this.E);
            this.f17777a.add(this.F);
            g("page_concern");
            c();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!d2.N3.get()) {
                AdvertAppInfo.q4.set(false);
                return;
            }
            this.G = new ArrayList<>();
            c.a.e.l.e.a<?, ?> j2 = c.a.r0.y2.y.o().j(this.f17779c, AdvertAppInfo.t4, "CONCERN");
            c.a.e.l.e.a<?, ?> j3 = c.a.r0.y2.y.o().j(this.f17779c, AdvertAppInfo.u4, "CONCERN");
            c.a.e.l.e.a<?, ?> j4 = c.a.r0.y2.y.o().j(this.f17779c, AdvertAppInfo.v4, "CONCERN");
            c.a.e.l.e.a<?, ?> j5 = c.a.r0.y2.y.o().j(this.f17779c, AdvertAppInfo.w4, "CONCERN");
            c.a.e.l.e.a<?, ?> j6 = c.a.r0.y2.y.o().j(this.f17779c, AdvertAppInfo.x4, "CONCERN");
            c.a.e.l.e.a<?, ?> j7 = c.a.r0.y2.y.o().j(this.f17779c, AdvertAppInfo.z4, "CONCERN");
            c.a.e.l.e.a<?, ?> j8 = c.a.r0.y2.y.o().j(this.f17779c, AdvertAppInfo.y4, "CONCERN");
            this.G.add(j2);
            this.G.add(j3);
            this.G.add(j4);
            this.G.add(j5);
            this.G.add(j6);
            this.G.add(j7);
            this.G.add(j8);
            this.f17777a.addAll(this.G);
            AdvertAppInfo.q4.set(true);
        }
    }

    public void d() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdTypeRecyclerView = this.f17778b) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || c.a.r0.p1.o.k.a.e(this.H)) {
            return;
        }
        Iterator<c.a.e.l.e.a> it = this.G.iterator();
        while (it.hasNext()) {
            c.a.e.l.e.a next = it.next();
            if (next instanceof c.a.r0.y2.p) {
                ((c.a.r0.y2.p) next).onDestroy();
            }
        }
    }

    public final void g(String str) {
        List<c.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (list = this.f17777a) == null) {
            return;
        }
        for (c.a.e.l.e.a aVar : list) {
            if (aVar instanceof c.a.r0.o.f) {
                ((c.a.r0.o.f) aVar).g(str);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<r> it = this.f17785i.iterator();
            while (it.hasNext()) {
                it.next().m = bdUniqueId;
            }
            this.f17782f.m = bdUniqueId;
            this.f17783g.m = bdUniqueId;
            this.f17784h.m = bdUniqueId;
            this.D.m = bdUniqueId;
            this.B.m = bdUniqueId;
            this.C.m = bdUniqueId;
            this.A.m = bdUniqueId;
            this.s.m = bdUniqueId;
            this.z.m = bdUniqueId;
            this.F.n = bdUniqueId;
        }
    }

    public final void i(c.a.e.l.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sVar) == null) {
            Iterator<r> it = this.f17785i.iterator();
            while (it.hasNext()) {
                it.next().w0(sVar);
            }
            this.f17786j.r0(sVar);
            this.k.r0(sVar);
            this.l.m0(sVar);
            this.m.m0(sVar);
            this.n.n0(sVar);
            this.u.m0(sVar);
            this.v.m0(sVar);
            this.o.m0(sVar);
            this.z.k0(sVar);
            this.w.j0(sVar);
            this.x.k0(sVar);
            this.y.j0(sVar);
            this.p.m0(sVar);
            this.q.m0(sVar);
            this.r.m0(sVar);
            this.t.p0(sVar);
            this.s.n0(sVar);
            this.A.n0(sVar);
            this.C.m0(sVar);
            this.B.n0(sVar);
            this.D.n0(sVar);
            this.F.j0(sVar);
        }
    }

    public void j(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.H = list;
            this.f17778b.setData(list);
        }
    }
}
