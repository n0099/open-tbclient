package com.baidu.swan.apps.statistic;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.adaptation.a.w;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.u.c.b;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
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
        if (!com.baidu.swan.apps.t.a.apx().Zu()) {
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
            SwanCoreVersion jP = com.baidu.swan.apps.swancore.b.jP(com.baidu.swan.apps.runtime.d.aAn().Yy());
            if (jP != null && !TextUtils.isEmpty(jP.swanCorePath)) {
                if (!str.startsWith(jP.swanCorePath)) {
                    if (DEBUG) {
                        Log.d("V8StabilityHelper", "file path is not swan core path");
                        return;
                    }
                    return;
                }
                final File file = new File(str);
                if (file.exists()) {
                    final HashMap hashMap = new HashMap();
                    com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
                    if (!TextUtils.isEmpty(com.baidu.swan.apps.runtime.e.aAt())) {
                        hashMap.put("appId", com.baidu.swan.apps.runtime.e.aAt());
                    }
                    if (aAr != null && !TextUtils.isEmpty(aAr.getVersion())) {
                        hashMap.put("appVersion", aAr.getVersion());
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
                    p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.statistic.i.1
                        @Override // java.lang.Runnable
                        public void run() {
                            w apD = com.baidu.swan.apps.t.a.apD();
                            if (apD != null) {
                                apD.a(hashMap, file, (w.a) null, "error_js");
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
        if (!com.baidu.swan.apps.t.a.apx().Zv()) {
            if (DEBUG) {
                Log.d("V8StabilityHelper", "stability switch off");
                return;
            }
            return;
        }
        b.a aVar = null;
        com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
        if (aAr != null) {
            aVar = aAr.YI();
        }
        com.baidu.swan.apps.statistic.a.d rP = new com.baidu.swan.apps.statistic.a.d().i(new com.baidu.swan.apps.am.a().bP(5L).bQ(37L)).a(aVar).rO(h.jG(com.baidu.swan.apps.runtime.d.aAn().Yy())).rP(com.baidu.swan.apps.runtime.e.aAt());
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
            rP.bQ(jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        h.b(rP);
    }
}
