package c.a.r0.h1.e.a;

import androidx.core.view.InputDeviceCompat;
import c.a.e.l.e.n;
import c.a.r0.b0.e0.k;
import c.a.r0.b0.e0.l;
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
    public TbPageContext f18126a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f18127b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<c.a.e.l.e.a> f18128c;

    /* renamed from: d  reason: collision with root package name */
    public f f18129d;

    /* renamed from: e  reason: collision with root package name */
    public c f18130e;

    /* renamed from: f  reason: collision with root package name */
    public d f18131f;

    /* renamed from: g  reason: collision with root package name */
    public e f18132g;

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
        this.f18126a = tbPageContext;
        this.f18127b = bdTypeRecyclerView;
        this.f18128c = new LinkedList<>();
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f18127b;
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
            this.f18129d = new f(this.f18126a, k.C0);
            this.f18130e = new c(this.f18126a, l.X);
            this.f18131f = new d(this.f18126a, k.K0);
            this.f18132g = new e(this.f18126a, k.I0);
            this.f18129d.n0(this.f18127b);
            this.f18130e.p0(this.f18127b);
            this.f18131f.m0(this.f18127b);
            this.f18132g.o0(this.f18127b);
            this.f18128c.add(this.f18129d);
            this.f18128c.add(this.f18130e);
            this.f18128c.add(this.f18131f);
            this.f18128c.add(this.f18132g);
            this.f18127b.addAdapters(this.f18128c);
        }
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeRecyclerView = this.f18127b) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (cVar = this.f18130e) == null) {
            return;
        }
        cVar.onPause();
    }

    public void f(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f18127b.setData(list);
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            f fVar = this.f18129d;
            if (fVar != null) {
                fVar.l0(i2);
            }
            c cVar = this.f18130e;
            if (cVar != null) {
                cVar.n0(i2);
            }
            d dVar = this.f18131f;
            if (dVar != null) {
                dVar.k0(i2);
            }
            e eVar = this.f18132g;
            if (eVar != null) {
                eVar.m0(i2);
            }
        }
    }

    public void h(NEGFeedBackView.b bVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || (eVar = this.f18132g) == null) {
            return;
        }
        eVar.l0(bVar);
    }

    public void i(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
            f fVar = this.f18129d;
            if (fVar != null) {
                fVar.m0(bdUniqueId);
            }
            c cVar = this.f18130e;
            if (cVar != null) {
                cVar.o0(bdUniqueId);
            }
            d dVar = this.f18131f;
            if (dVar != null) {
                dVar.l0(bdUniqueId);
            }
            e eVar = this.f18132g;
            if (eVar != null) {
                eVar.n0(bdUniqueId);
            }
        }
    }
}
