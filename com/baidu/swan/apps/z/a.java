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
    private Boolean cTL = null;
    private Context mContext = AppRuntime.getAppContext();

    @Override // com.baidu.swan.ubc.l
    public m adW() {
        return com.baidu.swan.apps.t.a.asM().adW();
    }

    @Override // com.baidu.swan.ubc.l
    public String ayF() {
        d asi = com.baidu.swan.apps.t.a.asi();
        return asi != null ? asi.acd() : "";
    }

    @Override // com.baidu.swan.ubc.l
    public boolean pW(String str) {
        int i;
        d asi = com.baidu.swan.apps.t.a.asi();
        String str2 = asi != null ? asi.getSwitch("ANDROID_UBC_SAMPLE_" + str, "") : "";
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
    public boolean ayG() {
        return DEBUG && PreferenceManager.getDefaultSharedPreferences(com.baidu.swan.apps.t.a.asf()).getBoolean("KEY_UBC_DEBUG", true);
    }

    @Override // com.baidu.swan.ubc.l
    public boolean ayH() {
        return com.baidu.swan.apps.ad.a.a.ayH() && (ayG() || com.baidu.swan.apps.b.cgi);
    }

    @Override // com.baidu.swan.ubc.l
    public boolean ayI() {
        if (this.cTL == null) {
            this.cTL = Boolean.valueOf(com.baidu.swan.apps.t.a.asi().getSwitch("swan_ceres_add_counter", false));
        }
        return this.cTL.booleanValue();
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, String str2, int i, String str3, int i2) {
        com.baidu.swan.apps.t.a.asN().a(str, str2, i, str3, i2);
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        com.baidu.swan.apps.t.a.asN().a(str, str2, i, str3, j, i2);
    }

    @Override // com.baidu.swan.ubc.l
    public void h(String str, int i, String str2) {
        com.baidu.swan.apps.t.a.asN().h(str, i, str2);
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, int i, JSONArray jSONArray) {
        com.baidu.swan.apps.t.a.asN().a(str, i, jSONArray);
    }

    @Override // com.baidu.swan.ubc.l
    public void I(String str, int i) {
        com.baidu.swan.apps.t.a.asN().I(str, i);
    }

    @Override // com.baidu.swan.ubc.l
    public String getDeviceId(Context context) {
        return com.baidu.swan.apps.t.a.ask().bq(com.baidu.swan.apps.t.a.asf());
    }

    @Override // com.baidu.swan.ubc.l
    public String getHostName() {
        return com.baidu.swan.apps.t.a.asS().getHostName();
    }

    @Override // com.baidu.swan.ubc.l
    public String cq(Context context) {
        return com.baidu.swan.uuid.b.dO(context).getUUID();
    }

    @Override // com.baidu.swan.ubc.l
    public String getUserId(Context context) {
        return com.baidu.swan.apps.t.a.ask().bp(com.baidu.swan.apps.t.a.asf());
    }

    @Override // com.baidu.swan.ubc.l
    public String getAppId() {
        e ajI = f.avu().ajI();
        return ajI != null ? ajI.id : "";
    }

    @Override // com.baidu.swan.ubc.l
    public String getAppVersion() {
        e ajI = f.avu().ajI();
        return ajI != null ? ajI.abu().getVersion() : "";
    }

    @Override // com.baidu.swan.ubc.l
    public String att() {
        return com.baidu.swan.apps.swancore.b.kk(abk());
    }

    @Override // com.baidu.swan.ubc.l
    public String ats() {
        return c.getVersion();
    }

    @Override // com.baidu.swan.ubc.l
    public int abk() {
        return com.baidu.swan.apps.runtime.d.aCW().abk();
    }

    @Override // com.baidu.swan.ubc.l
    public ExecutorService adx() {
        return com.baidu.swan.apps.t.a.asN().adx();
    }
}
