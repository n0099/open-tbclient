package c.a.s0.o1.l.b;

import androidx.core.view.InputDeviceCompat;
import c.a.d.m.e.n;
import c.a.s0.g0.f0.k;
import c.a.s0.g0.f0.l;
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
    public BdTypeRecyclerView f21251b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<c.a.d.m.e.a> f21252c;

    /* renamed from: d  reason: collision with root package name */
    public g f21253d;

    /* renamed from: e  reason: collision with root package name */
    public b f21254e;

    /* renamed from: f  reason: collision with root package name */
    public e f21255f;

    /* renamed from: g  reason: collision with root package name */
    public f f21256g;

    /* renamed from: h  reason: collision with root package name */
    public d f21257h;

    /* renamed from: i  reason: collision with root package name */
    public c f21258i;

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
        this.f21251b = bdTypeRecyclerView;
        this.f21252c = new LinkedList<>();
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f21251b;
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
            this.f21253d = new g(this.a, k.F0);
            this.f21254e = new b(this.a, l.Z);
            this.f21255f = new e(this.a, k.O0);
            this.f21256g = new f(this.a, k.M0);
            this.f21257h = new d(this.a, k.G0);
            this.f21258i = new c(this.a, k.N0);
            this.f21253d.l0(this.f21251b);
            this.f21254e.r0(this.f21251b);
            this.f21255f.k0(this.f21251b);
            this.f21256g.l0(this.f21251b);
            this.f21257h.m0(this.f21251b);
            this.f21258i.o0(this.f21251b);
            this.f21252c.add(this.f21253d);
            this.f21252c.add(this.f21254e);
            this.f21252c.add(this.f21255f);
            this.f21252c.add(this.f21256g);
            this.f21252c.add(this.f21257h);
            this.f21252c.add(this.f21258i);
            this.f21251b.addAdapters(this.f21252c);
        }
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeRecyclerView = this.f21251b) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bVar = this.f21254e) == null) {
            return;
        }
        bVar.onPause();
    }

    public void f(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f21251b.setData(list);
        }
    }

    public void g(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            f fVar = this.f21256g;
            if (fVar != null) {
                fVar.j0(bVar);
            }
            g gVar = this.f21253d;
            if (gVar != null) {
                gVar.j0(bVar);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            g gVar = this.f21253d;
            if (gVar != null) {
                gVar.k0(bdUniqueId);
            }
            b bVar = this.f21254e;
            if (bVar != null) {
                bVar.p0(bdUniqueId);
            }
            e eVar = this.f21255f;
            if (eVar != null) {
                eVar.j0(bdUniqueId);
            }
            f fVar = this.f21256g;
            if (fVar != null) {
                fVar.k0(bdUniqueId);
            }
            d dVar = this.f21257h;
            if (dVar != null) {
                dVar.l0(bdUniqueId);
            }
            c cVar = this.f21258i;
            if (cVar != null) {
                cVar.m0(bdUniqueId);
            }
        }
    }

    public void i(c.a.s0.o1.h.k.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            b bVar = this.f21254e;
            if (bVar != null) {
                bVar.q0(fVar);
            }
            c cVar = this.f21258i;
            if (cVar != null) {
                cVar.n0(fVar);
            }
        }
    }
}
