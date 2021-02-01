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
/* loaded from: classes9.dex */
public class a implements l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Boolean dpT = null;
    private Context mContext = AppRuntime.getAppContext();

    @Override // com.baidu.swan.ubc.l
    public m aiF() {
        return com.baidu.swan.apps.t.a.axC().aiF();
    }

    @Override // com.baidu.swan.ubc.l
    public String aDx() {
        d awZ = com.baidu.swan.apps.t.a.awZ();
        return awZ != null ? awZ.agK() : "";
    }

    @Override // com.baidu.swan.ubc.l
    public boolean qe(String str) {
        int i;
        d awZ = com.baidu.swan.apps.t.a.awZ();
        String str2 = awZ != null ? awZ.getSwitch("ANDROID_UBC_SAMPLE_" + str, "") : "";
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
    public boolean aDy() {
        return DEBUG && PreferenceManager.getDefaultSharedPreferences(com.baidu.swan.apps.t.a.awW()).getBoolean("KEY_UBC_DEBUG", true);
    }

    @Override // com.baidu.swan.ubc.l
    public boolean aDz() {
        return com.baidu.swan.apps.ad.a.a.aDz() && (aDy() || com.baidu.swan.apps.b.cCp);
    }

    @Override // com.baidu.swan.ubc.l
    public boolean aDA() {
        if (this.dpT == null) {
            this.dpT = Boolean.valueOf(com.baidu.swan.apps.t.a.awZ().getSwitch("swan_ceres_add_counter", false));
        }
        return this.dpT.booleanValue();
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, String str2, int i, String str3, int i2) {
        com.baidu.swan.apps.t.a.axD().a(str, str2, i, str3, i2);
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        com.baidu.swan.apps.t.a.axD().a(str, str2, i, str3, j, i2);
    }

    @Override // com.baidu.swan.ubc.l
    public void i(String str, int i, String str2) {
        com.baidu.swan.apps.t.a.axD().i(str, i, str2);
    }

    @Override // com.baidu.swan.ubc.l
    public void a(String str, int i, JSONArray jSONArray) {
        com.baidu.swan.apps.t.a.axD().a(str, i, jSONArray);
    }

    @Override // com.baidu.swan.ubc.l
    public void O(String str, int i) {
        com.baidu.swan.apps.t.a.axD().O(str, i);
    }

    @Override // com.baidu.swan.ubc.l
    public String getDeviceId(Context context) {
        return com.baidu.swan.apps.t.a.axb().cb(com.baidu.swan.apps.t.a.awW());
    }

    @Override // com.baidu.swan.ubc.l
    public String getHostName() {
        return com.baidu.swan.apps.t.a.axI().getHostName();
    }

    @Override // com.baidu.swan.ubc.l
    public String dd(Context context) {
        return com.baidu.swan.uuid.b.eK(context).getUUID();
    }

    @Override // com.baidu.swan.ubc.l
    public String getUserId(Context context) {
        return com.baidu.swan.apps.t.a.axb().ca(com.baidu.swan.apps.t.a.awW());
    }

    @Override // com.baidu.swan.ubc.l
    public String getAppId() {
        e aos = f.aAl().aos();
        return aos != null ? aos.id : "";
    }

    @Override // com.baidu.swan.ubc.l
    public String getAppVersion() {
        e aos = f.aAl().aos();
        return aos != null ? aos.afZ().getVersion() : "";
    }

    @Override // com.baidu.swan.ubc.l
    public String ayj() {
        return com.baidu.swan.apps.swancore.b.jB(getFrameType());
    }

    @Override // com.baidu.swan.ubc.l
    public String ayi() {
        return c.getVersion();
    }

    @Override // com.baidu.swan.ubc.l
    public int getFrameType() {
        return com.baidu.swan.apps.runtime.d.aIG().getFrameType();
    }

    @Override // com.baidu.swan.ubc.l
    public ExecutorService aie() {
        return com.baidu.swan.apps.t.a.axD().aie();
    }
}
