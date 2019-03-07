package com.baidu.swan.apps.z;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.c;
import com.baidu.swan.apps.w.e;
import com.baidu.swan.ubc.k;
import com.baidu.swan.ubc.l;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements k {
    private static final boolean DEBUG = c.DEBUG;
    private Context mContext = AppRuntime.getAppContext();

    @Override // com.baidu.swan.ubc.k
    public l uY() {
        return com.baidu.swan.apps.u.a.Dc().uY();
    }

    @Override // com.baidu.swan.ubc.k
    public String Fp() {
        com.baidu.swan.apps.b.b.c CB = com.baidu.swan.apps.u.a.CB();
        return CB != null ? CB.vm() : "";
    }

    @Override // com.baidu.swan.ubc.k
    public boolean fu(String str) {
        int i;
        com.baidu.swan.apps.b.b.c CB = com.baidu.swan.apps.u.a.CB();
        String V = CB != null ? CB.V("ANDROID_UBC_SAMPLE_" + str, "") : "";
        if (TextUtils.isEmpty(V)) {
            return false;
        }
        try {
            i = new JSONObject(V).getInt("probability");
        } catch (JSONException e) {
            e.printStackTrace();
            i = 0;
        }
        return new Random().nextInt(100) < i;
    }

    @Override // com.baidu.swan.ubc.k
    public boolean Fq() {
        return DEBUG && PreferenceManager.getDefaultSharedPreferences(com.baidu.swan.apps.u.a.Cy()).getBoolean("KEY_UBC_DEBUG", true);
    }

    @Override // com.baidu.swan.ubc.k
    public void b(String str, Object obj, int i) {
        if (!(obj instanceof String) || !com.baidu.swan.b.c.jW((String) obj)) {
            com.baidu.swan.apps.u.a.Dd().a(str, obj, i);
        }
    }

    @Override // com.baidu.swan.ubc.k
    public void a(String str, String str2, int i, String str3, int i2) {
        com.baidu.swan.apps.u.a.Dd().a(str, str2, i, str3, i2);
    }

    @Override // com.baidu.swan.ubc.k
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        com.baidu.swan.apps.u.a.Dd().a(str, str2, i, str3, j, i2);
    }

    @Override // com.baidu.swan.ubc.k
    public void c(String str, int i, String str2) {
        com.baidu.swan.apps.u.a.Dd().c(str, i, str2);
    }

    @Override // com.baidu.swan.ubc.k
    public void a(String str, int i, JSONArray jSONArray) {
        com.baidu.swan.apps.u.a.Dd().a(str, i, jSONArray);
    }

    @Override // com.baidu.swan.ubc.k
    public void y(String str, int i) {
        com.baidu.swan.apps.u.a.Dd().y(str, i);
    }

    @Override // com.baidu.swan.ubc.k
    public SQLiteDatabase getReadableDatabase() {
        return com.baidu.swan.apps.u.a.Dd().getReadableDatabase();
    }

    @Override // com.baidu.swan.ubc.k
    public SQLiteDatabase getWritableDatabase() {
        return com.baidu.swan.apps.u.a.Dd().getWritableDatabase();
    }

    @Override // com.baidu.swan.ubc.k
    public String getDeviceId(Context context) {
        return com.baidu.swan.apps.u.a.CD().bJ(com.baidu.swan.apps.u.a.Cy());
    }

    @Override // com.baidu.swan.ubc.k
    public String getAppId() {
        com.baidu.swan.apps.ae.b zb = e.Ec().zb();
        return zb != null ? zb.id : "";
    }

    @Override // com.baidu.swan.ubc.k
    public String getAppVersion() {
        com.baidu.swan.apps.ae.b zb = e.Ec().zb();
        return zb != null ? zb.uB().mVersion : "";
    }

    @Override // com.baidu.swan.ubc.k
    public String Dl() {
        return com.baidu.swan.apps.swancore.b.dI(ut());
    }

    @Override // com.baidu.swan.ubc.k
    public int ut() {
        SwanAppActivity DO = e.Ec().DO();
        if (DO == null || DO.isFinishing()) {
            return -1;
        }
        return DO.ut();
    }
}
