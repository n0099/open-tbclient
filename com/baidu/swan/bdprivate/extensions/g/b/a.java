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
    public C0465a djd;
    public c dje;
    public b djf;

    /* renamed from: com.baidu.swan.bdprivate.extensions.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0465a {
        public int aLC;
        public String djg;
        public String djh;
        public int dji;
        public String djj;
        public String djk;
        public int djl;
        public String mac;
        public int screenWidth;
    }

    /* loaded from: classes3.dex */
    public static class b {
        public int djm;
        public int network;
    }

    /* loaded from: classes3.dex */
    public static class c {
        public int coordType;
        public double latitude;
        public double longitude;
    }

    public a(@NonNull Context context, @NonNull JSONObject jSONObject) {
        C0465a c0465a = new C0465a();
        c cVar = new c();
        b bVar = new b();
        String aAt = e.aAt();
        this.appId = TextUtils.isEmpty(aAt) ? "" : aAt;
        this.djd = c0465a;
        this.dje = cVar;
        this.djf = bVar;
        this.data = jSONObject;
        String aFW = ak.aFW();
        c0465a.djg = "0".equals(aFW) ? "" : aFW;
        String androidId = getAndroidId();
        c0465a.djh = "0".equals(androidId) ? "" : androidId;
        c0465a.dji = 2;
        c0465a.aLC = com.baidu.swan.bdprivate.extensions.g.c.a.dm(context) ? 3 : 2;
        String ael = com.baidu.swan.apps.i.c.ael();
        c0465a.djj = "NUL".equals(ael) ? "" : ael;
        String deviceModel = com.baidu.swan.apps.i.c.getDeviceModel();
        c0465a.djk = "NUL".equals(deviceModel) ? "" : deviceModel;
        c0465a.djl = ah.getDisplayHeight(context);
        c0465a.screenWidth = ah.getDisplayWidth(context);
        String wifiInfo = getWifiInfo();
        c0465a.mac = (TextUtils.isEmpty(wifiInfo) || Config.DEF_MAC_ID.equals(wifiInfo)) ? "" : "";
        bVar.network = com.baidu.swan.bdprivate.extensions.g.c.a.aHD();
        bVar.djm = com.baidu.swan.bdprivate.extensions.g.c.a.dn(context);
    }

    @NonNull
    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.put("app_id", this.appId);
            jSONObject2.put("deviceid", this.djd.djg);
            jSONObject2.put("androidid", this.djd.djh);
            jSONObject2.put(HttpConstants.HTTP_OS_TYPE, this.djd.dji);
            jSONObject2.put(HttpConstants.DEVICE_TYPE, this.djd.aLC);
            jSONObject2.put("device_vendor", this.djd.djj);
            jSONObject2.put("device_model", this.djd.djk);
            jSONObject2.put("screen_height", this.djd.djl);
            jSONObject2.put("screen_width", this.djd.screenWidth);
            jSONObject2.put("mac", this.djd.mac);
            jSONObject.put(Config.DEVICE_PART, jSONObject2);
            jSONObject3.put("coord_type", this.dje.coordType);
            jSONObject3.put("latitude", this.dje.latitude);
            jSONObject3.put("longitude", this.dje.longitude);
            jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
            jSONObject4.put("network", this.djf.network);
            jSONObject4.put("operator", this.djf.djm);
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
