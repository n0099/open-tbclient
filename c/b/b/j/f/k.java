package c.b.b.j.f;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class k extends b<c.b.b.n.m.i, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f26989b;

    /* renamed from: c  reason: collision with root package name */
    public String f26990c;

    /* loaded from: classes9.dex */
    public static class a extends c.b.b.j.c<c.b.b.n.m.i> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public String f26991b;

        /* renamed from: c  reason: collision with root package name */
        public String f26992c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f26993d;

        /* renamed from: e  reason: collision with root package name */
        public String f26994e;

        /* renamed from: f  reason: collision with root package name */
        public String f26995f;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26993d = true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(e eVar) {
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
        this.f26989b = ".vert";
        this.f26990c = ".frag";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.b.b.j.f.a
    /* renamed from: f */
    public c.b.b.q.a<c.b.b.j.a> a(String str, c.b.b.m.a aVar, a aVar2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, aVar, aVar2)) == null) {
            return null;
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
    public c.b.b.n.m.i d(c.b.b.j.e eVar, String str, c.b.b.m.a aVar, a aVar2) {
        InterceptResult invokeLLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, eVar, str, aVar, aVar2)) == null) {
            String str3 = null;
            if (aVar2 != null) {
                String str4 = aVar2.f26991b;
                if (str4 == null) {
                    str4 = null;
                }
                str2 = aVar2.f26992c;
                if (str2 == null) {
                    str2 = null;
                }
                str3 = str4;
            } else {
                str2 = null;
            }
            if (str3 == null && str.endsWith(this.f26990c)) {
                str3 = str.substring(0, str.length() - this.f26990c.length()) + this.f26989b;
            }
            if (str2 == null && str.endsWith(this.f26989b)) {
                str2 = str.substring(0, str.length() - this.f26989b.length()) + this.f26990c;
            }
            c.b.b.m.a b2 = str3 == null ? aVar : b(str3);
            if (str2 != null) {
                aVar = b(str2);
            }
            String o = b2.o();
            String o2 = b2.equals(aVar) ? o : aVar.o();
            if (aVar2 != null) {
                if (aVar2.f26994e != null) {
                    o = aVar2.f26994e + o;
                }
                if (aVar2.f26995f != null) {
                    o2 = aVar2.f26995f + o2;
                }
            }
            c.b.b.n.m.i iVar = new c.b.b.n.m.i(o, o2);
            if ((aVar2 == null || aVar2.f26993d) && !iVar.o()) {
                eVar.p().b("ShaderProgram " + str + " failed to compile:\n" + iVar.l());
            }
            return iVar;
        }
        return (c.b.b.n.m.i) invokeLLLL.objValue;
    }
}
