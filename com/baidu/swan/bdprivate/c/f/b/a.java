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
    public C0320a cdo;
    public c cdp;
    public b cdq;
    public JSONObject data;

    /* renamed from: com.baidu.swan.bdprivate.c.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0320a {
        public int adu;
        public String cdr;
        public String cds;
        public int cdt;
        public String cdu;
        public String cdv;
        public int cdw;
        public String cdx;
        public int screenWidth;
    }

    /* loaded from: classes11.dex */
    public static class b {
        public int cdy;
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
        String acH = e.acH();
        this.appId = TextUtils.isEmpty(acH) ? "" : acH;
        this.cdo = c0320a;
        this.cdp = cVar;
        this.cdq = bVar;
        this.data = jSONObject;
        String ahh = ai.ahh();
        c0320a.cdr = "0".equals(ahh) ? "" : ahh;
        String androidId = getAndroidId();
        c0320a.cds = "0".equals(androidId) ? "" : androidId;
        c0320a.cdt = 2;
        c0320a.adu = com.baidu.swan.bdprivate.c.f.c.a.dm(context) ? 3 : 2;
        String Lm = com.baidu.swan.apps.h.c.Lm();
        c0320a.cdu = "NUL".equals(Lm) ? "" : Lm;
        String deviceModel = com.baidu.swan.apps.h.c.getDeviceModel();
        c0320a.cdv = "NUL".equals(deviceModel) ? "" : deviceModel;
        c0320a.cdw = af.getDisplayHeight(context);
        c0320a.screenWidth = af.getDisplayWidth(context);
        String wifiInfo = getWifiInfo();
        c0320a.cdx = (TextUtils.isEmpty(wifiInfo) || Config.DEF_MAC_ID.equals(wifiInfo)) ? "" : "";
        bVar.network = com.baidu.swan.bdprivate.c.f.c.a.aiz();
        bVar.cdy = com.baidu.swan.bdprivate.c.f.c.a.dn(context);
    }

    @NonNull
    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.put(Constants.APP_ID, this.appId);
            jSONObject2.put("deviceid", this.cdo.cdr);
            jSONObject2.put("androidid", this.cdo.cds);
            jSONObject2.put("os_type", this.cdo.cdt);
            jSONObject2.put("device_type", this.cdo.adu);
            jSONObject2.put("device_vendor", this.cdo.cdu);
            jSONObject2.put("device_model", this.cdo.cdv);
            jSONObject2.put("screen_height", this.cdo.cdw);
            jSONObject2.put("screen_width", this.cdo.screenWidth);
            jSONObject2.put("mac", this.cdo.cdx);
            jSONObject.put(Config.DEVICE_PART, jSONObject2);
            jSONObject3.put("coord_type", this.cdp.coordType);
            jSONObject3.put("latitude", this.cdp.latitude);
            jSONObject3.put("longitude", this.cdp.longitude);
            jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
            jSONObject4.put("network", this.cdq.network);
            jSONObject4.put("operator", this.cdq.cdy);
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
