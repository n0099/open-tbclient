package c.a.r0.g1.f.a.d;

import c.a.e.l.e.n;
import c.a.e.l.e.s;
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
/* loaded from: classes3.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f18077a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.e.l.e.a> f18078b;

    /* renamed from: c  reason: collision with root package name */
    public s f18079c;

    /* renamed from: d  reason: collision with root package name */
    public g f18080d;

    /* renamed from: e  reason: collision with root package name */
    public k f18081e;

    /* renamed from: f  reason: collision with root package name */
    public b f18082f;

    /* renamed from: g  reason: collision with root package name */
    public d f18083g;

    /* renamed from: h  reason: collision with root package name */
    public c f18084h;

    /* renamed from: i  reason: collision with root package name */
    public e f18085i;

    /* renamed from: j  reason: collision with root package name */
    public f f18086j;

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
        this.f18077a = tbPageContext;
        this.f18079c = sVar;
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18079c.getData() : (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.f18078b = arrayList;
            arrayList.add(new j(this.f18077a));
            this.f18078b.add(new i(this.f18077a));
            this.f18078b.add(new LoadingViewAdapter(this.f18077a));
            g gVar = new g(this.f18077a);
            this.f18080d = gVar;
            gVar.k0(this.f18079c);
            this.f18078b.add(this.f18080d);
            k kVar = new k(this.f18077a);
            this.f18081e = kVar;
            kVar.k0(this.f18079c);
            this.f18078b.add(this.f18081e);
            b bVar = new b(this.f18077a);
            this.f18082f = bVar;
            bVar.k0(this.f18079c);
            this.f18078b.add(this.f18082f);
            d dVar = new d(this.f18077a);
            this.f18083g = dVar;
            dVar.k0(this.f18079c);
            this.f18078b.add(this.f18083g);
            c cVar = new c(this.f18077a);
            this.f18084h = cVar;
            cVar.k0(this.f18079c);
            this.f18078b.add(this.f18084h);
            e eVar = new e(this.f18077a);
            this.f18085i = eVar;
            eVar.k0(this.f18079c);
            this.f18078b.add(this.f18085i);
            f fVar = new f(this.f18077a);
            this.f18086j = fVar;
            fVar.k0(this.f18079c);
            this.f18078b.add(this.f18086j);
            this.f18079c.addAdapters(this.f18078b);
        }
    }

    public void c() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (sVar = this.f18079c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f18079c.setData(list);
        }
    }

    public void e(c.a.q0.n.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            for (c.a.e.l.e.a aVar : this.f18078b) {
                if (aVar instanceof a) {
                    ((a) aVar).j0(fVar);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (c.a.e.l.e.a aVar : this.f18078b) {
                aVar.f0(bdUniqueId);
            }
        }
    }
}
