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
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public String appId;
    public b dJA;
    public C0508a dJy;
    public c dJz;
    public JSONObject data;

    /* renamed from: com.baidu.swan.bdprivate.extensions.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0508a {
        public int aQj;
        public String dJB;
        public String dJC;
        public int dJD;
        public String dJE;
        public String dJF;
        public int dJG;
        public String mac;
        public int screenWidth;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public int dJH;
        public int network;
    }

    /* loaded from: classes8.dex */
    public static class c {
        public int coordType;
        public double latitude;
        public double longitude;
    }

    public a(@NonNull Context context, @NonNull JSONObject jSONObject) {
        C0508a c0508a = new C0508a();
        c cVar = new c();
        b bVar = new b();
        String aHw = e.aHw();
        this.appId = TextUtils.isEmpty(aHw) ? "" : aHw;
        this.dJy = c0508a;
        this.dJz = cVar;
        this.dJA = bVar;
        this.data = jSONObject;
        String aMZ = ak.aMZ();
        c0508a.dJB = "0".equals(aMZ) ? "" : aMZ;
        String androidId = getAndroidId();
        c0508a.dJC = "0".equals(androidId) ? "" : androidId;
        c0508a.dJD = 2;
        c0508a.aQj = com.baidu.swan.bdprivate.extensions.g.c.a.ds(context) ? 3 : 2;
        String alq = com.baidu.swan.apps.i.c.alq();
        c0508a.dJE = "NUL".equals(alq) ? "" : alq;
        String deviceModel = com.baidu.swan.apps.i.c.getDeviceModel();
        c0508a.dJF = "NUL".equals(deviceModel) ? "" : deviceModel;
        c0508a.dJG = ah.getDisplayHeight(context);
        c0508a.screenWidth = ah.getDisplayWidth(context);
        String wifiInfo = getWifiInfo();
        c0508a.mac = (TextUtils.isEmpty(wifiInfo) || Config.DEF_MAC_ID.equals(wifiInfo)) ? "" : "";
        bVar.network = com.baidu.swan.bdprivate.extensions.g.c.a.aOG();
        bVar.dJH = com.baidu.swan.bdprivate.extensions.g.c.a.dt(context);
    }

    @NonNull
    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.put("app_id", this.appId);
            jSONObject2.put("deviceid", this.dJy.dJB);
            jSONObject2.put("androidid", this.dJy.dJC);
            jSONObject2.put(HttpConstants.HTTP_OS_TYPE, this.dJy.dJD);
            jSONObject2.put(HttpConstants.DEVICE_TYPE, this.dJy.aQj);
            jSONObject2.put("device_vendor", this.dJy.dJE);
            jSONObject2.put("device_model", this.dJy.dJF);
            jSONObject2.put("screen_height", this.dJy.dJG);
            jSONObject2.put("screen_width", this.dJy.screenWidth);
            jSONObject2.put("mac", this.dJy.mac);
            jSONObject.put(Config.DEVICE_PART, jSONObject2);
            jSONObject3.put("coord_type", this.dJz.coordType);
            jSONObject3.put("latitude", this.dJz.latitude);
            jSONObject3.put("longitude", this.dJz.longitude);
            jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
            jSONObject4.put("network", this.dJA.network);
            jSONObject4.put("operator", this.dJA.dJH);
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
