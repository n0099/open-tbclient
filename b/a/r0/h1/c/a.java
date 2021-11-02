package b.a.r0.h1.c;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import b.a.e.l.e.n;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.v1;
import b.a.r0.h1.c.e.e;
import b.a.r0.h1.c.e.f;
import b.a.r0.h1.c.e.g;
import b.a.r0.h1.c.e.h;
import b.a.r0.h1.c.e.i;
import b.a.r0.h1.c.e.j;
import b.a.r0.h1.c.e.k;
import b.a.r0.h1.c.e.l;
import b.a.r0.h1.c.e.m;
import b.a.r0.h1.c.e.o;
import b.a.r0.h1.c.e.p;
import b.a.r0.h1.c.e.q;
import b.a.r0.h1.c.e.r;
import b.a.r0.h1.c.e.s;
import b.a.r0.h1.c.e.t;
import b.a.r0.h1.c.e.u;
import b.a.r0.h1.c.e.v;
import b.a.r0.h1.c.e.w;
import b.a.r0.h1.c.e.x;
import b.a.r0.h1.c.e.y;
import b.a.r0.h1.c.e.z;
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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b.a.r0.h1.c.e.d A;
    public p B;
    public e C;
    public q D;
    public ConcernEmotionTipAdapter E;
    public z F;
    public ArrayList<b.a.e.l.e.a> G;
    public List<n> H;

    /* renamed from: a  reason: collision with root package name */
    public List<b.a.e.l.e.a> f16898a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f16899b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f16900c;

    /* renamed from: d  reason: collision with root package name */
    public ConcernTipAdapter f16901d;

    /* renamed from: e  reason: collision with root package name */
    public ConcernEmotionTipAdapter f16902e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.h1.c.e.b f16903f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.h1.c.e.a f16904g;

    /* renamed from: h  reason: collision with root package name */
    public v f16905h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<r> f16906i;
    public x j;
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
    public b.a.r0.h1.c.e.n w;
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
        this.f16906i = new ArrayList<>();
        this.f16898a = new ArrayList();
        this.f16899b = bdTypeRecyclerView;
        this.f16900c = (TbPageContext) b.a.e.a.j.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.f16898a);
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.H : (List) invokeV.objValue;
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            for (int i2 = 0; i2 < b.a.r0.b0.e0.b.R.size(); i2++) {
                for (int i3 = 0; i3 < b.a.r0.b0.e0.b.S.size(); i3++) {
                    this.f16906i.add(new r(this.f16900c, b.a.r0.b0.e0.b.T[i2][i3], b.a.r0.b0.e0.b.R.get(i2), b.a.r0.b0.e0.b.S.get(i3)));
                }
            }
            this.j = new x(this.f16900c, d2.x3, b.a.r0.b0.e0.b.H);
            this.k = new x(this.f16900c, d2.b3, b.a.r0.b0.e0.b.I);
            this.l = new j(this.f16900c, d2.Q3, b.a.r0.b0.e0.b.H);
            this.m = new w(this.f16900c, b.a.r0.b0.e0.k.C0);
            this.n = new l(this.f16900c, b.a.r0.b0.e0.k.D0);
            this.u = new k(this.f16900c, b.a.r0.b0.e0.k.J0);
            this.v = new m(this.f16900c, b.a.r0.b0.e0.k.K0);
            this.o = new u(this.f16900c, b.a.r0.b0.e0.k.I0);
            this.p = new i(this.f16900c, b.a.r0.b0.e0.k.E0);
            this.q = new h(this.f16900c, b.a.r0.b0.e0.k.F0);
            this.r = new g(this.f16900c, b.a.r0.b0.e0.k.G0);
            this.t = new y(this.f16900c, b.a.r0.b0.e0.l.X);
            this.A = new b.a.r0.h1.c.e.d(this.f16900c, b.a.r0.b0.e0.e.P0);
            this.s = new f(this.f16900c, b.a.r0.b0.e0.k.H0);
            this.z = new s(this.f16900c, v1.f13462i);
            this.w = new b.a.r0.h1.c.e.n(this.f16900c, b.a.r0.b0.e0.k.L0);
            this.x = new t(this.f16900c, b.a.r0.b0.e0.k.M0);
            this.y = new o(this.f16900c, b.a.r0.b0.e0.k.N0);
            this.f16898a.addAll(this.f16906i);
            this.f16898a.add(this.j);
            this.f16898a.add(this.k);
            this.f16898a.add(this.l);
            this.f16898a.add(this.m);
            this.f16898a.add(this.n);
            this.f16898a.add(this.u);
            this.f16898a.add(this.v);
            this.f16898a.add(this.o);
            this.f16898a.add(this.p);
            this.f16898a.add(this.q);
            this.f16898a.add(this.r);
            this.f16898a.add(this.t);
            this.f16898a.add(this.s);
            this.f16898a.add(this.z);
            this.f16898a.add(this.w);
            this.f16898a.add(this.x);
            this.f16898a.add(this.y);
            this.f16901d = new ConcernTipAdapter(this.f16900c.getContext());
            this.f16902e = new ConcernEmotionTipAdapter(this.f16900c.getContext());
            this.f16903f = new b.a.r0.h1.c.e.b(this.f16900c, b.a.r0.b0.e0.j.P0);
            this.f16904g = new b.a.r0.h1.c.e.a(this.f16900c, b.a.r0.b0.e0.j.Q0);
            this.f16905h = new v(this.f16900c, b.a.r0.b0.e0.k.v0);
            this.B = new p(this.f16900c, b.a.r0.b0.e0.k.w0);
            this.C = new e(this.f16900c, b.a.r0.b0.e0.k.x0);
            this.D = new q(this.f16900c, b.a.r0.b0.e0.k.y0);
            this.E = new ConcernEmotionTipAdapter(this.f16900c.getContext(), b.a.r0.h1.c.f.b.j);
            this.F = new z(this.f16900c, b.a.r0.b0.e0.k.B0, (byte) 4);
            this.f16898a.add(this.f16901d);
            this.f16898a.add(this.f16902e);
            this.f16898a.add(this.f16903f);
            this.f16898a.add(this.f16904g);
            this.f16898a.add(this.f16905h);
            this.f16898a.add(this.B);
            this.f16898a.add(this.C);
            this.f16898a.add(this.D);
            this.f16898a.add(this.A);
            this.f16898a.add(this.E);
            this.f16898a.add(this.F);
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
            b.a.e.l.e.a<?, ?> j = b.a.r0.z2.y.o().j(this.f16900c, AdvertAppInfo.t4, "CONCERN");
            b.a.e.l.e.a<?, ?> j2 = b.a.r0.z2.y.o().j(this.f16900c, AdvertAppInfo.u4, "CONCERN");
            b.a.e.l.e.a<?, ?> j3 = b.a.r0.z2.y.o().j(this.f16900c, AdvertAppInfo.v4, "CONCERN");
            b.a.e.l.e.a<?, ?> j4 = b.a.r0.z2.y.o().j(this.f16900c, AdvertAppInfo.w4, "CONCERN");
            b.a.e.l.e.a<?, ?> j5 = b.a.r0.z2.y.o().j(this.f16900c, AdvertAppInfo.x4, "CONCERN");
            b.a.e.l.e.a<?, ?> j6 = b.a.r0.z2.y.o().j(this.f16900c, AdvertAppInfo.z4, "CONCERN");
            b.a.e.l.e.a<?, ?> j7 = b.a.r0.z2.y.o().j(this.f16900c, AdvertAppInfo.y4, "CONCERN");
            this.G.add(j);
            this.G.add(j2);
            this.G.add(j3);
            this.G.add(j4);
            this.G.add(j5);
            this.G.add(j6);
            this.G.add(j7);
            this.f16898a.addAll(this.G);
            AdvertAppInfo.q4.set(true);
        }
    }

    public void d() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdTypeRecyclerView = this.f16899b) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || b.a.r0.q1.o.k.a.e(this.H)) {
            return;
        }
        Iterator<b.a.e.l.e.a> it = this.G.iterator();
        while (it.hasNext()) {
            b.a.e.l.e.a next = it.next();
            if (next instanceof b.a.r0.z2.p) {
                ((b.a.r0.z2.p) next).onDestroy();
            }
        }
    }

    public final void g(String str) {
        List<b.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (list = this.f16898a) == null) {
            return;
        }
        for (b.a.e.l.e.a aVar : list) {
            if (aVar instanceof b.a.r0.p.f) {
                ((b.a.r0.p.f) aVar).g(str);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<r> it = this.f16906i.iterator();
            while (it.hasNext()) {
                it.next().m = bdUniqueId;
            }
            this.f16903f.m = bdUniqueId;
            this.f16904g.m = bdUniqueId;
            this.f16905h.m = bdUniqueId;
            this.D.m = bdUniqueId;
            this.B.m = bdUniqueId;
            this.C.m = bdUniqueId;
            this.A.m = bdUniqueId;
            this.s.m = bdUniqueId;
            this.z.m = bdUniqueId;
            this.F.n = bdUniqueId;
        }
    }

    public final void i(b.a.e.l.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sVar) == null) {
            Iterator<r> it = this.f16906i.iterator();
            while (it.hasNext()) {
                it.next().v0(sVar);
            }
            this.j.q0(sVar);
            this.k.q0(sVar);
            this.l.l0(sVar);
            this.m.l0(sVar);
            this.n.m0(sVar);
            this.u.l0(sVar);
            this.v.l0(sVar);
            this.o.l0(sVar);
            this.z.j0(sVar);
            this.w.i0(sVar);
            this.x.j0(sVar);
            this.y.i0(sVar);
            this.p.l0(sVar);
            this.q.l0(sVar);
            this.r.l0(sVar);
            this.t.o0(sVar);
            this.s.m0(sVar);
            this.A.m0(sVar);
            this.C.l0(sVar);
            this.B.m0(sVar);
            this.D.m0(sVar);
            this.F.i0(sVar);
        }
    }

    public void j(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.H = list;
            this.f16899b.setData(list);
        }
    }
}
