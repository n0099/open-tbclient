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
/* loaded from: classes11.dex */
public class a implements k {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Context mContext = AppRuntime.getAppContext();

    @Override // com.baidu.swan.ubc.k
    public l IE() {
        return com.baidu.swan.apps.w.a.UE().IE();
    }

    @Override // com.baidu.swan.ubc.k
    public String Zt() {
        d Uc = com.baidu.swan.apps.w.a.Uc();
        return Uc != null ? Uc.Hr() : "";
    }

    @Override // com.baidu.swan.ubc.k
    public boolean jI(String str) {
        int i;
        d Uc = com.baidu.swan.apps.w.a.Uc();
        String str2 = Uc != null ? Uc.getSwitch("ANDROID_UBC_SAMPLE_" + str, "") : "";
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
    public boolean Zu() {
        return DEBUG && PreferenceManager.getDefaultSharedPreferences(com.baidu.swan.apps.w.a.TZ()).getBoolean("KEY_UBC_DEBUG", true);
    }

    @Override // com.baidu.swan.ubc.k
    public boolean Zv() {
        return com.baidu.swan.apps.ah.a.a.Zv() && (Zu() || com.baidu.swan.apps.b.bbk);
    }

    @Override // com.baidu.swan.ubc.k
    public void c(String str, Object obj, int i) {
        if (!(obj instanceof String) || !com.baidu.swan.c.d.re((String) obj)) {
            com.baidu.swan.apps.w.a.UF().b(str, obj, i);
        }
    }

    @Override // com.baidu.swan.ubc.k
    public void a(String str, String str2, int i, String str3, int i2) {
        com.baidu.swan.apps.w.a.UF().a(str, str2, i, str3, i2);
    }

    @Override // com.baidu.swan.ubc.k
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        com.baidu.swan.apps.w.a.UF().a(str, str2, i, str3, j, i2);
    }

    @Override // com.baidu.swan.ubc.k
    public void f(String str, int i, String str2) {
        com.baidu.swan.apps.w.a.UF().f(str, i, str2);
    }

    @Override // com.baidu.swan.ubc.k
    public void a(String str, int i, JSONArray jSONArray) {
        com.baidu.swan.apps.w.a.UF().a(str, i, jSONArray);
    }

    @Override // com.baidu.swan.ubc.k
    public void u(String str, int i) {
        com.baidu.swan.apps.w.a.UF().u(str, i);
    }

    @Override // com.baidu.swan.ubc.k
    public SQLiteDatabase getWritableDatabase() {
        return com.baidu.swan.apps.w.a.UF().getWritableDatabase();
    }

    @Override // com.baidu.swan.ubc.k
    public String getDeviceId(Context context) {
        return com.baidu.swan.apps.w.a.Ue().bq(com.baidu.swan.apps.w.a.TZ());
    }

    @Override // com.baidu.swan.ubc.k
    public String getHostName() {
        return com.baidu.swan.apps.w.a.UK().getHostName();
    }

    @Override // com.baidu.swan.ubc.k
    public String co(Context context) {
        return com.baidu.swan.uuid.b.dG(context).getUUID();
    }

    @Override // com.baidu.swan.ubc.k
    public String getUserId(Context context) {
        return com.baidu.swan.apps.w.a.Ue().bp(com.baidu.swan.apps.w.a.TZ());
    }

    @Override // com.baidu.swan.ubc.k
    public String getAppId() {
        e OD = f.WV().OD();
        return OD != null ? OD.id : "";
    }

    @Override // com.baidu.swan.ubc.k
    public String getAppVersion() {
        e OD = f.WV().OD();
        return OD != null ? OD.GJ().getVersion() : "";
    }

    @Override // com.baidu.swan.ubc.k
    public String UZ() {
        return com.baidu.swan.apps.swancore.b.gy(Gz());
    }

    @Override // com.baidu.swan.ubc.k
    public int Gz() {
        return com.baidu.swan.apps.runtime.d.acF().Gz();
    }

    @Override // com.baidu.swan.ubc.k
    public ExecutorService HR() {
        return com.baidu.swan.apps.w.a.UF().HR();
    }
}
