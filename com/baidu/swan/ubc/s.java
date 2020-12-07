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
/* loaded from: classes17.dex */
public class s {
    private String cFU;
    private String dIu;
    private String erZ;
    private String esa;
    private String esb;
    private String esc;
    private String esd;
    private String ese;
    private String esg;
    private String esh;
    private String esi;
    private String esj;
    private String mAppPackageName;
    private String mAppVersion;
    private String mContent;
    private String mCuid;
    private String mUuid;
    a erX = new a();
    b erY = new b();
    private String dFD = com.baidu.swan.b.a.getNetworkClass();
    private String esf = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(String str) {
        Context appContext = AppRuntime.getAppContext();
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            this.mAppVersion = packageInfo.versionName;
            this.mAppPackageName = packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException e) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService("phone");
        if (telephonyManager != null && (Build.VERSION.SDK_INT < 23 || appContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            this.esa = telephonyManager.getSimOperator();
        }
        this.mCuid = e.bfQ().getDeviceId(appContext);
        this.mUuid = e.bfQ().cW(appContext);
        this.dIu = e.bfQ().getHostName();
        this.ese = e.bfQ().aAm();
        this.esh = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class a {
        String boc;
        String deviceType;
        int esk;
        String os = "Android";
        String osVersion = Build.VERSION.RELEASE;
        String brand = Build.MANUFACTURER;
        int aRB = Build.VERSION.SDK_INT;
        String model = Build.MODEL;

        public a() {
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            this.boc = windowManager.getDefaultDisplay().getWidth() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + windowManager.getDefaultDisplay().getHeight();
            this.esk = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public final class b {
        String esm;

        private b() {
            this.esm = e.bfQ().getUserId(AppRuntime.getAppContext());
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("os", this.erX.os);
            jSONObject2.putOpt("osversion", this.erX.osVersion);
            jSONObject2.putOpt("model", this.erX.model);
            jSONObject2.putOpt(CashierData.DEVICE_TYPE, this.erX.deviceType);
            jSONObject2.putOpt(CashierData.SDK, this.erX.aRB + "");
            jSONObject2.putOpt(Constants.PHONE_BRAND, this.erX.brand);
            jSONObject2.putOpt("screen", this.erX.boc);
            jSONObject2.putOpt("density", this.erX.esk + "");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("passId", this.erY.esm);
            jSONObject.putOpt("userInfo", jSONObject3);
            jSONObject.putOpt("system", jSONObject2);
            jSONObject.putOpt("appVersion", this.mAppVersion);
            jSONObject.putOpt("appBranch", this.erZ);
            jSONObject.putOpt("appPackageName", this.mAppPackageName);
            jSONObject.putOpt("cuid", this.mCuid);
            jSONObject.putOpt("uuid", this.mUuid);
            jSONObject.putOpt("hostName", this.dIu);
            jSONObject.putOpt("net", this.dFD);
            jSONObject.putOpt("operator", this.esa);
            jSONObject.putOpt("smartAppId", this.esb);
            jSONObject.putOpt("smartAppVersion", this.esc);
            jSONObject.putOpt("swanCoreVersion", this.esd);
            jSONObject.putOpt("swanNativeVersion", this.ese);
            jSONObject.putOpt("swanType", this.esf);
            jSONObject.putOpt("swanId", this.esg);
            jSONObject.putOpt("bizId", this.esh);
            jSONObject.putOpt("eventType", this.esi);
            jSONObject.putOpt("eventName", this.cFU);
            jSONObject.putOpt("content", this.mContent);
            jSONObject.putOpt("propagation", this.esj);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void dd(JSONObject jSONObject) {
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
    public static String zD(String str) {
        JSONObject jSONObject;
        if (e.bfQ() != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(str);
                }
                str = de(jSONObject);
                return str;
            } catch (JSONException e) {
                return str;
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String de(JSONObject jSONObject) {
        l bfQ = e.bfQ();
        if (jSONObject == null || bfQ == null) {
            return "";
        }
        try {
            String str = "";
            if (bfQ.aie() == 0) {
                str = "swan";
            } else if (bfQ.aie() == 1) {
                str = "swangame";
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("smartAppId", bfQ.getAppId());
            jSONObject2.putOpt("smartAppVersion", bfQ.getAppVersion());
            jSONObject2.putOpt("swanCoreVersion", bfQ.aAn());
            jSONObject2.putOpt("swanNativeVersion", bfQ.aAm());
            jSONObject2.putOpt("swanType", str);
            jSONObject.putOpt("appInfo", jSONObject2);
            return jSONObject.toString();
        } catch (JSONException e) {
            return jSONObject.toString();
        }
    }

    public static void M(JSONArray jSONArray) {
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
