package b.a.r0.o0.k.b;

import android.view.View;
import b.a.e.m.e.n;
import b.a.e.m.e.s;
import b.a.r0.b0.d0;
import b.a.r0.o0.k.c.e;
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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f23214a;

    /* renamed from: b  reason: collision with root package name */
    public List<b.a.e.m.e.a> f23215b;

    /* renamed from: c  reason: collision with root package name */
    public s f23216c;

    /* renamed from: d  reason: collision with root package name */
    public b f23217d;

    /* renamed from: e  reason: collision with root package name */
    public c f23218e;

    /* renamed from: f  reason: collision with root package name */
    public d f23219f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f23220g;

    /* renamed from: h  reason: collision with root package name */
    public d0<BaseCardInfo> f23221h;

    /* renamed from: b.a.r0.o0.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1131a extends d0<BaseCardInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f23222b;

        public C1131a(a aVar) {
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
            this.f23222b = aVar;
        }

        @Override // b.a.r0.b0.d0
        public void a(View view, BaseCardInfo baseCardInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) && baseCardInfo != null && (baseCardInfo instanceof b.a.r0.o0.k.c.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((b.a.r0.o0.k.c.d) baseCardInfo).getTitle();
                for (n nVar : this.f23222b.f23220g) {
                    if (nVar instanceof b.a.r0.o0.k.c.d) {
                        b.a.r0.o0.k.c.d dVar = (b.a.r0.o0.k.c.d) nVar;
                        if (title.equals(dVar.getTitle())) {
                            List<b.a.r0.o0.k.c.c> q = dVar.q();
                            arrayList.add(nVar);
                            arrayList.addAll(q);
                        } else {
                            List<b.a.r0.o0.k.c.c> p = dVar.p();
                            arrayList.add(nVar);
                            arrayList.addAll(p);
                        }
                    }
                }
                e eVar = new e();
                eVar.f23245e = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    this.f23222b.f23216c.setData(arrayList);
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
        this.f23221h = new C1131a(this);
        this.f23214a = tbPageContext;
        this.f23216c = sVar;
        c();
        this.f23216c.addAdapters(this.f23215b);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f23215b = new ArrayList();
            b bVar = new b(this.f23214a);
            this.f23217d = bVar;
            this.f23215b.add(bVar);
            c cVar = new c(this.f23214a, this.f23221h);
            this.f23218e = cVar;
            this.f23215b.add(cVar);
            d dVar = new d(this.f23214a);
            this.f23219f = dVar;
            this.f23215b.add(dVar);
        }
    }

    public void d() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f23216c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void e(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f23220g = list;
            this.f23216c.setData(list);
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            for (b.a.e.m.e.a aVar : this.f23215b) {
                aVar.e0(bdUniqueId);
            }
        }
    }
}
