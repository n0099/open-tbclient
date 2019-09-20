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
    public l Fm() {
        return com.baidu.swan.apps.u.a.ES().Fm();
    }

    @Override // com.baidu.swan.ubc.k
    public String Ii() {
        c Er = com.baidu.swan.apps.u.a.Er();
        return Er != null ? Er.ws() : "";
    }

    @Override // com.baidu.swan.ubc.k
    public boolean fQ(String str) {
        int i;
        c Er = com.baidu.swan.apps.u.a.Er();
        String Q = Er != null ? Er.Q("ANDROID_UBC_SAMPLE_" + str, "") : "";
        if (TextUtils.isEmpty(Q)) {
            return false;
        }
        try {
            i = new JSONObject(Q).getInt("probability");
        } catch (JSONException e) {
            e.printStackTrace();
            i = 0;
        }
        return new Random().nextInt(100) < i;
    }

    @Override // com.baidu.swan.ubc.k
    public boolean Ij() {
        return DEBUG && PreferenceManager.getDefaultSharedPreferences(com.baidu.swan.apps.u.a.Eo()).getBoolean("KEY_UBC_DEBUG", true);
    }

    @Override // com.baidu.swan.ubc.k
    public void b(String str, Object obj, int i) {
        if (!(obj instanceof String) || !d.lg((String) obj)) {
            com.baidu.swan.apps.u.a.ET().a(str, obj, i);
        }
    }

    @Override // com.baidu.swan.ubc.k
    public void a(String str, String str2, int i, String str3, int i2) {
        com.baidu.swan.apps.u.a.ET().a(str, str2, i, str3, i2);
    }

    @Override // com.baidu.swan.ubc.k
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        com.baidu.swan.apps.u.a.ET().a(str, str2, i, str3, j, i2);
    }

    @Override // com.baidu.swan.ubc.k
    public void c(String str, int i, String str2) {
        com.baidu.swan.apps.u.a.ET().c(str, i, str2);
    }

    @Override // com.baidu.swan.ubc.k
    public void a(String str, int i, JSONArray jSONArray) {
        com.baidu.swan.apps.u.a.ET().a(str, i, jSONArray);
    }

    @Override // com.baidu.swan.ubc.k
    public void t(String str, int i) {
        com.baidu.swan.apps.u.a.ET().t(str, i);
    }

    @Override // com.baidu.swan.ubc.k
    public SQLiteDatabase getWritableDatabase() {
        return com.baidu.swan.apps.u.a.ET().getWritableDatabase();
    }

    @Override // com.baidu.swan.ubc.k
    public String getDeviceId(Context context) {
        return com.baidu.swan.apps.u.a.Et().bd(com.baidu.swan.apps.u.a.Eo());
    }

    @Override // com.baidu.swan.ubc.k
    public String getAppId() {
        com.baidu.swan.apps.ae.b AI = e.GJ().AI();
        return AI != null ? AI.id : "";
    }

    @Override // com.baidu.swan.ubc.k
    public String getAppVersion() {
        com.baidu.swan.apps.ae.b AI = e.GJ().AI();
        return AI != null ? AI.vP().getVersion() : "";
    }

    @Override // com.baidu.swan.ubc.k
    public String Fb() {
        return com.baidu.swan.apps.swancore.b.dW(vH());
    }

    @Override // com.baidu.swan.ubc.k
    public int vH() {
        SwanAppActivity Gv = e.GJ().Gv();
        if (Gv == null || Gv.isFinishing()) {
            return -1;
        }
        return Gv.vH();
    }

    @Override // com.baidu.swan.ubc.k
    public ExecutorService wK() {
        return com.baidu.swan.apps.u.a.ET().wK();
    }
}
