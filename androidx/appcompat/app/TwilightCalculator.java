package androidx.appcompat.app;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class TwilightCalculator {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float ALTIDUTE_CORRECTION_CIVIL_TWILIGHT = -0.10471976f;
    public static final float C1 = 0.0334196f;
    public static final float C2 = 3.49066E-4f;
    public static final float C3 = 5.236E-6f;
    public static final int DAY = 0;
    public static final float DEGREES_TO_RADIANS = 0.017453292f;
    public static final float J0 = 9.0E-4f;
    public static final int NIGHT = 1;
    public static final float OBLIQUITY = 0.4092797f;
    public static final long UTC_2000 = 946728000000L;
    public static TwilightCalculator sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public int state;
    public long sunrise;
    public long sunset;

    public TwilightCalculator() {
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

    public static TwilightCalculator getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sInstance == null) {
                sInstance = new TwilightCalculator();
            }
            return sInstance;
        }
        return (TwilightCalculator) invokeV.objValue;
    }

    public void calculateTwilight(long j, double d, double d2) {
        float f;
        float f2;
        double d3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Double.valueOf(d), Double.valueOf(d2)}) == null) {
            double d4 = (0.01720197f * (((float) (j - UTC_2000)) / 8.64E7f)) + 6.24006f;
            double sin = (Math.sin(d4) * 0.03341960161924362d) + d4 + (Math.sin(2.0f * f2) * 3.4906598739326E-4d) + (Math.sin(f2 * 3.0f) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
            double round = ((float) Math.round((f - 9.0E-4f) - d3)) + 9.0E-4f + ((-d2) / 360.0d) + (Math.sin(d4) * 0.0053d) + (Math.sin(2.0d * sin) * (-0.0069d));
            double asin = Math.asin(Math.sin(sin) * Math.sin(0.4092797040939331d));
            double d5 = 0.01745329238474369d * d;
            double sin2 = (Math.sin(-0.10471975803375244d) - (Math.sin(d5) * Math.sin(asin))) / (Math.cos(d5) * Math.cos(asin));
            if (sin2 >= 1.0d) {
                this.state = 1;
                this.sunset = -1L;
                this.sunrise = -1L;
            } else if (sin2 <= -1.0d) {
                this.state = 0;
                this.sunset = -1L;
                this.sunrise = -1L;
            } else {
                double acos = (float) (Math.acos(sin2) / 6.283185307179586d);
                this.sunset = Math.round((round + acos) * 8.64E7d) + UTC_2000;
                long round2 = Math.round((round - acos) * 8.64E7d) + UTC_2000;
                this.sunrise = round2;
                if (round2 < j && this.sunset > j) {
                    this.state = 0;
                } else {
                    this.state = 1;
                }
            }
        }
    }
}
