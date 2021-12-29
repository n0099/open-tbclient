package c.a.t0.o1.l.b;

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
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f21309b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<c.a.d.n.e.a> f21310c;

    /* renamed from: d  reason: collision with root package name */
    public g f21311d;

    /* renamed from: e  reason: collision with root package name */
    public b f21312e;

    /* renamed from: f  reason: collision with root package name */
    public e f21313f;

    /* renamed from: g  reason: collision with root package name */
    public f f21314g;

    /* renamed from: h  reason: collision with root package name */
    public d f21315h;

    /* renamed from: i  reason: collision with root package name */
    public c f21316i;

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
        this.f21309b = bdTypeRecyclerView;
        this.f21310c = new LinkedList<>();
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f21309b;
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
            this.f21311d = new g(this.a, k.G0);
            this.f21312e = new b(this.a, l.Z);
            this.f21313f = new e(this.a, k.P0);
            this.f21314g = new f(this.a, k.N0);
            this.f21315h = new d(this.a, k.H0);
            this.f21316i = new c(this.a, k.O0);
            this.f21311d.e0(this.f21309b);
            this.f21312e.k0(this.f21309b);
            this.f21313f.d0(this.f21309b);
            this.f21314g.e0(this.f21309b);
            this.f21315h.f0(this.f21309b);
            this.f21316i.h0(this.f21309b);
            this.f21310c.add(this.f21311d);
            this.f21310c.add(this.f21312e);
            this.f21310c.add(this.f21313f);
            this.f21310c.add(this.f21314g);
            this.f21310c.add(this.f21315h);
            this.f21310c.add(this.f21316i);
            this.f21309b.addAdapters(this.f21310c);
        }
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeRecyclerView = this.f21309b) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bVar = this.f21312e) == null) {
            return;
        }
        bVar.onPause();
    }

    public void f(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f21309b.setData(list);
        }
    }

    public void g(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            f fVar = this.f21314g;
            if (fVar != null) {
                fVar.c0(bVar);
            }
            g gVar = this.f21311d;
            if (gVar != null) {
                gVar.c0(bVar);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            g gVar = this.f21311d;
            if (gVar != null) {
                gVar.d0(bdUniqueId);
            }
            b bVar = this.f21312e;
            if (bVar != null) {
                bVar.i0(bdUniqueId);
            }
            e eVar = this.f21313f;
            if (eVar != null) {
                eVar.c0(bdUniqueId);
            }
            f fVar = this.f21314g;
            if (fVar != null) {
                fVar.d0(bdUniqueId);
            }
            d dVar = this.f21315h;
            if (dVar != null) {
                dVar.e0(bdUniqueId);
            }
            c cVar = this.f21316i;
            if (cVar != null) {
                cVar.f0(bdUniqueId);
            }
        }
    }

    public void i(c.a.t0.o1.h.k.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            b bVar = this.f21312e;
            if (bVar != null) {
                bVar.j0(fVar);
            }
            c cVar = this.f21316i;
            if (cVar != null) {
                cVar.g0(fVar);
            }
        }
    }
}
