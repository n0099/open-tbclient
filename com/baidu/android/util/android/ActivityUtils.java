package com.baidu.android.util.android;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.List;
/* loaded from: classes10.dex */
public final class ActivityUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean DEBUG = false;
    public static final String TAG = "ActivityUtils";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2106708120, "Lcom/baidu/android/util/android/ActivityUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2106708120, "Lcom/baidu/android/util/android/ActivityUtils;");
        }
    }

    public ActivityUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean isDestroyed(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) {
            if (activity == null || activity.isFinishing()) {
                return true;
            }
            return Build.VERSION.SDK_INT >= 17 && activity.isDestroyed();
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public static boolean isIntentAvailable(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, intent)) == null) ? intent != null && context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0 : invokeLL.booleanValue;
    }

    @Deprecated
    public static boolean processFileUriIntent(Context context, File file, Intent intent) {
        InterceptResult invokeLLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, file, intent)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
                    if (uriForFile == null) {
                        return false;
                    }
                    intent.setDataAndType(uriForFile, intent.getType());
                    List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
                    if (queryIntentActivities == null) {
                        return true;
                    }
                    for (ResolveInfo resolveInfo : queryIntentActivities) {
                        ActivityInfo activityInfo = resolveInfo.activityInfo;
                        if (activityInfo != null && (str = activityInfo.packageName) != null) {
                            context.grantUriPermission(str, uriForFile, 1);
                        }
                    }
                } catch (IllegalArgumentException e2) {
                    if (DEBUG) {
                        throw e2;
                    }
                    return false;
                }
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static void setTaskDescription(Activity activity, String str, Bitmap bitmap, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65541, null, activity, str, bitmap, i2) == null) {
            if (Color.alpha(i2) != 255) {
                i2 = Color.argb(255, Color.red(i2), Color.green(i2), Color.blue(i2));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                activity.setTaskDescription(new ActivityManager.TaskDescription(str, bitmap, i2));
            }
        }
    }

    public static boolean startActivityForResultSafely(Context context, Intent intent, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65543, null, context, intent, i2)) == null) ? startActivityForResultSafely((Activity) context, intent, i2, false, false) : invokeLLI.booleanValue;
    }

    public static void startActivitySafely(Activity activity, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, activity, intent) == null) {
            startActivitySafely((Context) activity, intent, true);
        }
    }

    public static boolean startActivityForResultSafely(Activity activity, Intent intent, int i2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{activity, intent, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (z) {
                intent.addFlags(268435456);
            }
            try {
                activity.startActivityForResult(intent, i2);
                return true;
            } catch (ActivityNotFoundException unused) {
                if (z2) {
                    Toast.makeText(activity, R.string.activity_not_found, 0).show();
                    return false;
                }
                return false;
            } catch (SecurityException unused2) {
                if (z2) {
                    Toast.makeText(activity, R.string.activity_not_found, 0).show();
                }
                if (DEBUG) {
                    String str = "Launcher does not have the permission to launch " + intent + ". Make sure to create a MAIN intent-filter for the corresponding activity or use the exported attribute for this activity.";
                    return false;
                }
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean startActivitySafely(Context context, Intent intent, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65548, null, context, intent, z)) == null) ? startActivitySafely(context, intent, z, true) : invokeLLZ.booleanValue;
    }

    public static boolean startActivitySafely(Context context, Intent intent, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{context, intent, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (z || !(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            try {
                context.startActivity(intent);
                return true;
            } catch (ActivityNotFoundException unused) {
                if (z2) {
                    Toast.makeText(context, R.string.activity_not_found, 0).show();
                    return false;
                }
                return false;
            } catch (SecurityException unused2) {
                if (z2) {
                    Toast.makeText(context, R.string.activity_not_found, 0).show();
                }
                if (DEBUG) {
                    String str = "Launcher does not have the permission to launch " + intent + ". Make sure to create a MAIN intent-filter for the corresponding activity or use the exported attribute for this activity.";
                    return false;
                }
                return false;
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.getMessage();
                    return false;
                }
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean startActivitySafely(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, intent)) == null) ? startActivitySafely(context, intent, false) : invokeLL.booleanValue;
    }

    public static boolean startActivitySafely(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65550, null, context, str, str2)) == null) ? startActivitySafely(context, str, str2, true) : invokeLLL.booleanValue;
    }

    public static boolean startActivitySafely(Context context, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{context, str, str2, Boolean.valueOf(z)})) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return false;
            }
            return startActivitySafely(context, new ComponentName(str, str2), z);
        }
        return invokeCommon.booleanValue;
    }

    public static boolean startActivitySafely(Context context, ComponentName componentName) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, context, componentName)) == null) ? startActivitySafely(context, componentName, true) : invokeLL.booleanValue;
    }

    public static boolean startActivitySafely(Context context, ComponentName componentName, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65546, null, context, componentName, z)) == null) {
            if (componentName != null) {
                Intent intent = new Intent();
                intent.setComponent(componentName);
                return startActivitySafely(context, intent, true, z);
            }
            return false;
        }
        return invokeLLZ.booleanValue;
    }
}
