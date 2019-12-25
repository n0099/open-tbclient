package com.baidu.swan.apps.ad;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adaptation.a.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.ubc.k;
import com.baidu.swan.ubc.l;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a implements k {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Context mContext = AppRuntime.getAppContext();

    @Override // com.baidu.swan.ubc.k
    public l FO() {
        return com.baidu.swan.apps.w.a.RP().FO();
    }

    @Override // com.baidu.swan.ubc.k
    public String WD() {
        d Rn = com.baidu.swan.apps.w.a.Rn();
        return Rn != null ? Rn.Ez() : "";
    }

    @Override // com.baidu.swan.ubc.k
    public boolean jr(String str) {
        int i;
        d Rn = com.baidu.swan.apps.w.a.Rn();
        String str2 = Rn != null ? Rn.getSwitch("ANDROID_UBC_SAMPLE_" + str, "") : "";
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

    @Override // com.baidu.swan.ubc.k
    public boolean WE() {
        return DEBUG && PreferenceManager.getDefaultSharedPreferences(com.baidu.swan.apps.w.a.Rk()).getBoolean("KEY_UBC_DEBUG", true);
    }

    @Override // com.baidu.swan.ubc.k
    public boolean WF() {
        return com.baidu.swan.apps.ah.a.a.WF() && (WE() || com.baidu.swan.apps.b.aVS);
    }

    @Override // com.baidu.swan.ubc.k
    public void c(String str, Object obj, int i) {
        if (!(obj instanceof String) || !com.baidu.swan.c.d.qN((String) obj)) {
            com.baidu.swan.apps.w.a.RQ().b(str, obj, i);
        }
    }

    @Override // com.baidu.swan.ubc.k
    public void a(String str, String str2, int i, String str3, int i2) {
        com.baidu.swan.apps.w.a.RQ().a(str, str2, i, str3, i2);
    }

    @Override // com.baidu.swan.ubc.k
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        com.baidu.swan.apps.w.a.RQ().a(str, str2, i, str3, j, i2);
    }

    @Override // com.baidu.swan.ubc.k
    public void e(String str, int i, String str2) {
        com.baidu.swan.apps.w.a.RQ().e(str, i, str2);
    }

    @Override // com.baidu.swan.ubc.k
    public void a(String str, int i, JSONArray jSONArray) {
        com.baidu.swan.apps.w.a.RQ().a(str, i, jSONArray);
    }

    @Override // com.baidu.swan.ubc.k
    public void w(String str, int i) {
        com.baidu.swan.apps.w.a.RQ().w(str, i);
    }

    @Override // com.baidu.swan.ubc.k
    public SQLiteDatabase getWritableDatabase() {
        return com.baidu.swan.apps.w.a.RQ().getWritableDatabase();
    }

    @Override // com.baidu.swan.ubc.k
    public String getDeviceId(Context context) {
        return com.baidu.swan.apps.w.a.Rp().bn(com.baidu.swan.apps.w.a.Rk());
    }

    @Override // com.baidu.swan.ubc.k
    public String getHostName() {
        return com.baidu.swan.apps.w.a.RV().getHostName();
    }

    @Override // com.baidu.swan.ubc.k
    public String cl(Context context) {
        return com.baidu.swan.uuid.b.dD(context).getUUID();
    }

    @Override // com.baidu.swan.ubc.k
    public String getUserId(Context context) {
        return com.baidu.swan.apps.w.a.Rp().bm(com.baidu.swan.apps.w.a.Rk());
    }

    @Override // com.baidu.swan.ubc.k
    public String getAppId() {
        e LO = f.Uf().LO();
        return LO != null ? LO.id : "";
    }

    @Override // com.baidu.swan.ubc.k
    public String getAppVersion() {
        e LO = f.Uf().LO();
        return LO != null ? LO.DR().getVersion() : "";
    }

    @Override // com.baidu.swan.ubc.k
    public String Sk() {
        return com.baidu.swan.apps.swancore.b.gg(DH());
    }

    @Override // com.baidu.swan.ubc.k
    public int DH() {
        return com.baidu.swan.apps.runtime.d.ZP().DH();
    }

    @Override // com.baidu.swan.ubc.k
    public ExecutorService Fb() {
        return com.baidu.swan.apps.w.a.RQ().Fb();
    }
}
