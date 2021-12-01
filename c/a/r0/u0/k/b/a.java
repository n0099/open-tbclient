package c.a.r0.u0.k.b;

import android.view.View;
import c.a.d.m.e.n;
import c.a.d.m.e.s;
import c.a.r0.g0.d0;
import c.a.r0.u0.k.c.e;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.d.m.e.a> f24230b;

    /* renamed from: c  reason: collision with root package name */
    public s f24231c;

    /* renamed from: d  reason: collision with root package name */
    public b f24232d;

    /* renamed from: e  reason: collision with root package name */
    public c f24233e;

    /* renamed from: f  reason: collision with root package name */
    public d f24234f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f24235g;

    /* renamed from: h  reason: collision with root package name */
    public d0<BaseCardInfo> f24236h;

    /* renamed from: c.a.r0.u0.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1383a extends d0<BaseCardInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f24237b;

        public C1383a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24237b = aVar;
        }

        @Override // c.a.r0.g0.d0
        public void a(View view, BaseCardInfo baseCardInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) && baseCardInfo != null && (baseCardInfo instanceof c.a.r0.u0.k.c.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((c.a.r0.u0.k.c.d) baseCardInfo).getTitle();
                for (n nVar : this.f24237b.f24235g) {
                    if (nVar instanceof c.a.r0.u0.k.c.d) {
                        c.a.r0.u0.k.c.d dVar = (c.a.r0.u0.k.c.d) nVar;
                        if (title.equals(dVar.getTitle())) {
                            List<c.a.r0.u0.k.c.c> q = dVar.q();
                            arrayList.add(nVar);
                            arrayList.addAll(q);
                        } else {
                            List<c.a.r0.u0.k.c.c> p = dVar.p();
                            arrayList.add(nVar);
                            arrayList.addAll(p);
                        }
                    }
                }
                e eVar = new e();
                eVar.f24259e = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    this.f24237b.f24231c.setData(arrayList);
                }
            }
        }
    }

    public a(TbPageContext tbPageContext, s sVar) {
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
        this.f24236h = new C1383a(this);
        this.a = tbPageContext;
        this.f24231c = sVar;
        c();
        this.f24231c.addAdapters(this.f24230b);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f24230b = new ArrayList();
            b bVar = new b(this.a);
            this.f24232d = bVar;
            this.f24230b.add(bVar);
            c cVar = new c(this.a, this.f24236h);
            this.f24233e = cVar;
            this.f24230b.add(cVar);
            d dVar = new d(this.a);
            this.f24234f = dVar;
            this.f24230b.add(dVar);
        }
    }

    public void d() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f24231c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void e(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f24235g = list;
            this.f24231c.setData(list);
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            for (c.a.d.m.e.a aVar : this.f24230b) {
                aVar.e0(bdUniqueId);
            }
        }
    }
}
