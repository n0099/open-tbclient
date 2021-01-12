package com.baidu.swan.apps.statistic;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.adaptation.a.w;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.u.c.b;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(V8ExceptionInfo v8ExceptionInfo) {
        if (v8ExceptionInfo == null) {
            if (DEBUG) {
                Log.d("V8StabilityHelper", "empty exceptionInfo");
                return;
            }
            return;
        }
        c(v8ExceptionInfo);
        b(v8ExceptionInfo);
    }

    private static void b(V8ExceptionInfo v8ExceptionInfo) {
        if (!com.baidu.swan.apps.t.a.awB().agp()) {
            if (DEBUG) {
                Log.d("V8StabilityHelper", "upload js switch off");
            }
        } else if (!TextUtils.isEmpty(v8ExceptionInfo.filePath)) {
            final String str = v8ExceptionInfo.filePath;
            if (str.startsWith("script:")) {
                if (DEBUG) {
                    Log.d("V8StabilityHelper", "file path start with js code prefix");
                    return;
                }
                return;
            }
            SwanCoreVersion jA = com.baidu.swan.apps.swancore.b.jA(com.baidu.swan.apps.runtime.d.aIn().afr());
            if (jA != null && !TextUtils.isEmpty(jA.swanCorePath)) {
                if (!str.startsWith(jA.swanCorePath)) {
                    if (DEBUG) {
                        Log.d("V8StabilityHelper", "file path is not swan core path");
                        return;
                    }
                    return;
                }
                final File file = new File(str);
                if (file.exists()) {
                    final HashMap hashMap = new HashMap();
                    com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
                    if (!TextUtils.isEmpty(com.baidu.swan.apps.runtime.e.aIt())) {
                        hashMap.put("appId", com.baidu.swan.apps.runtime.e.aIt());
                    }
                    if (aIr != null && !TextUtils.isEmpty(aIr.getVersion())) {
                        hashMap.put("appVersion", aIr.getVersion());
                    }
                    if (!TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg)) {
                        hashMap.put("exceptionMsg", v8ExceptionInfo.exceptionMsg);
                    }
                    if (!TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace)) {
                        hashMap.put("exceptionTrace", v8ExceptionInfo.exceptionTrace);
                    }
                    if (!TextUtils.isEmpty(v8ExceptionInfo.exceptionType)) {
                        hashMap.put("exceptionType", v8ExceptionInfo.exceptionType);
                    }
                    p.a(new Runnable() { // from class: com.baidu.swan.apps.statistic.i.1
                        @Override // java.lang.Runnable
                        public void run() {
                            w awH = com.baidu.swan.apps.t.a.awH();
                            if (awH != null) {
                                awH.a(hashMap, file, (w.a) null, "error_js");
                                if (i.DEBUG) {
                                    Log.d("V8StabilityHelper", "extraData :" + hashMap.toString());
                                    Log.d("V8StabilityHelper", "filePath :" + str);
                                }
                            }
                        }
                    }, "error_js");
                }
            }
        }
    }

    private static void c(V8ExceptionInfo v8ExceptionInfo) {
        if (!com.baidu.swan.apps.t.a.awB().agq()) {
            if (DEBUG) {
                Log.d("V8StabilityHelper", "stability switch off");
                return;
            }
            return;
        }
        b.a aVar = null;
        com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
        if (aIr != null) {
            aVar = aIr.afB();
        }
        com.baidu.swan.apps.statistic.a.d sx = new com.baidu.swan.apps.statistic.a.d().i(new com.baidu.swan.apps.al.a().cV(5L).cW(37L)).a(aVar).sw(h.jr(com.baidu.swan.apps.runtime.d.aIn().afr())).sx(com.baidu.swan.apps.runtime.e.aIt());
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg)) {
                jSONObject.put("exceptionMsg", v8ExceptionInfo.exceptionMsg);
            }
            if (!TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace)) {
                jSONObject.put("exceptionTrace", v8ExceptionInfo.exceptionTrace);
            }
            if (!TextUtils.isEmpty(v8ExceptionInfo.exceptionType)) {
                jSONObject.put("exceptionType", v8ExceptionInfo.exceptionType);
            }
            sx.ck(jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        h.b(sx);
    }
}
