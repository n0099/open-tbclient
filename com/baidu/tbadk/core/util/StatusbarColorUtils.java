package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes9.dex */
public class StatusbarColorUtils {
    public static /* synthetic */ Interceptable $ic;
    public static int SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
    public static Method mSetStatusBarColorIcon;
    public static Method mSetStatusBarDarkIcon;
    public static Field mStatusBarColorFiled;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1921540140, "Lcom/baidu/tbadk/core/util/StatusbarColorUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1921540140, "Lcom/baidu/tbadk/core/util/StatusbarColorUtils;");
                return;
            }
        }
        try {
            mSetStatusBarColorIcon = Activity.class.getMethod("setStatusBarDarkIcon", Integer.TYPE);
        } catch (NoSuchMethodException unused) {
        }
        try {
            mSetStatusBarDarkIcon = Activity.class.getMethod("setStatusBarDarkIcon", Boolean.TYPE);
        } catch (NoSuchMethodException unused2) {
        }
        try {
            mStatusBarColorFiled = WindowManager.LayoutParams.class.getField("statusBarColor");
        } catch (NoSuchFieldException unused3) {
        }
        try {
            SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt(null);
        } catch (IllegalAccessException | NoSuchFieldException unused4) {
        }
    }

    public StatusbarColorUtils() {
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

    public static boolean changeMeizuFlag(WindowManager.LayoutParams layoutParams, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, layoutParams, str, z)) == null) {
            try {
                Field declaredField = layoutParams.getClass().getDeclaredField(str);
                declaredField.setAccessible(true);
                int i2 = declaredField.getInt(layoutParams);
                Field declaredField2 = layoutParams.getClass().getDeclaredField("meizuFlags");
                declaredField2.setAccessible(true);
                int i3 = declaredField2.getInt(layoutParams);
                int i4 = z ? i2 | i3 : (~i2) & i3;
                if (i3 != i4) {
                    declaredField2.setInt(layoutParams, i4);
                    return true;
                }
                return false;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return false;
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
                return false;
            } catch (NoSuchFieldException e4) {
                e4.printStackTrace();
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeLLZ.booleanValue;
    }

    public static boolean isBlackColor(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i2, i3)) == null) ? toGrey(i2) < i3 : invokeII.booleanValue;
    }

    public static void setStatusBarColor(Window window, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, window, i2) == null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            Field field = mStatusBarColorFiled;
            if (field != null) {
                try {
                    if (field.getInt(attributes) != i2) {
                        mStatusBarColorFiled.set(attributes, Integer.valueOf(i2));
                        window.setAttributes(attributes);
                    }
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void setStatusBarDarkIcon(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65541, null, activity, i2) == null) {
            Method method = mSetStatusBarColorIcon;
            if (method != null) {
                try {
                    method.invoke(activity, Integer.valueOf(i2));
                    return;
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                    return;
                } catch (InvocationTargetException e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            boolean isBlackColor = isBlackColor(i2, 50);
            if (mStatusBarColorFiled != null) {
                setStatusBarDarkIcon(activity, isBlackColor, isBlackColor);
                setStatusBarDarkIcon(activity.getWindow(), i2);
                return;
            }
            setStatusBarDarkIcon(activity, isBlackColor);
        }
    }

    public static int toGrey(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i2)) == null) ? (((((i2 & 16711680) >> 16) * 38) + (((65280 & i2) >> 8) * 75)) + ((i2 & 255) * 15)) >> 7 : invokeI.intValue;
    }

    public static void setStatusBarDarkIcon(Window window, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65545, null, window, i2) == null) {
            try {
                setStatusBarColor(window, i2);
                if (Build.VERSION.SDK_INT > 22) {
                    setStatusBarDarkIcon(window.getDecorView(), true);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void setStatusBarDarkIcon(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65542, null, activity, z) == null) {
            setStatusBarDarkIcon(activity, z, true);
        }
    }

    public static void setStatusBarDarkIcon(View view, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65544, null, view, z) == null) {
            int systemUiVisibility = view.getSystemUiVisibility();
            if (z) {
                i2 = SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | systemUiVisibility;
            } else {
                i2 = (~SYSTEM_UI_FLAG_LIGHT_STATUS_BAR) & systemUiVisibility;
            }
            if (i2 != systemUiVisibility) {
                view.setSystemUiVisibility(i2);
            }
        }
    }

    public static void setStatusBarDarkIcon(Window window, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65546, null, window, z) == null) {
            if (Build.VERSION.SDK_INT < 23) {
                changeMeizuFlag(window.getAttributes(), "MEIZU_FLAG_DARK_STATUS_BAR_ICON", z);
                return;
            }
            View decorView = window.getDecorView();
            if (decorView != null) {
                setStatusBarDarkIcon(decorView, z);
                setStatusBarColor(window, 0);
            }
        }
    }

    public static void setStatusBarDarkIcon(Activity activity, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{activity, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            Method method = mSetStatusBarDarkIcon;
            if (method == null) {
                if (z2) {
                    setStatusBarDarkIcon(activity.getWindow(), z);
                    return;
                }
                return;
            }
            try {
                method.invoke(activity, Boolean.valueOf(z));
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
    }
}
