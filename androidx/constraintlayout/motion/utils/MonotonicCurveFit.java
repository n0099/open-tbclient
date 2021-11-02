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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        int length = dArr.length;
        int length2 = dArr2[0].length;
        int i4 = length - 1;
        double[][] dArr3 = (double[][]) Array.newInstance(double.class, i4, length2);
        double[][] dArr4 = (double[][]) Array.newInstance(double.class, length, length2);
        for (int i5 = 0; i5 < length2; i5++) {
            int i6 = 0;
            while (i6 < i4) {
                int i7 = i6 + 1;
                dArr3[i6][i5] = (dArr2[i7][i5] - dArr2[i6][i5]) / (dArr[i7] - dArr[i6]);
                if (i6 == 0) {
                    dArr4[i6][i5] = dArr3[i6][i5];
                } else {
                    dArr4[i6][i5] = (dArr3[i6 - 1][i5] + dArr3[i6][i5]) * 0.5d;
                }
                i6 = i7;
            }
            dArr4[i4][i5] = dArr3[length - 2][i5];
        }
        for (int i8 = 0; i8 < i4; i8++) {
            for (int i9 = 0; i9 < length2; i9++) {
                if (dArr3[i8][i9] == 0.0d) {
                    dArr4[i8][i9] = 0.0d;
                    dArr4[i8 + 1][i9] = 0.0d;
                } else {
                    double d2 = dArr4[i8][i9] / dArr3[i8][i9];
                    int i10 = i8 + 1;
                    double d3 = dArr4[i10][i9] / dArr3[i8][i9];
                    double hypot = Math.hypot(d2, d3);
                    if (hypot > 9.0d) {
                        double d4 = 3.0d / hypot;
                        dArr4[i8][i9] = d2 * d4 * dArr3[i8][i9];
                        dArr4[i10][i9] = d4 * d3 * dArr3[i8][i9];
                    }
                }
            }
        }
        this.mT = dArr;
        this.mY = dArr2;
        this.mTangent = dArr4;
    }

    public static double diff(double d2, double d3, double d4, double d5, double d6, double d7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5), Double.valueOf(d6), Double.valueOf(d7)})) == null) {
            double d8 = d3 * d3;
            double d9 = d3 * 6.0d;
            double d10 = 3.0d * d2;
            return ((((((((((-6.0d) * d8) * d5) + (d9 * d5)) + ((6.0d * d8) * d4)) - (d9 * d4)) + ((d10 * d7) * d8)) + ((d10 * d6) * d8)) - (((2.0d * d2) * d7) * d3)) - (((4.0d * d2) * d6) * d3)) + (d2 * d6);
        }
        return invokeCommon.doubleValue;
    }

    public static double interpolate(double d2, double d3, double d4, double d5, double d6, double d7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5), Double.valueOf(d6), Double.valueOf(d7)})) == null) {
            double d8 = d3 * d3;
            double d9 = d8 * d3;
            double d10 = 3.0d * d8;
            double d11 = d2 * d7;
            double d12 = d2 * d6;
            return (((((((((((-2.0d) * d9) * d5) + (d10 * d5)) + ((d9 * 2.0d) * d4)) - (d10 * d4)) + d4) + (d11 * d9)) + (d9 * d12)) - (d11 * d8)) - (((d2 * 2.0d) * d6) * d8)) + (d12 * d3);
        }
        return invokeCommon.doubleValue;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d2, double[] dArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d2), dArr}) == null) {
            double[] dArr2 = this.mT;
            int length = dArr2.length;
            int i2 = 0;
            int length2 = this.mY[0].length;
            if (d2 <= dArr2[0]) {
                for (int i3 = 0; i3 < length2; i3++) {
                    dArr[i3] = this.mY[0][i3];
                }
                return;
            }
            int i4 = length - 1;
            if (d2 >= dArr2[i4]) {
                while (i2 < length2) {
                    dArr[i2] = this.mY[i4][i2];
                    i2++;
                }
                return;
            }
            int i5 = 0;
            while (i5 < i4) {
                if (d2 == this.mT[i5]) {
                    for (int i6 = 0; i6 < length2; i6++) {
                        dArr[i6] = this.mY[i5][i6];
                    }
                }
                double[] dArr3 = this.mT;
                int i7 = i5 + 1;
                if (d2 < dArr3[i7]) {
                    double d3 = dArr3[i7] - dArr3[i5];
                    double d4 = (d2 - dArr3[i5]) / d3;
                    while (i2 < length2) {
                        double[][] dArr4 = this.mY;
                        double d5 = dArr4[i5][i2];
                        double d6 = dArr4[i7][i2];
                        double[][] dArr5 = this.mTangent;
                        dArr[i2] = interpolate(d3, d4, d5, d6, dArr5[i5][i2], dArr5[i7][i2]);
                        i2++;
                    }
                    return;
                }
                i5 = i7;
            }
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getSlope(double d2, double[] dArr) {
        double d3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Double.valueOf(d2), dArr}) == null) {
            double[] dArr2 = this.mT;
            int length = dArr2.length;
            int length2 = this.mY[0].length;
            if (d2 <= dArr2[0]) {
                d3 = dArr2[0];
            } else {
                int i2 = length - 1;
                d3 = d2 >= dArr2[i2] ? dArr2[i2] : d2;
            }
            int i3 = 0;
            while (i3 < length - 1) {
                double[] dArr3 = this.mT;
                int i4 = i3 + 1;
                if (d3 <= dArr3[i4]) {
                    double d4 = dArr3[i4] - dArr3[i3];
                    double d5 = (d3 - dArr3[i3]) / d4;
                    for (int i5 = 0; i5 < length2; i5++) {
                        double[][] dArr4 = this.mY;
                        double d6 = dArr4[i3][i5];
                        double d7 = dArr4[i4][i5];
                        double[][] dArr5 = this.mTangent;
                        dArr[i5] = diff(d4, d5, d6, d7, dArr5[i3][i5], dArr5[i4][i5]) / d4;
                    }
                    return;
                }
                i3 = i4;
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
    public double getSlope(double d2, int i2) {
        InterceptResult invokeCommon;
        double d3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Double.valueOf(d2), Integer.valueOf(i2)})) == null) {
            double[] dArr = this.mT;
            int length = dArr.length;
            int i3 = 0;
            if (d2 < dArr[0]) {
                d3 = dArr[0];
            } else {
                int i4 = length - 1;
                d3 = d2 >= dArr[i4] ? dArr[i4] : d2;
            }
            while (i3 < length - 1) {
                double[] dArr2 = this.mT;
                int i5 = i3 + 1;
                if (d3 <= dArr2[i5]) {
                    double d4 = dArr2[i5] - dArr2[i3];
                    double[][] dArr3 = this.mY;
                    double d5 = dArr3[i3][i2];
                    double d6 = dArr3[i5][i2];
                    double[][] dArr4 = this.mTangent;
                    return diff(d4, (d3 - dArr2[i3]) / d4, d5, d6, dArr4[i3][i2], dArr4[i5][i2]) / d4;
                }
                i3 = i5;
            }
            return 0.0d;
        }
        return invokeCommon.doubleValue;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d2, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d2), fArr}) == null) {
            double[] dArr = this.mT;
            int length = dArr.length;
            int i2 = 0;
            int length2 = this.mY[0].length;
            if (d2 <= dArr[0]) {
                for (int i3 = 0; i3 < length2; i3++) {
                    fArr[i3] = (float) this.mY[0][i3];
                }
                return;
            }
            int i4 = length - 1;
            if (d2 >= dArr[i4]) {
                while (i2 < length2) {
                    fArr[i2] = (float) this.mY[i4][i2];
                    i2++;
                }
                return;
            }
            int i5 = 0;
            while (i5 < i4) {
                if (d2 == this.mT[i5]) {
                    for (int i6 = 0; i6 < length2; i6++) {
                        fArr[i6] = (float) this.mY[i5][i6];
                    }
                }
                double[] dArr2 = this.mT;
                int i7 = i5 + 1;
                if (d2 < dArr2[i7]) {
                    double d3 = dArr2[i7] - dArr2[i5];
                    double d4 = (d2 - dArr2[i5]) / d3;
                    while (i2 < length2) {
                        double[][] dArr3 = this.mY;
                        double d5 = dArr3[i5][i2];
                        double d6 = dArr3[i7][i2];
                        double[][] dArr4 = this.mTangent;
                        fArr[i2] = (float) interpolate(d3, d4, d5, d6, dArr4[i5][i2], dArr4[i7][i2]);
                        i2++;
                    }
                    return;
                }
                i5 = i7;
            }
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getPos(double d2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d2), Integer.valueOf(i2)})) == null) {
            double[] dArr = this.mT;
            int length = dArr.length;
            int i3 = 0;
            if (d2 <= dArr[0]) {
                return this.mY[0][i2];
            }
            int i4 = length - 1;
            if (d2 >= dArr[i4]) {
                return this.mY[i4][i2];
            }
            while (i3 < i4) {
                double[] dArr2 = this.mT;
                if (d2 == dArr2[i3]) {
                    return this.mY[i3][i2];
                }
                int i5 = i3 + 1;
                if (d2 < dArr2[i5]) {
                    double d3 = dArr2[i5] - dArr2[i3];
                    double d4 = (d2 - dArr2[i3]) / d3;
                    double[][] dArr3 = this.mY;
                    double d5 = dArr3[i3][i2];
                    double d6 = dArr3[i5][i2];
                    double[][] dArr4 = this.mTangent;
                    return interpolate(d3, d4, d5, d6, dArr4[i3][i2], dArr4[i5][i2]);
                }
                i3 = i5;
            }
            return 0.0d;
        }
        return invokeCommon.doubleValue;
    }
}
