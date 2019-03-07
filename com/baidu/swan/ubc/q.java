package com.baidu.swan.ubc;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.WindowManager;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class q {
    private static final boolean DEBUG = g.DEBUG;
    private String appVersion;
    private String bpK;
    private String bpL;
    private String bpM;
    private String bpN;
    private String bpO;
    private String bpP;
    private String bpQ;
    private String bpR;
    private String bpS;
    private String bpT;
    private String bpU;
    private String content;
    private String operator;
    private String uuid;
    a bpH = new a();
    private int bpI = 1;
    private int bpJ = 1;
    private String net = com.baidu.swan.b.a.Fc();

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(String str) {
        Context appContext = AppRuntime.getAppContext();
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            this.appVersion = packageInfo.versionName;
            this.bpL = packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException e) {
            if (DEBUG) {
                Log.e("StatisticData", "obtain statistic data fail", e);
            }
        }
        TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
        if (telephonyManager != null && (Build.VERSION.SDK_INT < 23 || appContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            this.operator = telephonyManager.getSimOperator();
        }
        this.uuid = r.Ts().getDeviceId(appContext);
        this.bpR = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        String bpW;
        int density;
        String deviceType;
        String os = "Android";
        String osVersion = Build.VERSION.RELEASE;
        String brand = Build.MANUFACTURER;
        int bpV = Build.VERSION.SDK_INT;
        String model = Build.MODEL;

        public a() {
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            this.bpW = windowManager.getDefaultDisplay().getWidth() + "_" + windowManager.getDefaultDisplay().getHeight();
            this.density = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("os", this.bpH.os);
            jSONObject2.putOpt("osversion", this.bpH.osVersion);
            jSONObject2.putOpt("model", this.bpH.model);
            jSONObject2.putOpt("deviceType", this.bpH.deviceType);
            jSONObject2.putOpt("sdk", this.bpH.bpV + "");
            jSONObject2.putOpt("brand", this.bpH.brand);
            jSONObject2.putOpt("screen", this.bpH.bpW);
            jSONObject2.putOpt("density", this.bpH.density + "");
            jSONObject.putOpt("system", jSONObject2);
            jSONObject.putOpt("officialNo", Integer.valueOf(this.bpI));
            jSONObject.putOpt("containerNo", Integer.valueOf(this.bpJ));
            jSONObject.putOpt("appVersion", this.appVersion);
            jSONObject.putOpt("appBranch", this.bpK);
            jSONObject.putOpt("appPackageName", this.bpL);
            jSONObject.putOpt("uuid", this.uuid);
            jSONObject.putOpt("net", this.net);
            jSONObject.putOpt("operator", this.operator);
            jSONObject.putOpt("smartAppId", this.bpM);
            jSONObject.putOpt("smartAppVersion", this.bpN);
            jSONObject.putOpt("swanCoreVersion", this.bpO);
            jSONObject.putOpt("swanType", this.bpP);
            jSONObject.putOpt("swanId", this.bpQ);
            jSONObject.putOpt("bizId", this.bpR);
            jSONObject.putOpt("eventType", this.bpS);
            jSONObject.putOpt("eventName", this.bpT);
            jSONObject.putOpt("content", this.content);
            jSONObject.putOpt("propagation", this.bpU);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void aG(JSONObject jSONObject) {
        JSONObject jSONObject2 = new q(jSONObject.optString("bizId")).toJSONObject();
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!jSONObject.has(next)) {
                try {
                    jSONObject.putOpt(next, jSONObject2.opt(next));
                } catch (JSONException e) {
                    if (DEBUG) {
                        Log.d("StatisticData", e.getMessage());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String jR(String str) {
        JSONObject jSONObject;
        if (r.Ts() != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(str);
                }
                str = aH(jSONObject);
                return str;
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("StatisticData", "insert app info fail");
                    return str;
                }
                return str;
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String aH(JSONObject jSONObject) {
        k Ts = r.Ts();
        if (jSONObject == null || Ts == null) {
            return "";
        }
        try {
            String str = Ts.ut() == 0 ? "swan" : "swangame";
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("smartAppId", Ts.getAppId());
            jSONObject2.putOpt("smartAppVersion", Ts.getAppVersion());
            jSONObject2.putOpt("swanCoreVersion", Ts.Dl());
            jSONObject2.putOpt("swanType", str);
            jSONObject.putOpt("appInfo", jSONObject2);
            return jSONObject.toString();
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("StatisticData", "insert app info fail");
            }
            return jSONObject.toString();
        }
    }

    public static void u(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() >= 1) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < jSONArray.length()) {
                    try {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        JSONObject jSONObject2 = jSONObject.getJSONObject("content");
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("appInfo");
                        Iterator<String> keys = jSONObject3.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            jSONObject.putOpt(next, jSONObject3.optString(next));
                        }
                        jSONObject2.remove("appInfo");
                    } catch (JSONException e) {
                        if (DEBUG) {
                            Log.e("StatisticData", "OpenStat content not has app info");
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
