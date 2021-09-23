package c.a.r0.g1.l.b;

import androidx.core.view.InputDeviceCompat;
import c.a.e.l.e.n;
import c.a.r0.a0.d0.k;
import c.a.r0.a0.d0.l;
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
    public TbPageContext f18574a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f18575b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<c.a.e.l.e.a> f18576c;

    /* renamed from: d  reason: collision with root package name */
    public g f18577d;

    /* renamed from: e  reason: collision with root package name */
    public b f18578e;

    /* renamed from: f  reason: collision with root package name */
    public e f18579f;

    /* renamed from: g  reason: collision with root package name */
    public f f18580g;

    /* renamed from: h  reason: collision with root package name */
    public d f18581h;

    /* renamed from: i  reason: collision with root package name */
    public c f18582i;

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
        this.f18574a = tbPageContext;
        this.f18575b = bdTypeRecyclerView;
        this.f18576c = new LinkedList<>();
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f18575b;
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
            this.f18577d = new g(this.f18574a, k.C0);
            this.f18578e = new b(this.f18574a, l.X);
            this.f18579f = new e(this.f18574a, k.K0);
            this.f18580g = new f(this.f18574a, k.I0);
            this.f18581h = new d(this.f18574a, k.D0);
            this.f18582i = new c(this.f18574a, k.J0);
            this.f18577d.m0(this.f18575b);
            this.f18578e.s0(this.f18575b);
            this.f18579f.l0(this.f18575b);
            this.f18580g.m0(this.f18575b);
            this.f18581h.n0(this.f18575b);
            this.f18582i.p0(this.f18575b);
            this.f18576c.add(this.f18577d);
            this.f18576c.add(this.f18578e);
            this.f18576c.add(this.f18579f);
            this.f18576c.add(this.f18580g);
            this.f18576c.add(this.f18581h);
            this.f18576c.add(this.f18582i);
            this.f18575b.addAdapters(this.f18576c);
        }
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeRecyclerView = this.f18575b) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bVar = this.f18578e) == null) {
            return;
        }
        bVar.onPause();
    }

    public void f(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f18575b.setData(list);
        }
    }

    public void g(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            f fVar = this.f18580g;
            if (fVar != null) {
                fVar.k0(bVar);
            }
            g gVar = this.f18577d;
            if (gVar != null) {
                gVar.k0(bVar);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            g gVar = this.f18577d;
            if (gVar != null) {
                gVar.l0(bdUniqueId);
            }
            b bVar = this.f18578e;
            if (bVar != null) {
                bVar.q0(bdUniqueId);
            }
            e eVar = this.f18579f;
            if (eVar != null) {
                eVar.k0(bdUniqueId);
            }
            f fVar = this.f18580g;
            if (fVar != null) {
                fVar.l0(bdUniqueId);
            }
            d dVar = this.f18581h;
            if (dVar != null) {
                dVar.m0(bdUniqueId);
            }
            c cVar = this.f18582i;
            if (cVar != null) {
                cVar.n0(bdUniqueId);
            }
        }
    }

    public void i(c.a.r0.g1.h.k.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
            b bVar = this.f18578e;
            if (bVar != null) {
                bVar.r0(eVar);
            }
            c cVar = this.f18582i;
            if (cVar != null) {
                cVar.o0(eVar);
            }
        }
    }
}
