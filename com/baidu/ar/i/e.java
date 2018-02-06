package com.baidu.ar.i;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.ar.bean.ARConfiguration;
import com.baidu.ar.i.f;
import com.baidu.ar.util.Constants;
import com.baidu.ar.util.g;
import com.baidu.ar.util.l;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Arrays;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class e {
    public static b a(int i, String str, boolean z, ContentResolver contentResolver, a<String> aVar) {
        b bVar = new b(i, z, contentResolver, aVar);
        bVar.execute(str);
        return bVar;
    }

    public static c a(Context context, ARConfiguration aRConfiguration, f.a<JSONObject> aVar) {
        String a = a(context, aRConfiguration);
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        String str = Constants.URL_TRACK_AR_PREFIX + Constants.URL_AR_QUERY_SERVICE + Constants.URL_TRACK_AR_ACTION_QUERY;
        com.baidu.ar.util.b.a("doQueryArResource: " + str);
        d dVar = new d(str, aVar);
        dVar.execute(a);
        return dVar;
    }

    public static String a(Context context, ARConfiguration aRConfiguration) {
        String jsonString;
        JSONObject jSONObject = new JSONObject();
        if (aRConfiguration != null) {
            try {
                jsonString = aRConfiguration.getJsonString();
            } catch (Exception e) {
                com.baidu.ar.util.b.d("doQueryArResource catch Exception");
                if (Constants.DEBUG_LOG) {
                    e.printStackTrace();
                }
            }
        } else {
            jsonString = null;
        }
        JSONObject jSONObject2 = jsonString != null ? new JSONObject(jsonString) : new JSONObject();
        UUID a = new g(context).a();
        if (a != null) {
            jSONObject2.put("user_id", a.toString());
        }
        jSONObject.put(Constants.HTTP_AR_VALUE, jSONObject2.toString());
        if (aRConfiguration != null) {
            String aRKey = aRConfiguration.getARKey();
            if (!TextUtils.isEmpty(aRKey)) {
                jSONObject.put(Constants.AR_KEY, aRKey);
            }
            String aRId = aRConfiguration.getARId();
            if (TextUtils.isEmpty(aRId)) {
                jSONObject.put("ar_id", "");
            } else {
                jSONObject.put("ar_id", aRId);
            }
        }
        jSONObject.put(Constants.HTTP_GLES_VERSION, ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getDeviceConfigurationInfo().reqGlEsVersion >> 16);
        jSONObject.put(Constants.HTTP_OS_TYPE, Constants.OS_TYPE_VALUE);
        jSONObject.put(Constants.HTTP_ENGINE_VERSION, com.baidu.ar.util.c.a());
        jSONObject.put(Constants.HTTP_APP_ID, com.baidu.ar.util.c.a(context));
        jSONObject.put(Constants.HTTP_DEVICE_ID, Build.MODEL);
        jSONObject.put(Constants.HTTP_SYSTEM_VERSION, Build.VERSION.SDK_INT);
        jSONObject.put("user_id", a.toString());
        a(context, jSONObject);
        b(context, jSONObject);
        com.baidu.ar.util.b.a("doQueryArResource = " + jSONObject.toString());
        return jSONObject.toString();
    }

    public static String a(Context context, String str) {
        return a(context, ARConfiguration.createARConfiguration(str));
    }

    public static void a(Context context, JSONObject jSONObject) {
        String lowerCase = context.getApplicationContext().getPackageName().toLowerCase();
        if (lowerCase.contains("box")) {
            jSONObject.put(Constants.AR_PUBLISH_ID, "2");
        } else if (lowerCase.contains("npc") || lowerCase.contains("map")) {
            jSONObject.put(Constants.AR_PUBLISH_ID, "6");
        } else {
            try {
                jSONObject.put(Constants.AR_PUBLISH_ID, "10000");
                jSONObject.put("sign", ARConfiguration.getSignature());
                jSONObject.put("timestamp", ARConfiguration.getTimestamp());
                String publishID = ARConfiguration.getPublishID();
                if (publishID == null || Integer.parseInt(publishID) <= 10000) {
                    return;
                }
                jSONObject.put(Constants.AR_PUBLISH_ID, publishID);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void b(Context context, JSONObject jSONObject) {
        if (context == null) {
            com.baidu.ar.util.b.d("bdar: postSystemInfo context is null!!!");
            return;
        }
        long[] a = l.a();
        long[] b = l.b();
        Sensor defaultSensor = ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(4);
        if (jSONObject != null) {
            jSONObject.put("os_brand", Build.BRAND.toLowerCase());
            jSONObject.put("os_model", Build.MODEL.toLowerCase());
            jSONObject.put("os_version_sdk", Build.VERSION.SDK_INT);
            jSONObject.put("os_version_release", Build.VERSION.RELEASE);
            jSONObject.put("os_width_pixels", context.getResources().getDisplayMetrics().widthPixels);
            jSONObject.put("os_height_pixels", context.getResources().getDisplayMetrics().heightPixels);
            jSONObject.put("os_scale_pdi", context.getResources().getDisplayMetrics().densityDpi);
            jSONObject.put("os_ram_avail_memory", l.c(context));
            jSONObject.put("os_ram_memory", l.b(context));
            jSONObject.put("os_rom_avail_memory", a[1]);
            jSONObject.put("os_rom_memory", a[0]);
            jSONObject.put("os_sdcard_avail_memory", b[1]);
            jSONObject.put("os_sdcard_memory", b[0]);
            jSONObject.put("os_has_gyroscope", l.d(context) ? Constants.OS_HAS_GYROSCOPE : Constants.OS_NOT_HAS_GYROSCOPE);
            jSONObject.put("os_cpu_name", l.c());
            jSONObject.put("os_cpu_num_cores", l.d());
            jSONObject.put("os_cpu_min_freq", l.e());
            jSONObject.put("os_cpu_max_freq", l.f());
            jSONObject.put("os_cpu_cur_freq", l.g());
            jSONObject.put("os_cpu_abi", Build.CPU_ABI);
            jSONObject.put("os_native_heapsize", (int) (Runtime.getRuntime().maxMemory() / 1048576));
            jSONObject.put("os_native_sensor", defaultSensor != null);
            if (Build.VERSION.SDK_INT < 21) {
                jSONObject.put("os_cpu_supported_abis", Build.CPU_ABI);
            } else {
                jSONObject.put("os_cpu_supported_abis", Arrays.asList(Build.SUPPORTED_ABIS));
            }
        }
    }
}
