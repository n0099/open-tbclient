package c.a.r0.h1.c;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.e.l.e.n;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.v1;
import c.a.r0.h1.c.e.e;
import c.a.r0.h1.c.e.f;
import c.a.r0.h1.c.e.g;
import c.a.r0.h1.c.e.h;
import c.a.r0.h1.c.e.i;
import c.a.r0.h1.c.e.j;
import c.a.r0.h1.c.e.k;
import c.a.r0.h1.c.e.l;
import c.a.r0.h1.c.e.m;
import c.a.r0.h1.c.e.o;
import c.a.r0.h1.c.e.p;
import c.a.r0.h1.c.e.q;
import c.a.r0.h1.c.e.r;
import c.a.r0.h1.c.e.s;
import c.a.r0.h1.c.e.t;
import c.a.r0.h1.c.e.u;
import c.a.r0.h1.c.e.v;
import c.a.r0.h1.c.e.w;
import c.a.r0.h1.c.e.x;
import c.a.r0.h1.c.e.y;
import c.a.r0.h1.c.e.z;
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
    public c.a.r0.h1.c.e.d A;
    public p B;
    public e C;
    public q D;
    public ConcernEmotionTipAdapter E;
    public z F;
    public ArrayList<c.a.e.l.e.a> G;
    public List<n> H;

    /* renamed from: a  reason: collision with root package name */
    public List<c.a.e.l.e.a> f17944a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f17945b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f17946c;

    /* renamed from: d  reason: collision with root package name */
    public ConcernTipAdapter f17947d;

    /* renamed from: e  reason: collision with root package name */
    public ConcernEmotionTipAdapter f17948e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.h1.c.e.b f17949f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.h1.c.e.a f17950g;

    /* renamed from: h  reason: collision with root package name */
    public v f17951h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<r> f17952i;

    /* renamed from: j  reason: collision with root package name */
    public x f17953j;
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
    public c.a.r0.h1.c.e.n w;
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
        this.f17952i = new ArrayList<>();
        this.f17944a = new ArrayList();
        this.f17945b = bdTypeRecyclerView;
        this.f17946c = (TbPageContext) c.a.e.a.j.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.f17944a);
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.H : (List) invokeV.objValue;
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            for (int i2 = 0; i2 < c.a.r0.b0.e0.b.R.size(); i2++) {
                for (int i3 = 0; i3 < c.a.r0.b0.e0.b.S.size(); i3++) {
                    this.f17952i.add(new r(this.f17946c, c.a.r0.b0.e0.b.T[i2][i3], c.a.r0.b0.e0.b.R.get(i2), c.a.r0.b0.e0.b.S.get(i3)));
                }
            }
            this.f17953j = new x(this.f17946c, d2.x3, c.a.r0.b0.e0.b.H);
            this.k = new x(this.f17946c, d2.b3, c.a.r0.b0.e0.b.I);
            this.l = new j(this.f17946c, d2.Q3, c.a.r0.b0.e0.b.H);
            this.m = new w(this.f17946c, c.a.r0.b0.e0.k.C0);
            this.n = new l(this.f17946c, c.a.r0.b0.e0.k.D0);
            this.u = new k(this.f17946c, c.a.r0.b0.e0.k.J0);
            this.v = new m(this.f17946c, c.a.r0.b0.e0.k.K0);
            this.o = new u(this.f17946c, c.a.r0.b0.e0.k.I0);
            this.p = new i(this.f17946c, c.a.r0.b0.e0.k.E0);
            this.q = new h(this.f17946c, c.a.r0.b0.e0.k.F0);
            this.r = new g(this.f17946c, c.a.r0.b0.e0.k.G0);
            this.t = new y(this.f17946c, c.a.r0.b0.e0.l.X);
            this.A = new c.a.r0.h1.c.e.d(this.f17946c, c.a.r0.b0.e0.e.P0);
            this.s = new f(this.f17946c, c.a.r0.b0.e0.k.H0);
            this.z = new s(this.f17946c, v1.f14348i);
            this.w = new c.a.r0.h1.c.e.n(this.f17946c, c.a.r0.b0.e0.k.L0);
            this.x = new t(this.f17946c, c.a.r0.b0.e0.k.M0);
            this.y = new o(this.f17946c, c.a.r0.b0.e0.k.N0);
            this.f17944a.addAll(this.f17952i);
            this.f17944a.add(this.f17953j);
            this.f17944a.add(this.k);
            this.f17944a.add(this.l);
            this.f17944a.add(this.m);
            this.f17944a.add(this.n);
            this.f17944a.add(this.u);
            this.f17944a.add(this.v);
            this.f17944a.add(this.o);
            this.f17944a.add(this.p);
            this.f17944a.add(this.q);
            this.f17944a.add(this.r);
            this.f17944a.add(this.t);
            this.f17944a.add(this.s);
            this.f17944a.add(this.z);
            this.f17944a.add(this.w);
            this.f17944a.add(this.x);
            this.f17944a.add(this.y);
            this.f17947d = new ConcernTipAdapter(this.f17946c.getContext());
            this.f17948e = new ConcernEmotionTipAdapter(this.f17946c.getContext());
            this.f17949f = new c.a.r0.h1.c.e.b(this.f17946c, c.a.r0.b0.e0.j.P0);
            this.f17950g = new c.a.r0.h1.c.e.a(this.f17946c, c.a.r0.b0.e0.j.Q0);
            this.f17951h = new v(this.f17946c, c.a.r0.b0.e0.k.v0);
            this.B = new p(this.f17946c, c.a.r0.b0.e0.k.w0);
            this.C = new e(this.f17946c, c.a.r0.b0.e0.k.x0);
            this.D = new q(this.f17946c, c.a.r0.b0.e0.k.y0);
            this.E = new ConcernEmotionTipAdapter(this.f17946c.getContext(), c.a.r0.h1.c.f.b.f18076j);
            this.F = new z(this.f17946c, c.a.r0.b0.e0.k.B0, (byte) 4);
            this.f17944a.add(this.f17947d);
            this.f17944a.add(this.f17948e);
            this.f17944a.add(this.f17949f);
            this.f17944a.add(this.f17950g);
            this.f17944a.add(this.f17951h);
            this.f17944a.add(this.B);
            this.f17944a.add(this.C);
            this.f17944a.add(this.D);
            this.f17944a.add(this.A);
            this.f17944a.add(this.E);
            this.f17944a.add(this.F);
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
            c.a.e.l.e.a<?, ?> j2 = c.a.r0.z2.y.o().j(this.f17946c, AdvertAppInfo.t4, "CONCERN");
            c.a.e.l.e.a<?, ?> j3 = c.a.r0.z2.y.o().j(this.f17946c, AdvertAppInfo.u4, "CONCERN");
            c.a.e.l.e.a<?, ?> j4 = c.a.r0.z2.y.o().j(this.f17946c, AdvertAppInfo.v4, "CONCERN");
            c.a.e.l.e.a<?, ?> j5 = c.a.r0.z2.y.o().j(this.f17946c, AdvertAppInfo.w4, "CONCERN");
            c.a.e.l.e.a<?, ?> j6 = c.a.r0.z2.y.o().j(this.f17946c, AdvertAppInfo.x4, "CONCERN");
            c.a.e.l.e.a<?, ?> j7 = c.a.r0.z2.y.o().j(this.f17946c, AdvertAppInfo.z4, "CONCERN");
            c.a.e.l.e.a<?, ?> j8 = c.a.r0.z2.y.o().j(this.f17946c, AdvertAppInfo.y4, "CONCERN");
            this.G.add(j2);
            this.G.add(j3);
            this.G.add(j4);
            this.G.add(j5);
            this.G.add(j6);
            this.G.add(j7);
            this.G.add(j8);
            this.f17944a.addAll(this.G);
            AdvertAppInfo.q4.set(true);
        }
    }

    public void d() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdTypeRecyclerView = this.f17945b) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || c.a.r0.q1.o.k.a.e(this.H)) {
            return;
        }
        Iterator<c.a.e.l.e.a> it = this.G.iterator();
        while (it.hasNext()) {
            c.a.e.l.e.a next = it.next();
            if (next instanceof c.a.r0.z2.p) {
                ((c.a.r0.z2.p) next).onDestroy();
            }
        }
    }

    public final void g(String str) {
        List<c.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (list = this.f17944a) == null) {
            return;
        }
        for (c.a.e.l.e.a aVar : list) {
            if (aVar instanceof c.a.r0.p.f) {
                ((c.a.r0.p.f) aVar).g(str);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<r> it = this.f17952i.iterator();
            while (it.hasNext()) {
                it.next().m = bdUniqueId;
            }
            this.f17949f.m = bdUniqueId;
            this.f17950g.m = bdUniqueId;
            this.f17951h.m = bdUniqueId;
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
            Iterator<r> it = this.f17952i.iterator();
            while (it.hasNext()) {
                it.next().w0(sVar);
            }
            this.f17953j.r0(sVar);
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
            this.f17945b.setData(list);
        }
    }
}
