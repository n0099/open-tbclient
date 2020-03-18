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
/* loaded from: classes11.dex */
public class a {
    public String appId;
    public c cdA;
    public b cdB;
    public C0320a cdz;
    public JSONObject data;

    /* renamed from: com.baidu.swan.bdprivate.c.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0320a {
        public int adE;
        public String cdC;
        public String cdD;
        public int cdE;
        public String cdF;
        public String cdG;
        public int cdH;
        public String cdI;
        public int screenWidth;
    }

    /* loaded from: classes11.dex */
    public static class b {
        public int cdJ;
        public int network;
    }

    /* loaded from: classes11.dex */
    public static class c {
        public int coordType;
        public double latitude;
        public double longitude;
    }

    public a(@NonNull Context context, @NonNull JSONObject jSONObject) {
        C0320a c0320a = new C0320a();
        c cVar = new c();
        b bVar = new b();
        String acK = e.acK();
        this.appId = TextUtils.isEmpty(acK) ? "" : acK;
        this.cdz = c0320a;
        this.cdA = cVar;
        this.cdB = bVar;
        this.data = jSONObject;
        String ahk = ai.ahk();
        c0320a.cdC = "0".equals(ahk) ? "" : ahk;
        String androidId = getAndroidId();
        c0320a.cdD = "0".equals(androidId) ? "" : androidId;
        c0320a.cdE = 2;
        c0320a.adE = com.baidu.swan.bdprivate.c.f.c.a.dl(context) ? 3 : 2;
        String Lp = com.baidu.swan.apps.h.c.Lp();
        c0320a.cdF = "NUL".equals(Lp) ? "" : Lp;
        String deviceModel = com.baidu.swan.apps.h.c.getDeviceModel();
        c0320a.cdG = "NUL".equals(deviceModel) ? "" : deviceModel;
        c0320a.cdH = af.getDisplayHeight(context);
        c0320a.screenWidth = af.getDisplayWidth(context);
        String wifiInfo = getWifiInfo();
        c0320a.cdI = (TextUtils.isEmpty(wifiInfo) || Config.DEF_MAC_ID.equals(wifiInfo)) ? "" : "";
        bVar.network = com.baidu.swan.bdprivate.c.f.c.a.aiC();
        bVar.cdJ = com.baidu.swan.bdprivate.c.f.c.a.dm(context);
    }

    @NonNull
    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.put(Constants.APP_ID, this.appId);
            jSONObject2.put("deviceid", this.cdz.cdC);
            jSONObject2.put("androidid", this.cdz.cdD);
            jSONObject2.put("os_type", this.cdz.cdE);
            jSONObject2.put("device_type", this.cdz.adE);
            jSONObject2.put("device_vendor", this.cdz.cdF);
            jSONObject2.put("device_model", this.cdz.cdG);
            jSONObject2.put("screen_height", this.cdz.cdH);
            jSONObject2.put("screen_width", this.cdz.screenWidth);
            jSONObject2.put("mac", this.cdz.cdI);
            jSONObject.put(Config.DEVICE_PART, jSONObject2);
            jSONObject3.put("coord_type", this.cdA.coordType);
            jSONObject3.put("latitude", this.cdA.latitude);
            jSONObject3.put("longitude", this.cdA.longitude);
            jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
            jSONObject4.put("network", this.cdB.network);
            jSONObject4.put("operator", this.cdB.cdJ);
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
