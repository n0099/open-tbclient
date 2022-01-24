package c.a.t0.p1.l.b;

import androidx.core.view.InputDeviceCompat;
import c.a.d.n.e.n;
import c.a.t0.g0.f0.k;
import c.a.t0.g0.f0.l;
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
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f21067b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<c.a.d.n.e.a> f21068c;

    /* renamed from: d  reason: collision with root package name */
    public g f21069d;

    /* renamed from: e  reason: collision with root package name */
    public b f21070e;

    /* renamed from: f  reason: collision with root package name */
    public e f21071f;

    /* renamed from: g  reason: collision with root package name */
    public f f21072g;

    /* renamed from: h  reason: collision with root package name */
    public d f21073h;

    /* renamed from: i  reason: collision with root package name */
    public c f21074i;

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
        this.f21067b = bdTypeRecyclerView;
        this.f21068c = new LinkedList<>();
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f21067b;
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
            this.f21069d = new g(this.a, k.G0);
            this.f21070e = new b(this.a, l.Z);
            this.f21071f = new e(this.a, k.P0);
            this.f21072g = new f(this.a, k.N0);
            this.f21073h = new d(this.a, k.H0);
            this.f21074i = new c(this.a, k.O0);
            this.f21069d.e0(this.f21067b);
            this.f21070e.k0(this.f21067b);
            this.f21071f.d0(this.f21067b);
            this.f21072g.e0(this.f21067b);
            this.f21073h.f0(this.f21067b);
            this.f21074i.h0(this.f21067b);
            this.f21068c.add(this.f21069d);
            this.f21068c.add(this.f21070e);
            this.f21068c.add(this.f21071f);
            this.f21068c.add(this.f21072g);
            this.f21068c.add(this.f21073h);
            this.f21068c.add(this.f21074i);
            this.f21067b.addAdapters(this.f21068c);
        }
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeRecyclerView = this.f21067b) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bVar = this.f21070e) == null) {
            return;
        }
        bVar.onPause();
    }

    public void f(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f21067b.setData(list);
        }
    }

    public void g(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            f fVar = this.f21072g;
            if (fVar != null) {
                fVar.c0(bVar);
            }
            g gVar = this.f21069d;
            if (gVar != null) {
                gVar.c0(bVar);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            g gVar = this.f21069d;
            if (gVar != null) {
                gVar.d0(bdUniqueId);
            }
            b bVar = this.f21070e;
            if (bVar != null) {
                bVar.i0(bdUniqueId);
            }
            e eVar = this.f21071f;
            if (eVar != null) {
                eVar.c0(bdUniqueId);
            }
            f fVar = this.f21072g;
            if (fVar != null) {
                fVar.d0(bdUniqueId);
            }
            d dVar = this.f21073h;
            if (dVar != null) {
                dVar.e0(bdUniqueId);
            }
            c cVar = this.f21074i;
            if (cVar != null) {
                cVar.f0(bdUniqueId);
            }
        }
    }

    public void i(c.a.t0.p1.h.k.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            b bVar = this.f21070e;
            if (bVar != null) {
                bVar.j0(fVar);
            }
            c cVar = this.f21074i;
            if (cVar != null) {
                cVar.g0(fVar);
            }
        }
    }
}
