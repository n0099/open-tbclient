package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
/* loaded from: classes.dex */
public final class NavUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PARENT_ACTIVITY = "android.support.PARENT_ACTIVITY";
    public static final String TAG = "NavUtils";
    public transient /* synthetic */ FieldHolder $fh;

    public NavUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Nullable
    public static Intent getParentActivityIntent(@NonNull Activity activity) {
        InterceptResult invokeL;
        Intent parentActivityIntent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, activity)) == null) {
            if (Build.VERSION.SDK_INT < 16 || (parentActivityIntent = activity.getParentActivityIntent()) == null) {
                String parentActivityName = getParentActivityName(activity);
                if (parentActivityName == null) {
                    return null;
                }
                ComponentName componentName = new ComponentName(activity, parentActivityName);
                try {
                    if (getParentActivityName(activity, componentName) == null) {
                        return Intent.makeMainActivity(componentName);
                    }
                    return new Intent().setComponent(componentName);
                } catch (PackageManager.NameNotFoundException unused) {
                    Log.e(TAG, "getParentActivityIntent: bad parentActivityName '" + parentActivityName + "' in manifest");
                    return null;
                }
            }
            return parentActivityIntent;
        }
        return (Intent) invokeL.objValue;
    }

    @Nullable
    public static String getParentActivityName(@NonNull Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity)) == null) {
            try {
                return getParentActivityName(activity, activity.getComponentName());
            } catch (PackageManager.NameNotFoundException e2) {
                throw new IllegalArgumentException(e2);
            }
        }
        return (String) invokeL.objValue;
    }

    public static void navigateUpFromSameTask(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, activity) == null) {
            Intent parentActivityIntent = getParentActivityIntent(activity);
            if (parentActivityIntent != null) {
                navigateUpTo(activity, parentActivityIntent);
                return;
            }
            throw new IllegalArgumentException("Activity " + activity.getClass().getSimpleName() + " does not have a parent activity name specified. (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data>  element in your manifest?)");
        }
    }

    public static void navigateUpTo(@NonNull Activity activity, @NonNull Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, activity, intent) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                activity.navigateUpTo(intent);
                return;
            }
            intent.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            activity.startActivity(intent);
            activity.finish();
        }
    }

    public static boolean shouldUpRecreateTask(@NonNull Activity activity, @NonNull Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, activity, intent)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return activity.shouldUpRecreateTask(intent);
            }
            String action = activity.getIntent().getAction();
            return (action == null || action.equals("android.intent.action.MAIN")) ? false : true;
        }
        return invokeLL.booleanValue;
    }

    @Nullable
    public static String getParentActivityName(@NonNull Context context, @NonNull ComponentName componentName) throws PackageManager.NameNotFoundException {
        InterceptResult invokeLL;
        String string;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, componentName)) == null) {
            PackageManager packageManager = context.getPackageManager();
            int i = Build.VERSION.SDK_INT;
            int i2 = 640;
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 29) {
                i2 = 269222528;
            } else if (i3 >= 24) {
                i2 = 787072;
            }
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, i2);
            if (Build.VERSION.SDK_INT < 16 || (str = activityInfo.parentActivityName) == null) {
                Bundle bundle = activityInfo.metaData;
                if (bundle == null || (string = bundle.getString(PARENT_ACTIVITY)) == null) {
                    return null;
                }
                if (string.charAt(0) == '.') {
                    return context.getPackageName() + string;
                }
                return string;
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    @Nullable
    public static Intent getParentActivityIntent(@NonNull Context context, @NonNull Class<?> cls) throws PackageManager.NameNotFoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, cls)) == null) {
            String parentActivityName = getParentActivityName(context, new ComponentName(context, cls));
            if (parentActivityName == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(context, parentActivityName);
            if (getParentActivityName(context, componentName) == null) {
                return Intent.makeMainActivity(componentName);
            }
            return new Intent().setComponent(componentName);
        }
        return (Intent) invokeLL.objValue;
    }

    @Nullable
    public static Intent getParentActivityIntent(@NonNull Context context, @NonNull ComponentName componentName) throws PackageManager.NameNotFoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, componentName)) == null) {
            String parentActivityName = getParentActivityName(context, componentName);
            if (parentActivityName == null) {
                return null;
            }
            ComponentName componentName2 = new ComponentName(componentName.getPackageName(), parentActivityName);
            if (getParentActivityName(context, componentName2) == null) {
                return Intent.makeMainActivity(componentName2);
            }
            return new Intent().setComponent(componentName2);
        }
        return (Intent) invokeLL.objValue;
    }
}
