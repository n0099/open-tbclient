package androidx.core.location;

import android.content.Context;
import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.collection.SimpleArrayMap;
import androidx.core.location.GnssStatusCompat;
import androidx.core.os.CancellationSignal;
import androidx.core.os.ExecutorCompat;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.h;
import java.lang.reflect.Field;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes.dex */
public final class LocationManagerCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long GET_CURRENT_LOCATION_TIMEOUT_MS = 30000;
    public static final long MAX_CURRENT_LOCATION_AGE_MS = 10000;
    public static final long PRE_N_LOOPER_TIMEOUT_S = 5;
    public static Field sContextField;
    @GuardedBy("sGnssStatusListeners")
    public static final SimpleArrayMap<Object, Object> sGnssStatusListeners;
    public transient /* synthetic */ FieldHolder $fh;

    @RequiresApi(28)
    /* loaded from: classes.dex */
    public static class Api28Impl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Api28Impl() {
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
        public static String getGnssHardwareModelName(LocationManager locationManager) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, locationManager)) == null) {
                return locationManager.getGnssHardwareModelName();
            }
            return (String) invokeL.objValue;
        }

        @DoNotInline
        public static int getGnssYearOfHardware(LocationManager locationManager) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, locationManager)) == null) {
                return locationManager.getGnssYearOfHardware();
            }
            return invokeL.intValue;
        }

        @DoNotInline
        public static boolean isLocationEnabled(LocationManager locationManager) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, locationManager)) == null) {
                return locationManager.isLocationEnabled();
            }
            return invokeL.booleanValue;
        }
    }

    @RequiresApi(30)
    /* loaded from: classes.dex */
    public static class Api30Impl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Api30Impl() {
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

        @RequiresPermission(anyOf = {h.h, h.g})
        @DoNotInline
        public static void getCurrentLocation(LocationManager locationManager, @NonNull String str, @Nullable CancellationSignal cancellationSignal, @NonNull Executor executor, @NonNull Consumer<Location> consumer) {
            android.os.CancellationSignal cancellationSignal2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLLL(65537, null, locationManager, str, cancellationSignal, executor, consumer) == null) {
                if (cancellationSignal != null) {
                    cancellationSignal2 = (android.os.CancellationSignal) cancellationSignal.getCancellationSignalObject();
                } else {
                    cancellationSignal2 = null;
                }
                locationManager.getCurrentLocation(str, cancellationSignal2, executor, new java.util.function.Consumer<Location>(consumer) { // from class: androidx.core.location.LocationManagerCompat.Api30Impl.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Consumer val$consumer;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {consumer};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$consumer = consumer;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.function.Consumer
                    public void accept(Location location) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, location) == null) {
                            this.val$consumer.accept(location);
                        }
                    }
                });
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class CancellableLocationListener implements LocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Consumer<Location> mConsumer;
        public final Executor mExecutor;
        public final LocationManager mLocationManager;
        public final Handler mTimeoutHandler;
        @Nullable
        public Runnable mTimeoutRunnable;
        @GuardedBy("this")
        public boolean mTriggered;

        @Override // android.location.LocationListener
        public void onProviderEnabled(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            }
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048580, this, str, i, bundle) == null) {
            }
        }

        public CancellableLocationListener(LocationManager locationManager, Executor executor, Consumer<Location> consumer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {locationManager, executor, consumer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mLocationManager = locationManager;
            this.mExecutor = executor;
            this.mTimeoutHandler = new Handler(Looper.getMainLooper());
            this.mConsumer = consumer;
        }

        @RequiresPermission(anyOf = {h.h, h.g})
        private void cleanup() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                this.mConsumer = null;
                this.mLocationManager.removeUpdates(this);
                Runnable runnable = this.mTimeoutRunnable;
                if (runnable != null) {
                    this.mTimeoutHandler.removeCallbacks(runnable);
                    this.mTimeoutRunnable = null;
                }
            }
        }

        @RequiresPermission(anyOf = {h.h, h.g})
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    if (this.mTriggered) {
                        return;
                    }
                    this.mTriggered = true;
                    cleanup();
                }
            }
        }

        @Override // android.location.LocationListener
        @RequiresPermission(anyOf = {h.h, h.g})
        public void onLocationChanged(@Nullable Location location) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, location) == null) {
                synchronized (this) {
                    if (this.mTriggered) {
                        return;
                    }
                    this.mTriggered = true;
                    this.mExecutor.execute(new Runnable(this, this.mConsumer, location) { // from class: androidx.core.location.LocationManagerCompat.CancellableLocationListener.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ CancellableLocationListener this$0;
                        public final /* synthetic */ Consumer val$consumer;
                        public final /* synthetic */ Location val$location;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, r7, location};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$consumer = r7;
                            this.val$location = location;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.val$consumer.accept(this.val$location);
                            }
                        }
                    });
                    cleanup();
                }
            }
        }

        @Override // android.location.LocationListener
        @RequiresPermission(anyOf = {h.h, h.g})
        public void onProviderDisabled(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                onLocationChanged((Location) null);
            }
        }

        public void startTimeout(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
                synchronized (this) {
                    if (this.mTriggered) {
                        return;
                    }
                    Runnable runnable = new Runnable(this) { // from class: androidx.core.location.LocationManagerCompat.CancellableLocationListener.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ CancellableLocationListener this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // java.lang.Runnable
                        @RequiresPermission(anyOf = {h.h, h.g})
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                CancellableLocationListener cancellableLocationListener = this.this$0;
                                cancellableLocationListener.mTimeoutRunnable = null;
                                cancellableLocationListener.onLocationChanged((Location) null);
                            }
                        }
                    };
                    this.mTimeoutRunnable = runnable;
                    this.mTimeoutHandler.postDelayed(runnable, j);
                }
            }
        }
    }

    @RequiresApi(30)
    /* loaded from: classes.dex */
    public static class GnssStatusTransport extends GnssStatus.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final GnssStatusCompat.Callback mCallback;

        public GnssStatusTransport(GnssStatusCompat.Callback callback) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (callback != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "invalid null callback");
            this.mCallback = callback;
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.mCallback.onFirstFix(i);
            }
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gnssStatus) == null) {
                this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(gnssStatus));
            }
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.mCallback.onStarted();
            }
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.mCallback.onStopped();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class GpsStatusTransport implements GpsStatus.Listener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final GnssStatusCompat.Callback mCallback;
        @Nullable
        public volatile Executor mExecutor;
        public final LocationManager mLocationManager;

        public GpsStatusTransport(LocationManager locationManager, GnssStatusCompat.Callback callback) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {locationManager, callback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (callback != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "invalid null callback");
            this.mLocationManager = locationManager;
            this.mCallback = callback;
        }

        @Override // android.location.GpsStatus.Listener
        @RequiresPermission(h.g)
        public void onGpsStatusChanged(int i) {
            Executor executor;
            GpsStatus gpsStatus;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || (executor = this.mExecutor) == null) {
                return;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4 && (gpsStatus = this.mLocationManager.getGpsStatus(null)) != null) {
                            executor.execute(new Runnable(this, executor, GnssStatusCompat.wrap(gpsStatus)) { // from class: androidx.core.location.LocationManagerCompat.GpsStatusTransport.4
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ GpsStatusTransport this$0;
                                public final /* synthetic */ Executor val$executor;
                                public final /* synthetic */ GnssStatusCompat val$gnssStatus;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, executor, r8};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$0 = this;
                                    this.val$executor = executor;
                                    this.val$gnssStatus = r8;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable2 = $ic;
                                    if ((interceptable2 != null && interceptable2.invokeV(1048576, this) != null) || this.this$0.mExecutor != this.val$executor) {
                                        return;
                                    }
                                    this.this$0.mCallback.onSatelliteStatusChanged(this.val$gnssStatus);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    GpsStatus gpsStatus2 = this.mLocationManager.getGpsStatus(null);
                    if (gpsStatus2 != null) {
                        executor.execute(new Runnable(this, executor, gpsStatus2.getTimeToFirstFix()) { // from class: androidx.core.location.LocationManagerCompat.GpsStatusTransport.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ GpsStatusTransport this$0;
                            public final /* synthetic */ Executor val$executor;
                            public final /* synthetic */ int val$ttff;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, executor, Integer.valueOf(r8)};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$executor = executor;
                                this.val$ttff = r8;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if ((interceptable2 != null && interceptable2.invokeV(1048576, this) != null) || this.this$0.mExecutor != this.val$executor) {
                                    return;
                                }
                                this.this$0.mCallback.onFirstFix(this.val$ttff);
                            }
                        });
                        return;
                    }
                    return;
                }
                executor.execute(new Runnable(this, executor) { // from class: androidx.core.location.LocationManagerCompat.GpsStatusTransport.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ GpsStatusTransport this$0;
                    public final /* synthetic */ Executor val$executor;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, executor};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$executor = executor;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 != null && interceptable2.invokeV(1048576, this) != null) || this.this$0.mExecutor != this.val$executor) {
                            return;
                        }
                        this.this$0.mCallback.onStopped();
                    }
                });
                return;
            }
            executor.execute(new Runnable(this, executor) { // from class: androidx.core.location.LocationManagerCompat.GpsStatusTransport.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ GpsStatusTransport this$0;
                public final /* synthetic */ Executor val$executor;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, executor};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$executor = executor;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 != null && interceptable2.invokeV(1048576, this) != null) || this.this$0.mExecutor != this.val$executor) {
                        return;
                    }
                    this.this$0.mCallback.onStarted();
                }
            });
        }

        public void register(Executor executor) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, executor) == null) {
                if (this.mExecutor == null) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkState(z);
                this.mExecutor = executor;
            }
        }

        public void unregister() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.mExecutor = null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class InlineHandlerExecutor implements Executor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Handler mHandler;

        public InlineHandlerExecutor(@NonNull Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {handler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mHandler = (Handler) Preconditions.checkNotNull(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
                if (Looper.myLooper() == this.mHandler.getLooper()) {
                    runnable.run();
                } else if (this.mHandler.post((Runnable) Preconditions.checkNotNull(runnable))) {
                } else {
                    throw new RejectedExecutionException(this.mHandler + " is shutting down");
                }
            }
        }
    }

    @RequiresApi(24)
    /* loaded from: classes.dex */
    public static class PreRGnssStatusTransport extends GnssStatus.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final GnssStatusCompat.Callback mCallback;
        @Nullable
        public volatile Executor mExecutor;

        public PreRGnssStatusTransport(GnssStatusCompat.Callback callback) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (callback != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "invalid null callback");
            this.mCallback = callback;
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int i) {
            Executor executor;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || (executor = this.mExecutor) == null) {
                return;
            }
            executor.execute(new Runnable(this, executor, i) { // from class: androidx.core.location.LocationManagerCompat.PreRGnssStatusTransport.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PreRGnssStatusTransport this$0;
                public final /* synthetic */ Executor val$executor;
                public final /* synthetic */ int val$ttffMillis;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, executor, Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$executor = executor;
                    this.val$ttffMillis = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 != null && interceptable2.invokeV(1048576, this) != null) || this.this$0.mExecutor != this.val$executor) {
                        return;
                    }
                    this.this$0.mCallback.onFirstFix(this.val$ttffMillis);
                }
            });
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            Executor executor;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gnssStatus) != null) || (executor = this.mExecutor) == null) {
                return;
            }
            executor.execute(new Runnable(this, executor, gnssStatus) { // from class: androidx.core.location.LocationManagerCompat.PreRGnssStatusTransport.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PreRGnssStatusTransport this$0;
                public final /* synthetic */ Executor val$executor;
                public final /* synthetic */ GnssStatus val$status;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, executor, gnssStatus};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$executor = executor;
                    this.val$status = gnssStatus;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 != null && interceptable2.invokeV(1048576, this) != null) || this.this$0.mExecutor != this.val$executor) {
                        return;
                    }
                    this.this$0.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(this.val$status));
                }
            });
        }

        public void register(Executor executor) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, executor) == null) {
                boolean z2 = true;
                if (executor != null) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkArgument(z, "invalid null executor");
                if (this.mExecutor != null) {
                    z2 = false;
                }
                Preconditions.checkState(z2);
                this.mExecutor = executor;
            }
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            Executor executor;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (executor = this.mExecutor) == null) {
                return;
            }
            executor.execute(new Runnable(this, executor) { // from class: androidx.core.location.LocationManagerCompat.PreRGnssStatusTransport.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PreRGnssStatusTransport this$0;
                public final /* synthetic */ Executor val$executor;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, executor};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$executor = executor;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 != null && interceptable2.invokeV(1048576, this) != null) || this.this$0.mExecutor != this.val$executor) {
                        return;
                    }
                    this.this$0.mCallback.onStarted();
                }
            });
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            Executor executor;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (executor = this.mExecutor) == null) {
                return;
            }
            executor.execute(new Runnable(this, executor) { // from class: androidx.core.location.LocationManagerCompat.PreRGnssStatusTransport.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PreRGnssStatusTransport this$0;
                public final /* synthetic */ Executor val$executor;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, executor};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$executor = executor;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 != null && interceptable2.invokeV(1048576, this) != null) || this.this$0.mExecutor != this.val$executor) {
                        return;
                    }
                    this.this$0.mCallback.onStopped();
                }
            });
        }

        public void unregister() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.mExecutor = null;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1844233595, "Landroidx/core/location/LocationManagerCompat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1844233595, "Landroidx/core/location/LocationManagerCompat;");
                return;
            }
        }
        sGnssStatusListeners = new SimpleArrayMap<>();
    }

    public LocationManagerCompat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @RequiresPermission(anyOf = {h.h, h.g})
    public static void getCurrentLocation(@NonNull LocationManager locationManager, @NonNull String str, @Nullable CancellationSignal cancellationSignal, @NonNull Executor executor, @NonNull Consumer<Location> consumer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65538, null, locationManager, str, cancellationSignal, executor, consumer) == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                Api30Impl.getCurrentLocation(locationManager, str, cancellationSignal, executor, consumer);
                return;
            }
            if (cancellationSignal != null) {
                cancellationSignal.throwIfCanceled();
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation(str);
            if (lastKnownLocation != null && SystemClock.elapsedRealtime() - LocationCompat.getElapsedRealtimeMillis(lastKnownLocation) < 10000) {
                executor.execute(new Runnable(consumer, lastKnownLocation) { // from class: androidx.core.location.LocationManagerCompat.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Consumer val$consumer;
                    public final /* synthetic */ Location val$location;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {consumer, lastKnownLocation};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$consumer = consumer;
                        this.val$location = lastKnownLocation;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.val$consumer.accept(this.val$location);
                        }
                    }
                });
                return;
            }
            CancellableLocationListener cancellableLocationListener = new CancellableLocationListener(locationManager, executor, consumer);
            locationManager.requestLocationUpdates(str, 0L, 0.0f, cancellableLocationListener, Looper.getMainLooper());
            if (cancellationSignal != null) {
                cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener(cancellableLocationListener) { // from class: androidx.core.location.LocationManagerCompat.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ CancellableLocationListener val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {cancellableLocationListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$listener = cancellableLocationListener;
                    }

                    @Override // androidx.core.os.CancellationSignal.OnCancelListener
                    @RequiresPermission(anyOf = {h.h, h.g})
                    public void onCancel() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.val$listener.cancel();
                        }
                    }
                });
            }
            cancellableLocationListener.startTimeout(30000L);
        }
    }

    @Nullable
    public static String getGnssHardwareModelName(@NonNull LocationManager locationManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, locationManager)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.getGnssHardwareModelName(locationManager);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static int getGnssYearOfHardware(@NonNull LocationManager locationManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, locationManager)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.getGnssYearOfHardware(locationManager);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static boolean isLocationEnabled(@NonNull LocationManager locationManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, locationManager)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 28) {
                return Api28Impl.isLocationEnabled(locationManager);
            }
            if (i <= 19) {
                try {
                    if (sContextField == null) {
                        Field declaredField = LocationManager.class.getDeclaredField("mContext");
                        sContextField = declaredField;
                        declaredField.setAccessible(true);
                    }
                    Context context = (Context) sContextField.get(locationManager);
                    if (context != null) {
                        if (Build.VERSION.SDK_INT == 19) {
                            if (Settings.Secure.getInt(context.getContentResolver(), "location_mode", 0) == 0) {
                                return false;
                            }
                            return true;
                        }
                        return !TextUtils.isEmpty(ApiReplaceUtil.Overload.getString(context.getContentResolver(), "location_providers_allowed"));
                    }
                } catch (ClassCastException | IllegalAccessException | NoSuchFieldException | SecurityException unused) {
                }
            }
            if (!locationManager.isProviderEnabled("network") && !locationManager.isProviderEnabled("gps")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:91:0x0118 A[Catch: all -> 0x0134, TryCatch #7 {all -> 0x0134, blocks: (B:85:0x00f7, B:86:0x010d, B:89:0x0110, B:91:0x0118, B:93:0x0120, B:94:0x0126, B:95:0x0127, B:96:0x012c, B:97:0x012d, B:98:0x0133, B:75:0x00e6), top: B:114:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012d A[Catch: all -> 0x0134, TryCatch #7 {all -> 0x0134, blocks: (B:85:0x00f7, B:86:0x010d, B:89:0x0110, B:91:0x0118, B:93:0x0120, B:94:0x0126, B:95:0x0127, B:96:0x012c, B:97:0x012d, B:98:0x0133, B:75:0x00e6), top: B:114:0x00a6 }] */
    @RequiresPermission(h.g)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean registerGnssStatusCallback(LocationManager locationManager, Handler handler, Executor executor, GnssStatusCompat.Callback callback) {
        InterceptResult invokeLLLL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65542, null, locationManager, handler, executor, callback)) == null) {
            int i = Build.VERSION.SDK_INT;
            boolean z3 = true;
            if (i >= 30) {
                synchronized (sGnssStatusListeners) {
                    GnssStatus.Callback callback2 = (GnssStatusTransport) sGnssStatusListeners.get(callback);
                    if (callback2 == null) {
                        callback2 = new GnssStatusTransport(callback);
                    }
                    if (!locationManager.registerGnssStatusCallback(executor, callback2)) {
                        return false;
                    }
                    sGnssStatusListeners.put(callback, callback2);
                    return true;
                }
            } else if (i >= 24) {
                if (handler != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Preconditions.checkArgument(z2);
                synchronized (sGnssStatusListeners) {
                    PreRGnssStatusTransport preRGnssStatusTransport = (PreRGnssStatusTransport) sGnssStatusListeners.get(callback);
                    if (preRGnssStatusTransport == null) {
                        preRGnssStatusTransport = new PreRGnssStatusTransport(callback);
                    } else {
                        preRGnssStatusTransport.unregister();
                    }
                    preRGnssStatusTransport.register(executor);
                    if (!locationManager.registerGnssStatusCallback(preRGnssStatusTransport, handler)) {
                        return false;
                    }
                    sGnssStatusListeners.put(callback, preRGnssStatusTransport);
                    return true;
                }
            } else {
                if (handler != null) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkArgument(z);
                synchronized (sGnssStatusListeners) {
                    GpsStatusTransport gpsStatusTransport = (GpsStatusTransport) sGnssStatusListeners.get(callback);
                    if (gpsStatusTransport == null) {
                        gpsStatusTransport = new GpsStatusTransport(locationManager, callback);
                    } else {
                        gpsStatusTransport.unregister();
                    }
                    gpsStatusTransport.register(executor);
                    FutureTask futureTask = new FutureTask(new Callable<Boolean>(locationManager, gpsStatusTransport) { // from class: androidx.core.location.LocationManagerCompat.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ LocationManager val$locationManager;
                        public final /* synthetic */ GpsStatusTransport val$myTransport;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {locationManager, gpsStatusTransport};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.val$locationManager = locationManager;
                            this.val$myTransport = gpsStatusTransport;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // java.util.concurrent.Callable
                        @RequiresPermission(h.g)
                        public Boolean call() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                                return Boolean.valueOf(this.val$locationManager.addGpsStatusListener(this.val$myTransport));
                            }
                            return (Boolean) invokeV.objValue;
                        }
                    });
                    if (Looper.myLooper() == handler.getLooper()) {
                        futureTask.run();
                    } else if (!handler.post(futureTask)) {
                        throw new IllegalStateException(handler + " is shutting down");
                    }
                    try {
                        try {
                            long nanos = TimeUnit.SECONDS.toNanos(5L);
                            long nanoTime = System.nanoTime() + nanos;
                            boolean z4 = false;
                            while (((Boolean) futureTask.get(nanos, TimeUnit.NANOSECONDS)).booleanValue()) {
                                try {
                                    try {
                                        sGnssStatusListeners.put(callback, gpsStatusTransport);
                                        if (z4) {
                                            Thread.currentThread().interrupt();
                                        }
                                        return true;
                                    } catch (ExecutionException e) {
                                        e = e;
                                        if (e.getCause() instanceof RuntimeException) {
                                            if (e.getCause() instanceof Error) {
                                                throw ((Error) e.getCause());
                                            }
                                            throw new IllegalStateException(e);
                                        }
                                        throw ((RuntimeException) e.getCause());
                                    } catch (TimeoutException e2) {
                                        e = e2;
                                        throw new IllegalStateException(handler + " appears to be blocked, please run registerGnssStatusCallback() directly on a Looper thread or ensure the main Looper is not blocked by this thread", e);
                                    }
                                } catch (InterruptedException unused) {
                                    nanos = nanoTime - System.nanoTime();
                                    z4 = true;
                                } catch (ExecutionException e3) {
                                    e = e3;
                                    if (e.getCause() instanceof RuntimeException) {
                                    }
                                } catch (TimeoutException e4) {
                                    e = e4;
                                    throw new IllegalStateException(handler + " appears to be blocked, please run registerGnssStatusCallback() directly on a Looper thread or ensure the main Looper is not blocked by this thread", e);
                                } catch (Throwable th) {
                                    th = th;
                                    z3 = z4;
                                    if (z3) {
                                        Thread.currentThread().interrupt();
                                    }
                                    throw th;
                                }
                            }
                            if (z4) {
                                Thread.currentThread().interrupt();
                            }
                            return false;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (ExecutionException e5) {
                        e = e5;
                    } catch (TimeoutException e6) {
                        e = e6;
                    } catch (Throwable th3) {
                        th = th3;
                        z3 = false;
                    }
                }
            }
        } else {
            return invokeLLLL.booleanValue;
        }
    }

    @RequiresPermission(h.g)
    public static boolean registerGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull GnssStatusCompat.Callback callback, @NonNull Handler handler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, locationManager, callback, handler)) == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                return registerGnssStatusCallback(locationManager, ExecutorCompat.create(handler), callback);
            }
            return registerGnssStatusCallback(locationManager, new InlineHandlerExecutor(handler), callback);
        }
        return invokeLLL.booleanValue;
    }

    @RequiresPermission(h.g)
    public static boolean registerGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull Executor executor, @NonNull GnssStatusCompat.Callback callback) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, locationManager, executor, callback)) == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                return registerGnssStatusCallback(locationManager, null, executor, callback);
            }
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                myLooper = Looper.getMainLooper();
            }
            return registerGnssStatusCallback(locationManager, new Handler(myLooper), executor, callback);
        }
        return invokeLLL.booleanValue;
    }

    public static void unregisterGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull GnssStatusCompat.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, locationManager, callback) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                synchronized (sGnssStatusListeners) {
                    GnssStatus.Callback callback2 = (GnssStatusTransport) sGnssStatusListeners.remove(callback);
                    if (callback2 != null) {
                        locationManager.unregisterGnssStatusCallback(callback2);
                    }
                }
            } else if (i >= 24) {
                synchronized (sGnssStatusListeners) {
                    PreRGnssStatusTransport preRGnssStatusTransport = (PreRGnssStatusTransport) sGnssStatusListeners.remove(callback);
                    if (preRGnssStatusTransport != null) {
                        preRGnssStatusTransport.unregister();
                        locationManager.unregisterGnssStatusCallback(preRGnssStatusTransport);
                    }
                }
            } else {
                synchronized (sGnssStatusListeners) {
                    GpsStatusTransport gpsStatusTransport = (GpsStatusTransport) sGnssStatusListeners.remove(callback);
                    if (gpsStatusTransport != null) {
                        gpsStatusTransport.unregister();
                        locationManager.removeGpsStatusListener(gpsStatusTransport);
                    }
                }
            }
        }
    }
}
