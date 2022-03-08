package com.baidu.android.util.android;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
@Deprecated
/* loaded from: classes3.dex */
public class AccessibilityUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String MODE_ACCESSIBILITY_TAG = "talkback";
    public transient /* synthetic */ FieldHolder $fh;

    public AccessibilityUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void addTalkBackChangeListener(AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        AccessibilityManager accessibilityManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, touchExplorationStateChangeListener) == null) || (accessibilityManager = (AccessibilityManager) AppRuntime.getAppContext().getSystemService("accessibility")) == null || Build.VERSION.SDK_INT < 19) {
            return;
        }
        accessibilityManager.addTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
    }

    public static boolean isEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                for (AccessibilityServiceInfo accessibilityServiceInfo : ((AccessibilityManager) AppRuntime.getAppContext().getSystemService("accessibility")).getEnabledAccessibilityServiceList(-1)) {
                    if (accessibilityServiceInfo.getId().toLowerCase(Locale.getDefault()).contains("talkback")) {
                        return true;
                    }
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean isTalkBackOpened() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            AccessibilityManager accessibilityManager = (AccessibilityManager) AppRuntime.getAppContext().getSystemService("accessibility");
            return accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled();
        }
        return invokeV.booleanValue;
    }

    public static void removeTalkBackChangeListener(AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        AccessibilityManager accessibilityManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, touchExplorationStateChangeListener) == null) || (accessibilityManager = (AccessibilityManager) AppRuntime.getAppContext().getSystemService("accessibility")) == null || Build.VERSION.SDK_INT < 19) {
            return;
        }
        accessibilityManager.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
    }
}
