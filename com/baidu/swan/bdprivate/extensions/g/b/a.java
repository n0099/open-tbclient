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
/* loaded from: classes3.dex */
public class a {
    public String appId;
    public JSONObject data;
    public C0470a dgW;
    public c dgX;
    public b dgY;

    /* renamed from: com.baidu.swan.bdprivate.extensions.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0470a {
        public int aJZ;
        public String dgZ;
        public String dha;
        public int dhb;
        public String dhc;
        public String dhd;
        public int dhe;
        public String mac;
        public int screenWidth;
    }

    /* loaded from: classes3.dex */
    public static class b {
        public int dhf;
        public int network;
    }

    /* loaded from: classes3.dex */
    public static class c {
        public int coordType;
        public double latitude;
        public double longitude;
    }

    public a(@NonNull Context context, @NonNull JSONObject jSONObject) {
        C0470a c0470a = new C0470a();
        c cVar = new c();
        b bVar = new b();
        String azK = e.azK();
        this.appId = TextUtils.isEmpty(azK) ? "" : azK;
        this.dgW = c0470a;
        this.dgX = cVar;
        this.dgY = bVar;
        this.data = jSONObject;
        String aFm = ak.aFm();
        c0470a.dgZ = "0".equals(aFm) ? "" : aFm;
        String androidId = getAndroidId();
        c0470a.dha = "0".equals(androidId) ? "" : androidId;
        c0470a.dhb = 2;
        c0470a.aJZ = com.baidu.swan.bdprivate.extensions.g.c.a.dn(context) ? 3 : 2;
        String adB = com.baidu.swan.apps.i.c.adB();
        c0470a.dhc = "NUL".equals(adB) ? "" : adB;
        String deviceModel = com.baidu.swan.apps.i.c.getDeviceModel();
        c0470a.dhd = "NUL".equals(deviceModel) ? "" : deviceModel;
        c0470a.dhe = ah.getDisplayHeight(context);
        c0470a.screenWidth = ah.getDisplayWidth(context);
        String wifiInfo = getWifiInfo();
        c0470a.mac = (TextUtils.isEmpty(wifiInfo) || Config.DEF_MAC_ID.equals(wifiInfo)) ? "" : "";
        bVar.network = com.baidu.swan.bdprivate.extensions.g.c.a.aGT();
        bVar.dhf = com.baidu.swan.bdprivate.extensions.g.c.a.m35do(context);
    }

    @NonNull
    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.put("app_id", this.appId);
            jSONObject2.put("deviceid", this.dgW.dgZ);
            jSONObject2.put("androidid", this.dgW.dha);
            jSONObject2.put(HttpConstants.HTTP_OS_TYPE, this.dgW.dhb);
            jSONObject2.put(HttpConstants.DEVICE_TYPE, this.dgW.aJZ);
            jSONObject2.put("device_vendor", this.dgW.dhc);
            jSONObject2.put("device_model", this.dgW.dhd);
            jSONObject2.put("screen_height", this.dgW.dhe);
            jSONObject2.put("screen_width", this.dgW.screenWidth);
            jSONObject2.put("mac", this.dgW.mac);
            jSONObject.put(Config.DEVICE_PART, jSONObject2);
            jSONObject3.put("coord_type", this.dgX.coordType);
            jSONObject3.put("latitude", this.dgX.latitude);
            jSONObject3.put("longitude", this.dgX.longitude);
            jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
            jSONObject4.put("network", this.dgY.network);
            jSONObject4.put("operator", this.dgY.dhf);
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
