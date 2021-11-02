package androidx.constraintlayout.motion.utils;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class CurveFit {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CONSTANT = 2;
    public static final int LINEAR = 1;
    public static final int SPLINE = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class Constant extends CurveFit {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public double mTime;
        public double[] mValue;

        public Constant(double d2, double[] dArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Double.valueOf(d2), dArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mTime = d2;
            this.mValue = dArr;
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public void getPos(double d2, double[] dArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d2), dArr}) == null) {
                double[] dArr2 = this.mValue;
                System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
            }
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public double getSlope(double d2, int i2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Double.valueOf(d2), Integer.valueOf(i2)})) == null) {
                return 0.0d;
            }
            return invokeCommon.doubleValue;
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public void getSlope(double d2, double[] dArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Double.valueOf(d2), dArr}) == null) {
                for (int i2 = 0; i2 < this.mValue.length; i2++) {
                    dArr[i2] = 0.0d;
                }
            }
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public double[] getTimePoints() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new double[]{this.mTime} : (double[]) invokeV.objValue;
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public void getPos(double d2, float[] fArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d2), fArr}) != null) {
                return;
            }
            int i2 = 0;
            while (true) {
                double[] dArr = this.mValue;
                if (i2 >= dArr.length) {
                    return;
                }
                fArr[i2] = (float) dArr[i2];
                i2++;
            }
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public double getPos(double d2, int i2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d2), Integer.valueOf(i2)})) == null) ? this.mValue[i2] : invokeCommon.doubleValue;
        }
    }

    public CurveFit() {
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

    public static CurveFit get(int i2, double[] dArr, double[][] dArr2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65537, null, i2, dArr, dArr2)) == null) {
            if (dArr.length == 1) {
                i2 = 2;
            }
            if (i2 != 0) {
                if (i2 != 2) {
                    return new LinearCurveFit(dArr, dArr2);
                }
                return new Constant(dArr[0], dArr2[0]);
            }
            return new MonotonicCurveFit(dArr, dArr2);
        }
        return (CurveFit) invokeILL.objValue;
    }

    public static CurveFit getArc(int[] iArr, double[] dArr, double[][] dArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, iArr, dArr, dArr2)) == null) ? new ArcCurveFit(iArr, dArr, dArr2) : (CurveFit) invokeLLL.objValue;
    }

    public abstract double getPos(double d2, int i2);

    public abstract void getPos(double d2, double[] dArr);

    public abstract void getPos(double d2, float[] fArr);

    public abstract double getSlope(double d2, int i2);

    public abstract void getSlope(double d2, double[] dArr);

    public abstract double[] getTimePoints();
}
