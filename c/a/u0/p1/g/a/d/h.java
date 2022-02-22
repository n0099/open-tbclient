package c.a.u0.p1.g.a.d;

import c.a.d.o.e.n;
import c.a.d.o.e.s;
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
/* loaded from: classes8.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.d.o.e.a> f20557b;

    /* renamed from: c  reason: collision with root package name */
    public s f20558c;

    /* renamed from: d  reason: collision with root package name */
    public g f20559d;

    /* renamed from: e  reason: collision with root package name */
    public k f20560e;

    /* renamed from: f  reason: collision with root package name */
    public b f20561f;

    /* renamed from: g  reason: collision with root package name */
    public d f20562g;

    /* renamed from: h  reason: collision with root package name */
    public c f20563h;

    /* renamed from: i  reason: collision with root package name */
    public e f20564i;

    /* renamed from: j  reason: collision with root package name */
    public f f20565j;

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
        this.f20558c = sVar;
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20558c.getData() : (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.f20557b = arrayList;
            arrayList.add(new j(this.a));
            this.f20557b.add(new i(this.a));
            this.f20557b.add(new LoadingViewAdapter(this.a));
            g gVar = new g(this.a);
            this.f20559d = gVar;
            gVar.c0(this.f20558c);
            this.f20557b.add(this.f20559d);
            k kVar = new k(this.a);
            this.f20560e = kVar;
            kVar.c0(this.f20558c);
            this.f20557b.add(this.f20560e);
            b bVar = new b(this.a);
            this.f20561f = bVar;
            bVar.c0(this.f20558c);
            this.f20557b.add(this.f20561f);
            d dVar = new d(this.a);
            this.f20562g = dVar;
            dVar.c0(this.f20558c);
            this.f20557b.add(this.f20562g);
            c cVar = new c(this.a);
            this.f20563h = cVar;
            cVar.c0(this.f20558c);
            this.f20557b.add(this.f20563h);
            e eVar = new e(this.a);
            this.f20564i = eVar;
            eVar.c0(this.f20558c);
            this.f20557b.add(this.f20564i);
            f fVar = new f(this.a);
            this.f20565j = fVar;
            fVar.c0(this.f20558c);
            this.f20557b.add(this.f20565j);
            this.f20558c.addAdapters(this.f20557b);
        }
    }

    public void c() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (sVar = this.f20558c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f20558c.setData(list);
        }
    }

    public void e(c.a.t0.n.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            for (c.a.d.o.e.a aVar : this.f20557b) {
                if (aVar instanceof a) {
                    ((a) aVar).b0(fVar);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (c.a.d.o.e.a aVar : this.f20557b) {
                aVar.X(bdUniqueId);
            }
        }
    }
}
