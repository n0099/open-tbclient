package c.i.d.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public final class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final t a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f30994b;

    /* renamed from: c  reason: collision with root package name */
    public long f30995c;

    /* renamed from: d  reason: collision with root package name */
    public long f30996d;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2077213701, "Lc/i/d/a/p$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2077213701, "Lc/i/d/a/p$a;");
                    return;
                }
            }
            int[] iArr = new int[TimeUnit.values().length];
            a = iArr;
            try {
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public p() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = t.b();
    }

    public static String a(TimeUnit timeUnit) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, timeUnit)) == null) {
            switch (a.a[timeUnit.ordinal()]) {
                case 1:
                    return NotificationStyle.NOTIFICATION_STYLE;
                case 2:
                    return "μs";
                case 3:
                    return "ms";
                case 4:
                    return "s";
                case 5:
                    return "min";
                case 6:
                    return "h";
                case 7:
                    return "d";
                default:
                    throw new AssertionError();
            }
        }
        return (String) invokeL.objValue;
    }

    public static TimeUnit b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j2)) == null) {
            if (TimeUnit.DAYS.convert(j2, TimeUnit.NANOSECONDS) > 0) {
                return TimeUnit.DAYS;
            }
            if (TimeUnit.HOURS.convert(j2, TimeUnit.NANOSECONDS) > 0) {
                return TimeUnit.HOURS;
            }
            if (TimeUnit.MINUTES.convert(j2, TimeUnit.NANOSECONDS) > 0) {
                return TimeUnit.MINUTES;
            }
            if (TimeUnit.SECONDS.convert(j2, TimeUnit.NANOSECONDS) > 0) {
                return TimeUnit.SECONDS;
            }
            if (TimeUnit.MILLISECONDS.convert(j2, TimeUnit.NANOSECONDS) > 0) {
                return TimeUnit.MILLISECONDS;
            }
            if (TimeUnit.MICROSECONDS.convert(j2, TimeUnit.NANOSECONDS) > 0) {
                return TimeUnit.MICROSECONDS;
            }
            return TimeUnit.NANOSECONDS;
        }
        return (TimeUnit) invokeJ.objValue;
    }

    public static p c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            p pVar = new p();
            pVar.h();
            return pVar;
        }
        return (p) invokeV.objValue;
    }

    public static p d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? new p() : (p) invokeV.objValue;
    }

    public long e(TimeUnit timeUnit) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, timeUnit)) == null) ? timeUnit.convert(f(), TimeUnit.NANOSECONDS) : invokeL.longValue;
    }

    public final long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f30994b ? (this.a.a() - this.f30996d) + this.f30995c : this.f30995c : invokeV.longValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30994b : invokeV.booleanValue;
    }

    public p h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            n.x(!this.f30994b, "This stopwatch is already running.");
            this.f30994b = true;
            this.f30996d = this.a.a();
            return this;
        }
        return (p) invokeV.objValue;
    }

    public p i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            long a2 = this.a.a();
            n.x(this.f30994b, "This stopwatch is already stopped.");
            this.f30994b = false;
            this.f30995c += a2 - this.f30996d;
            return this;
        }
        return (p) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            long f2 = f();
            TimeUnit b2 = b(f2);
            double convert = f2 / TimeUnit.NANOSECONDS.convert(1L, b2);
            return m.b(convert) + " " + a(b2);
        }
        return (String) invokeV.objValue;
    }
}
