package com.baidu.swan.apps.ad;

import android.content.Context;
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
    public l Qq() {
        return com.baidu.swan.apps.w.a.act().Qq();
    }

    @Override // com.baidu.swan.ubc.k
    public String ahy() {
        d abR = com.baidu.swan.apps.w.a.abR();
        return abR != null ? abR.Pe() : "";
    }

    @Override // com.baidu.swan.ubc.k
    public boolean kV(String str) {
        int i;
        d abR = com.baidu.swan.apps.w.a.abR();
        String str2 = abR != null ? abR.getSwitch("ANDROID_UBC_SAMPLE_" + str, "") : "";
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
    public boolean ahz() {
        return DEBUG && PreferenceManager.getDefaultSharedPreferences(com.baidu.swan.apps.w.a.abO()).getBoolean("KEY_UBC_DEBUG", true);
    }

    @Override // com.baidu.swan.ubc.k
    public boolean ahA() {
        return com.baidu.swan.apps.ah.a.a.ahA() && (ahz() || com.baidu.swan.apps.b.bzy);
    }

    @Override // com.baidu.swan.ubc.k
    public void c(String str, Object obj, int i) {
        if (!(obj instanceof String) || !com.baidu.swan.c.d.ss((String) obj)) {
            com.baidu.swan.apps.w.a.acu().b(str, obj, i);
        }
    }

    @Override // com.baidu.swan.ubc.k
    public void a(String str, String str2, int i, String str3, int i2) {
        com.baidu.swan.apps.w.a.acu().a(str, str2, i, str3, i2);
    }

    @Override // com.baidu.swan.ubc.k
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        com.baidu.swan.apps.w.a.acu().a(str, str2, i, str3, j, i2);
    }

    @Override // com.baidu.swan.ubc.k
    public void f(String str, int i, String str2) {
        com.baidu.swan.apps.w.a.acu().f(str, i, str2);
    }

    @Override // com.baidu.swan.ubc.k
    public void a(String str, int i, JSONArray jSONArray) {
        com.baidu.swan.apps.w.a.acu().a(str, i, jSONArray);
    }

    @Override // com.baidu.swan.ubc.k
    public void C(String str, int i) {
        com.baidu.swan.apps.w.a.acu().C(str, i);
    }

    @Override // com.baidu.swan.ubc.k
    public String getDeviceId(Context context) {
        return com.baidu.swan.apps.w.a.abT().be(com.baidu.swan.apps.w.a.abO());
    }

    @Override // com.baidu.swan.ubc.k
    public String getHostName() {
        return com.baidu.swan.apps.w.a.acz().getHostName();
    }

    @Override // com.baidu.swan.ubc.k
    public String cc(Context context) {
        return com.baidu.swan.uuid.b.du(context).getUUID();
    }

    @Override // com.baidu.swan.ubc.k
    public String getUserId(Context context) {
        return com.baidu.swan.apps.w.a.abT().bd(com.baidu.swan.apps.w.a.abO());
    }

    @Override // com.baidu.swan.ubc.k
    public String getAppId() {
        e Wr = f.aeK().Wr();
        return Wr != null ? Wr.id : "";
    }

    @Override // com.baidu.swan.ubc.k
    public String getAppVersion() {
        e Wr = f.aeK().Wr();
        return Wr != null ? Wr.Ow().getVersion() : "";
    }

    @Override // com.baidu.swan.ubc.k
    public String acO() {
        return com.baidu.swan.apps.swancore.b.gF(Om());
    }

    @Override // com.baidu.swan.ubc.k
    public int Om() {
        return com.baidu.swan.apps.runtime.d.akK().Om();
    }

    @Override // com.baidu.swan.ubc.k
    public ExecutorService PD() {
        return com.baidu.swan.apps.w.a.acu().PD();
    }
}
