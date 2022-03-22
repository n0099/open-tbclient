package c.a.n0.g.k.a;

import android.util.Log;
import c.a.n0.u.e;
import c.a.n0.u.m;
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
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(871682299, "Lc/a/n0/g/k/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(871682299, "Lc/a/n0/g/k/a/a;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // c.a.n0.u.m
    public boolean a(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONArray)) == null) {
            if (a) {
                Log.d("OpenBehaviorUploader", "upload stat data -> " + jSONArray.toString());
            }
            c.a.n0.g.k.a.d.c cVar = new c.a.n0.g.k.a.d.c();
            HashMap hashMap = new HashMap(2);
            hashMap.put("cuid", e.g().getDeviceId(AppRuntime.getApplication()));
            hashMap.put("uuid", e.g().p(AppRuntime.getApplication()));
            c.a.n0.g.k.a.d.b.d().g(hashMap, jSONArray.toString().getBytes(), null, cVar);
            if (a) {
                Log.d("OpenBehaviorUploader", "errorCode : " + cVar.a);
                Log.d("OpenBehaviorUploader", "errorMsg : " + cVar.f8225b);
            }
            int i = cVar.a;
            if (i == 1 || i == 2 || i == 4) {
                c.a.n0.v.c.a();
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
