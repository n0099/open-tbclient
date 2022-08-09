package androidx.constraintlayout.motion.utils;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes.dex */
public class Oscillator {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BOUNCE = 6;
    public static final int COS_WAVE = 5;
    public static final int REVERSE_SAW_WAVE = 4;
    public static final int SAW_WAVE = 3;
    public static final int SIN_WAVE = 0;
    public static final int SQUARE_WAVE = 1;
    public static String TAG = "Oscillator";
    public static final int TRIANGLE_WAVE = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public double PI2;
    public double[] mArea;
    public boolean mNormalized;
    public float[] mPeriod;
    public double[] mPosition;
    public int mType;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(540394866, "Landroidx/constraintlayout/motion/utils/Oscillator;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(540394866, "Landroidx/constraintlayout/motion/utils/Oscillator;");
        }
    }

    public Oscillator() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mPeriod = new float[0];
        this.mPosition = new double[0];
        this.PI2 = 6.283185307179586d;
        this.mNormalized = false;
    }

    public void addPoint(double d, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d), Float.valueOf(f)}) == null) {
            int length = this.mPeriod.length + 1;
            int binarySearch = Arrays.binarySearch(this.mPosition, d);
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 1;
            }
            this.mPosition = Arrays.copyOf(this.mPosition, length);
            this.mPeriod = Arrays.copyOf(this.mPeriod, length);
            this.mArea = new double[length];
            double[] dArr = this.mPosition;
            System.arraycopy(dArr, binarySearch, dArr, binarySearch + 1, (length - binarySearch) - 1);
            this.mPosition[binarySearch] = d;
            this.mPeriod[binarySearch] = f;
            this.mNormalized = false;
        }
    }

    public double getDP(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d)})) == null) {
            if (d <= 0.0d) {
                d = 1.0E-5d;
            } else if (d >= 1.0d) {
                d = 0.999999d;
            }
            int binarySearch = Arrays.binarySearch(this.mPosition, d);
            if (binarySearch <= 0 && binarySearch != 0) {
                int i = (-binarySearch) - 1;
                float[] fArr = this.mPeriod;
                int i2 = i - 1;
                double d2 = fArr[i] - fArr[i2];
                double[] dArr = this.mPosition;
                double d3 = d2 / (dArr[i] - dArr[i2]);
                return (fArr[i2] - (d3 * dArr[i2])) + (d * d3);
            }
            return 0.0d;
        }
        return invokeCommon.doubleValue;
    }

    public double getP(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d)})) == null) {
            if (d < 0.0d) {
                d = 0.0d;
            } else if (d > 1.0d) {
                d = 1.0d;
            }
            int binarySearch = Arrays.binarySearch(this.mPosition, d);
            if (binarySearch > 0) {
                return 1.0d;
            }
            if (binarySearch != 0) {
                int i = (-binarySearch) - 1;
                float[] fArr = this.mPeriod;
                int i2 = i - 1;
                double d2 = fArr[i] - fArr[i2];
                double[] dArr = this.mPosition;
                double d3 = d2 / (dArr[i] - dArr[i2]);
                return this.mArea[i2] + ((fArr[i2] - (dArr[i2] * d3)) * (d - dArr[i2])) + ((d3 * ((d * d) - (dArr[i2] * dArr[i2]))) / 2.0d);
            }
            return 0.0d;
        }
        return invokeCommon.doubleValue;
    }

    public double getSlope(double d) {
        InterceptResult invokeCommon;
        double dp;
        double signum;
        double dp2;
        double dp3;
        double sin;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Double.valueOf(d)})) == null) {
            switch (this.mType) {
                case 1:
                    return 0.0d;
                case 2:
                    dp = getDP(d) * 4.0d;
                    signum = Math.signum((((getP(d) * 4.0d) + 3.0d) % 4.0d) - 2.0d);
                    return dp * signum;
                case 3:
                    dp2 = getDP(d);
                    return dp2 * 2.0d;
                case 4:
                    dp2 = -getDP(d);
                    return dp2 * 2.0d;
                case 5:
                    dp3 = (-this.PI2) * getDP(d);
                    sin = Math.sin(this.PI2 * getP(d));
                    return dp3 * sin;
                case 6:
                    dp = getDP(d) * 4.0d;
                    signum = (((getP(d) * 4.0d) + 2.0d) % 4.0d) - 2.0d;
                    return dp * signum;
                default:
                    dp3 = this.PI2 * getDP(d);
                    sin = Math.cos(this.PI2 * getP(d));
                    return dp3 * sin;
            }
        }
        return invokeCommon.doubleValue;
    }

    public double getValue(double d) {
        InterceptResult invokeCommon;
        double abs;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Double.valueOf(d)})) == null) {
            switch (this.mType) {
                case 1:
                    return Math.signum(0.5d - (getP(d) % 1.0d));
                case 2:
                    abs = Math.abs((((getP(d) * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                    break;
                case 3:
                    return (((getP(d) * 2.0d) + 1.0d) % 2.0d) - 1.0d;
                case 4:
                    abs = ((getP(d) * 2.0d) + 1.0d) % 2.0d;
                    break;
                case 5:
                    return Math.cos(this.PI2 * getP(d));
                case 6:
                    double abs2 = 1.0d - Math.abs(((getP(d) * 4.0d) % 4.0d) - 2.0d);
                    abs = abs2 * abs2;
                    break;
                default:
                    return Math.sin(this.PI2 * getP(d));
            }
            return 1.0d - abs;
        }
        return invokeCommon.doubleValue;
    }

    public void normalize() {
        float[] fArr;
        float[] fArr2;
        float[] fArr3;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048581, this) != null) {
            return;
        }
        double d = 0.0d;
        int i2 = 0;
        while (true) {
            if (i2 >= this.mPeriod.length) {
                break;
            }
            d += fArr[i2];
            i2++;
        }
        double d2 = 0.0d;
        int i3 = 1;
        while (true) {
            if (i3 >= this.mPeriod.length) {
                break;
            }
            double[] dArr = this.mPosition;
            d2 += (dArr[i3] - dArr[i3 - 1]) * ((fArr2[i] + fArr2[i3]) / 2.0f);
            i3++;
        }
        int i4 = 0;
        while (true) {
            float[] fArr4 = this.mPeriod;
            if (i4 >= fArr4.length) {
                break;
            }
            fArr4[i4] = (float) (fArr4[i4] * (d / d2));
            i4++;
        }
        this.mArea[0] = 0.0d;
        int i5 = 1;
        while (true) {
            if (i5 < this.mPeriod.length) {
                int i6 = i5 - 1;
                double[] dArr2 = this.mPosition;
                double d3 = dArr2[i5] - dArr2[i6];
                double[] dArr3 = this.mArea;
                dArr3[i5] = dArr3[i6] + (d3 * ((fArr3[i6] + fArr3[i5]) / 2.0f));
                i5++;
            } else {
                this.mNormalized = true;
                return;
            }
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.mType = i;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return "pos =" + Arrays.toString(this.mPosition) + " period=" + Arrays.toString(this.mPeriod);
        }
        return (String) invokeV.objValue;
    }
}
