package c.a.k0.a.l;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            return str + "/bddownload/";
        }
        return (String) invokeL.objValue;
    }

    public static File b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                if (Build.VERSION.SDK_INT > 28) {
                    return context.getExternalFilesDir(null);
                }
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    if (f.a(context, "android.permission.WRITE_EXTERNAL_STORAGE") && f.b("permission_storage")) {
                        return c();
                    }
                    if (Build.VERSION.SDK_INT >= 19) {
                        return context.getExternalFilesDir(null);
                    }
                    return context.getFilesDir();
                }
                return context.getFilesDir();
            } catch (Exception e2) {
                b.i().h("TAG", e2.getMessage());
                return null;
            }
        }
        return (File) invokeL.objValue;
    }

    public static File c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? Environment.getExternalStorageDirectory() : (File) invokeV.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? e(context, "/mnt/sdcard") : (String) invokeL.objValue;
    }

    public static String e(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            try {
                return a(b(context).getPath());
            } catch (Throwable unused) {
                return a(str);
            }
        }
        return (String) invokeLL.objValue;
    }
}
