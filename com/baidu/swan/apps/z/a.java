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
/* loaded from: classes7.dex */
public class a implements l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Boolean dgx = null;
    private Context mContext = AppRuntime.getAppContext();

    @Override // com.baidu.swan.ubc.l
    public m ahI() {
        return com.baidu.swan.apps.t.a.awy().ahI();
    }

    @Override // com.baidu.swan.ubc.l
    public String aCr() {
        d avV = com.baidu.swan.apps.t.a.avV();
        return avV != null ? avV.afP() : "";
    }

    @Override // com.baidu.swan.ubc.l
    public boolean qx(String str) {
        int i;
        d avV = com.baidu.swan.apps.t.a.avV();
        String str2 = avV != null ? avV.getSwitch("ANDROID_UBC_SAMPLE_" + str, "") : "";
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
    public boolean aCs() {
        return DEBUG && PreferenceManager.getDefaultSharedPreferences(com.baidu.swan.apps.t.a.avS()).getBoolean("KEY_UBC_DEBUG", true);
    }

    @Override // com.baidu.swan.ubc.l
    public boolean aCt() {
        return com.baidu.swan.apps.ad.a.a.aCt() && (aCs() || com.baidu.swan.apps.b.csT);
    }

    @Override // com.baidu.swan.ubc.l
    public boolean aCu() {
        if (this.dgx == null) {
            this.dgx = Boolean.valueOf(com.baidu.swan.apps.t.a.avV().getSwitch("swan_ceres_add_counter", false));
        }
        return this.dgx.booleanValue();
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, String str2, int i, String str3, int i2) {
        com.baidu.swan.apps.t.a.awz().a(str, str2, i, str3, i2);
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        com.baidu.swan.apps.t.a.awz().a(str, str2, i, str3, j, i2);
    }

    @Override // com.baidu.swan.ubc.l
    public void i(String str, int i, String str2) {
        com.baidu.swan.apps.t.a.awz().i(str, i, str2);
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, int i, JSONArray jSONArray) {
        com.baidu.swan.apps.t.a.awz().a(str, i, jSONArray);
    }

    @Override // com.baidu.swan.ubc.l
    public void K(String str, int i) {
        com.baidu.swan.apps.t.a.awz().K(str, i);
    }

    @Override // com.baidu.swan.ubc.l
    public String getDeviceId(Context context) {
        return com.baidu.swan.apps.t.a.avX().bq(com.baidu.swan.apps.t.a.avS());
    }

    @Override // com.baidu.swan.ubc.l
    public String getHostName() {
        return com.baidu.swan.apps.t.a.awE().getHostName();
    }

    @Override // com.baidu.swan.ubc.l
    public String cq(Context context) {
        return com.baidu.swan.uuid.b.dO(context).getUUID();
    }

    @Override // com.baidu.swan.ubc.l
    public String getUserId(Context context) {
        return com.baidu.swan.apps.t.a.avX().bp(com.baidu.swan.apps.t.a.avS());
    }

    @Override // com.baidu.swan.ubc.l
    public String getAppId() {
        e anu = f.azg().anu();
        return anu != null ? anu.id : "";
    }

    @Override // com.baidu.swan.ubc.l
    public String getAppVersion() {
        e anu = f.azg().anu();
        return anu != null ? anu.afg().getVersion() : "";
    }

    @Override // com.baidu.swan.ubc.l
    public String axf() {
        return com.baidu.swan.apps.swancore.b.kB(aeW());
    }

    @Override // com.baidu.swan.ubc.l
    public String axe() {
        return c.getVersion();
    }

    @Override // com.baidu.swan.ubc.l
    public int aeW() {
        return com.baidu.swan.apps.runtime.d.aGI().aeW();
    }

    @Override // com.baidu.swan.ubc.l
    public ExecutorService ahj() {
        return com.baidu.swan.apps.t.a.awz().ahj();
    }
}
