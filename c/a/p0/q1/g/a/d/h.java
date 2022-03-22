package c.a.p0.q1.g.a.d;

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
    public List<c.a.d.o.e.a> f17309b;

    /* renamed from: c  reason: collision with root package name */
    public s f17310c;

    /* renamed from: d  reason: collision with root package name */
    public g f17311d;

    /* renamed from: e  reason: collision with root package name */
    public k f17312e;

    /* renamed from: f  reason: collision with root package name */
    public b f17313f;

    /* renamed from: g  reason: collision with root package name */
    public d f17314g;

    /* renamed from: h  reason: collision with root package name */
    public c f17315h;
    public e i;
    public f j;

    public h(TbPageContext tbPageContext, s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, sVar};
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
        this.f17310c = sVar;
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f17310c.getData() : (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.f17309b = arrayList;
            arrayList.add(new j(this.a));
            this.f17309b.add(new i(this.a));
            this.f17309b.add(new LoadingViewAdapter(this.a));
            g gVar = new g(this.a);
            this.f17311d = gVar;
            gVar.c0(this.f17310c);
            this.f17309b.add(this.f17311d);
            k kVar = new k(this.a);
            this.f17312e = kVar;
            kVar.c0(this.f17310c);
            this.f17309b.add(this.f17312e);
            b bVar = new b(this.a);
            this.f17313f = bVar;
            bVar.c0(this.f17310c);
            this.f17309b.add(this.f17313f);
            d dVar = new d(this.a);
            this.f17314g = dVar;
            dVar.c0(this.f17310c);
            this.f17309b.add(this.f17314g);
            c cVar = new c(this.a);
            this.f17315h = cVar;
            cVar.c0(this.f17310c);
            this.f17309b.add(this.f17315h);
            e eVar = new e(this.a);
            this.i = eVar;
            eVar.c0(this.f17310c);
            this.f17309b.add(this.i);
            f fVar = new f(this.a);
            this.j = fVar;
            fVar.c0(this.f17310c);
            this.f17309b.add(this.j);
            this.f17310c.a(this.f17309b);
        }
    }

    public void c() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (sVar = this.f17310c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f17310c.setData(list);
        }
    }

    public void e(c.a.o0.m.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            for (c.a.d.o.e.a aVar : this.f17309b) {
                if (aVar instanceof a) {
                    ((a) aVar).b0(fVar);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (c.a.d.o.e.a aVar : this.f17309b) {
                aVar.X(bdUniqueId);
            }
        }
    }
}
