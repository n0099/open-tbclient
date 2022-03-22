package c.a.p0.f1.t2;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.l;
import c.a.d.o.e.n;
import c.a.p0.b2.o.l.j;
import c.a.p0.f1.j1.g;
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
/* loaded from: classes2.dex */
public class f implements c.a.p0.f1.j1.a, c.a.p0.b2.o.l.f, b, c.a.p0.b2.o.l.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.e.l.a f14670b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.d.o.e.a f14671c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext f14672d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeRecyclerView f14673e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f14674f;

    /* renamed from: g  reason: collision with root package name */
    public final List<c.a.d.o.e.a> f14675g;

    /* renamed from: h  reason: collision with root package name */
    public String f14676h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public String m;
    public c n;
    public j o;
    public c.a.p0.f1.t2.a p;
    public BdUniqueId q;
    public RecyclerView.SmoothScroller r;

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDtToFit(int i, int i2, int i3, int i4, int i5) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) ? (i3 + ((i4 - i3) / 5)) - (i + ((i2 - i) / 5)) : invokeCommon.intValue;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14674f = new ArrayList();
        this.f14675g = new ArrayList();
        this.i = false;
        this.j = false;
        this.k = -1;
        this.l = -1;
        this.f14672d = tbPageContext;
        this.q = bdUniqueId;
        this.f14673e = bdTypeRecyclerView;
        this.i = z;
        this.n = cVar;
        this.f14676h = str;
        this.m = str2;
        j();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.q0();
            this.f14670b.j0();
        }
    }

    public void B(c.a.p0.f1.j1.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) || gVar == null || ListUtils.isEmpty(this.f14674f) || this.f14674f.get(0) == null) {
            return;
        }
        this.j = true;
        g.c cVar = ((c.a.p0.f1.j1.g) this.f14674f.get(0)).v;
        g.c cVar2 = gVar.v;
        cVar.n = cVar2.n;
        cVar.o = cVar2.o;
    }

    @Override // c.a.p0.f1.j1.a
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            y(i);
        }
    }

    @Override // c.a.p0.b2.o.l.g
    public void b(c.a.p0.h0.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) && (bVar instanceof c.a.p0.f1.t2.a)) {
            this.p = (c.a.p0.f1.t2.a) bVar;
        }
    }

    @Override // c.a.p0.f1.t2.b
    public c.a.e.m.e.b c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            List<n> list = this.f14674f;
            if (list == null || list.isEmpty() || str == null) {
                return null;
            }
            c.a.e.m.e.b bVar = new c.a.e.m.e.b();
            int i = 0;
            int i2 = -1;
            boolean z = false;
            int i3 = 0;
            int i4 = -1;
            int i5 = -1;
            while (true) {
                if (i >= this.f14674f.size()) {
                    i = -1;
                    break;
                }
                if (this.f14674f.get(i) instanceof c.a.e.d) {
                    if (l(this.f14674f.get(i))) {
                        if (z) {
                            break;
                        }
                        i4 = i;
                    } else if (z) {
                        i3++;
                    }
                }
                if ((this.f14674f.get(i) instanceof c.a.p0.f1.j1.g) && str.equals(((c.a.p0.f1.j1.g) this.f14674f.get(i)).g())) {
                    z = true;
                    i5 = i;
                }
                i++;
            }
            if (i == -1 || (i = i - i3) >= -1) {
                i2 = i;
            }
            bVar.h(str);
            bVar.g(i4);
            bVar.e(i5);
            bVar.f(i2);
            return bVar;
        }
        return (c.a.e.m.e.b) invokeL.objValue;
    }

    @Override // c.a.p0.f1.j1.a
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            u();
        }
    }

    public void d(int i) {
        j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            if (this.k == i && (jVar = this.o) != null && jVar.isPlaying()) {
                return;
            }
            if (this.k == i && this.o != null && n()) {
                return;
            }
            this.k = i;
            this.l = i;
            if (ListUtils.isEmpty(this.f14674f) || this.f14673e == null) {
                return;
            }
            for (n nVar : this.f14674f) {
                if (nVar instanceof c.a.p0.b2.o.l.i) {
                    c.a.p0.b2.o.l.i iVar = (c.a.p0.b2.o.l.i) nVar;
                    iVar.setAutoPlay(false);
                    iVar.setWaitConfirm(false);
                }
            }
            if (this.k > this.f14674f.size() - 1 || !(this.f14674f.get(this.k) instanceof c.a.p0.b2.o.l.i)) {
                return;
            }
            c.a.p0.b2.o.l.i iVar2 = (c.a.p0.b2.o.l.i) this.f14674f.get(this.k);
            iVar2.setAutoPlay(true);
            if (!l.H() && !c.a.p0.n4.h.c().d()) {
                iVar2.setWaitConfirm(true);
            } else {
                iVar2.setWaitConfirm(false);
            }
            p();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || ListUtils.isEmpty(this.f14674f)) {
            return;
        }
        for (n nVar : this.f14674f) {
            if (nVar instanceof c.a.p0.b2.o.l.i) {
                c.a.p0.b2.o.l.i iVar = (c.a.p0.b2.o.l.i) nVar;
                iVar.setAutoPlay(false);
                iVar.setWaitConfirm(false);
            }
        }
    }

    public c.a.p0.f1.t2.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.p : (c.a.p0.f1.t2.a) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.k : invokeV.intValue;
    }

    @Override // c.a.p0.b2.o.l.f
    public void h(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jVar) == null) {
            j jVar2 = this.o;
            this.o = jVar;
            if (jVar2 == null || jVar2 == jVar) {
                return;
            }
            jVar2.stopPlay();
        }
    }

    public int i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            int size = this.f14674f.size();
            for (int i2 = i + 1; i2 < size; i2++) {
                if (l(this.f14674f.get(i2))) {
                    return i2 - i;
                }
            }
            return 1;
        }
        return invokeI.intValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.a = new e(this.f14672d, this, this.n, this.i, this.f14676h, this.m, this, this.q, this, this);
            this.f14670b = new c.a.e.l.a(this.f14672d, c.a.e.b.f2664b, this, this.n, this);
            this.f14671c = new c.a.e.l.b(this.f14672d, c.a.e.b.a);
            this.f14675g.add(this.a);
            this.f14675g.add(this.f14671c);
            this.f14675g.add(this.f14670b);
            this.f14673e.a(this.f14675g);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.a.g0() || this.f14670b.c0() : invokeV.booleanValue;
    }

    public final boolean l(n nVar) {
        InterceptResult invokeL;
        c.a.e.e g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, nVar)) == null) {
            if (nVar == null) {
                return false;
            }
            if (nVar instanceof c.a.p0.f1.j1.g) {
                return true;
            }
            return (!(nVar instanceof c.a.e.d) || (g2 = ((c.a.e.d) nVar).g()) == null || g2.a) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public boolean m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            if (i < 0 || i >= this.f14674f.size()) {
                return false;
            }
            return l(this.f14674f.get(i));
        }
        return invokeI.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.a.h0() : invokeV.booleanValue;
    }

    public void o(String str, boolean z) {
        c.a.p0.f1.j1.g gVar;
        g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048593, this, str, z) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        for (n nVar : this.f14674f) {
            if (nVar != null && (nVar instanceof c.a.p0.f1.j1.g) && (bVar = (gVar = (c.a.p0.f1.j1.g) nVar).u) != null && str.equals(bVar.a)) {
                gVar.u.f14138e = z;
            }
        }
    }

    public void p() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (bdTypeRecyclerView = this.f14673e) == null || bdTypeRecyclerView.getListAdapter() == null) {
            return;
        }
        this.f14673e.getListAdapter().notifyDataSetChanged();
    }

    public void q(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, configuration) == null) {
            this.a.i0(configuration);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.a.onDestroy();
            this.f14670b.g0();
        }
    }

    public boolean s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) ? this.a.l0(i) : invokeI.booleanValue;
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.a.m0();
            this.f14670b.i0();
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            e();
            this.k = 0;
            this.l = -1;
            t();
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.a.n0();
        }
    }

    public void w(List<BaseCardInfo> list, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048601, this, list, z) == null) || list == null) {
            return;
        }
        int size = this.f14674f.size();
        this.f14674f.addAll(list);
        if (this.j) {
            this.j = false;
            this.f14673e.setData(this.f14674f);
        } else {
            this.f14673e.setDataWithPartChange(this.f14674f, size, list.size());
        }
        if (list.size() > 0 && this.i && z) {
            u();
            if (list.get(0) instanceof c.a.p0.b2.o.l.i) {
                c.a.p0.b2.o.l.i iVar = (c.a.p0.b2.o.l.i) list.get(0);
                iVar.setAutoPlay(true);
                if (l.x() && !c.a.p0.n4.h.c().d()) {
                    iVar.setWaitConfirm(true);
                } else {
                    iVar.setWaitConfirm(false);
                }
            }
        }
        int i = this.k;
        if (i == -1) {
            i = this.l;
        }
        if (this.f14674f.size() <= i || z || i == -1 || !(this.f14674f.get(i) instanceof c.a.p0.b2.o.l.i)) {
            return;
        }
        c.a.p0.b2.o.l.i iVar2 = (c.a.p0.b2.o.l.i) this.f14674f.get(i);
        iVar2.setAutoPlay(true);
        if (!l.H() && !c.a.p0.n4.h.c().d()) {
            iVar2.setWaitConfirm(true);
            p();
            return;
        }
        iVar2.setWaitConfirm(false);
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.a.o0(z);
        }
    }

    public void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.k = i;
            this.l = i;
            if (ListUtils.isEmpty(this.f14674f) || this.f14673e == null) {
                return;
            }
            for (n nVar : this.f14674f) {
                if (nVar instanceof c.a.p0.b2.o.l.i) {
                    c.a.p0.b2.o.l.i iVar = (c.a.p0.b2.o.l.i) nVar;
                    iVar.setAutoPlay(false);
                    iVar.setWaitConfirm(false);
                }
            }
            if (this.k < this.f14674f.size() - 1) {
                int i2 = i(i);
                int i3 = this.k + i2;
                this.k = i3;
                if (this.f14674f.get(i3) instanceof c.a.p0.b2.o.l.i) {
                    c.a.p0.b2.o.l.i iVar2 = (c.a.p0.b2.o.l.i) this.f14674f.get(i3);
                    iVar2.setAutoPlay(true);
                    if (!l.H() && !c.a.p0.n4.h.c().d()) {
                        iVar2.setWaitConfirm(true);
                    } else {
                        iVar2.setWaitConfirm(false);
                    }
                    if (this.r == null) {
                        this.r = new a(this, this.f14672d.getContext());
                    }
                    this.r.setTargetPosition(i + this.f14673e.getHeaderViewsCount() + i2);
                    this.f14673e.getLayoutManager().startSmoothScroll(this.r);
                    p();
                }
            } else if (this.k == this.f14674f.size() - 1 && (this.f14674f.get(this.k) instanceof c.a.p0.b2.o.l.i)) {
                c.a.p0.b2.o.l.i iVar3 = (c.a.p0.b2.o.l.i) this.f14674f.get(this.k);
                iVar3.setAutoPlay(true);
                if (!l.H() && !c.a.p0.n4.h.c().d()) {
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
            this.a.p0();
        }
    }
}
