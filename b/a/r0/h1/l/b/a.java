package b.a.r0.h1.l.b;

import androidx.core.view.InputDeviceCompat;
import b.a.e.m.e.n;
import b.a.r0.b0.f0.k;
import b.a.r0.b0.f0.l;
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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f19140a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f19141b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<b.a.e.m.e.a> f19142c;

    /* renamed from: d  reason: collision with root package name */
    public g f19143d;

    /* renamed from: e  reason: collision with root package name */
    public b f19144e;

    /* renamed from: f  reason: collision with root package name */
    public e f19145f;

    /* renamed from: g  reason: collision with root package name */
    public f f19146g;

    /* renamed from: h  reason: collision with root package name */
    public d f19147h;

    /* renamed from: i  reason: collision with root package name */
    public c f19148i;

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
        this.f19140a = tbPageContext;
        this.f19141b = bdTypeRecyclerView;
        this.f19142c = new LinkedList<>();
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f19141b;
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
            this.f19143d = new g(this.f19140a, k.E0);
            this.f19144e = new b(this.f19140a, l.Z);
            this.f19145f = new e(this.f19140a, k.N0);
            this.f19146g = new f(this.f19140a, k.L0);
            this.f19147h = new d(this.f19140a, k.F0);
            this.f19148i = new c(this.f19140a, k.M0);
            this.f19143d.l0(this.f19141b);
            this.f19144e.r0(this.f19141b);
            this.f19145f.k0(this.f19141b);
            this.f19146g.l0(this.f19141b);
            this.f19147h.m0(this.f19141b);
            this.f19148i.o0(this.f19141b);
            this.f19142c.add(this.f19143d);
            this.f19142c.add(this.f19144e);
            this.f19142c.add(this.f19145f);
            this.f19142c.add(this.f19146g);
            this.f19142c.add(this.f19147h);
            this.f19142c.add(this.f19148i);
            this.f19141b.addAdapters(this.f19142c);
        }
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeRecyclerView = this.f19141b) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bVar = this.f19144e) == null) {
            return;
        }
        bVar.onPause();
    }

    public void f(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f19141b.setData(list);
        }
    }

    public void g(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            f fVar = this.f19146g;
            if (fVar != null) {
                fVar.j0(bVar);
            }
            g gVar = this.f19143d;
            if (gVar != null) {
                gVar.j0(bVar);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            g gVar = this.f19143d;
            if (gVar != null) {
                gVar.k0(bdUniqueId);
            }
            b bVar = this.f19144e;
            if (bVar != null) {
                bVar.p0(bdUniqueId);
            }
            e eVar = this.f19145f;
            if (eVar != null) {
                eVar.j0(bdUniqueId);
            }
            f fVar = this.f19146g;
            if (fVar != null) {
                fVar.k0(bdUniqueId);
            }
            d dVar = this.f19147h;
            if (dVar != null) {
                dVar.l0(bdUniqueId);
            }
            c cVar = this.f19148i;
            if (cVar != null) {
                cVar.m0(bdUniqueId);
            }
        }
    }

    public void i(b.a.r0.h1.h.k.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            b bVar = this.f19144e;
            if (bVar != null) {
                bVar.q0(fVar);
            }
            c cVar = this.f19148i;
            if (cVar != null) {
                cVar.n0(fVar);
            }
        }
    }
}
