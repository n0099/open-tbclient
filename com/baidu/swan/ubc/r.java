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
    private String bSM;
    private String cxe;
    private String deA;
    private String deC;
    private String deD;
    private String deE;
    private String deF;
    private String dev;
    private String dew;
    private String dex;
    private String dey;
    private String dez;
    private String mAppVersion;
    private String mContent;
    private String mCuid;
    private String mUuid;
    a det = new a();
    b deu = new b();
    private String cus = com.baidu.swan.c.a.getNetworkClass();
    private String deB = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(String str) {
        Context appContext = AppRuntime.getAppContext();
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            this.mAppVersion = packageInfo.versionName;
            this.dew = packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException e) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService("phone");
        if (telephonyManager != null && (Build.VERSION.SDK_INT < 23 || appContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            this.dex = telephonyManager.getSimOperator();
        }
        this.mCuid = s.aEh().getDeviceId(appContext);
        this.mUuid = s.aEh().cc(appContext);
        this.cxe = s.aEh().getHostName();
        this.deD = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a {
        String deG;
        int deH;
        String deviceType;
        String os = "Android";
        String osVersion = Build.VERSION.RELEASE;
        String brand = Build.MANUFACTURER;
        int avY = Build.VERSION.SDK_INT;
        String model = Build.MODEL;

        public a() {
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            this.deG = windowManager.getDefaultDisplay().getWidth() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + windowManager.getDefaultDisplay().getHeight();
            this.deH = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public final class b {
        String deJ;

        private b() {
            this.deJ = s.aEh().getUserId(AppRuntime.getAppContext());
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("os", this.det.os);
            jSONObject2.putOpt("osversion", this.det.osVersion);
            jSONObject2.putOpt("model", this.det.model);
            jSONObject2.putOpt(CashierData.DEVICE_TYPE, this.det.deviceType);
            jSONObject2.putOpt(CashierData.SDK, this.det.avY + "");
            jSONObject2.putOpt(Constants.PHONE_BRAND, this.det.brand);
            jSONObject2.putOpt("screen", this.det.deG);
            jSONObject2.putOpt("density", this.det.deH + "");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("passId", this.deu.deJ);
            jSONObject.putOpt("userInfo", jSONObject3);
            jSONObject.putOpt("system", jSONObject2);
            jSONObject.putOpt("appVersion", this.mAppVersion);
            jSONObject.putOpt("appBranch", this.dev);
            jSONObject.putOpt("appPackageName", this.dew);
            jSONObject.putOpt("cuid", this.mCuid);
            jSONObject.putOpt("uuid", this.mUuid);
            jSONObject.putOpt("hostName", this.cxe);
            jSONObject.putOpt("net", this.cus);
            jSONObject.putOpt("operator", this.dex);
            jSONObject.putOpt("smartAppId", this.dey);
            jSONObject.putOpt("smartAppVersion", this.dez);
            jSONObject.putOpt("swanCoreVersion", this.deA);
            jSONObject.putOpt("swanType", this.deB);
            jSONObject.putOpt("swanId", this.deC);
            jSONObject.putOpt("bizId", this.deD);
            jSONObject.putOpt("eventType", this.deE);
            jSONObject.putOpt("eventName", this.bSM);
            jSONObject.putOpt("content", this.mContent);
            jSONObject.putOpt("propagation", this.deF);
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
            if (aEh.Om() == 0) {
                str = "swan";
            } else if (aEh.Om() == 1) {
                str = "swangame";
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("smartAppId", aEh.getAppId());
            jSONObject2.putOpt("smartAppVersion", aEh.getAppVersion());
            jSONObject2.putOpt("swanCoreVersion", aEh.acO());
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
