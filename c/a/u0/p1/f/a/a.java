package c.a.u0.p1.f.a;

import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.u0.g0.d0.k;
import c.a.u0.g0.d0.l;
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
    public BdTypeRecyclerView f20462b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<c.a.d.o.e.a> f20463c;

    /* renamed from: d  reason: collision with root package name */
    public f f20464d;

    /* renamed from: e  reason: collision with root package name */
    public c f20465e;

    /* renamed from: f  reason: collision with root package name */
    public d f20466f;

    /* renamed from: g  reason: collision with root package name */
    public e f20467g;

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
        this.f20462b = bdTypeRecyclerView;
        this.f20463c = new LinkedList<>();
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f20462b;
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
            this.f20464d = new f(this.a, k.D0);
            this.f20465e = new c(this.a, l.Y);
            this.f20466f = new d(this.a, k.M0);
            this.f20467g = new e(this.a, k.K0);
            this.f20464d.f0(this.f20462b);
            this.f20465e.h0(this.f20462b);
            this.f20466f.e0(this.f20462b);
            this.f20467g.g0(this.f20462b);
            this.f20463c.add(this.f20464d);
            this.f20463c.add(this.f20465e);
            this.f20463c.add(this.f20466f);
            this.f20463c.add(this.f20467g);
            this.f20462b.addAdapters(this.f20463c);
        }
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeRecyclerView = this.f20462b) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (cVar = this.f20465e) == null) {
            return;
        }
        cVar.onPause();
    }

    public void f(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f20462b.setData(list);
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            f fVar = this.f20464d;
            if (fVar != null) {
                fVar.d0(i2);
            }
            c cVar = this.f20465e;
            if (cVar != null) {
                cVar.f0(i2);
            }
            d dVar = this.f20466f;
            if (dVar != null) {
                dVar.c0(i2);
            }
            e eVar = this.f20467g;
            if (eVar != null) {
                eVar.e0(i2);
            }
        }
    }

    public void h(NEGFeedBackView.b bVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || (eVar = this.f20467g) == null) {
            return;
        }
        eVar.d0(bVar);
    }

    public void i(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
            f fVar = this.f20464d;
            if (fVar != null) {
                fVar.e0(bdUniqueId);
            }
            c cVar = this.f20465e;
            if (cVar != null) {
                cVar.g0(bdUniqueId);
            }
            d dVar = this.f20466f;
            if (dVar != null) {
                dVar.d0(bdUniqueId);
            }
            e eVar = this.f20467g;
            if (eVar != null) {
                eVar.f0(bdUniqueId);
            }
        }
    }
}
