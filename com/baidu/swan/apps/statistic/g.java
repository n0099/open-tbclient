package com.baidu.swan.apps.statistic;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.adaptation.a.s;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.x.b.b;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class g {
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
        if (!com.baidu.swan.apps.w.a.TZ().Hr()) {
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
            SwanCoreVersion gA = com.baidu.swan.apps.swancore.b.gA(com.baidu.swan.apps.runtime.d.acC().Gu());
            if (gA != null && !TextUtils.isEmpty(gA.swanCorePath)) {
                if (!str.startsWith(gA.swanCorePath)) {
                    if (DEBUG) {
                        Log.d("V8StabilityHelper", "file path is not swan core path");
                        return;
                    }
                    return;
                }
                final File file = new File(str);
                if (file.exists()) {
                    final HashMap hashMap = new HashMap();
                    com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
                    if (!TextUtils.isEmpty(com.baidu.swan.apps.runtime.e.acH())) {
                        hashMap.put("appId", com.baidu.swan.apps.runtime.e.acH());
                    }
                    if (acF != null && !TextUtils.isEmpty(acF.getVersion())) {
                        hashMap.put("appVersion", acF.getVersion());
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
                    m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.statistic.g.1
                        @Override // java.lang.Runnable
                        public void run() {
                            s Uf = com.baidu.swan.apps.w.a.Uf();
                            if (Uf != null) {
                                Uf.a(hashMap, file, (s.a) null, "error_js");
                                if (g.DEBUG) {
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
        if (!com.baidu.swan.apps.w.a.TZ().Hs()) {
            if (DEBUG) {
                Log.d("V8StabilityHelper", "stability switch off");
                return;
            }
            return;
        }
        b.a aVar = null;
        com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
        if (acF != null) {
            aVar = acF.GE();
        }
        com.baidu.swan.apps.statistic.a.d lO = new com.baidu.swan.apps.statistic.a.d().e(new com.baidu.swan.apps.ap.a().aI(5L).aJ(37L)).a(aVar).lN(f.gs(com.baidu.swan.apps.runtime.d.acC().Gu())).lO(com.baidu.swan.apps.runtime.e.acH());
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
            lO.aZ(jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        f.b(lO);
    }
}
