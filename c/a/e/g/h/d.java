package c.a.e.g.h;

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

    /* renamed from: a  reason: collision with root package name */
    public static String f2690a = "11446";

    /* renamed from: b  reason: collision with root package name */
    public static String f2691b = "type";

    /* renamed from: c  reason: collision with root package name */
    public static String f2692c = "value";

    /* renamed from: d  reason: collision with root package name */
    public static String f2693d = "ext";

    /* renamed from: e  reason: collision with root package name */
    public static String f2694e = "suc";

    /* renamed from: f  reason: collision with root package name */
    public static String f2695f = "fail";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1268712022, "Lc/a/e/g/h/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1268712022, "Lc/a/e/g/h/d;");
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
                jSONObject.put(f2691b, f2695f);
                jSONObject.put(f2692c, str);
                JSONObject jSONObject2 = new JSONObject();
                if (list != null && !list.isEmpty()) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        AbstractMap.SimpleEntry<String, String> simpleEntry = list.get(i2);
                        if (simpleEntry != null && !TextUtils.isEmpty(simpleEntry.getKey())) {
                            jSONObject2.put(simpleEntry.getKey(), a(simpleEntry.getValue()));
                        }
                    }
                }
                jSONObject.put(f2693d, jSONObject2);
                d(f2690a, jSONObject);
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
                jSONObject.put(f2691b, f2694e);
                jSONObject.put(f2692c, str);
                JSONObject jSONObject2 = new JSONObject();
                if (list != null && !list.isEmpty()) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        AbstractMap.SimpleEntry<String, String> simpleEntry = list.get(i2);
                        if (simpleEntry != null && !TextUtils.isEmpty(simpleEntry.getKey())) {
                            jSONObject2.put(simpleEntry.getKey(), a(simpleEntry.getValue()));
                        }
                    }
                }
                jSONObject.put(f2693d, jSONObject2);
                d(f2690a, jSONObject);
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
