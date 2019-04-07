package com.baidu.swan.apps.z;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.b.b.c;
import com.baidu.swan.apps.w.e;
import com.baidu.swan.ubc.j;
import com.baidu.swan.ubc.k;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Context mContext = AppRuntime.getAppContext();

    @Override // com.baidu.swan.ubc.j
    public k uX() {
        return com.baidu.swan.apps.u.a.Da().uX();
    }

    @Override // com.baidu.swan.ubc.j
    public String Fn() {
        c Cz = com.baidu.swan.apps.u.a.Cz();
        return Cz != null ? Cz.vl() : "";
    }

    @Override // com.baidu.swan.ubc.j
    public boolean fv(String str) {
        int i;
        c Cz = com.baidu.swan.apps.u.a.Cz();
        String V = Cz != null ? Cz.V("ANDROID_UBC_SAMPLE_" + str, "") : "";
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

    @Override // com.baidu.swan.ubc.j
    public boolean Fo() {
        return DEBUG && PreferenceManager.getDefaultSharedPreferences(com.baidu.swan.apps.u.a.Cw()).getBoolean("KEY_UBC_DEBUG", true);
    }

    @Override // com.baidu.swan.ubc.j
    public void b(String str, Object obj, int i) {
        if (!(obj instanceof String) || !com.baidu.swan.b.c.jX((String) obj)) {
            com.baidu.swan.apps.u.a.Db().a(str, obj, i);
        }
    }

    @Override // com.baidu.swan.ubc.j
    public void a(String str, String str2, int i, String str3, int i2) {
        com.baidu.swan.apps.u.a.Db().a(str, str2, i, str3, i2);
    }

    @Override // com.baidu.swan.ubc.j
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        com.baidu.swan.apps.u.a.Db().a(str, str2, i, str3, j, i2);
    }

    @Override // com.baidu.swan.ubc.j
    public void c(String str, int i, String str2) {
        com.baidu.swan.apps.u.a.Db().c(str, i, str2);
    }

    @Override // com.baidu.swan.ubc.j
    public void a(String str, int i, JSONArray jSONArray) {
        com.baidu.swan.apps.u.a.Db().a(str, i, jSONArray);
    }

    @Override // com.baidu.swan.ubc.j
    public void y(String str, int i) {
        com.baidu.swan.apps.u.a.Db().y(str, i);
    }

    @Override // com.baidu.swan.ubc.j
    public SQLiteDatabase getReadableDatabase() {
        return com.baidu.swan.apps.u.a.Db().getReadableDatabase();
    }

    @Override // com.baidu.swan.ubc.j
    public SQLiteDatabase getWritableDatabase() {
        return com.baidu.swan.apps.u.a.Db().getWritableDatabase();
    }

    @Override // com.baidu.swan.ubc.j
    public String getDeviceId(Context context) {
        return com.baidu.swan.apps.u.a.CB().bJ(com.baidu.swan.apps.u.a.Cw());
    }

    @Override // com.baidu.swan.ubc.j
    public String getAppId() {
        com.baidu.swan.apps.ae.b za = e.Ea().za();
        return za != null ? za.id : "";
    }

    @Override // com.baidu.swan.ubc.j
    public String getAppVersion() {
        com.baidu.swan.apps.ae.b za = e.Ea().za();
        return za != null ? za.uA().mVersion : "";
    }

    @Override // com.baidu.swan.ubc.j
    public String Dj() {
        return com.baidu.swan.apps.swancore.b.dH(us());
    }

    @Override // com.baidu.swan.ubc.j
    public int us() {
        SwanAppActivity DM = e.Ea().DM();
        if (DM == null || DM.isFinishing()) {
            return -1;
        }
        return DM.us();
    }
}
