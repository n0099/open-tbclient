package c.a.r0.n1.f.a.d;

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
/* loaded from: classes6.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.d.m.e.a> f20347b;

    /* renamed from: c  reason: collision with root package name */
    public s f20348c;

    /* renamed from: d  reason: collision with root package name */
    public g f20349d;

    /* renamed from: e  reason: collision with root package name */
    public k f20350e;

    /* renamed from: f  reason: collision with root package name */
    public b f20351f;

    /* renamed from: g  reason: collision with root package name */
    public d f20352g;

    /* renamed from: h  reason: collision with root package name */
    public c f20353h;

    /* renamed from: i  reason: collision with root package name */
    public e f20354i;

    /* renamed from: j  reason: collision with root package name */
    public f f20355j;

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
        this.f20348c = sVar;
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20348c.getData() : (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.f20347b = arrayList;
            arrayList.add(new j(this.a));
            this.f20347b.add(new i(this.a));
            this.f20347b.add(new LoadingViewAdapter(this.a));
            g gVar = new g(this.a);
            this.f20349d = gVar;
            gVar.j0(this.f20348c);
            this.f20347b.add(this.f20349d);
            k kVar = new k(this.a);
            this.f20350e = kVar;
            kVar.j0(this.f20348c);
            this.f20347b.add(this.f20350e);
            b bVar = new b(this.a);
            this.f20351f = bVar;
            bVar.j0(this.f20348c);
            this.f20347b.add(this.f20351f);
            d dVar = new d(this.a);
            this.f20352g = dVar;
            dVar.j0(this.f20348c);
            this.f20347b.add(this.f20352g);
            c cVar = new c(this.a);
            this.f20353h = cVar;
            cVar.j0(this.f20348c);
            this.f20347b.add(this.f20353h);
            e eVar = new e(this.a);
            this.f20354i = eVar;
            eVar.j0(this.f20348c);
            this.f20347b.add(this.f20354i);
            f fVar = new f(this.a);
            this.f20355j = fVar;
            fVar.j0(this.f20348c);
            this.f20347b.add(this.f20355j);
            this.f20348c.addAdapters(this.f20347b);
        }
    }

    public void c() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (sVar = this.f20348c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f20348c.setData(list);
        }
    }

    public void e(c.a.q0.n.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            for (c.a.d.m.e.a aVar : this.f20347b) {
                if (aVar instanceof a) {
                    ((a) aVar).i0(fVar);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (c.a.d.m.e.a aVar : this.f20347b) {
                aVar.e0(bdUniqueId);
            }
        }
    }
}
