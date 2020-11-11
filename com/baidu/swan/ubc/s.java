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
    private String cAM;
    private String dDd;
    private String emD;
    private String emE;
    private String emF;
    private String emG;
    private String emH;
    private String emI;
    private String emJ;
    private String emL;
    private String emM;
    private String emN;
    private String emO;
    private String mAppVersion;
    private String mContent;
    private String mCuid;
    private String mUuid;
    a emB = new a();
    b emC = new b();
    private String dAl = com.baidu.swan.b.a.getNetworkClass();
    private String emK = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(String str) {
        Context appContext = AppRuntime.getAppContext();
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            this.mAppVersion = packageInfo.versionName;
            this.emE = packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException e) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService("phone");
        if (telephonyManager != null && (Build.VERSION.SDK_INT < 23 || appContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            this.emF = telephonyManager.getSimOperator();
        }
        this.mCuid = e.bds().getDeviceId(appContext);
        this.mUuid = e.bds().cq(appContext);
        this.dDd = e.bds().getHostName();
        this.emJ = e.bds().axM();
        this.emM = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a {
        String aHH;
        String deviceType;
        int emP;
        String os = "Android";
        String osVersion = Build.VERSION.RELEASE;
        String brand = Build.MANUFACTURER;
        int aQm = Build.VERSION.SDK_INT;
        String model = Build.MODEL;

        public a() {
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            this.aHH = windowManager.getDefaultDisplay().getWidth() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + windowManager.getDefaultDisplay().getHeight();
            this.emP = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public final class b {
        String emR;

        private b() {
            this.emR = e.bds().getUserId(AppRuntime.getAppContext());
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("os", this.emB.os);
            jSONObject2.putOpt("osversion", this.emB.osVersion);
            jSONObject2.putOpt("model", this.emB.model);
            jSONObject2.putOpt(CashierData.DEVICE_TYPE, this.emB.deviceType);
            jSONObject2.putOpt(CashierData.SDK, this.emB.aQm + "");
            jSONObject2.putOpt(Constants.PHONE_BRAND, this.emB.brand);
            jSONObject2.putOpt("screen", this.emB.aHH);
            jSONObject2.putOpt("density", this.emB.emP + "");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("passId", this.emC.emR);
            jSONObject.putOpt("userInfo", jSONObject3);
            jSONObject.putOpt("system", jSONObject2);
            jSONObject.putOpt("appVersion", this.mAppVersion);
            jSONObject.putOpt("appBranch", this.emD);
            jSONObject.putOpt("appPackageName", this.emE);
            jSONObject.putOpt("cuid", this.mCuid);
            jSONObject.putOpt("uuid", this.mUuid);
            jSONObject.putOpt("hostName", this.dDd);
            jSONObject.putOpt("net", this.dAl);
            jSONObject.putOpt("operator", this.emF);
            jSONObject.putOpt("smartAppId", this.emG);
            jSONObject.putOpt("smartAppVersion", this.emH);
            jSONObject.putOpt("swanCoreVersion", this.emI);
            jSONObject.putOpt("swanNativeVersion", this.emJ);
            jSONObject.putOpt("swanType", this.emK);
            jSONObject.putOpt("swanId", this.emL);
            jSONObject.putOpt("bizId", this.emM);
            jSONObject.putOpt("eventType", this.emN);
            jSONObject.putOpt("eventName", this.cAM);
            jSONObject.putOpt("content", this.mContent);
            jSONObject.putOpt("propagation", this.emO);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void dh(JSONObject jSONObject) {
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
    public static String zb(String str) {
        JSONObject jSONObject;
        if (e.bds() != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(str);
                }
                str = di(jSONObject);
                return str;
            } catch (JSONException e) {
                return str;
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String di(JSONObject jSONObject) {
        l bds = e.bds();
        if (jSONObject == null || bds == null) {
            return "";
        }
        try {
            String str = "";
            if (bds.afE() == 0) {
                str = "swan";
            } else if (bds.afE() == 1) {
                str = "swangame";
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("smartAppId", bds.getAppId());
            jSONObject2.putOpt("smartAppVersion", bds.getAppVersion());
            jSONObject2.putOpt("swanCoreVersion", bds.axN());
            jSONObject2.putOpt("swanNativeVersion", bds.axM());
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
