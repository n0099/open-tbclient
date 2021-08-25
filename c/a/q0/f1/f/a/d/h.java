package c.a.q0.f1.f.a.d;

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
    public TbPageContext f17553a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.e.l.e.a> f17554b;

    /* renamed from: c  reason: collision with root package name */
    public s f17555c;

    /* renamed from: d  reason: collision with root package name */
    public g f17556d;

    /* renamed from: e  reason: collision with root package name */
    public k f17557e;

    /* renamed from: f  reason: collision with root package name */
    public b f17558f;

    /* renamed from: g  reason: collision with root package name */
    public d f17559g;

    /* renamed from: h  reason: collision with root package name */
    public c f17560h;

    /* renamed from: i  reason: collision with root package name */
    public e f17561i;

    /* renamed from: j  reason: collision with root package name */
    public f f17562j;

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
        this.f17553a = tbPageContext;
        this.f17555c = sVar;
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f17555c.getData() : (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.f17554b = arrayList;
            arrayList.add(new j(this.f17553a));
            this.f17554b.add(new i(this.f17553a));
            this.f17554b.add(new LoadingViewAdapter(this.f17553a));
            g gVar = new g(this.f17553a);
            this.f17556d = gVar;
            gVar.k0(this.f17555c);
            this.f17554b.add(this.f17556d);
            k kVar = new k(this.f17553a);
            this.f17557e = kVar;
            kVar.k0(this.f17555c);
            this.f17554b.add(this.f17557e);
            b bVar = new b(this.f17553a);
            this.f17558f = bVar;
            bVar.k0(this.f17555c);
            this.f17554b.add(this.f17558f);
            d dVar = new d(this.f17553a);
            this.f17559g = dVar;
            dVar.k0(this.f17555c);
            this.f17554b.add(this.f17559g);
            c cVar = new c(this.f17553a);
            this.f17560h = cVar;
            cVar.k0(this.f17555c);
            this.f17554b.add(this.f17560h);
            e eVar = new e(this.f17553a);
            this.f17561i = eVar;
            eVar.k0(this.f17555c);
            this.f17554b.add(this.f17561i);
            f fVar = new f(this.f17553a);
            this.f17562j = fVar;
            fVar.k0(this.f17555c);
            this.f17554b.add(this.f17562j);
            this.f17555c.addAdapters(this.f17554b);
        }
    }

    public void c() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (sVar = this.f17555c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f17555c.setData(list);
        }
    }

    public void e(c.a.p0.n.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            for (c.a.e.l.e.a aVar : this.f17554b) {
                if (aVar instanceof a) {
                    ((a) aVar).j0(fVar);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (c.a.e.l.e.a aVar : this.f17554b) {
                aVar.f0(bdUniqueId);
            }
        }
    }
}
