package androidx.core.widget;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class PopupWindowCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PopupWindowCompatApi21";
    public static Method sGetWindowLayoutTypeMethod;
    public static boolean sGetWindowLayoutTypeMethodAttempted;
    public static Field sOverlapAnchorField;
    public static boolean sOverlapAnchorFieldAttempted;
    public static Method sSetWindowLayoutTypeMethod;
    public static boolean sSetWindowLayoutTypeMethodAttempted;
    public transient /* synthetic */ FieldHolder $fh;

    public PopupWindowCompat() {
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

    public static boolean getOverlapAnchor(@NonNull PopupWindow popupWindow) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, popupWindow)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                return popupWindow.getOverlapAnchor();
            }
            if (i2 >= 21) {
                if (!sOverlapAnchorFieldAttempted) {
                    try {
                        Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                        sOverlapAnchorField = declaredField;
                        declaredField.setAccessible(true);
                    } catch (NoSuchFieldException e2) {
                        Log.i(TAG, "Could not fetch mOverlapAnchor field from PopupWindow", e2);
                    }
                    sOverlapAnchorFieldAttempted = true;
                }
                Field field = sOverlapAnchorField;
                if (field != null) {
                    try {
                        return ((Boolean) field.get(popupWindow)).booleanValue();
                    } catch (IllegalAccessException e3) {
                        Log.i(TAG, "Could not get overlap anchor field in PopupWindow", e3);
                        return false;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int getWindowLayoutType(@NonNull PopupWindow popupWindow) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, popupWindow)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return popupWindow.getWindowLayoutType();
            }
            if (!sGetWindowLayoutTypeMethodAttempted) {
                try {
                    Method declaredMethod = PopupWindow.class.getDeclaredMethod("getWindowLayoutType", new Class[0]);
                    sGetWindowLayoutTypeMethod = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Exception unused) {
                }
                sGetWindowLayoutTypeMethodAttempted = true;
            }
            Method method = sGetWindowLayoutTypeMethod;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(popupWindow, new Object[0])).intValue();
                } catch (Exception unused2) {
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void setOverlapAnchor(@NonNull PopupWindow popupWindow, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65539, null, popupWindow, z) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                popupWindow.setOverlapAnchor(z);
            } else if (i2 >= 21) {
                if (!sOverlapAnchorFieldAttempted) {
                    try {
                        Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                        sOverlapAnchorField = declaredField;
                        declaredField.setAccessible(true);
                    } catch (NoSuchFieldException e2) {
                        Log.i(TAG, "Could not fetch mOverlapAnchor field from PopupWindow", e2);
                    }
                    sOverlapAnchorFieldAttempted = true;
                }
                Field field = sOverlapAnchorField;
                if (field != null) {
                    try {
                        field.set(popupWindow, Boolean.valueOf(z));
                    } catch (IllegalAccessException e3) {
                        Log.i(TAG, "Could not set overlap anchor field in PopupWindow", e3);
                    }
                }
            }
        }
    }

    public static void setWindowLayoutType(@NonNull PopupWindow popupWindow, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, popupWindow, i2) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                popupWindow.setWindowLayoutType(i2);
                return;
            }
            if (!sSetWindowLayoutTypeMethodAttempted) {
                try {
                    Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                    sSetWindowLayoutTypeMethod = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Exception unused) {
                }
                sSetWindowLayoutTypeMethodAttempted = true;
            }
            Method method = sSetWindowLayoutTypeMethod;
            if (method != null) {
                try {
                    method.invoke(popupWindow, Integer.valueOf(i2));
                } catch (Exception unused2) {
                }
            }
        }
    }

    public static void showAsDropDown(@NonNull PopupWindow popupWindow, @NonNull View view, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{popupWindow, view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                popupWindow.showAsDropDown(view, i2, i3, i4);
                return;
            }
            if ((GravityCompat.getAbsoluteGravity(i4, ViewCompat.getLayoutDirection(view)) & 7) == 5) {
                i2 -= popupWindow.getWidth() - view.getWidth();
            }
            popupWindow.showAsDropDown(view, i2, i3);
        }
    }
}
