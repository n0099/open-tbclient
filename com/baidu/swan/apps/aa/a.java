package com.baidu.swan.apps.aa;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adaptation.a.d;
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
    private Boolean cxK = null;
    private Context mContext = AppRuntime.getAppContext();

    @Override // com.baidu.swan.ubc.l
    public m Uz() {
        return com.baidu.swan.apps.t.a.ahO().Uz();
    }

    @Override // com.baidu.swan.ubc.l
    public String anq() {
        d ahm = com.baidu.swan.apps.t.a.ahm();
        return ahm != null ? ahm.SN() : "";
    }

    @Override // com.baidu.swan.ubc.l
    public boolean mR(String str) {
        int i;
        d ahm = com.baidu.swan.apps.t.a.ahm();
        String str2 = ahm != null ? ahm.getSwitch("ANDROID_UBC_SAMPLE_" + str, "") : "";
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
    public boolean anr() {
        return DEBUG && PreferenceManager.getDefaultSharedPreferences(com.baidu.swan.apps.t.a.ahj()).getBoolean("KEY_UBC_DEBUG", true);
    }

    @Override // com.baidu.swan.ubc.l
    public boolean ans() {
        return com.baidu.swan.apps.ae.a.a.ans() && (anr() || com.baidu.swan.apps.b.bMu);
    }

    @Override // com.baidu.swan.ubc.l
    public boolean ant() {
        if (this.cxK == null) {
            this.cxK = Boolean.valueOf(com.baidu.swan.apps.t.a.ahm().getSwitch("swan_ceres_add_counter", false));
        }
        return this.cxK.booleanValue();
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, String str2, int i, String str3, int i2) {
        com.baidu.swan.apps.t.a.ahP().a(str, str2, i, str3, i2);
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        com.baidu.swan.apps.t.a.ahP().a(str, str2, i, str3, j, i2);
    }

    @Override // com.baidu.swan.ubc.l
    public void f(String str, int i, String str2) {
        com.baidu.swan.apps.t.a.ahP().f(str, i, str2);
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, int i, JSONArray jSONArray) {
        com.baidu.swan.apps.t.a.ahP().a(str, i, jSONArray);
    }

    @Override // com.baidu.swan.ubc.l
    public void G(String str, int i) {
        com.baidu.swan.apps.t.a.ahP().G(str, i);
    }

    @Override // com.baidu.swan.ubc.l
    public String getDeviceId(Context context) {
        return com.baidu.swan.apps.t.a.aho().bf(com.baidu.swan.apps.t.a.ahj());
    }

    @Override // com.baidu.swan.ubc.l
    public String getHostName() {
        return com.baidu.swan.apps.t.a.ahU().getHostName();
    }

    @Override // com.baidu.swan.ubc.l
    public String cf(Context context) {
        return com.baidu.swan.uuid.b.dD(context).getUUID();
    }

    @Override // com.baidu.swan.ubc.l
    public String getUserId(Context context) {
        return com.baidu.swan.apps.t.a.aho().be(com.baidu.swan.apps.t.a.ahj());
    }

    @Override // com.baidu.swan.ubc.l
    public String getAppId() {
        e aad = f.akr().aad();
        return aad != null ? aad.id : "";
    }

    @Override // com.baidu.swan.ubc.l
    public String getAppVersion() {
        e aad = f.akr().aad();
        return aad != null ? aad.Se().getVersion() : "";
    }

    @Override // com.baidu.swan.ubc.l
    public String air() {
        return com.baidu.swan.apps.swancore.b.hv(RU());
    }

    @Override // com.baidu.swan.ubc.l
    public int RU() {
        return com.baidu.swan.apps.runtime.d.arr().RU();
    }

    @Override // com.baidu.swan.ubc.l
    public ExecutorService TZ() {
        return com.baidu.swan.apps.t.a.ahP().TZ();
    }
}
