package c.b.b.n.l.h;

import c.b.b.f;
import c.b.b.n.l.h.e;
import c.b.b.q.a;
import c.b.b.q.o;
import c.b.b.q.w;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d extends c.b.b.j.f.b<c, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public c.b.b.q.a<w.b<String, e<c>>> f22634b;

    /* loaded from: classes3.dex */
    public static class a extends c.b.b.j.c<c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public c.b.b.q.a<c.b.b.n.l.h.f.a<?>> f22635b;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c.b.b.j.f.e eVar) {
        super(eVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.b.b.j.f.e) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22634b = new c.b.b.q.a<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [V, c.b.b.n.l.h.e] */
    @Override // c.b.b.j.f.a
    /* renamed from: f */
    public c.b.b.q.a<c.b.b.j.a> a(String str, c.b.b.m.a aVar, a aVar2) {
        InterceptResult invokeLLL;
        c.b.b.q.a<e.a> b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, aVar, aVar2)) == null) {
            ?? r0 = (e) new o().d(e.class, aVar);
            synchronized (this.f22634b) {
                w.b<String, e<c>> bVar = new w.b<>();
                bVar.a = str;
                bVar.f22866b = r0;
                this.f22634b.a(bVar);
                b2 = r0.b();
            }
            c.b.b.q.a<c.b.b.j.a> aVar3 = new c.b.b.q.a<>();
            a.b<e.a> it = b2.iterator();
            while (it.hasNext()) {
                e.a next = it.next();
                if (!b(next.a).c()) {
                    next.a = aVar.i().a(f.f22333d.a(next.a).g()).j();
                }
                Class<T> cls = next.f22639b;
                if (cls == c.class) {
                    aVar3.a(new c.b.b.j.a(next.a, cls, aVar2));
                } else {
                    aVar3.a(new c.b.b.j.a(next.a, cls));
                }
            }
            return aVar3;
        }
        return (c.b.b.q.a) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.b.b.j.f.b
    /* renamed from: g */
    public void c(c.b.b.j.e eVar, String str, c.b.b.m.a aVar, a aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, eVar, str, aVar, aVar2) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.b.b.j.f.b
    /* renamed from: h */
    public c d(c.b.b.j.e eVar, String str, c.b.b.m.a aVar, a aVar2) {
        InterceptResult invokeLLLL;
        e<c> eVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, eVar, str, aVar, aVar2)) == null) {
            synchronized (this.f22634b) {
                int i = 0;
                while (true) {
                    if (i >= this.f22634b.f22717b) {
                        eVar2 = null;
                        break;
                    }
                    w.b<String, e<c>> bVar = this.f22634b.get(i);
                    if (bVar.a.equals(str)) {
                        eVar2 = bVar.f22866b;
                        this.f22634b.i(i);
                        break;
                    }
                    i++;
                }
            }
            eVar2.f22638d.a(eVar, eVar2);
            if (aVar2 != null) {
                c.b.b.q.a<c.b.b.n.l.h.f.a<?>> aVar3 = aVar2.f22635b;
                if (aVar3 != null) {
                    a.b<c.b.b.n.l.h.f.a<?>> it = aVar3.iterator();
                    while (it.hasNext()) {
                        it.next().b(eVar, eVar2);
                    }
                }
                eVar2.f22638d.f(aVar2.f22635b);
            }
            return eVar2.f22638d;
        }
        return (c) invokeLLLL.objValue;
    }
}
