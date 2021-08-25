package c.a.o0.g.c.c;

import c.a.o0.a.k;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends c.a.o0.g.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1154242686, "Lc/a/o0/g/c/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1154242686, "Lc/a/o0/g/c/c/a;");
                return;
            }
        }
        boolean z = k.f7049a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a() {
        super("getDownloadConfig");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.o0.g.f.a
    public c.a.o0.a.u.h.b a(JSONObject jSONObject, c.a.o0.a.u0.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
            if (jSONObject == null) {
                bVar.onFail(202, "params may be error");
                return null;
            }
            if (jSONObject.has("wifiResumeDownloadFlag")) {
                c.a.o0.g.c.d.b.a().c(jSONObject.optBoolean("wifiResumeDownloadFlag", true));
            }
            if (jSONObject.has("install_guide_switch")) {
                c.a.o0.g.c.e.a.r(jSONObject.optBoolean("install_guide_switch"));
            }
            if (jSONObject.has("install_guide_count")) {
                c.a.o0.g.c.e.a.q(jSONObject.optInt("install_guide_count"));
            }
            if (jSONObject.has("get_install_result")) {
                c.a.o0.g.c.e.a.s(jSONObject.optBoolean("get_install_result"));
            }
            bVar.a(null);
            return null;
        }
        return (c.a.o0.a.u.h.b) invokeLL.objValue;
    }
}
