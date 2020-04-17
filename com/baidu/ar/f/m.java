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
    private static String ws = null;

    public static void a(Context context, JSONObject jSONObject) {
        if (context == null || jSONObject == null) {
            b.aK("bdar: addSystemInfo context/httpParams is null!!!");
            return;
        }
        jSONObject.put(HttpConstants.HTTP_OS_TYPE_OLD, "android");
        jSONObject.put(HttpConstants.HTTP_OS_TYPE, "android");
        jSONObject.put(HttpConstants.HTTP_ENGINE_VERSION, c.getVersionCode());
        jSONObject.put("app_id", c.o(context));
        jSONObject.put("device_id", Build.MODEL);
        jSONObject.put(HttpConstants.HTTP_SYSTEM_VERSION, Build.VERSION.SDK_INT);
        jSONObject.put(HttpConstants.OS_BRAND, Build.BRAND.toLowerCase());
        jSONObject.put(HttpConstants.OS_MODEL, Build.MODEL.toLowerCase());
        jSONObject.put(HttpConstants.OS_VERSION_SDK, Build.VERSION.SDK_INT);
        jSONObject.put(HttpConstants.OS_VERSION_RELESE, Build.VERSION.RELEASE);
        jSONObject.put(HttpConstants.OS_WIDTH_PIXELS, context.getResources().getDisplayMetrics().widthPixels);
        jSONObject.put(HttpConstants.OS_HEIGHT_PIXELS, context.getResources().getDisplayMetrics().heightPixels);
        jSONObject.put(HttpConstants.OS_SCALE_PDI, context.getResources().getDisplayMetrics().densityDpi);
        long[] eY = o.eY();
        jSONObject.put(HttpConstants.OS_ROM_MEMORY, eY[0]);
        jSONObject.put(HttpConstants.OS_ROM_AVAIL_MEMORY, eY[1]);
        jSONObject.put(HttpConstants.OS_SDCARD_MEMORY, o.eZ());
        jSONObject.put(HttpConstants.OS_ROM_SDCARD_AVAIL_MEMORY, o.fa());
        jSONObject.put(HttpConstants.OS_RAM_MEMEORY, o.x(context));
        jSONObject.put(HttpConstants.OS_RAM_AVAIL_MEMORY, o.y(context));
        if (o.z(context)) {
            jSONObject.put(HttpConstants.OS_HAS_GYROSCOPE, 1);
        } else {
            jSONObject.put(HttpConstants.OS_HAS_GYROSCOPE, 0);
        }
        jSONObject.put(HttpConstants.OS_CPU_NAME, o.fb());
        jSONObject.put(HttpConstants.OS_CPU_NUM_CORES, o.fc());
        jSONObject.put(HttpConstants.OS_CPU_MIN_FREQ, o.fd());
        jSONObject.put(HttpConstants.OS_CPU_MAX_FREQ, o.fe());
        jSONObject.put(HttpConstants.OS_CPU_ABI, Build.CPU_ABI);
        jSONObject.put(HttpConstants.OS_CPU_CUR_FREQ, o.ff());
        jSONObject.put(HttpConstants.OS_NATIVE_HEAPSIZE, (int) (Runtime.getRuntime().maxMemory() / 1048576));
        jSONObject.put(HttpConstants.OS_NATIVE_SENSOR, ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(4) != null);
        jSONObject.put(HttpConstants.NETWORK_TYPE, k.t(context));
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
        jSONObject.put("user_id", u(context));
        jSONObject.put("cuid", ARConfig.getCUID());
    }

    public static void f(JSONObject jSONObject) {
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

    public static String u(Context context) {
        if (ws == null && context != null) {
            UUID eV = new e(context).eV();
            ws = eV != null ? eV.toString() : "";
        }
        return ws;
    }
}
