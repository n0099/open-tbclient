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
/* loaded from: classes11.dex */
public class r {
    private String bSS;
    private String cxk;
    private String deA;
    private String deB;
    private String deC;
    private String deD;
    private String deE;
    private String deF;
    private String deH;
    private String deI;
    private String deJ;
    private String deK;
    private String mAppVersion;
    private String mContent;
    private String mCuid;
    private String mUuid;
    a dey = new a();
    b dez = new b();
    private String cuz = com.baidu.swan.c.a.getNetworkClass();
    private String deG = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(String str) {
        Context appContext = AppRuntime.getAppContext();
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            this.mAppVersion = packageInfo.versionName;
            this.deB = packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException e) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService("phone");
        if (telephonyManager != null && (Build.VERSION.SDK_INT < 23 || appContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            this.deC = telephonyManager.getSimOperator();
        }
        this.mCuid = s.aEh().getDeviceId(appContext);
        this.mUuid = s.aEh().bQ(appContext);
        this.cxk = s.aEh().getHostName();
        this.deI = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a {
        String deL;
        int deM;
        String deviceType;
        String os = "Android";
        String osVersion = Build.VERSION.RELEASE;
        String brand = Build.MANUFACTURER;
        int awe = Build.VERSION.SDK_INT;
        String model = Build.MODEL;

        public a() {
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            this.deL = windowManager.getDefaultDisplay().getWidth() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + windowManager.getDefaultDisplay().getHeight();
            this.deM = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public final class b {
        String deO;

        private b() {
            this.deO = s.aEh().getUserId(AppRuntime.getAppContext());
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("os", this.dey.os);
            jSONObject2.putOpt("osversion", this.dey.osVersion);
            jSONObject2.putOpt("model", this.dey.model);
            jSONObject2.putOpt(CashierData.DEVICE_TYPE, this.dey.deviceType);
            jSONObject2.putOpt(CashierData.SDK, this.dey.awe + "");
            jSONObject2.putOpt(Constants.PHONE_BRAND, this.dey.brand);
            jSONObject2.putOpt("screen", this.dey.deL);
            jSONObject2.putOpt("density", this.dey.deM + "");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("passId", this.dez.deO);
            jSONObject.putOpt("userInfo", jSONObject3);
            jSONObject.putOpt("system", jSONObject2);
            jSONObject.putOpt("appVersion", this.mAppVersion);
            jSONObject.putOpt("appBranch", this.deA);
            jSONObject.putOpt("appPackageName", this.deB);
            jSONObject.putOpt("cuid", this.mCuid);
            jSONObject.putOpt("uuid", this.mUuid);
            jSONObject.putOpt("hostName", this.cxk);
            jSONObject.putOpt("net", this.cuz);
            jSONObject.putOpt("operator", this.deC);
            jSONObject.putOpt("smartAppId", this.deD);
            jSONObject.putOpt("smartAppVersion", this.deE);
            jSONObject.putOpt("swanCoreVersion", this.deF);
            jSONObject.putOpt("swanType", this.deG);
            jSONObject.putOpt("swanId", this.deH);
            jSONObject.putOpt("bizId", this.deI);
            jSONObject.putOpt("eventType", this.deJ);
            jSONObject.putOpt("eventName", this.bSS);
            jSONObject.putOpt("content", this.mContent);
            jSONObject.putOpt("propagation", this.deK);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void cp(JSONObject jSONObject) {
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
    public static String sm(String str) {
        JSONObject jSONObject;
        if (s.aEh() != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(str);
                }
                str = cq(jSONObject);
                return str;
            } catch (JSONException e) {
                return str;
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String cq(JSONObject jSONObject) {
        k aEh = s.aEh();
        if (jSONObject == null || aEh == null) {
            return "";
        }
        try {
            String str = "";
            if (aEh.Ol() == 0) {
                str = "swan";
            } else if (aEh.Ol() == 1) {
                str = "swangame";
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("smartAppId", aEh.getAppId());
            jSONObject2.putOpt("smartAppVersion", aEh.getAppVersion());
            jSONObject2.putOpt("swanCoreVersion", aEh.acN());
            jSONObject2.putOpt("swanType", str);
            jSONObject.putOpt("appInfo", jSONObject2);
            return jSONObject.toString();
        } catch (JSONException e) {
            return jSONObject.toString();
        }
    }

    public static void J(JSONArray jSONArray) {
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
