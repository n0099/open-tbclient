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
public class r {
    private String bTV;
    private String bqi;
    private String cBj;
    private String cBk;
    private String cBl;
    private String cBm;
    private String cBn;
    private String cBo;
    private String cBq;
    private String cBr;
    private String cBs;
    private String cBt;
    private String mAppVersion;
    private String mContent;
    private String mCuid;
    private String mUuid;
    a cBh = new a();
    b cBi = new b();
    private String bRj = com.baidu.swan.c.a.getNetworkClass();
    private String cBp = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(String str) {
        Context appContext = AppRuntime.getAppContext();
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            this.mAppVersion = packageInfo.versionName;
            this.cBk = packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException e) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService("phone");
        if (telephonyManager != null && (Build.VERSION.SDK_INT < 23 || appContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            this.cBl = telephonyManager.getSimOperator();
        }
        this.mCuid = s.atD().getDeviceId(appContext);
        this.mUuid = s.atD().cl(appContext);
        this.bTV = s.atD().getHostName();
        this.cBr = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a {
        String cBu;
        int cBv;
        String deviceType;
        String os = "Android";
        String osVersion = Build.VERSION.RELEASE;
        String brand = Build.MANUFACTURER;
        int abr = Build.VERSION.SDK_INT;
        String model = Build.MODEL;

        public a() {
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            this.cBu = windowManager.getDefaultDisplay().getWidth() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + windowManager.getDefaultDisplay().getHeight();
            this.cBv = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public final class b {
        String cBx;

        private b() {
            this.cBx = s.atD().getUserId(AppRuntime.getAppContext());
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("os", this.cBh.os);
            jSONObject2.putOpt("osversion", this.cBh.osVersion);
            jSONObject2.putOpt("model", this.cBh.model);
            jSONObject2.putOpt(CashierData.DEVICE_TYPE, this.cBh.deviceType);
            jSONObject2.putOpt(CashierData.SDK, this.cBh.abr + "");
            jSONObject2.putOpt(Constants.PHONE_BRAND, this.cBh.brand);
            jSONObject2.putOpt("screen", this.cBh.cBu);
            jSONObject2.putOpt("density", this.cBh.cBv + "");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("passId", this.cBi.cBx);
            jSONObject.putOpt("userInfo", jSONObject3);
            jSONObject.putOpt("system", jSONObject2);
            jSONObject.putOpt("appVersion", this.mAppVersion);
            jSONObject.putOpt("appBranch", this.cBj);
            jSONObject.putOpt("appPackageName", this.cBk);
            jSONObject.putOpt("cuid", this.mCuid);
            jSONObject.putOpt("uuid", this.mUuid);
            jSONObject.putOpt("hostName", this.bTV);
            jSONObject.putOpt("net", this.bRj);
            jSONObject.putOpt("operator", this.cBl);
            jSONObject.putOpt("smartAppId", this.cBm);
            jSONObject.putOpt("smartAppVersion", this.cBn);
            jSONObject.putOpt("swanCoreVersion", this.cBo);
            jSONObject.putOpt("swanType", this.cBp);
            jSONObject.putOpt("swanId", this.cBq);
            jSONObject.putOpt("bizId", this.cBr);
            jSONObject.putOpt("eventType", this.cBs);
            jSONObject.putOpt("eventName", this.bqi);
            jSONObject.putOpt("content", this.mContent);
            jSONObject.putOpt("propagation", this.cBt);
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
    public static String qL(String str) {
        JSONObject jSONObject;
        if (s.atD() != null) {
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
        k atD = s.atD();
        if (jSONObject == null || atD == null) {
            return "";
        }
        try {
            String str = "";
            if (atD.Ed() == 0) {
                str = "swan";
            } else if (atD.Ed() == 1) {
                str = "swangame";
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("smartAppId", atD.getAppId());
            jSONObject2.putOpt("smartAppVersion", atD.getAppVersion());
            jSONObject2.putOpt("swanCoreVersion", atD.SG());
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
