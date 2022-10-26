package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.h;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public TwilightManager(Context context, LocationManager locationManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, locationManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTwilightState = new TwilightState();
        this.mContext = context;
        this.mLocationManager = locationManager;
    }

    public static TwilightManager getInstance(Context context) {
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

    private Location getLastKnownLocationForProvider(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            try {
                if (this.mLocationManager.isProviderEnabled(str)) {
                    return this.mLocationManager.getLastKnownLocation(str);
                }
                return null;
            } catch (Exception e) {
                Log.d(TAG, "Failed to get last known location", e);
                return null;
            }
        }
        return (Location) invokeL.objValue;
    }

    public static void setInstance(TwilightManager twilightManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, twilightManager) == null) {
            sInstance = twilightManager;
        }
    }

    private Location getLastKnownLocation() {
        InterceptResult invokeV;
        Location location;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            Location location2 = null;
            if (PermissionChecker.checkSelfPermission(this.mContext, h.h) == 0) {
                location = getLastKnownLocationForProvider("network");
            } else {
                location = null;
            }
            if (PermissionChecker.checkSelfPermission(this.mContext, h.g) == 0) {
                location2 = getLastKnownLocationForProvider("gps");
            }
            if (location2 != null && location != null) {
                if (location2.getTime() > location.getTime()) {
                    return location2;
                }
                return location;
            } else if (location2 != null) {
                return location2;
            } else {
                return location;
            }
        }
        return (Location) invokeV.objValue;
    }

    private boolean isStateValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (this.mTwilightState.nextUpdate > System.currentTimeMillis()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void updateState(Location location) {
        boolean z;
        long j;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, location) == null) {
            TwilightState twilightState = this.mTwilightState;
            long currentTimeMillis = System.currentTimeMillis();
            TwilightCalculator twilightCalculator = TwilightCalculator.getInstance();
            twilightCalculator.calculateTwilight(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
            long j3 = twilightCalculator.sunset;
            twilightCalculator.calculateTwilight(currentTimeMillis, location.getLatitude(), location.getLongitude());
            if (twilightCalculator.state == 1) {
                z = true;
            } else {
                z = false;
            }
            long j4 = twilightCalculator.sunrise;
            long j5 = twilightCalculator.sunset;
            boolean z2 = z;
            twilightCalculator.calculateTwilight(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
            long j6 = twilightCalculator.sunrise;
            if (j4 != -1 && j5 != -1) {
                if (currentTimeMillis > j5) {
                    j2 = 0 + j6;
                } else if (currentTimeMillis > j4) {
                    j2 = 0 + j5;
                } else {
                    j2 = 0 + j4;
                }
                j = j2 + 60000;
            } else {
                j = 43200000 + currentTimeMillis;
            }
            twilightState.isNight = z2;
            twilightState.yesterdaySunset = j3;
            twilightState.todaySunrise = j4;
            twilightState.todaySunset = j5;
            twilightState.tomorrowSunrise = j6;
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
            int i = Calendar.getInstance().get(11);
            if (i >= 6 && i < 22) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
