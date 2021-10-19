package c.a.r0.v.b.g;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.aiapps.apps.permission.PermissionActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static List<String> f25345a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1906288205, "Lc/a/r0/v/b/g/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1906288205, "Lc/a/r0/v/b/g/a;");
        }
    }

    @TargetApi(23)
    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            List<String> list = f25345a;
            if (list == null) {
                f25345a = new ArrayList();
            } else {
                list.clear();
            }
            if (context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                f25345a.add("android.permission.WRITE_EXTERNAL_STORAGE");
                f25345a.add("android.permission.READ_EXTERNAL_STORAGE");
            }
        }
    }

    @TargetApi(23)
    public static boolean b(Context context, int i2, String[] strArr, int[] iArr) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65538, null, context, i2, strArr, iArr)) == null) {
            if (strArr.length >= 1 || iArr.length >= 1) {
                if (!c(context)) {
                    d(context);
                    return true;
                } else if (context instanceof PermissionActivity) {
                    ((Activity) context).finish();
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
        return invokeLILL.booleanValue;
    }

    @TargetApi(23)
    public static boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0 : invokeL.booleanValue;
    }

    @TargetApi(23)
    public static void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            if (!c(context)) {
                a(context);
                List<String> list = f25345a;
                ((Activity) context).requestPermissions((String[]) list.toArray(new String[list.size()]), 102);
            } else if (context instanceof PermissionActivity) {
                ((Activity) context).finish();
            }
        }
    }
}
