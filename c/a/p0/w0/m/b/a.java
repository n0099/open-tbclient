package c.a.p0.w0.m.b;

import android.view.View;
import c.a.d.o.e.n;
import c.a.d.o.e.s;
import c.a.p0.h0.b0;
import c.a.p0.w0.m.c.e;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.d.o.e.a> f19486b;

    /* renamed from: c  reason: collision with root package name */
    public s f19487c;

    /* renamed from: d  reason: collision with root package name */
    public b f19488d;

    /* renamed from: e  reason: collision with root package name */
    public c f19489e;

    /* renamed from: f  reason: collision with root package name */
    public d f19490f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f19491g;

    /* renamed from: h  reason: collision with root package name */
    public b0<BaseCardInfo> f19492h;

    /* renamed from: c.a.p0.w0.m.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1473a extends b0<BaseCardInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f19493b;

        public C1473a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19493b = aVar;
        }

        @Override // c.a.p0.h0.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) && baseCardInfo != null && (baseCardInfo instanceof c.a.p0.w0.m.c.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((c.a.p0.w0.m.c.d) baseCardInfo).getTitle();
                for (n nVar : this.f19493b.f19491g) {
                    if (nVar instanceof c.a.p0.w0.m.c.d) {
                        c.a.p0.w0.m.c.d dVar = (c.a.p0.w0.m.c.d) nVar;
                        if (title.equals(dVar.getTitle())) {
                            List<c.a.p0.w0.m.c.c> q = dVar.q();
                            arrayList.add(nVar);
                            arrayList.addAll(q);
                        } else {
                            List<c.a.p0.w0.m.c.c> m = dVar.m();
                            arrayList.add(nVar);
                            arrayList.addAll(m);
                        }
                    }
                }
                e eVar = new e();
                eVar.a = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    this.f19493b.f19487c.setData(arrayList);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19492h = new C1473a(this);
        this.a = tbPageContext;
        this.f19487c = sVar;
        c();
        this.f19487c.a(this.f19486b);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f19486b = new ArrayList();
            b bVar = new b(this.a);
            this.f19488d = bVar;
            this.f19486b.add(bVar);
            c cVar = new c(this.a, this.f19492h);
            this.f19489e = cVar;
            this.f19486b.add(cVar);
            d dVar = new d(this.a);
            this.f19490f = dVar;
            this.f19486b.add(dVar);
        }
    }

    public void d() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f19487c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void e(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f19491g = list;
            this.f19487c.setData(list);
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            for (c.a.d.o.e.a aVar : this.f19486b) {
                aVar.X(bdUniqueId);
            }
        }
    }
}
