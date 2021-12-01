package c.a.r0.n1.l.b;

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
    public BdTypeRecyclerView f20727b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<c.a.d.m.e.a> f20728c;

    /* renamed from: d  reason: collision with root package name */
    public g f20729d;

    /* renamed from: e  reason: collision with root package name */
    public b f20730e;

    /* renamed from: f  reason: collision with root package name */
    public e f20731f;

    /* renamed from: g  reason: collision with root package name */
    public f f20732g;

    /* renamed from: h  reason: collision with root package name */
    public d f20733h;

    /* renamed from: i  reason: collision with root package name */
    public c f20734i;

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
        this.f20727b = bdTypeRecyclerView;
        this.f20728c = new LinkedList<>();
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f20727b;
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
            this.f20729d = new g(this.a, k.F0);
            this.f20730e = new b(this.a, l.Z);
            this.f20731f = new e(this.a, k.O0);
            this.f20732g = new f(this.a, k.M0);
            this.f20733h = new d(this.a, k.G0);
            this.f20734i = new c(this.a, k.N0);
            this.f20729d.l0(this.f20727b);
            this.f20730e.r0(this.f20727b);
            this.f20731f.k0(this.f20727b);
            this.f20732g.l0(this.f20727b);
            this.f20733h.m0(this.f20727b);
            this.f20734i.o0(this.f20727b);
            this.f20728c.add(this.f20729d);
            this.f20728c.add(this.f20730e);
            this.f20728c.add(this.f20731f);
            this.f20728c.add(this.f20732g);
            this.f20728c.add(this.f20733h);
            this.f20728c.add(this.f20734i);
            this.f20727b.addAdapters(this.f20728c);
        }
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeRecyclerView = this.f20727b) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bVar = this.f20730e) == null) {
            return;
        }
        bVar.onPause();
    }

    public void f(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f20727b.setData(list);
        }
    }

    public void g(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            f fVar = this.f20732g;
            if (fVar != null) {
                fVar.j0(bVar);
            }
            g gVar = this.f20729d;
            if (gVar != null) {
                gVar.j0(bVar);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            g gVar = this.f20729d;
            if (gVar != null) {
                gVar.k0(bdUniqueId);
            }
            b bVar = this.f20730e;
            if (bVar != null) {
                bVar.p0(bdUniqueId);
            }
            e eVar = this.f20731f;
            if (eVar != null) {
                eVar.j0(bdUniqueId);
            }
            f fVar = this.f20732g;
            if (fVar != null) {
                fVar.k0(bdUniqueId);
            }
            d dVar = this.f20733h;
            if (dVar != null) {
                dVar.l0(bdUniqueId);
            }
            c cVar = this.f20734i;
            if (cVar != null) {
                cVar.m0(bdUniqueId);
            }
        }
    }

    public void i(c.a.r0.n1.h.k.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            b bVar = this.f20730e;
            if (bVar != null) {
                bVar.q0(fVar);
            }
            c cVar = this.f20734i;
            if (cVar != null) {
                cVar.n0(fVar);
            }
        }
    }
}
