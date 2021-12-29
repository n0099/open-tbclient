package c.a.r0.j.c;

import c.a.r0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-421481201, "Lc/a/r0/j/c/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-421481201, "Lc/a/r0/j/c/h;");
                return;
            }
        }
        a = k.a;
    }

    public h(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jsObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        c.a.r0.a.y.b.a F = c.a.r0.a.y.b.a.F(jsObject);
        if (F == null) {
            return;
        }
        c.a.r0.a.d2.e L = c.a.r0.a.d2.e.L();
        if (L == null) {
            a(F, false, b("internal error"));
            return;
        }
        try {
            boolean m = F.m("mixWithOther", false);
            L.T().h("key_audio_is_mix_with_other", Boolean.valueOf(m));
            if (a) {
                String str = "Audio Mix Changed to " + m;
            }
            a(F, true, "setInnerAudioOption:ok");
        } catch (Exception unused) {
            c.a.r0.a.e0.d.c("InnerAudioOptionApi", "set swanApp global var error");
            a(F, false, b("internal error"));
        }
    }

    public final void a(c.a.r0.a.y.b.a aVar, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{aVar, Boolean.valueOf(z), str}) == null) {
            c.a.r0.j.d.c.b bVar = new c.a.r0.j.d.c.b();
            bVar.errMsg = str;
            c.a.r0.j.n0.c.call(aVar, z, bVar);
        }
    }

    public final String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? String.format("setInnerAudioOption:fail %s", str) : (String) invokeL.objValue;
    }
}
