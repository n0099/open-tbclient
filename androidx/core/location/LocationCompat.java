package androidx.core.location;

import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class LocationCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_IS_MOCK = "mockLocation";
    @Nullable
    public static Method sSetIsFromMockProviderMethod;
    public transient /* synthetic */ FieldHolder $fh;

    @RequiresApi(17)
    /* loaded from: classes.dex */
    public static class Api17Impl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Api17Impl() {
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

        @DoNotInline
        public static long getElapsedRealtimeNanos(Location location) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, location)) == null) {
                return location.getElapsedRealtimeNanos();
            }
            return invokeL.longValue;
        }
    }

    @RequiresApi(18)
    /* loaded from: classes.dex */
    public static class Api18Impl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Api18Impl() {
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

        @DoNotInline
        public static boolean isMock(Location location) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, location)) == null) {
                return location.isFromMockProvider();
            }
            return invokeL.booleanValue;
        }
    }

    public LocationCompat() {
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

    public static Method getSetIsFromMockProviderMethod() throws NoSuchMethodException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (sSetIsFromMockProviderMethod == null) {
                Method declaredMethod = Location.class.getDeclaredMethod("setIsFromMockProvider", Boolean.TYPE);
                sSetIsFromMockProviderMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            return sSetIsFromMockProviderMethod;
        }
        return (Method) invokeV.objValue;
    }

    public static long getElapsedRealtimeMillis(@NonNull Location location) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, location)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                return TimeUnit.NANOSECONDS.toMillis(Api17Impl.getElapsedRealtimeNanos(location));
            }
            long currentTimeMillis = System.currentTimeMillis() - location.getTime();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (currentTimeMillis < 0) {
                return elapsedRealtime;
            }
            if (currentTimeMillis > elapsedRealtime) {
                return 0L;
            }
            return elapsedRealtime - currentTimeMillis;
        }
        return invokeL.longValue;
    }

    public static long getElapsedRealtimeNanos(@NonNull Location location) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, location)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                return Api17Impl.getElapsedRealtimeNanos(location);
            }
            return TimeUnit.MILLISECONDS.toNanos(getElapsedRealtimeMillis(location));
        }
        return invokeL.longValue;
    }

    public static boolean isMock(@NonNull Location location) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, location)) == null) {
            if (Build.VERSION.SDK_INT >= 18) {
                return Api18Impl.isMock(location);
            }
            Bundle extras = location.getExtras();
            if (extras == null) {
                return false;
            }
            return extras.getBoolean(EXTRA_IS_MOCK, false);
        }
        return invokeL.booleanValue;
    }

    public static void setMock(@NonNull Location location, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65541, null, location, z) == null) {
            if (Build.VERSION.SDK_INT >= 18) {
                try {
                    getSetIsFromMockProviderMethod().invoke(location, Boolean.valueOf(z));
                    return;
                } catch (IllegalAccessException e) {
                    IllegalAccessError illegalAccessError = new IllegalAccessError();
                    illegalAccessError.initCause(e);
                    throw illegalAccessError;
                } catch (NoSuchMethodException e2) {
                    NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
                    noSuchMethodError.initCause(e2);
                    throw noSuchMethodError;
                } catch (InvocationTargetException e3) {
                    throw new RuntimeException(e3);
                }
            }
            Bundle extras = location.getExtras();
            if (extras == null) {
                Bundle bundle = new Bundle();
                bundle.putBoolean(EXTRA_IS_MOCK, true);
                location.setExtras(bundle);
                return;
            }
            extras.putBoolean(EXTRA_IS_MOCK, true);
        }
    }
}
