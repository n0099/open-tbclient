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
    private Boolean dif = null;
    private Context mContext = AppRuntime.getAppContext();

    @Override // com.baidu.swan.ubc.l
    public m aiq() {
        return com.baidu.swan.apps.t.a.axg().aiq();
    }

    @Override // com.baidu.swan.ubc.l
    public String aCZ() {
        d awD = com.baidu.swan.apps.t.a.awD();
        return awD != null ? awD.agx() : "";
    }

    @Override // com.baidu.swan.ubc.l
    public boolean qD(String str) {
        int i;
        d awD = com.baidu.swan.apps.t.a.awD();
        String str2 = awD != null ? awD.getSwitch("ANDROID_UBC_SAMPLE_" + str, "") : "";
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
    public boolean aDa() {
        return DEBUG && PreferenceManager.getDefaultSharedPreferences(com.baidu.swan.apps.t.a.awA()).getBoolean("KEY_UBC_DEBUG", true);
    }

    @Override // com.baidu.swan.ubc.l
    public boolean aDb() {
        return com.baidu.swan.apps.ad.a.a.aDb() && (aDa() || com.baidu.swan.apps.b.cuH);
    }

    @Override // com.baidu.swan.ubc.l
    public boolean aDc() {
        if (this.dif == null) {
            this.dif = Boolean.valueOf(com.baidu.swan.apps.t.a.awD().getSwitch("swan_ceres_add_counter", false));
        }
        return this.dif.booleanValue();
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, String str2, int i, String str3, int i2) {
        com.baidu.swan.apps.t.a.axh().a(str, str2, i, str3, i2);
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        com.baidu.swan.apps.t.a.axh().a(str, str2, i, str3, j, i2);
    }

    @Override // com.baidu.swan.ubc.l
    public void i(String str, int i, String str2) {
        com.baidu.swan.apps.t.a.axh().i(str, i, str2);
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, int i, JSONArray jSONArray) {
        com.baidu.swan.apps.t.a.axh().a(str, i, jSONArray);
    }

    @Override // com.baidu.swan.ubc.l
    public void K(String str, int i) {
        com.baidu.swan.apps.t.a.axh().K(str, i);
    }

    @Override // com.baidu.swan.ubc.l
    public String getDeviceId(Context context) {
        return com.baidu.swan.apps.t.a.awF().bq(com.baidu.swan.apps.t.a.awA());
    }

    @Override // com.baidu.swan.ubc.l
    public String getHostName() {
        return com.baidu.swan.apps.t.a.axm().getHostName();
    }

    @Override // com.baidu.swan.ubc.l
    public String cq(Context context) {
        return com.baidu.swan.uuid.b.dO(context).getUUID();
    }

    @Override // com.baidu.swan.ubc.l
    public String getUserId(Context context) {
        return com.baidu.swan.apps.t.a.awF().bp(com.baidu.swan.apps.t.a.awA());
    }

    @Override // com.baidu.swan.ubc.l
    public String getAppId() {
        e aoc = f.azO().aoc();
        return aoc != null ? aoc.id : "";
    }

    @Override // com.baidu.swan.ubc.l
    public String getAppVersion() {
        e aoc = f.azO().aoc();
        return aoc != null ? aoc.afO().getVersion() : "";
    }

    @Override // com.baidu.swan.ubc.l
    public String axN() {
        return com.baidu.swan.apps.swancore.b.kF(afE());
    }

    @Override // com.baidu.swan.ubc.l
    public String axM() {
        return c.getVersion();
    }

    @Override // com.baidu.swan.ubc.l
    public int afE() {
        return com.baidu.swan.apps.runtime.d.aHq().afE();
    }

    @Override // com.baidu.swan.ubc.l
    public ExecutorService ahR() {
        return com.baidu.swan.apps.t.a.axh().ahR();
    }
}
