package b.a.p0.e.a.h;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f10257a;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            String str = f10257a;
            if (str != null) {
                return TextUtils.equals(str, "HUAWEI");
            }
            String upperCase = Build.BRAND.toUpperCase();
            if (!TextUtils.equals("HUAWEI", upperCase) && !TextUtils.equals("HONOR", upperCase)) {
                String upperCase2 = Build.MANUFACTURER.toUpperCase();
                if (upperCase2.contains("HUAWEI") || upperCase2.contains("HONOR")) {
                    f10257a = "HUAWEI";
                    return true;
                }
                return false;
            }
            f10257a = "HUAWEI";
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            String str = f10257a;
            if (str != null) {
                return TextUtils.equals(str, "OPPO");
            }
            if (TextUtils.equals("OPPO", Build.BRAND.toUpperCase())) {
                f10257a = "OPPO";
                return true;
            } else if (Build.MANUFACTURER.toUpperCase().contains("OPPO")) {
                f10257a = "OPPO";
                return true;
            } else {
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
