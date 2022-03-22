package c.a.p0.q1.d;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.o0.r.r.s1;
import c.a.p0.q1.d.e.a0;
import c.a.p0.q1.d.e.e;
import c.a.p0.q1.d.e.f;
import c.a.p0.q1.d.e.g;
import c.a.p0.q1.d.e.h;
import c.a.p0.q1.d.e.i;
import c.a.p0.q1.d.e.j;
import c.a.p0.q1.d.e.k;
import c.a.p0.q1.d.e.l;
import c.a.p0.q1.d.e.m;
import c.a.p0.q1.d.e.o;
import c.a.p0.q1.d.e.p;
import c.a.p0.q1.d.e.q;
import c.a.p0.q1.d.e.r;
import c.a.p0.q1.d.e.s;
import c.a.p0.q1.d.e.t;
import c.a.p0.q1.d.e.u;
import c.a.p0.q1.d.e.v;
import c.a.p0.q1.d.e.w;
import c.a.p0.q1.d.e.x;
import c.a.p0.q1.d.e.y;
import c.a.p0.q1.d.e.z;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public s A;
    public c.a.p0.q1.d.e.d B;
    public p C;
    public e D;
    public q E;
    public ConcernEmotionTipAdapter F;
    public a0 G;
    public ArrayList<c.a.d.o.e.a> H;
    public List<n> I;
    public List<c.a.d.o.e.a> a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f17133b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f17134c;

    /* renamed from: d  reason: collision with root package name */
    public ConcernTipAdapter f17135d;

    /* renamed from: e  reason: collision with root package name */
    public ConcernEmotionTipAdapter f17136e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.q1.d.e.b f17137f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.q1.d.e.a f17138g;

    /* renamed from: h  reason: collision with root package name */
    public v f17139h;
    public ArrayList<r> i;
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
    public c.a.p0.q1.d.e.n w;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new ArrayList<>();
        this.a = new ArrayList();
        this.f17133b = bdTypeRecyclerView;
        this.f17134c = (TbPageContext) c.a.d.a.j.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.a(this.a);
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.I : (List) invokeV.objValue;
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            for (int i = 0; i < c.a.p0.h0.e0.b.O.size(); i++) {
                for (int i2 = 0; i2 < c.a.p0.h0.e0.b.P.size(); i2++) {
                    this.i.add(new r(this.f17134c, c.a.p0.h0.e0.b.Q[i][i2], c.a.p0.h0.e0.b.O.get(i), c.a.p0.h0.e0.b.P.get(i2)));
                }
            }
            this.j = new x(this.f17134c, ThreadData.TYPE_VIDEO, c.a.p0.h0.e0.b.D);
            this.k = new x(this.f17134c, ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER, c.a.p0.h0.e0.b.E);
            this.l = new j(this.f17134c, ThreadData.TYPE_FAKE_VIDEO, c.a.p0.h0.e0.b.D);
            this.m = new w(this.f17134c, c.a.p0.h0.e0.k.z0);
            this.n = new l(this.f17134c, c.a.p0.h0.e0.k.A0);
            this.u = new k(this.f17134c, c.a.p0.h0.e0.k.H0);
            this.v = new m(this.f17134c, c.a.p0.h0.e0.k.I0);
            this.o = new u(this.f17134c, c.a.p0.h0.e0.k.G0);
            this.p = new i(this.f17134c, c.a.p0.h0.e0.k.B0);
            this.q = new h(this.f17134c, c.a.p0.h0.e0.k.C0);
            this.r = new g(this.f17134c, c.a.p0.h0.e0.k.D0);
            this.t = new y(this.f17134c, c.a.p0.h0.e0.l.U);
            this.B = new c.a.p0.q1.d.e.d(this.f17134c, c.a.p0.h0.e0.e.N0);
            this.s = new f(this.f17134c, c.a.p0.h0.e0.k.E0);
            this.A = new s(this.f17134c, s1.f10951e);
            this.w = new c.a.p0.q1.d.e.n(this.f17134c, c.a.p0.h0.e0.k.J0);
            this.x = new t(this.f17134c, c.a.p0.h0.e0.k.K0);
            this.y = new o(this.f17134c, c.a.p0.h0.e0.k.L0);
            this.z = new z(this.f17134c, ThreadData.TYPE_CONTENT_VOICE_ROOM);
            this.a.addAll(this.i);
            this.a.add(this.j);
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
            this.f17135d = new ConcernTipAdapter(this.f17134c.getContext());
            this.f17136e = new ConcernEmotionTipAdapter(this.f17134c.getContext());
            this.f17137f = new c.a.p0.q1.d.e.b(this.f17134c, c.a.p0.h0.e0.j.N0);
            this.f17138g = new c.a.p0.q1.d.e.a(this.f17134c, c.a.p0.h0.e0.j.O0);
            this.f17139h = new v(this.f17134c, c.a.p0.h0.e0.k.r0);
            this.C = new p(this.f17134c, c.a.p0.h0.e0.k.s0);
            this.D = new e(this.f17134c, c.a.p0.h0.e0.k.t0);
            this.E = new q(this.f17134c, c.a.p0.h0.e0.k.u0);
            this.F = new ConcernEmotionTipAdapter(this.f17134c.getContext(), c.a.p0.q1.d.f.b.f17196f);
            this.G = new a0(this.f17134c, c.a.p0.h0.e0.k.x0, (byte) 4);
            this.a.add(this.f17135d);
            this.a.add(this.f17136e);
            this.a.add(this.f17137f);
            this.a.add(this.f17138g);
            this.a.add(this.f17139h);
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
            if (!ThreadData.isRecAppLoaded.get()) {
                AdvertAppInfo.v.set(false);
                return;
            }
            this.H = new ArrayList<>();
            c.a.d.o.e.a<?, ?> j = c.a.p0.l3.z.q().j(this.f17134c, AdvertAppInfo.y, "CONCERN");
            c.a.d.o.e.a<?, ?> j2 = c.a.p0.l3.z.q().j(this.f17134c, AdvertAppInfo.z, "CONCERN");
            c.a.d.o.e.a<?, ?> j3 = c.a.p0.l3.z.q().j(this.f17134c, AdvertAppInfo.A, "CONCERN");
            c.a.d.o.e.a<?, ?> j4 = c.a.p0.l3.z.q().j(this.f17134c, AdvertAppInfo.B, "CONCERN");
            c.a.d.o.e.a<?, ?> j5 = c.a.p0.l3.z.q().j(this.f17134c, AdvertAppInfo.C, "CONCERN");
            c.a.d.o.e.a<?, ?> j6 = c.a.p0.l3.z.q().j(this.f17134c, AdvertAppInfo.E, "CONCERN");
            c.a.d.o.e.a<?, ?> j7 = c.a.p0.l3.z.q().j(this.f17134c, AdvertAppInfo.D, "CONCERN");
            this.H.add(j);
            this.H.add(j2);
            this.H.add(j3);
            this.H.add(j4);
            this.H.add(j5);
            this.H.add(j6);
            this.H.add(j7);
            this.a.addAll(this.H);
            AdvertAppInfo.v.set(true);
        }
    }

    public void d() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdTypeRecyclerView = this.f17133b) == null) {
            return;
        }
        bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            d();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || c.a.p0.b2.o.k.a.e(this.I)) {
            return;
        }
        Iterator<c.a.d.o.e.a> it = this.H.iterator();
        while (it.hasNext()) {
            c.a.d.o.e.a next = it.next();
            if (next instanceof c.a.p0.l3.p) {
                ((c.a.p0.l3.p) next).onDestroy();
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
            if (aVar instanceof c.a.p0.v.f) {
                ((c.a.p0.v.f) aVar).g(str);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<r> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().i = bdUniqueId;
            }
            this.f17137f.i = bdUniqueId;
            this.f17138g.i = bdUniqueId;
            this.f17139h.i = bdUniqueId;
            this.E.i = bdUniqueId;
            this.C.i = bdUniqueId;
            this.D.i = bdUniqueId;
            this.B.i = bdUniqueId;
            this.s.i = bdUniqueId;
            this.A.i = bdUniqueId;
            this.G.j = bdUniqueId;
            this.z.i = bdUniqueId;
        }
    }

    public final void i(c.a.d.o.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sVar) == null) {
            Iterator<r> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().o0(sVar);
            }
            this.j.j0(sVar);
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
            this.f17133b.setData(list);
        }
    }
}
