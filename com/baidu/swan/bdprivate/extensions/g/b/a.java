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
    public C0470a dha;
    public c dhb;
    public b dhc;

    /* renamed from: com.baidu.swan.bdprivate.extensions.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0470a {
        public int aKb;
        public String dhd;
        public String dhe;
        public int dhf;
        public String dhg;
        public String dhh;
        public int dhi;
        public String mac;
        public int screenWidth;
    }

    /* loaded from: classes3.dex */
    public static class b {
        public int dhj;
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
        this.dha = c0470a;
        this.dhb = cVar;
        this.dhc = bVar;
        this.data = jSONObject;
        String aFm = ak.aFm();
        c0470a.dhd = "0".equals(aFm) ? "" : aFm;
        String androidId = getAndroidId();
        c0470a.dhe = "0".equals(androidId) ? "" : androidId;
        c0470a.dhf = 2;
        c0470a.aKb = com.baidu.swan.bdprivate.extensions.g.c.a.dn(context) ? 3 : 2;
        String adB = com.baidu.swan.apps.i.c.adB();
        c0470a.dhg = "NUL".equals(adB) ? "" : adB;
        String deviceModel = com.baidu.swan.apps.i.c.getDeviceModel();
        c0470a.dhh = "NUL".equals(deviceModel) ? "" : deviceModel;
        c0470a.dhi = ah.getDisplayHeight(context);
        c0470a.screenWidth = ah.getDisplayWidth(context);
        String wifiInfo = getWifiInfo();
        c0470a.mac = (TextUtils.isEmpty(wifiInfo) || Config.DEF_MAC_ID.equals(wifiInfo)) ? "" : "";
        bVar.network = com.baidu.swan.bdprivate.extensions.g.c.a.aGT();
        bVar.dhj = com.baidu.swan.bdprivate.extensions.g.c.a.m35do(context);
    }

    @NonNull
    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.put("app_id", this.appId);
            jSONObject2.put("deviceid", this.dha.dhd);
            jSONObject2.put("androidid", this.dha.dhe);
            jSONObject2.put(HttpConstants.HTTP_OS_TYPE, this.dha.dhf);
            jSONObject2.put(HttpConstants.DEVICE_TYPE, this.dha.aKb);
            jSONObject2.put("device_vendor", this.dha.dhg);
            jSONObject2.put("device_model", this.dha.dhh);
            jSONObject2.put("screen_height", this.dha.dhi);
            jSONObject2.put("screen_width", this.dha.screenWidth);
            jSONObject2.put("mac", this.dha.mac);
            jSONObject.put(Config.DEVICE_PART, jSONObject2);
            jSONObject3.put("coord_type", this.dhb.coordType);
            jSONObject3.put("latitude", this.dhb.latitude);
            jSONObject3.put("longitude", this.dhb.longitude);
            jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
            jSONObject4.put("network", this.dhc.network);
            jSONObject4.put("operator", this.dhc.dhj);
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
