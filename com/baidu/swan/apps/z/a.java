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
/* loaded from: classes3.dex */
public class a implements l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Boolean cHI = null;
    private Context mContext = AppRuntime.getAppContext();

    @Override // com.baidu.swan.ubc.l
    public m abk() {
        return com.baidu.swan.apps.t.a.aqa().abk();
    }

    @Override // com.baidu.swan.ubc.l
    public String avU() {
        d apx = com.baidu.swan.apps.t.a.apx();
        return apx != null ? apx.Zr() : "";
    }

    @Override // com.baidu.swan.ubc.l
    public boolean pk(String str) {
        int i;
        d apx = com.baidu.swan.apps.t.a.apx();
        String str2 = apx != null ? apx.getSwitch("ANDROID_UBC_SAMPLE_" + str, "") : "";
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
    public boolean avV() {
        return DEBUG && PreferenceManager.getDefaultSharedPreferences(com.baidu.swan.apps.t.a.apu()).getBoolean("KEY_UBC_DEBUG", true);
    }

    @Override // com.baidu.swan.ubc.l
    public boolean avW() {
        return com.baidu.swan.apps.ad.a.a.avW() && (avV() || com.baidu.swan.apps.b.bTU);
    }

    @Override // com.baidu.swan.ubc.l
    public boolean avX() {
        if (this.cHI == null) {
            this.cHI = Boolean.valueOf(com.baidu.swan.apps.t.a.apx().getSwitch("swan_ceres_add_counter", false));
        }
        return this.cHI.booleanValue();
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, String str2, int i, String str3, int i2) {
        com.baidu.swan.apps.t.a.aqb().a(str, str2, i, str3, i2);
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        com.baidu.swan.apps.t.a.aqb().a(str, str2, i, str3, j, i2);
    }

    @Override // com.baidu.swan.ubc.l
    public void f(String str, int i, String str2) {
        com.baidu.swan.apps.t.a.aqb().f(str, i, str2);
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, int i, JSONArray jSONArray) {
        com.baidu.swan.apps.t.a.aqb().a(str, i, jSONArray);
    }

    @Override // com.baidu.swan.ubc.l
    public void H(String str, int i) {
        com.baidu.swan.apps.t.a.aqb().H(str, i);
    }

    @Override // com.baidu.swan.ubc.l
    public String getDeviceId(Context context) {
        return com.baidu.swan.apps.t.a.apz().bk(com.baidu.swan.apps.t.a.apu());
    }

    @Override // com.baidu.swan.ubc.l
    public String getHostName() {
        return com.baidu.swan.apps.t.a.aqg().getHostName();
    }

    @Override // com.baidu.swan.ubc.l
    public String ck(Context context) {
        return com.baidu.swan.uuid.b.dI(context).getUUID();
    }

    @Override // com.baidu.swan.ubc.l
    public String getUserId(Context context) {
        return com.baidu.swan.apps.t.a.apz().bj(com.baidu.swan.apps.t.a.apu());
    }

    @Override // com.baidu.swan.ubc.l
    public String getAppId() {
        e agX = f.asJ().agX();
        return agX != null ? agX.id : "";
    }

    @Override // com.baidu.swan.ubc.l
    public String getAppVersion() {
        e agX = f.asJ().agX();
        return agX != null ? agX.YI().getVersion() : "";
    }

    @Override // com.baidu.swan.ubc.l
    public String aqH() {
        return com.baidu.swan.apps.swancore.b.jN(Yy());
    }

    @Override // com.baidu.swan.ubc.l
    public String aqG() {
        return c.getVersion();
    }

    @Override // com.baidu.swan.ubc.l
    public int Yy() {
        return com.baidu.swan.apps.runtime.d.aAn().Yy();
    }

    @Override // com.baidu.swan.ubc.l
    public ExecutorService aaL() {
        return com.baidu.swan.apps.t.a.aqb().aaL();
    }
}
