package com.baidu.swan.ubc;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.WindowManager;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.coremedia.iso.boxes.UserBox;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class p {
    private String appVersion;
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
    private String bpV;
    private String content;
    private String operator;
    private String uuid;
    a bpI = new a();
    private int bpJ = 1;
    private int bpK = 1;
    private String net = com.baidu.swan.b.a.Fc();

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str) {
        Context appContext = AppRuntime.getAppContext();
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            this.appVersion = packageInfo.versionName;
            this.bpM = packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException e) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
        if (telephonyManager != null && (Build.VERSION.SDK_INT < 23 || appContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            this.operator = telephonyManager.getSimOperator();
        }
        this.uuid = q.Ts().getDeviceId(appContext);
        this.bpS = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        String bpX;
        int density;
        String deviceType;
        String os = "Android";
        String osVersion = Build.VERSION.RELEASE;
        String brand = Build.MANUFACTURER;
        int bpW = Build.VERSION.SDK_INT;
        String model = Build.MODEL;

        public a() {
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            this.bpX = windowManager.getDefaultDisplay().getWidth() + "_" + windowManager.getDefaultDisplay().getHeight();
            this.density = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("os", this.bpI.os);
            jSONObject2.putOpt("osversion", this.bpI.osVersion);
            jSONObject2.putOpt("model", this.bpI.model);
            jSONObject2.putOpt("deviceType", this.bpI.deviceType);
            jSONObject2.putOpt("sdk", this.bpI.bpW + "");
            jSONObject2.putOpt("brand", this.bpI.brand);
            jSONObject2.putOpt("screen", this.bpI.bpX);
            jSONObject2.putOpt("density", this.bpI.density + "");
            jSONObject.putOpt("system", jSONObject2);
            jSONObject.putOpt("officialNo", Integer.valueOf(this.bpJ));
            jSONObject.putOpt("containerNo", Integer.valueOf(this.bpK));
            jSONObject.putOpt("appVersion", this.appVersion);
            jSONObject.putOpt("appBranch", this.bpL);
            jSONObject.putOpt("appPackageName", this.bpM);
            jSONObject.putOpt(UserBox.TYPE, this.uuid);
            jSONObject.putOpt("net", this.net);
            jSONObject.putOpt("operator", this.operator);
            jSONObject.putOpt("smartAppId", this.bpN);
            jSONObject.putOpt("smartAppVersion", this.bpO);
            jSONObject.putOpt("swanCoreVersion", this.bpP);
            jSONObject.putOpt("swanType", this.bpQ);
            jSONObject.putOpt("swanId", this.bpR);
            jSONObject.putOpt("bizId", this.bpS);
            jSONObject.putOpt("eventType", this.bpT);
            jSONObject.putOpt("eventName", this.bpU);
            jSONObject.putOpt("content", this.content);
            jSONObject.putOpt("propagation", this.bpV);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void aG(JSONObject jSONObject) {
        JSONObject jSONObject2 = new p(jSONObject.optString("bizId")).toJSONObject();
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!jSONObject.has(next)) {
                try {
                    jSONObject.putOpt(next, jSONObject2.opt(next));
                } catch (JSONException e) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String jR(String str) {
        JSONObject jSONObject;
        if (q.Ts() != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(str);
                }
                str = aH(jSONObject);
                return str;
            } catch (JSONException e) {
                return str;
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String aH(JSONObject jSONObject) {
        j Ts = q.Ts();
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
            return jSONObject.toString();
        }
    }

    public static void u(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() >= 1) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    JSONObject jSONObject2 = jSONObject.getJSONObject("content");
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("appInfo");
                    Iterator<String> keys = jSONObject3.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject.putOpt(next, jSONObject3.optString(next));
                    }
                    jSONObject2.remove("appInfo");
                } catch (JSONException e) {
                }
            }
        }
    }
}
