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
public class r {
    private String bTJ;
    private String bpu;
    private String cAY;
    private String cAZ;
    private String cBa;
    private String cBb;
    private String cBc;
    private String cBd;
    private String cBf;
    private String cBg;
    private String cBh;
    private String cBi;
    private String mAppVersion;
    private String mContent;
    private String mCuid;
    private String mUuid;
    a cAW = new a();
    b cAX = new b();
    private String bQz = com.baidu.swan.c.a.getNetworkClass();
    private String cBe = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(String str) {
        Context appContext = AppRuntime.getAppContext();
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            this.mAppVersion = packageInfo.versionName;
            this.cAZ = packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException e) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService("phone");
        if (telephonyManager != null && (Build.VERSION.SDK_INT < 23 || appContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            this.cBa = telephonyManager.getSimOperator();
        }
        this.mCuid = s.atk().getDeviceId(appContext);
        this.mUuid = s.atk().cl(appContext);
        this.bTJ = s.atk().getHostName();
        this.cBg = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a {
        String cBj;
        int cBk;
        String deviceType;
        String os = "Android";
        String osVersion = Build.VERSION.RELEASE;
        String brand = Build.MANUFACTURER;
        int abe = Build.VERSION.SDK_INT;
        String model = Build.MODEL;

        public a() {
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            this.cBj = windowManager.getDefaultDisplay().getWidth() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + windowManager.getDefaultDisplay().getHeight();
            this.cBk = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public final class b {
        String cBm;

        private b() {
            this.cBm = s.atk().getUserId(AppRuntime.getAppContext());
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("os", this.cAW.os);
            jSONObject2.putOpt("osversion", this.cAW.osVersion);
            jSONObject2.putOpt("model", this.cAW.model);
            jSONObject2.putOpt(CashierData.DEVICE_TYPE, this.cAW.deviceType);
            jSONObject2.putOpt(CashierData.SDK, this.cAW.abe + "");
            jSONObject2.putOpt(Constants.PHONE_BRAND, this.cAW.brand);
            jSONObject2.putOpt("screen", this.cAW.cBj);
            jSONObject2.putOpt("density", this.cAW.cBk + "");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("passId", this.cAX.cBm);
            jSONObject.putOpt("userInfo", jSONObject3);
            jSONObject.putOpt("system", jSONObject2);
            jSONObject.putOpt("appVersion", this.mAppVersion);
            jSONObject.putOpt("appBranch", this.cAY);
            jSONObject.putOpt("appPackageName", this.cAZ);
            jSONObject.putOpt("cuid", this.mCuid);
            jSONObject.putOpt("uuid", this.mUuid);
            jSONObject.putOpt("hostName", this.bTJ);
            jSONObject.putOpt("net", this.bQz);
            jSONObject.putOpt("operator", this.cBa);
            jSONObject.putOpt("smartAppId", this.cBb);
            jSONObject.putOpt("smartAppVersion", this.cBc);
            jSONObject.putOpt("swanCoreVersion", this.cBd);
            jSONObject.putOpt("swanType", this.cBe);
            jSONObject.putOpt("swanId", this.cBf);
            jSONObject.putOpt("bizId", this.cBg);
            jSONObject.putOpt("eventType", this.cBh);
            jSONObject.putOpt("eventName", this.bpu);
            jSONObject.putOpt("content", this.mContent);
            jSONObject.putOpt("propagation", this.cBi);
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
    public static String qI(String str) {
        JSONObject jSONObject;
        if (s.atk() != null) {
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
        k atk = s.atk();
        if (jSONObject == null || atk == null) {
            return "";
        }
        try {
            String str = "";
            if (atk.DH() == 0) {
                str = "swan";
            } else if (atk.DH() == 1) {
                str = "swangame";
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("smartAppId", atk.getAppId());
            jSONObject2.putOpt("smartAppVersion", atk.getAppVersion());
            jSONObject2.putOpt("swanCoreVersion", atk.Sk());
            jSONObject2.putOpt("swanType", str);
            jSONObject.putOpt("appInfo", jSONObject2);
            return jSONObject.toString();
        } catch (JSONException e) {
            return jSONObject.toString();
        }
    }

    public static void H(JSONArray jSONArray) {
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
