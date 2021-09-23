package c.a.p0.e.o.a;

import c.a.p0.a.k;
import c.a.p0.r.e;
import c.a.p0.r.m;
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
/* loaded from: classes.dex */
public class a implements m {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f10432a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1798357189, "Lc/a/p0/e/o/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1798357189, "Lc/a/p0/e/o/a/a;");
                return;
            }
        }
        f10432a = k.f7085a;
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

    @Override // c.a.p0.r.m
    public boolean a(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONArray)) == null) {
            if (f10432a) {
                String str = "upload stat data -> " + jSONArray.toString();
            }
            c.a.p0.e.o.a.d.c cVar = new c.a.p0.e.o.a.d.c();
            HashMap hashMap = new HashMap(2);
            hashMap.put("cuid", e.h().getDeviceId(AppRuntime.getApplication()));
            hashMap.put("uuid", e.h().p(AppRuntime.getApplication()));
            c.a.p0.e.o.a.d.b.d().g(hashMap, jSONArray.toString().getBytes(), null, cVar);
            if (f10432a) {
                String str2 = "errorCode : " + cVar.f10437a;
                String str3 = "errorMsg : " + cVar.f10438b;
            }
            int i2 = cVar.f10437a;
            if (i2 == 1 || i2 == 2 || i2 == 4) {
                c.a.p0.s.c.a();
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
