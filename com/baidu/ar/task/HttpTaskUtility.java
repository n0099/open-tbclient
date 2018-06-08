package com.baidu.ar.task;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.util.ARLog;
import com.baidu.ar.util.ARSDKInfo;
import com.baidu.ar.util.DeviceUuidFactory;
import com.baidu.ar.util.NetworkUtil;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.ar.util.UrlUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class HttpTaskUtility {
    private static String a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            a(context, jSONObject, ARConfig.getARKey(), ARConfig.getARId());
            addCheckInfo(jSONObject);
            addSystemInfo(context, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    private static void a(Context context, JSONObject jSONObject, String str, String str2) {
        if (jSONObject == null) {
            ARLog.e("bdar: addCaseParams httpParams is null!!!");
            return;
        }
        String arValue = ARConfig.getArValue();
        JSONObject jSONObject2 = arValue != null ? new JSONObject(arValue) : new JSONObject();
        UUID deviceUuid = new DeviceUuidFactory(context).getDeviceUuid();
        if (deviceUuid != null) {
            jSONObject2.put("user_id", deviceUuid.toString());
            jSONObject.put("user_id", deviceUuid.toString());
        }
        jSONObject.put(HttpConstants.HTTP_AR_VALUE, jSONObject2.toString());
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put("ar_key", str);
        }
        if (TextUtils.isEmpty(str2)) {
            jSONObject.put("ar_id", "");
        } else {
            jSONObject.put("ar_id", str2);
        }
    }

    public static void addCheckInfo(JSONObject jSONObject) {
        if (jSONObject == null) {
            ARLog.e("bdar: addCheckInfo httpParams is null!!!");
            return;
        }
        jSONObject.put(HttpConstants.AIP_APP_ID, DuMixARConfig.getAipAppId());
        jSONObject.put(HttpConstants.IS_AIP, ARConfig.getIsAip());
        jSONObject.put("sign", ARConfig.getSignature());
        jSONObject.put(HttpConstants.TIMESTAMP, ARConfig.getTimestamp());
    }

    public static void addSystemInfo(Context context, JSONObject jSONObject) {
        if (context == null || jSONObject == null) {
            ARLog.e("bdar: addSystemInfo context/httpParams is null!!!");
            return;
        }
        jSONObject.put(HttpConstants.HTTP_OS_TYPE_OLD, HttpConstants.OS_TYPE_VALUE);
        jSONObject.put("os_type", HttpConstants.OS_TYPE_VALUE);
        jSONObject.put(HttpConstants.HTTP_ENGINE_VERSION, ARSDKInfo.getVersionCode());
        jSONObject.put(HttpConstants.HTTP_APP_ID, ARSDKInfo.getAppId(context));
        jSONObject.put("device_id", Build.MODEL);
        jSONObject.put(HttpConstants.HTTP_SYSTEM_VERSION, Build.VERSION.SDK_INT);
        jSONObject.put(HttpConstants.OS_BRAND, Build.BRAND.toLowerCase());
        jSONObject.put(HttpConstants.OS_MODEL, Build.MODEL.toLowerCase());
        jSONObject.put(HttpConstants.OS_VERSION_SDK, Build.VERSION.SDK_INT);
        jSONObject.put(HttpConstants.OS_VERSION_RELESE, Build.VERSION.RELEASE);
        jSONObject.put(HttpConstants.OS_WIDTH_PIXELS, context.getResources().getDisplayMetrics().widthPixels);
        jSONObject.put(HttpConstants.OS_HEIGHT_PIXELS, context.getResources().getDisplayMetrics().heightPixels);
        jSONObject.put(HttpConstants.OS_SCALE_PDI, context.getResources().getDisplayMetrics().densityDpi);
        long[] romMemroy = SystemInfoUtil.getRomMemroy();
        jSONObject.put(HttpConstants.OS_ROM_MEMORY, romMemroy[0]);
        jSONObject.put(HttpConstants.OS_ROM_AVAIL_MEMORY, romMemroy[1]);
        jSONObject.put(HttpConstants.OS_SDCARD_MEMORY, SystemInfoUtil.getSDCardTotalSize());
        jSONObject.put(HttpConstants.OS_ROM_SDCARD_AVAIL_MEMORY, SystemInfoUtil.getSDAvailableSizeByM());
        jSONObject.put(HttpConstants.OS_RAM_MEMEORY, SystemInfoUtil.getRamMemory(context));
        jSONObject.put(HttpConstants.OS_RAM_AVAIL_MEMORY, SystemInfoUtil.getAvailMemory(context));
        if (SystemInfoUtil.isHasGyroscope(context)) {
            jSONObject.put(HttpConstants.OS_HAS_GYROSCOPE, 1);
        } else {
            jSONObject.put(HttpConstants.OS_HAS_GYROSCOPE, 0);
        }
        jSONObject.put(HttpConstants.OS_CPU_NAME, SystemInfoUtil.getCpuName());
        jSONObject.put(HttpConstants.OS_CPU_NUM_CORES, SystemInfoUtil.getNumCores());
        jSONObject.put(HttpConstants.OS_CPU_MIN_FREQ, SystemInfoUtil.getMinCpuFreq());
        jSONObject.put(HttpConstants.OS_CPU_MAX_FREQ, SystemInfoUtil.getMaxCpuFreq());
        jSONObject.put(HttpConstants.OS_CPU_ABI, Build.CPU_ABI);
        jSONObject.put(HttpConstants.OS_CPU_CUR_FREQ, SystemInfoUtil.getCurCpuFreq());
        jSONObject.put(HttpConstants.OS_NATIVE_HEAPSIZE, (int) (Runtime.getRuntime().maxMemory() / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED));
        jSONObject.put(HttpConstants.OS_NATIVE_SENSOR, ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(4) != null);
        jSONObject.put(HttpConstants.NETWORK_TYPE, NetworkUtil.getNetworkType(context));
        if (Build.VERSION.SDK_INT < 21) {
            jSONObject.put(HttpConstants.OS_CPU_SUPPORTED_ABIS, Build.CPU_ABI);
        } else {
            jSONObject.put(HttpConstants.OS_CPU_SUPPORTED_ABIS, Arrays.asList(Build.SUPPORTED_ABIS));
        }
        jSONObject.put(HttpConstants.HTTP_GLES_VERSION, ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getDeviceConfigurationInfo().reqGlEsVersion >> 16);
    }

    public static HttpHandle doQueryArResource(Context context, HttpResponseListener<JSONObject> httpResponseListener) {
        String queryResourceUrl = UrlUtils.getQueryResourceUrl();
        ARLog.d("doQueryArResource: " + queryResourceUrl);
        String a = a(context);
        ARLog.d("doQueryArResource = " + a);
        b bVar = new b(context, queryResourceUrl, httpResponseListener);
        bVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, a);
        return bVar;
    }

    public static String getHttpParamsForCaseSwitch(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("update_check", String.valueOf(1));
        return getHttpParamsWithKeyAndMap(context, str, hashMap);
    }

    public static String getHttpParamsForMM(Context context) {
        return a(context);
    }

    public static String getHttpParamsWithKey(Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            a(context, jSONObject, str, null);
            addCheckInfo(jSONObject);
            addSystemInfo(context, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String getHttpParamsWithKeyAndMap(Context context, String str, Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            a(context, jSONObject, str, null);
            addCheckInfo(jSONObject);
            addSystemInfo(context, jSONObject);
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
