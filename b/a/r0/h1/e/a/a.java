package b.a.r0.h1.e.a;

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
    public TbPageContext f18539a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f18540b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<b.a.e.m.e.a> f18541c;

    /* renamed from: d  reason: collision with root package name */
    public f f18542d;

    /* renamed from: e  reason: collision with root package name */
    public c f18543e;

    /* renamed from: f  reason: collision with root package name */
    public d f18544f;

    /* renamed from: g  reason: collision with root package name */
    public e f18545g;

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
        this.f18539a = tbPageContext;
        this.f18540b = bdTypeRecyclerView;
        this.f18541c = new LinkedList<>();
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f18540b;
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
            this.f18542d = new f(this.f18539a, k.E0);
            this.f18543e = new c(this.f18539a, l.Z);
            this.f18544f = new d(this.f18539a, k.N0);
            this.f18545g = new e(this.f18539a, k.L0);
            this.f18542d.m0(this.f18540b);
            this.f18543e.o0(this.f18540b);
            this.f18544f.l0(this.f18540b);
            this.f18545g.n0(this.f18540b);
            this.f18541c.add(this.f18542d);
            this.f18541c.add(this.f18543e);
            this.f18541c.add(this.f18544f);
            this.f18541c.add(this.f18545g);
            this.f18540b.addAdapters(this.f18541c);
        }
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeRecyclerView = this.f18540b) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (cVar = this.f18543e) == null) {
            return;
        }
        cVar.onPause();
    }

    public void f(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f18540b.setData(list);
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            f fVar = this.f18542d;
            if (fVar != null) {
                fVar.k0(i2);
            }
            c cVar = this.f18543e;
            if (cVar != null) {
                cVar.m0(i2);
            }
            d dVar = this.f18544f;
            if (dVar != null) {
                dVar.j0(i2);
            }
            e eVar = this.f18545g;
            if (eVar != null) {
                eVar.l0(i2);
            }
        }
    }

    public void h(NEGFeedBackView.b bVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || (eVar = this.f18545g) == null) {
            return;
        }
        eVar.k0(bVar);
    }

    public void i(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
            f fVar = this.f18542d;
            if (fVar != null) {
                fVar.l0(bdUniqueId);
            }
            c cVar = this.f18543e;
            if (cVar != null) {
                cVar.n0(bdUniqueId);
            }
            d dVar = this.f18544f;
            if (dVar != null) {
                dVar.k0(bdUniqueId);
            }
            e eVar = this.f18545g;
            if (eVar != null) {
                eVar.m0(bdUniqueId);
            }
        }
    }
}
