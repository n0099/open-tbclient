package com.baidu.swan.apps.env.c;

import android.text.TextUtils;
import com.baidu.swan.apps.env.c.b;
import com.baidu.swan.pms.model.PMSAppInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
class a implements b.a {
    private final String cYx;
    private JSONObject cYy = new JSONObject();

    private a(String str, boolean z) {
        this.cYx = str;
        try {
            this.cYy.put("pkg_id", this.cYx);
            if (z) {
                update();
            }
        } catch (JSONException e) {
            if (b.cYz) {
                e.printStackTrace();
            }
        }
    }

    public static a nq(String str) {
        return new a(str, true);
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public String atL() {
        return this.cYx;
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public JSONObject toJSONObject() {
        return this.cYy;
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.cYx);
    }

    private void update() throws JSONException {
        PMSAppInfo xC;
        if (isValid() && (xC = com.baidu.swan.pms.database.a.bci().xC(this.cYx)) != null) {
            this.cYy.put("app_name", xC.appName);
            this.cYy.put("pkg_vername", xC.versionName);
            this.cYy.put("pkg_vercode", xC.versionCode);
            this.cYy.put("create_time", xC.createTime);
            this.cYy.put("last_launch_time", xC.getLastLaunchTime());
            this.cYy.put("launch_count", xC.aNN());
            this.cYy.put("install_src", xC.aqA());
        }
    }
}
