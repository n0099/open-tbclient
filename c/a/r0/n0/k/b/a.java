package c.a.r0.n0.k.b;

import android.view.View;
import c.a.e.l.e.n;
import c.a.e.l.e.s;
import c.a.r0.a0.b0;
import c.a.r0.n0.k.c.e;
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
    public TbPageContext f22644a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.e.l.e.a> f22645b;

    /* renamed from: c  reason: collision with root package name */
    public s f22646c;

    /* renamed from: d  reason: collision with root package name */
    public b f22647d;

    /* renamed from: e  reason: collision with root package name */
    public c f22648e;

    /* renamed from: f  reason: collision with root package name */
    public d f22649f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f22650g;

    /* renamed from: h  reason: collision with root package name */
    public b0<BaseCardInfo> f22651h;

    /* renamed from: c.a.r0.n0.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1058a extends b0<BaseCardInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f22652b;

        public C1058a(a aVar) {
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
            this.f22652b = aVar;
        }

        @Override // c.a.r0.a0.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) && baseCardInfo != null && (baseCardInfo instanceof c.a.r0.n0.k.c.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((c.a.r0.n0.k.c.d) baseCardInfo).getTitle();
                for (n nVar : this.f22652b.f22650g) {
                    if (nVar instanceof c.a.r0.n0.k.c.d) {
                        c.a.r0.n0.k.c.d dVar = (c.a.r0.n0.k.c.d) nVar;
                        if (title.equals(dVar.getTitle())) {
                            List<c.a.r0.n0.k.c.c> q = dVar.q();
                            arrayList.add(nVar);
                            arrayList.addAll(q);
                        } else {
                            List<c.a.r0.n0.k.c.c> p = dVar.p();
                            arrayList.add(nVar);
                            arrayList.addAll(p);
                        }
                    }
                }
                e eVar = new e();
                eVar.f22676e = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    this.f22652b.f22646c.setData(arrayList);
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
        this.f22651h = new C1058a(this);
        this.f22644a = tbPageContext;
        this.f22646c = sVar;
        c();
        this.f22646c.addAdapters(this.f22645b);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f22645b = new ArrayList();
            b bVar = new b(this.f22644a);
            this.f22647d = bVar;
            this.f22645b.add(bVar);
            c cVar = new c(this.f22644a, this.f22651h);
            this.f22648e = cVar;
            this.f22645b.add(cVar);
            d dVar = new d(this.f22644a);
            this.f22649f = dVar;
            this.f22645b.add(dVar);
        }
    }

    public void d() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f22646c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void e(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f22650g = list;
            this.f22646c.setData(list);
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            for (c.a.e.l.e.a aVar : this.f22645b) {
                aVar.f0(bdUniqueId);
            }
        }
    }
}
