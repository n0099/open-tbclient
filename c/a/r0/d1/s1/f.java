package c.a.r0.d1.s1;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.j;
import c.a.d.m.e.n;
import c.a.r0.d1.s1.g;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class f implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public e f15951e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f15952f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeListView f15953g;

    /* renamed from: h  reason: collision with root package name */
    public List<n> f15954h;

    /* renamed from: i  reason: collision with root package name */
    public final List<c.a.d.m.e.a> f15955i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f15956j;

    /* renamed from: k  reason: collision with root package name */
    public int f15957k;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15954h = new ArrayList();
        this.f15955i = new ArrayList();
        this.f15956j = false;
        this.f15957k = -1;
        this.f15952f = tbPageContext;
        this.f15953g = bdTypeListView;
        this.f15956j = z;
        d();
    }

    @Override // c.a.r0.d1.s1.a
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f15957k = i2;
            if (ListUtils.isEmpty(this.f15954h) || this.f15953g == null) {
                return;
            }
            for (n nVar : this.f15954h) {
                if (nVar instanceof g) {
                    ((g) nVar).F = false;
                }
            }
            if (j.H()) {
                if (this.f15957k < this.f15954h.size() - 1) {
                    List<n> list = this.f15954h;
                    int i3 = this.f15957k + 1;
                    this.f15957k = i3;
                    if (list.get(i3) instanceof g) {
                        ((g) this.f15954h.get(this.f15957k)).F = true;
                        BdTypeListView bdTypeListView = this.f15953g;
                        bdTypeListView.smoothScrollToPositionFromTop(i2 + bdTypeListView.getHeaderViewsCount() + 1, 0);
                        g();
                    }
                } else if (this.f15957k == this.f15954h.size() - 1 && (this.f15954h.get(this.f15957k) instanceof g)) {
                    ((g) this.f15954h.get(this.f15957k)).F = false;
                }
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || ListUtils.isEmpty(this.f15954h)) {
            return;
        }
        Iterator<n> it = this.f15954h.iterator();
        while (it.hasNext()) {
            ((g) it.next()).F = false;
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15957k : invokeV.intValue;
    }

    @Override // c.a.r0.d1.s1.a
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            l();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            e eVar = new e(this.f15952f, this, this.f15956j);
            this.f15951e = eVar;
            this.f15955i.add(eVar);
            this.f15953g.addAdapters(this.f15955i);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f15951e.k0() : invokeV.booleanValue;
    }

    public void f(String str, boolean z) {
        g gVar;
        g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048582, this, str, z) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        boolean z2 = false;
        for (n nVar : this.f15954h) {
            if (nVar != null && (nVar instanceof g) && (bVar = (gVar = (g) nVar).y) != null && str.equals(bVar.a)) {
                gVar.y.f15973e = z;
                z2 = true;
            }
        }
        if (z2) {
            g();
        }
    }

    public void g() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bdTypeListView = this.f15953g) == null || bdTypeListView.getAdapter2() == null || !(this.f15953g.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f15953g.getAdapter2().notifyDataSetChanged();
    }

    public void h(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, configuration) == null) {
            this.f15951e.l0(configuration);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f15951e.onDestroy();
        }
    }

    public boolean j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) ? this.f15951e.o0(i2) : invokeI.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f15951e.p0();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            b();
            this.f15957k = 0;
            k();
        }
    }

    public void m(List<g> list, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048589, this, list, z) == null) || list == null) {
            return;
        }
        if (z) {
            this.f15954h.clear();
        }
        this.f15954h.addAll(list);
        this.f15953g.setData(this.f15954h);
        if (z && list.size() > 0 && this.f15956j && j.H()) {
            l();
            list.get(0).F = true;
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f15951e.q0();
        }
    }
}
