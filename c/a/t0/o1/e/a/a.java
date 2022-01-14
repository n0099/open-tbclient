package c.a.t0.o1.e.a;

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
    public BdTypeRecyclerView f20255b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<c.a.d.n.e.a> f20256c;

    /* renamed from: d  reason: collision with root package name */
    public f f20257d;

    /* renamed from: e  reason: collision with root package name */
    public c f20258e;

    /* renamed from: f  reason: collision with root package name */
    public d f20259f;

    /* renamed from: g  reason: collision with root package name */
    public e f20260g;

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
        this.f20255b = bdTypeRecyclerView;
        this.f20256c = new LinkedList<>();
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f20255b;
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
            this.f20257d = new f(this.a, k.G0);
            this.f20258e = new c(this.a, l.Z);
            this.f20259f = new d(this.a, k.P0);
            this.f20260g = new e(this.a, k.N0);
            this.f20257d.f0(this.f20255b);
            this.f20258e.h0(this.f20255b);
            this.f20259f.e0(this.f20255b);
            this.f20260g.g0(this.f20255b);
            this.f20256c.add(this.f20257d);
            this.f20256c.add(this.f20258e);
            this.f20256c.add(this.f20259f);
            this.f20256c.add(this.f20260g);
            this.f20255b.addAdapters(this.f20256c);
        }
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeRecyclerView = this.f20255b) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (cVar = this.f20258e) == null) {
            return;
        }
        cVar.onPause();
    }

    public void f(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f20255b.setData(list);
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            f fVar = this.f20257d;
            if (fVar != null) {
                fVar.d0(i2);
            }
            c cVar = this.f20258e;
            if (cVar != null) {
                cVar.f0(i2);
            }
            d dVar = this.f20259f;
            if (dVar != null) {
                dVar.c0(i2);
            }
            e eVar = this.f20260g;
            if (eVar != null) {
                eVar.e0(i2);
            }
        }
    }

    public void h(NEGFeedBackView.b bVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || (eVar = this.f20260g) == null) {
            return;
        }
        eVar.d0(bVar);
    }

    public void i(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
            f fVar = this.f20257d;
            if (fVar != null) {
                fVar.e0(bdUniqueId);
            }
            c cVar = this.f20258e;
            if (cVar != null) {
                cVar.g0(bdUniqueId);
            }
            d dVar = this.f20259f;
            if (dVar != null) {
                dVar.d0(bdUniqueId);
            }
            e eVar = this.f20260g;
            if (eVar != null) {
                eVar.f0(bdUniqueId);
            }
        }
    }
}
