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
/* loaded from: classes10.dex */
public class a {
    public String appId;
    public C0310a bZg;
    public c bZh;
    public b bZi;
    public JSONObject data;

    /* renamed from: com.baidu.swan.bdprivate.c.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0310a {
        public int abo;
        public String bZj;
        public String bZk;
        public int bZl;
        public String bZm;
        public String bZn;
        public int bZo;
        public String bZp;
        public int screenWidth;
    }

    /* loaded from: classes10.dex */
    public static class b {
        public int bZq;
        public int network;
    }

    /* loaded from: classes10.dex */
    public static class c {
        public int coordType;
        public double latitude;
        public double longitude;
    }

    public a(@NonNull Context context, @NonNull JSONObject jSONObject) {
        C0310a c0310a = new C0310a();
        c cVar = new c();
        b bVar = new b();
        String aar = e.aar();
        this.appId = TextUtils.isEmpty(aar) ? "" : aar;
        this.bZg = c0310a;
        this.bZh = cVar;
        this.bZi = bVar;
        this.data = jSONObject;
        String aeR = ai.aeR();
        c0310a.bZj = "0".equals(aeR) ? "" : aeR;
        String androidId = getAndroidId();
        c0310a.bZk = "0".equals(androidId) ? "" : androidId;
        c0310a.bZl = 2;
        c0310a.abo = com.baidu.swan.bdprivate.c.f.c.a.di(context) ? 3 : 2;
        String IV = com.baidu.swan.apps.h.c.IV();
        c0310a.bZm = "NUL".equals(IV) ? "" : IV;
        String deviceModel = com.baidu.swan.apps.h.c.getDeviceModel();
        c0310a.bZn = "NUL".equals(deviceModel) ? "" : deviceModel;
        c0310a.bZo = af.getDisplayHeight(context);
        c0310a.screenWidth = af.getDisplayWidth(context);
        String wifiInfo = getWifiInfo();
        c0310a.bZp = (TextUtils.isEmpty(wifiInfo) || Config.DEF_MAC_ID.equals(wifiInfo)) ? "" : "";
        bVar.network = com.baidu.swan.bdprivate.c.f.c.a.agj();
        bVar.bZq = com.baidu.swan.bdprivate.c.f.c.a.dj(context);
    }

    @NonNull
    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.put(Constants.APP_ID, this.appId);
            jSONObject2.put("deviceid", this.bZg.bZj);
            jSONObject2.put("androidid", this.bZg.bZk);
            jSONObject2.put("os_type", this.bZg.bZl);
            jSONObject2.put("device_type", this.bZg.abo);
            jSONObject2.put("device_vendor", this.bZg.bZm);
            jSONObject2.put("device_model", this.bZg.bZn);
            jSONObject2.put("screen_height", this.bZg.bZo);
            jSONObject2.put("screen_width", this.bZg.screenWidth);
            jSONObject2.put("mac", this.bZg.bZp);
            jSONObject.put(Config.DEVICE_PART, jSONObject2);
            jSONObject3.put("coord_type", this.bZh.coordType);
            jSONObject3.put("latitude", this.bZh.latitude);
            jSONObject3.put("longitude", this.bZh.longitude);
            jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
            jSONObject4.put("network", this.bZi.network);
            jSONObject4.put("operator", this.bZi.bZq);
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
