package androidx.constraintlayout.motion.utils;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
/* loaded from: classes.dex */
public class HyperSpline {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public double[][] mCtl;
    public Cubic[][] mCurve;
    public double[] mCurveLength;
    public int mDimensionality;
    public int mPoints;
    public double mTotalLength;

    /* loaded from: classes.dex */
    public static class Cubic {
        public static /* synthetic */ Interceptable $ic = null;
        public static final double HALF = 0.5d;
        public static final double THIRD = 0.3333333333333333d;
        public transient /* synthetic */ FieldHolder $fh;
        public double mA;
        public double mB;
        public double mC;
        public double mD;

        public Cubic(double d2, double d3, double d4, double d5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mA = d2;
            this.mB = d3;
            this.mC = d4;
            this.mD = d5;
        }

        public double eval(double d2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d2)})) == null) ? (((((this.mD * d2) + this.mC) * d2) + this.mB) * d2) + this.mA : invokeCommon.doubleValue;
        }

        public double vel(double d2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d2)})) == null) ? (((this.mD * 0.3333333333333333d * d2) + (this.mC * 0.5d)) * d2) + this.mB : invokeCommon.doubleValue;
        }
    }

    public HyperSpline(double[][] dArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        setup(dArr);
    }

    public static Cubic[] calcNaturalCubic(int i2, double[] dArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i2, dArr)) == null) {
            double[] dArr2 = new double[i2];
            double[] dArr3 = new double[i2];
            double[] dArr4 = new double[i2];
            int i3 = i2 - 1;
            int i4 = 0;
            dArr2[0] = 0.5d;
            int i5 = 1;
            for (int i6 = 1; i6 < i3; i6++) {
                dArr2[i6] = 1.0d / (4.0d - dArr2[i6 - 1]);
            }
            int i7 = i3 - 1;
            dArr2[i3] = 1.0d / (2.0d - dArr2[i7]);
            dArr3[0] = (dArr[1] - dArr[0]) * 3.0d * dArr2[0];
            while (i5 < i3) {
                int i8 = i5 + 1;
                int i9 = i5 - 1;
                dArr3[i5] = (((dArr[i8] - dArr[i9]) * 3.0d) - dArr3[i9]) * dArr2[i5];
                i5 = i8;
            }
            dArr3[i3] = (((dArr[i3] - dArr[i7]) * 3.0d) - dArr3[i7]) * dArr2[i3];
            dArr4[i3] = dArr3[i3];
            while (i7 >= 0) {
                dArr4[i7] = dArr3[i7] - (dArr2[i7] * dArr4[i7 + 1]);
                i7--;
            }
            Cubic[] cubicArr = new Cubic[i3];
            while (i4 < i3) {
                int i10 = i4 + 1;
                cubicArr[i4] = new Cubic((float) dArr[i4], dArr4[i4], (((dArr[i10] - dArr[i4]) * 3.0d) - (dArr4[i4] * 2.0d)) - dArr4[i10], ((dArr[i4] - dArr[i10]) * 2.0d) + dArr4[i4] + dArr4[i10]);
                i4 = i10;
            }
            return cubicArr;
        }
        return (Cubic[]) invokeIL.objValue;
    }

    public double approxLength(Cubic[] cubicArr) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cubicArr)) == null) {
            int length = cubicArr.length;
            double[] dArr = new double[cubicArr.length];
            double d2 = 0.0d;
            double d3 = 0.0d;
            double d4 = 0.0d;
            while (true) {
                i2 = 0;
                if (d3 >= 1.0d) {
                    break;
                }
                double d5 = 0.0d;
                while (i2 < cubicArr.length) {
                    double d6 = dArr[i2];
                    double eval = cubicArr[i2].eval(d3);
                    dArr[i2] = eval;
                    double d7 = d6 - eval;
                    d5 += d7 * d7;
                    i2++;
                }
                if (d3 > 0.0d) {
                    d4 += Math.sqrt(d5);
                }
                d3 += 0.1d;
            }
            while (i2 < cubicArr.length) {
                double d8 = dArr[i2];
                double eval2 = cubicArr[i2].eval(1.0d);
                dArr[i2] = eval2;
                double d9 = d8 - eval2;
                d2 += d9 * d9;
                i2++;
            }
            return d4 + Math.sqrt(d2);
        }
        return invokeL.doubleValue;
    }

    public void getPos(double d2, double[] dArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d2), dArr}) == null) {
            double d3 = d2 * this.mTotalLength;
            int i2 = 0;
            while (true) {
                double[] dArr2 = this.mCurveLength;
                if (i2 >= dArr2.length - 1 || dArr2[i2] >= d3) {
                    break;
                }
                d3 -= dArr2[i2];
                i2++;
            }
            for (int i3 = 0; i3 < dArr.length; i3++) {
                dArr[i3] = this.mCurve[i3][i2].eval(d3 / this.mCurveLength[i2]);
            }
        }
    }

    public void getVelocity(double d2, double[] dArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Double.valueOf(d2), dArr}) == null) {
            double d3 = d2 * this.mTotalLength;
            int i2 = 0;
            while (true) {
                double[] dArr2 = this.mCurveLength;
                if (i2 >= dArr2.length - 1 || dArr2[i2] >= d3) {
                    break;
                }
                d3 -= dArr2[i2];
                i2++;
            }
            for (int i3 = 0; i3 < dArr.length; i3++) {
                dArr[i3] = this.mCurve[i3][i2].vel(d3 / this.mCurveLength[i2]);
            }
        }
    }

    public void setup(double[][] dArr) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dArr) == null) {
            int length = dArr[0].length;
            this.mDimensionality = length;
            int length2 = dArr.length;
            this.mPoints = length2;
            this.mCtl = (double[][]) Array.newInstance(double.class, length, length2);
            this.mCurve = new Cubic[this.mDimensionality];
            for (int i3 = 0; i3 < this.mDimensionality; i3++) {
                for (int i4 = 0; i4 < this.mPoints; i4++) {
                    this.mCtl[i3][i4] = dArr[i4][i3];
                }
            }
            int i5 = 0;
            while (true) {
                i2 = this.mDimensionality;
                if (i5 >= i2) {
                    break;
                }
                Cubic[][] cubicArr = this.mCurve;
                double[][] dArr2 = this.mCtl;
                cubicArr[i5] = calcNaturalCubic(dArr2[i5].length, dArr2[i5]);
                i5++;
            }
            this.mCurveLength = new double[this.mPoints - 1];
            this.mTotalLength = 0.0d;
            Cubic[] cubicArr2 = new Cubic[i2];
            for (int i6 = 0; i6 < this.mCurveLength.length; i6++) {
                for (int i7 = 0; i7 < this.mDimensionality; i7++) {
                    cubicArr2[i7] = this.mCurve[i7][i6];
                }
                double d2 = this.mTotalLength;
                double[] dArr3 = this.mCurveLength;
                double approxLength = approxLength(cubicArr2);
                dArr3[i6] = approxLength;
                this.mTotalLength = d2 + approxLength;
            }
        }
    }

    public HyperSpline() {
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

    public void getPos(double d2, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Double.valueOf(d2), fArr}) == null) {
            double d3 = d2 * this.mTotalLength;
            int i2 = 0;
            while (true) {
                double[] dArr = this.mCurveLength;
                if (i2 >= dArr.length - 1 || dArr[i2] >= d3) {
                    break;
                }
                d3 -= dArr[i2];
                i2++;
            }
            for (int i3 = 0; i3 < fArr.length; i3++) {
                fArr[i3] = (float) this.mCurve[i3][i2].eval(d3 / this.mCurveLength[i2]);
            }
        }
    }

    public double getPos(double d2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d2), Integer.valueOf(i2)})) == null) {
            double d3 = d2 * this.mTotalLength;
            int i3 = 0;
            while (true) {
                double[] dArr = this.mCurveLength;
                if (i3 >= dArr.length - 1 || dArr[i3] >= d3) {
                    break;
                }
                d3 -= dArr[i3];
                i3++;
            }
            return this.mCurve[i2][i3].eval(d3 / this.mCurveLength[i3]);
        }
        return invokeCommon.doubleValue;
    }
}
