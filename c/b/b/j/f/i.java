package c.b.b.j.f;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class i extends n<c.b.b.n.k.d, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a extends c.b.b.j.c<c.b.b.n.k.d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public String f22379b;

        /* renamed from: c  reason: collision with root package name */
        public String f22380c;

        /* renamed from: d  reason: collision with root package name */
        public c.b.b.m.a f22381d;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(e eVar) {
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
                super((e) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.b.b.j.f.a
    /* renamed from: d */
    public c.b.b.q.a<c.b.b.j.a> a(String str, c.b.b.m.a aVar, a aVar2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, aVar, aVar2)) == null) {
            if (aVar2 == null || aVar2.f22379b == null) {
                return null;
            }
            c.b.b.q.a<c.b.b.j.a> aVar3 = new c.b.b.q.a<>();
            aVar3.a(new c.b.b.j.a(aVar2.f22379b, c.b.b.n.k.h.class));
            return aVar3;
        }
        return (c.b.b.q.a) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.b.b.j.f.n
    /* renamed from: e */
    public c.b.b.n.k.d c(c.b.b.j.e eVar, String str, c.b.b.m.a aVar, a aVar2) {
        InterceptResult invokeLLLL;
        c.b.b.m.a aVar3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, eVar, str, aVar, aVar2)) == null) {
            c.b.b.n.k.d dVar = new c.b.b.n.k.d();
            if (aVar2 != null && (str2 = aVar2.f22379b) != null) {
                dVar.f(aVar, (c.b.b.n.k.h) eVar.j(str2, c.b.b.n.k.h.class), aVar2.f22380c);
            } else if (aVar2 != null && (aVar3 = aVar2.f22381d) != null) {
                dVar.a(aVar, aVar3);
            } else {
                dVar.a(aVar, aVar.i());
            }
            return dVar;
        }
        return (c.b.b.n.k.d) invokeLLLL.objValue;
    }
}
