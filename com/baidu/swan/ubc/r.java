package com.baidu.swan.ubc;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.WindowManager;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class r {
    private String avI;
    private String bPj;
    private String bPk;
    private String bPl;
    private String bPm;
    private String bPn;
    private String bPo;
    private String bPp;
    private String bPq;
    private String bPr;
    private String bPs;
    private String bPt;
    private String content;
    private String operator;
    private String uuid;
    a bPf = new a();
    private int bPg = 1;
    private int bPh = 2;
    private String bPi = com.baidu.swan.c.c.ads();
    private String net = com.baidu.swan.b.a.MP();

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(String str) {
        Context appContext = AppRuntime.getAppContext();
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            this.avI = packageInfo.versionName;
            this.bPk = packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException e) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService("phone");
        if (telephonyManager != null && (Build.VERSION.SDK_INT < 23 || appContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            this.operator = telephonyManager.getSimOperator();
        }
        this.uuid = s.adf().getDeviceId(appContext);
        this.bPq = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        String bPu;
        int bPv;
        String deviceType;
        String os = "Android";
        String osVersion = Build.VERSION.RELEASE;
        String brand = Build.MANUFACTURER;
        int Ud = Build.VERSION.SDK_INT;
        String model = Build.MODEL;

        public a() {
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            this.bPu = windowManager.getDefaultDisplay().getWidth() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + windowManager.getDefaultDisplay().getHeight();
            this.bPv = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("os", this.bPf.os);
            jSONObject2.putOpt("osversion", this.bPf.osVersion);
            jSONObject2.putOpt("model", this.bPf.model);
            jSONObject2.putOpt("deviceType", this.bPf.deviceType);
            jSONObject2.putOpt("sdk", this.bPf.Ud + "");
            jSONObject2.putOpt(Constants.PHONE_BRAND, this.bPf.brand);
            jSONObject2.putOpt("screen", this.bPf.bPu);
            jSONObject2.putOpt("density", this.bPf.bPv + "");
            jSONObject.putOpt("system", jSONObject2);
            jSONObject.putOpt("officialNo", Integer.valueOf(this.bPg));
            jSONObject.putOpt("containerNo", Integer.valueOf(this.bPh));
            jSONObject.putOpt("appVersion", this.avI);
            jSONObject.putOpt("appBranch", this.bPj);
            jSONObject.putOpt("appPackageName", this.bPk);
            jSONObject.putOpt("uuid", this.uuid);
            jSONObject.putOpt("net", this.net);
            jSONObject.putOpt("operator", this.operator);
            jSONObject.putOpt("smartAppId", this.bPl);
            jSONObject.putOpt("smartAppVersion", this.bPm);
            jSONObject.putOpt("swanCoreVersion", this.bPn);
            jSONObject.putOpt("swanType", this.bPo);
            jSONObject.putOpt("swanId", this.bPp);
            jSONObject.putOpt("bizId", this.bPq);
            jSONObject.putOpt("eventType", this.bPr);
            jSONObject.putOpt("eventName", this.bPs);
            jSONObject.putOpt("content", this.content);
            jSONObject.putOpt("propagation", this.bPt);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void br(JSONObject jSONObject) {
        JSONObject jSONObject2 = new r(jSONObject.optString("bizId")).toJSONObject();
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
    public static String lC(String str) {
        JSONObject jSONObject;
        if (s.adf() != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(str);
                }
                str = bs(jSONObject);
                return str;
            } catch (JSONException e) {
                return str;
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String bs(JSONObject jSONObject) {
        k adf = s.adf();
        if (jSONObject == null || adf == null) {
            return "";
        }
        try {
            String str = adf.AC() == 0 ? "swan" : "swangame";
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("smartAppId", adf.getAppId());
            jSONObject2.putOpt("smartAppVersion", adf.getAppVersion());
            jSONObject2.putOpt("swanCoreVersion", adf.JW());
            jSONObject2.putOpt("swanType", str);
            jSONObject.putOpt("appInfo", jSONObject2);
            return jSONObject.toString();
        } catch (JSONException e) {
            return jSONObject.toString();
        }
    }

    public static void B(JSONArray jSONArray) {
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
