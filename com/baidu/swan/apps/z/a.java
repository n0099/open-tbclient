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
    private Boolean drv = null;
    private Context mContext = AppRuntime.getAppContext();

    @Override // com.baidu.swan.ubc.l
    public m aiI() {
        return com.baidu.swan.apps.t.a.axF().aiI();
    }

    @Override // com.baidu.swan.ubc.l
    public String aDA() {
        d axc = com.baidu.swan.apps.t.a.axc();
        return axc != null ? axc.agN() : "";
    }

    @Override // com.baidu.swan.ubc.l
    public boolean ql(String str) {
        int i;
        d axc = com.baidu.swan.apps.t.a.axc();
        String str2 = axc != null ? axc.getSwitch("ANDROID_UBC_SAMPLE_" + str, "") : "";
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
    public boolean aDB() {
        return DEBUG && PreferenceManager.getDefaultSharedPreferences(com.baidu.swan.apps.t.a.awZ()).getBoolean("KEY_UBC_DEBUG", true);
    }

    @Override // com.baidu.swan.ubc.l
    public boolean aDC() {
        return com.baidu.swan.apps.ad.a.a.aDC() && (aDB() || com.baidu.swan.apps.b.cDP);
    }

    @Override // com.baidu.swan.ubc.l
    public boolean aDD() {
        if (this.drv == null) {
            this.drv = Boolean.valueOf(com.baidu.swan.apps.t.a.axc().getSwitch("swan_ceres_add_counter", false));
        }
        return this.drv.booleanValue();
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, String str2, int i, String str3, int i2) {
        com.baidu.swan.apps.t.a.axG().a(str, str2, i, str3, i2);
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        com.baidu.swan.apps.t.a.axG().a(str, str2, i, str3, j, i2);
    }

    @Override // com.baidu.swan.ubc.l
    public void i(String str, int i, String str2) {
        com.baidu.swan.apps.t.a.axG().i(str, i, str2);
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, int i, JSONArray jSONArray) {
        com.baidu.swan.apps.t.a.axG().a(str, i, jSONArray);
    }

    @Override // com.baidu.swan.ubc.l
    public void P(String str, int i) {
        com.baidu.swan.apps.t.a.axG().P(str, i);
    }

    @Override // com.baidu.swan.ubc.l
    public String getDeviceId(Context context) {
        return com.baidu.swan.apps.t.a.axe().ca(com.baidu.swan.apps.t.a.awZ());
    }

    @Override // com.baidu.swan.ubc.l
    public String getHostName() {
        return com.baidu.swan.apps.t.a.axL().getHostName();
    }

    @Override // com.baidu.swan.ubc.l
    public String dc(Context context) {
        return com.baidu.swan.uuid.b.eJ(context).getUUID();
    }

    @Override // com.baidu.swan.ubc.l
    public String getUserId(Context context) {
        return com.baidu.swan.apps.t.a.axe().bZ(com.baidu.swan.apps.t.a.awZ());
    }

    @Override // com.baidu.swan.ubc.l
    public String getAppId() {
        e aov = f.aAo().aov();
        return aov != null ? aov.id : "";
    }

    @Override // com.baidu.swan.ubc.l
    public String getAppVersion() {
        e aov = f.aAo().aov();
        return aov != null ? aov.agc().getVersion() : "";
    }

    @Override // com.baidu.swan.ubc.l
    public String aym() {
        return com.baidu.swan.apps.swancore.b.jC(getFrameType());
    }

    @Override // com.baidu.swan.ubc.l
    public String ayl() {
        return c.getVersion();
    }

    @Override // com.baidu.swan.ubc.l
    public int getFrameType() {
        return com.baidu.swan.apps.runtime.d.aIJ().getFrameType();
    }

    @Override // com.baidu.swan.ubc.l
    public ExecutorService aih() {
        return com.baidu.swan.apps.t.a.axG().aih();
    }
}
