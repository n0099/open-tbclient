package com.baidu.swan.bdprivate.d.f.b;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public String appId;
    public C0411a cOq;
    public c cOr;
    public b cOs;
    public JSONObject data;

    /* renamed from: com.baidu.swan.bdprivate.d.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0411a {
        public int aBk;
        public String cOt;
        public String cOu;
        public int cOv;
        public String cOw;
        public String cOx;
        public int cOy;
        public String cOz;
        public int screenWidth;
    }

    /* loaded from: classes11.dex */
    public static class b {
        public int cOA;
        public int network;
    }

    /* loaded from: classes11.dex */
    public static class c {
        public int coordType;
        public double latitude;
        public double longitude;
    }

    public a(@NonNull Context context, @NonNull JSONObject jSONObject) {
        C0411a c0411a = new C0411a();
        c cVar = new c();
        b bVar = new b();
        String aoH = e.aoH();
        this.appId = TextUtils.isEmpty(aoH) ? "" : aoH;
        this.cOq = c0411a;
        this.cOr = cVar;
        this.cOs = bVar;
        this.data = jSONObject;
        String atR = aj.atR();
        c0411a.cOt = "0".equals(atR) ? "" : atR;
        String androidId = getAndroidId();
        c0411a.cOu = "0".equals(androidId) ? "" : androidId;
        c0411a.cOv = 2;
        c0411a.aBk = com.baidu.swan.bdprivate.d.f.c.a.db(context) ? 3 : 2;
        String VJ = com.baidu.swan.apps.h.c.VJ();
        c0411a.cOw = "NUL".equals(VJ) ? "" : VJ;
        String deviceModel = com.baidu.swan.apps.h.c.getDeviceModel();
        c0411a.cOx = "NUL".equals(deviceModel) ? "" : deviceModel;
        c0411a.cOy = ag.getDisplayHeight(context);
        c0411a.screenWidth = ag.getDisplayWidth(context);
        String wifiInfo = getWifiInfo();
        c0411a.cOz = (TextUtils.isEmpty(wifiInfo) || Config.DEF_MAC_ID.equals(wifiInfo)) ? "" : "";
        bVar.network = com.baidu.swan.bdprivate.d.f.c.a.auQ();
        bVar.cOA = com.baidu.swan.bdprivate.d.f.c.a.dc(context);
    }

    @NonNull
    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.put("app_id", this.appId);
            jSONObject2.put("deviceid", this.cOq.cOt);
            jSONObject2.put("androidid", this.cOq.cOu);
            jSONObject2.put(HttpConstants.HTTP_OS_TYPE, this.cOq.cOv);
            jSONObject2.put(HttpConstants.DEVICE_TYPE, this.cOq.aBk);
            jSONObject2.put("device_vendor", this.cOq.cOw);
            jSONObject2.put("device_model", this.cOq.cOx);
            jSONObject2.put("screen_height", this.cOq.cOy);
            jSONObject2.put("screen_width", this.cOq.screenWidth);
            jSONObject2.put("mac", this.cOq.cOz);
            jSONObject.put(Config.DEVICE_PART, jSONObject2);
            jSONObject3.put("coord_type", this.cOr.coordType);
            jSONObject3.put("latitude", this.cOr.latitude);
            jSONObject3.put("longitude", this.cOr.longitude);
            jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
            jSONObject4.put("network", this.cOs.network);
            jSONObject4.put("operator", this.cOs.cOA);
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
