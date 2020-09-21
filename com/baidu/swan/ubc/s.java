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
/* loaded from: classes14.dex */
public class s {
    private String bZZ;
    private String dMo;
    private String dMp;
    private String dMq;
    private String dMr;
    private String dMs;
    private String dMt;
    private String dMu;
    private String dMw;
    private String dMx;
    private String dMy;
    private String dMz;
    private String dcC;
    private String mAppVersion;
    private String mContent;
    private String mCuid;
    private String mUuid;
    a dMm = new a();
    b dMn = new b();
    private String cZH = com.baidu.swan.b.a.getNetworkClass();
    private String dMv = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(String str) {
        Context appContext = AppRuntime.getAppContext();
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            this.mAppVersion = packageInfo.versionName;
            this.dMp = packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException e) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService("phone");
        if (telephonyManager != null && (Build.VERSION.SDK_INT < 23 || appContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            this.dMq = telephonyManager.getSimOperator();
        }
        this.mCuid = e.aWr().getDeviceId(appContext);
        this.mUuid = e.aWr().ck(appContext);
        this.dcC = e.aWr().getHostName();
        this.dMu = e.aWr().aqG();
        this.dMx = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public class a {
        String aDF;
        int dMA;
        String deviceType;
        String os = "Android";
        String osVersion = Build.VERSION.RELEASE;
        String brand = Build.MANUFACTURER;
        int aLF = Build.VERSION.SDK_INT;
        String model = Build.MODEL;

        public a() {
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            this.aDF = windowManager.getDefaultDisplay().getWidth() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + windowManager.getDefaultDisplay().getHeight();
            this.dMA = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public final class b {
        String dMC;

        private b() {
            this.dMC = e.aWr().getUserId(AppRuntime.getAppContext());
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("os", this.dMm.os);
            jSONObject2.putOpt("osversion", this.dMm.osVersion);
            jSONObject2.putOpt("model", this.dMm.model);
            jSONObject2.putOpt(CashierData.DEVICE_TYPE, this.dMm.deviceType);
            jSONObject2.putOpt(CashierData.SDK, this.dMm.aLF + "");
            jSONObject2.putOpt(Constants.PHONE_BRAND, this.dMm.brand);
            jSONObject2.putOpt("screen", this.dMm.aDF);
            jSONObject2.putOpt("density", this.dMm.dMA + "");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("passId", this.dMn.dMC);
            jSONObject.putOpt("userInfo", jSONObject3);
            jSONObject.putOpt("system", jSONObject2);
            jSONObject.putOpt("appVersion", this.mAppVersion);
            jSONObject.putOpt("appBranch", this.dMo);
            jSONObject.putOpt("appPackageName", this.dMp);
            jSONObject.putOpt("cuid", this.mCuid);
            jSONObject.putOpt("uuid", this.mUuid);
            jSONObject.putOpt("hostName", this.dcC);
            jSONObject.putOpt("net", this.cZH);
            jSONObject.putOpt("operator", this.dMq);
            jSONObject.putOpt("smartAppId", this.dMr);
            jSONObject.putOpt("smartAppVersion", this.dMs);
            jSONObject.putOpt("swanCoreVersion", this.dMt);
            jSONObject.putOpt("swanNativeVersion", this.dMu);
            jSONObject.putOpt("swanType", this.dMv);
            jSONObject.putOpt("swanId", this.dMw);
            jSONObject.putOpt("bizId", this.dMx);
            jSONObject.putOpt("eventType", this.dMy);
            jSONObject.putOpt("eventName", this.bZZ);
            jSONObject.putOpt("content", this.mContent);
            jSONObject.putOpt("propagation", this.dMz);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void cR(JSONObject jSONObject) {
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
    public static String xI(String str) {
        JSONObject jSONObject;
        if (e.aWr() != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(str);
                }
                str = cS(jSONObject);
                return str;
            } catch (JSONException e) {
                return str;
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String cS(JSONObject jSONObject) {
        l aWr = e.aWr();
        if (jSONObject == null || aWr == null) {
            return "";
        }
        try {
            String str = "";
            if (aWr.Yy() == 0) {
                str = "swan";
            } else if (aWr.Yy() == 1) {
                str = "swangame";
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("smartAppId", aWr.getAppId());
            jSONObject2.putOpt("smartAppVersion", aWr.getAppVersion());
            jSONObject2.putOpt("swanCoreVersion", aWr.aqH());
            jSONObject2.putOpt("swanNativeVersion", aWr.aqG());
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
