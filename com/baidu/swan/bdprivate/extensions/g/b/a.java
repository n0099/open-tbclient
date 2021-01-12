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
    public C0494a dSV;
    public c dSW;
    public b dSX;
    public JSONObject data;

    /* renamed from: com.baidu.swan.bdprivate.extensions.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0494a {
        public int aNA;
        public String dSY;
        public String dSZ;
        public int dTa;
        public String dTb;
        public int dTc;
        public String deviceModel;
        public String mac;
        public int screenWidth;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public int dTd;
        public int network;
    }

    /* loaded from: classes8.dex */
    public static class c {
        public int coordType;
        public double latitude;
        public double longitude;
    }

    public a(@NonNull Context context, @NonNull JSONObject jSONObject) {
        C0494a c0494a = new C0494a();
        c cVar = new c();
        b bVar = new b();
        String aIt = e.aIt();
        this.appId = TextUtils.isEmpty(aIt) ? "" : aIt;
        this.dSV = c0494a;
        this.dSW = cVar;
        this.dSX = bVar;
        this.data = jSONObject;
        String aNV = ak.aNV();
        c0494a.dSY = "0".equals(aNV) ? "" : aNV;
        String androidId = getAndroidId();
        c0494a.dSZ = "0".equals(androidId) ? "" : androidId;
        c0494a.dTa = 2;
        c0494a.aNA = com.baidu.swan.bdprivate.extensions.g.c.a.eq(context) ? 3 : 2;
        String ali = com.baidu.swan.apps.i.c.ali();
        c0494a.dTb = "NUL".equals(ali) ? "" : ali;
        String deviceModel = com.baidu.swan.apps.i.c.getDeviceModel();
        c0494a.deviceModel = "NUL".equals(deviceModel) ? "" : deviceModel;
        c0494a.dTc = ah.getDisplayHeight(context);
        c0494a.screenWidth = ah.getDisplayWidth(context);
        String wifiInfo = getWifiInfo();
        c0494a.mac = (TextUtils.isEmpty(wifiInfo) || Config.DEF_MAC_ID.equals(wifiInfo)) ? "" : "";
        bVar.network = com.baidu.swan.bdprivate.extensions.g.c.a.aPF();
        bVar.dTd = com.baidu.swan.bdprivate.extensions.g.c.a.er(context);
    }

    @NonNull
    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.put("app_id", this.appId);
            jSONObject2.put("deviceid", this.dSV.dSY);
            jSONObject2.put("androidid", this.dSV.dSZ);
            jSONObject2.put(HttpConstants.HTTP_OS_TYPE, this.dSV.dTa);
            jSONObject2.put(HttpConstants.DEVICE_TYPE, this.dSV.aNA);
            jSONObject2.put("device_vendor", this.dSV.dTb);
            jSONObject2.put("device_model", this.dSV.deviceModel);
            jSONObject2.put("screen_height", this.dSV.dTc);
            jSONObject2.put("screen_width", this.dSV.screenWidth);
            jSONObject2.put("mac", this.dSV.mac);
            jSONObject.put(Config.DEVICE_PART, jSONObject2);
            jSONObject3.put("coord_type", this.dSW.coordType);
            jSONObject3.put("latitude", this.dSW.latitude);
            jSONObject3.put("longitude", this.dSW.longitude);
            jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
            jSONObject4.put("network", this.dSX.network);
            jSONObject4.put("operator", this.dSX.dTd);
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
