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
    public C0417a cTa;
    public c cTb;
    public b cTc;
    public JSONObject data;

    /* renamed from: com.baidu.swan.bdprivate.d.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0417a {
        public int aDv;
        public String cTd;
        public String cTe;
        public int cTf;
        public String cTg;
        public String cTh;
        public int cTi;
        public String cTj;
        public int screenWidth;
    }

    /* loaded from: classes11.dex */
    public static class b {
        public int cTk;
        public int network;
    }

    /* loaded from: classes11.dex */
    public static class c {
        public int coordType;
        public double latitude;
        public double longitude;
    }

    public a(@NonNull Context context, @NonNull JSONObject jSONObject) {
        C0417a c0417a = new C0417a();
        c cVar = new c();
        b bVar = new b();
        String apO = e.apO();
        this.appId = TextUtils.isEmpty(apO) ? "" : apO;
        this.cTa = c0417a;
        this.cTb = cVar;
        this.cTc = bVar;
        this.data = jSONObject;
        String auX = aj.auX();
        c0417a.cTd = "0".equals(auX) ? "" : auX;
        String androidId = getAndroidId();
        c0417a.cTe = "0".equals(androidId) ? "" : androidId;
        c0417a.cTf = 2;
        c0417a.aDv = com.baidu.swan.bdprivate.d.f.c.a.dc(context) ? 3 : 2;
        String WP = com.baidu.swan.apps.h.c.WP();
        c0417a.cTg = "NUL".equals(WP) ? "" : WP;
        String deviceModel = com.baidu.swan.apps.h.c.getDeviceModel();
        c0417a.cTh = "NUL".equals(deviceModel) ? "" : deviceModel;
        c0417a.cTi = ag.getDisplayHeight(context);
        c0417a.screenWidth = ag.getDisplayWidth(context);
        String wifiInfo = getWifiInfo();
        c0417a.cTj = (TextUtils.isEmpty(wifiInfo) || Config.DEF_MAC_ID.equals(wifiInfo)) ? "" : "";
        bVar.network = com.baidu.swan.bdprivate.d.f.c.a.avW();
        bVar.cTk = com.baidu.swan.bdprivate.d.f.c.a.dd(context);
    }

    @NonNull
    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.put("app_id", this.appId);
            jSONObject2.put("deviceid", this.cTa.cTd);
            jSONObject2.put("androidid", this.cTa.cTe);
            jSONObject2.put(HttpConstants.HTTP_OS_TYPE, this.cTa.cTf);
            jSONObject2.put(HttpConstants.DEVICE_TYPE, this.cTa.aDv);
            jSONObject2.put("device_vendor", this.cTa.cTg);
            jSONObject2.put("device_model", this.cTa.cTh);
            jSONObject2.put("screen_height", this.cTa.cTi);
            jSONObject2.put("screen_width", this.cTa.screenWidth);
            jSONObject2.put("mac", this.cTa.cTj);
            jSONObject.put(Config.DEVICE_PART, jSONObject2);
            jSONObject3.put("coord_type", this.cTb.coordType);
            jSONObject3.put("latitude", this.cTb.latitude);
            jSONObject3.put("longitude", this.cTb.longitude);
            jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
            jSONObject4.put("network", this.cTc.network);
            jSONObject4.put("operator", this.cTc.cTk);
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
