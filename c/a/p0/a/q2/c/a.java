package c.a.p0.a.q2.c;

import c.a.p0.a.k;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static JSONObject f7557b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(541606333, "Lc/a/p0/a/q2/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(541606333, "Lc/a/p0/a/q2/c/a;");
                return;
            }
        }
        a = k.a;
    }

    public static synchronized JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (a.class) {
                if (f7557b != null) {
                    if (a) {
                        String str = "return cache obj : " + f7557b.toString();
                    }
                    return f7557b;
                }
                JSONObject rawSwitch = c.a.p0.a.c1.a.g0().getRawSwitch();
                if (rawSwitch == null) {
                    f7557b = new JSONObject();
                    boolean z = a;
                    return f7557b;
                }
                Iterator<String> keys = rawSwitch.keys();
                while (keys.hasNext()) {
                    if (!keys.next().startsWith("swanswitch")) {
                        keys.remove();
                    }
                }
                f7557b = rawSwitch;
                if (a) {
                    String str2 = "return new obj : " + f7557b.toString();
                }
                return f7557b;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("abTestSwitch", a());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            synchronized (a.class) {
                boolean z = a;
                f7557b = null;
            }
        }
    }
}
