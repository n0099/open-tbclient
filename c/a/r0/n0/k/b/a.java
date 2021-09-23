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
    public TbPageContext f22660a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.e.l.e.a> f22661b;

    /* renamed from: c  reason: collision with root package name */
    public s f22662c;

    /* renamed from: d  reason: collision with root package name */
    public b f22663d;

    /* renamed from: e  reason: collision with root package name */
    public c f22664e;

    /* renamed from: f  reason: collision with root package name */
    public d f22665f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f22666g;

    /* renamed from: h  reason: collision with root package name */
    public b0<BaseCardInfo> f22667h;

    /* renamed from: c.a.r0.n0.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1056a extends b0<BaseCardInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f22668b;

        public C1056a(a aVar) {
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
            this.f22668b = aVar;
        }

        @Override // c.a.r0.a0.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) && baseCardInfo != null && (baseCardInfo instanceof c.a.r0.n0.k.c.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((c.a.r0.n0.k.c.d) baseCardInfo).getTitle();
                for (n nVar : this.f22668b.f22666g) {
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
                eVar.f22692e = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    this.f22668b.f22662c.setData(arrayList);
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
        this.f22667h = new C1056a(this);
        this.f22660a = tbPageContext;
        this.f22662c = sVar;
        c();
        this.f22662c.addAdapters(this.f22661b);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f22661b = new ArrayList();
            b bVar = new b(this.f22660a);
            this.f22663d = bVar;
            this.f22661b.add(bVar);
            c cVar = new c(this.f22660a, this.f22667h);
            this.f22664e = cVar;
            this.f22661b.add(cVar);
            d dVar = new d(this.f22660a);
            this.f22665f = dVar;
            this.f22661b.add(dVar);
        }
    }

    public void d() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f22662c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void e(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f22666g = list;
            this.f22662c.setData(list);
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            for (c.a.e.l.e.a aVar : this.f22661b) {
                aVar.f0(bdUniqueId);
            }
        }
    }
}
