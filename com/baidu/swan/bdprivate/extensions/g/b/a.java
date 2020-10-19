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
    public JSONObject data;
    public C0482a dvj;
    public c dvk;
    public b dvl;

    /* renamed from: com.baidu.swan.bdprivate.extensions.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0482a {
        public int aOH;
        public String dvm;
        public String dvn;
        public int dvo;
        public String dvp;
        public String dvq;
        public int dvr;
        public String mac;
        public int screenWidth;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public int dvs;
        public int network;
    }

    /* loaded from: classes8.dex */
    public static class c {
        public int coordType;
        public double latitude;
        public double longitude;
    }

    public a(@NonNull Context context, @NonNull JSONObject jSONObject) {
        C0482a c0482a = new C0482a();
        c cVar = new c();
        b bVar = new b();
        String aDc = e.aDc();
        this.appId = TextUtils.isEmpty(aDc) ? "" : aDc;
        this.dvj = c0482a;
        this.dvk = cVar;
        this.dvl = bVar;
        this.data = jSONObject;
        String aIF = ak.aIF();
        c0482a.dvm = "0".equals(aIF) ? "" : aIF;
        String androidId = getAndroidId();
        c0482a.dvn = "0".equals(androidId) ? "" : androidId;
        c0482a.dvo = 2;
        c0482a.aOH = com.baidu.swan.bdprivate.extensions.g.c.a.ds(context) ? 3 : 2;
        String agW = com.baidu.swan.apps.i.c.agW();
        c0482a.dvp = "NUL".equals(agW) ? "" : agW;
        String deviceModel = com.baidu.swan.apps.i.c.getDeviceModel();
        c0482a.dvq = "NUL".equals(deviceModel) ? "" : deviceModel;
        c0482a.dvr = ah.getDisplayHeight(context);
        c0482a.screenWidth = ah.getDisplayWidth(context);
        String wifiInfo = getWifiInfo();
        c0482a.mac = (TextUtils.isEmpty(wifiInfo) || Config.DEF_MAC_ID.equals(wifiInfo)) ? "" : "";
        bVar.network = com.baidu.swan.bdprivate.extensions.g.c.a.aKm();
        bVar.dvs = com.baidu.swan.bdprivate.extensions.g.c.a.dt(context);
    }

    @NonNull
    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.put("app_id", this.appId);
            jSONObject2.put("deviceid", this.dvj.dvm);
            jSONObject2.put("androidid", this.dvj.dvn);
            jSONObject2.put(HttpConstants.HTTP_OS_TYPE, this.dvj.dvo);
            jSONObject2.put(HttpConstants.DEVICE_TYPE, this.dvj.aOH);
            jSONObject2.put("device_vendor", this.dvj.dvp);
            jSONObject2.put("device_model", this.dvj.dvq);
            jSONObject2.put("screen_height", this.dvj.dvr);
            jSONObject2.put("screen_width", this.dvj.screenWidth);
            jSONObject2.put("mac", this.dvj.mac);
            jSONObject.put(Config.DEVICE_PART, jSONObject2);
            jSONObject3.put("coord_type", this.dvk.coordType);
            jSONObject3.put("latitude", this.dvk.latitude);
            jSONObject3.put("longitude", this.dvk.longitude);
            jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
            jSONObject4.put("network", this.dvl.network);
            jSONObject4.put("operator", this.dvl.dvs);
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
