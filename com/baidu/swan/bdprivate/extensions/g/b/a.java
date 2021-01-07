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
/* loaded from: classes9.dex */
public class a {
    public String appId;
    public C0511a dXH;
    public c dXI;
    public b dXJ;
    public JSONObject data;

    /* renamed from: com.baidu.swan.bdprivate.extensions.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0511a {
        public int aSn;
        public String dXK;
        public String dXL;
        public int dXM;
        public String dXN;
        public int dXO;
        public String deviceModel;
        public String mac;
        public int screenWidth;
    }

    /* loaded from: classes9.dex */
    public static class b {
        public int dXP;
        public int network;
    }

    /* loaded from: classes9.dex */
    public static class c {
        public int coordType;
        public double latitude;
        public double longitude;
    }

    public a(@NonNull Context context, @NonNull JSONObject jSONObject) {
        C0511a c0511a = new C0511a();
        c cVar = new c();
        b bVar = new b();
        String aMn = e.aMn();
        this.appId = TextUtils.isEmpty(aMn) ? "" : aMn;
        this.dXH = c0511a;
        this.dXI = cVar;
        this.dXJ = bVar;
        this.data = jSONObject;
        String aRP = ak.aRP();
        c0511a.dXK = "0".equals(aRP) ? "" : aRP;
        String androidId = getAndroidId();
        c0511a.dXL = "0".equals(androidId) ? "" : androidId;
        c0511a.dXM = 2;
        c0511a.aSn = com.baidu.swan.bdprivate.extensions.g.c.a.er(context) ? 3 : 2;
        String apc = com.baidu.swan.apps.i.c.apc();
        c0511a.dXN = "NUL".equals(apc) ? "" : apc;
        String deviceModel = com.baidu.swan.apps.i.c.getDeviceModel();
        c0511a.deviceModel = "NUL".equals(deviceModel) ? "" : deviceModel;
        c0511a.dXO = ah.getDisplayHeight(context);
        c0511a.screenWidth = ah.getDisplayWidth(context);
        String wifiInfo = getWifiInfo();
        c0511a.mac = (TextUtils.isEmpty(wifiInfo) || Config.DEF_MAC_ID.equals(wifiInfo)) ? "" : "";
        bVar.network = com.baidu.swan.bdprivate.extensions.g.c.a.aTz();
        bVar.dXP = com.baidu.swan.bdprivate.extensions.g.c.a.es(context);
    }

    @NonNull
    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.put("app_id", this.appId);
            jSONObject2.put("deviceid", this.dXH.dXK);
            jSONObject2.put("androidid", this.dXH.dXL);
            jSONObject2.put(HttpConstants.HTTP_OS_TYPE, this.dXH.dXM);
            jSONObject2.put(HttpConstants.DEVICE_TYPE, this.dXH.aSn);
            jSONObject2.put("device_vendor", this.dXH.dXN);
            jSONObject2.put("device_model", this.dXH.deviceModel);
            jSONObject2.put("screen_height", this.dXH.dXO);
            jSONObject2.put("screen_width", this.dXH.screenWidth);
            jSONObject2.put("mac", this.dXH.mac);
            jSONObject.put(Config.DEVICE_PART, jSONObject2);
            jSONObject3.put("coord_type", this.dXI.coordType);
            jSONObject3.put("latitude", this.dXI.latitude);
            jSONObject3.put("longitude", this.dXI.longitude);
            jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
            jSONObject4.put("network", this.dXJ.network);
            jSONObject4.put("operator", this.dXJ.dXP);
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
