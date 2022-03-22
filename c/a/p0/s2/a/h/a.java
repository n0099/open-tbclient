package c.a.p0.s2.a.h;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.p0.s2.a.e;
import c.a.p0.s2.a.f;
import c.a.p0.s2.a.g;
import c.a.p0.s2.c.d;
import c.a.p0.s2.f.b;
import c.a.p0.s2.f.c;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;

    /* renamed from: b  reason: collision with root package name */
    public final List<c.a.d.o.e.a> f18203b;

    /* renamed from: c  reason: collision with root package name */
    public List<n> f18204c;

    /* renamed from: d  reason: collision with root package name */
    public g f18205d;

    /* renamed from: e  reason: collision with root package name */
    public e f18206e;

    /* renamed from: f  reason: collision with root package name */
    public f f18207f;

    /* renamed from: g  reason: collision with root package name */
    public c f18208g;

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
        this.f18203b = new ArrayList();
        d(context, bdTypeRecyclerView);
    }

    public void a(int i, c.a.p0.s2.c.c cVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), cVar, Integer.valueOf(i2)}) == null) {
            new c.a.p0.s2.d.a().a(i, cVar, i2, this.f18204c, this.a);
        }
    }

    public void b(boolean z) {
        List<n> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (list = this.f18204c) == null || list.size() <= 0) {
            return;
        }
        for (n nVar : this.f18204c) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18204c : (List) invokeV.objValue;
    }

    public final void d(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, bdTypeRecyclerView) == null) {
            this.f18205d = new g(context, c.a.p0.s2.c.f.f18245c);
            this.f18206e = new e(context, d.i);
            this.f18207f = new f(context, c.a.p0.s2.c.e.f18242d);
            this.f18203b.add(this.f18205d);
            this.f18203b.add(this.f18206e);
            this.f18203b.add(this.f18207f);
            this.a = bdTypeRecyclerView;
            bdTypeRecyclerView.a(this.f18203b);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<n> list = this.f18204c;
            if (list != null && list.size() > 0) {
                for (n nVar : this.f18204c) {
                    if (nVar != null && (nVar instanceof d) && ((d) nVar).k()) {
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
            List<n> list = this.f18204c;
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (n nVar : this.f18204c) {
                if (nVar != null && (nVar instanceof d) && !((d) nVar).k()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            g gVar = this.f18205d;
            if (gVar != null) {
                gVar.H();
            }
            e eVar = this.f18206e;
            if (eVar != null) {
                eVar.H();
            }
            f fVar = this.f18207f;
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
            this.f18207f.e0(bVar);
        }
    }

    public void j(List<c.a.p0.s2.c.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, list) == null) || this.a == null) {
            return;
        }
        List<n> b2 = new c.a.p0.s2.d.a().b(list);
        if (ListUtils.isEmpty(this.f18204c)) {
            this.f18204c = b2;
        } else {
            this.f18204c.addAll(b2);
        }
        if (ListUtils.isEmpty(this.f18204c)) {
            return;
        }
        this.a.setData(this.f18204c);
        this.f18208g.a();
    }

    public void k(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.f18208g = cVar;
            this.f18206e.g0(cVar);
            this.f18207f.f0(cVar);
        }
    }
}
