package com.baidu.swan.mini.slave;

import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.swan.apps.b;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
@Keep
/* loaded from: classes11.dex */
public class SwanMiniSlaveJsInterface {
    private static final boolean DEBUG = b.DEBUG;
    public static final String JAVASCRIPT_INTERFACE_NAME = "___NA_SWAN_MINI___";
    private com.baidu.swan.mini.a mMiniRuntime;

    public SwanMiniSlaveJsInterface(@NonNull com.baidu.swan.mini.a aVar) {
        this.mMiniRuntime = aVar;
    }

    @JavascriptInterface
    public void loadMasters(String str) {
        if (!this.mMiniRuntime.ate()) {
            if (DEBUG) {
                Log.e("SwanMiniRuntime", "Slave not loaded -- loadMasters");
            }
        } else if (TextUtils.isEmpty(str)) {
            this.mMiniRuntime.d(2, "No info param", false);
        } else {
            this.mMiniRuntime.loadMasters(str);
        }
    }

    @JavascriptInterface
    public void disposeMasters(String str) {
        if (!this.mMiniRuntime.ate()) {
            if (DEBUG) {
                Log.e("SwanMiniRuntime", "Slave not loaded -- disposeMasters");
                return;
            }
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() == 0) {
                this.mMiniRuntime.d(5, "Id array empty", false);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                String optString = jSONArray.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    arrayList.add(optString);
                }
            }
            if (arrayList.size() == 0) {
                this.mMiniRuntime.d(5, "No valid instance id", false);
            } else {
                this.mMiniRuntime.ak(arrayList);
            }
        } catch (Exception e) {
            this.mMiniRuntime.d(5, "Id array illegal", false);
        }
    }

    @JavascriptInterface
    public void printLog(String str) {
        this.mMiniRuntime.b(false, "mini-slave", str);
    }

    @JavascriptInterface
    public void sendMessage(String str, String str2) {
        if (!this.mMiniRuntime.ate()) {
            if (DEBUG) {
                Log.e("SwanMiniRuntime", "Slave not loaded -- sendMessage");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.v("SwanMiniRuntime", "Slave == sendMessage(" + str + ", " + str2 + ")");
        }
        this.mMiniRuntime.ca(str, str2);
    }

    @JavascriptInterface
    public void report(int i, String str) {
        if (!this.mMiniRuntime.ate()) {
            if (DEBUG) {
                Log.e("SwanMiniRuntime", "Slave not loaded -- report");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("SwanMiniRuntime", "statistic report : (" + i + ", " + str + ")");
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            switch (i) {
                case 1:
                    processPerformanceReport(jSONObject);
                    return;
                case 2:
                    processErrorReport(jSONObject);
                    return;
                default:
                    return;
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void processPerformanceReport(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("keyFrameType", -1);
        if (optInt >= 0) {
            String optString = jSONObject.optString("cardInstanceId");
            String optString2 = jSONObject.optString("message");
            if (TextUtils.isEmpty(optString)) {
                this.mMiniRuntime.atf().M(optInt, optString2);
            } else {
                this.mMiniRuntime.atf().m(optString, optInt, optString2);
            }
            if (optInt == 109 && !TextUtils.isEmpty(optString)) {
                String optString3 = jSONObject.optString("appKey");
                String optString4 = jSONObject.optString("bundleId");
                HashMap hashMap = new HashMap();
                if (!TextUtils.isEmpty(optString3)) {
                    hashMap.put("appKey", optString3);
                }
                if (!TextUtils.isEmpty(optString4)) {
                    hashMap.put("bundleId", optString4);
                }
                this.mMiniRuntime.atf().f(optString, hashMap);
            }
        }
    }

    private void processErrorReport(JSONObject jSONObject) {
        this.mMiniRuntime.atf().d(jSONObject.optInt("errCode", -1), jSONObject.optString("errMessage"), jSONObject.optString("appKey"), jSONObject.optString("bundleId"));
    }
}
