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
    private String awa;
    private String bQa;
    private String bQb;
    private String bQc;
    private String bQd;
    private String bQe;
    private String bQf;
    private String bQg;
    private String bQh;
    private String bQi;
    private String bQj;
    private String bQk;
    private String content;
    private String operator;
    private String uuid;
    a bPW = new a();
    private int bPX = 1;
    private int bPY = 2;
    private String bPZ = com.baidu.swan.c.c.adu();
    private String net = com.baidu.swan.b.a.MO();

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(String str) {
        Context appContext = AppRuntime.getAppContext();
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            this.awa = packageInfo.versionName;
            this.bQb = packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException e) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService("phone");
        if (telephonyManager != null && (Build.VERSION.SDK_INT < 23 || appContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            this.operator = telephonyManager.getSimOperator();
        }
        this.uuid = s.adh().getDeviceId(appContext);
        this.bQh = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        String bQl;
        int bQm;
        String deviceType;
        String os = "Android";
        String osVersion = Build.VERSION.RELEASE;
        String brand = Build.MANUFACTURER;
        int Uw = Build.VERSION.SDK_INT;
        String model = Build.MODEL;

        public a() {
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            this.bQl = windowManager.getDefaultDisplay().getWidth() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + windowManager.getDefaultDisplay().getHeight();
            this.bQm = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("os", this.bPW.os);
            jSONObject2.putOpt("osversion", this.bPW.osVersion);
            jSONObject2.putOpt("model", this.bPW.model);
            jSONObject2.putOpt("deviceType", this.bPW.deviceType);
            jSONObject2.putOpt("sdk", this.bPW.Uw + "");
            jSONObject2.putOpt(Constants.PHONE_BRAND, this.bPW.brand);
            jSONObject2.putOpt("screen", this.bPW.bQl);
            jSONObject2.putOpt("density", this.bPW.bQm + "");
            jSONObject.putOpt("system", jSONObject2);
            jSONObject.putOpt("officialNo", Integer.valueOf(this.bPX));
            jSONObject.putOpt("containerNo", Integer.valueOf(this.bPY));
            jSONObject.putOpt("appVersion", this.awa);
            jSONObject.putOpt("appBranch", this.bQa);
            jSONObject.putOpt("appPackageName", this.bQb);
            jSONObject.putOpt("uuid", this.uuid);
            jSONObject.putOpt("net", this.net);
            jSONObject.putOpt("operator", this.operator);
            jSONObject.putOpt("smartAppId", this.bQc);
            jSONObject.putOpt("smartAppVersion", this.bQd);
            jSONObject.putOpt("swanCoreVersion", this.bQe);
            jSONObject.putOpt("swanType", this.bQf);
            jSONObject.putOpt("swanId", this.bQg);
            jSONObject.putOpt("bizId", this.bQh);
            jSONObject.putOpt("eventType", this.bQi);
            jSONObject.putOpt("eventName", this.bQj);
            jSONObject.putOpt("content", this.content);
            jSONObject.putOpt("propagation", this.bQk);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void bq(JSONObject jSONObject) {
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
        if (s.adh() != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(str);
                }
                str = br(jSONObject);
                return str;
            } catch (JSONException e) {
                return str;
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String br(JSONObject jSONObject) {
        k adh = s.adh();
        if (jSONObject == null || adh == null) {
            return "";
        }
        try {
            String str = adh.AB() == 0 ? "swan" : "swangame";
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("smartAppId", adh.getAppId());
            jSONObject2.putOpt("smartAppVersion", adh.getAppVersion());
            jSONObject2.putOpt("swanCoreVersion", adh.JV());
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
