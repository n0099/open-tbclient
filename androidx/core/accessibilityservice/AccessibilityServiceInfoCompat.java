package androidx.core.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.network.outback.EngineName;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class AccessibilityServiceInfoCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CAPABILITY_CAN_FILTER_KEY_EVENTS = 8;
    public static final int CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 4;
    public static final int CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION = 2;
    public static final int CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT = 1;
    public static final int FEEDBACK_ALL_MASK = -1;
    public static final int FEEDBACK_BRAILLE = 32;
    public static final int FLAG_INCLUDE_NOT_IMPORTANT_VIEWS = 2;
    public static final int FLAG_REPORT_VIEW_IDS = 16;
    public static final int FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 8;
    public static final int FLAG_REQUEST_FILTER_KEY_EVENTS = 32;
    public static final int FLAG_REQUEST_TOUCH_EXPLORATION_MODE = 4;
    public transient /* synthetic */ FieldHolder $fh;

    public static String capabilityToString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? i != 1 ? i != 2 ? i != 4 ? i != 8 ? RomUtils.UNKNOWN : "CAPABILITY_CAN_FILTER_KEY_EVENTS" : "CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY" : "CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION" : "CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT" : (String) invokeI.objValue;
    }

    public static String flagToString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 4) {
                        if (i != 8) {
                            if (i != 16) {
                                if (i != 32) {
                                    return null;
                                }
                                return "FLAG_REQUEST_FILTER_KEY_EVENTS";
                            }
                            return "FLAG_REPORT_VIEW_IDS";
                        }
                        return "FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
                    }
                    return "FLAG_REQUEST_TOUCH_EXPLORATION_MODE";
                }
                return "FLAG_INCLUDE_NOT_IMPORTANT_VIEWS";
            }
            return EngineName.DEFAULT_ENGINE;
        }
        return (String) invokeI.objValue;
    }

    public AccessibilityServiceInfoCompat() {
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

    public static String feedbackTypeToString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(PreferencesUtil.LEFT_MOUNT);
            while (i > 0) {
                int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(i);
                i &= ~numberOfTrailingZeros;
                if (sb.length() > 1) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                if (numberOfTrailingZeros != 1) {
                    if (numberOfTrailingZeros != 2) {
                        if (numberOfTrailingZeros != 4) {
                            if (numberOfTrailingZeros != 8) {
                                if (numberOfTrailingZeros == 16) {
                                    sb.append("FEEDBACK_GENERIC");
                                }
                            } else {
                                sb.append("FEEDBACK_VISUAL");
                            }
                        } else {
                            sb.append("FEEDBACK_AUDIBLE");
                        }
                    } else {
                        sb.append("FEEDBACK_HAPTIC");
                    }
                } else {
                    sb.append("FEEDBACK_SPOKEN");
                }
            }
            sb.append(PreferencesUtil.RIGHT_MOUNT);
            return sb.toString();
        }
        return (String) invokeI.objValue;
    }

    public static int getCapabilities(AccessibilityServiceInfo accessibilityServiceInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, accessibilityServiceInfo)) == null) {
            if (Build.VERSION.SDK_INT >= 18) {
                return accessibilityServiceInfo.getCapabilities();
            }
            if (accessibilityServiceInfo.getCanRetrieveWindowContent()) {
                return 1;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static String loadDescription(AccessibilityServiceInfo accessibilityServiceInfo, PackageManager packageManager) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, accessibilityServiceInfo, packageManager)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return accessibilityServiceInfo.loadDescription(packageManager);
            }
            return accessibilityServiceInfo.getDescription();
        }
        return (String) invokeLL.objValue;
    }
}
