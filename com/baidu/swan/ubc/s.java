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
/* loaded from: classes10.dex */
public class s {
    private String bXY;
    private String dKk;
    private String dKl;
    private String dKm;
    private String dKn;
    private String dKo;
    private String dKp;
    private String dKq;
    private String dKs;
    private String dKt;
    private String dKu;
    private String dKv;
    private String daB;
    private String mAppVersion;
    private String mContent;
    private String mCuid;
    private String mUuid;
    a dKi = new a();
    b dKj = new b();
    private String cXH = com.baidu.swan.b.a.getNetworkClass();
    private String dKr = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(String str) {
        Context appContext = AppRuntime.getAppContext();
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            this.mAppVersion = packageInfo.versionName;
            this.dKl = packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException e) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService("phone");
        if (telephonyManager != null && (Build.VERSION.SDK_INT < 23 || appContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            this.dKm = telephonyManager.getSimOperator();
        }
        this.mCuid = e.aVF().getDeviceId(appContext);
        this.mUuid = e.aVF().cl(appContext);
        this.daB = e.aVF().getHostName();
        this.dKq = e.aVF().apW();
        this.dKt = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a {
        String dKw;
        int dKx;
        String deviceType;
        String os = "Android";
        String osVersion = Build.VERSION.RELEASE;
        String brand = Build.MANUFACTURER;
        int aKe = Build.VERSION.SDK_INT;
        String model = Build.MODEL;

        public a() {
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            this.dKw = windowManager.getDefaultDisplay().getWidth() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + windowManager.getDefaultDisplay().getHeight();
            this.dKx = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public final class b {
        String dKz;

        private b() {
            this.dKz = e.aVF().getUserId(AppRuntime.getAppContext());
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("os", this.dKi.os);
            jSONObject2.putOpt("osversion", this.dKi.osVersion);
            jSONObject2.putOpt("model", this.dKi.model);
            jSONObject2.putOpt(CashierData.DEVICE_TYPE, this.dKi.deviceType);
            jSONObject2.putOpt(CashierData.SDK, this.dKi.aKe + "");
            jSONObject2.putOpt(Constants.PHONE_BRAND, this.dKi.brand);
            jSONObject2.putOpt("screen", this.dKi.dKw);
            jSONObject2.putOpt("density", this.dKi.dKx + "");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("passId", this.dKj.dKz);
            jSONObject.putOpt("userInfo", jSONObject3);
            jSONObject.putOpt("system", jSONObject2);
            jSONObject.putOpt("appVersion", this.mAppVersion);
            jSONObject.putOpt("appBranch", this.dKk);
            jSONObject.putOpt("appPackageName", this.dKl);
            jSONObject.putOpt("cuid", this.mCuid);
            jSONObject.putOpt("uuid", this.mUuid);
            jSONObject.putOpt("hostName", this.daB);
            jSONObject.putOpt("net", this.cXH);
            jSONObject.putOpt("operator", this.dKm);
            jSONObject.putOpt("smartAppId", this.dKn);
            jSONObject.putOpt("smartAppVersion", this.dKo);
            jSONObject.putOpt("swanCoreVersion", this.dKp);
            jSONObject.putOpt("swanNativeVersion", this.dKq);
            jSONObject.putOpt("swanType", this.dKr);
            jSONObject.putOpt("swanId", this.dKs);
            jSONObject.putOpt("bizId", this.dKt);
            jSONObject.putOpt("eventType", this.dKu);
            jSONObject.putOpt("eventName", this.bXY);
            jSONObject.putOpt("content", this.mContent);
            jSONObject.putOpt("propagation", this.dKv);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void cO(JSONObject jSONObject) {
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
    public static String xp(String str) {
        JSONObject jSONObject;
        if (e.aVF() != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(str);
                }
                str = cP(jSONObject);
                return str;
            } catch (JSONException e) {
                return str;
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String cP(JSONObject jSONObject) {
        l aVF = e.aVF();
        if (jSONObject == null || aVF == null) {
            return "";
        }
        try {
            String str = "";
            if (aVF.XP() == 0) {
                str = "swan";
            } else if (aVF.XP() == 1) {
                str = "swangame";
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("smartAppId", aVF.getAppId());
            jSONObject2.putOpt("smartAppVersion", aVF.getAppVersion());
            jSONObject2.putOpt("swanCoreVersion", aVF.apX());
            jSONObject2.putOpt("swanNativeVersion", aVF.apW());
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
