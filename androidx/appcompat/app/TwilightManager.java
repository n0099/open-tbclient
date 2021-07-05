package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.PermissionChecker;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Calendar;
/* loaded from: classes.dex */
public class TwilightManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SUNRISE = 6;
    public static final int SUNSET = 22;
    public static final String TAG = "TwilightManager";
    public static TwilightManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context mContext;
    public final LocationManager mLocationManager;
    public final TwilightState mTwilightState;

    /* loaded from: classes.dex */
    public static class TwilightState {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean isNight;
        public long nextUpdate;
        public long todaySunrise;
        public long todaySunset;
        public long tomorrowSunrise;
        public long yesterdaySunset;

        public TwilightState() {
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
    }

    @VisibleForTesting
    public TwilightManager(@NonNull Context context, @NonNull LocationManager locationManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, locationManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTwilightState = new TwilightState();
        this.mContext = context;
        this.mLocationManager = locationManager;
    }

    public static TwilightManager getInstance(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (sInstance == null) {
                Context applicationContext = context.getApplicationContext();
                sInstance = new TwilightManager(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            return sInstance;
        }
        return (TwilightManager) invokeL.objValue;
    }

    @SuppressLint({"MissingPermission"})
    private Location getLastKnownLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            Location lastKnownLocationForProvider = PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? getLastKnownLocationForProvider("network") : null;
            Location lastKnownLocationForProvider2 = PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0 ? getLastKnownLocationForProvider("gps") : null;
            return (lastKnownLocationForProvider2 == null || lastKnownLocationForProvider == null) ? lastKnownLocationForProvider2 != null ? lastKnownLocationForProvider2 : lastKnownLocationForProvider : lastKnownLocationForProvider2.getTime() > lastKnownLocationForProvider.getTime() ? lastKnownLocationForProvider2 : lastKnownLocationForProvider;
        }
        return (Location) invokeV.objValue;
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    private Location getLastKnownLocationForProvider(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            try {
                if (this.mLocationManager.isProviderEnabled(str)) {
                    return this.mLocationManager.getLastKnownLocation(str);
                }
                return null;
            } catch (Exception e2) {
                Log.d(TAG, "Failed to get last known location", e2);
                return null;
            }
        }
        return (Location) invokeL.objValue;
    }

    private boolean isStateValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, this)) == null) ? this.mTwilightState.nextUpdate > System.currentTimeMillis() : invokeV.booleanValue;
    }

    @VisibleForTesting
    public static void setInstance(TwilightManager twilightManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, twilightManager) == null) {
            sInstance = twilightManager;
        }
    }

    private void updateState(@NonNull Location location) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, location) == null) {
            TwilightState twilightState = this.mTwilightState;
            long currentTimeMillis = System.currentTimeMillis();
            TwilightCalculator twilightCalculator = TwilightCalculator.getInstance();
            twilightCalculator.calculateTwilight(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
            long j2 = twilightCalculator.sunset;
            twilightCalculator.calculateTwilight(currentTimeMillis, location.getLatitude(), location.getLongitude());
            boolean z = twilightCalculator.state == 1;
            long j3 = twilightCalculator.sunrise;
            long j4 = twilightCalculator.sunset;
            boolean z2 = z;
            twilightCalculator.calculateTwilight(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
            long j5 = twilightCalculator.sunrise;
            if (j3 == -1 || j4 == -1) {
                j = 43200000 + currentTimeMillis;
            } else {
                j = (currentTimeMillis > j4 ? 0 + j5 : currentTimeMillis > j3 ? 0 + j4 : 0 + j3) + 60000;
            }
            twilightState.isNight = z2;
            twilightState.yesterdaySunset = j2;
            twilightState.todaySunrise = j3;
            twilightState.todaySunset = j4;
            twilightState.tomorrowSunrise = j5;
            twilightState.nextUpdate = j;
        }
    }

    public boolean isNight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            TwilightState twilightState = this.mTwilightState;
            if (isStateValid()) {
                return twilightState.isNight;
            }
            Location lastKnownLocation = getLastKnownLocation();
            if (lastKnownLocation != null) {
                updateState(lastKnownLocation);
                return twilightState.isNight;
            }
            Log.i(TAG, "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
            int i2 = Calendar.getInstance().get(11);
            return i2 < 6 || i2 >= 22;
        }
        return invokeV.booleanValue;
    }
}
