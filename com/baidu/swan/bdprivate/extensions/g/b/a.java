package com.baidu.swan.bdprivate.extensions.g.b;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public String appId;
    public C0425a cXN;
    public c cXO;
    public b cXP;
    public JSONObject data;

    /* renamed from: com.baidu.swan.bdprivate.extensions.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0425a {
        public int aEP;
        public String cXQ;
        public String cXR;
        public int cXS;
        public String cXT;
        public String cXU;
        public int cXV;
        public String cXW;
        public int screenWidth;
    }

    /* loaded from: classes11.dex */
    public static class b {
        public int cXX;
        public int network;
    }

    /* loaded from: classes11.dex */
    public static class c {
        public int coordType;
        public double latitude;
        public double longitude;
    }

    public a(@NonNull Context context, @NonNull JSONObject jSONObject) {
        C0425a c0425a = new C0425a();
        c cVar = new c();
        b bVar = new b();
        String arx = e.arx();
        this.appId = TextUtils.isEmpty(arx) ? "" : arx;
        this.cXN = c0425a;
        this.cXO = cVar;
        this.cXP = bVar;
        this.data = jSONObject;
        String axd = al.axd();
        c0425a.cXQ = "0".equals(axd) ? "" : axd;
        String androidId = getAndroidId();
        c0425a.cXR = "0".equals(androidId) ? "" : androidId;
        c0425a.cXS = 2;
        c0425a.aEP = com.baidu.swan.bdprivate.extensions.g.c.a.dh(context) ? 3 : 2;
        String Xv = com.baidu.swan.apps.h.c.Xv();
        c0425a.cXT = "NUL".equals(Xv) ? "" : Xv;
        String deviceModel = com.baidu.swan.apps.h.c.getDeviceModel();
        c0425a.cXU = "NUL".equals(deviceModel) ? "" : deviceModel;
        c0425a.cXV = ai.getDisplayHeight(context);
        c0425a.screenWidth = ai.getDisplayWidth(context);
        String wifiInfo = getWifiInfo();
        c0425a.cXW = (TextUtils.isEmpty(wifiInfo) || Config.DEF_MAC_ID.equals(wifiInfo)) ? "" : "";
        bVar.network = com.baidu.swan.bdprivate.extensions.g.c.a.ayK();
        bVar.cXX = com.baidu.swan.bdprivate.extensions.g.c.a.di(context);
    }

    @NonNull
    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.put("app_id", this.appId);
            jSONObject2.put("deviceid", this.cXN.cXQ);
            jSONObject2.put("androidid", this.cXN.cXR);
            jSONObject2.put(HttpConstants.HTTP_OS_TYPE, this.cXN.cXS);
            jSONObject2.put(HttpConstants.DEVICE_TYPE, this.cXN.aEP);
            jSONObject2.put("device_vendor", this.cXN.cXT);
            jSONObject2.put("device_model", this.cXN.cXU);
            jSONObject2.put("screen_height", this.cXN.cXV);
            jSONObject2.put("screen_width", this.cXN.screenWidth);
            jSONObject2.put("mac", this.cXN.cXW);
            jSONObject.put(Config.DEVICE_PART, jSONObject2);
            jSONObject3.put("coord_type", this.cXO.coordType);
            jSONObject3.put("latitude", this.cXO.latitude);
            jSONObject3.put("longitude", this.cXO.longitude);
            jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
            jSONObject4.put("network", this.cXP.network);
            jSONObject4.put("operator", this.cXP.cXX);
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
