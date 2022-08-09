package androidx.constraintlayout.motion.utils;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
/* loaded from: classes.dex */
public class MonotonicCurveFit extends CurveFit {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MonotonicCurveFit";
    public transient /* synthetic */ FieldHolder $fh;
    public double[] mT;
    public double[][] mTangent;
    public double[][] mY;

    public MonotonicCurveFit(double[] dArr, double[][] dArr2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {dArr, dArr2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        int length = dArr.length;
        int length2 = dArr2[0].length;
        int i3 = length - 1;
        double[][] dArr3 = (double[][]) Array.newInstance(double.class, i3, length2);
        double[][] dArr4 = (double[][]) Array.newInstance(double.class, length, length2);
        for (int i4 = 0; i4 < length2; i4++) {
            int i5 = 0;
            while (i5 < i3) {
                int i6 = i5 + 1;
                dArr3[i5][i4] = (dArr2[i6][i4] - dArr2[i5][i4]) / (dArr[i6] - dArr[i5]);
                if (i5 == 0) {
                    dArr4[i5][i4] = dArr3[i5][i4];
                } else {
                    dArr4[i5][i4] = (dArr3[i5 - 1][i4] + dArr3[i5][i4]) * 0.5d;
                }
                i5 = i6;
            }
            dArr4[i3][i4] = dArr3[length - 2][i4];
        }
        for (int i7 = 0; i7 < i3; i7++) {
            for (int i8 = 0; i8 < length2; i8++) {
                if (dArr3[i7][i8] == 0.0d) {
                    dArr4[i7][i8] = 0.0d;
                    dArr4[i7 + 1][i8] = 0.0d;
                } else {
                    double d = dArr4[i7][i8] / dArr3[i7][i8];
                    int i9 = i7 + 1;
                    double d2 = dArr4[i9][i8] / dArr3[i7][i8];
                    double hypot = Math.hypot(d, d2);
                    if (hypot > 9.0d) {
                        double d3 = 3.0d / hypot;
                        dArr4[i7][i8] = d * d3 * dArr3[i7][i8];
                        dArr4[i9][i8] = d3 * d2 * dArr3[i7][i8];
                    }
                }
            }
        }
        this.mT = dArr;
        this.mY = dArr2;
        this.mTangent = dArr4;
    }

    public static double diff(double d, double d2, double d3, double d4, double d5, double d6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5), Double.valueOf(d6)})) == null) {
            double d7 = d2 * d2;
            double d8 = d2 * 6.0d;
            double d9 = 3.0d * d;
            return ((((((((((-6.0d) * d7) * d4) + (d8 * d4)) + ((6.0d * d7) * d3)) - (d8 * d3)) + ((d9 * d6) * d7)) + ((d9 * d5) * d7)) - (((2.0d * d) * d6) * d2)) - (((4.0d * d) * d5) * d2)) + (d * d5);
        }
        return invokeCommon.doubleValue;
    }

    public static double interpolate(double d, double d2, double d3, double d4, double d5, double d6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5), Double.valueOf(d6)})) == null) {
            double d7 = d2 * d2;
            double d8 = d7 * d2;
            double d9 = 3.0d * d7;
            double d10 = d * d6;
            double d11 = d * d5;
            return (((((((((((-2.0d) * d8) * d4) + (d9 * d4)) + ((d8 * 2.0d) * d3)) - (d9 * d3)) + d3) + (d10 * d8)) + (d8 * d11)) - (d10 * d7)) - (((d * 2.0d) * d5) * d7)) + (d11 * d2);
        }
        return invokeCommon.doubleValue;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d, double[] dArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d), dArr}) == null) {
            double[] dArr2 = this.mT;
            int length = dArr2.length;
            int i = 0;
            int length2 = this.mY[0].length;
            if (d <= dArr2[0]) {
                for (int i2 = 0; i2 < length2; i2++) {
                    dArr[i2] = this.mY[0][i2];
                }
                return;
            }
            int i3 = length - 1;
            if (d >= dArr2[i3]) {
                while (i < length2) {
                    dArr[i] = this.mY[i3][i];
                    i++;
                }
                return;
            }
            int i4 = 0;
            while (i4 < i3) {
                if (d == this.mT[i4]) {
                    for (int i5 = 0; i5 < length2; i5++) {
                        dArr[i5] = this.mY[i4][i5];
                    }
                }
                double[] dArr3 = this.mT;
                int i6 = i4 + 1;
                if (d < dArr3[i6]) {
                    double d2 = dArr3[i6] - dArr3[i4];
                    double d3 = (d - dArr3[i4]) / d2;
                    while (i < length2) {
                        double[][] dArr4 = this.mY;
                        double d4 = dArr4[i4][i];
                        double d5 = dArr4[i6][i];
                        double[][] dArr5 = this.mTangent;
                        dArr[i] = interpolate(d2, d3, d4, d5, dArr5[i4][i], dArr5[i6][i]);
                        i++;
                    }
                    return;
                }
                i4 = i6;
            }
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getSlope(double d, double[] dArr) {
        double d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Double.valueOf(d), dArr}) == null) {
            double[] dArr2 = this.mT;
            int length = dArr2.length;
            int length2 = this.mY[0].length;
            if (d <= dArr2[0]) {
                d2 = dArr2[0];
            } else {
                int i = length - 1;
                d2 = d >= dArr2[i] ? dArr2[i] : d;
            }
            int i2 = 0;
            while (i2 < length - 1) {
                double[] dArr3 = this.mT;
                int i3 = i2 + 1;
                if (d2 <= dArr3[i3]) {
                    double d3 = dArr3[i3] - dArr3[i2];
                    double d4 = (d2 - dArr3[i2]) / d3;
                    for (int i4 = 0; i4 < length2; i4++) {
                        double[][] dArr4 = this.mY;
                        double d5 = dArr4[i2][i4];
                        double d6 = dArr4[i3][i4];
                        double[][] dArr5 = this.mTangent;
                        dArr[i4] = diff(d3, d4, d5, d6, dArr5[i2][i4], dArr5[i3][i4]) / d3;
                    }
                    return;
                }
                i2 = i3;
            }
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double[] getTimePoints() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mT : (double[]) invokeV.objValue;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getSlope(double d, int i) {
        InterceptResult invokeCommon;
        double d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Double.valueOf(d), Integer.valueOf(i)})) == null) {
            double[] dArr = this.mT;
            int length = dArr.length;
            int i2 = 0;
            if (d < dArr[0]) {
                d2 = dArr[0];
            } else {
                int i3 = length - 1;
                d2 = d >= dArr[i3] ? dArr[i3] : d;
            }
            while (i2 < length - 1) {
                double[] dArr2 = this.mT;
                int i4 = i2 + 1;
                if (d2 <= dArr2[i4]) {
                    double d3 = dArr2[i4] - dArr2[i2];
                    double[][] dArr3 = this.mY;
                    double d4 = dArr3[i2][i];
                    double d5 = dArr3[i4][i];
                    double[][] dArr4 = this.mTangent;
                    return diff(d3, (d2 - dArr2[i2]) / d3, d4, d5, dArr4[i2][i], dArr4[i4][i]) / d3;
                }
                i2 = i4;
            }
            return 0.0d;
        }
        return invokeCommon.doubleValue;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d), fArr}) == null) {
            double[] dArr = this.mT;
            int length = dArr.length;
            int i = 0;
            int length2 = this.mY[0].length;
            if (d <= dArr[0]) {
                for (int i2 = 0; i2 < length2; i2++) {
                    fArr[i2] = (float) this.mY[0][i2];
                }
                return;
            }
            int i3 = length - 1;
            if (d >= dArr[i3]) {
                while (i < length2) {
                    fArr[i] = (float) this.mY[i3][i];
                    i++;
                }
                return;
            }
            int i4 = 0;
            while (i4 < i3) {
                if (d == this.mT[i4]) {
                    for (int i5 = 0; i5 < length2; i5++) {
                        fArr[i5] = (float) this.mY[i4][i5];
                    }
                }
                double[] dArr2 = this.mT;
                int i6 = i4 + 1;
                if (d < dArr2[i6]) {
                    double d2 = dArr2[i6] - dArr2[i4];
                    double d3 = (d - dArr2[i4]) / d2;
                    while (i < length2) {
                        double[][] dArr3 = this.mY;
                        double d4 = dArr3[i4][i];
                        double d5 = dArr3[i6][i];
                        double[][] dArr4 = this.mTangent;
                        fArr[i] = (float) interpolate(d2, d3, d4, d5, dArr4[i4][i], dArr4[i6][i]);
                        i++;
                    }
                    return;
                }
                i4 = i6;
            }
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getPos(double d, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d), Integer.valueOf(i)})) == null) {
            double[] dArr = this.mT;
            int length = dArr.length;
            int i2 = 0;
            if (d <= dArr[0]) {
                return this.mY[0][i];
            }
            int i3 = length - 1;
            if (d >= dArr[i3]) {
                return this.mY[i3][i];
            }
            while (i2 < i3) {
                double[] dArr2 = this.mT;
                if (d == dArr2[i2]) {
                    return this.mY[i2][i];
                }
                int i4 = i2 + 1;
                if (d < dArr2[i4]) {
                    double d2 = dArr2[i4] - dArr2[i2];
                    double d3 = (d - dArr2[i2]) / d2;
                    double[][] dArr3 = this.mY;
                    double d4 = dArr3[i2][i];
                    double d5 = dArr3[i4][i];
                    double[][] dArr4 = this.mTangent;
                    return interpolate(d2, d3, d4, d5, dArr4[i2][i], dArr4[i4][i]);
                }
                i2 = i4;
            }
            return 0.0d;
        }
        return invokeCommon.doubleValue;
    }
}
