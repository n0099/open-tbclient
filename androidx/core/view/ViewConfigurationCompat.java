package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class ViewConfigurationCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ViewConfigCompat";
    public static Method sGetScaledScrollFactorMethod;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(779267932, "Landroidx/core/view/ViewConfigurationCompat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(779267932, "Landroidx/core/view/ViewConfigurationCompat;");
                return;
            }
        }
        if (Build.VERSION.SDK_INT == 25) {
            try {
                sGetScaledScrollFactorMethod = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
            } catch (Exception unused) {
            }
        }
    }

    public ViewConfigurationCompat() {
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

    public static float getLegacyScrollFactor(ViewConfiguration viewConfiguration, Context context) {
        InterceptResult invokeLL;
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, viewConfiguration, context)) == null) {
            if (Build.VERSION.SDK_INT >= 25 && (method = sGetScaledScrollFactorMethod) != null) {
                try {
                    return ((Integer) method.invoke(viewConfiguration, new Object[0])).intValue();
                } catch (Exception unused) {
                }
            }
            TypedValue typedValue = new TypedValue();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                return typedValue.getDimension(context.getResources().getDisplayMetrics());
            }
            return 0.0f;
        }
        return invokeLL.floatValue;
    }

    public static float getScaledHorizontalScrollFactor(@NonNull ViewConfiguration viewConfiguration, @NonNull Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, viewConfiguration, context)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return viewConfiguration.getScaledHorizontalScrollFactor();
            }
            return getLegacyScrollFactor(viewConfiguration, context);
        }
        return invokeLL.floatValue;
    }

    public static int getScaledHoverSlop(ViewConfiguration viewConfiguration) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, viewConfiguration)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return viewConfiguration.getScaledHoverSlop();
            }
            return viewConfiguration.getScaledTouchSlop() / 2;
        }
        return invokeL.intValue;
    }

    @Deprecated
    public static int getScaledPagingTouchSlop(ViewConfiguration viewConfiguration) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, viewConfiguration)) == null) ? viewConfiguration.getScaledPagingTouchSlop() : invokeL.intValue;
    }

    public static float getScaledVerticalScrollFactor(@NonNull ViewConfiguration viewConfiguration, @NonNull Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, viewConfiguration, context)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return viewConfiguration.getScaledVerticalScrollFactor();
            }
            return getLegacyScrollFactor(viewConfiguration, context);
        }
        return invokeLL.floatValue;
    }

    @Deprecated
    public static boolean hasPermanentMenuKey(ViewConfiguration viewConfiguration) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, viewConfiguration)) == null) ? viewConfiguration.hasPermanentMenuKey() : invokeL.booleanValue;
    }

    public static boolean shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration viewConfiguration, @NonNull Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, viewConfiguration, context)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
            }
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
            return identifier != 0 && resources.getBoolean(identifier);
        }
        return invokeLL.booleanValue;
    }
}
