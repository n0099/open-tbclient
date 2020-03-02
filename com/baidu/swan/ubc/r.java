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
    private String bYa;
    private String but;
    private String cFi;
    private String cFj;
    private String cFk;
    private String cFl;
    private String cFm;
    private String cFn;
    private String cFp;
    private String cFq;
    private String cFr;
    private String cFs;
    private String mAppVersion;
    private String mContent;
    private String mCuid;
    private String mUuid;
    a cFg = new a();
    b cFh = new b();
    private String bVp = com.baidu.swan.c.a.getNetworkClass();
    private String cFo = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(String str) {
        Context appContext = AppRuntime.getAppContext();
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            this.mAppVersion = packageInfo.versionName;
            this.cFj = packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException e) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService("phone");
        if (telephonyManager != null && (Build.VERSION.SDK_INT < 23 || appContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            this.cFk = telephonyManager.getSimOperator();
        }
        this.mCuid = s.avT().getDeviceId(appContext);
        this.mUuid = s.avT().cp(appContext);
        this.bYa = s.avT().getHostName();
        this.cFq = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a {
        String cFt;
        int cFu;
        String deviceType;
        String os = "Android";
        String osVersion = Build.VERSION.RELEASE;
        String brand = Build.MANUFACTURER;
        int adx = Build.VERSION.SDK_INT;
        String model = Build.MODEL;

        public a() {
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            this.cFt = windowManager.getDefaultDisplay().getWidth() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + windowManager.getDefaultDisplay().getHeight();
            this.cFu = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public final class b {
        String cFw;

        private b() {
            this.cFw = s.avT().getUserId(AppRuntime.getAppContext());
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("os", this.cFg.os);
            jSONObject2.putOpt("osversion", this.cFg.osVersion);
            jSONObject2.putOpt("model", this.cFg.model);
            jSONObject2.putOpt(CashierData.DEVICE_TYPE, this.cFg.deviceType);
            jSONObject2.putOpt(CashierData.SDK, this.cFg.adx + "");
            jSONObject2.putOpt(Constants.PHONE_BRAND, this.cFg.brand);
            jSONObject2.putOpt("screen", this.cFg.cFt);
            jSONObject2.putOpt("density", this.cFg.cFu + "");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("passId", this.cFh.cFw);
            jSONObject.putOpt("userInfo", jSONObject3);
            jSONObject.putOpt("system", jSONObject2);
            jSONObject.putOpt("appVersion", this.mAppVersion);
            jSONObject.putOpt("appBranch", this.cFi);
            jSONObject.putOpt("appPackageName", this.cFj);
            jSONObject.putOpt("cuid", this.mCuid);
            jSONObject.putOpt("uuid", this.mUuid);
            jSONObject.putOpt("hostName", this.bYa);
            jSONObject.putOpt("net", this.bVp);
            jSONObject.putOpt("operator", this.cFk);
            jSONObject.putOpt("smartAppId", this.cFl);
            jSONObject.putOpt("smartAppVersion", this.cFm);
            jSONObject.putOpt("swanCoreVersion", this.cFn);
            jSONObject.putOpt("swanType", this.cFo);
            jSONObject.putOpt("swanId", this.cFp);
            jSONObject.putOpt("bizId", this.cFq);
            jSONObject.putOpt("eventType", this.cFr);
            jSONObject.putOpt("eventName", this.but);
            jSONObject.putOpt("content", this.mContent);
            jSONObject.putOpt("propagation", this.cFs);
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
    public static String ra(String str) {
        JSONObject jSONObject;
        if (s.avT() != null) {
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
        k avT = s.avT();
        if (jSONObject == null || avT == null) {
            return "";
        }
        try {
            String str = "";
            if (avT.Gu() == 0) {
                str = "swan";
            } else if (avT.Gu() == 1) {
                str = "swangame";
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("smartAppId", avT.getAppId());
            jSONObject2.putOpt("smartAppVersion", avT.getAppVersion());
            jSONObject2.putOpt("swanCoreVersion", avT.UW());
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
