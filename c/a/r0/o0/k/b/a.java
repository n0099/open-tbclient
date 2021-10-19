package c.a.r0.o0.k.b;

import android.view.View;
import c.a.e.l.e.n;
import c.a.e.l.e.s;
import c.a.r0.b0.c0;
import c.a.r0.o0.k.c.e;
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
    public TbPageContext f22844a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.e.l.e.a> f22845b;

    /* renamed from: c  reason: collision with root package name */
    public s f22846c;

    /* renamed from: d  reason: collision with root package name */
    public b f22847d;

    /* renamed from: e  reason: collision with root package name */
    public c f22848e;

    /* renamed from: f  reason: collision with root package name */
    public d f22849f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f22850g;

    /* renamed from: h  reason: collision with root package name */
    public c0<BaseCardInfo> f22851h;

    /* renamed from: c.a.r0.o0.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1066a extends c0<BaseCardInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f22852b;

        public C1066a(a aVar) {
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
            this.f22852b = aVar;
        }

        @Override // c.a.r0.b0.c0
        public void a(View view, BaseCardInfo baseCardInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) && baseCardInfo != null && (baseCardInfo instanceof c.a.r0.o0.k.c.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((c.a.r0.o0.k.c.d) baseCardInfo).getTitle();
                for (n nVar : this.f22852b.f22850g) {
                    if (nVar instanceof c.a.r0.o0.k.c.d) {
                        c.a.r0.o0.k.c.d dVar = (c.a.r0.o0.k.c.d) nVar;
                        if (title.equals(dVar.getTitle())) {
                            List<c.a.r0.o0.k.c.c> q = dVar.q();
                            arrayList.add(nVar);
                            arrayList.addAll(q);
                        } else {
                            List<c.a.r0.o0.k.c.c> p = dVar.p();
                            arrayList.add(nVar);
                            arrayList.addAll(p);
                        }
                    }
                }
                e eVar = new e();
                eVar.f22876e = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    this.f22852b.f22846c.setData(arrayList);
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
        this.f22851h = new C1066a(this);
        this.f22844a = tbPageContext;
        this.f22846c = sVar;
        c();
        this.f22846c.addAdapters(this.f22845b);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f22845b = new ArrayList();
            b bVar = new b(this.f22844a);
            this.f22847d = bVar;
            this.f22845b.add(bVar);
            c cVar = new c(this.f22844a, this.f22851h);
            this.f22848e = cVar;
            this.f22845b.add(cVar);
            d dVar = new d(this.f22844a);
            this.f22849f = dVar;
            this.f22845b.add(dVar);
        }
    }

    public void d() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f22846c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void e(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f22850g = list;
            this.f22846c.setData(list);
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            for (c.a.e.l.e.a aVar : this.f22845b) {
                aVar.f0(bdUniqueId);
            }
        }
    }
}
