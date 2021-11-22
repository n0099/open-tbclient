package b.a.r0.g2.a.h;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import b.a.e.m.e.n;
import b.a.r0.g2.a.e;
import b.a.r0.g2.a.f;
import b.a.r0.g2.a.g;
import b.a.r0.g2.c.d;
import b.a.r0.g2.f.b;
import b.a.r0.g2.f.c;
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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdTypeRecyclerView f18252a;

    /* renamed from: b  reason: collision with root package name */
    public final List<b.a.e.m.e.a> f18253b;

    /* renamed from: c  reason: collision with root package name */
    public List<n> f18254c;

    /* renamed from: d  reason: collision with root package name */
    public g f18255d;

    /* renamed from: e  reason: collision with root package name */
    public e f18256e;

    /* renamed from: f  reason: collision with root package name */
    public f f18257f;

    /* renamed from: g  reason: collision with root package name */
    public c f18258g;

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
        this.f18253b = new ArrayList();
        d(context, bdTypeRecyclerView);
    }

    public void a(int i2, b.a.r0.g2.c.c cVar, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), cVar, Integer.valueOf(i3)}) == null) {
            new b.a.r0.g2.d.a().a(i2, cVar, i3, this.f18254c, this.f18252a);
        }
    }

    public void b(boolean z) {
        List<n> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (list = this.f18254c) == null || list.size() <= 0) {
            return;
        }
        for (n nVar : this.f18254c) {
            if (nVar != null && (nVar instanceof d)) {
                d dVar = (d) nVar;
                dVar.u(z);
                h(dVar);
            }
        }
        this.f18252a.getAdapter().notifyDataSetChanged();
    }

    public List<n> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18254c : (List) invokeV.objValue;
    }

    public final void d(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, bdTypeRecyclerView) == null) {
            this.f18255d = new g(context, b.a.r0.g2.c.f.f18298g);
            this.f18256e = new e(context, d.m);
            this.f18257f = new f(context, b.a.r0.g2.c.e.f18294h);
            this.f18253b.add(this.f18255d);
            this.f18253b.add(this.f18256e);
            this.f18253b.add(this.f18257f);
            this.f18252a = bdTypeRecyclerView;
            bdTypeRecyclerView.addAdapters(this.f18253b);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<n> list = this.f18254c;
            if (list != null && list.size() > 0) {
                for (n nVar : this.f18254c) {
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
            List<n> list = this.f18254c;
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (n nVar : this.f18254c) {
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
            g gVar = this.f18255d;
            if (gVar != null) {
                gVar.O();
            }
            e eVar = this.f18256e;
            if (eVar != null) {
                eVar.O();
            }
            f fVar = this.f18257f;
            if (fVar != null) {
                fVar.O();
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
            this.f18257f.l0(bVar);
        }
    }

    public void j(List<b.a.r0.g2.c.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, list) == null) || this.f18252a == null) {
            return;
        }
        List<n> b2 = new b.a.r0.g2.d.a().b(list);
        if (ListUtils.isEmpty(this.f18254c)) {
            this.f18254c = b2;
        } else {
            this.f18254c.addAll(b2);
        }
        if (ListUtils.isEmpty(this.f18254c)) {
            return;
        }
        this.f18252a.setData(this.f18254c);
        this.f18258g.a();
    }

    public void k(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.f18258g = cVar;
            this.f18256e.n0(cVar);
            this.f18257f.m0(cVar);
        }
    }
}
