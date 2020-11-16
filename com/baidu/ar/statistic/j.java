package com.baidu.ar.statistic;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.g.s;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.ar.ihttp.IHttpResponse;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
class j implements e {
    protected JSONObject a(JSONObject jSONObject, a aVar) {
        String gg = aVar.gg();
        if (gg != null) {
            jSONObject.put("_uniq", gg);
        }
        return jSONObject;
    }

    @Override // com.baidu.ar.statistic.e
    public void a(Context context, a aVar) {
        if (context == null) {
            throw new SecurityException("context is cleared");
        }
        try {
            JSONObject gh = aVar.gh();
            a(gh, aVar);
            a(gh, context);
            h(gh);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.ar.statistic.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, List<a> list) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        if (context == null) {
            throw new SecurityException("context is cleared");
        }
        JSONArray jSONArray = new JSONArray();
        try {
            Map<String, Object> i = i(list);
            Set<String> keySet = i != null ? i.keySet() : null;
            Iterator<a> it = list.iterator();
            while (true) {
                try {
                    jSONObject = jSONObject2;
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (jSONObject == null) {
                        jSONObject2 = new JSONObject();
                        jSONObject2.put("event_id", "[multi]");
                    } else {
                        jSONObject2 = jSONObject;
                    }
                    jSONObject = next.a(keySet);
                    a(jSONObject, next);
                    jSONArray.put(jSONObject);
                } catch (JSONException e) {
                    e = e;
                    jSONObject2 = jSONObject;
                    e.printStackTrace();
                    jSONObject = jSONObject2;
                    if (jSONObject == null) {
                    }
                }
            }
            if (jSONObject != null) {
                if (i != null) {
                    for (Map.Entry<String, Object> entry : i.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
                a(jSONObject, context);
                jSONObject.put("data", jSONArray);
            }
        } catch (JSONException e2) {
            e = e2;
        }
        if (jSONObject == null) {
            h(jSONObject);
        }
    }

    protected void a(Context context, JSONObject jSONObject) {
        if (context == null || jSONObject == null) {
            return;
        }
        jSONObject.put(HttpConstants.HTTP_OS_TYPE_OLD, "android");
        jSONObject.put(HttpConstants.HTTP_OS_TYPE, "android");
        jSONObject.put(HttpConstants.HTTP_ENGINE_VERSION, com.baidu.ar.g.c.getVersionCode());
        jSONObject.put("app_id", com.baidu.ar.g.c.r(context));
        jSONObject.put("device_id", Build.MODEL);
        jSONObject.put(HttpConstants.HTTP_SYSTEM_VERSION, Build.VERSION.SDK_INT);
        jSONObject.put(HttpConstants.OS_BRAND, Build.BRAND.toLowerCase());
        jSONObject.put(HttpConstants.OS_MODEL, Build.MODEL.toLowerCase());
        jSONObject.put(HttpConstants.OS_VERSION_SDK, Build.VERSION.SDK_INT);
        jSONObject.put(HttpConstants.OS_VERSION_RELESE, Build.VERSION.RELEASE);
        jSONObject.put(HttpConstants.OS_WIDTH_PIXELS, context.getResources().getDisplayMetrics().widthPixels);
        jSONObject.put(HttpConstants.OS_HEIGHT_PIXELS, context.getResources().getDisplayMetrics().heightPixels);
        jSONObject.put(HttpConstants.OS_SCALE_PDI, context.getResources().getDisplayMetrics().densityDpi);
        long[] gC = com.baidu.ar.g.q.gC();
        jSONObject.put(HttpConstants.OS_ROM_MEMORY, gC[0]);
        jSONObject.put(HttpConstants.OS_ROM_AVAIL_MEMORY, gC[1]);
        jSONObject.put(HttpConstants.OS_SDCARD_MEMORY, com.baidu.ar.g.q.gD());
        jSONObject.put(HttpConstants.OS_ROM_SDCARD_AVAIL_MEMORY, com.baidu.ar.g.q.gE());
        jSONObject.put(HttpConstants.OS_RAM_MEMEORY, com.baidu.ar.g.q.A(context));
        jSONObject.put(HttpConstants.OS_RAM_AVAIL_MEMORY, com.baidu.ar.g.q.B(context));
        if (com.baidu.ar.g.q.C(context)) {
            jSONObject.put(HttpConstants.OS_HAS_GYROSCOPE, 1);
        } else {
            jSONObject.put(HttpConstants.OS_HAS_GYROSCOPE, 0);
        }
        jSONObject.put(HttpConstants.OS_CPU_NAME, com.baidu.ar.g.q.gF());
        jSONObject.put(HttpConstants.OS_CPU_NUM_CORES, com.baidu.ar.g.q.gG());
        jSONObject.put(HttpConstants.OS_CPU_MIN_FREQ, com.baidu.ar.g.q.gH());
        jSONObject.put(HttpConstants.OS_CPU_MAX_FREQ, com.baidu.ar.g.q.gJ());
        jSONObject.put(HttpConstants.OS_CPU_ABI, Build.CPU_ABI);
        jSONObject.put(HttpConstants.OS_CPU_CUR_FREQ, com.baidu.ar.g.q.gK());
        jSONObject.put(HttpConstants.OS_NATIVE_HEAPSIZE, (int) (Runtime.getRuntime().maxMemory() / 1048576));
        jSONObject.put(HttpConstants.OS_NATIVE_SENSOR, ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(4) != null);
        jSONObject.put(HttpConstants.NETWORK_TYPE, com.baidu.ar.g.m.w(context));
        if (Build.VERSION.SDK_INT < 21) {
            jSONObject.put(HttpConstants.OS_CPU_SUPPORTED_ABIS, Build.CPU_ABI);
        } else {
            jSONObject.put(HttpConstants.OS_CPU_SUPPORTED_ABIS, Arrays.asList(Build.SUPPORTED_ABIS));
        }
        jSONObject.put(HttpConstants.HTTP_GLES_VERSION, ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getDeviceConfigurationInfo().reqGlEsVersion >> 16);
    }

    protected void a(JSONObject jSONObject, Context context) {
        UUID gz = new com.baidu.ar.g.g(context).gz();
        String uuid = gz != null ? gz.toString() : "";
        g(jSONObject);
        jSONObject.put(HttpConstants.AIP_APP_ID, DuMixARConfig.getAipAppId());
        jSONObject.put("cuid", ARConfig.getCUID());
        a(context, jSONObject);
        jSONObject.put(HttpConstants.HTTP_OS_TYPE, "android");
        jSONObject.put("os_version", Build.MODEL);
        jSONObject.put(HttpConstants.DEVICE_TYPE, Build.BRAND);
        jSONObject.put("user_id", uuid);
        jSONObject.put("device_id", uuid);
        jSONObject.put("os_version", Build.VERSION.SDK_INT);
        jSONObject.put("app_version", com.baidu.ar.g.c.getVersionCode());
        jSONObject.put(HttpConstants.HTTP_ENGINE_VERSION, com.baidu.ar.g.c.getVersionCode());
        if (!TextUtils.isEmpty(com.baidu.ar.g.c.r(context))) {
            jSONObject.put("app_id", com.baidu.ar.g.c.r(context));
        }
        jSONObject.put(HttpConstants.HTTP_SYSTEM_VERSION, Build.VERSION.SDK_INT);
        jSONObject.put(HttpConstants.HTTP_HARDWARE, Build.HARDWARE);
        jSONObject.put("manufacture", Build.MANUFACTURER);
        jSONObject.put(HttpConstants.HTTP_BOARD, Build.BOARD);
    }

    protected void g(JSONObject jSONObject) {
        jSONObject.put(HttpConstants.AIP_APP_ID, DuMixARConfig.getAipAppId());
        jSONObject.put(HttpConstants.IS_AIP, "3");
        Object[] signatureAndTime = ARConfig.getSignatureAndTime();
        jSONObject.put("sign", signatureAndTime[0]);
        jSONObject.put("timestamp", signatureAndTime[1]);
    }

    protected void h(JSONObject jSONObject) {
        int i;
        IHttpRequest newRequest = HttpFactory.newRequest();
        if (newRequest == null) {
            return;
        }
        newRequest.setUrl(s.gQ()).setMethod("POST").setBody(jSONObject);
        IHttpResponse execute = newRequest.execute();
        String str = "";
        if (execute.isSuccess()) {
            i = execute.getCode();
            str = execute.getContent();
        } else {
            i = 0;
        }
        if (i != 200 || !str.equals("success")) {
            throw new IOException(String.format("stats response is error. code: %d response: %s", Integer.valueOf(i), str));
        }
    }

    protected Map<String, Object> i(List<a> list) {
        Object az;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        a aVar = list.get(0);
        ArrayList<String> arrayList = new ArrayList();
        Iterator<String> keys = aVar.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!"event_id".equals(next) && (az = aVar.az(next)) != null) {
                hashMap.put(next, az);
                hashMap2.put(next, az);
                arrayList.add(next);
            }
        }
        int size = list.size();
        for (int i = 1; i < size; i++) {
            a aVar2 = list.get(i);
            for (String str : arrayList) {
                if (hashMap2.containsKey(str) && !hashMap.get(str).equals(aVar2.az(str))) {
                    hashMap2.remove(str);
                }
            }
        }
        return hashMap2;
    }
}
