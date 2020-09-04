package com.baidu.swan.apps.z;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adaptation.a.d;
import com.baidu.swan.apps.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.ubc.l;
import com.baidu.swan.ubc.m;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a implements l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Boolean cFI = null;
    private Context mContext = AppRuntime.getAppContext();

    @Override // com.baidu.swan.ubc.l
    public m aaB() {
        return com.baidu.swan.apps.t.a.apq().aaB();
    }

    @Override // com.baidu.swan.ubc.l
    public String avl() {
        d aoM = com.baidu.swan.apps.t.a.aoM();
        return aoM != null ? aoM.YI() : "";
    }

    @Override // com.baidu.swan.ubc.l
    public boolean oR(String str) {
        int i;
        d aoM = com.baidu.swan.apps.t.a.aoM();
        String str2 = aoM != null ? aoM.getSwitch("ANDROID_UBC_SAMPLE_" + str, "") : "";
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

    @Override // com.baidu.swan.ubc.l
    public boolean avm() {
        return DEBUG && PreferenceManager.getDefaultSharedPreferences(com.baidu.swan.apps.t.a.aoJ()).getBoolean("KEY_UBC_DEBUG", true);
    }

    @Override // com.baidu.swan.ubc.l
    public boolean avn() {
        return com.baidu.swan.apps.ad.a.a.avn() && (avm() || com.baidu.swan.apps.b.bRU);
    }

    @Override // com.baidu.swan.ubc.l
    public boolean avo() {
        if (this.cFI == null) {
            this.cFI = Boolean.valueOf(com.baidu.swan.apps.t.a.aoM().getSwitch("swan_ceres_add_counter", false));
        }
        return this.cFI.booleanValue();
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, String str2, int i, String str3, int i2) {
        com.baidu.swan.apps.t.a.apr().a(str, str2, i, str3, i2);
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        com.baidu.swan.apps.t.a.apr().a(str, str2, i, str3, j, i2);
    }

    @Override // com.baidu.swan.ubc.l
    public void f(String str, int i, String str2) {
        com.baidu.swan.apps.t.a.apr().f(str, i, str2);
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, int i, JSONArray jSONArray) {
        com.baidu.swan.apps.t.a.apr().a(str, i, jSONArray);
    }

    @Override // com.baidu.swan.ubc.l
    public void H(String str, int i) {
        com.baidu.swan.apps.t.a.apr().H(str, i);
    }

    @Override // com.baidu.swan.ubc.l
    public String getDeviceId(Context context) {
        return com.baidu.swan.apps.t.a.aoO().bl(com.baidu.swan.apps.t.a.aoJ());
    }

    @Override // com.baidu.swan.ubc.l
    public String getHostName() {
        return com.baidu.swan.apps.t.a.apw().getHostName();
    }

    @Override // com.baidu.swan.ubc.l
    public String cl(Context context) {
        return com.baidu.swan.uuid.b.dJ(context).getUUID();
    }

    @Override // com.baidu.swan.ubc.l
    public String getUserId(Context context) {
        return com.baidu.swan.apps.t.a.aoO().bk(com.baidu.swan.apps.t.a.aoJ());
    }

    @Override // com.baidu.swan.ubc.l
    public String getAppId() {
        e agn = f.arY().agn();
        return agn != null ? agn.id : "";
    }

    @Override // com.baidu.swan.ubc.l
    public String getAppVersion() {
        e agn = f.arY().agn();
        return agn != null ? agn.XZ().getVersion() : "";
    }

    @Override // com.baidu.swan.ubc.l
    public String apX() {
        return com.baidu.swan.apps.swancore.b.jC(XP());
    }

    @Override // com.baidu.swan.ubc.l
    public String apW() {
        return c.getVersion();
    }

    @Override // com.baidu.swan.ubc.l
    public int XP() {
        return com.baidu.swan.apps.runtime.d.azE().XP();
    }

    @Override // com.baidu.swan.ubc.l
    public ExecutorService aac() {
        return com.baidu.swan.apps.t.a.apr().aac();
    }
}
