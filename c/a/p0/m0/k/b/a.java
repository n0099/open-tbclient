package c.a.p0.m0.k.b;

import android.view.View;
import c.a.e.k.e.n;
import c.a.e.k.e.s;
import c.a.p0.a0.b0;
import c.a.p0.m0.k.c.e;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f21746a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.e.k.e.a> f21747b;

    /* renamed from: c  reason: collision with root package name */
    public s f21748c;

    /* renamed from: d  reason: collision with root package name */
    public b f21749d;

    /* renamed from: e  reason: collision with root package name */
    public c f21750e;

    /* renamed from: f  reason: collision with root package name */
    public d f21751f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f21752g;

    /* renamed from: h  reason: collision with root package name */
    public b0<BaseCardInfo> f21753h;

    /* renamed from: c.a.p0.m0.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1014a extends b0<BaseCardInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f21754b;

        public C1014a(a aVar) {
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
            this.f21754b = aVar;
        }

        @Override // c.a.p0.a0.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) && baseCardInfo != null && (baseCardInfo instanceof c.a.p0.m0.k.c.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((c.a.p0.m0.k.c.d) baseCardInfo).getTitle();
                for (n nVar : this.f21754b.f21752g) {
                    if (nVar instanceof c.a.p0.m0.k.c.d) {
                        c.a.p0.m0.k.c.d dVar = (c.a.p0.m0.k.c.d) nVar;
                        if (title.equals(dVar.getTitle())) {
                            List<c.a.p0.m0.k.c.c> q = dVar.q();
                            arrayList.add(nVar);
                            arrayList.addAll(q);
                        } else {
                            List<c.a.p0.m0.k.c.c> p = dVar.p();
                            arrayList.add(nVar);
                            arrayList.addAll(p);
                        }
                    }
                }
                e eVar = new e();
                eVar.f21778e = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    this.f21754b.f21748c.setData(arrayList);
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
        this.f21753h = new C1014a(this);
        this.f21746a = tbPageContext;
        this.f21748c = sVar;
        c();
        this.f21748c.addAdapters(this.f21747b);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f21747b = new ArrayList();
            b bVar = new b(this.f21746a);
            this.f21749d = bVar;
            this.f21747b.add(bVar);
            c cVar = new c(this.f21746a, this.f21753h);
            this.f21750e = cVar;
            this.f21747b.add(cVar);
            d dVar = new d(this.f21746a);
            this.f21751f = dVar;
            this.f21747b.add(dVar);
        }
    }

    public void d() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f21748c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void e(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f21752g = list;
            this.f21748c.setData(list);
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            for (c.a.e.k.e.a aVar : this.f21747b) {
                aVar.f0(bdUniqueId);
            }
        }
    }
}
