package c.a.t0.o1.f.a.d;

import c.a.d.n.e.n;
import c.a.d.n.e.s;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.LoadingViewAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.d.n.e.a> f20912b;

    /* renamed from: c  reason: collision with root package name */
    public s f20913c;

    /* renamed from: d  reason: collision with root package name */
    public g f20914d;

    /* renamed from: e  reason: collision with root package name */
    public k f20915e;

    /* renamed from: f  reason: collision with root package name */
    public b f20916f;

    /* renamed from: g  reason: collision with root package name */
    public d f20917g;

    /* renamed from: h  reason: collision with root package name */
    public c f20918h;

    /* renamed from: i  reason: collision with root package name */
    public e f20919i;

    /* renamed from: j  reason: collision with root package name */
    public f f20920j;

    public h(TbPageContext tbPageContext, s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, sVar};
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
        this.f20913c = sVar;
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20913c.getData() : (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.f20912b = arrayList;
            arrayList.add(new j(this.a));
            this.f20912b.add(new i(this.a));
            this.f20912b.add(new LoadingViewAdapter(this.a));
            g gVar = new g(this.a);
            this.f20914d = gVar;
            gVar.c0(this.f20913c);
            this.f20912b.add(this.f20914d);
            k kVar = new k(this.a);
            this.f20915e = kVar;
            kVar.c0(this.f20913c);
            this.f20912b.add(this.f20915e);
            b bVar = new b(this.a);
            this.f20916f = bVar;
            bVar.c0(this.f20913c);
            this.f20912b.add(this.f20916f);
            d dVar = new d(this.a);
            this.f20917g = dVar;
            dVar.c0(this.f20913c);
            this.f20912b.add(this.f20917g);
            c cVar = new c(this.a);
            this.f20918h = cVar;
            cVar.c0(this.f20913c);
            this.f20912b.add(this.f20918h);
            e eVar = new e(this.a);
            this.f20919i = eVar;
            eVar.c0(this.f20913c);
            this.f20912b.add(this.f20919i);
            f fVar = new f(this.a);
            this.f20920j = fVar;
            fVar.c0(this.f20913c);
            this.f20912b.add(this.f20920j);
            this.f20913c.addAdapters(this.f20912b);
        }
    }

    public void c() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (sVar = this.f20913c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f20913c.setData(list);
        }
    }

    public void e(c.a.s0.n.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            for (c.a.d.n.e.a aVar : this.f20912b) {
                if (aVar instanceof a) {
                    ((a) aVar).b0(fVar);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (c.a.d.n.e.a aVar : this.f20912b) {
                aVar.X(bdUniqueId);
            }
        }
    }
}
