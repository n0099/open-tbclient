package c.a.p0.f1.f.a.d;

import c.a.e.k.e.n;
import c.a.e.k.e.s;
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
    public TbPageContext f17208a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.e.k.e.a> f17209b;

    /* renamed from: c  reason: collision with root package name */
    public s f17210c;

    /* renamed from: d  reason: collision with root package name */
    public g f17211d;

    /* renamed from: e  reason: collision with root package name */
    public k f17212e;

    /* renamed from: f  reason: collision with root package name */
    public b f17213f;

    /* renamed from: g  reason: collision with root package name */
    public d f17214g;

    /* renamed from: h  reason: collision with root package name */
    public c f17215h;

    /* renamed from: i  reason: collision with root package name */
    public e f17216i;

    /* renamed from: j  reason: collision with root package name */
    public f f17217j;

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
        this.f17208a = tbPageContext;
        this.f17210c = sVar;
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f17210c.getData() : (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.f17209b = arrayList;
            arrayList.add(new j(this.f17208a));
            this.f17209b.add(new i(this.f17208a));
            this.f17209b.add(new LoadingViewAdapter(this.f17208a));
            g gVar = new g(this.f17208a);
            this.f17211d = gVar;
            gVar.k0(this.f17210c);
            this.f17209b.add(this.f17211d);
            k kVar = new k(this.f17208a);
            this.f17212e = kVar;
            kVar.k0(this.f17210c);
            this.f17209b.add(this.f17212e);
            b bVar = new b(this.f17208a);
            this.f17213f = bVar;
            bVar.k0(this.f17210c);
            this.f17209b.add(this.f17213f);
            d dVar = new d(this.f17208a);
            this.f17214g = dVar;
            dVar.k0(this.f17210c);
            this.f17209b.add(this.f17214g);
            c cVar = new c(this.f17208a);
            this.f17215h = cVar;
            cVar.k0(this.f17210c);
            this.f17209b.add(this.f17215h);
            e eVar = new e(this.f17208a);
            this.f17216i = eVar;
            eVar.k0(this.f17210c);
            this.f17209b.add(this.f17216i);
            f fVar = new f(this.f17208a);
            this.f17217j = fVar;
            fVar.k0(this.f17210c);
            this.f17209b.add(this.f17217j);
            this.f17210c.addAdapters(this.f17209b);
        }
    }

    public void c() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (sVar = this.f17210c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f17210c.setData(list);
        }
    }

    public void e(c.a.o0.n.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            for (c.a.e.k.e.a aVar : this.f17209b) {
                if (aVar instanceof a) {
                    ((a) aVar).j0(fVar);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (c.a.e.k.e.a aVar : this.f17209b) {
                aVar.f0(bdUniqueId);
            }
        }
    }
}
