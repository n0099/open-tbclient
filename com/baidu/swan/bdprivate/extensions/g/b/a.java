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
/* loaded from: classes7.dex */
public class a {
    public String appId;
    public C0506a dHQ;
    public c dHR;
    public b dHS;
    public JSONObject data;

    /* renamed from: com.baidu.swan.bdprivate.extensions.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0506a {
        public int aOy;
        public String dHT;
        public String dHU;
        public int dHV;
        public String dHW;
        public String dHX;
        public int dHY;
        public String mac;
        public int screenWidth;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public int dHZ;
        public int network;
    }

    /* loaded from: classes7.dex */
    public static class c {
        public int coordType;
        public double latitude;
        public double longitude;
    }

    public a(@NonNull Context context, @NonNull JSONObject jSONObject) {
        C0506a c0506a = new C0506a();
        c cVar = new c();
        b bVar = new b();
        String aGO = e.aGO();
        this.appId = TextUtils.isEmpty(aGO) ? "" : aGO;
        this.dHQ = c0506a;
        this.dHR = cVar;
        this.dHS = bVar;
        this.data = jSONObject;
        String aMr = ak.aMr();
        c0506a.dHT = "0".equals(aMr) ? "" : aMr;
        String androidId = getAndroidId();
        c0506a.dHU = "0".equals(androidId) ? "" : androidId;
        c0506a.dHV = 2;
        c0506a.aOy = com.baidu.swan.bdprivate.extensions.g.c.a.ds(context) ? 3 : 2;
        String akI = com.baidu.swan.apps.i.c.akI();
        c0506a.dHW = "NUL".equals(akI) ? "" : akI;
        String deviceModel = com.baidu.swan.apps.i.c.getDeviceModel();
        c0506a.dHX = "NUL".equals(deviceModel) ? "" : deviceModel;
        c0506a.dHY = ah.getDisplayHeight(context);
        c0506a.screenWidth = ah.getDisplayWidth(context);
        String wifiInfo = getWifiInfo();
        c0506a.mac = (TextUtils.isEmpty(wifiInfo) || Config.DEF_MAC_ID.equals(wifiInfo)) ? "" : "";
        bVar.network = com.baidu.swan.bdprivate.extensions.g.c.a.aNY();
        bVar.dHZ = com.baidu.swan.bdprivate.extensions.g.c.a.dt(context);
    }

    @NonNull
    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.put("app_id", this.appId);
            jSONObject2.put("deviceid", this.dHQ.dHT);
            jSONObject2.put("androidid", this.dHQ.dHU);
            jSONObject2.put(HttpConstants.HTTP_OS_TYPE, this.dHQ.dHV);
            jSONObject2.put(HttpConstants.DEVICE_TYPE, this.dHQ.aOy);
            jSONObject2.put("device_vendor", this.dHQ.dHW);
            jSONObject2.put("device_model", this.dHQ.dHX);
            jSONObject2.put("screen_height", this.dHQ.dHY);
            jSONObject2.put("screen_width", this.dHQ.screenWidth);
            jSONObject2.put("mac", this.dHQ.mac);
            jSONObject.put(Config.DEVICE_PART, jSONObject2);
            jSONObject3.put("coord_type", this.dHR.coordType);
            jSONObject3.put("latitude", this.dHR.latitude);
            jSONObject3.put("longitude", this.dHR.longitude);
            jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
            jSONObject4.put("network", this.dHS.network);
            jSONObject4.put("operator", this.dHS.dHZ);
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
