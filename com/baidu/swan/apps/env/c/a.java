package com.baidu.swan.apps.env.c;

import android.text.TextUtils;
import com.baidu.swan.apps.env.c.b;
import com.baidu.swan.pms.model.PMSAppInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
class a implements b.a {
    private final String cET;
    private JSONObject cEU = new JSONObject();

    private a(String str, boolean z) {
        this.cET = str;
        try {
            this.cEU.put("pkg_id", this.cET);
            if (z) {
                update();
            }
        } catch (JSONException e) {
            if (b.cEV) {
                e.printStackTrace();
            }
        }
    }

    public static a nA(String str) {
        return new a(str, true);
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public String apr() {
        return this.cET;
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public JSONObject toJSONObject() {
        return this.cEU;
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.cET);
    }

    private void update() throws JSONException {
        PMSAppInfo xF;
        if (isValid() && (xF = com.baidu.swan.pms.database.a.aWO().xF(this.cET)) != null) {
            this.cEU.put("app_name", xF.appName);
            this.cEU.put("pkg_vername", xF.versionName);
            this.cEU.put("pkg_vercode", xF.versionCode);
            this.cEU.put("create_time", xF.createTime);
            this.cEU.put("last_launch_time", xF.getLastLaunchTime());
            this.cEU.put("launch_count", xF.aIw());
            this.cEU.put("install_src", xF.ami());
        }
    }
}
