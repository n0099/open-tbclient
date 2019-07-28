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
    private String bwV;
    private String bwW;
    private String bwX;
    private String bwY;
    private String bwZ;
    private String bxa;
    private String bxb;
    private String bxc;
    private String bxd;
    private String bxe;
    private String bxf;
    private String content;
    private String operator;
    private String uuid;
    a bwR = new a();
    private int bwS = 1;
    private int bwT = 2;
    private String bwU = com.baidu.swan.c.c.YB();
    private String net = com.baidu.swan.b.a.HQ();

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(String str) {
        Context appContext = AppRuntime.getAppContext();
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            this.appVersion = packageInfo.versionName;
            this.bwW = packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException e) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService("phone");
        if (telephonyManager != null && (Build.VERSION.SDK_INT < 23 || appContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            this.operator = telephonyManager.getSimOperator();
        }
        this.uuid = s.Yn().getDeviceId(appContext);
        this.bxc = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        String bxh;
        int bxi;
        String deviceType;
        String os = "Android";
        String osVersion = Build.VERSION.RELEASE;
        String brand = Build.MANUFACTURER;
        int bxg = Build.VERSION.SDK_INT;
        String model = Build.MODEL;

        public a() {
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            this.bxh = windowManager.getDefaultDisplay().getWidth() + "_" + windowManager.getDefaultDisplay().getHeight();
            this.bxi = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt(IXAdRequestInfo.OS, this.bwR.os);
            jSONObject2.putOpt("osversion", this.bwR.osVersion);
            jSONObject2.putOpt("model", this.bwR.model);
            jSONObject2.putOpt("deviceType", this.bwR.deviceType);
            jSONObject2.putOpt(PayChannel.ACTION_TYPE_SDK, this.bwR.bxg + "");
            jSONObject2.putOpt(Constants.PHONE_BRAND, this.bwR.brand);
            jSONObject2.putOpt("screen", this.bwR.bxh);
            jSONObject2.putOpt("density", this.bwR.bxi + "");
            jSONObject.putOpt("system", jSONObject2);
            jSONObject.putOpt("officialNo", Integer.valueOf(this.bwS));
            jSONObject.putOpt("containerNo", Integer.valueOf(this.bwT));
            jSONObject.putOpt("appVersion", this.appVersion);
            jSONObject.putOpt("appBranch", this.bwV);
            jSONObject.putOpt("appPackageName", this.bwW);
            jSONObject.putOpt(UserBox.TYPE, this.uuid);
            jSONObject.putOpt("net", this.net);
            jSONObject.putOpt("operator", this.operator);
            jSONObject.putOpt("smartAppId", this.bwX);
            jSONObject.putOpt("smartAppVersion", this.bwY);
            jSONObject.putOpt("swanCoreVersion", this.bwZ);
            jSONObject.putOpt("swanType", this.bxa);
            jSONObject.putOpt("swanId", this.bxb);
            jSONObject.putOpt("bizId", this.bxc);
            jSONObject.putOpt("eventType", this.bxd);
            jSONObject.putOpt("eventName", this.bxe);
            jSONObject.putOpt("content", this.content);
            jSONObject.putOpt("propagation", this.bxf);
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
    public static String kY(String str) {
        JSONObject jSONObject;
        if (s.Yn() != null) {
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
        k Yn = s.Yn();
        if (jSONObject == null || Yn == null) {
            return "";
        }
        try {
            String str = Yn.vD() == 0 ? "swan" : "swangame";
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("smartAppId", Yn.getAppId());
            jSONObject2.putOpt("smartAppVersion", Yn.getAppVersion());
            jSONObject2.putOpt("swanCoreVersion", Yn.EX());
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
