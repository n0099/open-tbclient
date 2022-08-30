package com.baidu.searchbox.live.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class LiveActivityUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "LiveActivityUtil";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public interface OnTranslucentListener {
        void onTranslucent(boolean z);
    }

    public LiveActivityUtil() {
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

    public static void convertFromTranslucent(Activity activity, OnTranslucentListener onTranslucentListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, activity, onTranslucentListener) == null) {
            try {
                Method declaredMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(activity, new Object[0]);
                if (onTranslucentListener != null) {
                    onTranslucentListener.onTranslucent(false);
                }
            } catch (Throwable th) {
                if (onTranslucentListener != null) {
                    onTranslucentListener.onTranslucent(true);
                }
                th.printStackTrace();
            }
        }
    }

    public static void fixTarget26Crash(@Nullable Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, activity) == null) && Build.VERSION.SDK_INT == 26 && activity != null) {
            convertFromTranslucent(activity, new OnTranslucentListener() { // from class: com.baidu.searchbox.live.util.LiveActivityUtil.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.searchbox.live.util.LiveActivityUtil.OnTranslucentListener
                public void onTranslucent(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                    }
                }
            });
        }
    }

    public static boolean startActivitySafely(Context context, Intent intent, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, context, intent, z)) == null) ? startActivitySafely(context, intent, z, true) : invokeLLZ.booleanValue;
    }

    public static boolean startActivitySafely(Context context, Intent intent, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{context, intent, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (z || !(context instanceof Activity)) {
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            try {
                context.startActivity(intent);
                return true;
            } catch (ActivityNotFoundException unused) {
                if (z2) {
                    Toast.makeText(context, (int) R.string.obfuscated_res_0x7f0f0a30, 0).show();
                    return false;
                }
                return false;
            } catch (SecurityException unused2) {
                if (z2) {
                    Toast.makeText(context, (int) R.string.obfuscated_res_0x7f0f0a30, 0).show();
                    return false;
                }
                return false;
            } catch (Exception unused3) {
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean startActivitySafely(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, intent)) == null) ? startActivitySafely(context, intent, false) : invokeLL.booleanValue;
    }
}
