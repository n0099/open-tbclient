package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class ViewGroupUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static Method sGetChildDrawingOrderMethod = null;
    public static boolean sGetChildDrawingOrderMethodFetched = false;
    public static boolean sTryHiddenSuppressLayout = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-854215068, "Landroidx/transition/ViewGroupUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-854215068, "Landroidx/transition/ViewGroupUtils;");
        }
    }

    public ViewGroupUtils() {
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

    public static int getChildDrawingOrder(@NonNull ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, viewGroup, i2)) == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                return viewGroup.getChildDrawingOrder(i2);
            }
            if (!sGetChildDrawingOrderMethodFetched) {
                try {
                    Method declaredMethod = ViewGroup.class.getDeclaredMethod("getChildDrawingOrder", Integer.TYPE, Integer.TYPE);
                    sGetChildDrawingOrderMethod = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                }
                sGetChildDrawingOrderMethodFetched = true;
            }
            Method method = sGetChildDrawingOrderMethod;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(viewGroup, Integer.valueOf(viewGroup.getChildCount()), Integer.valueOf(i2))).intValue();
                } catch (IllegalAccessException | InvocationTargetException unused2) {
                }
            }
            return i2;
        }
        return invokeLI.intValue;
    }

    public static ViewGroupOverlayImpl getOverlay(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, viewGroup)) == null) {
            if (Build.VERSION.SDK_INT >= 18) {
                return new ViewGroupOverlayApi18(viewGroup);
            }
            return ViewGroupOverlayApi14.createFrom(viewGroup);
        }
        return (ViewGroupOverlayImpl) invokeL.objValue;
    }

    @RequiresApi(18)
    @SuppressLint({"NewApi"})
    public static void hiddenSuppressLayout(@NonNull ViewGroup viewGroup, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, viewGroup, z) == null) && sTryHiddenSuppressLayout) {
            try {
                viewGroup.suppressLayout(z);
            } catch (NoSuchMethodError unused) {
                sTryHiddenSuppressLayout = false;
            }
        }
    }

    public static void suppressLayout(@NonNull ViewGroup viewGroup, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65541, null, viewGroup, z) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                viewGroup.suppressLayout(z);
            } else if (i2 >= 18) {
                hiddenSuppressLayout(viewGroup, z);
            } else {
                ViewGroupUtilsApi14.suppressLayout(viewGroup, z);
            }
        }
    }
}
