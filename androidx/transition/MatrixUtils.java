package androidx.transition;

import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class MatrixUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final Matrix IDENTITY_MATRIX;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1543317621, "Landroidx/transition/MatrixUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1543317621, "Landroidx/transition/MatrixUtils;");
                return;
            }
        }
        IDENTITY_MATRIX = new Matrix() { // from class: androidx.transition.MatrixUtils.1
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

            public void oops() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    throw new IllegalStateException("Matrix can not be modified");
                }
            }

            @Override // android.graphics.Matrix
            public boolean postConcat(Matrix matrix) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, matrix)) == null) {
                    oops();
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // android.graphics.Matrix
            public boolean postRotate(float f2, float f3, float f4) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048579, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
                    oops();
                    return false;
                }
                return invokeCommon.booleanValue;
            }

            @Override // android.graphics.Matrix
            public boolean postScale(float f2, float f3, float f4, float f5) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048581, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
                    oops();
                    return false;
                }
                return invokeCommon.booleanValue;
            }

            @Override // android.graphics.Matrix
            public boolean postSkew(float f2, float f3, float f4, float f5) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048583, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
                    oops();
                    return false;
                }
                return invokeCommon.booleanValue;
            }

            @Override // android.graphics.Matrix
            public boolean postTranslate(float f2, float f3) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                    oops();
                    return false;
                }
                return invokeCommon.booleanValue;
            }

            @Override // android.graphics.Matrix
            public boolean preConcat(Matrix matrix) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048585, this, matrix)) == null) {
                    oops();
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // android.graphics.Matrix
            public boolean preRotate(float f2, float f3, float f4) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048587, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
                    oops();
                    return false;
                }
                return invokeCommon.booleanValue;
            }

            @Override // android.graphics.Matrix
            public boolean preScale(float f2, float f3, float f4, float f5) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048589, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
                    oops();
                    return false;
                }
                return invokeCommon.booleanValue;
            }

            @Override // android.graphics.Matrix
            public boolean preSkew(float f2, float f3, float f4, float f5) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048591, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
                    oops();
                    return false;
                }
                return invokeCommon.booleanValue;
            }

            @Override // android.graphics.Matrix
            public boolean preTranslate(float f2, float f3) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048592, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                    oops();
                    return false;
                }
                return invokeCommon.booleanValue;
            }

            @Override // android.graphics.Matrix
            public void reset() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048593, this) == null) {
                    oops();
                }
            }

            @Override // android.graphics.Matrix
            public void set(Matrix matrix) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048594, this, matrix) == null) {
                    oops();
                }
            }

            @Override // android.graphics.Matrix
            public boolean setConcat(Matrix matrix, Matrix matrix2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048595, this, matrix, matrix2)) == null) {
                    oops();
                    return false;
                }
                return invokeLL.booleanValue;
            }

            @Override // android.graphics.Matrix
            public boolean setPolyToPoly(float[] fArr, int i, float[] fArr2, int i2, int i3) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048596, this, new Object[]{fArr, Integer.valueOf(i), fArr2, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
                    oops();
                    return false;
                }
                return invokeCommon.booleanValue;
            }

            @Override // android.graphics.Matrix
            public boolean setRectToRect(RectF rectF, RectF rectF2, Matrix.ScaleToFit scaleToFit) {
                InterceptResult invokeLLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048597, this, rectF, rectF2, scaleToFit)) == null) {
                    oops();
                    return false;
                }
                return invokeLLL.booleanValue;
            }

            @Override // android.graphics.Matrix
            public void setRotate(float f2, float f3, float f4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048599, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
                    oops();
                }
            }

            @Override // android.graphics.Matrix
            public void setScale(float f2, float f3, float f4, float f5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048601, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
                    oops();
                }
            }

            @Override // android.graphics.Matrix
            public void setSinCos(float f2, float f3, float f4, float f5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048603, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
                    oops();
                }
            }

            @Override // android.graphics.Matrix
            public void setSkew(float f2, float f3, float f4, float f5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048605, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
                    oops();
                }
            }

            @Override // android.graphics.Matrix
            public void setTranslate(float f2, float f3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048606, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                    oops();
                }
            }

            @Override // android.graphics.Matrix
            public void setValues(float[] fArr) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048607, this, fArr) == null) {
                    oops();
                }
            }

            @Override // android.graphics.Matrix
            public boolean postRotate(float f2) {
                InterceptResult invokeF;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeF = interceptable2.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2)) == null) {
                    oops();
                    return false;
                }
                return invokeF.booleanValue;
            }

            @Override // android.graphics.Matrix
            public boolean postScale(float f2, float f3) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048580, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                    oops();
                    return false;
                }
                return invokeCommon.booleanValue;
            }

            @Override // android.graphics.Matrix
            public boolean postSkew(float f2, float f3) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048582, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                    oops();
                    return false;
                }
                return invokeCommon.booleanValue;
            }

            @Override // android.graphics.Matrix
            public boolean preRotate(float f2) {
                InterceptResult invokeF;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeF = interceptable2.invokeF(1048586, this, f2)) == null) {
                    oops();
                    return false;
                }
                return invokeF.booleanValue;
            }

            @Override // android.graphics.Matrix
            public boolean preScale(float f2, float f3) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048588, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                    oops();
                    return false;
                }
                return invokeCommon.booleanValue;
            }

            @Override // android.graphics.Matrix
            public boolean preSkew(float f2, float f3) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048590, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                    oops();
                    return false;
                }
                return invokeCommon.booleanValue;
            }

            @Override // android.graphics.Matrix
            public void setRotate(float f2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeF(1048598, this, f2) == null) {
                    oops();
                }
            }

            @Override // android.graphics.Matrix
            public void setScale(float f2, float f3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048600, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                    oops();
                }
            }

            @Override // android.graphics.Matrix
            public void setSinCos(float f2, float f3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048602, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                    oops();
                }
            }

            @Override // android.graphics.Matrix
            public void setSkew(float f2, float f3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048604, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                    oops();
                }
            }
        };
    }

    public MatrixUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
