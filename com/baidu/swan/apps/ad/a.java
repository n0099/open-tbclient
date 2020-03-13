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
    public l IB() {
        return com.baidu.swan.apps.w.a.UB().IB();
    }

    @Override // com.baidu.swan.ubc.k
    public String Zq() {
        d TZ = com.baidu.swan.apps.w.a.TZ();
        return TZ != null ? TZ.Hm() : "";
    }

    @Override // com.baidu.swan.ubc.k
    public boolean jJ(String str) {
        int i;
        d TZ = com.baidu.swan.apps.w.a.TZ();
        String str2 = TZ != null ? TZ.getSwitch("ANDROID_UBC_SAMPLE_" + str, "") : "";
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
    public boolean Zr() {
        return DEBUG && PreferenceManager.getDefaultSharedPreferences(com.baidu.swan.apps.w.a.TW()).getBoolean("KEY_UBC_DEBUG", true);
    }

    @Override // com.baidu.swan.ubc.k
    public boolean Zs() {
        return com.baidu.swan.apps.ah.a.a.Zs() && (Zr() || com.baidu.swan.apps.b.baX);
    }

    @Override // com.baidu.swan.ubc.k
    public void c(String str, Object obj, int i) {
        if (!(obj instanceof String) || !com.baidu.swan.c.d.rf((String) obj)) {
            com.baidu.swan.apps.w.a.UC().b(str, obj, i);
        }
    }

    @Override // com.baidu.swan.ubc.k
    public void a(String str, String str2, int i, String str3, int i2) {
        com.baidu.swan.apps.w.a.UC().a(str, str2, i, str3, i2);
    }

    @Override // com.baidu.swan.ubc.k
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        com.baidu.swan.apps.w.a.UC().a(str, str2, i, str3, j, i2);
    }

    @Override // com.baidu.swan.ubc.k
    public void f(String str, int i, String str2) {
        com.baidu.swan.apps.w.a.UC().f(str, i, str2);
    }

    @Override // com.baidu.swan.ubc.k
    public void a(String str, int i, JSONArray jSONArray) {
        com.baidu.swan.apps.w.a.UC().a(str, i, jSONArray);
    }

    @Override // com.baidu.swan.ubc.k
    public void u(String str, int i) {
        com.baidu.swan.apps.w.a.UC().u(str, i);
    }

    @Override // com.baidu.swan.ubc.k
    public SQLiteDatabase getWritableDatabase() {
        return com.baidu.swan.apps.w.a.UC().getWritableDatabase();
    }

    @Override // com.baidu.swan.ubc.k
    public String getDeviceId(Context context) {
        return com.baidu.swan.apps.w.a.Ub().br(com.baidu.swan.apps.w.a.TW());
    }

    @Override // com.baidu.swan.ubc.k
    public String getHostName() {
        return com.baidu.swan.apps.w.a.UH().getHostName();
    }

    @Override // com.baidu.swan.ubc.k
    public String cp(Context context) {
        return com.baidu.swan.uuid.b.dH(context).getUUID();
    }

    @Override // com.baidu.swan.ubc.k
    public String getUserId(Context context) {
        return com.baidu.swan.apps.w.a.Ub().bq(com.baidu.swan.apps.w.a.TW());
    }

    @Override // com.baidu.swan.ubc.k
    public String getAppId() {
        e OA = f.WS().OA();
        return OA != null ? OA.id : "";
    }

    @Override // com.baidu.swan.ubc.k
    public String getAppVersion() {
        e OA = f.WS().OA();
        return OA != null ? OA.GE().getVersion() : "";
    }

    @Override // com.baidu.swan.ubc.k
    public String UW() {
        return com.baidu.swan.apps.swancore.b.gy(Gu());
    }

    @Override // com.baidu.swan.ubc.k
    public int Gu() {
        return com.baidu.swan.apps.runtime.d.acC().Gu();
    }

    @Override // com.baidu.swan.ubc.k
    public ExecutorService HO() {
        return com.baidu.swan.apps.w.a.UC().HO();
    }
}
