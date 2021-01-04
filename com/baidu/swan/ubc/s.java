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
/* loaded from: classes6.dex */
public class s {
    private String cKK;
    private String dQZ;
    private String eBJ;
    private String eBK;
    private String eBL;
    private String eBM;
    private String eBN;
    private String eBO;
    private String eBQ;
    private String eBR;
    private String eBS;
    private String eBT;
    private String mAppPackageName;
    private String mAppVersion;
    private String mContent;
    private String mCuid;
    private String mUuid;
    a eBH = new a();
    b eBI = new b();
    private String dOh = com.baidu.swan.b.a.getNetworkClass();
    private String eBP = "";

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
            this.eBK = telephonyManager.getSimOperator();
        }
        this.mCuid = e.bin().getDeviceId(appContext);
        this.mUuid = e.bin().df(appContext);
        this.dQZ = e.bin().getHostName();
        this.eBO = e.bin().aBD();
        this.eBR = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a {
        String bpL;
        String deviceType;
        int eBU;
        String os = "Android";
        String osVersion = Build.VERSION.RELEASE;
        String brand = Build.MANUFACTURER;
        int aSq = Build.VERSION.SDK_INT;
        String model = Build.MODEL;

        public a() {
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            this.bpL = windowManager.getDefaultDisplay().getWidth() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + windowManager.getDefaultDisplay().getHeight();
            this.eBU = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public final class b {
        String eBW;

        private b() {
            this.eBW = e.bin().getUserId(AppRuntime.getAppContext());
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("os", this.eBH.os);
            jSONObject2.putOpt("osversion", this.eBH.osVersion);
            jSONObject2.putOpt("model", this.eBH.model);
            jSONObject2.putOpt(CashierData.DEVICE_TYPE, this.eBH.deviceType);
            jSONObject2.putOpt(CashierData.SDK, this.eBH.aSq + "");
            jSONObject2.putOpt(Constants.PHONE_BRAND, this.eBH.brand);
            jSONObject2.putOpt("screen", this.eBH.bpL);
            jSONObject2.putOpt("density", this.eBH.eBU + "");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("passId", this.eBI.eBW);
            jSONObject.putOpt("userInfo", jSONObject3);
            jSONObject.putOpt("system", jSONObject2);
            jSONObject.putOpt("appVersion", this.mAppVersion);
            jSONObject.putOpt("appBranch", this.eBJ);
            jSONObject.putOpt("appPackageName", this.mAppPackageName);
            jSONObject.putOpt("cuid", this.mCuid);
            jSONObject.putOpt("uuid", this.mUuid);
            jSONObject.putOpt("hostName", this.dQZ);
            jSONObject.putOpt("net", this.dOh);
            jSONObject.putOpt("operator", this.eBK);
            jSONObject.putOpt("smartAppId", this.eBL);
            jSONObject.putOpt("smartAppVersion", this.eBM);
            jSONObject.putOpt("swanCoreVersion", this.eBN);
            jSONObject.putOpt("swanNativeVersion", this.eBO);
            jSONObject.putOpt("swanType", this.eBP);
            jSONObject.putOpt("swanId", this.eBQ);
            jSONObject.putOpt("bizId", this.eBR);
            jSONObject.putOpt("eventType", this.eBS);
            jSONObject.putOpt("eventName", this.cKK);
            jSONObject.putOpt("content", this.mContent);
            jSONObject.putOpt("propagation", this.eBT);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void dl(JSONObject jSONObject) {
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
    public static String zC(String str) {
        JSONObject jSONObject;
        if (e.bin() != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(str);
                }
                str = dm(jSONObject);
                return str;
            } catch (JSONException e) {
                return str;
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String dm(JSONObject jSONObject) {
        l bin = e.bin();
        if (jSONObject == null || bin == null) {
            return "";
        }
        try {
            String str = "";
            if (bin.ajk() == 0) {
                str = GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
            } else if (bin.ajk() == 1) {
                str = "swangame";
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("smartAppId", bin.getAppId());
            jSONObject2.putOpt("smartAppVersion", bin.getAppVersion());
            jSONObject2.putOpt("swanCoreVersion", bin.aBE());
            jSONObject2.putOpt("swanNativeVersion", bin.aBD());
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
