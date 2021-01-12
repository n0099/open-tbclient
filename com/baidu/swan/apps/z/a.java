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
/* loaded from: classes8.dex */
public class a implements l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Boolean dnG = null;
    private Context mContext = AppRuntime.getAppContext();

    @Override // com.baidu.swan.ubc.l
    public m aih() {
        return com.baidu.swan.apps.t.a.axe().aih();
    }

    @Override // com.baidu.swan.ubc.l
    public String aDb() {
        d awB = com.baidu.swan.apps.t.a.awB();
        return awB != null ? awB.agm() : "";
    }

    @Override // com.baidu.swan.ubc.l
    public boolean pM(String str) {
        int i;
        d awB = com.baidu.swan.apps.t.a.awB();
        String str2 = awB != null ? awB.getSwitch("ANDROID_UBC_SAMPLE_" + str, "") : "";
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
    public boolean aDc() {
        return DEBUG && PreferenceManager.getDefaultSharedPreferences(com.baidu.swan.apps.t.a.awy()).getBoolean("KEY_UBC_DEBUG", true);
    }

    @Override // com.baidu.swan.ubc.l
    public boolean aDd() {
        return com.baidu.swan.apps.ad.a.a.aDd() && (aDc() || com.baidu.swan.apps.b.czT);
    }

    @Override // com.baidu.swan.ubc.l
    public boolean aDe() {
        if (this.dnG == null) {
            this.dnG = Boolean.valueOf(com.baidu.swan.apps.t.a.awB().getSwitch("swan_ceres_add_counter", false));
        }
        return this.dnG.booleanValue();
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, String str2, int i, String str3, int i2) {
        com.baidu.swan.apps.t.a.axf().a(str, str2, i, str3, i2);
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        com.baidu.swan.apps.t.a.axf().a(str, str2, i, str3, j, i2);
    }

    @Override // com.baidu.swan.ubc.l
    public void i(String str, int i, String str2) {
        com.baidu.swan.apps.t.a.axf().i(str, i, str2);
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, int i, JSONArray jSONArray) {
        com.baidu.swan.apps.t.a.axf().a(str, i, jSONArray);
    }

    @Override // com.baidu.swan.ubc.l
    public void M(String str, int i) {
        com.baidu.swan.apps.t.a.axf().M(str, i);
    }

    @Override // com.baidu.swan.ubc.l
    public String getDeviceId(Context context) {
        return com.baidu.swan.apps.t.a.awD().cc(com.baidu.swan.apps.t.a.awy());
    }

    @Override // com.baidu.swan.ubc.l
    public String getHostName() {
        return com.baidu.swan.apps.t.a.axk().getHostName();
    }

    @Override // com.baidu.swan.ubc.l
    public String de(Context context) {
        return com.baidu.swan.uuid.b.eL(context).getUUID();
    }

    @Override // com.baidu.swan.ubc.l
    public String getUserId(Context context) {
        return com.baidu.swan.apps.t.a.awD().cb(com.baidu.swan.apps.t.a.awy());
    }

    @Override // com.baidu.swan.ubc.l
    public String getAppId() {
        e anU = f.azN().anU();
        return anU != null ? anU.id : "";
    }

    @Override // com.baidu.swan.ubc.l
    public String getAppVersion() {
        e anU = f.azN().anU();
        return anU != null ? anU.afB().getVersion() : "";
    }

    @Override // com.baidu.swan.ubc.l
    public String axL() {
        return com.baidu.swan.apps.swancore.b.jy(afr());
    }

    @Override // com.baidu.swan.ubc.l
    public String axK() {
        return c.getVersion();
    }

    @Override // com.baidu.swan.ubc.l
    public int afr() {
        return com.baidu.swan.apps.runtime.d.aIn().afr();
    }

    @Override // com.baidu.swan.ubc.l
    public ExecutorService ahG() {
        return com.baidu.swan.apps.t.a.axf().ahG();
    }
}
