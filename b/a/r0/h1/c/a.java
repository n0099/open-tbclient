package b.a.r0.h1.c;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import b.a.e.m.e.n;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.v1;
import b.a.r0.h1.c.e.a0;
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
    public s A;
    public b.a.r0.h1.c.e.d B;
    public p C;
    public e D;
    public q E;
    public ConcernEmotionTipAdapter F;
    public a0 G;
    public ArrayList<b.a.e.m.e.a> H;
    public List<n> I;

    /* renamed from: a  reason: collision with root package name */
    public List<b.a.e.m.e.a> f18365a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f18366b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f18367c;

    /* renamed from: d  reason: collision with root package name */
    public ConcernTipAdapter f18368d;

    /* renamed from: e  reason: collision with root package name */
    public ConcernEmotionTipAdapter f18369e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.h1.c.e.b f18370f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.h1.c.e.a f18371g;

    /* renamed from: h  reason: collision with root package name */
    public v f18372h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<r> f18373i;
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
        this.f18373i = new ArrayList<>();
        this.f18365a = new ArrayList();
        this.f18366b = bdTypeRecyclerView;
        this.f18367c = (TbPageContext) b.a.e.a.j.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.f18365a);
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.I : (List) invokeV.objValue;
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            for (int i2 = 0; i2 < b.a.r0.b0.f0.b.T.size(); i2++) {
                for (int i3 = 0; i3 < b.a.r0.b0.f0.b.U.size(); i3++) {
                    this.f18373i.add(new r(this.f18367c, b.a.r0.b0.f0.b.V[i2][i3], b.a.r0.b0.f0.b.T.get(i2), b.a.r0.b0.f0.b.U.get(i3)));
                }
            }
            this.j = new x(this.f18367c, d2.z3, b.a.r0.b0.f0.b.I);
            this.k = new x(this.f18367c, d2.c3, b.a.r0.b0.f0.b.J);
            this.l = new j(this.f18367c, d2.R3, b.a.r0.b0.f0.b.I);
            this.m = new w(this.f18367c, b.a.r0.b0.f0.k.E0);
            this.n = new l(this.f18367c, b.a.r0.b0.f0.k.F0);
            this.u = new k(this.f18367c, b.a.r0.b0.f0.k.M0);
            this.v = new m(this.f18367c, b.a.r0.b0.f0.k.N0);
            this.o = new u(this.f18367c, b.a.r0.b0.f0.k.L0);
            this.p = new i(this.f18367c, b.a.r0.b0.f0.k.G0);
            this.q = new h(this.f18367c, b.a.r0.b0.f0.k.H0);
            this.r = new g(this.f18367c, b.a.r0.b0.f0.k.I0);
            this.t = new y(this.f18367c, b.a.r0.b0.f0.l.Z);
            this.B = new b.a.r0.h1.c.e.d(this.f18367c, b.a.r0.b0.f0.e.S0);
            this.s = new f(this.f18367c, b.a.r0.b0.f0.k.J0);
            this.A = new s(this.f18367c, v1.f14244i);
            this.w = new b.a.r0.h1.c.e.n(this.f18367c, b.a.r0.b0.f0.k.O0);
            this.x = new t(this.f18367c, b.a.r0.b0.f0.k.P0);
            this.y = new o(this.f18367c, b.a.r0.b0.f0.k.Q0);
            this.z = new z(this.f18367c, d2.n3);
            this.f18365a.addAll(this.f18373i);
            this.f18365a.add(this.j);
            this.f18365a.add(this.k);
            this.f18365a.add(this.l);
            this.f18365a.add(this.m);
            this.f18365a.add(this.n);
            this.f18365a.add(this.u);
            this.f18365a.add(this.v);
            this.f18365a.add(this.o);
            this.f18365a.add(this.p);
            this.f18365a.add(this.q);
            this.f18365a.add(this.r);
            this.f18365a.add(this.t);
            this.f18365a.add(this.s);
            this.f18365a.add(this.A);
            this.f18365a.add(this.w);
            this.f18365a.add(this.x);
            this.f18365a.add(this.y);
            this.f18365a.add(this.z);
            this.f18368d = new ConcernTipAdapter(this.f18367c.getContext());
            this.f18369e = new ConcernEmotionTipAdapter(this.f18367c.getContext());
            this.f18370f = new b.a.r0.h1.c.e.b(this.f18367c, b.a.r0.b0.f0.j.S0);
            this.f18371g = new b.a.r0.h1.c.e.a(this.f18367c, b.a.r0.b0.f0.j.T0);
            this.f18372h = new v(this.f18367c, b.a.r0.b0.f0.k.x0);
            this.C = new p(this.f18367c, b.a.r0.b0.f0.k.y0);
            this.D = new e(this.f18367c, b.a.r0.b0.f0.k.z0);
            this.E = new q(this.f18367c, b.a.r0.b0.f0.k.A0);
            this.F = new ConcernEmotionTipAdapter(this.f18367c.getContext(), b.a.r0.h1.c.f.b.j);
            this.G = new a0(this.f18367c, b.a.r0.b0.f0.k.D0, (byte) 4);
            this.f18365a.add(this.f18368d);
            this.f18365a.add(this.f18369e);
            this.f18365a.add(this.f18370f);
            this.f18365a.add(this.f18371g);
            this.f18365a.add(this.f18372h);
            this.f18365a.add(this.C);
            this.f18365a.add(this.D);
            this.f18365a.add(this.E);
            this.f18365a.add(this.B);
            this.f18365a.add(this.F);
            this.f18365a.add(this.G);
            g("page_concern");
            c();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!d2.P3.get()) {
                AdvertAppInfo.r4.set(false);
                return;
            }
            this.H = new ArrayList<>();
            b.a.e.m.e.a<?, ?> j = b.a.r0.a3.y.o().j(this.f18367c, AdvertAppInfo.u4, "CONCERN");
            b.a.e.m.e.a<?, ?> j2 = b.a.r0.a3.y.o().j(this.f18367c, AdvertAppInfo.v4, "CONCERN");
            b.a.e.m.e.a<?, ?> j3 = b.a.r0.a3.y.o().j(this.f18367c, AdvertAppInfo.w4, "CONCERN");
            b.a.e.m.e.a<?, ?> j4 = b.a.r0.a3.y.o().j(this.f18367c, AdvertAppInfo.x4, "CONCERN");
            b.a.e.m.e.a<?, ?> j5 = b.a.r0.a3.y.o().j(this.f18367c, AdvertAppInfo.y4, "CONCERN");
            b.a.e.m.e.a<?, ?> j6 = b.a.r0.a3.y.o().j(this.f18367c, AdvertAppInfo.A4, "CONCERN");
            b.a.e.m.e.a<?, ?> j7 = b.a.r0.a3.y.o().j(this.f18367c, AdvertAppInfo.z4, "CONCERN");
            this.H.add(j);
            this.H.add(j2);
            this.H.add(j3);
            this.H.add(j4);
            this.H.add(j5);
            this.H.add(j6);
            this.H.add(j7);
            this.f18365a.addAll(this.H);
            AdvertAppInfo.r4.set(true);
        }
    }

    public void d() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdTypeRecyclerView = this.f18366b) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || b.a.r0.q1.o.k.a.e(this.I)) {
            return;
        }
        Iterator<b.a.e.m.e.a> it = this.H.iterator();
        while (it.hasNext()) {
            b.a.e.m.e.a next = it.next();
            if (next instanceof b.a.r0.a3.p) {
                ((b.a.r0.a3.p) next).onDestroy();
            }
        }
    }

    public final void g(String str) {
        List<b.a.e.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (list = this.f18365a) == null) {
            return;
        }
        for (b.a.e.m.e.a aVar : list) {
            if (aVar instanceof b.a.r0.p.f) {
                ((b.a.r0.p.f) aVar).g(str);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<r> it = this.f18373i.iterator();
            while (it.hasNext()) {
                it.next().m = bdUniqueId;
            }
            this.f18370f.m = bdUniqueId;
            this.f18371g.m = bdUniqueId;
            this.f18372h.m = bdUniqueId;
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

    public final void i(b.a.e.m.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sVar) == null) {
            Iterator<r> it = this.f18373i.iterator();
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
            this.f18366b.setData(list);
        }
    }
}
