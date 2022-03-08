package c.a.p0.j.l;

import c.a.p0.a.p2.g1.c;
import c.a.p0.a.t1.e;
import c.a.p0.a.x1.c.f;
import c.a.p0.j.d.c.b;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.j.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0717a implements c<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.o.b.a f10517e;

        public C0717a(c.a.p0.a.o.b.a aVar) {
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
            this.f10517e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                if (fVar == null || fVar.f9100d || fVar.f9106j != 1) {
                    a.c(this.f10517e, false, "system deny");
                } else {
                    a.c(this.f10517e, true, "authorize:ok");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1101271669, "Lc/a/p0/j/l/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1101271669, "Lc/a/p0/j/l/a;");
                return;
            }
        }
        a = c.a.p0.a.a.a;
    }

    public static void b(JsObject jsObject) {
        c.a.p0.a.o.b.a F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, jsObject) == null) || (F = c.a.p0.a.o.b.a.F(jsObject)) == null) {
            return;
        }
        e a0 = e.a0();
        if (a0 == null) {
            c(F, false, "authorize:fail internal error");
        } else {
            a0.d0().e("mapp_enable_eval", new C0717a(F));
        }
    }

    public static void c(c.a.p0.a.o.b.a aVar, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{aVar, Boolean.valueOf(z), str}) == null) {
            if (a) {
                String str2 = "callAsyncCallback: " + str;
            }
            b bVar = new b();
            bVar.errMsg = str;
            c.a.p0.j.n0.c.call(aVar, z, bVar);
        }
    }
}
