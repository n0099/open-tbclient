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
    private String bYm;
    private String buG;
    private String cFB;
    private String cFC;
    private String cFD;
    private String cFE;
    private String cFu;
    private String cFv;
    private String cFw;
    private String cFx;
    private String cFy;
    private String cFz;
    private String mAppVersion;
    private String mContent;
    private String mCuid;
    private String mUuid;
    a cFs = new a();
    b cFt = new b();
    private String bVB = com.baidu.swan.c.a.getNetworkClass();
    private String cFA = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(String str) {
        Context appContext = AppRuntime.getAppContext();
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            this.mAppVersion = packageInfo.versionName;
            this.cFv = packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException e) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService("phone");
        if (telephonyManager != null && (Build.VERSION.SDK_INT < 23 || appContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            this.cFw = telephonyManager.getSimOperator();
        }
        this.mCuid = s.avW().getDeviceId(appContext);
        this.mUuid = s.avW().co(appContext);
        this.bYm = s.avW().getHostName();
        this.cFC = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a {
        String cFF;
        int cFG;
        String deviceType;
        String os = "Android";
        String osVersion = Build.VERSION.RELEASE;
        String brand = Build.MANUFACTURER;
        int adH = Build.VERSION.SDK_INT;
        String model = Build.MODEL;

        public a() {
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            this.cFF = windowManager.getDefaultDisplay().getWidth() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + windowManager.getDefaultDisplay().getHeight();
            this.cFG = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public final class b {
        String cFI;

        private b() {
            this.cFI = s.avW().getUserId(AppRuntime.getAppContext());
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("os", this.cFs.os);
            jSONObject2.putOpt("osversion", this.cFs.osVersion);
            jSONObject2.putOpt("model", this.cFs.model);
            jSONObject2.putOpt(CashierData.DEVICE_TYPE, this.cFs.deviceType);
            jSONObject2.putOpt(CashierData.SDK, this.cFs.adH + "");
            jSONObject2.putOpt(Constants.PHONE_BRAND, this.cFs.brand);
            jSONObject2.putOpt("screen", this.cFs.cFF);
            jSONObject2.putOpt("density", this.cFs.cFG + "");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("passId", this.cFt.cFI);
            jSONObject.putOpt("userInfo", jSONObject3);
            jSONObject.putOpt("system", jSONObject2);
            jSONObject.putOpt("appVersion", this.mAppVersion);
            jSONObject.putOpt("appBranch", this.cFu);
            jSONObject.putOpt("appPackageName", this.cFv);
            jSONObject.putOpt("cuid", this.mCuid);
            jSONObject.putOpt("uuid", this.mUuid);
            jSONObject.putOpt("hostName", this.bYm);
            jSONObject.putOpt("net", this.bVB);
            jSONObject.putOpt("operator", this.cFw);
            jSONObject.putOpt("smartAppId", this.cFx);
            jSONObject.putOpt("smartAppVersion", this.cFy);
            jSONObject.putOpt("swanCoreVersion", this.cFz);
            jSONObject.putOpt("swanType", this.cFA);
            jSONObject.putOpt("swanId", this.cFB);
            jSONObject.putOpt("bizId", this.cFC);
            jSONObject.putOpt("eventType", this.cFD);
            jSONObject.putOpt("eventName", this.buG);
            jSONObject.putOpt("content", this.mContent);
            jSONObject.putOpt("propagation", this.cFE);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void ce(JSONObject jSONObject) {
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
    public static String qZ(String str) {
        JSONObject jSONObject;
        if (s.avW() != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(str);
                }
                str = cf(jSONObject);
                return str;
            } catch (JSONException e) {
                return str;
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String cf(JSONObject jSONObject) {
        k avW = s.avW();
        if (jSONObject == null || avW == null) {
            return "";
        }
        try {
            String str = "";
            if (avW.Gz() == 0) {
                str = "swan";
            } else if (avW.Gz() == 1) {
                str = "swangame";
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("smartAppId", avW.getAppId());
            jSONObject2.putOpt("smartAppVersion", avW.getAppVersion());
            jSONObject2.putOpt("swanCoreVersion", avW.UZ());
            jSONObject2.putOpt("swanType", str);
            jSONObject.putOpt("appInfo", jSONObject2);
            return jSONObject.toString();
        } catch (JSONException e) {
            return jSONObject.toString();
        }
    }

    public static void I(JSONArray jSONArray) {
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
