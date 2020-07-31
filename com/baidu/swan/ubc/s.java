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
    private String bSl;
    private String cRv;
    private String dAW;
    private String dAX;
    private String dAY;
    private String dAZ;
    private String dBa;
    private String dBb;
    private String dBd;
    private String dBe;
    private String dBf;
    private String dBg;
    private String mAppVersion;
    private String mContent;
    private String mCuid;
    private String mUuid;
    a dAU = new a();
    b dAV = new b();
    private String cOD = com.baidu.swan.c.a.getNetworkClass();
    private String dBc = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(String str) {
        Context appContext = AppRuntime.getAppContext();
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            this.mAppVersion = packageInfo.versionName;
            this.dAX = packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException e) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService("phone");
        if (telephonyManager != null && (Build.VERSION.SDK_INT < 23 || appContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            this.dAY = telephonyManager.getSimOperator();
        }
        this.mCuid = e.aNf().getDeviceId(appContext);
        this.mUuid = e.aNf().cf(appContext);
        this.cRv = e.aNf().getHostName();
        this.dBe = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a {
        String dBh;
        int dBi;
        String deviceType;
        String os = "Android";
        String osVersion = Build.VERSION.RELEASE;
        String brand = Build.MANUFACTURER;
        int aES = Build.VERSION.SDK_INT;
        String model = Build.MODEL;

        public a() {
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            this.dBh = windowManager.getDefaultDisplay().getWidth() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + windowManager.getDefaultDisplay().getHeight();
            this.dBi = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public final class b {
        String dBk;

        private b() {
            this.dBk = e.aNf().getUserId(AppRuntime.getAppContext());
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("os", this.dAU.os);
            jSONObject2.putOpt("osversion", this.dAU.osVersion);
            jSONObject2.putOpt("model", this.dAU.model);
            jSONObject2.putOpt(CashierData.DEVICE_TYPE, this.dAU.deviceType);
            jSONObject2.putOpt(CashierData.SDK, this.dAU.aES + "");
            jSONObject2.putOpt(Constants.PHONE_BRAND, this.dAU.brand);
            jSONObject2.putOpt("screen", this.dAU.dBh);
            jSONObject2.putOpt("density", this.dAU.dBi + "");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("passId", this.dAV.dBk);
            jSONObject.putOpt("userInfo", jSONObject3);
            jSONObject.putOpt("system", jSONObject2);
            jSONObject.putOpt("appVersion", this.mAppVersion);
            jSONObject.putOpt("appBranch", this.dAW);
            jSONObject.putOpt("appPackageName", this.dAX);
            jSONObject.putOpt("cuid", this.mCuid);
            jSONObject.putOpt("uuid", this.mUuid);
            jSONObject.putOpt("hostName", this.cRv);
            jSONObject.putOpt("net", this.cOD);
            jSONObject.putOpt("operator", this.dAY);
            jSONObject.putOpt("smartAppId", this.dAZ);
            jSONObject.putOpt("smartAppVersion", this.dBa);
            jSONObject.putOpt("swanCoreVersion", this.dBb);
            jSONObject.putOpt("swanType", this.dBc);
            jSONObject.putOpt("swanId", this.dBd);
            jSONObject.putOpt("bizId", this.dBe);
            jSONObject.putOpt("eventType", this.dBf);
            jSONObject.putOpt("eventName", this.bSl);
            jSONObject.putOpt("content", this.mContent);
            jSONObject.putOpt("propagation", this.dBg);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void cI(JSONObject jSONObject) {
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
    public static String vd(String str) {
        JSONObject jSONObject;
        if (e.aNf() != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(str);
                }
                str = cJ(jSONObject);
                return str;
            } catch (JSONException e) {
                return str;
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String cJ(JSONObject jSONObject) {
        l aNf = e.aNf();
        if (jSONObject == null || aNf == null) {
            return "";
        }
        try {
            String str = "";
            if (aNf.RU() == 0) {
                str = "swan";
            } else if (aNf.RU() == 1) {
                str = "swangame";
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("smartAppId", aNf.getAppId());
            jSONObject2.putOpt("smartAppVersion", aNf.getAppVersion());
            jSONObject2.putOpt("swanCoreVersion", aNf.air());
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
