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
    public C0496a dDG;
    public c dDH;
    public b dDI;
    public JSONObject data;

    /* renamed from: com.baidu.swan.bdprivate.extensions.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0496a {
        public int aPm;
        public String dDJ;
        public String dDK;
        public int dDL;
        public String dDM;
        public String dDN;
        public int dDO;
        public String mac;
        public int screenWidth;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public int dDP;
        public int network;
    }

    /* loaded from: classes8.dex */
    public static class c {
        public int coordType;
        public double latitude;
        public double longitude;
    }

    public a(@NonNull Context context, @NonNull JSONObject jSONObject) {
        C0496a c0496a = new C0496a();
        c cVar = new c();
        b bVar = new b();
        String aEW = e.aEW();
        this.appId = TextUtils.isEmpty(aEW) ? "" : aEW;
        this.dDG = c0496a;
        this.dDH = cVar;
        this.dDI = bVar;
        this.data = jSONObject;
        String aKz = ak.aKz();
        c0496a.dDJ = "0".equals(aKz) ? "" : aKz;
        String androidId = getAndroidId();
        c0496a.dDK = "0".equals(androidId) ? "" : androidId;
        c0496a.dDL = 2;
        c0496a.aPm = com.baidu.swan.bdprivate.extensions.g.c.a.ds(context) ? 3 : 2;
        String aiQ = com.baidu.swan.apps.i.c.aiQ();
        c0496a.dDM = "NUL".equals(aiQ) ? "" : aiQ;
        String deviceModel = com.baidu.swan.apps.i.c.getDeviceModel();
        c0496a.dDN = "NUL".equals(deviceModel) ? "" : deviceModel;
        c0496a.dDO = ah.getDisplayHeight(context);
        c0496a.screenWidth = ah.getDisplayWidth(context);
        String wifiInfo = getWifiInfo();
        c0496a.mac = (TextUtils.isEmpty(wifiInfo) || Config.DEF_MAC_ID.equals(wifiInfo)) ? "" : "";
        bVar.network = com.baidu.swan.bdprivate.extensions.g.c.a.aMg();
        bVar.dDP = com.baidu.swan.bdprivate.extensions.g.c.a.dt(context);
    }

    @NonNull
    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.put("app_id", this.appId);
            jSONObject2.put("deviceid", this.dDG.dDJ);
            jSONObject2.put("androidid", this.dDG.dDK);
            jSONObject2.put(HttpConstants.HTTP_OS_TYPE, this.dDG.dDL);
            jSONObject2.put(HttpConstants.DEVICE_TYPE, this.dDG.aPm);
            jSONObject2.put("device_vendor", this.dDG.dDM);
            jSONObject2.put("device_model", this.dDG.dDN);
            jSONObject2.put("screen_height", this.dDG.dDO);
            jSONObject2.put("screen_width", this.dDG.screenWidth);
            jSONObject2.put("mac", this.dDG.mac);
            jSONObject.put(Config.DEVICE_PART, jSONObject2);
            jSONObject3.put("coord_type", this.dDH.coordType);
            jSONObject3.put("latitude", this.dDH.latitude);
            jSONObject3.put("longitude", this.dDH.longitude);
            jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
            jSONObject4.put("network", this.dDI.network);
            jSONObject4.put("operator", this.dDI.dDP);
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
