package androidx.constraintlayout.motion.utils;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class LinearCurveFit extends CurveFit {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "LinearCurveFit";
    public transient /* synthetic */ FieldHolder $fh;
    public double[] mT;
    public double mTotalLength;
    public double[][] mY;

    public LinearCurveFit(double[] dArr, double[][] dArr2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
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
        this.mTotalLength = Double.NaN;
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.mT = dArr;
        this.mY = dArr2;
        if (length2 > 2) {
            double d2 = 0.0d;
            double d3 = 0.0d;
            int i4 = 0;
            while (i4 < dArr.length) {
                double d4 = dArr2[i4][0];
                double d5 = dArr2[i4][0];
                if (i4 > 0) {
                    Math.hypot(d4 - d2, d5 - d3);
                }
                i4++;
                d2 = d4;
                d3 = d5;
            }
            this.mTotalLength = 0.0d;
        }
    }

    private double getLength2D(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Double.valueOf(d2)})) == null) {
            if (Double.isNaN(this.mTotalLength)) {
                return 0.0d;
            }
            double[] dArr = this.mT;
            int length = dArr.length;
            if (d2 <= dArr[0]) {
                return 0.0d;
            }
            int i2 = length - 1;
            if (d2 >= dArr[i2]) {
                return this.mTotalLength;
            }
            double d3 = 0.0d;
            double d4 = 0.0d;
            double d5 = 0.0d;
            int i3 = 0;
            while (i3 < i2) {
                double[][] dArr2 = this.mY;
                double d6 = dArr2[i3][0];
                double d7 = dArr2[i3][1];
                if (i3 > 0) {
                    d3 += Math.hypot(d6 - d4, d7 - d5);
                }
                double[] dArr3 = this.mT;
                if (d2 == dArr3[i3]) {
                    return d3;
                }
                int i4 = i3 + 1;
                if (d2 < dArr3[i4]) {
                    double d8 = (d2 - dArr3[i3]) / (dArr3[i4] - dArr3[i3]);
                    double[][] dArr4 = this.mY;
                    double d9 = 1.0d - d8;
                    return d3 + Math.hypot(d7 - ((dArr4[i3][1] * d9) + (dArr4[i4][1] * d8)), d6 - ((dArr4[i3][0] * d9) + (dArr4[i4][0] * d8)));
                }
                i3 = i4;
                d4 = d6;
                d5 = d7;
            }
            return 0.0d;
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
                    double d3 = (d2 - dArr3[i5]) / (dArr3[i7] - dArr3[i5]);
                    while (i2 < length2) {
                        double[][] dArr4 = this.mY;
                        dArr[i2] = (dArr4[i5][i2] * (1.0d - d3)) + (dArr4[i7][i2] * d3);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Double.valueOf(d2), dArr}) == null) {
            double[] dArr2 = this.mT;
            int length = dArr2.length;
            int length2 = this.mY[0].length;
            if (d2 <= dArr2[0]) {
                d2 = dArr2[0];
            } else {
                int i2 = length - 1;
                if (d2 >= dArr2[i2]) {
                    d2 = dArr2[i2];
                }
            }
            int i3 = 0;
            while (i3 < length - 1) {
                double[] dArr3 = this.mT;
                int i4 = i3 + 1;
                if (d2 <= dArr3[i4]) {
                    double d3 = dArr3[i4] - dArr3[i3];
                    double d4 = dArr3[i3];
                    for (int i5 = 0; i5 < length2; i5++) {
                        double[][] dArr4 = this.mY;
                        dArr[i5] = (dArr4[i4][i5] - dArr4[i3][i5]) / d3;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Double.valueOf(d2), Integer.valueOf(i2)})) == null) {
            double[] dArr = this.mT;
            int length = dArr.length;
            int i3 = 0;
            if (d2 < dArr[0]) {
                d2 = dArr[0];
            } else {
                int i4 = length - 1;
                if (d2 >= dArr[i4]) {
                    d2 = dArr[i4];
                }
            }
            while (i3 < length - 1) {
                double[] dArr2 = this.mT;
                int i5 = i3 + 1;
                if (d2 <= dArr2[i5]) {
                    double d3 = dArr2[i5] - dArr2[i3];
                    double d4 = dArr2[i3];
                    double[][] dArr3 = this.mY;
                    return (dArr3[i5][i2] - dArr3[i3][i2]) / d3;
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
                    double d3 = (d2 - dArr2[i5]) / (dArr2[i7] - dArr2[i5]);
                    while (i2 < length2) {
                        double[][] dArr3 = this.mY;
                        fArr[i2] = (float) ((dArr3[i5][i2] * (1.0d - d3)) + (dArr3[i7][i2] * d3));
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
                    double d3 = (d2 - dArr2[i3]) / (dArr2[i5] - dArr2[i3]);
                    double[][] dArr3 = this.mY;
                    return (dArr3[i3][i2] * (1.0d - d3)) + (dArr3[i5][i2] * d3);
                }
                i3 = i5;
            }
            return 0.0d;
        }
        return invokeCommon.doubleValue;
    }
}
