package c.a.d.h.h;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ubc.UBCManager;
import java.util.AbstractMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "11446";

    /* renamed from: b  reason: collision with root package name */
    public static String f3229b = "type";

    /* renamed from: c  reason: collision with root package name */
    public static String f3230c = "value";

    /* renamed from: d  reason: collision with root package name */
    public static String f3231d = "ext";

    /* renamed from: e  reason: collision with root package name */
    public static String f3232e = "suc";

    /* renamed from: f  reason: collision with root package name */
    public static String f3233f = "fail";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-445469162, "Lc/a/d/h/h/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-445469162, "Lc/a/d/h/h/d;");
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? TextUtils.isEmpty(str) ? "-" : str : (String) invokeL.objValue;
    }

    public static void b(String str, List<AbstractMap.SimpleEntry<String, String>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, list) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(f3229b, f3233f);
                jSONObject.put(f3230c, str);
                JSONObject jSONObject2 = new JSONObject();
                if (list != null && !list.isEmpty()) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        AbstractMap.SimpleEntry<String, String> simpleEntry = list.get(i2);
                        if (simpleEntry != null && !TextUtils.isEmpty(simpleEntry.getKey())) {
                            jSONObject2.put(simpleEntry.getKey(), a(simpleEntry.getValue()));
                        }
                    }
                }
                jSONObject.put(f3231d, jSONObject2);
                d(a, jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void c(String str, List<AbstractMap.SimpleEntry<String, String>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, list) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(f3229b, f3232e);
                jSONObject.put(f3230c, str);
                JSONObject jSONObject2 = new JSONObject();
                if (list != null && !list.isEmpty()) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        AbstractMap.SimpleEntry<String, String> simpleEntry = list.get(i2);
                        if (simpleEntry != null && !TextUtils.isEmpty(simpleEntry.getKey())) {
                            jSONObject2.put(simpleEntry.getKey(), a(simpleEntry.getValue()));
                        }
                    }
                }
                jSONObject.put(f3231d, jSONObject2);
                d(a, jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void d(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, jSONObject) == null) {
            ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(str, jSONObject);
        }
    }
}
