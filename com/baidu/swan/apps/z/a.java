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
/* loaded from: classes25.dex */
public class a implements l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Boolean dnx = null;
    private Context mContext = AppRuntime.getAppContext();

    @Override // com.baidu.swan.ubc.l
    public m akQ() {
        return com.baidu.swan.apps.t.a.azG().akQ();
    }

    @Override // com.baidu.swan.ubc.l
    public String aFA() {
        d azd = com.baidu.swan.apps.t.a.azd();
        return azd != null ? azd.aiX() : "";
    }

    @Override // com.baidu.swan.ubc.l
    public boolean re(String str) {
        int i;
        d azd = com.baidu.swan.apps.t.a.azd();
        String str2 = azd != null ? azd.getSwitch("ANDROID_UBC_SAMPLE_" + str, "") : "";
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
    public boolean aFB() {
        return DEBUG && PreferenceManager.getDefaultSharedPreferences(com.baidu.swan.apps.t.a.aza()).getBoolean("KEY_UBC_DEBUG", true);
    }

    @Override // com.baidu.swan.ubc.l
    public boolean aFC() {
        return com.baidu.swan.apps.ad.a.a.aFC() && (aFB() || com.baidu.swan.apps.b.czP);
    }

    @Override // com.baidu.swan.ubc.l
    public boolean aFD() {
        if (this.dnx == null) {
            this.dnx = Boolean.valueOf(com.baidu.swan.apps.t.a.azd().getSwitch("swan_ceres_add_counter", false));
        }
        return this.dnx.booleanValue();
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, String str2, int i, String str3, int i2) {
        com.baidu.swan.apps.t.a.azH().a(str, str2, i, str3, i2);
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        com.baidu.swan.apps.t.a.azH().a(str, str2, i, str3, j, i2);
    }

    @Override // com.baidu.swan.ubc.l
    public void i(String str, int i, String str2) {
        com.baidu.swan.apps.t.a.azH().i(str, i, str2);
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, int i, JSONArray jSONArray) {
        com.baidu.swan.apps.t.a.azH().a(str, i, jSONArray);
    }

    @Override // com.baidu.swan.ubc.l
    public void L(String str, int i) {
        com.baidu.swan.apps.t.a.azH().L(str, i);
    }

    @Override // com.baidu.swan.ubc.l
    public String getDeviceId(Context context) {
        return com.baidu.swan.apps.t.a.azf().bW(com.baidu.swan.apps.t.a.aza());
    }

    @Override // com.baidu.swan.ubc.l
    public String getHostName() {
        return com.baidu.swan.apps.t.a.azM().getHostName();
    }

    @Override // com.baidu.swan.ubc.l
    public String cW(Context context) {
        return com.baidu.swan.uuid.b.et(context).getUUID();
    }

    @Override // com.baidu.swan.ubc.l
    public String getUserId(Context context) {
        return com.baidu.swan.apps.t.a.azf().bV(com.baidu.swan.apps.t.a.aza());
    }

    @Override // com.baidu.swan.ubc.l
    public String getAppId() {
        e aqC = f.aCp().aqC();
        return aqC != null ? aqC.id : "";
    }

    @Override // com.baidu.swan.ubc.l
    public String getAppVersion() {
        e aqC = f.aCp().aqC();
        return aqC != null ? aqC.aio().getVersion() : "";
    }

    @Override // com.baidu.swan.ubc.l
    public String aAn() {
        return com.baidu.swan.apps.swancore.b.kZ(aie());
    }

    @Override // com.baidu.swan.ubc.l
    public String aAm() {
        return c.getVersion();
    }

    @Override // com.baidu.swan.ubc.l
    public int aie() {
        return com.baidu.swan.apps.runtime.d.aJQ().aie();
    }

    @Override // com.baidu.swan.ubc.l
    public ExecutorService akr() {
        return com.baidu.swan.apps.t.a.azH().akr();
    }
}
