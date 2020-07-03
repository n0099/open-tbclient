package com.baidu.ar.f;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.constants.HttpConstants;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Arrays;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m {
    private static String wS = null;

    public static void a(Context context, JSONObject jSONObject) {
        if (context == null || jSONObject == null) {
            b.aL("bdar: addSystemInfo context/httpParams is null!!!");
            return;
        }
        jSONObject.put(HttpConstants.HTTP_OS_TYPE_OLD, "android");
        jSONObject.put(HttpConstants.HTTP_OS_TYPE, "android");
        jSONObject.put(HttpConstants.HTTP_ENGINE_VERSION, c.getVersionCode());
        jSONObject.put("app_id", c.q(context));
        jSONObject.put("device_id", Build.MODEL);
        jSONObject.put(HttpConstants.HTTP_SYSTEM_VERSION, Build.VERSION.SDK_INT);
        jSONObject.put(HttpConstants.OS_BRAND, Build.BRAND.toLowerCase());
        jSONObject.put(HttpConstants.OS_MODEL, Build.MODEL.toLowerCase());
        jSONObject.put(HttpConstants.OS_VERSION_SDK, Build.VERSION.SDK_INT);
        jSONObject.put(HttpConstants.OS_VERSION_RELESE, Build.VERSION.RELEASE);
        jSONObject.put(HttpConstants.OS_WIDTH_PIXELS, context.getResources().getDisplayMetrics().widthPixels);
        jSONObject.put(HttpConstants.OS_HEIGHT_PIXELS, context.getResources().getDisplayMetrics().heightPixels);
        jSONObject.put(HttpConstants.OS_SCALE_PDI, context.getResources().getDisplayMetrics().densityDpi);
        long[] fo = o.fo();
        jSONObject.put(HttpConstants.OS_ROM_MEMORY, fo[0]);
        jSONObject.put(HttpConstants.OS_ROM_AVAIL_MEMORY, fo[1]);
        jSONObject.put(HttpConstants.OS_SDCARD_MEMORY, o.fp());
        jSONObject.put(HttpConstants.OS_ROM_SDCARD_AVAIL_MEMORY, o.fq());
        jSONObject.put(HttpConstants.OS_RAM_MEMEORY, o.z(context));
        jSONObject.put(HttpConstants.OS_RAM_AVAIL_MEMORY, o.A(context));
        if (o.B(context)) {
            jSONObject.put(HttpConstants.OS_HAS_GYROSCOPE, 1);
        } else {
            jSONObject.put(HttpConstants.OS_HAS_GYROSCOPE, 0);
        }
        jSONObject.put(HttpConstants.OS_CPU_NAME, o.fr());
        jSONObject.put(HttpConstants.OS_CPU_NUM_CORES, o.fs());
        jSONObject.put(HttpConstants.OS_CPU_MIN_FREQ, o.ft());
        jSONObject.put(HttpConstants.OS_CPU_MAX_FREQ, o.fu());
        jSONObject.put(HttpConstants.OS_CPU_ABI, Build.CPU_ABI);
        jSONObject.put(HttpConstants.OS_CPU_CUR_FREQ, o.fv());
        jSONObject.put(HttpConstants.OS_NATIVE_HEAPSIZE, (int) (Runtime.getRuntime().maxMemory() / 1048576));
        jSONObject.put(HttpConstants.OS_NATIVE_SENSOR, ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(4) != null);
        jSONObject.put(HttpConstants.NETWORK_TYPE, k.v(context));
        if (Build.VERSION.SDK_INT < 21) {
            jSONObject.put(HttpConstants.OS_CPU_SUPPORTED_ABIS, Build.CPU_ABI);
        } else {
            jSONObject.put(HttpConstants.OS_CPU_SUPPORTED_ABIS, Arrays.asList(Build.SUPPORTED_ABIS));
        }
        jSONObject.put(HttpConstants.HTTP_GLES_VERSION, ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getDeviceConfigurationInfo().reqGlEsVersion >> 16);
        jSONObject.put(HttpConstants.HTTP_BOARD, Build.BOARD);
        jSONObject.put(HttpConstants.HTTP_HARDWARE, Build.HARDWARE);
        jSONObject.put(HttpConstants.HTTP_MANUFACTURER, Build.MANUFACTURER);
    }

    public static void b(Context context, JSONObject jSONObject) {
        if (context == null || jSONObject == null) {
            return;
        }
        jSONObject.put("user_id", w(context));
        jSONObject.put("cuid", ARConfig.getCUID());
    }

    public static void g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String aipAppId = DuMixARConfig.getAipAppId();
        jSONObject.put(HttpConstants.AIP_APP_ID, TextUtils.isEmpty(aipAppId) ? 0 : Integer.parseInt(aipAppId));
        jSONObject.put(HttpConstants.IS_AIP, "3");
        Object[] signatureAndTime = ARConfig.getSignatureAndTime();
        jSONObject.put("sign", signatureAndTime[0]);
        jSONObject.put("timestamp", signatureAndTime[1]);
    }

    public static String w(Context context) {
        if (wS == null && context != null) {
            UUID fl = new e(context).fl();
            wS = fl != null ? fl.toString() : "";
        }
        return wS;
    }
}
