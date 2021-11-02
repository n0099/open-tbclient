package b.a.p0.h.l;

import b.a.p0.a.a2.e;
import b.a.p0.a.e2.c.f;
import b.a.p0.a.k;
import b.a.p0.a.v2.e1.b;
import b.a.p0.h.m0.c;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f10509a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.h.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0570a implements b<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.y.b.a f10510e;

        public C0570a(b.a.p0.a.y.b.a aVar) {
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
            this.f10510e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                if (fVar == null || fVar.f4907d || fVar.j != 1) {
                    a.c(this.f10510e, false, "system deny");
                } else {
                    a.c(this.f10510e, true, "authorize:ok");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-865126964, "Lb/a/p0/h/l/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-865126964, "Lb/a/p0/h/l/a;");
                return;
            }
        }
        f10509a = k.f6397a;
    }

    public static void b(JsObject jsObject) {
        b.a.p0.a.y.b.a F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, jsObject) == null) || (F = b.a.p0.a.y.b.a.F(jsObject)) == null) {
            return;
        }
        e P = e.P();
        if (P == null) {
            c(F, false, "authorize:fail internal error");
        } else {
            P.S().e("mapp_enable_eval", new C0570a(F));
        }
    }

    public static void c(b.a.p0.a.y.b.a aVar, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{aVar, Boolean.valueOf(z), str}) == null) {
            if (f10509a) {
                String str2 = "callAsyncCallback: " + str;
            }
            b.a.p0.h.d.c.b bVar = new b.a.p0.h.d.c.b();
            bVar.errMsg = str;
            c.call(aVar, z, bVar);
        }
    }
}
