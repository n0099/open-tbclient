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

    public abstract double getPos(double d, int i);

    public abstract void getPos(double d, double[] dArr);

    public abstract void getPos(double d, float[] fArr);

    public abstract double getSlope(double d, int i);

    public abstract void getSlope(double d, double[] dArr);

    public abstract double[] getTimePoints();

    /* loaded from: classes.dex */
    public static class Constant extends CurveFit {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public double mTime;
        public double[] mValue;

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public double getSlope(double d, int i) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Double.valueOf(d), Integer.valueOf(i)})) == null) {
                return 0.0d;
            }
            return invokeCommon.doubleValue;
        }

        public Constant(double d, double[] dArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Double.valueOf(d), dArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mTime = d;
            this.mValue = dArr;
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public double getPos(double d, int i) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d), Integer.valueOf(i)})) == null) {
                return this.mValue[i];
            }
            return invokeCommon.doubleValue;
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public void getSlope(double d, double[] dArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Double.valueOf(d), dArr}) == null) {
                for (int i = 0; i < this.mValue.length; i++) {
                    dArr[i] = 0.0d;
                }
            }
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public void getPos(double d, double[] dArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d), dArr}) == null) {
                double[] dArr2 = this.mValue;
                System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
            }
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public void getPos(double d, float[] fArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d), fArr}) == null) {
                int i = 0;
                while (true) {
                    double[] dArr = this.mValue;
                    if (i < dArr.length) {
                        fArr[i] = (float) dArr[i];
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new double[]{this.mTime} : (double[]) invokeV.objValue;
        }
    }

    public CurveFit() {
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

    public static CurveFit get(int i, double[] dArr, double[][] dArr2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65537, null, i, dArr, dArr2)) == null) {
            if (dArr.length == 1) {
                i = 2;
            }
            if (i != 0) {
                if (i != 2) {
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, iArr, dArr, dArr2)) == null) {
            return new ArcCurveFit(iArr, dArr, dArr2);
        }
        return (CurveFit) invokeLLL.objValue;
    }
}
