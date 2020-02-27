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
    private String bXZ;
    private String bus;
    private String cFh;
    private String cFi;
    private String cFj;
    private String cFk;
    private String cFl;
    private String cFm;
    private String cFo;
    private String cFp;
    private String cFq;
    private String cFr;
    private String mAppVersion;
    private String mContent;
    private String mCuid;
    private String mUuid;
    a cFf = new a();
    b cFg = new b();
    private String bVo = com.baidu.swan.c.a.getNetworkClass();
    private String cFn = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(String str) {
        Context appContext = AppRuntime.getAppContext();
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            this.mAppVersion = packageInfo.versionName;
            this.cFi = packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException e) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService("phone");
        if (telephonyManager != null && (Build.VERSION.SDK_INT < 23 || appContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            this.cFj = telephonyManager.getSimOperator();
        }
        this.mCuid = s.avR().getDeviceId(appContext);
        this.mUuid = s.avR().cp(appContext);
        this.bXZ = s.avR().getHostName();
        this.cFp = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a {
        String cFs;
        int cFt;
        String deviceType;
        String os = "Android";
        String osVersion = Build.VERSION.RELEASE;
        String brand = Build.MANUFACTURER;
        int adx = Build.VERSION.SDK_INT;
        String model = Build.MODEL;

        public a() {
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            this.cFs = windowManager.getDefaultDisplay().getWidth() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + windowManager.getDefaultDisplay().getHeight();
            this.cFt = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public final class b {
        String cFv;

        private b() {
            this.cFv = s.avR().getUserId(AppRuntime.getAppContext());
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("os", this.cFf.os);
            jSONObject2.putOpt("osversion", this.cFf.osVersion);
            jSONObject2.putOpt("model", this.cFf.model);
            jSONObject2.putOpt(CashierData.DEVICE_TYPE, this.cFf.deviceType);
            jSONObject2.putOpt(CashierData.SDK, this.cFf.adx + "");
            jSONObject2.putOpt(Constants.PHONE_BRAND, this.cFf.brand);
            jSONObject2.putOpt("screen", this.cFf.cFs);
            jSONObject2.putOpt("density", this.cFf.cFt + "");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("passId", this.cFg.cFv);
            jSONObject.putOpt("userInfo", jSONObject3);
            jSONObject.putOpt("system", jSONObject2);
            jSONObject.putOpt("appVersion", this.mAppVersion);
            jSONObject.putOpt("appBranch", this.cFh);
            jSONObject.putOpt("appPackageName", this.cFi);
            jSONObject.putOpt("cuid", this.mCuid);
            jSONObject.putOpt("uuid", this.mUuid);
            jSONObject.putOpt("hostName", this.bXZ);
            jSONObject.putOpt("net", this.bVo);
            jSONObject.putOpt("operator", this.cFj);
            jSONObject.putOpt("smartAppId", this.cFk);
            jSONObject.putOpt("smartAppVersion", this.cFl);
            jSONObject.putOpt("swanCoreVersion", this.cFm);
            jSONObject.putOpt("swanType", this.cFn);
            jSONObject.putOpt("swanId", this.cFo);
            jSONObject.putOpt("bizId", this.cFp);
            jSONObject.putOpt("eventType", this.cFq);
            jSONObject.putOpt("eventName", this.bus);
            jSONObject.putOpt("content", this.mContent);
            jSONObject.putOpt("propagation", this.cFr);
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
        if (s.avR() != null) {
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
        k avR = s.avR();
        if (jSONObject == null || avR == null) {
            return "";
        }
        try {
            String str = "";
            if (avR.Gs() == 0) {
                str = "swan";
            } else if (avR.Gs() == 1) {
                str = "swangame";
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("smartAppId", avR.getAppId());
            jSONObject2.putOpt("smartAppVersion", avR.getAppVersion());
            jSONObject2.putOpt("swanCoreVersion", avR.UU());
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
