package androidx.constraintlayout.motion.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes.dex */
public class Easing {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACCELERATE = "cubic(0.4, 0.05, 0.8, 0.7)";
    public static final String ACCELERATE_NAME = "accelerate";
    public static final String DECELERATE = "cubic(0.0, 0.0, 0.2, 0.95)";
    public static final String DECELERATE_NAME = "decelerate";
    public static final String LINEAR = "cubic(1, 1, 0, 0)";
    public static final String LINEAR_NAME = "linear";
    public static String[] NAMED_EASING = null;
    public static final String STANDARD = "cubic(0.4, 0.0, 0.2, 1)";
    public static final String STANDARD_NAME = "standard";
    public static Easing sDefault;
    public transient /* synthetic */ FieldHolder $fh;
    public String str;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(412636615, "Landroidx/constraintlayout/motion/utils/Easing;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(412636615, "Landroidx/constraintlayout/motion/utils/Easing;");
                return;
            }
        }
        sDefault = new Easing();
        NAMED_EASING = new String[]{"standard", ACCELERATE_NAME, DECELERATE_NAME, LINEAR_NAME};
    }

    public Easing() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.str = "identity";
    }

    public static Easing getInterpolator(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str == null) {
                return null;
            }
            if (str.startsWith("cubic")) {
                return new CubicEasing(str);
            }
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1354466595:
                    if (str.equals(ACCELERATE_NAME)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1263948740:
                    if (str.equals(DECELERATE_NAME)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1102672091:
                    if (str.equals(LINEAR_NAME)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1312628413:
                    if (str.equals("standard")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 != 3) {
                            String str2 = "transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(NAMED_EASING);
                            return sDefault;
                        }
                        return new CubicEasing(LINEAR);
                    }
                    return new CubicEasing(DECELERATE);
                }
                return new CubicEasing(ACCELERATE);
            }
            return new CubicEasing(STANDARD);
        }
        return (Easing) invokeL.objValue;
    }

    public double get(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d2)})) == null) ? d2 : invokeCommon.doubleValue;
    }

    public double getDiff(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d2)})) == null) {
            return 1.0d;
        }
        return invokeCommon.doubleValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.str : (String) invokeV.objValue;
    }

    /* loaded from: classes.dex */
    public static class CubicEasing extends Easing {
        public static /* synthetic */ Interceptable $ic = null;
        public static double d_error = 1.0E-4d;
        public static double error = 0.01d;
        public transient /* synthetic */ FieldHolder $fh;
        public double x1;
        public double x2;
        public double y1;
        public double y2;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-298420330, "Landroidx/constraintlayout/motion/utils/Easing$CubicEasing;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-298420330, "Landroidx/constraintlayout/motion/utils/Easing$CubicEasing;");
            }
        }

        public CubicEasing(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.str = str;
            int indexOf = str.indexOf(40);
            int indexOf2 = str.indexOf(44, indexOf);
            this.x1 = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
            int i4 = indexOf2 + 1;
            int indexOf3 = str.indexOf(44, i4);
            this.y1 = Double.parseDouble(str.substring(i4, indexOf3).trim());
            int i5 = indexOf3 + 1;
            int indexOf4 = str.indexOf(44, i5);
            this.x2 = Double.parseDouble(str.substring(i5, indexOf4).trim());
            int i6 = indexOf4 + 1;
            this.y2 = Double.parseDouble(str.substring(i6, str.indexOf(41, i6)).trim());
        }

        private double getDiffX(double d2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Double.valueOf(d2)})) == null) {
                double d3 = 1.0d - d2;
                double d4 = this.x1;
                double d5 = this.x2;
                return (d3 * 3.0d * d3 * d4) + (d3 * 6.0d * d2 * (d5 - d4)) + (3.0d * d2 * d2 * (1.0d - d5));
            }
            return invokeCommon.doubleValue;
        }

        private double getDiffY(double d2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Double.valueOf(d2)})) == null) {
                double d3 = 1.0d - d2;
                double d4 = this.y1;
                double d5 = this.y2;
                return (d3 * 3.0d * d3 * d4) + (d3 * 6.0d * d2 * (d5 - d4)) + (3.0d * d2 * d2 * (1.0d - d5));
            }
            return invokeCommon.doubleValue;
        }

        private double getX(double d2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{Double.valueOf(d2)})) == null) {
                double d3 = 1.0d - d2;
                double d4 = 3.0d * d3;
                return (this.x1 * d3 * d4 * d2) + (this.x2 * d4 * d2 * d2) + (d2 * d2 * d2);
            }
            return invokeCommon.doubleValue;
        }

        private double getY(double d2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{Double.valueOf(d2)})) == null) {
                double d3 = 1.0d - d2;
                double d4 = 3.0d * d3;
                return (this.y1 * d3 * d4 * d2) + (this.y2 * d4 * d2 * d2) + (d2 * d2 * d2);
            }
            return invokeCommon.doubleValue;
        }

        @Override // androidx.constraintlayout.motion.utils.Easing
        public double get(double d2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d2)})) == null) {
                if (d2 <= 0.0d) {
                    return 0.0d;
                }
                if (d2 >= 1.0d) {
                    return 1.0d;
                }
                double d3 = 0.5d;
                double d4 = 0.5d;
                while (d3 > error) {
                    d3 *= 0.5d;
                    d4 = getX(d4) < d2 ? d4 + d3 : d4 - d3;
                }
                double d5 = d4 - d3;
                double x = getX(d5);
                double d6 = d4 + d3;
                double x2 = getX(d6);
                double y = getY(d5);
                return (((getY(d6) - y) * (d2 - x)) / (x2 - x)) + y;
            }
            return invokeCommon.doubleValue;
        }

        @Override // androidx.constraintlayout.motion.utils.Easing
        public double getDiff(double d2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d2)})) == null) {
                double d3 = 0.5d;
                double d4 = 0.5d;
                while (d3 > d_error) {
                    d3 *= 0.5d;
                    d4 = getX(d4) < d2 ? d4 + d3 : d4 - d3;
                }
                double d5 = d4 - d3;
                double d6 = d4 + d3;
                return (getY(d6) - getY(d5)) / (getX(d6) - getX(d5));
            }
            return invokeCommon.doubleValue;
        }

        public void setup(double d2, double d3, double d4, double d5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5)}) == null) {
                this.x1 = d2;
                this.y1 = d3;
                this.x2 = d4;
                this.y2 = d5;
            }
        }

        public CubicEasing(double d2, double d3, double d4, double d5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            setup(d2, d3, d4, d5);
        }
    }
}
