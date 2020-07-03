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
public class s {
    private String bRu;
    private String cNZ;
    private String dvg;
    private String dvh;
    private String dvi;
    private String dvj;
    private String dvk;
    private String dvl;
    private String dvn;
    private String dvo;
    private String dvp;
    private String dvq;
    private String mAppVersion;
    private String mContent;
    private String mCuid;
    private String mUuid;
    a dve = new a();
    b dvf = new b();
    private String cLi = com.baidu.swan.d.a.getNetworkClass();
    private String dvm = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(String str) {
        Context appContext = AppRuntime.getAppContext();
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            this.mAppVersion = packageInfo.versionName;
            this.dvh = packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException e) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService("phone");
        if (telephonyManager != null && (Build.VERSION.SDK_INT < 23 || appContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            this.dvi = telephonyManager.getSimOperator();
        }
        this.mCuid = e.aJn().getDeviceId(appContext);
        this.mUuid = e.aJn().cc(appContext);
        this.cNZ = e.aJn().getHostName();
        this.dvo = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a {
        String deviceType;
        String dvr;
        int dvs;
        String os = "Android";
        String osVersion = Build.VERSION.RELEASE;
        String brand = Build.MANUFACTURER;
        int aDy = Build.VERSION.SDK_INT;
        String model = Build.MODEL;

        public a() {
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            this.dvr = windowManager.getDefaultDisplay().getWidth() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + windowManager.getDefaultDisplay().getHeight();
            this.dvs = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public final class b {
        String dvu;

        private b() {
            this.dvu = e.aJn().getUserId(AppRuntime.getAppContext());
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("os", this.dve.os);
            jSONObject2.putOpt("osversion", this.dve.osVersion);
            jSONObject2.putOpt("model", this.dve.model);
            jSONObject2.putOpt(CashierData.DEVICE_TYPE, this.dve.deviceType);
            jSONObject2.putOpt(CashierData.SDK, this.dve.aDy + "");
            jSONObject2.putOpt(Constants.PHONE_BRAND, this.dve.brand);
            jSONObject2.putOpt("screen", this.dve.dvr);
            jSONObject2.putOpt("density", this.dve.dvs + "");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("passId", this.dvf.dvu);
            jSONObject.putOpt("userInfo", jSONObject3);
            jSONObject.putOpt("system", jSONObject2);
            jSONObject.putOpt("appVersion", this.mAppVersion);
            jSONObject.putOpt("appBranch", this.dvg);
            jSONObject.putOpt("appPackageName", this.dvh);
            jSONObject.putOpt("cuid", this.mCuid);
            jSONObject.putOpt("uuid", this.mUuid);
            jSONObject.putOpt("hostName", this.cNZ);
            jSONObject.putOpt("net", this.cLi);
            jSONObject.putOpt("operator", this.dvi);
            jSONObject.putOpt("smartAppId", this.dvj);
            jSONObject.putOpt("smartAppVersion", this.dvk);
            jSONObject.putOpt("swanCoreVersion", this.dvl);
            jSONObject.putOpt("swanType", this.dvm);
            jSONObject.putOpt("swanId", this.dvn);
            jSONObject.putOpt("bizId", this.dvo);
            jSONObject.putOpt("eventType", this.dvp);
            jSONObject.putOpt("eventName", this.bRu);
            jSONObject.putOpt("content", this.mContent);
            jSONObject.putOpt("propagation", this.dvq);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void cC(JSONObject jSONObject) {
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
    public static String ua(String str) {
        JSONObject jSONObject;
        if (e.aJn() != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(str);
                }
                str = cD(jSONObject);
                return str;
            } catch (JSONException e) {
                return str;
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String cD(JSONObject jSONObject) {
        l aJn = e.aJn();
        if (jSONObject == null || aJn == null) {
            return "";
        }
        try {
            String str = "";
            if (aJn.RF() == 0) {
                str = "swan";
            } else if (aJn.RF() == 1) {
                str = "swangame";
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("smartAppId", aJn.getAppId());
            jSONObject2.putOpt("smartAppVersion", aJn.getAppVersion());
            jSONObject2.putOpt("swanCoreVersion", aJn.ahc());
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
