package c.a.n0.h.c;

import c.a.n0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f10788a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1838856243, "Lc/a/n0/h/c/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1838856243, "Lc/a/n0/h/c/h;");
                return;
            }
        }
        f10788a = k.f6803a;
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
        c.a.n0.a.y.b.a G = c.a.n0.a.y.b.a.G(jsObject);
        if (G == null) {
            return;
        }
        c.a.n0.a.a2.e i4 = c.a.n0.a.a2.e.i();
        if (i4 == null) {
            a(G, false, b("internal error"));
            return;
        }
        try {
            boolean n = G.n("mixWithOther", false);
            i4.J().h("key_audio_is_mix_with_other", Boolean.valueOf(n));
            if (f10788a) {
                String str = "Audio Mix Changed to " + n;
            }
            a(G, true, "setInnerAudioOption:ok");
        } catch (Exception unused) {
            c.a.n0.a.e0.d.b("InnerAudioOptionApi", "set swanApp global var error");
            a(G, false, b("internal error"));
        }
    }

    public final void a(c.a.n0.a.y.b.a aVar, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{aVar, Boolean.valueOf(z), str}) == null) {
            c.a.n0.h.d.c.b bVar = new c.a.n0.h.d.c.b();
            bVar.errMsg = str;
            c.a.n0.h.m0.c.a(aVar, z, bVar);
        }
    }

    public final String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? String.format("setInnerAudioOption:fail %s", str) : (String) invokeL.objValue;
    }
}
