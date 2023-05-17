package com.baidu.searchbox.launch;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.devicescore.IDeviceScore;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ScheduleStrategy {
    public static final String BUSINESS_PRIVATE_STICKINESS = "{\"bdwindow\": {\"high_device_stickiness\": 0.0001,\"mid_device_stickiness\": 0.005,\"low_device_stickiness\": 0.01},\"swan\": {\"high_device_stickiness\": 0.0005,\"mid_device_stickiness\": 0.025,\"low_device_stickiness\": 0.05}}";
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
    public static Context sContext;
    public static final boolean DEBUG = AppConfig.isDebug();
    public static double staticScore = -1.0d;
    public static double dynamicScore = -1.0d;
    public static double deviceScore = -1.0d;
    public static boolean isLoadPrivateStickiness = false;
    public static double commonStickinessThreshold = -1.0d;
    public static Map<String, Double> businessPrivateThresholds = new HashMap();
    public static double dynamicScoreWeight = 0.0d;
    public static double staticScoreWeight = 1.0d;
    public static double midHighThreshold = 0.6d;
    public static double lowMidThreshold = 0.37d;
    public static double highDeviceStickinessThreshold = 0.001d;
    public static double midDeviceStickinessThreshold = 0.05d;
    public static double lowDeviceStickinessThreshold = 0.1d;

    /* loaded from: classes3.dex */
    public enum DeviceType {
        LOW,
        MID,
        HIGH
    }

    /* renamed from: com.baidu.searchbox.launch.ScheduleStrategy$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$launch$ScheduleStrategy$DeviceType;

        static {
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

    public ScheduleStrategy() {
        sContext = AppRuntime.getAppContext();
    }

    public static double getDeviceScore() {
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

    public static double getDynamicScore() {
        double d = dynamicScore;
        if (d >= 0.0d) {
            return d;
        }
        return -1.0f;
    }

    public static double getStaticScore() {
        double d = staticScore;
        if (d >= 0.0d) {
            return d;
        }
        return -1.0d;
    }

    public static double getStickinessThreshold(String str) {
        Double d;
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

    public static void loadPrivateStickiness() {
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

    public static void loadPrivateStickinessImpl(DeviceType deviceType) {
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

    public int getScheduleStrategy(SmartLaunchTask smartLaunchTask) {
        smartLaunchTask.setType(1);
        return smartLaunchTask.getType();
    }
}
