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
/* loaded from: classes9.dex */
public class s {
    private String cuT;
    private String dxl;
    private String egM;
    private String egN;
    private String egO;
    private String egP;
    private String egQ;
    private String egR;
    private String egS;
    private String egU;
    private String egV;
    private String egW;
    private String egX;
    private String mAppVersion;
    private String mContent;
    private String mCuid;
    private String mUuid;
    a egK = new a();
    b egL = new b();
    private String dut = com.baidu.swan.b.a.getNetworkClass();
    private String egT = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(String str) {
        Context appContext = AppRuntime.getAppContext();
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            this.mAppVersion = packageInfo.versionName;
            this.egN = packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException e) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService("phone");
        if (telephonyManager != null && (Build.VERSION.SDK_INT < 23 || appContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            this.egO = telephonyManager.getSimOperator();
        }
        this.mCuid = e.baS().getDeviceId(appContext);
        this.mUuid = e.baS().cq(appContext);
        this.dxl = e.baS().getHostName();
        this.egS = e.baS().avm();
        this.egV = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a {
        String aGR;
        String deviceType;
        int egY;
        String os = "Android";
        String osVersion = Build.VERSION.RELEASE;
        String brand = Build.MANUFACTURER;
        int aPp = Build.VERSION.SDK_INT;
        String model = Build.MODEL;

        public a() {
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            this.aGR = windowManager.getDefaultDisplay().getWidth() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + windowManager.getDefaultDisplay().getHeight();
            this.egY = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public final class b {
        String eha;

        private b() {
            this.eha = e.baS().getUserId(AppRuntime.getAppContext());
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("os", this.egK.os);
            jSONObject2.putOpt("osversion", this.egK.osVersion);
            jSONObject2.putOpt("model", this.egK.model);
            jSONObject2.putOpt(CashierData.DEVICE_TYPE, this.egK.deviceType);
            jSONObject2.putOpt(CashierData.SDK, this.egK.aPp + "");
            jSONObject2.putOpt(Constants.PHONE_BRAND, this.egK.brand);
            jSONObject2.putOpt("screen", this.egK.aGR);
            jSONObject2.putOpt("density", this.egK.egY + "");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("passId", this.egL.eha);
            jSONObject.putOpt("userInfo", jSONObject3);
            jSONObject.putOpt("system", jSONObject2);
            jSONObject.putOpt("appVersion", this.mAppVersion);
            jSONObject.putOpt("appBranch", this.egM);
            jSONObject.putOpt("appPackageName", this.egN);
            jSONObject.putOpt("cuid", this.mCuid);
            jSONObject.putOpt("uuid", this.mUuid);
            jSONObject.putOpt("hostName", this.dxl);
            jSONObject.putOpt("net", this.dut);
            jSONObject.putOpt("operator", this.egO);
            jSONObject.putOpt("smartAppId", this.egP);
            jSONObject.putOpt("smartAppVersion", this.egQ);
            jSONObject.putOpt("swanCoreVersion", this.egR);
            jSONObject.putOpt("swanNativeVersion", this.egS);
            jSONObject.putOpt("swanType", this.egT);
            jSONObject.putOpt("swanId", this.egU);
            jSONObject.putOpt("bizId", this.egV);
            jSONObject.putOpt("eventType", this.egW);
            jSONObject.putOpt("eventName", this.cuT);
            jSONObject.putOpt("content", this.mContent);
            jSONObject.putOpt("propagation", this.egX);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void db(JSONObject jSONObject) {
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
    public static String yN(String str) {
        JSONObject jSONObject;
        if (e.baS() != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(str);
                }
                str = dc(jSONObject);
                return str;
            } catch (JSONException e) {
                return str;
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String dc(JSONObject jSONObject) {
        l baS = e.baS();
        if (jSONObject == null || baS == null) {
            return "";
        }
        try {
            String str = "";
            if (baS.ade() == 0) {
                str = "swan";
            } else if (baS.ade() == 1) {
                str = "swangame";
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("smartAppId", baS.getAppId());
            jSONObject2.putOpt("smartAppVersion", baS.getAppVersion());
            jSONObject2.putOpt("swanCoreVersion", baS.avn());
            jSONObject2.putOpt("swanNativeVersion", baS.avm());
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
