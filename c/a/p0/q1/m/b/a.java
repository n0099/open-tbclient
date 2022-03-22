package c.a.p0.q1.m.b;

import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.p0.h0.e0.k;
import c.a.p0.h0.e0.l;
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
    public BdTypeRecyclerView f17609b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<c.a.d.o.e.a> f17610c;

    /* renamed from: d  reason: collision with root package name */
    public g f17611d;

    /* renamed from: e  reason: collision with root package name */
    public b f17612e;

    /* renamed from: f  reason: collision with root package name */
    public e f17613f;

    /* renamed from: g  reason: collision with root package name */
    public f f17614g;

    /* renamed from: h  reason: collision with root package name */
    public d f17615h;
    public c i;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.f17609b = bdTypeRecyclerView;
        this.f17610c = new LinkedList<>();
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f17609b;
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
            this.f17611d = new g(this.a, k.z0);
            this.f17612e = new b(this.a, l.U);
            this.f17613f = new e(this.a, k.I0);
            this.f17614g = new f(this.a, k.G0);
            this.f17615h = new d(this.a, k.A0);
            this.i = new c(this.a, k.H0);
            this.f17611d.e0(this.f17609b);
            this.f17612e.k0(this.f17609b);
            this.f17613f.d0(this.f17609b);
            this.f17614g.e0(this.f17609b);
            this.f17615h.f0(this.f17609b);
            this.i.h0(this.f17609b);
            this.f17610c.add(this.f17611d);
            this.f17610c.add(this.f17612e);
            this.f17610c.add(this.f17613f);
            this.f17610c.add(this.f17614g);
            this.f17610c.add(this.f17615h);
            this.f17610c.add(this.i);
            this.f17609b.a(this.f17610c);
        }
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeRecyclerView = this.f17609b) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bVar = this.f17612e) == null) {
            return;
        }
        bVar.onPause();
    }

    public void f(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f17609b.setData(list);
        }
    }

    public void g(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            f fVar = this.f17614g;
            if (fVar != null) {
                fVar.c0(bVar);
            }
            g gVar = this.f17611d;
            if (gVar != null) {
                gVar.c0(bVar);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            g gVar = this.f17611d;
            if (gVar != null) {
                gVar.d0(bdUniqueId);
            }
            b bVar = this.f17612e;
            if (bVar != null) {
                bVar.i0(bdUniqueId);
            }
            e eVar = this.f17613f;
            if (eVar != null) {
                eVar.c0(bdUniqueId);
            }
            f fVar = this.f17614g;
            if (fVar != null) {
                fVar.d0(bdUniqueId);
            }
            d dVar = this.f17615h;
            if (dVar != null) {
                dVar.e0(bdUniqueId);
            }
            c cVar = this.i;
            if (cVar != null) {
                cVar.f0(bdUniqueId);
            }
        }
    }

    public void i(c.a.p0.q1.i.k.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            b bVar = this.f17612e;
            if (bVar != null) {
                bVar.j0(fVar);
            }
            c cVar = this.i;
            if (cVar != null) {
                cVar.g0(fVar);
            }
        }
    }
}
