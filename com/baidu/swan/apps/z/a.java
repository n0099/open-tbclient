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
    public l Ez() {
        return com.baidu.swan.apps.u.a.Ef().Ez();
    }

    @Override // com.baidu.swan.ubc.k
    public String Hs() {
        c DE = com.baidu.swan.apps.u.a.DE();
        return DE != null ? DE.vN() : "";
    }

    @Override // com.baidu.swan.ubc.k
    public boolean fK(String str) {
        int i;
        c DE = com.baidu.swan.apps.u.a.DE();
        String Q = DE != null ? DE.Q("ANDROID_UBC_SAMPLE_" + str, "") : "";
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
    public boolean Ht() {
        return DEBUG && PreferenceManager.getDefaultSharedPreferences(com.baidu.swan.apps.u.a.DB()).getBoolean("KEY_UBC_DEBUG", true);
    }

    @Override // com.baidu.swan.ubc.k
    public void b(String str, Object obj, int i) {
        if (!(obj instanceof String) || !d.kX((String) obj)) {
            com.baidu.swan.apps.u.a.Eg().a(str, obj, i);
        }
    }

    @Override // com.baidu.swan.ubc.k
    public void a(String str, String str2, int i, String str3, int i2) {
        com.baidu.swan.apps.u.a.Eg().a(str, str2, i, str3, i2);
    }

    @Override // com.baidu.swan.ubc.k
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        com.baidu.swan.apps.u.a.Eg().a(str, str2, i, str3, j, i2);
    }

    @Override // com.baidu.swan.ubc.k
    public void c(String str, int i, String str2) {
        com.baidu.swan.apps.u.a.Eg().c(str, i, str2);
    }

    @Override // com.baidu.swan.ubc.k
    public void a(String str, int i, JSONArray jSONArray) {
        com.baidu.swan.apps.u.a.Eg().a(str, i, jSONArray);
    }

    @Override // com.baidu.swan.ubc.k
    public void t(String str, int i) {
        com.baidu.swan.apps.u.a.Eg().t(str, i);
    }

    @Override // com.baidu.swan.ubc.k
    public SQLiteDatabase getWritableDatabase() {
        return com.baidu.swan.apps.u.a.Eg().getWritableDatabase();
    }

    @Override // com.baidu.swan.ubc.k
    public String getDeviceId(Context context) {
        return com.baidu.swan.apps.u.a.DG().bd(com.baidu.swan.apps.u.a.DB());
    }

    @Override // com.baidu.swan.ubc.k
    public String getAppId() {
        com.baidu.swan.apps.ae.b zX = e.FV().zX();
        return zX != null ? zX.id : "";
    }

    @Override // com.baidu.swan.ubc.k
    public String getAppVersion() {
        com.baidu.swan.apps.ae.b zX = e.FV().zX();
        return zX != null ? zX.vk().getVersion() : "";
    }

    @Override // com.baidu.swan.ubc.k
    public String Eo() {
        return com.baidu.swan.apps.swancore.b.dS(vc());
    }

    @Override // com.baidu.swan.ubc.k
    public int vc() {
        SwanAppActivity FH = e.FV().FH();
        if (FH == null || FH.isFinishing()) {
            return -1;
        }
        return FH.vc();
    }

    @Override // com.baidu.swan.ubc.k
    public ExecutorService wf() {
        return com.baidu.swan.apps.u.a.Eg().wf();
    }
}
