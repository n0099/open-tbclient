package c.b.b.j.f;

import c.b.b.q.w;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class l extends b<c.b.b.p.a.a.j, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a extends c.b.b.j.c<c.b.b.p.a.a.j> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final String f27831b;

        /* renamed from: c  reason: collision with root package name */
        public final w<String, Object> f27832c;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a() {
            this(null, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr = newInitContext.callArgs;
                    this((String) objArr[0], (w) objArr[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public a(String str, w<String, Object> wVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, wVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f27831b = str;
            this.f27832c = wVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(e eVar) {
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
                super((e) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.b.b.j.f.a
    /* renamed from: f */
    public c.b.b.q.a<c.b.b.j.a> a(String str, c.b.b.m.a aVar, a aVar2) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, aVar, aVar2)) == null) {
            c.b.b.q.a<c.b.b.j.a> aVar3 = new c.b.b.q.a<>();
            if (aVar2 == null || (str2 = aVar2.f27831b) == null) {
                aVar3.a(new c.b.b.j.a(aVar.k() + ".atlas", c.b.b.n.k.h.class));
            } else if (str2 != null) {
                aVar3.a(new c.b.b.j.a(str2, c.b.b.n.k.h.class));
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
    public c.b.b.p.a.a.j d(c.b.b.j.e eVar, String str, c.b.b.m.a aVar, a aVar2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, eVar, str, aVar, aVar2)) == null) {
            String str2 = aVar.k() + ".atlas";
            w<String, Object> wVar = null;
            if (aVar2 != null) {
                String str3 = aVar2.f27831b;
                if (str3 != null) {
                    str2 = str3;
                }
                w<String, Object> wVar2 = aVar2.f27832c;
                if (wVar2 != null) {
                    wVar = wVar2;
                }
            }
            c.b.b.p.a.a.j i2 = i((c.b.b.n.k.h) eVar.j(str2, c.b.b.n.k.h.class));
            if (wVar != null) {
                w.a<String, Object> b2 = wVar.b();
                b2.d();
                while (b2.hasNext()) {
                    w.b next = b2.next();
                    i2.a((String) next.a, next.f28388b);
                }
            }
            i2.o(aVar);
            return i2;
        }
        return (c.b.b.p.a.a.j) invokeLLLL.objValue;
    }

    public c.b.b.p.a.a.j i(c.b.b.n.k.h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, hVar)) == null) ? new c.b.b.p.a.a.j(hVar) : (c.b.b.p.a.a.j) invokeL.objValue;
    }
}
