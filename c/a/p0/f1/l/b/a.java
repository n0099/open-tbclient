package c.a.p0.f1.l.b;

import androidx.core.view.InputDeviceCompat;
import c.a.e.k.e.n;
import c.a.p0.a0.d0.k;
import c.a.p0.a0.d0.l;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f17698a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f17699b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<c.a.e.k.e.a> f17700c;

    /* renamed from: d  reason: collision with root package name */
    public g f17701d;

    /* renamed from: e  reason: collision with root package name */
    public b f17702e;

    /* renamed from: f  reason: collision with root package name */
    public e f17703f;

    /* renamed from: g  reason: collision with root package name */
    public f f17704g;

    /* renamed from: h  reason: collision with root package name */
    public d f17705h;

    /* renamed from: i  reason: collision with root package name */
    public c f17706i;

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
        this.f17698a = tbPageContext;
        this.f17699b = bdTypeRecyclerView;
        this.f17700c = new LinkedList<>();
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f17699b;
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
            this.f17701d = new g(this.f17698a, k.C0);
            this.f17702e = new b(this.f17698a, l.X);
            this.f17703f = new e(this.f17698a, k.K0);
            this.f17704g = new f(this.f17698a, k.I0);
            this.f17705h = new d(this.f17698a, k.D0);
            this.f17706i = new c(this.f17698a, k.J0);
            this.f17701d.m0(this.f17699b);
            this.f17702e.s0(this.f17699b);
            this.f17703f.l0(this.f17699b);
            this.f17704g.m0(this.f17699b);
            this.f17705h.n0(this.f17699b);
            this.f17706i.p0(this.f17699b);
            this.f17700c.add(this.f17701d);
            this.f17700c.add(this.f17702e);
            this.f17700c.add(this.f17703f);
            this.f17700c.add(this.f17704g);
            this.f17700c.add(this.f17705h);
            this.f17700c.add(this.f17706i);
            this.f17699b.addAdapters(this.f17700c);
        }
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeRecyclerView = this.f17699b) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bVar = this.f17702e) == null) {
            return;
        }
        bVar.onPause();
    }

    public void f(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f17699b.setData(list);
        }
    }

    public void g(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            f fVar = this.f17704g;
            if (fVar != null) {
                fVar.k0(bVar);
            }
            g gVar = this.f17701d;
            if (gVar != null) {
                gVar.k0(bVar);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            g gVar = this.f17701d;
            if (gVar != null) {
                gVar.l0(bdUniqueId);
            }
            b bVar = this.f17702e;
            if (bVar != null) {
                bVar.q0(bdUniqueId);
            }
            e eVar = this.f17703f;
            if (eVar != null) {
                eVar.k0(bdUniqueId);
            }
            f fVar = this.f17704g;
            if (fVar != null) {
                fVar.l0(bdUniqueId);
            }
            d dVar = this.f17705h;
            if (dVar != null) {
                dVar.m0(bdUniqueId);
            }
            c cVar = this.f17706i;
            if (cVar != null) {
                cVar.n0(bdUniqueId);
            }
        }
    }

    public void i(c.a.p0.f1.h.k.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
            b bVar = this.f17702e;
            if (bVar != null) {
                bVar.r0(eVar);
            }
            c cVar = this.f17706i;
            if (cVar != null) {
                cVar.o0(eVar);
            }
        }
    }
}
