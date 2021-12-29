package c.a.r0.g.p.a;

import c.a.r0.a.k;
import c.a.r0.u.e;
import c.a.r0.u.m;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class a implements m {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1878010086, "Lc/a/r0/g/p/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1878010086, "Lc/a/r0/g/p/a/a;");
                return;
            }
        }
        a = k.a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // c.a.r0.u.m
    public boolean a(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONArray)) == null) {
            if (a) {
                String str = "upload stat data -> " + jSONArray.toString();
            }
            c.a.r0.g.p.a.d.c cVar = new c.a.r0.g.p.a.d.c();
            HashMap hashMap = new HashMap(2);
            hashMap.put("cuid", e.g().getDeviceId(AppRuntime.getApplication()));
            hashMap.put("uuid", e.g().p(AppRuntime.getApplication()));
            c.a.r0.g.p.a.d.b.d().g(hashMap, jSONArray.toString().getBytes(), null, cVar);
            if (a) {
                String str2 = "errorCode : " + cVar.a;
                String str3 = "errorMsg : " + cVar.f10578b;
            }
            int i2 = cVar.a;
            if (i2 == 1 || i2 == 2 || i2 == 4) {
                c.a.r0.v.c.a();
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
