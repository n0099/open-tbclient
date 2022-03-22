package c.a.p0.q1.f.a;

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
    public BdTypeRecyclerView f17244b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<c.a.d.o.e.a> f17245c;

    /* renamed from: d  reason: collision with root package name */
    public f f17246d;

    /* renamed from: e  reason: collision with root package name */
    public c f17247e;

    /* renamed from: f  reason: collision with root package name */
    public d f17248f;

    /* renamed from: g  reason: collision with root package name */
    public e f17249g;

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
        this.f17244b = bdTypeRecyclerView;
        this.f17245c = new LinkedList<>();
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f17244b;
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
            this.f17246d = new f(this.a, k.z0);
            this.f17247e = new c(this.a, l.U);
            this.f17248f = new d(this.a, k.I0);
            this.f17249g = new e(this.a, k.G0);
            this.f17246d.f0(this.f17244b);
            this.f17247e.h0(this.f17244b);
            this.f17248f.e0(this.f17244b);
            this.f17249g.g0(this.f17244b);
            this.f17245c.add(this.f17246d);
            this.f17245c.add(this.f17247e);
            this.f17245c.add(this.f17248f);
            this.f17245c.add(this.f17249g);
            this.f17244b.a(this.f17245c);
        }
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeRecyclerView = this.f17244b) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (cVar = this.f17247e) == null) {
            return;
        }
        cVar.onPause();
    }

    public void f(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f17244b.setData(list);
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            f fVar = this.f17246d;
            if (fVar != null) {
                fVar.d0(i);
            }
            c cVar = this.f17247e;
            if (cVar != null) {
                cVar.f0(i);
            }
            d dVar = this.f17248f;
            if (dVar != null) {
                dVar.c0(i);
            }
            e eVar = this.f17249g;
            if (eVar != null) {
                eVar.e0(i);
            }
        }
    }

    public void h(NEGFeedBackView.b bVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || (eVar = this.f17249g) == null) {
            return;
        }
        eVar.d0(bVar);
    }

    public void i(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
            f fVar = this.f17246d;
            if (fVar != null) {
                fVar.e0(bdUniqueId);
            }
            c cVar = this.f17247e;
            if (cVar != null) {
                cVar.g0(bdUniqueId);
            }
            d dVar = this.f17248f;
            if (dVar != null) {
                dVar.d0(bdUniqueId);
            }
            e eVar = this.f17249g;
            if (eVar != null) {
                eVar.f0(bdUniqueId);
            }
        }
    }
}
