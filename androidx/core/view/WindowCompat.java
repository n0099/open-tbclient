package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class WindowCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FEATURE_ACTION_BAR = 8;
    public static final int FEATURE_ACTION_BAR_OVERLAY = 9;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;
    public transient /* synthetic */ FieldHolder $fh;

    @RequiresApi(16)
    /* loaded from: classes.dex */
    public static class Impl16 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Impl16() {
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

        public static void setDecorFitsSystemWindows(@NonNull Window window, boolean z) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(65537, null, window, z) == null) {
                View decorView = window.getDecorView();
                int systemUiVisibility = decorView.getSystemUiVisibility();
                if (z) {
                    i = systemUiVisibility & (-1793);
                } else {
                    i = systemUiVisibility | 1792;
                }
                decorView.setSystemUiVisibility(i);
            }
        }
    }

    @RequiresApi(30)
    /* loaded from: classes.dex */
    public static class Impl30 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Impl30() {
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

        public static WindowInsetsControllerCompat getInsetsController(@NonNull Window window) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, window)) == null) {
                WindowInsetsController insetsController = window.getInsetsController();
                if (insetsController != null) {
                    return WindowInsetsControllerCompat.toWindowInsetsControllerCompat(insetsController);
                }
                return null;
            }
            return (WindowInsetsControllerCompat) invokeL.objValue;
        }

        public static void setDecorFitsSystemWindows(@NonNull Window window, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(65538, null, window, z) == null) {
                window.setDecorFitsSystemWindows(z);
            }
        }
    }

    public WindowCompat() {
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
    public static WindowInsetsControllerCompat getInsetsController(@NonNull Window window, @NonNull View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, window, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                return Impl30.getInsetsController(window);
            }
            return new WindowInsetsControllerCompat(window, view2);
        }
        return (WindowInsetsControllerCompat) invokeLL.objValue;
    }

    @NonNull
    public static <T extends View> T requireViewById(@NonNull Window window, @IdRes int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, window, i)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return (T) window.requireViewById(i);
            }
            T t = (T) window.findViewById(i);
            if (t != null) {
                return t;
            }
            throw new IllegalArgumentException("ID does not reference a View inside this Window");
        }
        return (T) invokeLI.objValue;
    }

    public static void setDecorFitsSystemWindows(@NonNull Window window, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65539, null, window, z) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                Impl30.setDecorFitsSystemWindows(window, z);
            } else if (i >= 16) {
                Impl16.setDecorFitsSystemWindows(window, z);
            }
        }
    }
}
