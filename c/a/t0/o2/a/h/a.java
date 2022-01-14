package c.a.t0.o2.a.h;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.d.n.e.n;
import c.a.t0.o2.a.e;
import c.a.t0.o2.a.f;
import c.a.t0.o2.a.g;
import c.a.t0.o2.c.d;
import c.a.t0.o2.f.b;
import c.a.t0.o2.f.c;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;

    /* renamed from: b  reason: collision with root package name */
    public final List<c.a.d.n.e.a> f20809b;

    /* renamed from: c  reason: collision with root package name */
    public List<n> f20810c;

    /* renamed from: d  reason: collision with root package name */
    public g f20811d;

    /* renamed from: e  reason: collision with root package name */
    public e f20812e;

    /* renamed from: f  reason: collision with root package name */
    public f f20813f;

    /* renamed from: g  reason: collision with root package name */
    public c f20814g;

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
        this.f20809b = new ArrayList();
        d(context, bdTypeRecyclerView);
    }

    public void a(int i2, c.a.t0.o2.c.c cVar, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), cVar, Integer.valueOf(i3)}) == null) {
            new c.a.t0.o2.d.a().a(i2, cVar, i3, this.f20810c, this.a);
        }
    }

    public void b(boolean z) {
        List<n> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (list = this.f20810c) == null || list.size() <= 0) {
            return;
        }
        for (n nVar : this.f20810c) {
            if (nVar != null && (nVar instanceof d)) {
                d dVar = (d) nVar;
                dVar.u(z);
                h(dVar);
            }
        }
        this.a.getAdapter().notifyDataSetChanged();
    }

    public List<n> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20810c : (List) invokeV.objValue;
    }

    public final void d(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, bdTypeRecyclerView) == null) {
            this.f20811d = new g(context, c.a.t0.o2.c.f.f20853g);
            this.f20812e = new e(context, d.m);
            this.f20813f = new f(context, c.a.t0.o2.c.e.f20849h);
            this.f20809b.add(this.f20811d);
            this.f20809b.add(this.f20812e);
            this.f20809b.add(this.f20813f);
            this.a = bdTypeRecyclerView;
            bdTypeRecyclerView.addAdapters(this.f20809b);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<n> list = this.f20810c;
            if (list != null && list.size() > 0) {
                for (n nVar : this.f20810c) {
                    if (nVar != null && (nVar instanceof d) && ((d) nVar).l()) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<n> list = this.f20810c;
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (n nVar : this.f20810c) {
                if (nVar != null && (nVar instanceof d) && !((d) nVar).l()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            g gVar = this.f20811d;
            if (gVar != null) {
                gVar.H();
            }
            e eVar = this.f20812e;
            if (eVar != null) {
                eVar.H();
            }
            f fVar = this.f20813f;
            if (fVar != null) {
                fVar.H();
            }
        }
    }

    public final void h(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 3);
            statisticItem.param("fid", dVar.e());
            TiebaStatic.log(statisticItem);
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f20813f.e0(bVar);
        }
    }

    public void j(List<c.a.t0.o2.c.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, list) == null) || this.a == null) {
            return;
        }
        List<n> b2 = new c.a.t0.o2.d.a().b(list);
        if (ListUtils.isEmpty(this.f20810c)) {
            this.f20810c = b2;
        } else {
            this.f20810c.addAll(b2);
        }
        if (ListUtils.isEmpty(this.f20810c)) {
            return;
        }
        this.a.setData(this.f20810c);
        this.f20814g.a();
    }

    public void k(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.f20814g = cVar;
            this.f20812e.g0(cVar);
            this.f20813f.f0(cVar);
        }
    }
}
