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
    private String bpP;
    private String bpQ;
    private String bpR;
    private String bpS;
    private String bpT;
    private String bpU;
    private String bpV;
    private String bpW;
    private String bpX;
    private String bpY;
    private String bpZ;
    private String content;
    private String operator;
    private String uuid;
    a bpM = new a();
    private int bpN = 1;
    private int bpO = 1;
    private String net = com.baidu.swan.b.a.Fa();

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str) {
        Context appContext = AppRuntime.getAppContext();
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            this.appVersion = packageInfo.versionName;
            this.bpQ = packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException e) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
        if (telephonyManager != null && (Build.VERSION.SDK_INT < 23 || appContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            this.operator = telephonyManager.getSimOperator();
        }
        this.uuid = q.Tq().getDeviceId(appContext);
        this.bpW = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        String bqb;
        int density;
        String deviceType;
        String os = "Android";
        String osVersion = Build.VERSION.RELEASE;
        String brand = Build.MANUFACTURER;
        int bqa = Build.VERSION.SDK_INT;
        String model = Build.MODEL;

        public a() {
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            this.bqb = windowManager.getDefaultDisplay().getWidth() + "_" + windowManager.getDefaultDisplay().getHeight();
            this.density = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("os", this.bpM.os);
            jSONObject2.putOpt("osversion", this.bpM.osVersion);
            jSONObject2.putOpt("model", this.bpM.model);
            jSONObject2.putOpt("deviceType", this.bpM.deviceType);
            jSONObject2.putOpt("sdk", this.bpM.bqa + "");
            jSONObject2.putOpt("brand", this.bpM.brand);
            jSONObject2.putOpt("screen", this.bpM.bqb);
            jSONObject2.putOpt("density", this.bpM.density + "");
            jSONObject.putOpt("system", jSONObject2);
            jSONObject.putOpt("officialNo", Integer.valueOf(this.bpN));
            jSONObject.putOpt("containerNo", Integer.valueOf(this.bpO));
            jSONObject.putOpt("appVersion", this.appVersion);
            jSONObject.putOpt("appBranch", this.bpP);
            jSONObject.putOpt("appPackageName", this.bpQ);
            jSONObject.putOpt(UserBox.TYPE, this.uuid);
            jSONObject.putOpt("net", this.net);
            jSONObject.putOpt("operator", this.operator);
            jSONObject.putOpt("smartAppId", this.bpR);
            jSONObject.putOpt("smartAppVersion", this.bpS);
            jSONObject.putOpt("swanCoreVersion", this.bpT);
            jSONObject.putOpt("swanType", this.bpU);
            jSONObject.putOpt("swanId", this.bpV);
            jSONObject.putOpt("bizId", this.bpW);
            jSONObject.putOpt("eventType", this.bpX);
            jSONObject.putOpt("eventName", this.bpY);
            jSONObject.putOpt("content", this.content);
            jSONObject.putOpt("propagation", this.bpZ);
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
    public static String jS(String str) {
        JSONObject jSONObject;
        if (q.Tq() != null) {
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
        j Tq = q.Tq();
        if (jSONObject == null || Tq == null) {
            return "";
        }
        try {
            String str = Tq.us() == 0 ? "swan" : "swangame";
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("smartAppId", Tq.getAppId());
            jSONObject2.putOpt("smartAppVersion", Tq.getAppVersion());
            jSONObject2.putOpt("swanCoreVersion", Tq.Dj());
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
