package c.a.r0.o1.h.d;

import c.a.d.o.e.n;
import c.a.d.o.e.s;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.d.o.e.a> f19932b;

    /* renamed from: c  reason: collision with root package name */
    public s f19933c;

    /* renamed from: d  reason: collision with root package name */
    public c f19934d;

    /* renamed from: e  reason: collision with root package name */
    public h f19935e;

    /* renamed from: f  reason: collision with root package name */
    public b f19936f;

    /* renamed from: g  reason: collision with root package name */
    public f f19937g;

    /* renamed from: h  reason: collision with root package name */
    public e f19938h;

    /* renamed from: i  reason: collision with root package name */
    public g f19939i;

    /* renamed from: j  reason: collision with root package name */
    public i f19940j;

    public d(TbPageContext tbPageContext, s sVar) {
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
        this.a = tbPageContext;
        this.f19933c = sVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f19932b = new ArrayList();
            c cVar = new c(this.a);
            this.f19934d = cVar;
            cVar.c0(this.f19933c);
            this.f19932b.add(this.f19934d);
            h hVar = new h(this.a);
            this.f19935e = hVar;
            hVar.c0(this.f19933c);
            this.f19932b.add(this.f19935e);
            b bVar = new b(this.a);
            this.f19936f = bVar;
            bVar.c0(this.f19933c);
            this.f19932b.add(this.f19936f);
            f fVar = new f(this.a);
            this.f19937g = fVar;
            fVar.c0(this.f19933c);
            this.f19932b.add(this.f19937g);
            e eVar = new e(this.a);
            this.f19938h = eVar;
            eVar.c0(this.f19933c);
            this.f19932b.add(this.f19938h);
            g gVar = new g(this.a);
            this.f19939i = gVar;
            gVar.c0(this.f19933c);
            this.f19932b.add(this.f19939i);
            i iVar = new i(this.a);
            this.f19940j = iVar;
            iVar.c0(this.f19933c);
            this.f19932b.add(this.f19940j);
            this.f19933c.addAdapters(this.f19932b);
        }
    }

    public void b() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f19933c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (sVar = this.f19933c) == null) {
            return;
        }
        sVar.setData(list);
        b();
    }

    public void d(c.a.q0.m.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            for (c.a.d.o.e.a aVar : this.f19932b) {
                if (aVar instanceof a) {
                    ((a) aVar).b0(fVar);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (c.a.d.o.e.a aVar : this.f19932b) {
                aVar.X(bdUniqueId);
            }
        }
    }
}
