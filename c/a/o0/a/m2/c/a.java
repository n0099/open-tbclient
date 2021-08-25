package c.a.o0.a.m2.c;

import c.a.o0.a.k;
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

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f7353a;

    /* renamed from: b  reason: collision with root package name */
    public static JSONObject f7354b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1157476186, "Lc/a/o0/a/m2/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1157476186, "Lc/a/o0/a/m2/c/a;");
                return;
            }
        }
        f7353a = k.f7049a;
    }

    public static synchronized JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (a.class) {
                if (f7354b != null) {
                    if (f7353a) {
                        String str = "return cache obj : " + f7354b.toString();
                    }
                    return f7354b;
                }
                JSONObject rawSwitch = c.a.o0.a.c1.a.Z().getRawSwitch();
                if (rawSwitch == null) {
                    f7354b = new JSONObject();
                    boolean z = f7353a;
                    return f7354b;
                }
                Iterator<String> keys = rawSwitch.keys();
                while (keys.hasNext()) {
                    if (!keys.next().startsWith("swanswitch")) {
                        keys.remove();
                    }
                }
                f7354b = rawSwitch;
                if (f7353a) {
                    String str2 = "return new obj : " + f7354b.toString();
                }
                return f7354b;
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
                boolean z = f7353a;
                f7354b = null;
            }
        }
    }
}
