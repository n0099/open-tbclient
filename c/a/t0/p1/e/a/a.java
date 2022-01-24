package c.a.t0.p1.e.a;

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
    public BdTypeRecyclerView f20576b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<c.a.d.n.e.a> f20577c;

    /* renamed from: d  reason: collision with root package name */
    public f f20578d;

    /* renamed from: e  reason: collision with root package name */
    public c f20579e;

    /* renamed from: f  reason: collision with root package name */
    public d f20580f;

    /* renamed from: g  reason: collision with root package name */
    public e f20581g;

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
        this.f20576b = bdTypeRecyclerView;
        this.f20577c = new LinkedList<>();
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f20576b;
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
            this.f20578d = new f(this.a, k.G0);
            this.f20579e = new c(this.a, l.Z);
            this.f20580f = new d(this.a, k.P0);
            this.f20581g = new e(this.a, k.N0);
            this.f20578d.f0(this.f20576b);
            this.f20579e.h0(this.f20576b);
            this.f20580f.e0(this.f20576b);
            this.f20581g.g0(this.f20576b);
            this.f20577c.add(this.f20578d);
            this.f20577c.add(this.f20579e);
            this.f20577c.add(this.f20580f);
            this.f20577c.add(this.f20581g);
            this.f20576b.addAdapters(this.f20577c);
        }
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeRecyclerView = this.f20576b) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (cVar = this.f20579e) == null) {
            return;
        }
        cVar.onPause();
    }

    public void f(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f20576b.setData(list);
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            f fVar = this.f20578d;
            if (fVar != null) {
                fVar.d0(i2);
            }
            c cVar = this.f20579e;
            if (cVar != null) {
                cVar.f0(i2);
            }
            d dVar = this.f20580f;
            if (dVar != null) {
                dVar.c0(i2);
            }
            e eVar = this.f20581g;
            if (eVar != null) {
                eVar.e0(i2);
            }
        }
    }

    public void h(NEGFeedBackView.b bVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || (eVar = this.f20581g) == null) {
            return;
        }
        eVar.d0(bVar);
    }

    public void i(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
            f fVar = this.f20578d;
            if (fVar != null) {
                fVar.e0(bdUniqueId);
            }
            c cVar = this.f20579e;
            if (cVar != null) {
                cVar.g0(bdUniqueId);
            }
            d dVar = this.f20580f;
            if (dVar != null) {
                dVar.d0(bdUniqueId);
            }
            e eVar = this.f20581g;
            if (eVar != null) {
                eVar.f0(bdUniqueId);
            }
        }
    }
}
