package c.a.r0.x0.p2;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.l.e.n;
import c.a.r0.q1.o.l.j;
import c.a.r0.x0.h1.g;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements c.a.r0.x0.h1.a, c.a.r0.q1.o.l.f, b, c.a.r0.q1.o.l.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public e f27728e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.f.l.a f27729f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.e.l.e.a f27730g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext f27731h;

    /* renamed from: i  reason: collision with root package name */
    public BdTypeRecyclerView f27732i;

    /* renamed from: j  reason: collision with root package name */
    public List<n> f27733j;
    public final List<c.a.e.l.e.a> k;
    public String l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;
    public String q;
    public c r;
    public j s;
    public c.a.r0.x0.p2.a t;
    public BdUniqueId u;
    public RecyclerView.SmoothScroller v;

    /* loaded from: classes4.dex */
    public class a extends LinearSmoothScroller {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f fVar, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDtToFit(int i2, int i3, int i4, int i5, int i6) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) ? (i4 + ((i5 - i4) / 5)) - (i2 + ((i3 - i2) / 5)) : invokeCommon.intValue;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, displayMetrics)) == null) {
                return 0.2f;
            }
            return invokeL.floatValue;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int getVerticalSnapPreference() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return -1;
            }
            return invokeV.intValue;
        }
    }

    public f(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, c cVar, boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView, cVar, Boolean.valueOf(z), str, str2, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27733j = new ArrayList();
        this.k = new ArrayList();
        this.m = false;
        this.n = false;
        this.o = -1;
        this.p = -1;
        this.f27731h = tbPageContext;
        this.u = bdUniqueId;
        this.f27732i = bdTypeRecyclerView;
        this.m = z;
        this.r = cVar;
        this.l = str;
        this.q = str2;
        j();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f27728e.y0();
            this.f27729f.r0();
        }
    }

    public void B(c.a.r0.x0.h1.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) || gVar == null || ListUtils.isEmpty(this.f27733j) || this.f27733j.get(0) == null) {
            return;
        }
        this.n = true;
        g.c cVar = ((c.a.r0.x0.h1.g) this.f27733j.get(0)).z;
        g.c cVar2 = gVar.z;
        cVar.n = cVar2.n;
        cVar.o = cVar2.o;
    }

    @Override // c.a.r0.x0.h1.a
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            y(i2);
        }
    }

    @Override // c.a.r0.q1.o.l.g
    public void b(c.a.r0.b0.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) && (bVar instanceof c.a.r0.x0.p2.a)) {
            this.t = (c.a.r0.x0.p2.a) bVar;
        }
    }

    @Override // c.a.r0.x0.p2.b
    public c.a.f.m.e.b c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            List<n> list = this.f27733j;
            if (list == null || list.isEmpty() || str == null) {
                return null;
            }
            c.a.f.m.e.b bVar = new c.a.f.m.e.b();
            int i2 = 0;
            int i3 = -1;
            boolean z = false;
            int i4 = 0;
            int i5 = -1;
            int i6 = -1;
            while (true) {
                if (i2 >= this.f27733j.size()) {
                    i2 = -1;
                    break;
                }
                if (this.f27733j.get(i2) instanceof c.a.f.d) {
                    if (l(this.f27733j.get(i2))) {
                        if (z) {
                            break;
                        }
                        i5 = i2;
                    } else if (z) {
                        i4++;
                    }
                }
                if ((this.f27733j.get(i2) instanceof c.a.r0.x0.h1.g) && str.equals(((c.a.r0.x0.h1.g) this.f27733j.get(i2)).k())) {
                    z = true;
                    i6 = i2;
                }
                i2++;
            }
            if (i2 == -1 || (i2 = i2 - i4) >= -1) {
                i3 = i2;
            }
            bVar.h(str);
            bVar.g(i5);
            bVar.e(i6);
            bVar.f(i3);
            return bVar;
        }
        return (c.a.f.m.e.b) invokeL.objValue;
    }

    @Override // c.a.r0.x0.h1.a
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            u();
        }
    }

    public void d(int i2) {
        j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            if (this.o == i2 && (jVar = this.s) != null && jVar.isPlaying()) {
                return;
            }
            if (this.o == i2 && this.s != null && n()) {
                return;
            }
            this.o = i2;
            this.p = i2;
            if (ListUtils.isEmpty(this.f27733j) || this.f27732i == null) {
                return;
            }
            for (n nVar : this.f27733j) {
                if (nVar instanceof c.a.r0.q1.o.l.i) {
                    c.a.r0.q1.o.l.i iVar = (c.a.r0.q1.o.l.i) nVar;
                    iVar.setAutoPlay(false);
                    iVar.setWaitConfirm(false);
                }
            }
            if (this.o > this.f27733j.size() - 1 || !(this.f27733j.get(this.o) instanceof c.a.r0.q1.o.l.i)) {
                return;
            }
            c.a.r0.q1.o.l.i iVar2 = (c.a.r0.q1.o.l.i) this.f27733j.get(this.o);
            iVar2.setAutoPlay(true);
            if (!c.a.e.e.p.j.H() && !c.a.r0.y3.h.d().e()) {
                iVar2.setWaitConfirm(true);
            } else {
                iVar2.setWaitConfirm(false);
            }
            p();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || ListUtils.isEmpty(this.f27733j)) {
            return;
        }
        for (n nVar : this.f27733j) {
            if (nVar instanceof c.a.r0.q1.o.l.i) {
                c.a.r0.q1.o.l.i iVar = (c.a.r0.q1.o.l.i) nVar;
                iVar.setAutoPlay(false);
                iVar.setWaitConfirm(false);
            }
        }
    }

    public c.a.r0.x0.p2.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.t : (c.a.r0.x0.p2.a) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.o : invokeV.intValue;
    }

    @Override // c.a.r0.q1.o.l.f
    public void h(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jVar) == null) {
            j jVar2 = this.s;
            this.s = jVar;
            if (jVar2 == null || jVar2 == jVar) {
                return;
            }
            jVar2.stopPlay();
        }
    }

    public int i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            int size = this.f27733j.size();
            for (int i3 = i2 + 1; i3 < size; i3++) {
                if (l(this.f27733j.get(i3))) {
                    return i3 - i2;
                }
            }
            return 1;
        }
        return invokeI.intValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f27728e = new e(this.f27731h, this, this.r, this.m, this.l, this.q, this, this.u, this, this);
            this.f27729f = new c.a.f.l.a(this.f27731h, c.a.f.b.f3271b, this, this.r, this);
            this.f27730g = new c.a.f.l.b(this.f27731h, c.a.f.b.f3270a);
            this.k.add(this.f27728e);
            this.k.add(this.f27730g);
            this.k.add(this.f27729f);
            this.f27732i.addAdapters(this.k);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f27728e.o0() || this.f27729f.k0() : invokeV.booleanValue;
    }

    public final boolean l(n nVar) {
        InterceptResult invokeL;
        c.a.f.e i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, nVar)) == null) {
            if (nVar == null) {
                return false;
            }
            if (nVar instanceof c.a.r0.x0.h1.g) {
                return true;
            }
            return (!(nVar instanceof c.a.f.d) || (i2 = ((c.a.f.d) nVar).i()) == null || i2.f3282a) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public boolean m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            if (i2 < 0 || i2 >= this.f27733j.size()) {
                return false;
            }
            return l(this.f27733j.get(i2));
        }
        return invokeI.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f27728e.p0() : invokeV.booleanValue;
    }

    public void o(String str, boolean z) {
        c.a.r0.x0.h1.g gVar;
        g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048593, this, str, z) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        for (n nVar : this.f27733j) {
            if (nVar != null && (nVar instanceof c.a.r0.x0.h1.g) && (bVar = (gVar = (c.a.r0.x0.h1.g) nVar).y) != null && str.equals(bVar.f27010a)) {
                gVar.y.f27014e = z;
            }
        }
    }

    public void p() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (bdTypeRecyclerView = this.f27732i) == null || bdTypeRecyclerView.getListAdapter() == null) {
            return;
        }
        this.f27732i.getListAdapter().notifyDataSetChanged();
    }

    public void q(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, configuration) == null) {
            this.f27728e.q0(configuration);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f27728e.onDestroy();
            this.f27729f.o0();
        }
    }

    public boolean s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) ? this.f27728e.t0(i2) : invokeI.booleanValue;
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f27728e.u0();
            this.f27729f.q0();
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            e();
            this.o = 0;
            this.p = -1;
            t();
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.f27728e.v0();
        }
    }

    public void w(List<BaseCardInfo> list, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048601, this, list, z) == null) || list == null) {
            return;
        }
        int size = this.f27733j.size();
        this.f27733j.addAll(list);
        if (this.n) {
            this.n = false;
            this.f27732i.setData(this.f27733j);
        } else {
            this.f27732i.setDataWithPartChange(this.f27733j, size, list.size());
        }
        if (list.size() > 0 && this.m && z) {
            u();
            if (list.get(0) instanceof c.a.r0.q1.o.l.i) {
                c.a.r0.q1.o.l.i iVar = (c.a.r0.q1.o.l.i) list.get(0);
                iVar.setAutoPlay(true);
                if (c.a.e.e.p.j.x() && !c.a.r0.y3.h.d().e()) {
                    iVar.setWaitConfirm(true);
                } else {
                    iVar.setWaitConfirm(false);
                }
            }
        }
        int i2 = this.o;
        if (i2 == -1) {
            i2 = this.p;
        }
        if (this.f27733j.size() <= i2 || z || i2 == -1 || !(this.f27733j.get(i2) instanceof c.a.r0.q1.o.l.i)) {
            return;
        }
        c.a.r0.q1.o.l.i iVar2 = (c.a.r0.q1.o.l.i) this.f27733j.get(i2);
        iVar2.setAutoPlay(true);
        if (!c.a.e.e.p.j.H() && !c.a.r0.y3.h.d().e()) {
            iVar2.setWaitConfirm(true);
            p();
            return;
        }
        iVar2.setWaitConfirm(false);
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.f27728e.w0(z);
        }
    }

    public void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.o = i2;
            this.p = i2;
            if (ListUtils.isEmpty(this.f27733j) || this.f27732i == null) {
                return;
            }
            for (n nVar : this.f27733j) {
                if (nVar instanceof c.a.r0.q1.o.l.i) {
                    c.a.r0.q1.o.l.i iVar = (c.a.r0.q1.o.l.i) nVar;
                    iVar.setAutoPlay(false);
                    iVar.setWaitConfirm(false);
                }
            }
            if (this.o < this.f27733j.size() - 1) {
                int i3 = i(i2);
                int i4 = this.o + i3;
                this.o = i4;
                if (this.f27733j.get(i4) instanceof c.a.r0.q1.o.l.i) {
                    c.a.r0.q1.o.l.i iVar2 = (c.a.r0.q1.o.l.i) this.f27733j.get(i4);
                    iVar2.setAutoPlay(true);
                    if (!c.a.e.e.p.j.H() && !c.a.r0.y3.h.d().e()) {
                        iVar2.setWaitConfirm(true);
                    } else {
                        iVar2.setWaitConfirm(false);
                    }
                    if (this.v == null) {
                        this.v = new a(this, this.f27731h.getContext());
                    }
                    this.v.setTargetPosition(i2 + this.f27732i.getHeaderViewsCount() + i3);
                    this.f27732i.getLayoutManager().startSmoothScroll(this.v);
                    p();
                }
            } else if (this.o == this.f27733j.size() - 1 && (this.f27733j.get(this.o) instanceof c.a.r0.q1.o.l.i)) {
                c.a.r0.q1.o.l.i iVar3 = (c.a.r0.q1.o.l.i) this.f27733j.get(this.o);
                iVar3.setAutoPlay(true);
                if (!c.a.e.e.p.j.H() && !c.a.r0.y3.h.d().e()) {
                    iVar3.setWaitConfirm(true);
                } else {
                    iVar3.setWaitConfirm(false);
                }
                p();
            }
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.f27728e.x0();
        }
    }
}
