package b.a.r0.h1.l.b;

import androidx.core.view.InputDeviceCompat;
import b.a.e.l.e.n;
import b.a.r0.b0.e0.k;
import b.a.r0.b0.e0.l;
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
    public TbPageContext f17671a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f17672b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<b.a.e.l.e.a> f17673c;

    /* renamed from: d  reason: collision with root package name */
    public g f17674d;

    /* renamed from: e  reason: collision with root package name */
    public b f17675e;

    /* renamed from: f  reason: collision with root package name */
    public e f17676f;

    /* renamed from: g  reason: collision with root package name */
    public f f17677g;

    /* renamed from: h  reason: collision with root package name */
    public d f17678h;

    /* renamed from: i  reason: collision with root package name */
    public c f17679i;

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
        this.f17671a = tbPageContext;
        this.f17672b = bdTypeRecyclerView;
        this.f17673c = new LinkedList<>();
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f17672b;
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
            this.f17674d = new g(this.f17671a, k.C0);
            this.f17675e = new b(this.f17671a, l.X);
            this.f17676f = new e(this.f17671a, k.K0);
            this.f17677g = new f(this.f17671a, k.I0);
            this.f17678h = new d(this.f17671a, k.D0);
            this.f17679i = new c(this.f17671a, k.J0);
            this.f17674d.l0(this.f17672b);
            this.f17675e.r0(this.f17672b);
            this.f17676f.k0(this.f17672b);
            this.f17677g.l0(this.f17672b);
            this.f17678h.m0(this.f17672b);
            this.f17679i.o0(this.f17672b);
            this.f17673c.add(this.f17674d);
            this.f17673c.add(this.f17675e);
            this.f17673c.add(this.f17676f);
            this.f17673c.add(this.f17677g);
            this.f17673c.add(this.f17678h);
            this.f17673c.add(this.f17679i);
            this.f17672b.addAdapters(this.f17673c);
        }
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeRecyclerView = this.f17672b) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bVar = this.f17675e) == null) {
            return;
        }
        bVar.onPause();
    }

    public void f(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f17672b.setData(list);
        }
    }

    public void g(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            f fVar = this.f17677g;
            if (fVar != null) {
                fVar.j0(bVar);
            }
            g gVar = this.f17674d;
            if (gVar != null) {
                gVar.j0(bVar);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            g gVar = this.f17674d;
            if (gVar != null) {
                gVar.k0(bdUniqueId);
            }
            b bVar = this.f17675e;
            if (bVar != null) {
                bVar.p0(bdUniqueId);
            }
            e eVar = this.f17676f;
            if (eVar != null) {
                eVar.j0(bdUniqueId);
            }
            f fVar = this.f17677g;
            if (fVar != null) {
                fVar.k0(bdUniqueId);
            }
            d dVar = this.f17678h;
            if (dVar != null) {
                dVar.l0(bdUniqueId);
            }
            c cVar = this.f17679i;
            if (cVar != null) {
                cVar.m0(bdUniqueId);
            }
        }
    }

    public void i(b.a.r0.h1.h.k.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            b bVar = this.f17675e;
            if (bVar != null) {
                bVar.q0(fVar);
            }
            c cVar = this.f17679i;
            if (cVar != null) {
                cVar.n0(fVar);
            }
        }
    }
}
