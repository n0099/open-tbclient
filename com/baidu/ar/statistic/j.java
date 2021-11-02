package com.baidu.ar.statistic;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.h.s;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.ar.ihttp.IHttpResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
public class j implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public j() {
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

    public JSONObject a(JSONObject jSONObject, a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, aVar)) == null) {
            String gg = aVar.gg();
            if (gg != null) {
                jSONObject.put("_uniq", gg);
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    @Override // com.baidu.ar.statistic.e
    public void a(Context context, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, aVar) == null) {
            if (context == null) {
                throw new SecurityException("context is cleared");
            }
            try {
                JSONObject gh = aVar.gh();
                a(gh, aVar);
                a(gh, context);
                h(gh);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.ar.statistic.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, List<a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, list) == null) {
            if (context == null) {
                throw new SecurityException("context is cleared");
            }
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = null;
            try {
                Map<String, Object> i2 = i(list);
                Set<String> keySet = i2 != null ? i2.keySet() : null;
                for (a aVar : list) {
                    if (jSONObject == null) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("event_id", "[multi]");
                            jSONObject = jSONObject2;
                        } catch (JSONException e2) {
                            e = e2;
                            jSONObject = jSONObject2;
                            e.printStackTrace();
                            if (jSONObject == null) {
                            }
                        }
                    }
                    JSONObject a2 = aVar.a(keySet);
                    a(a2, aVar);
                    jSONArray.put(a2);
                }
                if (jSONObject != null) {
                    if (i2 != null) {
                        for (Map.Entry<String, Object> entry : i2.entrySet()) {
                            jSONObject.put(entry.getKey(), entry.getValue());
                        }
                    }
                    a(jSONObject, context);
                    jSONObject.put("data", jSONArray);
                }
            } catch (JSONException e3) {
                e = e3;
            }
            if (jSONObject == null) {
                h(jSONObject);
            }
        }
    }

    public void a(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, context, jSONObject) == null) || context == null || jSONObject == null) {
            return;
        }
        jSONObject.put(HttpConstants.HTTP_OS_TYPE_OLD, "android");
        jSONObject.put("os_type", "android");
        jSONObject.put(HttpConstants.HTTP_ENGINE_VERSION, com.baidu.ar.h.c.getVersionCode());
        jSONObject.put("app_id", com.baidu.ar.h.c.s(context));
        jSONObject.put("device_id", Build.MODEL);
        jSONObject.put(HttpConstants.HTTP_SYSTEM_VERSION, Build.VERSION.SDK_INT);
        jSONObject.put(HttpConstants.OS_BRAND, Build.BRAND.toLowerCase());
        jSONObject.put(HttpConstants.OS_MODEL, Build.MODEL.toLowerCase());
        jSONObject.put(HttpConstants.OS_VERSION_SDK, Build.VERSION.SDK_INT);
        jSONObject.put(HttpConstants.OS_VERSION_RELESE, Build.VERSION.RELEASE);
        jSONObject.put(HttpConstants.OS_WIDTH_PIXELS, context.getResources().getDisplayMetrics().widthPixels);
        jSONObject.put(HttpConstants.OS_HEIGHT_PIXELS, context.getResources().getDisplayMetrics().heightPixels);
        jSONObject.put(HttpConstants.OS_SCALE_PDI, context.getResources().getDisplayMetrics().densityDpi);
        long[] gC = com.baidu.ar.h.q.gC();
        jSONObject.put(HttpConstants.OS_ROM_MEMORY, gC[0]);
        jSONObject.put(HttpConstants.OS_ROM_AVAIL_MEMORY, gC[1]);
        jSONObject.put(HttpConstants.OS_SDCARD_MEMORY, com.baidu.ar.h.q.gD());
        jSONObject.put(HttpConstants.OS_ROM_SDCARD_AVAIL_MEMORY, com.baidu.ar.h.q.gE());
        jSONObject.put(HttpConstants.OS_RAM_MEMEORY, com.baidu.ar.h.q.B(context));
        jSONObject.put(HttpConstants.OS_RAM_AVAIL_MEMORY, com.baidu.ar.h.q.C(context));
        if (com.baidu.ar.h.q.D(context)) {
            jSONObject.put(HttpConstants.OS_HAS_GYROSCOPE, 1);
        } else {
            jSONObject.put(HttpConstants.OS_HAS_GYROSCOPE, 0);
        }
        jSONObject.put(HttpConstants.OS_CPU_NAME, com.baidu.ar.h.q.gF());
        jSONObject.put(HttpConstants.OS_CPU_NUM_CORES, com.baidu.ar.h.q.gG());
        jSONObject.put(HttpConstants.OS_CPU_MIN_FREQ, com.baidu.ar.h.q.gH());
        jSONObject.put(HttpConstants.OS_CPU_MAX_FREQ, com.baidu.ar.h.q.gJ());
        jSONObject.put(HttpConstants.OS_CPU_ABI, Build.CPU_ABI);
        jSONObject.put(HttpConstants.OS_CPU_CUR_FREQ, com.baidu.ar.h.q.gK());
        jSONObject.put(HttpConstants.OS_NATIVE_HEAPSIZE, (int) (Runtime.getRuntime().maxMemory() / 1048576));
        jSONObject.put(HttpConstants.OS_NATIVE_SENSOR, ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(4) != null);
        jSONObject.put("network_type", com.baidu.ar.h.m.x(context));
        jSONObject.put(HttpConstants.OS_CPU_SUPPORTED_ABIS, Build.VERSION.SDK_INT < 21 ? Build.CPU_ABI : Arrays.asList(Build.SUPPORTED_ABIS));
        jSONObject.put(HttpConstants.HTTP_GLES_VERSION, ((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion >> 16);
    }

    public void a(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, jSONObject, context) == null) {
            UUID gz = new com.baidu.ar.h.g(context).gz();
            String uuid = gz != null ? gz.toString() : "";
            g(jSONObject);
            jSONObject.put(HttpConstants.AIP_APP_ID, DuMixARConfig.getAipAppId());
            jSONObject.put("cuid", ARConfig.getCUID());
            a(context, jSONObject);
            jSONObject.put("os_type", "android");
            jSONObject.put(HttpConstants.OS_VERSION, Build.MODEL);
            jSONObject.put("device_type", Build.BRAND);
            jSONObject.put("user_id", uuid);
            jSONObject.put("device_id", uuid);
            jSONObject.put(HttpConstants.OS_VERSION, Build.VERSION.SDK_INT);
            jSONObject.put("app_version", com.baidu.ar.h.c.getVersionCode());
            jSONObject.put(HttpConstants.HTTP_ENGINE_VERSION, com.baidu.ar.h.c.getVersionCode());
            if (!TextUtils.isEmpty(com.baidu.ar.h.c.s(context))) {
                jSONObject.put("app_id", com.baidu.ar.h.c.s(context));
            }
            jSONObject.put(HttpConstants.HTTP_SYSTEM_VERSION, Build.VERSION.SDK_INT);
            jSONObject.put(HttpConstants.HTTP_HARDWARE, Build.HARDWARE);
            jSONObject.put("manufacture", Build.MANUFACTURER);
            jSONObject.put(HttpConstants.HTTP_BOARD, Build.BOARD);
        }
    }

    public void g(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            jSONObject.put(HttpConstants.AIP_APP_ID, DuMixARConfig.getAipAppId());
            jSONObject.put(HttpConstants.IS_AIP, "3");
            Object[] signatureAndTime = ARConfig.getSignatureAndTime();
            jSONObject.put("sign", signatureAndTime[0]);
            jSONObject.put("timestamp", signatureAndTime[1]);
        }
    }

    public void h(JSONObject jSONObject) {
        IHttpRequest newRequest;
        String str;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) || (newRequest = HttpFactory.newRequest()) == null) {
            return;
        }
        newRequest.setUrl(s.gQ()).setMethod("POST").setBody(jSONObject);
        IHttpResponse execute = newRequest.execute();
        if (execute.isSuccess()) {
            i2 = execute.getCode();
            str = execute.getContent();
        } else {
            str = "";
            i2 = 0;
        }
        if (i2 != 200 || !str.equals("success")) {
            throw new IOException(String.format("stats response is error. code: %d response: %s", Integer.valueOf(i2), str));
        }
    }

    public Map<String, Object> i(List<a> list) {
        InterceptResult invokeL;
        Object aC;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, list)) == null) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            a aVar = list.get(0);
            ArrayList<String> arrayList = new ArrayList();
            Iterator<String> keys = aVar.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!"event_id".equals(next) && (aC = aVar.aC(next)) != null) {
                    hashMap.put(next, aC);
                    hashMap2.put(next, aC);
                    arrayList.add(next);
                }
            }
            int size = list.size();
            for (int i2 = 1; i2 < size; i2++) {
                a aVar2 = list.get(i2);
                for (String str : arrayList) {
                    if (hashMap2.containsKey(str) && !hashMap.get(str).equals(aVar2.aC(str))) {
                        hashMap2.remove(str);
                    }
                }
            }
            return hashMap2;
        }
        return (Map) invokeL.objValue;
    }
}
