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
/* loaded from: classes9.dex */
public class s {
    private String cmp;
    private String dYA;
    private String dYp;
    private String dYq;
    private String dYr;
    private String dYs;
    private String dYt;
    private String dYu;
    private String dYv;
    private String dYx;
    private String dYy;
    private String dYz;
    private String doL;
    private String mAppVersion;
    private String mContent;
    private String mCuid;
    private String mUuid;
    a dYn = new a();
    b dYo = new b();
    private String dlR = com.baidu.swan.b.a.getNetworkClass();
    private String dYw = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(String str) {
        Context appContext = AppRuntime.getAppContext();
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            this.mAppVersion = packageInfo.versionName;
            this.dYq = packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException e) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService("phone");
        if (telephonyManager != null && (Build.VERSION.SDK_INT < 23 || appContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            this.dYr = telephonyManager.getSimOperator();
        }
        this.mCuid = e.aYZ().getDeviceId(appContext);
        this.mUuid = e.aYZ().cq(appContext);
        this.doL = e.aYZ().getHostName();
        this.dYv = e.aYZ().ats();
        this.dYy = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a {
        String aGJ;
        int dYB;
        String deviceType;
        String os = "Android";
        String osVersion = Build.VERSION.RELEASE;
        String brand = Build.MANUFACTURER;
        int aOK = Build.VERSION.SDK_INT;
        String model = Build.MODEL;

        public a() {
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            this.aGJ = windowManager.getDefaultDisplay().getWidth() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + windowManager.getDefaultDisplay().getHeight();
            this.dYB = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public final class b {
        String dYD;

        private b() {
            this.dYD = e.aYZ().getUserId(AppRuntime.getAppContext());
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("os", this.dYn.os);
            jSONObject2.putOpt("osversion", this.dYn.osVersion);
            jSONObject2.putOpt("model", this.dYn.model);
            jSONObject2.putOpt(CashierData.DEVICE_TYPE, this.dYn.deviceType);
            jSONObject2.putOpt(CashierData.SDK, this.dYn.aOK + "");
            jSONObject2.putOpt(Constants.PHONE_BRAND, this.dYn.brand);
            jSONObject2.putOpt("screen", this.dYn.aGJ);
            jSONObject2.putOpt("density", this.dYn.dYB + "");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("passId", this.dYo.dYD);
            jSONObject.putOpt("userInfo", jSONObject3);
            jSONObject.putOpt("system", jSONObject2);
            jSONObject.putOpt("appVersion", this.mAppVersion);
            jSONObject.putOpt("appBranch", this.dYp);
            jSONObject.putOpt("appPackageName", this.dYq);
            jSONObject.putOpt("cuid", this.mCuid);
            jSONObject.putOpt("uuid", this.mUuid);
            jSONObject.putOpt("hostName", this.doL);
            jSONObject.putOpt("net", this.dlR);
            jSONObject.putOpt("operator", this.dYr);
            jSONObject.putOpt("smartAppId", this.dYs);
            jSONObject.putOpt("smartAppVersion", this.dYt);
            jSONObject.putOpt("swanCoreVersion", this.dYu);
            jSONObject.putOpt("swanNativeVersion", this.dYv);
            jSONObject.putOpt("swanType", this.dYw);
            jSONObject.putOpt("swanId", this.dYx);
            jSONObject.putOpt("bizId", this.dYy);
            jSONObject.putOpt("eventType", this.dYz);
            jSONObject.putOpt("eventName", this.cmp);
            jSONObject.putOpt("content", this.mContent);
            jSONObject.putOpt("propagation", this.dYA);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void cY(JSONObject jSONObject) {
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
    public static String yu(String str) {
        JSONObject jSONObject;
        if (e.aYZ() != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(str);
                }
                str = cZ(jSONObject);
                return str;
            } catch (JSONException e) {
                return str;
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String cZ(JSONObject jSONObject) {
        l aYZ = e.aYZ();
        if (jSONObject == null || aYZ == null) {
            return "";
        }
        try {
            String str = "";
            if (aYZ.abk() == 0) {
                str = "swan";
            } else if (aYZ.abk() == 1) {
                str = "swangame";
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("smartAppId", aYZ.getAppId());
            jSONObject2.putOpt("smartAppVersion", aYZ.getAppVersion());
            jSONObject2.putOpt("swanCoreVersion", aYZ.att());
            jSONObject2.putOpt("swanNativeVersion", aYZ.ats());
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
