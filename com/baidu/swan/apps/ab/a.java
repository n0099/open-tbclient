package com.baidu.swan.apps.ab;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adaptation.a.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.w.f;
import com.baidu.swan.ubc.l;
import com.baidu.swan.ubc.m;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Boolean cqI = null;
    private Context mContext = AppRuntime.getAppContext();

    @Override // com.baidu.swan.ubc.l
    public m ST() {
        return com.baidu.swan.apps.u.a.afv().ST();
    }

    @Override // com.baidu.swan.ubc.l
    public String akR() {
        d aeU = com.baidu.swan.apps.u.a.aeU();
        return aeU != null ? aeU.Rp() : "";
    }

    @Override // com.baidu.swan.ubc.l
    public boolean mj(String str) {
        int i;
        d aeU = com.baidu.swan.apps.u.a.aeU();
        String str2 = aeU != null ? aeU.getSwitch("ANDROID_UBC_SAMPLE_" + str, "") : "";
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
    public boolean akS() {
        return DEBUG && PreferenceManager.getDefaultSharedPreferences(com.baidu.swan.apps.u.a.aeR()).getBoolean("KEY_UBC_DEBUG", true);
    }

    @Override // com.baidu.swan.ubc.l
    public boolean akT() {
        return com.baidu.swan.apps.af.a.a.akT() && (akS() || com.baidu.swan.apps.b.bHh);
    }

    @Override // com.baidu.swan.ubc.l
    public boolean akU() {
        if (this.cqI == null) {
            this.cqI = Boolean.valueOf(com.baidu.swan.apps.u.a.aeU().getSwitch("swan_ceres_add_counter", false));
        }
        return this.cqI.booleanValue();
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, String str2, int i, String str3, int i2) {
        com.baidu.swan.apps.u.a.afw().a(str, str2, i, str3, i2);
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        com.baidu.swan.apps.u.a.afw().a(str, str2, i, str3, j, i2);
    }

    @Override // com.baidu.swan.ubc.l
    public void f(String str, int i, String str2) {
        com.baidu.swan.apps.u.a.afw().f(str, i, str2);
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, int i, JSONArray jSONArray) {
        com.baidu.swan.apps.u.a.afw().a(str, i, jSONArray);
    }

    @Override // com.baidu.swan.ubc.l
    public void G(String str, int i) {
        com.baidu.swan.apps.u.a.afw().G(str, i);
    }

    @Override // com.baidu.swan.ubc.l
    public String getDeviceId(Context context) {
        return com.baidu.swan.apps.u.a.aeW().bc(com.baidu.swan.apps.u.a.aeR());
    }

    @Override // com.baidu.swan.ubc.l
    public String getHostName() {
        return com.baidu.swan.apps.u.a.afB().getHostName();
    }

    @Override // com.baidu.swan.ubc.l
    public String cb(Context context) {
        return com.baidu.swan.uuid.b.dy(context).getUUID();
    }

    @Override // com.baidu.swan.ubc.l
    public String getUserId(Context context) {
        return com.baidu.swan.apps.u.a.aeW().bb(com.baidu.swan.apps.u.a.aeR());
    }

    @Override // com.baidu.swan.ubc.l
    public String getAppId() {
        e Zc = f.ahV().Zc();
        return Zc != null ? Zc.id : "";
    }

    @Override // com.baidu.swan.ubc.l
    public String getAppVersion() {
        e Zc = f.ahV().Zc();
        return Zc != null ? Zc.QJ().getVersion() : "";
    }

    @Override // com.baidu.swan.ubc.l
    public String afW() {
        return com.baidu.swan.apps.swancore.b.hb(Qz());
    }

    @Override // com.baidu.swan.ubc.l
    public int Qz() {
        return com.baidu.swan.apps.runtime.d.aoB().Qz();
    }

    @Override // com.baidu.swan.ubc.l
    public ExecutorService St() {
        return com.baidu.swan.apps.u.a.afw().St();
    }
}
