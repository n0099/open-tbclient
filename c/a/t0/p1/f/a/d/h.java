package c.a.t0.p1.f.a.d;

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
/* loaded from: classes8.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.d.n.e.a> f20671b;

    /* renamed from: c  reason: collision with root package name */
    public s f20672c;

    /* renamed from: d  reason: collision with root package name */
    public g f20673d;

    /* renamed from: e  reason: collision with root package name */
    public k f20674e;

    /* renamed from: f  reason: collision with root package name */
    public b f20675f;

    /* renamed from: g  reason: collision with root package name */
    public d f20676g;

    /* renamed from: h  reason: collision with root package name */
    public c f20677h;

    /* renamed from: i  reason: collision with root package name */
    public e f20678i;

    /* renamed from: j  reason: collision with root package name */
    public f f20679j;

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
        this.f20672c = sVar;
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20672c.getData() : (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.f20671b = arrayList;
            arrayList.add(new j(this.a));
            this.f20671b.add(new i(this.a));
            this.f20671b.add(new LoadingViewAdapter(this.a));
            g gVar = new g(this.a);
            this.f20673d = gVar;
            gVar.c0(this.f20672c);
            this.f20671b.add(this.f20673d);
            k kVar = new k(this.a);
            this.f20674e = kVar;
            kVar.c0(this.f20672c);
            this.f20671b.add(this.f20674e);
            b bVar = new b(this.a);
            this.f20675f = bVar;
            bVar.c0(this.f20672c);
            this.f20671b.add(this.f20675f);
            d dVar = new d(this.a);
            this.f20676g = dVar;
            dVar.c0(this.f20672c);
            this.f20671b.add(this.f20676g);
            c cVar = new c(this.a);
            this.f20677h = cVar;
            cVar.c0(this.f20672c);
            this.f20671b.add(this.f20677h);
            e eVar = new e(this.a);
            this.f20678i = eVar;
            eVar.c0(this.f20672c);
            this.f20671b.add(this.f20678i);
            f fVar = new f(this.a);
            this.f20679j = fVar;
            fVar.c0(this.f20672c);
            this.f20671b.add(this.f20679j);
            this.f20672c.addAdapters(this.f20671b);
        }
    }

    public void c() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (sVar = this.f20672c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f20672c.setData(list);
        }
    }

    public void e(c.a.s0.n.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            for (c.a.d.n.e.a aVar : this.f20671b) {
                if (aVar instanceof a) {
                    ((a) aVar).b0(fVar);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (c.a.d.n.e.a aVar : this.f20671b) {
                aVar.X(bdUniqueId);
            }
        }
    }
}
