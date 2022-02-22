package c.a.u0.q2.a.h;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.u0.q2.a.e;
import c.a.u0.q2.a.f;
import c.a.u0.q2.a.g;
import c.a.u0.q2.c.d;
import c.a.u0.q2.f.b;
import c.a.u0.q2.f.c;
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
    public final List<c.a.d.o.e.a> f21369b;

    /* renamed from: c  reason: collision with root package name */
    public List<n> f21370c;

    /* renamed from: d  reason: collision with root package name */
    public g f21371d;

    /* renamed from: e  reason: collision with root package name */
    public e f21372e;

    /* renamed from: f  reason: collision with root package name */
    public f f21373f;

    /* renamed from: g  reason: collision with root package name */
    public c f21374g;

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
        this.f21369b = new ArrayList();
        d(context, bdTypeRecyclerView);
    }

    public void a(int i2, c.a.u0.q2.c.c cVar, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), cVar, Integer.valueOf(i3)}) == null) {
            new c.a.u0.q2.d.a().a(i2, cVar, i3, this.f21370c, this.a);
        }
    }

    public void b(boolean z) {
        List<n> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (list = this.f21370c) == null || list.size() <= 0) {
            return;
        }
        for (n nVar : this.f21370c) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f21370c : (List) invokeV.objValue;
    }

    public final void d(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, bdTypeRecyclerView) == null) {
            this.f21371d = new g(context, c.a.u0.q2.c.f.f21413g);
            this.f21372e = new e(context, d.m);
            this.f21373f = new f(context, c.a.u0.q2.c.e.f21409h);
            this.f21369b.add(this.f21371d);
            this.f21369b.add(this.f21372e);
            this.f21369b.add(this.f21373f);
            this.a = bdTypeRecyclerView;
            bdTypeRecyclerView.addAdapters(this.f21369b);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<n> list = this.f21370c;
            if (list != null && list.size() > 0) {
                for (n nVar : this.f21370c) {
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
            List<n> list = this.f21370c;
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (n nVar : this.f21370c) {
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
            g gVar = this.f21371d;
            if (gVar != null) {
                gVar.H();
            }
            e eVar = this.f21372e;
            if (eVar != null) {
                eVar.H();
            }
            f fVar = this.f21373f;
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
            this.f21373f.e0(bVar);
        }
    }

    public void j(List<c.a.u0.q2.c.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, list) == null) || this.a == null) {
            return;
        }
        List<n> b2 = new c.a.u0.q2.d.a().b(list);
        if (ListUtils.isEmpty(this.f21370c)) {
            this.f21370c = b2;
        } else {
            this.f21370c.addAll(b2);
        }
        if (ListUtils.isEmpty(this.f21370c)) {
            return;
        }
        this.a.setData(this.f21370c);
        this.f21374g.a();
    }

    public void k(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.f21374g = cVar;
            this.f21372e.g0(cVar);
            this.f21373f.f0(cVar);
        }
    }
}
