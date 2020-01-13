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
/* loaded from: classes10.dex */
public class a implements k {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Context mContext = AppRuntime.getAppContext();

    @Override // com.baidu.swan.ubc.k
    public l Gk() {
        return com.baidu.swan.apps.w.a.Sl().Gk();
    }

    @Override // com.baidu.swan.ubc.k
    public String Xa() {
        d RJ = com.baidu.swan.apps.w.a.RJ();
        return RJ != null ? RJ.EV() : "";
    }

    @Override // com.baidu.swan.ubc.k
    public boolean ju(String str) {
        int i;
        d RJ = com.baidu.swan.apps.w.a.RJ();
        String str2 = RJ != null ? RJ.getSwitch("ANDROID_UBC_SAMPLE_" + str, "") : "";
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
    public boolean Xb() {
        return DEBUG && PreferenceManager.getDefaultSharedPreferences(com.baidu.swan.apps.w.a.RG()).getBoolean("KEY_UBC_DEBUG", true);
    }

    @Override // com.baidu.swan.ubc.k
    public boolean Xc() {
        return com.baidu.swan.apps.ah.a.a.Xc() && (Xb() || com.baidu.swan.apps.b.aWK);
    }

    @Override // com.baidu.swan.ubc.k
    public void c(String str, Object obj, int i) {
        if (!(obj instanceof String) || !com.baidu.swan.c.d.qQ((String) obj)) {
            com.baidu.swan.apps.w.a.Sm().b(str, obj, i);
        }
    }

    @Override // com.baidu.swan.ubc.k
    public void a(String str, String str2, int i, String str3, int i2) {
        com.baidu.swan.apps.w.a.Sm().a(str, str2, i, str3, i2);
    }

    @Override // com.baidu.swan.ubc.k
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        com.baidu.swan.apps.w.a.Sm().a(str, str2, i, str3, j, i2);
    }

    @Override // com.baidu.swan.ubc.k
    public void e(String str, int i, String str2) {
        com.baidu.swan.apps.w.a.Sm().e(str, i, str2);
    }

    @Override // com.baidu.swan.ubc.k
    public void a(String str, int i, JSONArray jSONArray) {
        com.baidu.swan.apps.w.a.Sm().a(str, i, jSONArray);
    }

    @Override // com.baidu.swan.ubc.k
    public void w(String str, int i) {
        com.baidu.swan.apps.w.a.Sm().w(str, i);
    }

    @Override // com.baidu.swan.ubc.k
    public SQLiteDatabase getWritableDatabase() {
        return com.baidu.swan.apps.w.a.Sm().getWritableDatabase();
    }

    @Override // com.baidu.swan.ubc.k
    public String getDeviceId(Context context) {
        return com.baidu.swan.apps.w.a.RL().bn(com.baidu.swan.apps.w.a.RG());
    }

    @Override // com.baidu.swan.ubc.k
    public String getHostName() {
        return com.baidu.swan.apps.w.a.Sr().getHostName();
    }

    @Override // com.baidu.swan.ubc.k
    public String cl(Context context) {
        return com.baidu.swan.uuid.b.dD(context).getUUID();
    }

    @Override // com.baidu.swan.ubc.k
    public String getUserId(Context context) {
        return com.baidu.swan.apps.w.a.RL().bm(com.baidu.swan.apps.w.a.RG());
    }

    @Override // com.baidu.swan.ubc.k
    public String getAppId() {
        e Mk = f.UC().Mk();
        return Mk != null ? Mk.id : "";
    }

    @Override // com.baidu.swan.ubc.k
    public String getAppVersion() {
        e Mk = f.UC().Mk();
        return Mk != null ? Mk.En().getVersion() : "";
    }

    @Override // com.baidu.swan.ubc.k
    public String SG() {
        return com.baidu.swan.apps.swancore.b.gh(Ed());
    }

    @Override // com.baidu.swan.ubc.k
    public int Ed() {
        return com.baidu.swan.apps.runtime.d.aam().Ed();
    }

    @Override // com.baidu.swan.ubc.k
    public ExecutorService Fx() {
        return com.baidu.swan.apps.w.a.Sm().Fx();
    }
}
