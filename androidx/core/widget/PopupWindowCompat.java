package androidx.core.widget;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean getOverlapAnchor(@NonNull PopupWindow popupWindow) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, popupWindow)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                return popupWindow.getOverlapAnchor();
            }
            if (i >= 21) {
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
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                popupWindow.setOverlapAnchor(z);
            } else if (i >= 21) {
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

    public static void setWindowLayoutType(@NonNull PopupWindow popupWindow, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, popupWindow, i) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                popupWindow.setWindowLayoutType(i);
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
                    method.invoke(popupWindow, Integer.valueOf(i));
                } catch (Exception unused2) {
                }
            }
        }
    }

    public static void showAsDropDown(@NonNull PopupWindow popupWindow, @NonNull View view, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{popupWindow, view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                popupWindow.showAsDropDown(view, i, i2, i3);
                return;
            }
            if ((GravityCompat.getAbsoluteGravity(i3, ViewCompat.getLayoutDirection(view)) & 7) == 5) {
                i -= popupWindow.getWidth() - view.getWidth();
            }
            popupWindow.showAsDropDown(view, i, i2);
        }
    }
}
