package com.baidu.swan.bdprivate.extensions.g.b;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public String appId;
    public C0497a dWC;
    public c dWD;
    public b dWE;
    public JSONObject data;

    /* renamed from: com.baidu.swan.bdprivate.extensions.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0497a {
        public int aSb;
        public String dWF;
        public String dWG;
        public int dWH;
        public String dWI;
        public int dWJ;
        public String deviceModel;
        public String mac;
        public int screenWidth;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public int dWK;
        public int network;
    }

    /* loaded from: classes8.dex */
    public static class c {
        public int coordType;
        public double latitude;
        public double longitude;
    }

    public a(@NonNull Context context, @NonNull JSONObject jSONObject) {
        C0497a c0497a = new C0497a();
        c cVar = new c();
        b bVar = new b();
        String aIP = e.aIP();
        this.appId = TextUtils.isEmpty(aIP) ? "" : aIP;
        this.dWC = c0497a;
        this.dWD = cVar;
        this.dWE = bVar;
        this.data = jSONObject;
        String aOr = ak.aOr();
        c0497a.dWF = "0".equals(aOr) ? "" : aOr;
        String androidId = getAndroidId();
        c0497a.dWG = "0".equals(androidId) ? "" : androidId;
        c0497a.dWH = 2;
        c0497a.aSb = com.baidu.swan.bdprivate.extensions.g.c.a.eo(context) ? 3 : 2;
        String alJ = com.baidu.swan.apps.i.c.alJ();
        c0497a.dWI = "NUL".equals(alJ) ? "" : alJ;
        String deviceModel = com.baidu.swan.apps.i.c.getDeviceModel();
        c0497a.deviceModel = "NUL".equals(deviceModel) ? "" : deviceModel;
        c0497a.dWJ = ah.getDisplayHeight(context);
        c0497a.screenWidth = ah.getDisplayWidth(context);
        String wifiInfo = getWifiInfo();
        c0497a.mac = (TextUtils.isEmpty(wifiInfo) || Config.DEF_MAC_ID.equals(wifiInfo)) ? "" : "";
        bVar.network = com.baidu.swan.bdprivate.extensions.g.c.a.aQb();
        bVar.dWK = com.baidu.swan.bdprivate.extensions.g.c.a.ep(context);
    }

    @NonNull
    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.put("app_id", this.appId);
            jSONObject2.put("deviceid", this.dWC.dWF);
            jSONObject2.put("androidid", this.dWC.dWG);
            jSONObject2.put(HttpConstants.HTTP_OS_TYPE, this.dWC.dWH);
            jSONObject2.put(HttpConstants.DEVICE_TYPE, this.dWC.aSb);
            jSONObject2.put("device_vendor", this.dWC.dWI);
            jSONObject2.put("device_model", this.dWC.deviceModel);
            jSONObject2.put("screen_height", this.dWC.dWJ);
            jSONObject2.put("screen_width", this.dWC.screenWidth);
            jSONObject2.put("mac", this.dWC.mac);
            jSONObject.put(Config.DEVICE_PART, jSONObject2);
            jSONObject3.put("coord_type", this.dWD.coordType);
            jSONObject3.put("latitude", this.dWD.latitude);
            jSONObject3.put("longitude", this.dWD.longitude);
            jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
            jSONObject4.put("network", this.dWE.network);
            jSONObject4.put("operator", this.dWE.dWK);
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
