package com.baidu.platform.comapi.walknavi.d.a.f;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.platform.comapi.walknavi.d.a.f.f;
import com.baidu.platform.comapi.walknavi.d.a.g.h;
import com.baidu.searchbox.ui.animview.praise.PraiseDataPassUtil;
import com.baidu.tbadk.core.atomData.FrsArActivityConfig;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class e {
    public static c a(Context context, com.baidu.platform.comapi.walknavi.d.a.a.a aVar, f.a<JSONObject> aVar2) {
        String a = a(context, aVar);
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        String str = com.baidu.platform.comapi.walknavi.d.a.g.d.a + com.baidu.platform.comapi.walknavi.d.a.g.d.b + "/queryARResource";
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("doQueryArResource: " + str);
        d dVar = new d(str, aVar2);
        dVar.execute(a);
        return dVar;
    }

    public static String a(Context context, com.baidu.platform.comapi.walknavi.d.a.a.a aVar) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
        } catch (Exception e) {
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("doQueryArResource catch Exception");
        }
        if (aVar == null) {
            return jSONObject2.toString();
        }
        String d = aVar.d();
        if (d != null) {
            jSONObject = new JSONObject(d);
        } else {
            jSONObject = new JSONObject();
        }
        UUID a = new com.baidu.platform.comapi.walknavi.d.a.g.e(context).a();
        if (a != null) {
            jSONObject.put("user_id", a.toString());
        }
        jSONObject2.put("ar_value", jSONObject.toString());
        String a2 = aVar.a();
        if (!TextUtils.isEmpty(a2)) {
            jSONObject2.put("ar_key", a2);
        }
        String b = aVar.b();
        if (!TextUtils.isEmpty(b)) {
            jSONObject2.put(FrsArActivityConfig.AR_ID, b);
        } else {
            jSONObject2.put(FrsArActivityConfig.AR_ID, "");
        }
        jSONObject2.put("gles_version", ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getDeviceConfigurationInfo().reqGlEsVersion >> 16);
        jSONObject2.put("osType", PraiseDataPassUtil.KEY_FROM_OS);
        jSONObject2.put("engine_version", com.baidu.platform.comapi.walknavi.d.a.g.b.a());
        jSONObject2.put(Constants.APP_ID, com.baidu.platform.comapi.walknavi.d.a.g.b.a(context));
        jSONObject2.put(com.baidu.android.imsdk.internal.Constants.KEY_DEVICE_ID, Build.MODEL);
        jSONObject2.put("system_version", Build.VERSION.SDK_INT);
        jSONObject2.put("user_id", a.toString());
        jSONObject2.put("publish_id", "6");
        if (!com.baidu.platform.comapi.walknavi.d.a.b.a) {
            jSONObject2.put("update_check", 1);
        }
        a(context, jSONObject2);
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("doQueryArResource = " + jSONObject2.toString());
        return jSONObject2.toString();
    }

    public static b a(String str, int i, String str2, boolean z, a<String> aVar) {
        b bVar = new b(str, i, z, aVar);
        bVar.execute(str2);
        return bVar;
    }

    public static void a(Context context, JSONObject jSONObject) {
        try {
            if (context == null) {
                com.baidu.platform.comapi.walknavi.d.a.g.a.a("bdar: postSystemInfo context is null!!!");
            } else {
                long[] a = h.a();
                long[] b = h.b();
                Sensor defaultSensor = ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(4);
                if (jSONObject != null) {
                    jSONObject.put("os_brand", Build.BRAND.toLowerCase());
                    jSONObject.put("os_model", Build.MODEL.toLowerCase());
                    jSONObject.put("os_version_sdk", Build.VERSION.SDK_INT);
                    jSONObject.put("os_version_release", Build.VERSION.RELEASE);
                    jSONObject.put("os_width_pixels", context.getResources().getDisplayMetrics().widthPixels);
                    jSONObject.put("os_height_pixels", context.getResources().getDisplayMetrics().heightPixels);
                    jSONObject.put("os_scale_pdi", context.getResources().getDisplayMetrics().densityDpi);
                    jSONObject.put("os_ram_avail_memory", h.b(context));
                    jSONObject.put("os_ram_memory", h.a(context));
                    jSONObject.put("os_rom_avail_memory", a[1]);
                    jSONObject.put("os_rom_memory", a[0]);
                    jSONObject.put("os_sdcard_avail_memory", b[1]);
                    jSONObject.put("os_sdcard_memory", b[0]);
                    jSONObject.put("os_cpu_name", h.c());
                    jSONObject.put("os_cpu_num_cores", h.d());
                    jSONObject.put("os_cpu_min_freq", h.e());
                    jSONObject.put("os_cpu_max_freq", h.f());
                    jSONObject.put("os_cpu_cur_freq", h.g());
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
        } catch (Exception e) {
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("postSystemInfo catch Exception");
        }
    }
}
