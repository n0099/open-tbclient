package c.a.r0.n1.e.a;

import androidx.core.view.InputDeviceCompat;
import c.a.d.m.e.n;
import c.a.r0.g0.f0.k;
import c.a.r0.g0.f0.l;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f20248b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<c.a.d.m.e.a> f20249c;

    /* renamed from: d  reason: collision with root package name */
    public f f20250d;

    /* renamed from: e  reason: collision with root package name */
    public c f20251e;

    /* renamed from: f  reason: collision with root package name */
    public d f20252f;

    /* renamed from: g  reason: collision with root package name */
    public e f20253g;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.f20248b = bdTypeRecyclerView;
        this.f20249c = new LinkedList<>();
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f20248b;
            if (bdTypeRecyclerView != null) {
                return bdTypeRecyclerView.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f20250d = new f(this.a, k.F0);
            this.f20251e = new c(this.a, l.Z);
            this.f20252f = new d(this.a, k.O0);
            this.f20253g = new e(this.a, k.M0);
            this.f20250d.m0(this.f20248b);
            this.f20251e.o0(this.f20248b);
            this.f20252f.l0(this.f20248b);
            this.f20253g.n0(this.f20248b);
            this.f20249c.add(this.f20250d);
            this.f20249c.add(this.f20251e);
            this.f20249c.add(this.f20252f);
            this.f20249c.add(this.f20253g);
            this.f20248b.addAdapters(this.f20249c);
        }
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeRecyclerView = this.f20248b) == null) {
            return;
        }
        bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public void e() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (cVar = this.f20251e) == null) {
            return;
        }
        cVar.onPause();
    }

    public void f(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f20248b.setData(list);
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            f fVar = this.f20250d;
            if (fVar != null) {
                fVar.k0(i2);
            }
            c cVar = this.f20251e;
            if (cVar != null) {
                cVar.m0(i2);
            }
            d dVar = this.f20252f;
            if (dVar != null) {
                dVar.j0(i2);
            }
            e eVar = this.f20253g;
            if (eVar != null) {
                eVar.l0(i2);
            }
        }
    }

    public void h(NEGFeedBackView.b bVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || (eVar = this.f20253g) == null) {
            return;
        }
        eVar.k0(bVar);
    }

    public void i(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
            f fVar = this.f20250d;
            if (fVar != null) {
                fVar.l0(bdUniqueId);
            }
            c cVar = this.f20251e;
            if (cVar != null) {
                cVar.n0(bdUniqueId);
            }
            d dVar = this.f20252f;
            if (dVar != null) {
                dVar.k0(bdUniqueId);
            }
            e eVar = this.f20253g;
            if (eVar != null) {
                eVar.m0(bdUniqueId);
            }
        }
    }
}
