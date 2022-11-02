package com.baidu.searchbox.launch;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.devicescore.IDeviceScore;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ScheduleStrategy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BUSINESS_PRIVATE_STICKINESS = "{\"bdwindow\": {\"high_device_stickiness\": 0.0001,\"mid_device_stickiness\": 0.005,\"low_device_stickiness\": 0.01},\"swan\": {\"high_device_stickiness\": 0.0005,\"mid_device_stickiness\": 0.025,\"low_device_stickiness\": 0.05}}";
    public static final boolean DEBUG;
    public static final double DEFAULT_DYNAMIC_SCORE_WEIGHT = 0.0d;
    public static final double DEFAULT_HIGH_DEVICE_STICKINESS_THRESHOLD = 0.001d;
    public static final double DEFAULT_LOW_DEVICE_STICKINESS_THRESHOLD = 0.1d;
    public static final double DEFAULT_LOW_MID_THRESHOLD = 0.37d;
    public static final double DEFAULT_MID_DEVICE_STICKINESS_THRESHOLD = 0.05d;
    public static final double DEFAULT_MID_HIGH_THRESHOLD = 0.6d;
    public static final double DEFAULT_STATIC_SCORE_WEIGHT = 1.0d;
    public static final int FAST_SCHEDULE_STRATEGY = 0;
    public static final String HIGH_DEVICE_STICKINESS_KEY = "high_device_stickiness";
    public static final int IDLE_SCHEDULE_STRATEGY = 1;
    public static final double INVALID = -1.0d;
    public static final String LOW_DEVICE_STICKINESS_KEY = "low_device_stickiness";
    public static final String MID_DEVICE_STICKINESS_KEY = "mid_device_stickiness";
    public static final String TAG = "ScheduleStrategy";
    public static Map<String, Double> businessPrivateThresholds;
    public static double commonStickinessThreshold;
    public static double deviceScore;
    public static double dynamicScore;
    public static double dynamicScoreWeight;
    public static double highDeviceStickinessThreshold;
    public static boolean isLoadPrivateStickiness;
    public static double lowDeviceStickinessThreshold;
    public static double lowMidThreshold;
    public static double midDeviceStickinessThreshold;
    public static double midHighThreshold;
    public static Context sContext;
    public static double staticScore;
    public static double staticScoreWeight;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.searchbox.launch.ScheduleStrategy$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$launch$ScheduleStrategy$DeviceType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-127626270, "Lcom/baidu/searchbox/launch/ScheduleStrategy$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-127626270, "Lcom/baidu/searchbox/launch/ScheduleStrategy$1;");
                    return;
                }
            }
            int[] iArr = new int[DeviceType.values().length];
            $SwitchMap$com$baidu$searchbox$launch$ScheduleStrategy$DeviceType = iArr;
            try {
                iArr[DeviceType.HIGH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$launch$ScheduleStrategy$DeviceType[DeviceType.MID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$launch$ScheduleStrategy$DeviceType[DeviceType.LOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class DeviceType {
        public static final /* synthetic */ DeviceType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final DeviceType HIGH;
        public static final DeviceType LOW;
        public static final DeviceType MID;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1192089779, "Lcom/baidu/searchbox/launch/ScheduleStrategy$DeviceType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1192089779, "Lcom/baidu/searchbox/launch/ScheduleStrategy$DeviceType;");
                    return;
                }
            }
            LOW = new DeviceType("LOW", 0);
            MID = new DeviceType("MID", 1);
            DeviceType deviceType = new DeviceType("HIGH", 2);
            HIGH = deviceType;
            $VALUES = new DeviceType[]{LOW, MID, deviceType};
        }

        public DeviceType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static DeviceType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (DeviceType) Enum.valueOf(DeviceType.class, str);
            }
            return (DeviceType) invokeL.objValue;
        }

        public static DeviceType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (DeviceType[]) $VALUES.clone();
            }
            return (DeviceType[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-853763121, "Lcom/baidu/searchbox/launch/ScheduleStrategy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-853763121, "Lcom/baidu/searchbox/launch/ScheduleStrategy;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
        staticScore = -1.0d;
        dynamicScore = -1.0d;
        deviceScore = -1.0d;
        isLoadPrivateStickiness = false;
        commonStickinessThreshold = -1.0d;
        businessPrivateThresholds = new HashMap();
        dynamicScoreWeight = 0.0d;
        staticScoreWeight = 1.0d;
        midHighThreshold = 0.6d;
        lowMidThreshold = 0.37d;
        highDeviceStickinessThreshold = 0.001d;
        midDeviceStickinessThreshold = 0.05d;
        lowDeviceStickinessThreshold = 0.1d;
    }

    public static void loadPrivateStickiness() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            double deviceScore2 = getDeviceScore();
            deviceScore = deviceScore2;
            if (deviceScore2 > midHighThreshold) {
                if (DEBUG) {
                    Log.d(TAG, "load stickiness threshold for high-performance devices");
                }
                commonStickinessThreshold = 0.001d;
                loadPrivateStickinessImpl(DeviceType.HIGH);
            } else if (deviceScore2 < lowMidThreshold && deviceScore2 >= 0.0d) {
                if (DEBUG) {
                    Log.d(TAG, "load stickiness threshold for low-performance devices");
                }
                commonStickinessThreshold = 0.1d;
                loadPrivateStickinessImpl(DeviceType.LOW);
            } else {
                if (DEBUG) {
                    Log.d(TAG, "load stickiness threshold for mid-performance devices");
                }
                commonStickinessThreshold = 0.05d;
                loadPrivateStickinessImpl(DeviceType.MID);
            }
        }
    }

    public ScheduleStrategy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        sContext = AppRuntime.getAppContext();
    }

    public static double getDynamicScore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            double d = dynamicScore;
            if (d >= 0.0d) {
                return d;
            }
            return -1.0f;
        }
        return invokeV.doubleValue;
    }

    public static double getStaticScore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            double d = staticScore;
            if (d >= 0.0d) {
                return d;
            }
            return -1.0d;
        }
        return invokeV.doubleValue;
    }

    public static double getDeviceScore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            double d = deviceScore;
            if (d >= 0.0d) {
                return d;
            }
            IDeviceScore iDeviceScore = (IDeviceScore) ServiceManager.getService(IDeviceScore.SERVICE_REFERENCE);
            if (iDeviceScore != null) {
                deviceScore = iDeviceScore.getFinalScore(BdBaseApplication.getInst());
            }
            return deviceScore;
        }
        return invokeV.doubleValue;
    }

    public static double getStickinessThreshold(String str) {
        InterceptResult invokeL;
        Double d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (!isLoadPrivateStickiness) {
                loadPrivateStickiness();
                if (DEBUG) {
                    Log.d(TAG, "loadPrivateStickiness finished");
                }
                isLoadPrivateStickiness = true;
            }
            if (businessPrivateThresholds.containsKey(str) && (d = businessPrivateThresholds.get(str)) != null && d.doubleValue() >= 0.0d) {
                if (DEBUG) {
                    Log.d(TAG, "stickiness(private) threshold for " + str + " is " + d);
                }
                return d.doubleValue();
            } else if (commonStickinessThreshold >= 0.0d) {
                if (DEBUG) {
                    Log.d(TAG, "stickiness(common) threshold for " + str + " is " + commonStickinessThreshold);
                }
                return commonStickinessThreshold;
            } else {
                return 0.05d;
            }
        }
        return invokeL.doubleValue;
    }

    public static void loadPrivateStickinessImpl(DeviceType deviceType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, deviceType) == null) {
            try {
                JSONObject jSONObject = new JSONObject(BUSINESS_PRIVATE_STICKINESS);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!TextUtils.isEmpty(next)) {
                        String optString = jSONObject.optString(next);
                        if (!TextUtils.isEmpty(optString)) {
                            JSONObject jSONObject2 = new JSONObject(optString);
                            int i = AnonymousClass1.$SwitchMap$com$baidu$searchbox$launch$ScheduleStrategy$DeviceType[deviceType.ordinal()];
                            if (i != 1) {
                                if (i != 2) {
                                    businessPrivateThresholds.put(next, Double.valueOf(jSONObject2.optDouble(LOW_DEVICE_STICKINESS_KEY, -1.0d)));
                                } else {
                                    businessPrivateThresholds.put(next, Double.valueOf(jSONObject2.optDouble(MID_DEVICE_STICKINESS_KEY, -1.0d)));
                                }
                            } else {
                                businessPrivateThresholds.put(next, Double.valueOf(jSONObject2.optDouble(HIGH_DEVICE_STICKINESS_KEY, -1.0d)));
                            }
                        }
                        if (DEBUG) {
                            Log.d(TAG, "businessID:" + next + " ## threshold:" + businessPrivateThresholds.get(next));
                        }
                    }
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d(TAG, "business_private_stickiness JsonException" + e.getStackTrace());
                }
            }
        }
    }

    public int getScheduleStrategy(SmartLaunchTask smartLaunchTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, smartLaunchTask)) == null) {
            smartLaunchTask.setType(1);
            return smartLaunchTask.getType();
        }
        return invokeL.intValue;
    }
}
