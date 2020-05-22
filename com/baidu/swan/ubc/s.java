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
    private String bMG;
    private String cJp;
    private String dqB;
    private String dqC;
    private String dqD;
    private String dqE;
    private String dqu;
    private String dqv;
    private String dqw;
    private String dqx;
    private String dqy;
    private String dqz;
    private String mAppVersion;
    private String mContent;
    private String mCuid;
    private String mUuid;
    a dqs = new a();
    b dqt = new b();
    private String cGy = com.baidu.swan.d.a.getNetworkClass();
    private String dqA = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(String str) {
        Context appContext = AppRuntime.getAppContext();
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            this.mAppVersion = packageInfo.versionName;
            this.dqv = packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException e) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService("phone");
        if (telephonyManager != null && (Build.VERSION.SDK_INT < 23 || appContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            this.dqw = telephonyManager.getSimOperator();
        }
        this.mCuid = e.aIh().getDeviceId(appContext);
        this.mUuid = e.aIh().cb(appContext);
        this.cJp = e.aIh().getHostName();
        this.dqC = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a {
        String deviceType;
        String dqF;
        int dqG;
        String os = "Android";
        String osVersion = Build.VERSION.RELEASE;
        String brand = Build.MANUFACTURER;
        int aBn = Build.VERSION.SDK_INT;
        String model = Build.MODEL;

        public a() {
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            this.dqF = windowManager.getDefaultDisplay().getWidth() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + windowManager.getDefaultDisplay().getHeight();
            this.dqG = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public final class b {
        String dqI;

        private b() {
            this.dqI = e.aIh().getUserId(AppRuntime.getAppContext());
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("os", this.dqs.os);
            jSONObject2.putOpt("osversion", this.dqs.osVersion);
            jSONObject2.putOpt("model", this.dqs.model);
            jSONObject2.putOpt(CashierData.DEVICE_TYPE, this.dqs.deviceType);
            jSONObject2.putOpt(CashierData.SDK, this.dqs.aBn + "");
            jSONObject2.putOpt(Constants.PHONE_BRAND, this.dqs.brand);
            jSONObject2.putOpt("screen", this.dqs.dqF);
            jSONObject2.putOpt("density", this.dqs.dqG + "");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("passId", this.dqt.dqI);
            jSONObject.putOpt("userInfo", jSONObject3);
            jSONObject.putOpt("system", jSONObject2);
            jSONObject.putOpt("appVersion", this.mAppVersion);
            jSONObject.putOpt("appBranch", this.dqu);
            jSONObject.putOpt("appPackageName", this.dqv);
            jSONObject.putOpt("cuid", this.mCuid);
            jSONObject.putOpt("uuid", this.mUuid);
            jSONObject.putOpt("hostName", this.cJp);
            jSONObject.putOpt("net", this.cGy);
            jSONObject.putOpt("operator", this.dqw);
            jSONObject.putOpt("smartAppId", this.dqx);
            jSONObject.putOpt("smartAppVersion", this.dqy);
            jSONObject.putOpt("swanCoreVersion", this.dqz);
            jSONObject.putOpt("swanType", this.dqA);
            jSONObject.putOpt("swanId", this.dqB);
            jSONObject.putOpt("bizId", this.dqC);
            jSONObject.putOpt("eventType", this.dqD);
            jSONObject.putOpt("eventName", this.bMG);
            jSONObject.putOpt("content", this.mContent);
            jSONObject.putOpt("propagation", this.dqE);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void cv(JSONObject jSONObject) {
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
    public static String tS(String str) {
        JSONObject jSONObject;
        if (e.aIh() != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(str);
                }
                str = cw(jSONObject);
                return str;
            } catch (JSONException e) {
                return str;
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String cw(JSONObject jSONObject) {
        l aIh = e.aIh();
        if (jSONObject == null || aIh == null) {
            return "";
        }
        try {
            String str = "";
            if (aIh.Qz() == 0) {
                str = "swan";
            } else if (aIh.Qz() == 1) {
                str = "swangame";
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("smartAppId", aIh.getAppId());
            jSONObject2.putOpt("smartAppVersion", aIh.getAppVersion());
            jSONObject2.putOpt("swanCoreVersion", aIh.afW());
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
