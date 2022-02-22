package c.a.u0.v0.k.b;

import android.view.View;
import c.a.d.o.e.n;
import c.a.d.o.e.s;
import c.a.u0.g0.b0;
import c.a.u0.v0.k.c.e;
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
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.d.o.e.a> f24547b;

    /* renamed from: c  reason: collision with root package name */
    public s f24548c;

    /* renamed from: d  reason: collision with root package name */
    public b f24549d;

    /* renamed from: e  reason: collision with root package name */
    public c f24550e;

    /* renamed from: f  reason: collision with root package name */
    public d f24551f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f24552g;

    /* renamed from: h  reason: collision with root package name */
    public b0<BaseCardInfo> f24553h;

    /* renamed from: c.a.u0.v0.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1489a extends b0<BaseCardInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f24554b;

        public C1489a(a aVar) {
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
            this.f24554b = aVar;
        }

        @Override // c.a.u0.g0.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) && baseCardInfo != null && (baseCardInfo instanceof c.a.u0.v0.k.c.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((c.a.u0.v0.k.c.d) baseCardInfo).getTitle();
                for (n nVar : this.f24554b.f24552g) {
                    if (nVar instanceof c.a.u0.v0.k.c.d) {
                        c.a.u0.v0.k.c.d dVar = (c.a.u0.v0.k.c.d) nVar;
                        if (title.equals(dVar.getTitle())) {
                            List<c.a.u0.v0.k.c.c> q = dVar.q();
                            arrayList.add(nVar);
                            arrayList.addAll(q);
                        } else {
                            List<c.a.u0.v0.k.c.c> p = dVar.p();
                            arrayList.add(nVar);
                            arrayList.addAll(p);
                        }
                    }
                }
                e eVar = new e();
                eVar.f24576e = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    this.f24554b.f24548c.setData(arrayList);
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
        this.f24553h = new C1489a(this);
        this.a = tbPageContext;
        this.f24548c = sVar;
        c();
        this.f24548c.addAdapters(this.f24547b);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f24547b = new ArrayList();
            b bVar = new b(this.a);
            this.f24549d = bVar;
            this.f24547b.add(bVar);
            c cVar = new c(this.a, this.f24553h);
            this.f24550e = cVar;
            this.f24547b.add(cVar);
            d dVar = new d(this.a);
            this.f24551f = dVar;
            this.f24547b.add(dVar);
        }
    }

    public void d() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f24548c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void e(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f24552g = list;
            this.f24548c.setData(list);
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            for (c.a.d.o.e.a aVar : this.f24547b) {
                aVar.X(bdUniqueId);
            }
        }
    }
}
