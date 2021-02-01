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
import com.baidu.swan.games.view.webview.GameWebViewJavascriptInterface;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class s {
    private String cIt;
    private String dOr;
    private String ezd;
    private String eze;
    private String ezf;
    private String ezg;
    private String ezh;
    private String ezi;
    private String ezk;
    private String ezl;
    private String ezm;
    private String ezn;
    private String mAppPackageName;
    private String mAppVersion;
    private String mContent;
    private String mCuid;
    private String mUuid;
    a ezb = new a();
    b ezc = new b();
    private String dLz = com.baidu.swan.b.a.getNetworkClass();
    private String ezj = "";

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
            this.eze = telephonyManager.getSimOperator();
        }
        this.mCuid = e.beH().getDeviceId(appContext);
        this.mUuid = e.beH().dd(appContext);
        this.dOr = e.beH().getHostName();
        this.ezi = e.beH().ayi();
        this.ezl = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a {
        String bor;
        String deviceType;
        int ezo;
        String os = "Android";
        String osVersion = Build.VERSION.RELEASE;
        String brand = Build.MANUFACTURER;
        int aQE = Build.VERSION.SDK_INT;
        String model = Build.MODEL;

        public a() {
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            this.bor = windowManager.getDefaultDisplay().getWidth() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + windowManager.getDefaultDisplay().getHeight();
            this.ezo = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public final class b {
        String ezq;

        private b() {
            this.ezq = e.beH().getUserId(AppRuntime.getAppContext());
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("os", this.ezb.os);
            jSONObject2.putOpt("osversion", this.ezb.osVersion);
            jSONObject2.putOpt("model", this.ezb.model);
            jSONObject2.putOpt(CashierData.DEVICE_TYPE, this.ezb.deviceType);
            jSONObject2.putOpt(CashierData.SDK, this.ezb.aQE + "");
            jSONObject2.putOpt(Constants.PHONE_BRAND, this.ezb.brand);
            jSONObject2.putOpt("screen", this.ezb.bor);
            jSONObject2.putOpt("density", this.ezb.ezo + "");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("passId", this.ezc.ezq);
            jSONObject.putOpt("userInfo", jSONObject3);
            jSONObject.putOpt("system", jSONObject2);
            jSONObject.putOpt("appVersion", this.mAppVersion);
            jSONObject.putOpt("appBranch", this.ezd);
            jSONObject.putOpt("appPackageName", this.mAppPackageName);
            jSONObject.putOpt("cuid", this.mCuid);
            jSONObject.putOpt("uuid", this.mUuid);
            jSONObject.putOpt("hostName", this.dOr);
            jSONObject.putOpt("net", this.dLz);
            jSONObject.putOpt("operator", this.eze);
            jSONObject.putOpt("smartAppId", this.ezf);
            jSONObject.putOpt("smartAppVersion", this.ezg);
            jSONObject.putOpt("swanCoreVersion", this.ezh);
            jSONObject.putOpt("swanNativeVersion", this.ezi);
            jSONObject.putOpt("swanType", this.ezj);
            jSONObject.putOpt("swanId", this.ezk);
            jSONObject.putOpt("bizId", this.ezl);
            jSONObject.putOpt("eventType", this.ezm);
            jSONObject.putOpt("eventName", this.cIt);
            jSONObject.putOpt("content", this.mContent);
            jSONObject.putOpt("propagation", this.ezn);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void di(JSONObject jSONObject) {
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
    public static String yK(String str) {
        JSONObject jSONObject;
        if (e.beH() != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(str);
                }
                str = dj(jSONObject);
                return str;
            } catch (JSONException e) {
                return str;
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String dj(JSONObject jSONObject) {
        l beH = e.beH();
        if (jSONObject == null || beH == null) {
            return "";
        }
        try {
            String str = "";
            if (beH.getFrameType() == 0) {
                str = GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
            } else if (beH.getFrameType() == 1) {
                str = "swangame";
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("smartAppId", beH.getAppId());
            jSONObject2.putOpt("smartAppVersion", beH.getAppVersion());
            jSONObject2.putOpt("swanCoreVersion", beH.ayj());
            jSONObject2.putOpt("swanNativeVersion", beH.ayi());
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
