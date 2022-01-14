package c.a.t0.u0.k.b;

import android.view.View;
import c.a.d.n.e.n;
import c.a.d.n.e.s;
import c.a.t0.g0.d0;
import c.a.t0.u0.k.c.e;
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
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.d.n.e.a> f24076b;

    /* renamed from: c  reason: collision with root package name */
    public s f24077c;

    /* renamed from: d  reason: collision with root package name */
    public b f24078d;

    /* renamed from: e  reason: collision with root package name */
    public c f24079e;

    /* renamed from: f  reason: collision with root package name */
    public d f24080f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f24081g;

    /* renamed from: h  reason: collision with root package name */
    public d0<BaseCardInfo> f24082h;

    /* renamed from: c.a.t0.u0.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1463a extends d0<BaseCardInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f24083b;

        public C1463a(a aVar) {
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
            this.f24083b = aVar;
        }

        @Override // c.a.t0.g0.d0
        public void a(View view, BaseCardInfo baseCardInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) && baseCardInfo != null && (baseCardInfo instanceof c.a.t0.u0.k.c.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((c.a.t0.u0.k.c.d) baseCardInfo).getTitle();
                for (n nVar : this.f24083b.f24081g) {
                    if (nVar instanceof c.a.t0.u0.k.c.d) {
                        c.a.t0.u0.k.c.d dVar = (c.a.t0.u0.k.c.d) nVar;
                        if (title.equals(dVar.getTitle())) {
                            List<c.a.t0.u0.k.c.c> q = dVar.q();
                            arrayList.add(nVar);
                            arrayList.addAll(q);
                        } else {
                            List<c.a.t0.u0.k.c.c> p = dVar.p();
                            arrayList.add(nVar);
                            arrayList.addAll(p);
                        }
                    }
                }
                e eVar = new e();
                eVar.f24105e = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    this.f24083b.f24077c.setData(arrayList);
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
        this.f24082h = new C1463a(this);
        this.a = tbPageContext;
        this.f24077c = sVar;
        c();
        this.f24077c.addAdapters(this.f24076b);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f24076b = new ArrayList();
            b bVar = new b(this.a);
            this.f24078d = bVar;
            this.f24076b.add(bVar);
            c cVar = new c(this.a, this.f24082h);
            this.f24079e = cVar;
            this.f24076b.add(cVar);
            d dVar = new d(this.a);
            this.f24080f = dVar;
            this.f24076b.add(dVar);
        }
    }

    public void d() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f24077c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void e(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f24081g = list;
            this.f24077c.setData(list);
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            for (c.a.d.n.e.a aVar : this.f24076b) {
                aVar.X(bdUniqueId);
            }
        }
    }
}
