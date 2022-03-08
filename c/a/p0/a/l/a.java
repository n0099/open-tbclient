package c.a.p0.a.l;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.v0.e.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int indexOf = str.indexOf("_dev");
            if (indexOf > 0) {
                return str.substring(0, indexOf);
            }
            int indexOf2 = str.indexOf("_trial");
            return indexOf2 > 0 ? str.substring(0, indexOf2) : str;
        }
        return (String) invokeL.objValue;
    }

    public static int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            if (str.contains("_dev")) {
                return 1;
            }
            if (str.endsWith("_trial")) {
                return 3;
            }
            return str.contains("_trial") ? 2 : 0;
        }
        return invokeL.intValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            int lastIndexOf = str.lastIndexOf("_dev");
            if (lastIndexOf >= 0 && lastIndexOf < str.length()) {
                return str.substring(lastIndexOf);
            }
            int lastIndexOf2 = str.lastIndexOf("_trial");
            return (lastIndexOf2 < 0 || lastIndexOf2 >= str.length()) ? "" : str.substring(lastIndexOf2);
        }
        return (String) invokeL.objValue;
    }

    public static boolean d(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bVar)) == null) ? bVar != null && bVar.getType() == 1 : invokeL.booleanValue;
    }

    public static boolean e(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar)) == null) ? bVar != null && bVar.getType() == 0 : invokeL.booleanValue;
    }

    @Deprecated
    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? (TextUtils.isEmpty(str) || str.contains("_")) ? false : true : invokeL.booleanValue;
    }

    public static boolean g(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bVar)) == null) ? bVar != null && bVar.getType() == 2 : invokeL.booleanValue;
    }
}
