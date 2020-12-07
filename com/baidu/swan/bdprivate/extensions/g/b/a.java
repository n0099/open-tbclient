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
/* loaded from: classes25.dex */
public class a {
    public String appId;
    public C0518a dOO;
    public c dOP;
    public b dOQ;
    public JSONObject data;

    /* renamed from: com.baidu.swan.bdprivate.extensions.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C0518a {
        public int aRy;
        public String dOR;
        public String dOS;
        public int dOT;
        public String dOU;
        public String dOV;
        public int dOW;
        public String mac;
        public int screenWidth;
    }

    /* loaded from: classes25.dex */
    public static class b {
        public int dOX;
        public int network;
    }

    /* loaded from: classes25.dex */
    public static class c {
        public int coordType;
        public double latitude;
        public double longitude;
    }

    public a(@NonNull Context context, @NonNull JSONObject jSONObject) {
        C0518a c0518a = new C0518a();
        c cVar = new c();
        b bVar = new b();
        String aJW = e.aJW();
        this.appId = TextUtils.isEmpty(aJW) ? "" : aJW;
        this.dOO = c0518a;
        this.dOP = cVar;
        this.dOQ = bVar;
        this.data = jSONObject;
        String aPx = ak.aPx();
        c0518a.dOR = "0".equals(aPx) ? "" : aPx;
        String androidId = getAndroidId();
        c0518a.dOS = "0".equals(androidId) ? "" : androidId;
        c0518a.dOT = 2;
        c0518a.aRy = com.baidu.swan.bdprivate.extensions.g.c.a.dY(context) ? 3 : 2;
        String anQ = com.baidu.swan.apps.i.c.anQ();
        c0518a.dOU = "NUL".equals(anQ) ? "" : anQ;
        String deviceModel = com.baidu.swan.apps.i.c.getDeviceModel();
        c0518a.dOV = "NUL".equals(deviceModel) ? "" : deviceModel;
        c0518a.dOW = ah.getDisplayHeight(context);
        c0518a.screenWidth = ah.getDisplayWidth(context);
        String wifiInfo = getWifiInfo();
        c0518a.mac = (TextUtils.isEmpty(wifiInfo) || Config.DEF_MAC_ID.equals(wifiInfo)) ? "" : "";
        bVar.network = com.baidu.swan.bdprivate.extensions.g.c.a.aRd();
        bVar.dOX = com.baidu.swan.bdprivate.extensions.g.c.a.dZ(context);
    }

    @NonNull
    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.put("app_id", this.appId);
            jSONObject2.put("deviceid", this.dOO.dOR);
            jSONObject2.put("androidid", this.dOO.dOS);
            jSONObject2.put(HttpConstants.HTTP_OS_TYPE, this.dOO.dOT);
            jSONObject2.put(HttpConstants.DEVICE_TYPE, this.dOO.aRy);
            jSONObject2.put("device_vendor", this.dOO.dOU);
            jSONObject2.put("device_model", this.dOO.dOV);
            jSONObject2.put("screen_height", this.dOO.dOW);
            jSONObject2.put("screen_width", this.dOO.screenWidth);
            jSONObject2.put("mac", this.dOO.mac);
            jSONObject.put(Config.DEVICE_PART, jSONObject2);
            jSONObject3.put("coord_type", this.dOP.coordType);
            jSONObject3.put("latitude", this.dOP.latitude);
            jSONObject3.put("longitude", this.dOP.longitude);
            jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
            jSONObject4.put("network", this.dOQ.network);
            jSONObject4.put("operator", this.dOQ.dOX);
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
