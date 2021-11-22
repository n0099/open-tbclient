package b.a.r0.h1.f.a.d;

import b.a.e.m.e.n;
import b.a.e.m.e.s;
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
/* loaded from: classes4.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f18663a;

    /* renamed from: b  reason: collision with root package name */
    public List<b.a.e.m.e.a> f18664b;

    /* renamed from: c  reason: collision with root package name */
    public s f18665c;

    /* renamed from: d  reason: collision with root package name */
    public g f18666d;

    /* renamed from: e  reason: collision with root package name */
    public k f18667e;

    /* renamed from: f  reason: collision with root package name */
    public b f18668f;

    /* renamed from: g  reason: collision with root package name */
    public d f18669g;

    /* renamed from: h  reason: collision with root package name */
    public c f18670h;

    /* renamed from: i  reason: collision with root package name */
    public e f18671i;
    public f j;

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
        this.f18663a = tbPageContext;
        this.f18665c = sVar;
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18665c.getData() : (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.f18664b = arrayList;
            arrayList.add(new j(this.f18663a));
            this.f18664b.add(new i(this.f18663a));
            this.f18664b.add(new LoadingViewAdapter(this.f18663a));
            g gVar = new g(this.f18663a);
            this.f18666d = gVar;
            gVar.j0(this.f18665c);
            this.f18664b.add(this.f18666d);
            k kVar = new k(this.f18663a);
            this.f18667e = kVar;
            kVar.j0(this.f18665c);
            this.f18664b.add(this.f18667e);
            b bVar = new b(this.f18663a);
            this.f18668f = bVar;
            bVar.j0(this.f18665c);
            this.f18664b.add(this.f18668f);
            d dVar = new d(this.f18663a);
            this.f18669g = dVar;
            dVar.j0(this.f18665c);
            this.f18664b.add(this.f18669g);
            c cVar = new c(this.f18663a);
            this.f18670h = cVar;
            cVar.j0(this.f18665c);
            this.f18664b.add(this.f18670h);
            e eVar = new e(this.f18663a);
            this.f18671i = eVar;
            eVar.j0(this.f18665c);
            this.f18664b.add(this.f18671i);
            f fVar = new f(this.f18663a);
            this.j = fVar;
            fVar.j0(this.f18665c);
            this.f18664b.add(this.j);
            this.f18665c.addAdapters(this.f18664b);
        }
    }

    public void c() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (sVar = this.f18665c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f18665c.setData(list);
        }
    }

    public void e(b.a.q0.n.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            for (b.a.e.m.e.a aVar : this.f18664b) {
                if (aVar instanceof a) {
                    ((a) aVar).i0(fVar);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (b.a.e.m.e.a aVar : this.f18664b) {
                aVar.e0(bdUniqueId);
            }
        }
    }
}
