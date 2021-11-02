package androidx.constraintlayout.motion.utils;

import androidx.core.view.InputDeviceCompat;
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
public class ArcCurveFit extends CurveFit {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ARC_START_FLIP = 3;
    public static final int ARC_START_HORIZONTAL = 2;
    public static final int ARC_START_LINEAR = 0;
    public static final int ARC_START_VERTICAL = 1;
    public static final int START_HORIZONTAL = 2;
    public static final int START_LINEAR = 3;
    public static final int START_VERTICAL = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public Arc[] mArcs;
    public final double[] mTime;

    /* loaded from: classes.dex */
    public static class Arc {
        public static /* synthetic */ Interceptable $ic = null;
        public static final double EPSILON = 0.001d;
        public static final String TAG = "Arc";
        public static double[] ourPercent;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean linear;
        public double mArcDistance;
        public double mArcVelocity;
        public double mEllipseA;
        public double mEllipseB;
        public double mEllipseCenterX;
        public double mEllipseCenterY;
        public double[] mLut;
        public double mOneOverDeltaTime;
        public double mTime1;
        public double mTime2;
        public double mTmpCosAngle;
        public double mTmpSinAngle;
        public boolean mVertical;
        public double mX1;
        public double mX2;
        public double mY1;
        public double mY2;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1884119454, "Landroidx/constraintlayout/motion/utils/ArcCurveFit$Arc;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1884119454, "Landroidx/constraintlayout/motion/utils/ArcCurveFit$Arc;");
                    return;
                }
            }
            ourPercent = new double[91];
        }

        public Arc(int i2, double d2, double d3, double d4, double d5, double d6, double d7) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {Integer.valueOf(i2), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5), Double.valueOf(d6), Double.valueOf(d7)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.linear = false;
            this.mVertical = i2 == 1;
            this.mTime1 = d2;
            this.mTime2 = d3;
            this.mOneOverDeltaTime = 1.0d / (d3 - d2);
            if (3 == i2) {
                this.linear = true;
            }
            double d8 = d6 - d4;
            double d9 = d7 - d5;
            if (!this.linear && Math.abs(d8) >= 0.001d && Math.abs(d9) >= 0.001d) {
                this.mLut = new double[101];
                this.mEllipseA = d8 * (this.mVertical ? -1 : 1);
                this.mEllipseB = d9 * (this.mVertical ? 1 : -1);
                this.mEllipseCenterX = this.mVertical ? d6 : d4;
                this.mEllipseCenterY = this.mVertical ? d5 : d7;
                buildTable(d4, d5, d6, d7);
                this.mArcVelocity = this.mArcDistance * this.mOneOverDeltaTime;
                return;
            }
            this.linear = true;
            this.mX1 = d4;
            this.mX2 = d6;
            this.mY1 = d5;
            this.mY2 = d7;
            double hypot = Math.hypot(d9, d8);
            this.mArcDistance = hypot;
            this.mArcVelocity = hypot * this.mOneOverDeltaTime;
            double d10 = this.mTime2;
            double d11 = this.mTime1;
            this.mEllipseCenterX = d8 / (d10 - d11);
            this.mEllipseCenterY = d9 / (d10 - d11);
        }

        private void buildTable(double d2, double d3, double d4, double d5) {
            double[] dArr;
            double[] dArr2;
            double d6;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeCommon(65538, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5)}) != null) {
                return;
            }
            double d7 = d4 - d2;
            double d8 = d3 - d5;
            int i2 = 0;
            double d9 = 0.0d;
            double d10 = 0.0d;
            double d11 = 0.0d;
            while (true) {
                if (i2 >= ourPercent.length) {
                    break;
                }
                double d12 = d9;
                double radians = Math.toRadians((i2 * 90.0d) / (dArr.length - 1));
                double sin = Math.sin(radians) * d7;
                double cos = Math.cos(radians) * d8;
                if (i2 > 0) {
                    d6 = d12 + Math.hypot(sin - d10, cos - d11);
                    ourPercent[i2] = d6;
                } else {
                    d6 = d12;
                }
                i2++;
                d11 = cos;
                d9 = d6;
                d10 = sin;
            }
            double d13 = d9;
            this.mArcDistance = d13;
            int i3 = 0;
            while (true) {
                double[] dArr3 = ourPercent;
                if (i3 >= dArr3.length) {
                    break;
                }
                dArr3[i3] = dArr3[i3] / d13;
                i3++;
            }
            int i4 = 0;
            while (true) {
                if (i4 >= this.mLut.length) {
                    return;
                }
                double length = i4 / (dArr2.length - 1);
                int binarySearch = Arrays.binarySearch(ourPercent, length);
                if (binarySearch >= 0) {
                    this.mLut[i4] = binarySearch / (ourPercent.length - 1);
                } else if (binarySearch == -1) {
                    this.mLut[i4] = 0.0d;
                } else {
                    int i5 = -binarySearch;
                    int i6 = i5 - 2;
                    double[] dArr4 = ourPercent;
                    this.mLut[i4] = (i6 + ((length - dArr4[i6]) / (dArr4[i5 - 1] - dArr4[i6]))) / (dArr4.length - 1);
                }
                i4++;
            }
        }

        public double getDX() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                double d2 = this.mEllipseA * this.mTmpCosAngle;
                double hypot = this.mArcVelocity / Math.hypot(d2, (-this.mEllipseB) * this.mTmpSinAngle);
                if (this.mVertical) {
                    d2 = -d2;
                }
                return d2 * hypot;
            }
            return invokeV.doubleValue;
        }

        public double getDY() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                double d2 = this.mEllipseA * this.mTmpCosAngle;
                double d3 = (-this.mEllipseB) * this.mTmpSinAngle;
                double hypot = this.mArcVelocity / Math.hypot(d2, d3);
                return this.mVertical ? (-d3) * hypot : d3 * hypot;
            }
            return invokeV.doubleValue;
        }

        public double getLinearDX(double d2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d2)})) == null) ? this.mEllipseCenterX : invokeCommon.doubleValue;
        }

        public double getLinearDY(double d2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Double.valueOf(d2)})) == null) ? this.mEllipseCenterY : invokeCommon.doubleValue;
        }

        public double getLinearX(double d2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Double.valueOf(d2)})) == null) {
                double d3 = (d2 - this.mTime1) * this.mOneOverDeltaTime;
                double d4 = this.mX1;
                return d4 + (d3 * (this.mX2 - d4));
            }
            return invokeCommon.doubleValue;
        }

        public double getLinearY(double d2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Double.valueOf(d2)})) == null) {
                double d3 = (d2 - this.mTime1) * this.mOneOverDeltaTime;
                double d4 = this.mY1;
                return d4 + (d3 * (this.mY2 - d4));
            }
            return invokeCommon.doubleValue;
        }

        public double getX() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mEllipseCenterX + (this.mEllipseA * this.mTmpSinAngle) : invokeV.doubleValue;
        }

        public double getY() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mEllipseCenterY + (this.mEllipseB * this.mTmpCosAngle) : invokeV.doubleValue;
        }

        public double lookup(double d2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Double.valueOf(d2)})) == null) {
                if (d2 <= 0.0d) {
                    return 0.0d;
                }
                if (d2 >= 1.0d) {
                    return 1.0d;
                }
                double[] dArr = this.mLut;
                double length = d2 * (dArr.length - 1);
                int i2 = (int) length;
                return dArr[i2] + ((length - i2) * (dArr[i2 + 1] - dArr[i2]));
            }
            return invokeCommon.doubleValue;
        }

        public void setPoint(double d2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Double.valueOf(d2)}) == null) {
                double lookup = lookup((this.mVertical ? this.mTime2 - d2 : d2 - this.mTime1) * this.mOneOverDeltaTime) * 1.5707963267948966d;
                this.mTmpSinAngle = Math.sin(lookup);
                this.mTmpCosAngle = Math.cos(lookup);
            }
        }
    }

    public ArcCurveFit(int[] iArr, double[] dArr, double[][] dArr2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {iArr, dArr, dArr2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTime = dArr;
        this.mArcs = new Arc[dArr.length - 1];
        int i5 = 0;
        int i6 = 1;
        int i7 = 1;
        while (i5 < this.mArcs.length) {
            int i8 = iArr[i5];
            if (i8 == 0) {
                i2 = 3;
            } else if (i8 == 1) {
                i6 = 1;
                i2 = 1;
            } else if (i8 == 2) {
                i6 = 2;
                i2 = 2;
            } else if (i8 != 3) {
                i2 = i7;
            } else {
                i6 = i6 == 1 ? 2 : 1;
                i2 = i6;
            }
            int i9 = i5 + 1;
            this.mArcs[i5] = new Arc(i2, dArr[i5], dArr[i9], dArr2[i5][0], dArr2[i5][1], dArr2[i9][0], dArr2[i9][1]);
            i7 = i2;
            i5 = i9;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d2, double[] dArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d2), dArr}) != null) {
            return;
        }
        Arc[] arcArr = this.mArcs;
        if (d2 < arcArr[0].mTime1) {
            d2 = arcArr[0].mTime1;
        }
        Arc[] arcArr2 = this.mArcs;
        if (d2 > arcArr2[arcArr2.length - 1].mTime2) {
            d2 = arcArr2[arcArr2.length - 1].mTime2;
        }
        int i2 = 0;
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i2 >= arcArr3.length) {
                return;
            }
            if (d2 <= arcArr3[i2].mTime2) {
                if (arcArr3[i2].linear) {
                    dArr[0] = arcArr3[i2].getLinearX(d2);
                    dArr[1] = this.mArcs[i2].getLinearY(d2);
                    return;
                }
                arcArr3[i2].setPoint(d2);
                dArr[0] = this.mArcs[i2].getX();
                dArr[1] = this.mArcs[i2].getY();
                return;
            }
            i2++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getSlope(double d2, double[] dArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(1048580, this, new Object[]{Double.valueOf(d2), dArr}) != null) {
            return;
        }
        Arc[] arcArr = this.mArcs;
        if (d2 < arcArr[0].mTime1) {
            d2 = arcArr[0].mTime1;
        } else if (d2 > arcArr[arcArr.length - 1].mTime2) {
            d2 = arcArr[arcArr.length - 1].mTime2;
        }
        int i2 = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i2 >= arcArr2.length) {
                return;
            }
            if (d2 <= arcArr2[i2].mTime2) {
                if (arcArr2[i2].linear) {
                    dArr[0] = arcArr2[i2].getLinearDX(d2);
                    dArr[1] = this.mArcs[i2].getLinearDY(d2);
                    return;
                }
                arcArr2[i2].setPoint(d2);
                dArr[0] = this.mArcs[i2].getDX();
                dArr[1] = this.mArcs[i2].getDY();
                return;
            }
            i2++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double[] getTimePoints() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mTime : (double[]) invokeV.objValue;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d2, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d2), fArr}) != null) {
            return;
        }
        Arc[] arcArr = this.mArcs;
        if (d2 < arcArr[0].mTime1) {
            d2 = arcArr[0].mTime1;
        } else if (d2 > arcArr[arcArr.length - 1].mTime2) {
            d2 = arcArr[arcArr.length - 1].mTime2;
        }
        int i2 = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i2 >= arcArr2.length) {
                return;
            }
            if (d2 <= arcArr2[i2].mTime2) {
                if (arcArr2[i2].linear) {
                    fArr[0] = (float) arcArr2[i2].getLinearX(d2);
                    fArr[1] = (float) this.mArcs[i2].getLinearY(d2);
                    return;
                }
                arcArr2[i2].setPoint(d2);
                fArr[0] = (float) this.mArcs[i2].getX();
                fArr[1] = (float) this.mArcs[i2].getY();
                return;
            }
            i2++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getSlope(double d2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Double.valueOf(d2), Integer.valueOf(i2)})) != null) {
            return invokeCommon.doubleValue;
        }
        Arc[] arcArr = this.mArcs;
        int i3 = 0;
        if (d2 < arcArr[0].mTime1) {
            d2 = arcArr[0].mTime1;
        }
        Arc[] arcArr2 = this.mArcs;
        if (d2 > arcArr2[arcArr2.length - 1].mTime2) {
            d2 = arcArr2[arcArr2.length - 1].mTime2;
        }
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i3 >= arcArr3.length) {
                return Double.NaN;
            }
            if (d2 <= arcArr3[i3].mTime2) {
                if (arcArr3[i3].linear) {
                    if (i2 == 0) {
                        return arcArr3[i3].getLinearDX(d2);
                    }
                    return arcArr3[i3].getLinearDY(d2);
                }
                arcArr3[i3].setPoint(d2);
                if (i2 == 0) {
                    return this.mArcs[i3].getDX();
                }
                return this.mArcs[i3].getDY();
            }
            i3++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getPos(double d2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d2), Integer.valueOf(i2)})) != null) {
            return invokeCommon.doubleValue;
        }
        Arc[] arcArr = this.mArcs;
        int i3 = 0;
        if (d2 < arcArr[0].mTime1) {
            d2 = arcArr[0].mTime1;
        } else if (d2 > arcArr[arcArr.length - 1].mTime2) {
            d2 = arcArr[arcArr.length - 1].mTime2;
        }
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i3 >= arcArr2.length) {
                return Double.NaN;
            }
            if (d2 <= arcArr2[i3].mTime2) {
                if (arcArr2[i3].linear) {
                    if (i2 == 0) {
                        return arcArr2[i3].getLinearX(d2);
                    }
                    return arcArr2[i3].getLinearY(d2);
                }
                arcArr2[i3].setPoint(d2);
                if (i2 == 0) {
                    return this.mArcs[i3].getX();
                }
                return this.mArcs[i3].getY();
            }
            i3++;
        }
    }
}
