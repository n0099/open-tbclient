package b.a.r0.x0.r1;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.j;
import b.a.e.l.e.n;
import b.a.r0.x0.r1.g;
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
    public e f26250e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f26251f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeListView f26252g;

    /* renamed from: h  reason: collision with root package name */
    public List<n> f26253h;

    /* renamed from: i  reason: collision with root package name */
    public final List<b.a.e.l.e.a> f26254i;
    public boolean j;
    public int k;

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
        this.f26253h = new ArrayList();
        this.f26254i = new ArrayList();
        this.j = false;
        this.k = -1;
        this.f26251f = tbPageContext;
        this.f26252g = bdTypeListView;
        this.j = z;
        d();
    }

    @Override // b.a.r0.x0.r1.a
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.k = i2;
            if (ListUtils.isEmpty(this.f26253h) || this.f26252g == null) {
                return;
            }
            for (n nVar : this.f26253h) {
                if (nVar instanceof g) {
                    ((g) nVar).F = false;
                }
            }
            if (j.H()) {
                if (this.k < this.f26253h.size() - 1) {
                    List<n> list = this.f26253h;
                    int i3 = this.k + 1;
                    this.k = i3;
                    if (list.get(i3) instanceof g) {
                        ((g) this.f26253h.get(this.k)).F = true;
                        BdTypeListView bdTypeListView = this.f26252g;
                        bdTypeListView.smoothScrollToPositionFromTop(i2 + bdTypeListView.getHeaderViewsCount() + 1, 0);
                        g();
                    }
                } else if (this.k == this.f26253h.size() - 1 && (this.f26253h.get(this.k) instanceof g)) {
                    ((g) this.f26253h.get(this.k)).F = false;
                }
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || ListUtils.isEmpty(this.f26253h)) {
            return;
        }
        Iterator<n> it = this.f26253h.iterator();
        while (it.hasNext()) {
            ((g) it.next()).F = false;
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k : invokeV.intValue;
    }

    @Override // b.a.r0.x0.r1.a
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            l();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            e eVar = new e(this.f26251f, this, this.j);
            this.f26250e = eVar;
            this.f26254i.add(eVar);
            this.f26252g.addAdapters(this.f26254i);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f26250e.k0() : invokeV.booleanValue;
    }

    public void f(String str, boolean z) {
        g gVar;
        g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048582, this, str, z) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        boolean z2 = false;
        for (n nVar : this.f26253h) {
            if (nVar != null && (nVar instanceof g) && (bVar = (gVar = (g) nVar).y) != null && str.equals(bVar.f26266a)) {
                gVar.y.f26270e = z;
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
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bdTypeListView = this.f26252g) == null || bdTypeListView.getAdapter2() == null || !(this.f26252g.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f26252g.getAdapter2().notifyDataSetChanged();
    }

    public void h(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, configuration) == null) {
            this.f26250e.l0(configuration);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f26250e.onDestroy();
        }
    }

    public boolean j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) ? this.f26250e.o0(i2) : invokeI.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f26250e.p0();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            b();
            this.k = 0;
            k();
        }
    }

    public void m(List<g> list, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048589, this, list, z) == null) || list == null) {
            return;
        }
        if (z) {
            this.f26253h.clear();
        }
        this.f26253h.addAll(list);
        this.f26252g.setData(this.f26253h);
        if (z && list.size() > 0 && this.j && j.H()) {
            l();
            list.get(0).F = true;
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f26250e.q0();
        }
    }
}
