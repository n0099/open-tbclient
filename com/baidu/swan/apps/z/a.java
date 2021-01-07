package com.baidu.swan.apps.z;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adaptation.a.d;
import com.baidu.swan.apps.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.ubc.l;
import com.baidu.swan.ubc.m;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a implements l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Boolean dsx = null;
    private Context mContext = AppRuntime.getAppContext();

    @Override // com.baidu.swan.ubc.l
    public m amb() {
        return com.baidu.swan.apps.t.a.aAY().amb();
    }

    @Override // com.baidu.swan.ubc.l
    public String aGV() {
        d aAv = com.baidu.swan.apps.t.a.aAv();
        return aAv != null ? aAv.akg() : "";
    }

    @Override // com.baidu.swan.ubc.l
    public boolean qX(String str) {
        int i;
        d aAv = com.baidu.swan.apps.t.a.aAv();
        String str2 = aAv != null ? aAv.getSwitch("ANDROID_UBC_SAMPLE_" + str, "") : "";
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            i = new JSONObject(str2).getInt("probability");
        } catch (JSONException e) {
            e.printStackTrace();
            i = 0;
        }
        return new Random().nextInt(100) < i;
    }

    @Override // com.baidu.swan.ubc.l
    public boolean aGW() {
        return DEBUG && PreferenceManager.getDefaultSharedPreferences(com.baidu.swan.apps.t.a.aAs()).getBoolean("KEY_UBC_DEBUG", true);
    }

    @Override // com.baidu.swan.ubc.l
    public boolean aGX() {
        return com.baidu.swan.apps.ad.a.a.aGX() && (aGW() || com.baidu.swan.apps.b.cEF);
    }

    @Override // com.baidu.swan.ubc.l
    public boolean aGY() {
        if (this.dsx == null) {
            this.dsx = Boolean.valueOf(com.baidu.swan.apps.t.a.aAv().getSwitch("swan_ceres_add_counter", false));
        }
        return this.dsx.booleanValue();
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, String str2, int i, String str3, int i2) {
        com.baidu.swan.apps.t.a.aAZ().a(str, str2, i, str3, i2);
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        com.baidu.swan.apps.t.a.aAZ().a(str, str2, i, str3, j, i2);
    }

    @Override // com.baidu.swan.ubc.l
    public void i(String str, int i, String str2) {
        com.baidu.swan.apps.t.a.aAZ().i(str, i, str2);
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, int i, JSONArray jSONArray) {
        com.baidu.swan.apps.t.a.aAZ().a(str, i, jSONArray);
    }

    @Override // com.baidu.swan.ubc.l
    public void M(String str, int i) {
        com.baidu.swan.apps.t.a.aAZ().M(str, i);
    }

    @Override // com.baidu.swan.ubc.l
    public String getDeviceId(Context context) {
        return com.baidu.swan.apps.t.a.aAx().cd(com.baidu.swan.apps.t.a.aAs());
    }

    @Override // com.baidu.swan.ubc.l
    public String getHostName() {
        return com.baidu.swan.apps.t.a.aBe().getHostName();
    }

    @Override // com.baidu.swan.ubc.l
    public String df(Context context) {
        return com.baidu.swan.uuid.b.eM(context).getUUID();
    }

    @Override // com.baidu.swan.ubc.l
    public String getUserId(Context context) {
        return com.baidu.swan.apps.t.a.aAx().cc(com.baidu.swan.apps.t.a.aAs());
    }

    @Override // com.baidu.swan.ubc.l
    public String getAppId() {
        e arP = f.aDH().arP();
        return arP != null ? arP.id : "";
    }

    @Override // com.baidu.swan.ubc.l
    public String getAppVersion() {
        e arP = f.aDH().arP();
        return arP != null ? arP.ajv().getVersion() : "";
    }

    @Override // com.baidu.swan.ubc.l
    public String aBF() {
        return com.baidu.swan.apps.swancore.b.le(ajl());
    }

    @Override // com.baidu.swan.ubc.l
    public String aBE() {
        return c.getVersion();
    }

    @Override // com.baidu.swan.ubc.l
    public int ajl() {
        return com.baidu.swan.apps.runtime.d.aMh().ajl();
    }

    @Override // com.baidu.swan.ubc.l
    public ExecutorService alA() {
        return com.baidu.swan.apps.t.a.aAZ().alA();
    }
}
