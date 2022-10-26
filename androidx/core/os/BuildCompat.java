package androidx.core.os;

import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class BuildCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BuildCompat() {
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

    @Deprecated
    public static boolean isAtLeastN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public static boolean isAtLeastNMR1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (Build.VERSION.SDK_INT >= 25) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public static boolean isAtLeastO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public static boolean isAtLeastOMR1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (Build.VERSION.SDK_INT >= 27) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public static boolean isAtLeastP() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public static boolean isAtLeastQ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isAtLeastR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (Build.VERSION.SDK_INT < 30 && !Build.VERSION.CODENAME.equals("R")) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
