package c.a.s0.o1.f.a.d;

import c.a.d.m.e.n;
import c.a.d.m.e.s;
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
    public List<c.a.d.m.e.a> f20869b;

    /* renamed from: c  reason: collision with root package name */
    public s f20870c;

    /* renamed from: d  reason: collision with root package name */
    public g f20871d;

    /* renamed from: e  reason: collision with root package name */
    public k f20872e;

    /* renamed from: f  reason: collision with root package name */
    public b f20873f;

    /* renamed from: g  reason: collision with root package name */
    public d f20874g;

    /* renamed from: h  reason: collision with root package name */
    public c f20875h;

    /* renamed from: i  reason: collision with root package name */
    public e f20876i;

    /* renamed from: j  reason: collision with root package name */
    public f f20877j;

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
        this.f20870c = sVar;
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20870c.getData() : (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.f20869b = arrayList;
            arrayList.add(new j(this.a));
            this.f20869b.add(new i(this.a));
            this.f20869b.add(new LoadingViewAdapter(this.a));
            g gVar = new g(this.a);
            this.f20871d = gVar;
            gVar.j0(this.f20870c);
            this.f20869b.add(this.f20871d);
            k kVar = new k(this.a);
            this.f20872e = kVar;
            kVar.j0(this.f20870c);
            this.f20869b.add(this.f20872e);
            b bVar = new b(this.a);
            this.f20873f = bVar;
            bVar.j0(this.f20870c);
            this.f20869b.add(this.f20873f);
            d dVar = new d(this.a);
            this.f20874g = dVar;
            dVar.j0(this.f20870c);
            this.f20869b.add(this.f20874g);
            c cVar = new c(this.a);
            this.f20875h = cVar;
            cVar.j0(this.f20870c);
            this.f20869b.add(this.f20875h);
            e eVar = new e(this.a);
            this.f20876i = eVar;
            eVar.j0(this.f20870c);
            this.f20869b.add(this.f20876i);
            f fVar = new f(this.a);
            this.f20877j = fVar;
            fVar.j0(this.f20870c);
            this.f20869b.add(this.f20877j);
            this.f20870c.addAdapters(this.f20869b);
        }
    }

    public void c() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (sVar = this.f20870c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f20870c.setData(list);
        }
    }

    public void e(c.a.r0.n.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            for (c.a.d.m.e.a aVar : this.f20869b) {
                if (aVar instanceof a) {
                    ((a) aVar).i0(fVar);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (c.a.d.m.e.a aVar : this.f20869b) {
                aVar.e0(bdUniqueId);
            }
        }
    }
}
