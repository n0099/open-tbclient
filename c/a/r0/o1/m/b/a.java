package c.a.r0.o1.m.b;

import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.r0.f0.d0.k;
import c.a.r0.f0.d0.l;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f20288b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<c.a.d.o.e.a> f20289c;

    /* renamed from: d  reason: collision with root package name */
    public g f20290d;

    /* renamed from: e  reason: collision with root package name */
    public b f20291e;

    /* renamed from: f  reason: collision with root package name */
    public e f20292f;

    /* renamed from: g  reason: collision with root package name */
    public f f20293g;

    /* renamed from: h  reason: collision with root package name */
    public d f20294h;

    /* renamed from: i  reason: collision with root package name */
    public c f20295i;

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
        this.f20288b = bdTypeRecyclerView;
        this.f20289c = new LinkedList<>();
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f20288b;
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
            this.f20290d = new g(this.a, k.D0);
            this.f20291e = new b(this.a, l.Y);
            this.f20292f = new e(this.a, k.M0);
            this.f20293g = new f(this.a, k.K0);
            this.f20294h = new d(this.a, k.E0);
            this.f20295i = new c(this.a, k.L0);
            this.f20290d.e0(this.f20288b);
            this.f20291e.k0(this.f20288b);
            this.f20292f.d0(this.f20288b);
            this.f20293g.e0(this.f20288b);
            this.f20294h.f0(this.f20288b);
            this.f20295i.h0(this.f20288b);
            this.f20289c.add(this.f20290d);
            this.f20289c.add(this.f20291e);
            this.f20289c.add(this.f20292f);
            this.f20289c.add(this.f20293g);
            this.f20289c.add(this.f20294h);
            this.f20289c.add(this.f20295i);
            this.f20288b.addAdapters(this.f20289c);
        }
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeRecyclerView = this.f20288b) == null) {
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
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bVar = this.f20291e) == null) {
            return;
        }
        bVar.onPause();
    }

    public void f(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f20288b.setData(list);
        }
    }

    public void g(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            f fVar = this.f20293g;
            if (fVar != null) {
                fVar.c0(bVar);
            }
            g gVar = this.f20290d;
            if (gVar != null) {
                gVar.c0(bVar);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            g gVar = this.f20290d;
            if (gVar != null) {
                gVar.d0(bdUniqueId);
            }
            b bVar = this.f20291e;
            if (bVar != null) {
                bVar.i0(bdUniqueId);
            }
            e eVar = this.f20292f;
            if (eVar != null) {
                eVar.c0(bdUniqueId);
            }
            f fVar = this.f20293g;
            if (fVar != null) {
                fVar.d0(bdUniqueId);
            }
            d dVar = this.f20294h;
            if (dVar != null) {
                dVar.e0(bdUniqueId);
            }
            c cVar = this.f20295i;
            if (cVar != null) {
                cVar.f0(bdUniqueId);
            }
        }
    }

    public void i(c.a.r0.o1.i.k.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            b bVar = this.f20291e;
            if (bVar != null) {
                bVar.j0(fVar);
            }
            c cVar = this.f20295i;
            if (cVar != null) {
                cVar.g0(fVar);
            }
        }
    }
}
