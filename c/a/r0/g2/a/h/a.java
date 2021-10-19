package c.a.r0.g2.a.h;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.e.l.e.n;
import c.a.r0.g2.a.e;
import c.a.r0.g2.a.f;
import c.a.r0.g2.a.g;
import c.a.r0.g2.c.d;
import c.a.r0.g2.f.b;
import c.a.r0.g2.f.c;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdTypeRecyclerView f17775a;

    /* renamed from: b  reason: collision with root package name */
    public final List<c.a.e.l.e.a> f17776b;

    /* renamed from: c  reason: collision with root package name */
    public List<n> f17777c;

    /* renamed from: d  reason: collision with root package name */
    public g f17778d;

    /* renamed from: e  reason: collision with root package name */
    public e f17779e;

    /* renamed from: f  reason: collision with root package name */
    public f f17780f;

    /* renamed from: g  reason: collision with root package name */
    public c f17781g;

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
        this.f17776b = new ArrayList();
        d(context, bdTypeRecyclerView);
    }

    public void a(int i2, c.a.r0.g2.c.c cVar, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), cVar, Integer.valueOf(i3)}) == null) {
            new c.a.r0.g2.d.a().a(i2, cVar, i3, this.f17777c, this.f17775a);
        }
    }

    public void b(boolean z) {
        List<n> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (list = this.f17777c) == null || list.size() <= 0) {
            return;
        }
        for (n nVar : this.f17777c) {
            if (nVar != null && (nVar instanceof d)) {
                d dVar = (d) nVar;
                dVar.u(z);
                h(dVar);
            }
        }
        this.f17775a.getAdapter().notifyDataSetChanged();
    }

    public List<n> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f17777c : (List) invokeV.objValue;
    }

    public final void d(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, bdTypeRecyclerView) == null) {
            this.f17778d = new g(context, c.a.r0.g2.c.f.f17824g);
            this.f17779e = new e(context, d.m);
            this.f17780f = new f(context, c.a.r0.g2.c.e.f17820h);
            this.f17776b.add(this.f17778d);
            this.f17776b.add(this.f17779e);
            this.f17776b.add(this.f17780f);
            this.f17775a = bdTypeRecyclerView;
            bdTypeRecyclerView.addAdapters(this.f17776b);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<n> list = this.f17777c;
            if (list != null && list.size() > 0) {
                for (n nVar : this.f17777c) {
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
            List<n> list = this.f17777c;
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (n nVar : this.f17777c) {
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
            g gVar = this.f17778d;
            if (gVar != null) {
                gVar.P();
            }
            e eVar = this.f17779e;
            if (eVar != null) {
                eVar.P();
            }
            f fVar = this.f17780f;
            if (fVar != null) {
                fVar.P();
            }
        }
    }

    public final void h(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 3);
            statisticItem.param("fid", dVar.d());
            TiebaStatic.log(statisticItem);
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f17780f.m0(bVar);
        }
    }

    public void j(List<c.a.r0.g2.c.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, list) == null) || this.f17775a == null) {
            return;
        }
        List<n> b2 = new c.a.r0.g2.d.a().b(list);
        if (ListUtils.isEmpty(this.f17777c)) {
            this.f17777c = b2;
        } else {
            this.f17777c.addAll(b2);
        }
        if (ListUtils.isEmpty(this.f17777c)) {
            return;
        }
        this.f17775a.setData(this.f17777c);
        this.f17781g.a();
    }

    public void k(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.f17781g = cVar;
            this.f17779e.o0(cVar);
            this.f17780f.n0(cVar);
        }
    }
}
