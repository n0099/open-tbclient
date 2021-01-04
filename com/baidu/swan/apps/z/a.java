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
    public m ama() {
        return com.baidu.swan.apps.t.a.aAX().ama();
    }

    @Override // com.baidu.swan.ubc.l
    public String aGU() {
        d aAu = com.baidu.swan.apps.t.a.aAu();
        return aAu != null ? aAu.akf() : "";
    }

    @Override // com.baidu.swan.ubc.l
    public boolean qX(String str) {
        int i;
        d aAu = com.baidu.swan.apps.t.a.aAu();
        String str2 = aAu != null ? aAu.getSwitch("ANDROID_UBC_SAMPLE_" + str, "") : "";
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
    public boolean aGV() {
        return DEBUG && PreferenceManager.getDefaultSharedPreferences(com.baidu.swan.apps.t.a.aAr()).getBoolean("KEY_UBC_DEBUG", true);
    }

    @Override // com.baidu.swan.ubc.l
    public boolean aGW() {
        return com.baidu.swan.apps.ad.a.a.aGW() && (aGV() || com.baidu.swan.apps.b.cEF);
    }

    @Override // com.baidu.swan.ubc.l
    public boolean aGX() {
        if (this.dsx == null) {
            this.dsx = Boolean.valueOf(com.baidu.swan.apps.t.a.aAu().getSwitch("swan_ceres_add_counter", false));
        }
        return this.dsx.booleanValue();
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, String str2, int i, String str3, int i2) {
        com.baidu.swan.apps.t.a.aAY().a(str, str2, i, str3, i2);
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        com.baidu.swan.apps.t.a.aAY().a(str, str2, i, str3, j, i2);
    }

    @Override // com.baidu.swan.ubc.l
    public void i(String str, int i, String str2) {
        com.baidu.swan.apps.t.a.aAY().i(str, i, str2);
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, int i, JSONArray jSONArray) {
        com.baidu.swan.apps.t.a.aAY().a(str, i, jSONArray);
    }

    @Override // com.baidu.swan.ubc.l
    public void M(String str, int i) {
        com.baidu.swan.apps.t.a.aAY().M(str, i);
    }

    @Override // com.baidu.swan.ubc.l
    public String getDeviceId(Context context) {
        return com.baidu.swan.apps.t.a.aAw().cd(com.baidu.swan.apps.t.a.aAr());
    }

    @Override // com.baidu.swan.ubc.l
    public String getHostName() {
        return com.baidu.swan.apps.t.a.aBd().getHostName();
    }

    @Override // com.baidu.swan.ubc.l
    public String df(Context context) {
        return com.baidu.swan.uuid.b.eM(context).getUUID();
    }

    @Override // com.baidu.swan.ubc.l
    public String getUserId(Context context) {
        return com.baidu.swan.apps.t.a.aAw().cc(com.baidu.swan.apps.t.a.aAr());
    }

    @Override // com.baidu.swan.ubc.l
    public String getAppId() {
        e arO = f.aDG().arO();
        return arO != null ? arO.id : "";
    }

    @Override // com.baidu.swan.ubc.l
    public String getAppVersion() {
        e arO = f.aDG().arO();
        return arO != null ? arO.aju().getVersion() : "";
    }

    @Override // com.baidu.swan.ubc.l
    public String aBE() {
        return com.baidu.swan.apps.swancore.b.le(ajk());
    }

    @Override // com.baidu.swan.ubc.l
    public String aBD() {
        return c.getVersion();
    }

    @Override // com.baidu.swan.ubc.l
    public int ajk() {
        return com.baidu.swan.apps.runtime.d.aMg().ajk();
    }

    @Override // com.baidu.swan.ubc.l
    public ExecutorService alz() {
        return com.baidu.swan.apps.t.a.aAY().alz();
    }
}
