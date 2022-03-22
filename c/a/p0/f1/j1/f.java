package c.a.p0.f1.j1;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.o.e.n;
import c.a.p0.f1.j1.g;
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
/* loaded from: classes2.dex */
public class f implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f14117b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeListView f14118c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f14119d;

    /* renamed from: e  reason: collision with root package name */
    public final List<c.a.d.o.e.a> f14120e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f14121f;

    /* renamed from: g  reason: collision with root package name */
    public int f14122g;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14119d = new ArrayList();
        this.f14120e = new ArrayList();
        this.f14121f = false;
        this.f14122g = -1;
        this.f14117b = tbPageContext;
        this.f14118c = bdTypeListView;
        this.f14121f = z;
        d();
    }

    @Override // c.a.p0.f1.j1.a
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.f14122g = i;
            if (ListUtils.isEmpty(this.f14119d) || this.f14118c == null) {
                return;
            }
            for (n nVar : this.f14119d) {
                if (nVar instanceof g) {
                    ((g) nVar).B = false;
                }
            }
            if (l.H()) {
                if (this.f14122g < this.f14119d.size() - 1) {
                    List<n> list = this.f14119d;
                    int i2 = this.f14122g + 1;
                    this.f14122g = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.f14119d.get(this.f14122g)).B = true;
                        BdTypeListView bdTypeListView = this.f14118c;
                        bdTypeListView.smoothScrollToPositionFromTop(i + bdTypeListView.getHeaderViewsCount() + 1, 0);
                        g();
                    }
                } else if (this.f14122g == this.f14119d.size() - 1 && (this.f14119d.get(this.f14122g) instanceof g)) {
                    ((g) this.f14119d.get(this.f14122g)).B = false;
                }
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || ListUtils.isEmpty(this.f14119d)) {
            return;
        }
        Iterator<n> it = this.f14119d.iterator();
        while (it.hasNext()) {
            ((g) it.next()).B = false;
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14122g : invokeV.intValue;
    }

    @Override // c.a.p0.f1.j1.a
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            l();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            e eVar = new e(this.f14117b, this, this.f14121f);
            this.a = eVar;
            this.f14120e.add(eVar);
            this.f14118c.a(this.f14120e);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.d0() : invokeV.booleanValue;
    }

    public void f(String str, boolean z) {
        g gVar;
        g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048582, this, str, z) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        boolean z2 = false;
        for (n nVar : this.f14119d) {
            if (nVar != null && (nVar instanceof g) && (bVar = (gVar = (g) nVar).u) != null && str.equals(bVar.a)) {
                gVar.u.f14138e = z;
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
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bdTypeListView = this.f14118c) == null || bdTypeListView.getAdapter2() == null || !(this.f14118c.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f14118c.getAdapter2().notifyDataSetChanged();
    }

    public void h(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, configuration) == null) {
            this.a.e0(configuration);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.a.onDestroy();
        }
    }

    public boolean j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) ? this.a.h0(i) : invokeI.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.a.i0();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            b();
            this.f14122g = 0;
            k();
        }
    }

    public void m(List<g> list, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048589, this, list, z) == null) || list == null) {
            return;
        }
        if (z) {
            this.f14119d.clear();
        }
        this.f14119d.addAll(list);
        this.f14118c.setData(this.f14119d);
        if (z && list.size() > 0 && this.f14121f && l.H()) {
            l();
            list.get(0).B = true;
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.a.j0();
        }
    }
}
