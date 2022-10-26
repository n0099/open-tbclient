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

        public double getDX() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                double d = this.mEllipseA * this.mTmpCosAngle;
                double hypot = this.mArcVelocity / Math.hypot(d, (-this.mEllipseB) * this.mTmpSinAngle);
                if (this.mVertical) {
                    d = -d;
                }
                return d * hypot;
            }
            return invokeV.doubleValue;
        }

        public double getDY() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                double d = this.mEllipseA * this.mTmpCosAngle;
                double d2 = (-this.mEllipseB) * this.mTmpSinAngle;
                double hypot = this.mArcVelocity / Math.hypot(d, d2);
                if (this.mVertical) {
                    return (-d2) * hypot;
                }
                return d2 * hypot;
            }
            return invokeV.doubleValue;
        }

        public double getX() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.mEllipseCenterX + (this.mEllipseA * this.mTmpSinAngle);
            }
            return invokeV.doubleValue;
        }

        public double getY() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.mEllipseCenterY + (this.mEllipseB * this.mTmpCosAngle);
            }
            return invokeV.doubleValue;
        }

        public Arc(int i, double d, double d2, double d3, double d4, double d5, double d6) {
            int i2;
            int i3;
            double d7;
            double d8;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {Integer.valueOf(i), Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5), Double.valueOf(d6)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.linear = false;
            this.mVertical = i == 1;
            this.mTime1 = d;
            this.mTime2 = d2;
            this.mOneOverDeltaTime = 1.0d / (d2 - d);
            if (3 == i) {
                this.linear = true;
            }
            double d9 = d5 - d3;
            double d10 = d6 - d4;
            if (!this.linear && Math.abs(d9) >= 0.001d && Math.abs(d10) >= 0.001d) {
                this.mLut = new double[101];
                if (this.mVertical) {
                    i2 = -1;
                } else {
                    i2 = 1;
                }
                this.mEllipseA = d9 * i2;
                if (this.mVertical) {
                    i3 = 1;
                } else {
                    i3 = -1;
                }
                this.mEllipseB = d10 * i3;
                if (this.mVertical) {
                    d7 = d5;
                } else {
                    d7 = d3;
                }
                this.mEllipseCenterX = d7;
                if (this.mVertical) {
                    d8 = d4;
                } else {
                    d8 = d6;
                }
                this.mEllipseCenterY = d8;
                buildTable(d3, d4, d5, d6);
                this.mArcVelocity = this.mArcDistance * this.mOneOverDeltaTime;
                return;
            }
            this.linear = true;
            this.mX1 = d3;
            this.mX2 = d5;
            this.mY1 = d4;
            this.mY2 = d6;
            double hypot = Math.hypot(d10, d9);
            this.mArcDistance = hypot;
            this.mArcVelocity = hypot * this.mOneOverDeltaTime;
            double d11 = this.mTime2;
            double d12 = this.mTime1;
            this.mEllipseCenterX = d9 / (d11 - d12);
            this.mEllipseCenterY = d10 / (d11 - d12);
        }

        private void buildTable(double d, double d2, double d3, double d4) {
            double[] dArr;
            double[] dArr2;
            double d5;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4)}) == null) {
                double d6 = d3 - d;
                double d7 = d2 - d4;
                int i = 0;
                double d8 = 0.0d;
                double d9 = 0.0d;
                double d10 = 0.0d;
                while (true) {
                    if (i >= ourPercent.length) {
                        break;
                    }
                    double d11 = d8;
                    double radians = Math.toRadians((i * 90.0d) / (dArr.length - 1));
                    double sin = Math.sin(radians) * d6;
                    double cos = Math.cos(radians) * d7;
                    if (i > 0) {
                        d5 = d11 + Math.hypot(sin - d9, cos - d10);
                        ourPercent[i] = d5;
                    } else {
                        d5 = d11;
                    }
                    i++;
                    d10 = cos;
                    d8 = d5;
                    d9 = sin;
                }
                double d12 = d8;
                this.mArcDistance = d12;
                int i2 = 0;
                while (true) {
                    double[] dArr3 = ourPercent;
                    if (i2 >= dArr3.length) {
                        break;
                    }
                    dArr3[i2] = dArr3[i2] / d12;
                    i2++;
                }
                int i3 = 0;
                while (true) {
                    if (i3 < this.mLut.length) {
                        double length = i3 / (dArr2.length - 1);
                        int binarySearch = Arrays.binarySearch(ourPercent, length);
                        if (binarySearch >= 0) {
                            this.mLut[i3] = binarySearch / (ourPercent.length - 1);
                        } else if (binarySearch == -1) {
                            this.mLut[i3] = 0.0d;
                        } else {
                            int i4 = -binarySearch;
                            int i5 = i4 - 2;
                            double[] dArr4 = ourPercent;
                            this.mLut[i3] = (i5 + ((length - dArr4[i5]) / (dArr4[i4 - 1] - dArr4[i5]))) / (dArr4.length - 1);
                        }
                        i3++;
                    } else {
                        return;
                    }
                }
            }
        }

        public double getLinearDX(double d) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d)})) == null) {
                return this.mEllipseCenterX;
            }
            return invokeCommon.doubleValue;
        }

        public double getLinearDY(double d) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Double.valueOf(d)})) == null) {
                return this.mEllipseCenterY;
            }
            return invokeCommon.doubleValue;
        }

        public double getLinearX(double d) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Double.valueOf(d)})) == null) {
                double d2 = (d - this.mTime1) * this.mOneOverDeltaTime;
                double d3 = this.mX1;
                return d3 + (d2 * (this.mX2 - d3));
            }
            return invokeCommon.doubleValue;
        }

        public double getLinearY(double d) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Double.valueOf(d)})) == null) {
                double d2 = (d - this.mTime1) * this.mOneOverDeltaTime;
                double d3 = this.mY1;
                return d3 + (d2 * (this.mY2 - d3));
            }
            return invokeCommon.doubleValue;
        }

        public double lookup(double d) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Double.valueOf(d)})) == null) {
                if (d <= 0.0d) {
                    return 0.0d;
                }
                if (d >= 1.0d) {
                    return 1.0d;
                }
                double[] dArr = this.mLut;
                double length = d * (dArr.length - 1);
                int i = (int) length;
                return dArr[i] + ((length - i) * (dArr[i + 1] - dArr[i]));
            }
            return invokeCommon.doubleValue;
        }

        public void setPoint(double d) {
            double d2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Double.valueOf(d)}) == null) {
                if (this.mVertical) {
                    d2 = this.mTime2 - d;
                } else {
                    d2 = d - this.mTime1;
                }
                double lookup = lookup(d2 * this.mOneOverDeltaTime) * 1.5707963267948966d;
                this.mTmpSinAngle = Math.sin(lookup);
                this.mTmpCosAngle = Math.cos(lookup);
            }
        }
    }

    public ArcCurveFit(int[] iArr, double[] dArr, double[][] dArr2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {iArr, dArr, dArr2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTime = dArr;
        this.mArcs = new Arc[dArr.length - 1];
        int i4 = 0;
        int i5 = 1;
        int i6 = 1;
        while (i4 < this.mArcs.length) {
            int i7 = iArr[i4];
            if (i7 != 0) {
                if (i7 != 1) {
                    if (i7 != 2) {
                        if (i7 != 3) {
                            i = i6;
                        } else {
                            if (i5 == 1) {
                                i5 = 2;
                            } else {
                                i5 = 1;
                            }
                            i = i5;
                        }
                    } else {
                        i5 = 2;
                        i = 2;
                    }
                } else {
                    i5 = 1;
                    i = 1;
                }
            } else {
                i = 3;
            }
            int i8 = i4 + 1;
            this.mArcs[i4] = new Arc(i, dArr[i4], dArr[i8], dArr2[i4][0], dArr2[i4][1], dArr2[i8][0], dArr2[i8][1]);
            i6 = i;
            i4 = i8;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getPos(double d, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d), Integer.valueOf(i)})) == null) {
            Arc[] arcArr = this.mArcs;
            int i2 = 0;
            if (d < arcArr[0].mTime1) {
                d = arcArr[0].mTime1;
            } else if (d > arcArr[arcArr.length - 1].mTime2) {
                d = arcArr[arcArr.length - 1].mTime2;
            }
            while (true) {
                Arc[] arcArr2 = this.mArcs;
                if (i2 < arcArr2.length) {
                    if (d <= arcArr2[i2].mTime2) {
                        if (arcArr2[i2].linear) {
                            if (i == 0) {
                                return arcArr2[i2].getLinearX(d);
                            }
                            return arcArr2[i2].getLinearY(d);
                        }
                        arcArr2[i2].setPoint(d);
                        if (i == 0) {
                            return this.mArcs[i2].getX();
                        }
                        return this.mArcs[i2].getY();
                    }
                    i2++;
                } else {
                    return Double.NaN;
                }
            }
        } else {
            return invokeCommon.doubleValue;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getSlope(double d, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Double.valueOf(d), Integer.valueOf(i)})) == null) {
            Arc[] arcArr = this.mArcs;
            int i2 = 0;
            if (d < arcArr[0].mTime1) {
                d = arcArr[0].mTime1;
            }
            Arc[] arcArr2 = this.mArcs;
            if (d > arcArr2[arcArr2.length - 1].mTime2) {
                d = arcArr2[arcArr2.length - 1].mTime2;
            }
            while (true) {
                Arc[] arcArr3 = this.mArcs;
                if (i2 < arcArr3.length) {
                    if (d <= arcArr3[i2].mTime2) {
                        if (arcArr3[i2].linear) {
                            if (i == 0) {
                                return arcArr3[i2].getLinearDX(d);
                            }
                            return arcArr3[i2].getLinearDY(d);
                        }
                        arcArr3[i2].setPoint(d);
                        if (i == 0) {
                            return this.mArcs[i2].getDX();
                        }
                        return this.mArcs[i2].getDY();
                    }
                    i2++;
                } else {
                    return Double.NaN;
                }
            }
        } else {
            return invokeCommon.doubleValue;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d, double[] dArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d), dArr}) == null) {
            Arc[] arcArr = this.mArcs;
            if (d < arcArr[0].mTime1) {
                d = arcArr[0].mTime1;
            }
            Arc[] arcArr2 = this.mArcs;
            if (d > arcArr2[arcArr2.length - 1].mTime2) {
                d = arcArr2[arcArr2.length - 1].mTime2;
            }
            int i = 0;
            while (true) {
                Arc[] arcArr3 = this.mArcs;
                if (i < arcArr3.length) {
                    if (d <= arcArr3[i].mTime2) {
                        if (arcArr3[i].linear) {
                            dArr[0] = arcArr3[i].getLinearX(d);
                            dArr[1] = this.mArcs[i].getLinearY(d);
                            return;
                        }
                        arcArr3[i].setPoint(d);
                        dArr[0] = this.mArcs[i].getX();
                        dArr[1] = this.mArcs[i].getY();
                        return;
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getSlope(double d, double[] dArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Double.valueOf(d), dArr}) == null) {
            Arc[] arcArr = this.mArcs;
            if (d < arcArr[0].mTime1) {
                d = arcArr[0].mTime1;
            } else if (d > arcArr[arcArr.length - 1].mTime2) {
                d = arcArr[arcArr.length - 1].mTime2;
            }
            int i = 0;
            while (true) {
                Arc[] arcArr2 = this.mArcs;
                if (i < arcArr2.length) {
                    if (d <= arcArr2[i].mTime2) {
                        if (arcArr2[i].linear) {
                            dArr[0] = arcArr2[i].getLinearDX(d);
                            dArr[1] = this.mArcs[i].getLinearDY(d);
                            return;
                        }
                        arcArr2[i].setPoint(d);
                        dArr[0] = this.mArcs[i].getDX();
                        dArr[1] = this.mArcs[i].getDY();
                        return;
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d), fArr}) == null) {
            Arc[] arcArr = this.mArcs;
            if (d < arcArr[0].mTime1) {
                d = arcArr[0].mTime1;
            } else if (d > arcArr[arcArr.length - 1].mTime2) {
                d = arcArr[arcArr.length - 1].mTime2;
            }
            int i = 0;
            while (true) {
                Arc[] arcArr2 = this.mArcs;
                if (i < arcArr2.length) {
                    if (d <= arcArr2[i].mTime2) {
                        if (arcArr2[i].linear) {
                            fArr[0] = (float) arcArr2[i].getLinearX(d);
                            fArr[1] = (float) this.mArcs[i].getLinearY(d);
                            return;
                        }
                        arcArr2[i].setPoint(d);
                        fArr[0] = (float) this.mArcs[i].getX();
                        fArr[1] = (float) this.mArcs[i].getY();
                        return;
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double[] getTimePoints() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mTime;
        }
        return (double[]) invokeV.objValue;
    }
}
