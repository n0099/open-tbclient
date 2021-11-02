package b.a.r0.x0.z2;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import b.a.e.l.e.n;
import b.a.r0.q1.o.l.j;
import b.a.r0.x0.r1.g;
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
/* loaded from: classes5.dex */
public class f implements b.a.r0.x0.r1.a, b.a.r0.q1.o.l.f, b, b.a.r0.q1.o.l.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public e f26984e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.f.l.a f26985f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.e.l.e.a f26986g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext f26987h;

    /* renamed from: i  reason: collision with root package name */
    public BdTypeRecyclerView f26988i;
    public List<n> j;
    public final List<b.a.e.l.e.a> k;
    public String l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;
    public String q;
    public c r;
    public j s;
    public b.a.r0.x0.z2.a t;
    public BdUniqueId u;
    public RecyclerView.SmoothScroller v;

    /* loaded from: classes5.dex */
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
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.m = false;
        this.n = false;
        this.o = -1;
        this.p = -1;
        this.f26987h = tbPageContext;
        this.u = bdUniqueId;
        this.f26988i = bdTypeRecyclerView;
        this.m = z;
        this.r = cVar;
        this.l = str;
        this.q = str2;
        j();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f26984e.x0();
            this.f26985f.q0();
        }
    }

    public void B(b.a.r0.x0.r1.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) || gVar == null || ListUtils.isEmpty(this.j) || this.j.get(0) == null) {
            return;
        }
        this.n = true;
        g.c cVar = ((b.a.r0.x0.r1.g) this.j.get(0)).z;
        g.c cVar2 = gVar.z;
        cVar.n = cVar2.n;
        cVar.o = cVar2.o;
    }

    @Override // b.a.r0.x0.r1.a
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            y(i2);
        }
    }

    @Override // b.a.r0.q1.o.l.g
    public void b(b.a.r0.b0.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) && (bVar instanceof b.a.r0.x0.z2.a)) {
            this.t = (b.a.r0.x0.z2.a) bVar;
        }
    }

    @Override // b.a.r0.x0.z2.b
    public b.a.f.m.e.b c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            List<n> list = this.j;
            if (list == null || list.isEmpty() || str == null) {
                return null;
            }
            b.a.f.m.e.b bVar = new b.a.f.m.e.b();
            int i2 = 0;
            int i3 = -1;
            boolean z = false;
            int i4 = 0;
            int i5 = -1;
            int i6 = -1;
            while (true) {
                if (i2 >= this.j.size()) {
                    i2 = -1;
                    break;
                }
                if (this.j.get(i2) instanceof b.a.f.d) {
                    if (l(this.j.get(i2))) {
                        if (z) {
                            break;
                        }
                        i5 = i2;
                    } else if (z) {
                        i4++;
                    }
                }
                if ((this.j.get(i2) instanceof b.a.r0.x0.r1.g) && str.equals(((b.a.r0.x0.r1.g) this.j.get(i2)).k())) {
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
        return (b.a.f.m.e.b) invokeL.objValue;
    }

    @Override // b.a.r0.x0.r1.a
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
            if (ListUtils.isEmpty(this.j) || this.f26988i == null) {
                return;
            }
            for (n nVar : this.j) {
                if (nVar instanceof b.a.r0.q1.o.l.i) {
                    b.a.r0.q1.o.l.i iVar = (b.a.r0.q1.o.l.i) nVar;
                    iVar.setAutoPlay(false);
                    iVar.setWaitConfirm(false);
                }
            }
            if (this.o > this.j.size() - 1 || !(this.j.get(this.o) instanceof b.a.r0.q1.o.l.i)) {
                return;
            }
            b.a.r0.q1.o.l.i iVar2 = (b.a.r0.q1.o.l.i) this.j.get(this.o);
            iVar2.setAutoPlay(true);
            if (!b.a.e.e.p.j.H() && !b.a.r0.z3.h.d().e()) {
                iVar2.setWaitConfirm(true);
            } else {
                iVar2.setWaitConfirm(false);
            }
            p();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || ListUtils.isEmpty(this.j)) {
            return;
        }
        for (n nVar : this.j) {
            if (nVar instanceof b.a.r0.q1.o.l.i) {
                b.a.r0.q1.o.l.i iVar = (b.a.r0.q1.o.l.i) nVar;
                iVar.setAutoPlay(false);
                iVar.setWaitConfirm(false);
            }
        }
    }

    public b.a.r0.x0.z2.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.t : (b.a.r0.x0.z2.a) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.o : invokeV.intValue;
    }

    @Override // b.a.r0.q1.o.l.f
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
            int size = this.j.size();
            for (int i3 = i2 + 1; i3 < size; i3++) {
                if (l(this.j.get(i3))) {
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
            this.f26984e = new e(this.f26987h, this, this.r, this.m, this.l, this.q, this, this.u, this, this);
            this.f26985f = new b.a.f.l.a(this.f26987h, b.a.f.b.f2718b, this, this.r, this);
            this.f26986g = new b.a.f.l.b(this.f26987h, b.a.f.b.f2717a);
            this.k.add(this.f26984e);
            this.k.add(this.f26986g);
            this.k.add(this.f26985f);
            this.f26988i.addAdapters(this.k);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f26984e.n0() || this.f26985f.j0() : invokeV.booleanValue;
    }

    public final boolean l(n nVar) {
        InterceptResult invokeL;
        b.a.f.e i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, nVar)) == null) {
            if (nVar == null) {
                return false;
            }
            if (nVar instanceof b.a.r0.x0.r1.g) {
                return true;
            }
            return (!(nVar instanceof b.a.f.d) || (i2 = ((b.a.f.d) nVar).i()) == null || i2.f2728a) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public boolean m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            if (i2 < 0 || i2 >= this.j.size()) {
                return false;
            }
            return l(this.j.get(i2));
        }
        return invokeI.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f26984e.o0() : invokeV.booleanValue;
    }

    public void o(String str, boolean z) {
        b.a.r0.x0.r1.g gVar;
        g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048593, this, str, z) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        for (n nVar : this.j) {
            if (nVar != null && (nVar instanceof b.a.r0.x0.r1.g) && (bVar = (gVar = (b.a.r0.x0.r1.g) nVar).y) != null && str.equals(bVar.f26266a)) {
                gVar.y.f26270e = z;
            }
        }
    }

    public void p() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (bdTypeRecyclerView = this.f26988i) == null || bdTypeRecyclerView.getListAdapter() == null) {
            return;
        }
        this.f26988i.getListAdapter().notifyDataSetChanged();
    }

    public void q(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, configuration) == null) {
            this.f26984e.p0(configuration);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f26984e.onDestroy();
            this.f26985f.n0();
        }
    }

    public boolean s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) ? this.f26984e.s0(i2) : invokeI.booleanValue;
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f26984e.t0();
            this.f26985f.p0();
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
            this.f26984e.u0();
        }
    }

    public void w(List<BaseCardInfo> list, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048601, this, list, z) == null) || list == null) {
            return;
        }
        int size = this.j.size();
        this.j.addAll(list);
        if (this.n) {
            this.n = false;
            this.f26988i.setData(this.j);
        } else {
            this.f26988i.setDataWithPartChange(this.j, size, list.size());
        }
        if (list.size() > 0 && this.m && z) {
            u();
            if (list.get(0) instanceof b.a.r0.q1.o.l.i) {
                b.a.r0.q1.o.l.i iVar = (b.a.r0.q1.o.l.i) list.get(0);
                iVar.setAutoPlay(true);
                if (b.a.e.e.p.j.x() && !b.a.r0.z3.h.d().e()) {
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
        if (this.j.size() <= i2 || z || i2 == -1 || !(this.j.get(i2) instanceof b.a.r0.q1.o.l.i)) {
            return;
        }
        b.a.r0.q1.o.l.i iVar2 = (b.a.r0.q1.o.l.i) this.j.get(i2);
        iVar2.setAutoPlay(true);
        if (!b.a.e.e.p.j.H() && !b.a.r0.z3.h.d().e()) {
            iVar2.setWaitConfirm(true);
            p();
            return;
        }
        iVar2.setWaitConfirm(false);
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.f26984e.v0(z);
        }
    }

    public void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.o = i2;
            this.p = i2;
            if (ListUtils.isEmpty(this.j) || this.f26988i == null) {
                return;
            }
            for (n nVar : this.j) {
                if (nVar instanceof b.a.r0.q1.o.l.i) {
                    b.a.r0.q1.o.l.i iVar = (b.a.r0.q1.o.l.i) nVar;
                    iVar.setAutoPlay(false);
                    iVar.setWaitConfirm(false);
                }
            }
            if (this.o < this.j.size() - 1) {
                int i3 = i(i2);
                int i4 = this.o + i3;
                this.o = i4;
                if (this.j.get(i4) instanceof b.a.r0.q1.o.l.i) {
                    b.a.r0.q1.o.l.i iVar2 = (b.a.r0.q1.o.l.i) this.j.get(i4);
                    iVar2.setAutoPlay(true);
                    if (!b.a.e.e.p.j.H() && !b.a.r0.z3.h.d().e()) {
                        iVar2.setWaitConfirm(true);
                    } else {
                        iVar2.setWaitConfirm(false);
                    }
                    if (this.v == null) {
                        this.v = new a(this, this.f26987h.getContext());
                    }
                    this.v.setTargetPosition(i2 + this.f26988i.getHeaderViewsCount() + i3);
                    this.f26988i.getLayoutManager().startSmoothScroll(this.v);
                    p();
                }
            } else if (this.o == this.j.size() - 1 && (this.j.get(this.o) instanceof b.a.r0.q1.o.l.i)) {
                b.a.r0.q1.o.l.i iVar3 = (b.a.r0.q1.o.l.i) this.j.get(this.o);
                iVar3.setAutoPlay(true);
                if (!b.a.e.e.p.j.H() && !b.a.r0.z3.h.d().e()) {
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
            this.f26984e.w0();
        }
    }
}
