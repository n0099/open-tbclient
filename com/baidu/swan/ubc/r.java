package com.baidu.swan.ubc;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.WindowManager;
import com.baidu.poly.bean.PayChannel;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
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
    private String bwf;
    private String bwg;
    private String bwh;
    private String bwi;
    private String bwj;
    private String bwk;
    private String bwl;
    private String bwm;
    private String bwn;
    private String bwo;
    private String bwp;
    private String content;
    private String operator;
    private String uuid;
    a bwb = new a();
    private int bwc = 1;
    private int bwd = 2;
    private String bwe = com.baidu.swan.c.c.XF();
    private String net = com.baidu.swan.b.a.Hf();

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(String str) {
        Context appContext = AppRuntime.getAppContext();
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            this.appVersion = packageInfo.versionName;
            this.bwg = packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException e) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
        if (telephonyManager != null && (Build.VERSION.SDK_INT < 23 || appContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            this.operator = telephonyManager.getSimOperator();
        }
        this.uuid = s.Xr().getDeviceId(appContext);
        this.bwm = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        String bwr;
        int density;
        String deviceType;
        String os = "Android";
        String osVersion = Build.VERSION.RELEASE;
        String brand = Build.MANUFACTURER;
        int bwq = Build.VERSION.SDK_INT;
        String model = Build.MODEL;

        public a() {
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            this.bwr = windowManager.getDefaultDisplay().getWidth() + "_" + windowManager.getDefaultDisplay().getHeight();
            this.density = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("os", this.bwb.os);
            jSONObject2.putOpt("osversion", this.bwb.osVersion);
            jSONObject2.putOpt("model", this.bwb.model);
            jSONObject2.putOpt("deviceType", this.bwb.deviceType);
            jSONObject2.putOpt(PayChannel.ACTION_TYPE_SDK, this.bwb.bwq + "");
            jSONObject2.putOpt(Constants.PHONE_BRAND, this.bwb.brand);
            jSONObject2.putOpt("screen", this.bwb.bwr);
            jSONObject2.putOpt("density", this.bwb.density + "");
            jSONObject.putOpt("system", jSONObject2);
            jSONObject.putOpt("officialNo", Integer.valueOf(this.bwc));
            jSONObject.putOpt("containerNo", Integer.valueOf(this.bwd));
            jSONObject.putOpt("appVersion", this.appVersion);
            jSONObject.putOpt("appBranch", this.bwf);
            jSONObject.putOpt("appPackageName", this.bwg);
            jSONObject.putOpt(UserBox.TYPE, this.uuid);
            jSONObject.putOpt("net", this.net);
            jSONObject.putOpt("operator", this.operator);
            jSONObject.putOpt("smartAppId", this.bwh);
            jSONObject.putOpt("smartAppVersion", this.bwi);
            jSONObject.putOpt("swanCoreVersion", this.bwj);
            jSONObject.putOpt("swanType", this.bwk);
            jSONObject.putOpt("swanId", this.bwl);
            jSONObject.putOpt("bizId", this.bwm);
            jSONObject.putOpt("eventType", this.bwn);
            jSONObject.putOpt("eventName", this.bwo);
            jSONObject.putOpt("content", this.content);
            jSONObject.putOpt("propagation", this.bwp);
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
    public static String kQ(String str) {
        JSONObject jSONObject;
        if (s.Xr() != null) {
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
        k Xr = s.Xr();
        if (jSONObject == null || Xr == null) {
            return "";
        }
        try {
            String str = Xr.vc() == 0 ? "swan" : "swangame";
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("smartAppId", Xr.getAppId());
            jSONObject2.putOpt("smartAppVersion", Xr.getAppVersion());
            jSONObject2.putOpt("swanCoreVersion", Xr.Eo());
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
