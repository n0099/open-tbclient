package c.a.s0.a.v1;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.k;
import com.baidu.swan.apps.SwanAppBaseActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(242425680, "Lc/a/s0/a/v1/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(242425680, "Lc/a/s0/a/v1/e;");
                return;
            }
        }
        a = k.a;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static boolean a(Context context, @NonNull f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, fVar)) == null) {
            if (context instanceof SwanAppBaseActivity) {
                return true;
            }
            fVar.b(2, "method should be called after setActivityRef");
            if (a) {
                throw new IllegalStateException("this method should be called after setActivityRef");
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(@NonNull Context context, @NonNull String str, @NonNull f fVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, str, fVar)) == null) {
            if (c.a.s0.x.d.c.a(context, str)) {
                fVar.a("permission has already granted");
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean c(ArrayList<String> arrayList, @NonNull f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, arrayList, fVar)) == null) {
            if (arrayList == null || arrayList.isEmpty()) {
                fVar.a("permission has already granted");
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @NonNull
    public static ArrayList<String> d(@NonNull Context context, @NonNull String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, strArr)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (String str : strArr) {
                if (!c.a.s0.x.d.c.a(context, str)) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public static void e(@NonNull String str, @NonNull String[] strArr, int i2, @NonNull Context context, @NonNull f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, strArr, Integer.valueOf(i2), context, fVar}) == null) && a(context, fVar) && !b(context, str, fVar)) {
            g(context, strArr, i2, fVar);
        }
    }

    @Deprecated
    public static void f(@NonNull Context context, @NonNull String[] strArr, int i2, @NonNull f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLIL(65542, null, context, strArr, i2, fVar) == null) && a(context, fVar)) {
            ArrayList<String> d2 = d(context, strArr);
            if (c(d2, fVar)) {
                return;
            }
            ((SwanAppBaseActivity) context).requestPermissionsExt(i2, (String[]) d2.toArray(new String[0]), new a(i2, fVar));
        }
    }

    public static void g(@NonNull Context context, @NonNull String[] strArr, int i2, @NonNull f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLIL(65543, null, context, strArr, i2, fVar) == null) && a(context, fVar)) {
            ArrayList<String> d2 = d(context, strArr);
            if (c(d2, fVar)) {
                return;
            }
            ((SwanAppBaseActivity) context).requestPermissionsExt(i2, (String[]) d2.toArray(new String[0]), new b(context, i2, fVar));
        }
    }

    public static void h(@NonNull String[] strArr, int i2, @NonNull Context context, @NonNull f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(65544, null, strArr, i2, context, fVar) == null) && a(context, fVar)) {
            ArrayList<String> d2 = d(context, strArr);
            if (c(d2, fVar)) {
                return;
            }
            g(context, (String[]) d2.toArray(new String[0]), i2, fVar);
        }
    }

    @Deprecated
    public static void requestPermissions(@NonNull String[] strArr, int i2, @NonNull Context context, @NonNull f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(65545, null, strArr, i2, context, fVar) == null) && a(context, fVar)) {
            ArrayList<String> d2 = d(context, strArr);
            if (c(d2, fVar)) {
                return;
            }
            f(context, (String[]) d2.toArray(new String[0]), i2, fVar);
        }
    }
}
