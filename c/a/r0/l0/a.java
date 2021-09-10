package c.a.r0.l0;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, String> f21791a;

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, String> f21792b;

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, String> f21793c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1789347514, "Lc/a/r0/l0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1789347514, "Lc/a/r0/l0/a;");
                return;
            }
        }
        f21791a = new HashMap();
        f21792b = new HashMap();
        f21793c = new HashMap();
        f21791a.put("CAM_X0101", "CAM_X1101");
        f21792b.put("CAM_X0101", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0101", "isAbNightColor");
        f21791a.put("CAM_X0102", "CAM_X1102");
        f21792b.put("CAM_X0102", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0102", "isAbNightColor");
        f21791a.put("CAM_X0103", "CAM_X1103");
        f21792b.put("CAM_X0103", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0103", "isAbNightColor");
        f21791a.put("CAM_X0105", "CAM_X1105");
        f21792b.put("CAM_X0105", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0105", "isAbNightColor");
        f21791a.put("CAM_X0106", "CAM_X1106");
        f21792b.put("CAM_X0106", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0106", "isAbNightColor");
        f21791a.put("CAM_X0107", "CAM_X1107");
        f21792b.put("CAM_X0107", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0107", "isAbNightColor");
        f21791a.put("CAM_X0108", "CAM_X1108");
        f21792b.put("CAM_X0108", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0108", "isAbNightColor");
        f21791a.put("CAM_X0109", "CAM_X1109");
        f21792b.put("CAM_X0109", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0109", "isAbNightColor");
        f21791a.put("CAM_X0111", "CAM_X1111");
        f21792b.put("CAM_X0111", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0111", "isAbNightColor");
        f21791a.put("CAM_X0112", "CAM_X1112");
        f21792b.put("CAM_X0112", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0112", "isAbNightColor");
        f21791a.put("CAM_X0201", "CAM_X1201");
        f21792b.put("CAM_X0201", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0201", "isAbNightColor");
        f21791a.put("CAM_X0202", "CAM_X1202");
        f21792b.put("CAM_X0202", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0202", "isAbNightColor");
        f21791a.put("CAM_X0204", "CAM_X1204");
        f21792b.put("CAM_X0204", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0204", "isAbNightColor");
        f21791a.put("CAM_X0205", "CAM_X1205");
        f21792b.put("CAM_X0205", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0205", "isAbNightColor");
        f21791a.put("CAM_X0206", "CAM_X1206");
        f21792b.put("CAM_X0206", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0206", "isAbNightColor");
        f21791a.put("CAM_X0207", "CAM_X1207");
        f21792b.put("CAM_X0207", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0207", "isAbNightColor");
        f21791a.put("CAM_X0208", "CAM_X1208");
        f21792b.put("CAM_X0208", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0208", "isAbNightColor");
        f21791a.put("CAM_X0209", "CAM_X1209");
        f21792b.put("CAM_X0209", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0209", "isAbNightColor");
        f21791a.put("CAM_X0210", "CAM_X1210");
        f21792b.put("CAM_X0210", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0210", "isAbNightColor");
        f21791a.put("CAM_X0211", "CAM_X1211");
        f21792b.put("CAM_X0211", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0211", "isAbNightColor");
        f21791a.put("CAM_X0212", "CAM_X1212");
        f21792b.put("CAM_X0212", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0212", "isAbNightColor");
        f21791a.put("CAM_X0213", "CAM_X1213");
        f21792b.put("CAM_X0213", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0213", "isAbNightColor");
        f21791a.put("CAM_X0214", "CAM_X1214");
        f21792b.put("CAM_X0214", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0214", "isAbNightColor");
        f21791a.put("CAM_X0215", "CAM_X1215");
        f21792b.put("CAM_X0215", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0215", "isAbNightColor");
        f21791a.put("CAM_X0301", "CAM_X1301");
        f21792b.put("CAM_X0301", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0301", "isAbNightColor");
        f21791a.put("CAM_X0302", "CAM_X1302");
        f21792b.put("CAM_X0302", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0302", "isAbNightColor");
        f21791a.put("CAM_X0304", "CAM_X1304");
        f21792b.put("CAM_X0304", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0304", "isAbNightColor");
        f21791a.put("CAM_X0305", "CAM_X1305");
        f21792b.put("CAM_X0305", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0305", "isAbNightColor");
        f21791a.put("CAM_X0306", "CAM_X1306");
        f21792b.put("CAM_X0306", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0306", "isAbNightColor");
        f21791a.put("CAM_X0307", "CAM_X1307");
        f21792b.put("CAM_X0307", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0307", "isAbNightColor");
        f21791a.put("CAM_X0308", "CAM_X1308");
        f21792b.put("CAM_X0308", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0308", "isAbNightColor");
        f21791a.put("CAM_X0309", "CAM_X1309");
        f21792b.put("CAM_X0309", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0309", "isAbNightColor");
        f21791a.put("CAM_X0310", "CAM_X1310");
        f21792b.put("CAM_X0310", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0310", "isAbNightColor");
        f21791a.put("CAM_X0311", "CAM_X1311");
        f21792b.put("CAM_X0311", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0311", "isAbNightColor");
        f21791a.put("CAM_X0312", "CAM_X1312");
        f21792b.put("CAM_X0312", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0312", "isAbNightColor");
        f21791a.put("CAM_X0313", "CAM_X1313");
        f21792b.put("CAM_X0313", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0313", "isAbNightColor");
        f21791a.put("CAM_X0314", "CAM_X1314");
        f21792b.put("CAM_X0314", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0314", "isAbNightColor");
        f21791a.put("CAM_X0315", "CAM_X1315");
        f21792b.put("CAM_X0315", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0315", "isAbNightColor");
        f21791a.put("CAM_X0316", "CAM_X1316");
        f21792b.put("CAM_X0316", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0316", "isAbNightColor");
        f21791a.put("CAM_X0317", "CAM_X1317");
        f21792b.put("CAM_X0317", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0317", "isAbNightColor");
        f21791a.put("CAM_X0319", "CAM_X1319");
        f21792b.put("CAM_X0319", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0319", "isAbNightColor");
        f21791a.put("CAM_X0401", "CAM_X1401");
        f21792b.put("CAM_X0401", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0401", "isAbNightColor");
        f21791a.put("CAM_X0501", "CAM_X1501");
        f21792b.put("CAM_X0501", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0501", "isAbNightColor");
        f21791a.put("CAM_X0701", "CAM_X1701");
        f21792b.put("CAM_X0701", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0701", "isAbNightColor");
        f21791a.put("CAM_X0901", "CAM_X1901");
        f21792b.put("CAM_X0901", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0901", "isAbNightColor");
        f21791a.put("CAM_X0902", "CAM_X1902");
        f21792b.put("CAM_X0902", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0902", "isAbNightColor");
        f21791a.put("CAM_X0903", "CAM_X1903");
        f21792b.put("CAM_X0903", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0903", "isAbNightColor");
        f21791a.put("CAM_X0905", "CAM_X1905");
        f21792b.put("CAM_X0905", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0905", "isAbNightColor");
        f21791a.put("CAM_X0402", "CAM_X1402");
        f21792b.put("CAM_X0402", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0402", "isAbNightColor");
        f21791a.put("CAM_X0906", "CAM_X0906");
        f21792b.put("CAM_X0906", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21793c.put("CAM_X0906", "testMethod");
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (f21792b.containsKey(str)) {
                try {
                    Method declaredMethod = Class.forName(f21792b.get(str)).getDeclaredMethod(f21793c.get(str), new Class[0]);
                    declaredMethod.setAccessible(true);
                    Object invoke = declaredMethod.invoke(null, new Object[0]);
                    return ((invoke instanceof Boolean) && ((Boolean) invoke).booleanValue()) ? f21791a.get(str) : str;
                } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                    e2.printStackTrace();
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
