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
/* loaded from: classes9.dex */
public class d extends c.b.b.j.f.b<c, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public c.b.b.q.a<w.b<String, e<c>>> f27294b;

    /* loaded from: classes9.dex */
    public static class a extends c.b.b.j.c<c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public c.b.b.q.a<c.b.b.n.l.h.f.a<?>> f27295b;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.b.b.j.f.e) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27294b = new c.b.b.q.a<>();
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
            synchronized (this.f27294b) {
                w.b<String, e<c>> bVar = new w.b<>();
                bVar.a = str;
                bVar.f27552b = r0;
                this.f27294b.a(bVar);
                b2 = r0.b();
            }
            c.b.b.q.a<c.b.b.j.a> aVar3 = new c.b.b.q.a<>();
            a.b<e.a> it = b2.iterator();
            while (it.hasNext()) {
                e.a next = it.next();
                if (!b(next.f27300e).c()) {
                    next.f27300e = aVar.i().a(f.f26966d.a(next.f27300e).g()).j();
                }
                Class<T> cls = next.f27301f;
                if (cls == c.class) {
                    aVar3.a(new c.b.b.j.a(next.f27300e, cls, aVar2));
                } else {
                    aVar3.a(new c.b.b.j.a(next.f27300e, cls));
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
            synchronized (this.f27294b) {
                int i2 = 0;
                while (true) {
                    if (i2 >= this.f27294b.f27389f) {
                        eVar2 = null;
                        break;
                    }
                    w.b<String, e<c>> bVar = this.f27294b.get(i2);
                    if (bVar.a.equals(str)) {
                        eVar2 = bVar.f27552b;
                        this.f27294b.h(i2);
                        break;
                    }
                    i2++;
                }
            }
            eVar2.f27299h.a(eVar, eVar2);
            if (aVar2 != null) {
                c.b.b.q.a<c.b.b.n.l.h.f.a<?>> aVar3 = aVar2.f27295b;
                if (aVar3 != null) {
                    a.b<c.b.b.n.l.h.f.a<?>> it = aVar3.iterator();
                    while (it.hasNext()) {
                        it.next().b(eVar, eVar2);
                    }
                }
                eVar2.f27299h.f(aVar2.f27295b);
            }
            return eVar2.f27299h;
        }
        return (c) invokeLLLL.objValue;
    }
}
