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
    public TbPageContext f18087a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.e.l.e.a> f18088b;

    /* renamed from: c  reason: collision with root package name */
    public s f18089c;

    /* renamed from: d  reason: collision with root package name */
    public g f18090d;

    /* renamed from: e  reason: collision with root package name */
    public k f18091e;

    /* renamed from: f  reason: collision with root package name */
    public b f18092f;

    /* renamed from: g  reason: collision with root package name */
    public d f18093g;

    /* renamed from: h  reason: collision with root package name */
    public c f18094h;

    /* renamed from: i  reason: collision with root package name */
    public e f18095i;

    /* renamed from: j  reason: collision with root package name */
    public f f18096j;

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
        this.f18087a = tbPageContext;
        this.f18089c = sVar;
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18089c.getData() : (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.f18088b = arrayList;
            arrayList.add(new j(this.f18087a));
            this.f18088b.add(new i(this.f18087a));
            this.f18088b.add(new LoadingViewAdapter(this.f18087a));
            g gVar = new g(this.f18087a);
            this.f18090d = gVar;
            gVar.k0(this.f18089c);
            this.f18088b.add(this.f18090d);
            k kVar = new k(this.f18087a);
            this.f18091e = kVar;
            kVar.k0(this.f18089c);
            this.f18088b.add(this.f18091e);
            b bVar = new b(this.f18087a);
            this.f18092f = bVar;
            bVar.k0(this.f18089c);
            this.f18088b.add(this.f18092f);
            d dVar = new d(this.f18087a);
            this.f18093g = dVar;
            dVar.k0(this.f18089c);
            this.f18088b.add(this.f18093g);
            c cVar = new c(this.f18087a);
            this.f18094h = cVar;
            cVar.k0(this.f18089c);
            this.f18088b.add(this.f18094h);
            e eVar = new e(this.f18087a);
            this.f18095i = eVar;
            eVar.k0(this.f18089c);
            this.f18088b.add(this.f18095i);
            f fVar = new f(this.f18087a);
            this.f18096j = fVar;
            fVar.k0(this.f18089c);
            this.f18088b.add(this.f18096j);
            this.f18089c.addAdapters(this.f18088b);
        }
    }

    public void c() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (sVar = this.f18089c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f18089c.setData(list);
        }
    }

    public void e(c.a.q0.n.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            for (c.a.e.l.e.a aVar : this.f18088b) {
                if (aVar instanceof a) {
                    ((a) aVar).j0(fVar);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (c.a.e.l.e.a aVar : this.f18088b) {
                aVar.f0(bdUniqueId);
            }
        }
    }
}
