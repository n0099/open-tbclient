package b.a.r0.o0.k.b;

import android.view.View;
import b.a.e.l.e.n;
import b.a.e.l.e.s;
import b.a.r0.b0.c0;
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
    public TbPageContext f21715a;

    /* renamed from: b  reason: collision with root package name */
    public List<b.a.e.l.e.a> f21716b;

    /* renamed from: c  reason: collision with root package name */
    public s f21717c;

    /* renamed from: d  reason: collision with root package name */
    public b f21718d;

    /* renamed from: e  reason: collision with root package name */
    public c f21719e;

    /* renamed from: f  reason: collision with root package name */
    public d f21720f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f21721g;

    /* renamed from: h  reason: collision with root package name */
    public c0<BaseCardInfo> f21722h;

    /* renamed from: b.a.r0.o0.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1063a extends c0<BaseCardInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f21723b;

        public C1063a(a aVar) {
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
            this.f21723b = aVar;
        }

        @Override // b.a.r0.b0.c0
        public void a(View view, BaseCardInfo baseCardInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) && baseCardInfo != null && (baseCardInfo instanceof b.a.r0.o0.k.c.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((b.a.r0.o0.k.c.d) baseCardInfo).getTitle();
                for (n nVar : this.f21723b.f21721g) {
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
                eVar.f21746e = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    this.f21723b.f21717c.setData(arrayList);
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
        this.f21722h = new C1063a(this);
        this.f21715a = tbPageContext;
        this.f21717c = sVar;
        c();
        this.f21717c.addAdapters(this.f21716b);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f21716b = new ArrayList();
            b bVar = new b(this.f21715a);
            this.f21718d = bVar;
            this.f21716b.add(bVar);
            c cVar = new c(this.f21715a, this.f21722h);
            this.f21719e = cVar;
            this.f21716b.add(cVar);
            d dVar = new d(this.f21715a);
            this.f21720f = dVar;
            this.f21716b.add(dVar);
        }
    }

    public void d() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f21717c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void e(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f21721g = list;
            this.f21717c.setData(list);
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            for (b.a.e.l.e.a aVar : this.f21716b) {
                aVar.e0(bdUniqueId);
            }
        }
    }
}
