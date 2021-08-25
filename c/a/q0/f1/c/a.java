package c.a.q0.f1.c;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.e.l.e.n;
import c.a.p0.s.q.c2;
import c.a.p0.s.q.u1;
import c.a.q0.f1.c.e.e;
import c.a.q0.f1.c.e.f;
import c.a.q0.f1.c.e.g;
import c.a.q0.f1.c.e.h;
import c.a.q0.f1.c.e.i;
import c.a.q0.f1.c.e.j;
import c.a.q0.f1.c.e.k;
import c.a.q0.f1.c.e.l;
import c.a.q0.f1.c.e.m;
import c.a.q0.f1.c.e.o;
import c.a.q0.f1.c.e.p;
import c.a.q0.f1.c.e.q;
import c.a.q0.f1.c.e.r;
import c.a.q0.f1.c.e.s;
import c.a.q0.f1.c.e.t;
import c.a.q0.f1.c.e.u;
import c.a.q0.f1.c.e.v;
import c.a.q0.f1.c.e.w;
import c.a.q0.f1.c.e.x;
import c.a.q0.f1.c.e.y;
import c.a.q0.f1.c.e.z;
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
    public c.a.q0.f1.c.e.d A;
    public p B;
    public e C;
    public q D;
    public ConcernEmotionTipAdapter E;
    public z F;
    public ArrayList<c.a.e.l.e.a> G;
    public List<n> H;

    /* renamed from: a  reason: collision with root package name */
    public List<c.a.e.l.e.a> f17243a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f17244b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f17245c;

    /* renamed from: d  reason: collision with root package name */
    public ConcernTipAdapter f17246d;

    /* renamed from: e  reason: collision with root package name */
    public ConcernEmotionTipAdapter f17247e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.f1.c.e.b f17248f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.f1.c.e.a f17249g;

    /* renamed from: h  reason: collision with root package name */
    public v f17250h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<r> f17251i;

    /* renamed from: j  reason: collision with root package name */
    public x f17252j;
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
    public c.a.q0.f1.c.e.n w;
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
        this.f17251i = new ArrayList<>();
        this.f17243a = new ArrayList();
        this.f17244b = bdTypeRecyclerView;
        this.f17245c = (TbPageContext) c.a.e.a.j.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.f17243a);
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.H : (List) invokeV.objValue;
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            for (int i2 = 0; i2 < c.a.q0.a0.d0.b.R.size(); i2++) {
                for (int i3 = 0; i3 < c.a.q0.a0.d0.b.S.size(); i3++) {
                    this.f17251i.add(new r(this.f17245c, c.a.q0.a0.d0.b.T[i2][i3], c.a.q0.a0.d0.b.R.get(i2), c.a.q0.a0.d0.b.S.get(i3)));
                }
            }
            this.f17252j = new x(this.f17245c, c2.t3, c.a.q0.a0.d0.b.H);
            this.k = new x(this.f17245c, c2.X2, c.a.q0.a0.d0.b.I);
            this.l = new j(this.f17245c, c2.M3, c.a.q0.a0.d0.b.H);
            this.m = new w(this.f17245c, c.a.q0.a0.d0.k.C0);
            this.n = new l(this.f17245c, c.a.q0.a0.d0.k.D0);
            this.u = new k(this.f17245c, c.a.q0.a0.d0.k.J0);
            this.v = new m(this.f17245c, c.a.q0.a0.d0.k.K0);
            this.o = new u(this.f17245c, c.a.q0.a0.d0.k.I0);
            this.p = new i(this.f17245c, c.a.q0.a0.d0.k.E0);
            this.q = new h(this.f17245c, c.a.q0.a0.d0.k.F0);
            this.r = new g(this.f17245c, c.a.q0.a0.d0.k.G0);
            this.t = new y(this.f17245c, c.a.q0.a0.d0.l.X);
            this.A = new c.a.q0.f1.c.e.d(this.f17245c, c.a.q0.a0.d0.e.P0);
            this.s = new f(this.f17245c, c.a.q0.a0.d0.k.H0);
            this.z = new s(this.f17245c, u1.f14358i);
            this.w = new c.a.q0.f1.c.e.n(this.f17245c, c.a.q0.a0.d0.k.L0);
            this.x = new t(this.f17245c, c.a.q0.a0.d0.k.M0);
            this.y = new o(this.f17245c, c.a.q0.a0.d0.k.N0);
            this.f17243a.addAll(this.f17251i);
            this.f17243a.add(this.f17252j);
            this.f17243a.add(this.k);
            this.f17243a.add(this.l);
            this.f17243a.add(this.m);
            this.f17243a.add(this.n);
            this.f17243a.add(this.u);
            this.f17243a.add(this.v);
            this.f17243a.add(this.o);
            this.f17243a.add(this.p);
            this.f17243a.add(this.q);
            this.f17243a.add(this.r);
            this.f17243a.add(this.t);
            this.f17243a.add(this.s);
            this.f17243a.add(this.z);
            this.f17243a.add(this.w);
            this.f17243a.add(this.x);
            this.f17243a.add(this.y);
            this.f17246d = new ConcernTipAdapter(this.f17245c.getContext());
            this.f17247e = new ConcernEmotionTipAdapter(this.f17245c.getContext());
            this.f17248f = new c.a.q0.f1.c.e.b(this.f17245c, c.a.q0.a0.d0.j.P0);
            this.f17249g = new c.a.q0.f1.c.e.a(this.f17245c, c.a.q0.a0.d0.j.Q0);
            this.f17250h = new v(this.f17245c, c.a.q0.a0.d0.k.v0);
            this.B = new p(this.f17245c, c.a.q0.a0.d0.k.w0);
            this.C = new e(this.f17245c, c.a.q0.a0.d0.k.x0);
            this.D = new q(this.f17245c, c.a.q0.a0.d0.k.y0);
            this.E = new ConcernEmotionTipAdapter(this.f17245c.getContext(), c.a.q0.f1.c.f.b.f17375j);
            this.F = new z(this.f17245c, c.a.q0.a0.d0.k.B0, (byte) 4);
            this.f17243a.add(this.f17246d);
            this.f17243a.add(this.f17247e);
            this.f17243a.add(this.f17248f);
            this.f17243a.add(this.f17249g);
            this.f17243a.add(this.f17250h);
            this.f17243a.add(this.B);
            this.f17243a.add(this.C);
            this.f17243a.add(this.D);
            this.f17243a.add(this.A);
            this.f17243a.add(this.E);
            this.f17243a.add(this.F);
            g("page_concern");
            c();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!c2.J3.get()) {
                AdvertAppInfo.m4.set(false);
                return;
            }
            this.G = new ArrayList<>();
            c.a.e.l.e.a<?, ?> j2 = c.a.q0.x2.y.o().j(this.f17245c, AdvertAppInfo.p4, "CONCERN");
            c.a.e.l.e.a<?, ?> j3 = c.a.q0.x2.y.o().j(this.f17245c, AdvertAppInfo.q4, "CONCERN");
            c.a.e.l.e.a<?, ?> j4 = c.a.q0.x2.y.o().j(this.f17245c, AdvertAppInfo.r4, "CONCERN");
            c.a.e.l.e.a<?, ?> j5 = c.a.q0.x2.y.o().j(this.f17245c, AdvertAppInfo.s4, "CONCERN");
            c.a.e.l.e.a<?, ?> j6 = c.a.q0.x2.y.o().j(this.f17245c, AdvertAppInfo.t4, "CONCERN");
            c.a.e.l.e.a<?, ?> j7 = c.a.q0.x2.y.o().j(this.f17245c, AdvertAppInfo.v4, "CONCERN");
            c.a.e.l.e.a<?, ?> j8 = c.a.q0.x2.y.o().j(this.f17245c, AdvertAppInfo.u4, "CONCERN");
            this.G.add(j2);
            this.G.add(j3);
            this.G.add(j4);
            this.G.add(j5);
            this.G.add(j6);
            this.G.add(j7);
            this.G.add(j8);
            this.f17243a.addAll(this.G);
            AdvertAppInfo.m4.set(true);
        }
    }

    public void d() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdTypeRecyclerView = this.f17244b) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || c.a.q0.o1.o.k.a.e(this.H)) {
            return;
        }
        Iterator<c.a.e.l.e.a> it = this.G.iterator();
        while (it.hasNext()) {
            c.a.e.l.e.a next = it.next();
            if (next instanceof c.a.q0.x2.p) {
                ((c.a.q0.x2.p) next).onDestroy();
            }
        }
    }

    public final void g(String str) {
        List<c.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (list = this.f17243a) == null) {
            return;
        }
        for (c.a.e.l.e.a aVar : list) {
            if (aVar instanceof c.a.q0.o.f) {
                ((c.a.q0.o.f) aVar).g(str);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<r> it = this.f17251i.iterator();
            while (it.hasNext()) {
                it.next().m = bdUniqueId;
            }
            this.f17248f.m = bdUniqueId;
            this.f17249g.m = bdUniqueId;
            this.f17250h.m = bdUniqueId;
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
            Iterator<r> it = this.f17251i.iterator();
            while (it.hasNext()) {
                it.next().w0(sVar);
            }
            this.f17252j.r0(sVar);
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
            this.f17244b.setData(list);
        }
    }
}
