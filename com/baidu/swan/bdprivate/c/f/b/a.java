package com.baidu.swan.bdprivate.c.f.b;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.runtime.e;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public String appId;
    public C0308a bYU;
    public c bYV;
    public b bYW;
    public JSONObject data;

    /* renamed from: com.baidu.swan.bdprivate.c.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0308a {
        public int aba;
        public String bYX;
        public String bYY;
        public int bYZ;
        public String bZa;
        public String bZb;
        public int bZc;
        public String bZd;
        public int screenWidth;
    }

    /* loaded from: classes9.dex */
    public static class b {
        public int bZe;
        public int network;
    }

    /* loaded from: classes9.dex */
    public static class c {
        public int coordType;
        public double latitude;
        public double longitude;
    }

    public a(@NonNull Context context, @NonNull JSONObject jSONObject) {
        C0308a c0308a = new C0308a();
        c cVar = new c();
        b bVar = new b();
        String ZU = e.ZU();
        this.appId = TextUtils.isEmpty(ZU) ? "" : ZU;
        this.bYU = c0308a;
        this.bYV = cVar;
        this.bYW = bVar;
        this.data = jSONObject;
        String aey = ai.aey();
        c0308a.bYX = "0".equals(aey) ? "" : aey;
        String androidId = getAndroidId();
        c0308a.bYY = "0".equals(androidId) ? "" : androidId;
        c0308a.bYZ = 2;
        c0308a.aba = com.baidu.swan.bdprivate.c.f.c.a.di(context) ? 3 : 2;
        String Iz = com.baidu.swan.apps.h.c.Iz();
        c0308a.bZa = "NUL".equals(Iz) ? "" : Iz;
        String deviceModel = com.baidu.swan.apps.h.c.getDeviceModel();
        c0308a.bZb = "NUL".equals(deviceModel) ? "" : deviceModel;
        c0308a.bZc = af.getDisplayHeight(context);
        c0308a.screenWidth = af.getDisplayWidth(context);
        String wifiInfo = getWifiInfo();
        c0308a.bZd = (TextUtils.isEmpty(wifiInfo) || Config.DEF_MAC_ID.equals(wifiInfo)) ? "" : "";
        bVar.network = com.baidu.swan.bdprivate.c.f.c.a.afQ();
        bVar.bZe = com.baidu.swan.bdprivate.c.f.c.a.dj(context);
    }

    @NonNull
    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.put(Constants.APP_ID, this.appId);
            jSONObject2.put("deviceid", this.bYU.bYX);
            jSONObject2.put("androidid", this.bYU.bYY);
            jSONObject2.put("os_type", this.bYU.bYZ);
            jSONObject2.put("device_type", this.bYU.aba);
            jSONObject2.put("device_vendor", this.bYU.bZa);
            jSONObject2.put("device_model", this.bYU.bZb);
            jSONObject2.put("screen_height", this.bYU.bZc);
            jSONObject2.put("screen_width", this.bYU.screenWidth);
            jSONObject2.put("mac", this.bYU.bZd);
            jSONObject.put(Config.DEVICE_PART, jSONObject2);
            jSONObject3.put("coord_type", this.bYV.coordType);
            jSONObject3.put("latitude", this.bYV.latitude);
            jSONObject3.put("longitude", this.bYV.longitude);
            jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
            jSONObject4.put("network", this.bYW.network);
            jSONObject4.put("operator", this.bYW.bZe);
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
