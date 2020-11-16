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
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class s {
    private String czc;
    private String dBw;
    private String ekW;
    private String ekX;
    private String ekY;
    private String ekZ;
    private String ela;
    private String elb;
    private String elc;
    private String ele;
    private String elf;
    private String elg;
    private String elh;
    private String mAppVersion;
    private String mContent;
    private String mCuid;
    private String mUuid;
    a ekU = new a();
    b ekV = new b();
    private String dyE = com.baidu.swan.b.a.getNetworkClass();
    private String eld = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(String str) {
        Context appContext = AppRuntime.getAppContext();
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            this.mAppVersion = packageInfo.versionName;
            this.ekX = packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException e) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService("phone");
        if (telephonyManager != null && (Build.VERSION.SDK_INT < 23 || appContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            this.ekY = telephonyManager.getSimOperator();
        }
        this.mCuid = e.bcL().getDeviceId(appContext);
        this.mUuid = e.bcL().cq(appContext);
        this.dBw = e.bcL().getHostName();
        this.elc = e.bcL().axe();
        this.elf = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class a {
        String aFW;
        String deviceType;
        int eli;
        String os = "Android";
        String osVersion = Build.VERSION.RELEASE;
        String brand = Build.MANUFACTURER;
        int aOB = Build.VERSION.SDK_INT;
        String model = Build.MODEL;

        public a() {
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            this.aFW = windowManager.getDefaultDisplay().getWidth() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + windowManager.getDefaultDisplay().getHeight();
            this.eli = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public final class b {
        String elk;

        private b() {
            this.elk = e.bcL().getUserId(AppRuntime.getAppContext());
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("os", this.ekU.os);
            jSONObject2.putOpt("osversion", this.ekU.osVersion);
            jSONObject2.putOpt("model", this.ekU.model);
            jSONObject2.putOpt(CashierData.DEVICE_TYPE, this.ekU.deviceType);
            jSONObject2.putOpt(CashierData.SDK, this.ekU.aOB + "");
            jSONObject2.putOpt(Constants.PHONE_BRAND, this.ekU.brand);
            jSONObject2.putOpt("screen", this.ekU.aFW);
            jSONObject2.putOpt("density", this.ekU.eli + "");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("passId", this.ekV.elk);
            jSONObject.putOpt("userInfo", jSONObject3);
            jSONObject.putOpt("system", jSONObject2);
            jSONObject.putOpt("appVersion", this.mAppVersion);
            jSONObject.putOpt("appBranch", this.ekW);
            jSONObject.putOpt("appPackageName", this.ekX);
            jSONObject.putOpt("cuid", this.mCuid);
            jSONObject.putOpt("uuid", this.mUuid);
            jSONObject.putOpt("hostName", this.dBw);
            jSONObject.putOpt("net", this.dyE);
            jSONObject.putOpt("operator", this.ekY);
            jSONObject.putOpt("smartAppId", this.ekZ);
            jSONObject.putOpt("smartAppVersion", this.ela);
            jSONObject.putOpt("swanCoreVersion", this.elb);
            jSONObject.putOpt("swanNativeVersion", this.elc);
            jSONObject.putOpt("swanType", this.eld);
            jSONObject.putOpt("swanId", this.ele);
            jSONObject.putOpt("bizId", this.elf);
            jSONObject.putOpt("eventType", this.elg);
            jSONObject.putOpt("eventName", this.czc);
            jSONObject.putOpt("content", this.mContent);
            jSONObject.putOpt("propagation", this.elh);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void db(JSONObject jSONObject) {
        JSONObject jSONObject2 = new s(jSONObject.optString("bizId")).toJSONObject();
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
    public static String yW(String str) {
        JSONObject jSONObject;
        if (e.bcL() != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(str);
                }
                str = dc(jSONObject);
                return str;
            } catch (JSONException e) {
                return str;
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String dc(JSONObject jSONObject) {
        l bcL = e.bcL();
        if (jSONObject == null || bcL == null) {
            return "";
        }
        try {
            String str = "";
            if (bcL.aeW() == 0) {
                str = "swan";
            } else if (bcL.aeW() == 1) {
                str = "swangame";
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("smartAppId", bcL.getAppId());
            jSONObject2.putOpt("smartAppVersion", bcL.getAppVersion());
            jSONObject2.putOpt("swanCoreVersion", bcL.axf());
            jSONObject2.putOpt("swanNativeVersion", bcL.axe());
            jSONObject2.putOpt("swanType", str);
            jSONObject.putOpt("appInfo", jSONObject2);
            return jSONObject.toString();
        } catch (JSONException e) {
            return jSONObject.toString();
        }
    }

    public static void L(JSONArray jSONArray) {
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
