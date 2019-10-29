package com.baidu.swan.apps.z;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.b.b.c;
import com.baidu.swan.apps.w.e;
import com.baidu.swan.b.d;
import com.baidu.swan.ubc.k;
import com.baidu.swan.ubc.l;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements k {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Context mContext = AppRuntime.getAppContext();

    @Override // com.baidu.swan.ubc.k
    public l Kg() {
        return com.baidu.swan.apps.u.a.JM().Kg();
    }

    @Override // com.baidu.swan.ubc.k
    public String Nc() {
        c Jl = com.baidu.swan.apps.u.a.Jl();
        return Jl != null ? Jl.Bm() : "";
    }

    @Override // com.baidu.swan.ubc.k
    public boolean gv(String str) {
        int i;
        c Jl = com.baidu.swan.apps.u.a.Jl();
        String X = Jl != null ? Jl.X("ANDROID_UBC_SAMPLE_" + str, "") : "";
        if (TextUtils.isEmpty(X)) {
            return false;
        }
        try {
            i = new JSONObject(X).getInt("probability");
        } catch (JSONException e) {
            e.printStackTrace();
            i = 0;
        }
        return new Random().nextInt(100) < i;
    }

    @Override // com.baidu.swan.ubc.k
    public boolean Nd() {
        return DEBUG && PreferenceManager.getDefaultSharedPreferences(com.baidu.swan.apps.u.a.Ji()).getBoolean("KEY_UBC_DEBUG", true);
    }

    @Override // com.baidu.swan.ubc.k
    public void c(String str, Object obj, int i) {
        if (!(obj instanceof String) || !d.lI((String) obj)) {
            com.baidu.swan.apps.u.a.JN().b(str, obj, i);
        }
    }

    @Override // com.baidu.swan.ubc.k
    public void a(String str, String str2, int i, String str3, int i2) {
        com.baidu.swan.apps.u.a.JN().a(str, str2, i, str3, i2);
    }

    @Override // com.baidu.swan.ubc.k
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        com.baidu.swan.apps.u.a.JN().a(str, str2, i, str3, j, i2);
    }

    @Override // com.baidu.swan.ubc.k
    public void e(String str, int i, String str2) {
        com.baidu.swan.apps.u.a.JN().e(str, i, str2);
    }

    @Override // com.baidu.swan.ubc.k
    public void a(String str, int i, JSONArray jSONArray) {
        com.baidu.swan.apps.u.a.JN().a(str, i, jSONArray);
    }

    @Override // com.baidu.swan.ubc.k
    public void t(String str, int i) {
        com.baidu.swan.apps.u.a.JN().t(str, i);
    }

    @Override // com.baidu.swan.ubc.k
    public SQLiteDatabase getWritableDatabase() {
        return com.baidu.swan.apps.u.a.JN().getWritableDatabase();
    }

    @Override // com.baidu.swan.ubc.k
    public String getDeviceId(Context context) {
        return com.baidu.swan.apps.u.a.Jn().bf(com.baidu.swan.apps.u.a.Ji());
    }

    @Override // com.baidu.swan.ubc.k
    public String getAppId() {
        com.baidu.swan.apps.ae.b FD = e.LD().FD();
        return FD != null ? FD.id : "";
    }

    @Override // com.baidu.swan.ubc.k
    public String getAppVersion() {
        com.baidu.swan.apps.ae.b FD = e.LD().FD();
        return FD != null ? FD.AJ().getVersion() : "";
    }

    @Override // com.baidu.swan.ubc.k
    public String JV() {
        return com.baidu.swan.apps.swancore.b.eR(AB());
    }

    @Override // com.baidu.swan.ubc.k
    public int AB() {
        SwanAppActivity Lp = e.LD().Lp();
        if (Lp == null || Lp.isFinishing()) {
            return -1;
        }
        return Lp.AB();
    }

    @Override // com.baidu.swan.ubc.k
    public ExecutorService BE() {
        return com.baidu.swan.apps.u.a.JN().BE();
    }
}
