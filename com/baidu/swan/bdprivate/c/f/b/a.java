package com.baidu.swan.bdprivate.c.f.b;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public String appId;
    public C0350a cCx;
    public c cCy;
    public b cCz;
    public JSONObject data;

    /* renamed from: com.baidu.swan.bdprivate.c.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0350a {
        public int avV;
        public String cCA;
        public String cCB;
        public int cCC;
        public String cCD;
        public String cCE;
        public int cCF;
        public String cCG;
        public int screenWidth;
    }

    /* loaded from: classes11.dex */
    public static class b {
        public int cCH;
        public int network;
    }

    /* loaded from: classes11.dex */
    public static class c {
        public int coordType;
        public double latitude;
        public double longitude;
    }

    public a(@NonNull Context context, @NonNull JSONObject jSONObject) {
        C0350a c0350a = new C0350a();
        c cVar = new c();
        b bVar = new b();
        String akP = e.akP();
        this.appId = TextUtils.isEmpty(akP) ? "" : akP;
        this.cCx = c0350a;
        this.cCy = cVar;
        this.cCz = bVar;
        this.data = jSONObject;
        String aps = ai.aps();
        c0350a.cCA = "0".equals(aps) ? "" : aps;
        String androidId = getAndroidId();
        c0350a.cCB = "0".equals(androidId) ? "" : androidId;
        c0350a.cCC = 2;
        c0350a.avV = com.baidu.swan.bdprivate.c.f.c.a.cZ(context) ? 3 : 2;
        String Td = com.baidu.swan.apps.h.c.Td();
        c0350a.cCD = "NUL".equals(Td) ? "" : Td;
        String deviceModel = com.baidu.swan.apps.h.c.getDeviceModel();
        c0350a.cCE = "NUL".equals(deviceModel) ? "" : deviceModel;
        c0350a.cCF = af.getDisplayHeight(context);
        c0350a.screenWidth = af.getDisplayWidth(context);
        String wifiInfo = getWifiInfo();
        c0350a.cCG = (TextUtils.isEmpty(wifiInfo) || Config.DEF_MAC_ID.equals(wifiInfo)) ? "" : "";
        bVar.network = com.baidu.swan.bdprivate.c.f.c.a.aqK();
        bVar.cCH = com.baidu.swan.bdprivate.c.f.c.a.da(context);
    }

    @NonNull
    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.put("app_id", this.appId);
            jSONObject2.put("deviceid", this.cCx.cCA);
            jSONObject2.put("androidid", this.cCx.cCB);
            jSONObject2.put(HttpConstants.HTTP_OS_TYPE, this.cCx.cCC);
            jSONObject2.put(HttpConstants.DEVICE_TYPE, this.cCx.avV);
            jSONObject2.put("device_vendor", this.cCx.cCD);
            jSONObject2.put("device_model", this.cCx.cCE);
            jSONObject2.put("screen_height", this.cCx.cCF);
            jSONObject2.put("screen_width", this.cCx.screenWidth);
            jSONObject2.put("mac", this.cCx.cCG);
            jSONObject.put(Config.DEVICE_PART, jSONObject2);
            jSONObject3.put("coord_type", this.cCy.coordType);
            jSONObject3.put("latitude", this.cCy.latitude);
            jSONObject3.put("longitude", this.cCy.longitude);
            jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
            jSONObject4.put("network", this.cCz.network);
            jSONObject4.put("operator", this.cCz.cCH);
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
