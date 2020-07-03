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
    private Boolean cvx = null;
    private Context mContext = AppRuntime.getAppContext();

    @Override // com.baidu.swan.ubc.l
    public m TZ() {
        return com.baidu.swan.apps.u.a.agB().TZ();
    }

    @Override // com.baidu.swan.ubc.l
    public String alX() {
        d aga = com.baidu.swan.apps.u.a.aga();
        return aga != null ? aga.Sv() : "";
    }

    @Override // com.baidu.swan.ubc.l
    public boolean mr(String str) {
        int i;
        d aga = com.baidu.swan.apps.u.a.aga();
        String str2 = aga != null ? aga.getSwitch("ANDROID_UBC_SAMPLE_" + str, "") : "";
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
    public boolean alY() {
        return DEBUG && PreferenceManager.getDefaultSharedPreferences(com.baidu.swan.apps.u.a.afX()).getBoolean("KEY_UBC_DEBUG", true);
    }

    @Override // com.baidu.swan.ubc.l
    public boolean alZ() {
        return com.baidu.swan.apps.af.a.a.alZ() && (alY() || com.baidu.swan.apps.b.bLV);
    }

    @Override // com.baidu.swan.ubc.l
    public boolean ama() {
        if (this.cvx == null) {
            this.cvx = Boolean.valueOf(com.baidu.swan.apps.u.a.aga().getSwitch("swan_ceres_add_counter", false));
        }
        return this.cvx.booleanValue();
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, String str2, int i, String str3, int i2) {
        com.baidu.swan.apps.u.a.agC().a(str, str2, i, str3, i2);
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        com.baidu.swan.apps.u.a.agC().a(str, str2, i, str3, j, i2);
    }

    @Override // com.baidu.swan.ubc.l
    public void f(String str, int i, String str2) {
        com.baidu.swan.apps.u.a.agC().f(str, i, str2);
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, int i, JSONArray jSONArray) {
        com.baidu.swan.apps.u.a.agC().a(str, i, jSONArray);
    }

    @Override // com.baidu.swan.ubc.l
    public void G(String str, int i) {
        com.baidu.swan.apps.u.a.agC().G(str, i);
    }

    @Override // com.baidu.swan.ubc.l
    public String getDeviceId(Context context) {
        return com.baidu.swan.apps.u.a.agc().bd(com.baidu.swan.apps.u.a.afX());
    }

    @Override // com.baidu.swan.ubc.l
    public String getHostName() {
        return com.baidu.swan.apps.u.a.agH().getHostName();
    }

    @Override // com.baidu.swan.ubc.l
    public String cc(Context context) {
        return com.baidu.swan.uuid.b.dz(context).getUUID();
    }

    @Override // com.baidu.swan.ubc.l
    public String getUserId(Context context) {
        return com.baidu.swan.apps.u.a.agc().bc(com.baidu.swan.apps.u.a.afX());
    }

    @Override // com.baidu.swan.ubc.l
    public String getAppId() {
        e aai = f.ajb().aai();
        return aai != null ? aai.id : "";
    }

    @Override // com.baidu.swan.ubc.l
    public String getAppVersion() {
        e aai = f.ajb().aai();
        return aai != null ? aai.RP().getVersion() : "";
    }

    @Override // com.baidu.swan.ubc.l
    public String ahc() {
        return com.baidu.swan.apps.swancore.b.hm(RF());
    }

    @Override // com.baidu.swan.ubc.l
    public int RF() {
        return com.baidu.swan.apps.runtime.d.apI().RF();
    }

    @Override // com.baidu.swan.ubc.l
    public ExecutorService Tz() {
        return com.baidu.swan.apps.u.a.agC().Tz();
    }
}
