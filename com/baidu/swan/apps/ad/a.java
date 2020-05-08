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
    public l Qp() {
        return com.baidu.swan.apps.w.a.acs().Qp();
    }

    @Override // com.baidu.swan.ubc.k
    public String ahx() {
        d abQ = com.baidu.swan.apps.w.a.abQ();
        return abQ != null ? abQ.Pd() : "";
    }

    @Override // com.baidu.swan.ubc.k
    public boolean kV(String str) {
        int i;
        d abQ = com.baidu.swan.apps.w.a.abQ();
        String str2 = abQ != null ? abQ.getSwitch("ANDROID_UBC_SAMPLE_" + str, "") : "";
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
    public boolean ahy() {
        return DEBUG && PreferenceManager.getDefaultSharedPreferences(com.baidu.swan.apps.w.a.abN()).getBoolean("KEY_UBC_DEBUG", true);
    }

    @Override // com.baidu.swan.ubc.k
    public boolean ahz() {
        return com.baidu.swan.apps.ah.a.a.ahz() && (ahy() || com.baidu.swan.apps.b.bzD);
    }

    @Override // com.baidu.swan.ubc.k
    public void c(String str, Object obj, int i) {
        if (!(obj instanceof String) || !com.baidu.swan.c.d.ss((String) obj)) {
            com.baidu.swan.apps.w.a.act().b(str, obj, i);
        }
    }

    @Override // com.baidu.swan.ubc.k
    public void a(String str, String str2, int i, String str3, int i2) {
        com.baidu.swan.apps.w.a.act().a(str, str2, i, str3, i2);
    }

    @Override // com.baidu.swan.ubc.k
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        com.baidu.swan.apps.w.a.act().a(str, str2, i, str3, j, i2);
    }

    @Override // com.baidu.swan.ubc.k
    public void f(String str, int i, String str2) {
        com.baidu.swan.apps.w.a.act().f(str, i, str2);
    }

    @Override // com.baidu.swan.ubc.k
    public void a(String str, int i, JSONArray jSONArray) {
        com.baidu.swan.apps.w.a.act().a(str, i, jSONArray);
    }

    @Override // com.baidu.swan.ubc.k
    public void C(String str, int i) {
        com.baidu.swan.apps.w.a.act().C(str, i);
    }

    @Override // com.baidu.swan.ubc.k
    public String getDeviceId(Context context) {
        return com.baidu.swan.apps.w.a.abS().aS(com.baidu.swan.apps.w.a.abN());
    }

    @Override // com.baidu.swan.ubc.k
    public String getHostName() {
        return com.baidu.swan.apps.w.a.acy().getHostName();
    }

    @Override // com.baidu.swan.ubc.k
    public String bQ(Context context) {
        return com.baidu.swan.uuid.b.di(context).getUUID();
    }

    @Override // com.baidu.swan.ubc.k
    public String getUserId(Context context) {
        return com.baidu.swan.apps.w.a.abS().aR(com.baidu.swan.apps.w.a.abN());
    }

    @Override // com.baidu.swan.ubc.k
    public String getAppId() {
        e Wq = f.aeJ().Wq();
        return Wq != null ? Wq.id : "";
    }

    @Override // com.baidu.swan.ubc.k
    public String getAppVersion() {
        e Wq = f.aeJ().Wq();
        return Wq != null ? Wq.Ov().getVersion() : "";
    }

    @Override // com.baidu.swan.ubc.k
    public String acN() {
        return com.baidu.swan.apps.swancore.b.gF(Ol());
    }

    @Override // com.baidu.swan.ubc.k
    public int Ol() {
        return com.baidu.swan.apps.runtime.d.akJ().Ol();
    }

    @Override // com.baidu.swan.ubc.k
    public ExecutorService PC() {
        return com.baidu.swan.apps.w.a.act().PC();
    }
}
