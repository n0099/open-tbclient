package b.a.r0.h1.f.a.d;

import b.a.e.l.e.n;
import b.a.e.l.e.s;
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
    public TbPageContext f17195a;

    /* renamed from: b  reason: collision with root package name */
    public List<b.a.e.l.e.a> f17196b;

    /* renamed from: c  reason: collision with root package name */
    public s f17197c;

    /* renamed from: d  reason: collision with root package name */
    public g f17198d;

    /* renamed from: e  reason: collision with root package name */
    public k f17199e;

    /* renamed from: f  reason: collision with root package name */
    public b f17200f;

    /* renamed from: g  reason: collision with root package name */
    public d f17201g;

    /* renamed from: h  reason: collision with root package name */
    public c f17202h;

    /* renamed from: i  reason: collision with root package name */
    public e f17203i;
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
        this.f17195a = tbPageContext;
        this.f17197c = sVar;
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f17197c.getData() : (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.f17196b = arrayList;
            arrayList.add(new j(this.f17195a));
            this.f17196b.add(new i(this.f17195a));
            this.f17196b.add(new LoadingViewAdapter(this.f17195a));
            g gVar = new g(this.f17195a);
            this.f17198d = gVar;
            gVar.j0(this.f17197c);
            this.f17196b.add(this.f17198d);
            k kVar = new k(this.f17195a);
            this.f17199e = kVar;
            kVar.j0(this.f17197c);
            this.f17196b.add(this.f17199e);
            b bVar = new b(this.f17195a);
            this.f17200f = bVar;
            bVar.j0(this.f17197c);
            this.f17196b.add(this.f17200f);
            d dVar = new d(this.f17195a);
            this.f17201g = dVar;
            dVar.j0(this.f17197c);
            this.f17196b.add(this.f17201g);
            c cVar = new c(this.f17195a);
            this.f17202h = cVar;
            cVar.j0(this.f17197c);
            this.f17196b.add(this.f17202h);
            e eVar = new e(this.f17195a);
            this.f17203i = eVar;
            eVar.j0(this.f17197c);
            this.f17196b.add(this.f17203i);
            f fVar = new f(this.f17195a);
            this.j = fVar;
            fVar.j0(this.f17197c);
            this.f17196b.add(this.j);
            this.f17197c.addAdapters(this.f17196b);
        }
    }

    public void c() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (sVar = this.f17197c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f17197c.setData(list);
        }
    }

    public void e(b.a.q0.n.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            for (b.a.e.l.e.a aVar : this.f17196b) {
                if (aVar instanceof a) {
                    ((a) aVar).i0(fVar);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (b.a.e.l.e.a aVar : this.f17196b) {
                aVar.e0(bdUniqueId);
            }
        }
    }
}
