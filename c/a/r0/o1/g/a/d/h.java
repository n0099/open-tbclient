package c.a.r0.o1.g.a.d;

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
/* loaded from: classes2.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.d.o.e.a> f19897b;

    /* renamed from: c  reason: collision with root package name */
    public s f19898c;

    /* renamed from: d  reason: collision with root package name */
    public g f19899d;

    /* renamed from: e  reason: collision with root package name */
    public k f19900e;

    /* renamed from: f  reason: collision with root package name */
    public b f19901f;

    /* renamed from: g  reason: collision with root package name */
    public d f19902g;

    /* renamed from: h  reason: collision with root package name */
    public c f19903h;

    /* renamed from: i  reason: collision with root package name */
    public e f19904i;

    /* renamed from: j  reason: collision with root package name */
    public f f19905j;

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
        this.f19898c = sVar;
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19898c.getData() : (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.f19897b = arrayList;
            arrayList.add(new j(this.a));
            this.f19897b.add(new i(this.a));
            this.f19897b.add(new LoadingViewAdapter(this.a));
            g gVar = new g(this.a);
            this.f19899d = gVar;
            gVar.c0(this.f19898c);
            this.f19897b.add(this.f19899d);
            k kVar = new k(this.a);
            this.f19900e = kVar;
            kVar.c0(this.f19898c);
            this.f19897b.add(this.f19900e);
            b bVar = new b(this.a);
            this.f19901f = bVar;
            bVar.c0(this.f19898c);
            this.f19897b.add(this.f19901f);
            d dVar = new d(this.a);
            this.f19902g = dVar;
            dVar.c0(this.f19898c);
            this.f19897b.add(this.f19902g);
            c cVar = new c(this.a);
            this.f19903h = cVar;
            cVar.c0(this.f19898c);
            this.f19897b.add(this.f19903h);
            e eVar = new e(this.a);
            this.f19904i = eVar;
            eVar.c0(this.f19898c);
            this.f19897b.add(this.f19904i);
            f fVar = new f(this.a);
            this.f19905j = fVar;
            fVar.c0(this.f19898c);
            this.f19897b.add(this.f19905j);
            this.f19898c.addAdapters(this.f19897b);
        }
    }

    public void c() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (sVar = this.f19898c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f19898c.setData(list);
        }
    }

    public void e(c.a.q0.m.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            for (c.a.d.o.e.a aVar : this.f19897b) {
                if (aVar instanceof a) {
                    ((a) aVar).b0(fVar);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (c.a.d.o.e.a aVar : this.f19897b) {
                aVar.X(bdUniqueId);
            }
        }
    }
}
