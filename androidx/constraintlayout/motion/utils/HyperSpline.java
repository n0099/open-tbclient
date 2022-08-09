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

        public Cubic(double d, double d2, double d3, double d4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mA = d;
            this.mB = d2;
            this.mC = d3;
            this.mD = d4;
        }

        public double eval(double d) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d)})) == null) ? (((((this.mD * d) + this.mC) * d) + this.mB) * d) + this.mA : invokeCommon.doubleValue;
        }

        public double vel(double d) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d)})) == null) ? (((this.mD * 0.3333333333333333d * d) + (this.mC * 0.5d)) * d) + this.mB : invokeCommon.doubleValue;
        }
    }

    public HyperSpline(double[][] dArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        setup(dArr);
    }

    public static Cubic[] calcNaturalCubic(int i, double[] dArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i, dArr)) == null) {
            double[] dArr2 = new double[i];
            double[] dArr3 = new double[i];
            double[] dArr4 = new double[i];
            int i2 = i - 1;
            int i3 = 0;
            dArr2[0] = 0.5d;
            int i4 = 1;
            for (int i5 = 1; i5 < i2; i5++) {
                dArr2[i5] = 1.0d / (4.0d - dArr2[i5 - 1]);
            }
            int i6 = i2 - 1;
            dArr2[i2] = 1.0d / (2.0d - dArr2[i6]);
            dArr3[0] = (dArr[1] - dArr[0]) * 3.0d * dArr2[0];
            while (i4 < i2) {
                int i7 = i4 + 1;
                int i8 = i4 - 1;
                dArr3[i4] = (((dArr[i7] - dArr[i8]) * 3.0d) - dArr3[i8]) * dArr2[i4];
                i4 = i7;
            }
            dArr3[i2] = (((dArr[i2] - dArr[i6]) * 3.0d) - dArr3[i6]) * dArr2[i2];
            dArr4[i2] = dArr3[i2];
            while (i6 >= 0) {
                dArr4[i6] = dArr3[i6] - (dArr2[i6] * dArr4[i6 + 1]);
                i6--;
            }
            Cubic[] cubicArr = new Cubic[i2];
            while (i3 < i2) {
                int i9 = i3 + 1;
                cubicArr[i3] = new Cubic((float) dArr[i3], dArr4[i3], (((dArr[i9] - dArr[i3]) * 3.0d) - (dArr4[i3] * 2.0d)) - dArr4[i9], ((dArr[i3] - dArr[i9]) * 2.0d) + dArr4[i3] + dArr4[i9]);
                i3 = i9;
            }
            return cubicArr;
        }
        return (Cubic[]) invokeIL.objValue;
    }

    public double approxLength(Cubic[] cubicArr) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cubicArr)) == null) {
            int length = cubicArr.length;
            double[] dArr = new double[cubicArr.length];
            double d = 0.0d;
            double d2 = 0.0d;
            double d3 = 0.0d;
            while (true) {
                i = 0;
                if (d2 >= 1.0d) {
                    break;
                }
                double d4 = 0.0d;
                while (i < cubicArr.length) {
                    double d5 = dArr[i];
                    double eval = cubicArr[i].eval(d2);
                    dArr[i] = eval;
                    double d6 = d5 - eval;
                    d4 += d6 * d6;
                    i++;
                }
                if (d2 > 0.0d) {
                    d3 += Math.sqrt(d4);
                }
                d2 += 0.1d;
            }
            while (i < cubicArr.length) {
                double d7 = dArr[i];
                double eval2 = cubicArr[i].eval(1.0d);
                dArr[i] = eval2;
                double d8 = d7 - eval2;
                d += d8 * d8;
                i++;
            }
            return d3 + Math.sqrt(d);
        }
        return invokeL.doubleValue;
    }

    public void getPos(double d, double[] dArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d), dArr}) == null) {
            double d2 = d * this.mTotalLength;
            int i = 0;
            while (true) {
                double[] dArr2 = this.mCurveLength;
                if (i >= dArr2.length - 1 || dArr2[i] >= d2) {
                    break;
                }
                d2 -= dArr2[i];
                i++;
            }
            for (int i2 = 0; i2 < dArr.length; i2++) {
                dArr[i2] = this.mCurve[i2][i].eval(d2 / this.mCurveLength[i]);
            }
        }
    }

    public void getVelocity(double d, double[] dArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Double.valueOf(d), dArr}) == null) {
            double d2 = d * this.mTotalLength;
            int i = 0;
            while (true) {
                double[] dArr2 = this.mCurveLength;
                if (i >= dArr2.length - 1 || dArr2[i] >= d2) {
                    break;
                }
                d2 -= dArr2[i];
                i++;
            }
            for (int i2 = 0; i2 < dArr.length; i2++) {
                dArr[i2] = this.mCurve[i2][i].vel(d2 / this.mCurveLength[i]);
            }
        }
    }

    public void setup(double[][] dArr) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dArr) == null) {
            int length = dArr[0].length;
            this.mDimensionality = length;
            int length2 = dArr.length;
            this.mPoints = length2;
            this.mCtl = (double[][]) Array.newInstance(double.class, length, length2);
            this.mCurve = new Cubic[this.mDimensionality];
            for (int i2 = 0; i2 < this.mDimensionality; i2++) {
                for (int i3 = 0; i3 < this.mPoints; i3++) {
                    this.mCtl[i2][i3] = dArr[i3][i2];
                }
            }
            int i4 = 0;
            while (true) {
                i = this.mDimensionality;
                if (i4 >= i) {
                    break;
                }
                Cubic[][] cubicArr = this.mCurve;
                double[][] dArr2 = this.mCtl;
                cubicArr[i4] = calcNaturalCubic(dArr2[i4].length, dArr2[i4]);
                i4++;
            }
            this.mCurveLength = new double[this.mPoints - 1];
            this.mTotalLength = 0.0d;
            Cubic[] cubicArr2 = new Cubic[i];
            for (int i5 = 0; i5 < this.mCurveLength.length; i5++) {
                for (int i6 = 0; i6 < this.mDimensionality; i6++) {
                    cubicArr2[i6] = this.mCurve[i6][i5];
                }
                double d = this.mTotalLength;
                double[] dArr3 = this.mCurveLength;
                double approxLength = approxLength(cubicArr2);
                dArr3[i5] = approxLength;
                this.mTotalLength = d + approxLength;
            }
        }
    }

    public HyperSpline() {
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

    public void getPos(double d, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Double.valueOf(d), fArr}) == null) {
            double d2 = d * this.mTotalLength;
            int i = 0;
            while (true) {
                double[] dArr = this.mCurveLength;
                if (i >= dArr.length - 1 || dArr[i] >= d2) {
                    break;
                }
                d2 -= dArr[i];
                i++;
            }
            for (int i2 = 0; i2 < fArr.length; i2++) {
                fArr[i2] = (float) this.mCurve[i2][i].eval(d2 / this.mCurveLength[i]);
            }
        }
    }

    public double getPos(double d, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d), Integer.valueOf(i)})) == null) {
            double d2 = d * this.mTotalLength;
            int i2 = 0;
            while (true) {
                double[] dArr = this.mCurveLength;
                if (i2 >= dArr.length - 1 || dArr[i2] >= d2) {
                    break;
                }
                d2 -= dArr[i2];
                i2++;
            }
            return this.mCurve[i][i2].eval(d2 / this.mCurveLength[i2]);
        }
        return invokeCommon.doubleValue;
    }
}
