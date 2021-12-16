package c.a.s0.o1.e.a;

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
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f20770b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<c.a.d.m.e.a> f20771c;

    /* renamed from: d  reason: collision with root package name */
    public f f20772d;

    /* renamed from: e  reason: collision with root package name */
    public c f20773e;

    /* renamed from: f  reason: collision with root package name */
    public d f20774f;

    /* renamed from: g  reason: collision with root package name */
    public e f20775g;

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
        this.f20770b = bdTypeRecyclerView;
        this.f20771c = new LinkedList<>();
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f20770b;
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
            this.f20772d = new f(this.a, k.F0);
            this.f20773e = new c(this.a, l.Z);
            this.f20774f = new d(this.a, k.O0);
            this.f20775g = new e(this.a, k.M0);
            this.f20772d.m0(this.f20770b);
            this.f20773e.o0(this.f20770b);
            this.f20774f.l0(this.f20770b);
            this.f20775g.n0(this.f20770b);
            this.f20771c.add(this.f20772d);
            this.f20771c.add(this.f20773e);
            this.f20771c.add(this.f20774f);
            this.f20771c.add(this.f20775g);
            this.f20770b.addAdapters(this.f20771c);
        }
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeRecyclerView = this.f20770b) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (cVar = this.f20773e) == null) {
            return;
        }
        cVar.onPause();
    }

    public void f(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f20770b.setData(list);
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            f fVar = this.f20772d;
            if (fVar != null) {
                fVar.k0(i2);
            }
            c cVar = this.f20773e;
            if (cVar != null) {
                cVar.m0(i2);
            }
            d dVar = this.f20774f;
            if (dVar != null) {
                dVar.j0(i2);
            }
            e eVar = this.f20775g;
            if (eVar != null) {
                eVar.l0(i2);
            }
        }
    }

    public void h(NEGFeedBackView.b bVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || (eVar = this.f20775g) == null) {
            return;
        }
        eVar.k0(bVar);
    }

    public void i(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
            f fVar = this.f20772d;
            if (fVar != null) {
                fVar.l0(bdUniqueId);
            }
            c cVar = this.f20773e;
            if (cVar != null) {
                cVar.n0(bdUniqueId);
            }
            d dVar = this.f20774f;
            if (dVar != null) {
                dVar.k0(bdUniqueId);
            }
            e eVar = this.f20775g;
            if (eVar != null) {
                eVar.m0(bdUniqueId);
            }
        }
    }
}
