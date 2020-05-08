package com.baidu.swan.bdprivate.c.f.b;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public String appId;
    public C0371a cCD;
    public c cCE;
    public b cCF;
    public JSONObject data;

    /* renamed from: com.baidu.swan.bdprivate.c.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0371a {
        public int awb;
        public String cCG;
        public String cCH;
        public int cCI;
        public String cCJ;
        public String cCK;
        public int cCL;
        public String cCM;
        public int screenWidth;
    }

    /* loaded from: classes11.dex */
    public static class b {
        public int cCN;
        public int network;
    }

    /* loaded from: classes11.dex */
    public static class c {
        public int coordType;
        public double latitude;
        public double longitude;
    }

    public a(@NonNull Context context, @NonNull JSONObject jSONObject) {
        C0371a c0371a = new C0371a();
        c cVar = new c();
        b bVar = new b();
        String akO = e.akO();
        this.appId = TextUtils.isEmpty(akO) ? "" : akO;
        this.cCD = c0371a;
        this.cCE = cVar;
        this.cCF = bVar;
        this.data = jSONObject;
        String apr = ai.apr();
        c0371a.cCG = "0".equals(apr) ? "" : apr;
        String androidId = getAndroidId();
        c0371a.cCH = "0".equals(androidId) ? "" : androidId;
        c0371a.cCI = 2;
        c0371a.awb = com.baidu.swan.bdprivate.c.f.c.a.cN(context) ? 3 : 2;
        String Tc = com.baidu.swan.apps.h.c.Tc();
        c0371a.cCJ = "NUL".equals(Tc) ? "" : Tc;
        String deviceModel = com.baidu.swan.apps.h.c.getDeviceModel();
        c0371a.cCK = "NUL".equals(deviceModel) ? "" : deviceModel;
        c0371a.cCL = af.getDisplayHeight(context);
        c0371a.screenWidth = af.getDisplayWidth(context);
        String wifiInfo = getWifiInfo();
        c0371a.cCM = (TextUtils.isEmpty(wifiInfo) || Config.DEF_MAC_ID.equals(wifiInfo)) ? "" : "";
        bVar.network = com.baidu.swan.bdprivate.c.f.c.a.aqJ();
        bVar.cCN = com.baidu.swan.bdprivate.c.f.c.a.cO(context);
    }

    @NonNull
    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.put("app_id", this.appId);
            jSONObject2.put("deviceid", this.cCD.cCG);
            jSONObject2.put("androidid", this.cCD.cCH);
            jSONObject2.put(HttpConstants.HTTP_OS_TYPE, this.cCD.cCI);
            jSONObject2.put(HttpConstants.DEVICE_TYPE, this.cCD.awb);
            jSONObject2.put("device_vendor", this.cCD.cCJ);
            jSONObject2.put("device_model", this.cCD.cCK);
            jSONObject2.put("screen_height", this.cCD.cCL);
            jSONObject2.put("screen_width", this.cCD.screenWidth);
            jSONObject2.put("mac", this.cCD.cCM);
            jSONObject.put(Config.DEVICE_PART, jSONObject2);
            jSONObject3.put("coord_type", this.cCE.coordType);
            jSONObject3.put("latitude", this.cCE.latitude);
            jSONObject3.put("longitude", this.cCE.longitude);
            jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
            jSONObject4.put("network", this.cCF.network);
            jSONObject4.put("operator", this.cCF.cCN);
            jSONObject.put("network", jSONObject4);
            jSONObject.put("data", this.data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public String toJsonString() {
        return toJsonObject().toString();
    }

    public String getAndroidId() {
        String string = Settings.Secure.getString(AppRuntime.getAppContext().getContentResolver(), "android_id");
        if (TextUtils.isEmpty(string)) {
            return "0";
        }
        return string;
    }

    public String getWifiInfo() {
        String str;
        try {
            str = ((WifiManager) AppRuntime.getAppContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
        } catch (Exception e) {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }
}
