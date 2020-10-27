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
/* loaded from: classes10.dex */
public class a implements l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Boolean dcj = null;
    private Context mContext = AppRuntime.getAppContext();

    @Override // com.baidu.swan.ubc.l
    public m afQ() {
        return com.baidu.swan.apps.t.a.auG().afQ();
    }

    @Override // com.baidu.swan.ubc.l
    public String aAz() {
        d aud = com.baidu.swan.apps.t.a.aud();
        return aud != null ? aud.adX() : "";
    }

    @Override // com.baidu.swan.ubc.l
    public boolean qp(String str) {
        int i;
        d aud = com.baidu.swan.apps.t.a.aud();
        String str2 = aud != null ? aud.getSwitch("ANDROID_UBC_SAMPLE_" + str, "") : "";
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
    public boolean aAA() {
        return DEBUG && PreferenceManager.getDefaultSharedPreferences(com.baidu.swan.apps.t.a.aua()).getBoolean("KEY_UBC_DEBUG", true);
    }

    @Override // com.baidu.swan.ubc.l
    public boolean aAB() {
        return com.baidu.swan.apps.ad.a.a.aAB() && (aAA() || com.baidu.swan.apps.b.coI);
    }

    @Override // com.baidu.swan.ubc.l
    public boolean aAC() {
        if (this.dcj == null) {
            this.dcj = Boolean.valueOf(com.baidu.swan.apps.t.a.aud().getSwitch("swan_ceres_add_counter", false));
        }
        return this.dcj.booleanValue();
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, String str2, int i, String str3, int i2) {
        com.baidu.swan.apps.t.a.auH().a(str, str2, i, str3, i2);
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        com.baidu.swan.apps.t.a.auH().a(str, str2, i, str3, j, i2);
    }

    @Override // com.baidu.swan.ubc.l
    public void h(String str, int i, String str2) {
        com.baidu.swan.apps.t.a.auH().h(str, i, str2);
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, int i, JSONArray jSONArray) {
        com.baidu.swan.apps.t.a.auH().a(str, i, jSONArray);
    }

    @Override // com.baidu.swan.ubc.l
    public void I(String str, int i) {
        com.baidu.swan.apps.t.a.auH().I(str, i);
    }

    @Override // com.baidu.swan.ubc.l
    public String getDeviceId(Context context) {
        return com.baidu.swan.apps.t.a.auf().bq(com.baidu.swan.apps.t.a.aua());
    }

    @Override // com.baidu.swan.ubc.l
    public String getHostName() {
        return com.baidu.swan.apps.t.a.auM().getHostName();
    }

    @Override // com.baidu.swan.ubc.l
    public String cq(Context context) {
        return com.baidu.swan.uuid.b.dO(context).getUUID();
    }

    @Override // com.baidu.swan.ubc.l
    public String getUserId(Context context) {
        return com.baidu.swan.apps.t.a.auf().bp(com.baidu.swan.apps.t.a.aua());
    }

    @Override // com.baidu.swan.ubc.l
    public String getAppId() {
        e alC = f.axo().alC();
        return alC != null ? alC.id : "";
    }

    @Override // com.baidu.swan.ubc.l
    public String getAppVersion() {
        e alC = f.axo().alC();
        return alC != null ? alC.ado().getVersion() : "";
    }

    @Override // com.baidu.swan.ubc.l
    public String avn() {
        return com.baidu.swan.apps.swancore.b.kv(ade());
    }

    @Override // com.baidu.swan.ubc.l
    public String avm() {
        return c.getVersion();
    }

    @Override // com.baidu.swan.ubc.l
    public int ade() {
        return com.baidu.swan.apps.runtime.d.aEQ().ade();
    }

    @Override // com.baidu.swan.ubc.l
    public ExecutorService afr() {
        return com.baidu.swan.apps.t.a.auH().afr();
    }
}
