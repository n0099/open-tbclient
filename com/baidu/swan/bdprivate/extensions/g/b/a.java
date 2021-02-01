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
    public C0491a dVb;
    public c dVc;
    public b dVd;
    public JSONObject data;

    /* renamed from: com.baidu.swan.bdprivate.extensions.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0491a {
        public int aQB;
        public String dVe;
        public String dVf;
        public int dVg;
        public String dVh;
        public int dVi;
        public String deviceModel;
        public String mac;
        public int screenWidth;
    }

    /* loaded from: classes9.dex */
    public static class b {
        public int dVj;
        public int network;
    }

    /* loaded from: classes9.dex */
    public static class c {
        public int coordType;
        public double latitude;
        public double longitude;
    }

    public a(@NonNull Context context, @NonNull JSONObject jSONObject) {
        C0491a c0491a = new C0491a();
        c cVar = new c();
        b bVar = new b();
        String aIM = e.aIM();
        this.appId = TextUtils.isEmpty(aIM) ? "" : aIM;
        this.dVb = c0491a;
        this.dVc = cVar;
        this.dVd = bVar;
        this.data = jSONObject;
        String aOo = ak.aOo();
        c0491a.dVe = "0".equals(aOo) ? "" : aOo;
        String androidId = getAndroidId();
        c0491a.dVf = "0".equals(androidId) ? "" : androidId;
        c0491a.dVg = 2;
        c0491a.aQB = com.baidu.swan.bdprivate.extensions.g.c.a.ep(context) ? 3 : 2;
        String alG = com.baidu.swan.apps.i.c.alG();
        c0491a.dVh = "NUL".equals(alG) ? "" : alG;
        String deviceModel = com.baidu.swan.apps.i.c.getDeviceModel();
        c0491a.deviceModel = "NUL".equals(deviceModel) ? "" : deviceModel;
        c0491a.dVi = ah.getDisplayHeight(context);
        c0491a.screenWidth = ah.getDisplayWidth(context);
        String wifiInfo = getWifiInfo();
        c0491a.mac = (TextUtils.isEmpty(wifiInfo) || Config.DEF_MAC_ID.equals(wifiInfo)) ? "" : "";
        bVar.network = com.baidu.swan.bdprivate.extensions.g.c.a.aPY();
        bVar.dVj = com.baidu.swan.bdprivate.extensions.g.c.a.eq(context);
    }

    @NonNull
    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.put("app_id", this.appId);
            jSONObject2.put("deviceid", this.dVb.dVe);
            jSONObject2.put("androidid", this.dVb.dVf);
            jSONObject2.put(HttpConstants.HTTP_OS_TYPE, this.dVb.dVg);
            jSONObject2.put(HttpConstants.DEVICE_TYPE, this.dVb.aQB);
            jSONObject2.put("device_vendor", this.dVb.dVh);
            jSONObject2.put("device_model", this.dVb.deviceModel);
            jSONObject2.put("screen_height", this.dVb.dVi);
            jSONObject2.put("screen_width", this.dVb.screenWidth);
            jSONObject2.put("mac", this.dVb.mac);
            jSONObject.put(Config.DEVICE_PART, jSONObject2);
            jSONObject3.put("coord_type", this.dVc.coordType);
            jSONObject3.put("latitude", this.dVc.latitude);
            jSONObject3.put("longitude", this.dVc.longitude);
            jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
            jSONObject4.put("network", this.dVd.network);
            jSONObject4.put("operator", this.dVd.dVj);
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
