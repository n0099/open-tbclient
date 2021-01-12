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
    private String cFY;
    private String dMn;
    private String ewU;
    private String ewV;
    private String ewW;
    private String ewX;
    private String ewY;
    private String ewZ;
    private String exb;
    private String exc;
    private String exd;
    private String exe;
    private String mAppPackageName;
    private String mAppVersion;
    private String mContent;
    private String mCuid;
    private String mUuid;
    a ewS = new a();
    b ewT = new b();
    private String dJv = com.baidu.swan.b.a.getNetworkClass();
    private String exa = "";

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
            this.ewV = telephonyManager.getSimOperator();
        }
        this.mCuid = e.beu().getDeviceId(appContext);
        this.mUuid = e.beu().de(appContext);
        this.dMn = e.beu().getHostName();
        this.ewZ = e.beu().axK();
        this.exc = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a {
        String bkY;
        String deviceType;
        int exf;
        String os = "Android";
        String osVersion = Build.VERSION.RELEASE;
        String brand = Build.MANUFACTURER;
        int aND = Build.VERSION.SDK_INT;
        String model = Build.MODEL;

        public a() {
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            this.bkY = windowManager.getDefaultDisplay().getWidth() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + windowManager.getDefaultDisplay().getHeight();
            this.exf = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public final class b {
        String exh;

        private b() {
            this.exh = e.beu().getUserId(AppRuntime.getAppContext());
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("os", this.ewS.os);
            jSONObject2.putOpt("osversion", this.ewS.osVersion);
            jSONObject2.putOpt("model", this.ewS.model);
            jSONObject2.putOpt(CashierData.DEVICE_TYPE, this.ewS.deviceType);
            jSONObject2.putOpt(CashierData.SDK, this.ewS.aND + "");
            jSONObject2.putOpt(Constants.PHONE_BRAND, this.ewS.brand);
            jSONObject2.putOpt("screen", this.ewS.bkY);
            jSONObject2.putOpt("density", this.ewS.exf + "");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("passId", this.ewT.exh);
            jSONObject.putOpt("userInfo", jSONObject3);
            jSONObject.putOpt("system", jSONObject2);
            jSONObject.putOpt("appVersion", this.mAppVersion);
            jSONObject.putOpt("appBranch", this.ewU);
            jSONObject.putOpt("appPackageName", this.mAppPackageName);
            jSONObject.putOpt("cuid", this.mCuid);
            jSONObject.putOpt("uuid", this.mUuid);
            jSONObject.putOpt("hostName", this.dMn);
            jSONObject.putOpt("net", this.dJv);
            jSONObject.putOpt("operator", this.ewV);
            jSONObject.putOpt("smartAppId", this.ewW);
            jSONObject.putOpt("smartAppVersion", this.ewX);
            jSONObject.putOpt("swanCoreVersion", this.ewY);
            jSONObject.putOpt("swanNativeVersion", this.ewZ);
            jSONObject.putOpt("swanType", this.exa);
            jSONObject.putOpt("swanId", this.exb);
            jSONObject.putOpt("bizId", this.exc);
            jSONObject.putOpt("eventType", this.exd);
            jSONObject.putOpt("eventName", this.cFY);
            jSONObject.putOpt("content", this.mContent);
            jSONObject.putOpt("propagation", this.exe);
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
    public static String yr(String str) {
        JSONObject jSONObject;
        if (e.beu() != null) {
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
        l beu = e.beu();
        if (jSONObject == null || beu == null) {
            return "";
        }
        try {
            String str = "";
            if (beu.afr() == 0) {
                str = GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
            } else if (beu.afr() == 1) {
                str = "swangame";
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("smartAppId", beu.getAppId());
            jSONObject2.putOpt("smartAppVersion", beu.getAppVersion());
            jSONObject2.putOpt("swanCoreVersion", beu.axL());
            jSONObject2.putOpt("swanNativeVersion", beu.axK());
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
