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
    private String bXU;
    private String dKg;
    private String dKh;
    private String dKi;
    private String dKj;
    private String dKk;
    private String dKl;
    private String dKm;
    private String dKo;
    private String dKp;
    private String dKq;
    private String dKr;
    private String daw;
    private String mAppVersion;
    private String mContent;
    private String mCuid;
    private String mUuid;
    a dKe = new a();
    b dKf = new b();
    private String cXD = com.baidu.swan.b.a.getNetworkClass();
    private String dKn = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(String str) {
        Context appContext = AppRuntime.getAppContext();
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            this.mAppVersion = packageInfo.versionName;
            this.dKh = packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException e) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService("phone");
        if (telephonyManager != null && (Build.VERSION.SDK_INT < 23 || appContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            this.dKi = telephonyManager.getSimOperator();
        }
        this.mCuid = e.aVF().getDeviceId(appContext);
        this.mUuid = e.aVF().cl(appContext);
        this.daw = e.aVF().getHostName();
        this.dKm = e.aVF().apW();
        this.dKp = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a {
        String dKs;
        int dKt;
        String deviceType;
        String os = "Android";
        String osVersion = Build.VERSION.RELEASE;
        String brand = Build.MANUFACTURER;
        int aKc = Build.VERSION.SDK_INT;
        String model = Build.MODEL;

        public a() {
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            this.dKs = windowManager.getDefaultDisplay().getWidth() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + windowManager.getDefaultDisplay().getHeight();
            this.dKt = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public final class b {
        String dKv;

        private b() {
            this.dKv = e.aVF().getUserId(AppRuntime.getAppContext());
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("os", this.dKe.os);
            jSONObject2.putOpt("osversion", this.dKe.osVersion);
            jSONObject2.putOpt("model", this.dKe.model);
            jSONObject2.putOpt(CashierData.DEVICE_TYPE, this.dKe.deviceType);
            jSONObject2.putOpt(CashierData.SDK, this.dKe.aKc + "");
            jSONObject2.putOpt(Constants.PHONE_BRAND, this.dKe.brand);
            jSONObject2.putOpt("screen", this.dKe.dKs);
            jSONObject2.putOpt("density", this.dKe.dKt + "");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("passId", this.dKf.dKv);
            jSONObject.putOpt("userInfo", jSONObject3);
            jSONObject.putOpt("system", jSONObject2);
            jSONObject.putOpt("appVersion", this.mAppVersion);
            jSONObject.putOpt("appBranch", this.dKg);
            jSONObject.putOpt("appPackageName", this.dKh);
            jSONObject.putOpt("cuid", this.mCuid);
            jSONObject.putOpt("uuid", this.mUuid);
            jSONObject.putOpt("hostName", this.daw);
            jSONObject.putOpt("net", this.cXD);
            jSONObject.putOpt("operator", this.dKi);
            jSONObject.putOpt("smartAppId", this.dKj);
            jSONObject.putOpt("smartAppVersion", this.dKk);
            jSONObject.putOpt("swanCoreVersion", this.dKl);
            jSONObject.putOpt("swanNativeVersion", this.dKm);
            jSONObject.putOpt("swanType", this.dKn);
            jSONObject.putOpt("swanId", this.dKo);
            jSONObject.putOpt("bizId", this.dKp);
            jSONObject.putOpt("eventType", this.dKq);
            jSONObject.putOpt("eventName", this.bXU);
            jSONObject.putOpt("content", this.mContent);
            jSONObject.putOpt("propagation", this.dKr);
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
    public static String xo(String str) {
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
