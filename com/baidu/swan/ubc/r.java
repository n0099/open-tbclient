package com.baidu.swan.ubc;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.WindowManager;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.poly.bean.PayChannel;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.coremedia.iso.boxes.UserBox;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class r {
    private String appVersion;
    private String bxA;
    private String bxB;
    private String bxC;
    private String bxD;
    private String bxt;
    private String bxu;
    private String bxv;
    private String bxw;
    private String bxx;
    private String bxy;
    private String bxz;
    private String content;
    private String operator;
    private String uuid;
    a bxp = new a();
    private int bxq = 1;
    private int bxr = 2;
    private String bxs = com.baidu.swan.c.c.YF();
    private String net = com.baidu.swan.b.a.HU();

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(String str) {
        Context appContext = AppRuntime.getAppContext();
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            this.appVersion = packageInfo.versionName;
            this.bxu = packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException e) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService("phone");
        if (telephonyManager != null && (Build.VERSION.SDK_INT < 23 || appContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            this.operator = telephonyManager.getSimOperator();
        }
        this.uuid = s.Yr().getDeviceId(appContext);
        this.bxA = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        String bxF;
        int bxG;
        String deviceType;
        String os = "Android";
        String osVersion = Build.VERSION.RELEASE;
        String brand = Build.MANUFACTURER;
        int bxE = Build.VERSION.SDK_INT;
        String model = Build.MODEL;

        public a() {
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            this.bxF = windowManager.getDefaultDisplay().getWidth() + "_" + windowManager.getDefaultDisplay().getHeight();
            this.bxG = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt(IXAdRequestInfo.OS, this.bxp.os);
            jSONObject2.putOpt("osversion", this.bxp.osVersion);
            jSONObject2.putOpt("model", this.bxp.model);
            jSONObject2.putOpt("deviceType", this.bxp.deviceType);
            jSONObject2.putOpt(PayChannel.ACTION_TYPE_SDK, this.bxp.bxE + "");
            jSONObject2.putOpt(Constants.PHONE_BRAND, this.bxp.brand);
            jSONObject2.putOpt("screen", this.bxp.bxF);
            jSONObject2.putOpt("density", this.bxp.bxG + "");
            jSONObject.putOpt("system", jSONObject2);
            jSONObject.putOpt("officialNo", Integer.valueOf(this.bxq));
            jSONObject.putOpt("containerNo", Integer.valueOf(this.bxr));
            jSONObject.putOpt("appVersion", this.appVersion);
            jSONObject.putOpt("appBranch", this.bxt);
            jSONObject.putOpt("appPackageName", this.bxu);
            jSONObject.putOpt(UserBox.TYPE, this.uuid);
            jSONObject.putOpt("net", this.net);
            jSONObject.putOpt("operator", this.operator);
            jSONObject.putOpt("smartAppId", this.bxv);
            jSONObject.putOpt("smartAppVersion", this.bxw);
            jSONObject.putOpt("swanCoreVersion", this.bxx);
            jSONObject.putOpt("swanType", this.bxy);
            jSONObject.putOpt("swanId", this.bxz);
            jSONObject.putOpt("bizId", this.bxA);
            jSONObject.putOpt("eventType", this.bxB);
            jSONObject.putOpt("eventName", this.bxC);
            jSONObject.putOpt("content", this.content);
            jSONObject.putOpt("propagation", this.bxD);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void aS(JSONObject jSONObject) {
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
    public static String la(String str) {
        JSONObject jSONObject;
        if (s.Yr() != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(str);
                }
                str = aT(jSONObject);
                return str;
            } catch (JSONException e) {
                return str;
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String aT(JSONObject jSONObject) {
        k Yr = s.Yr();
        if (jSONObject == null || Yr == null) {
            return "";
        }
        try {
            String str = Yr.vH() == 0 ? "swan" : "swangame";
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("smartAppId", Yr.getAppId());
            jSONObject2.putOpt("smartAppVersion", Yr.getAppVersion());
            jSONObject2.putOpt("swanCoreVersion", Yr.Fb());
            jSONObject2.putOpt("swanType", str);
            jSONObject.putOpt("appInfo", jSONObject2);
            return jSONObject.toString();
        } catch (JSONException e) {
            return jSONObject.toString();
        }
    }

    public static void t(JSONArray jSONArray) {
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
