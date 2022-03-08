package c.q.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class x1 {
    public static /* synthetic */ Interceptable $ic;
    public static final x1 a;

    /* renamed from: b  reason: collision with root package name */
    public static ConcurrentHashMap f29169b;

    /* renamed from: c  reason: collision with root package name */
    public static Context f29170c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1646413218, "Lc/q/a/x1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1646413218, "Lc/q/a/x1;");
                return;
            }
        }
        a = new x1();
        f29169b = new ConcurrentHashMap();
    }

    public x1() {
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

    public static x1 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            f29170c = context.getApplicationContext();
            return a;
        }
        return (x1) invokeL.objValue;
    }

    public long a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Long l = (Long) f29169b.get(str);
            if (l == null || l.longValue() <= 0) {
                try {
                    String C = h2.C(f29170c);
                    if (!TextUtils.isEmpty(C)) {
                        JSONObject jSONObject = new JSONObject(C);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            if (TextUtils.equals(str, next)) {
                                return jSONObject.optLong(next, 0L);
                            }
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0L;
            }
            return l.longValue();
        }
        return invokeL.longValue;
    }

    public void c(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j2) == null) {
            f29169b.put(str, Long.valueOf(j2));
            try {
                String C = h2.C(f29170c);
                JSONObject jSONObject = !TextUtils.isEmpty(C) ? new JSONObject(C) : new JSONObject();
                jSONObject.put(str, j2);
                Context context = f29170c;
                String jSONObject2 = jSONObject.toString();
                SharedPreferences.Editor edit = context.getSharedPreferences("res_prefs", 0).edit();
                edit.putString("key_local_res", jSONObject2);
                edit.apply();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
