package c.a.d0.v.v0;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Calendar;
/* loaded from: classes.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                String[] split = str.split(":");
                String[] split2 = str2.split(":");
                if (split.length != 0 && split2.length != 0) {
                    try {
                        Calendar calendar = Calendar.getInstance();
                        long timeInMillis = calendar.getTimeInMillis();
                        calendar.set(11, d.c(split[0]));
                        calendar.set(12, d.c(split[1]));
                        long timeInMillis2 = calendar.getTimeInMillis();
                        calendar.set(11, d.c(split2[0]));
                        calendar.set(12, d.c(split2[1]));
                        return timeInMillis >= timeInMillis2 && timeInMillis <= calendar.getTimeInMillis();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void b(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65537, null, activity, z) == null) || activity == null) {
            return;
        }
        h.b("BdVideoSys", "SCREEN_ORIENTATION_LANDSCAPE");
        if (z) {
            activity.setRequestedOrientation(8);
        } else {
            activity.setRequestedOrientation(0);
        }
        activity.getWindow().setFlags(1024, 1024);
    }

    public static void c(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65538, null, activity, z) == null) || activity == null) {
            return;
        }
        if (z) {
            activity.getWindow().addFlags(128);
        } else {
            activity.getWindow().clearFlags(128);
        }
    }

    public static void startActivity(Context context, String str, String str2, String str3) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, str2, str3) == null) {
            new Intent().setComponent(new ComponentName(str, str2 + str3));
        }
    }

    public static void startActivity(Context context, ComponentName componentName) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, componentName) == null) {
            new Intent().setComponent(componentName);
        }
    }
}
