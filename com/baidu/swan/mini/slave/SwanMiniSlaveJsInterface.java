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
        if (!this.mMiniRuntime.aGr()) {
            if (DEBUG) {
                Log.e("SwanMiniRuntime", "Slave not loaded -- loadMasters");
            }
        } else if (TextUtils.isEmpty(str)) {
            this.mMiniRuntime.e(2, "No info param", false);
        } else {
            this.mMiniRuntime.loadMasters(str);
        }
    }

    @JavascriptInterface
    public void disposeMasters(String str) {
        if (!this.mMiniRuntime.aGr()) {
            if (DEBUG) {
                Log.e("SwanMiniRuntime", "Slave not loaded -- disposeMasters");
                return;
            }
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() == 0) {
                this.mMiniRuntime.e(5, "Id array empty", false);
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
                this.mMiniRuntime.e(5, "No valid instance id", false);
            } else {
                this.mMiniRuntime.as(arrayList);
            }
        } catch (Exception e) {
            this.mMiniRuntime.e(5, "Id array illegal", false);
        }
    }

    @JavascriptInterface
    public void printLog(String str) {
        this.mMiniRuntime.b(false, "mini-slave", str);
    }

    @JavascriptInterface
    public void sendMessage(String str, String str2) {
        if (!this.mMiniRuntime.aGr()) {
            if (DEBUG) {
                Log.e("SwanMiniRuntime", "Slave not loaded -- sendMessage");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.v("SwanMiniRuntime", "Slave == sendMessage(" + str + ", " + str2 + ")");
        }
        this.mMiniRuntime.cH(str, str2);
    }

    @JavascriptInterface
    public void report(int i, String str) {
        if (!this.mMiniRuntime.aGr()) {
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
        String optString = jSONObject.optString("keypoint");
        if (!TextUtils.isEmpty(optString)) {
            String optString2 = jSONObject.optString("appInstanceId");
            String optString3 = jSONObject.optString("message");
            if (TextUtils.isEmpty(optString2)) {
                this.mMiniRuntime.aGs().cK(optString, optString3);
            } else {
                this.mMiniRuntime.aGs().V(optString2, optString, optString3);
            }
            if (optString.equals("fe_render_mini_end") && !TextUtils.isEmpty(optString2)) {
                String optString4 = jSONObject.optString("appKey");
                String optString5 = jSONObject.optString("bundleId");
                HashMap hashMap = new HashMap();
                if (!TextUtils.isEmpty(optString4)) {
                    hashMap.put("appKey", optString4);
                }
                if (!TextUtils.isEmpty(optString5)) {
                    hashMap.put("bundleId", optString5);
                }
                if (!TextUtils.isEmpty(optString2)) {
                    hashMap.put("appInstanceId", optString2);
                }
                this.mMiniRuntime.aGs().j(optString2, hashMap);
            }
        }
    }

    private void processErrorReport(JSONObject jSONObject) {
        this.mMiniRuntime.aGs().a(jSONObject.optInt("errCode", -1), jSONObject.optString("errMessage"), jSONObject.optString("appKey"), jSONObject.optString("bundleId"), jSONObject.optString("appInstanceId"));
    }
}
