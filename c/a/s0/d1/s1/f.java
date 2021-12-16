package c.a.s0.d1.s1;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.k;
import c.a.d.m.e.n;
import c.a.s0.d1.s1.g;
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
/* loaded from: classes7.dex */
public class f implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public e f16361e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f16362f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeListView f16363g;

    /* renamed from: h  reason: collision with root package name */
    public List<n> f16364h;

    /* renamed from: i  reason: collision with root package name */
    public final List<c.a.d.m.e.a> f16365i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f16366j;

    /* renamed from: k  reason: collision with root package name */
    public int f16367k;

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
        this.f16364h = new ArrayList();
        this.f16365i = new ArrayList();
        this.f16366j = false;
        this.f16367k = -1;
        this.f16362f = tbPageContext;
        this.f16363g = bdTypeListView;
        this.f16366j = z;
        d();
    }

    @Override // c.a.s0.d1.s1.a
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f16367k = i2;
            if (ListUtils.isEmpty(this.f16364h) || this.f16363g == null) {
                return;
            }
            for (n nVar : this.f16364h) {
                if (nVar instanceof g) {
                    ((g) nVar).F = false;
                }
            }
            if (k.H()) {
                if (this.f16367k < this.f16364h.size() - 1) {
                    List<n> list = this.f16364h;
                    int i3 = this.f16367k + 1;
                    this.f16367k = i3;
                    if (list.get(i3) instanceof g) {
                        ((g) this.f16364h.get(this.f16367k)).F = true;
                        BdTypeListView bdTypeListView = this.f16363g;
                        bdTypeListView.smoothScrollToPositionFromTop(i2 + bdTypeListView.getHeaderViewsCount() + 1, 0);
                        g();
                    }
                } else if (this.f16367k == this.f16364h.size() - 1 && (this.f16364h.get(this.f16367k) instanceof g)) {
                    ((g) this.f16364h.get(this.f16367k)).F = false;
                }
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || ListUtils.isEmpty(this.f16364h)) {
            return;
        }
        Iterator<n> it = this.f16364h.iterator();
        while (it.hasNext()) {
            ((g) it.next()).F = false;
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16367k : invokeV.intValue;
    }

    @Override // c.a.s0.d1.s1.a
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            l();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            e eVar = new e(this.f16362f, this, this.f16366j);
            this.f16361e = eVar;
            this.f16365i.add(eVar);
            this.f16363g.addAdapters(this.f16365i);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f16361e.k0() : invokeV.booleanValue;
    }

    public void f(String str, boolean z) {
        g gVar;
        g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048582, this, str, z) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        boolean z2 = false;
        for (n nVar : this.f16364h) {
            if (nVar != null && (nVar instanceof g) && (bVar = (gVar = (g) nVar).y) != null && str.equals(bVar.a)) {
                gVar.y.f16383e = z;
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
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bdTypeListView = this.f16363g) == null || bdTypeListView.getAdapter2() == null || !(this.f16363g.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f16363g.getAdapter2().notifyDataSetChanged();
    }

    public void h(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, configuration) == null) {
            this.f16361e.l0(configuration);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f16361e.onDestroy();
        }
    }

    public boolean j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) ? this.f16361e.o0(i2) : invokeI.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f16361e.p0();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            b();
            this.f16367k = 0;
            k();
        }
    }

    public void m(List<g> list, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048589, this, list, z) == null) || list == null) {
            return;
        }
        if (z) {
            this.f16364h.clear();
        }
        this.f16364h.addAll(list);
        this.f16363g.setData(this.f16364h);
        if (z && list.size() > 0 && this.f16366j && k.H()) {
            l();
            list.get(0).F = true;
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f16361e.q0();
        }
    }
}
