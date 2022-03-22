package c.a.p0.q1.h.d;

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
    public List<c.a.d.o.e.a> f17336b;

    /* renamed from: c  reason: collision with root package name */
    public s f17337c;

    /* renamed from: d  reason: collision with root package name */
    public c f17338d;

    /* renamed from: e  reason: collision with root package name */
    public h f17339e;

    /* renamed from: f  reason: collision with root package name */
    public b f17340f;

    /* renamed from: g  reason: collision with root package name */
    public f f17341g;

    /* renamed from: h  reason: collision with root package name */
    public e f17342h;
    public g i;
    public i j;

    public d(TbPageContext tbPageContext, s sVar) {
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
        this.a = tbPageContext;
        this.f17337c = sVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f17336b = new ArrayList();
            c cVar = new c(this.a);
            this.f17338d = cVar;
            cVar.c0(this.f17337c);
            this.f17336b.add(this.f17338d);
            h hVar = new h(this.a);
            this.f17339e = hVar;
            hVar.c0(this.f17337c);
            this.f17336b.add(this.f17339e);
            b bVar = new b(this.a);
            this.f17340f = bVar;
            bVar.c0(this.f17337c);
            this.f17336b.add(this.f17340f);
            f fVar = new f(this.a);
            this.f17341g = fVar;
            fVar.c0(this.f17337c);
            this.f17336b.add(this.f17341g);
            e eVar = new e(this.a);
            this.f17342h = eVar;
            eVar.c0(this.f17337c);
            this.f17336b.add(this.f17342h);
            g gVar = new g(this.a);
            this.i = gVar;
            gVar.c0(this.f17337c);
            this.f17336b.add(this.i);
            i iVar = new i(this.a);
            this.j = iVar;
            iVar.c0(this.f17337c);
            this.f17336b.add(this.j);
            this.f17337c.a(this.f17336b);
        }
    }

    public void b() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f17337c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (sVar = this.f17337c) == null) {
            return;
        }
        sVar.setData(list);
        b();
    }

    public void d(c.a.o0.m.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            for (c.a.d.o.e.a aVar : this.f17336b) {
                if (aVar instanceof a) {
                    ((a) aVar).b0(fVar);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (c.a.d.o.e.a aVar : this.f17336b) {
                aVar.X(bdUniqueId);
            }
        }
    }
}
