package com.baidu.swan.apps.env.c;

import android.text.TextUtils;
import com.baidu.swan.apps.env.c.b;
import com.baidu.swan.pms.model.PMSAppInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
class a implements b.a {
    private final String cTi;
    private JSONObject cTj = new JSONObject();

    private a(String str, boolean z) {
        this.cTi = str;
        try {
            this.cTj.put("pkg_id", this.cTi);
            if (z) {
                update();
            }
        } catch (JSONException e) {
            if (b.cTk) {
                e.printStackTrace();
            }
        }
    }

    public static a oi(String str) {
        return new a(str, true);
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public String atM() {
        return this.cTi;
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public JSONObject toJSONObject() {
        return this.cTj;
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.cTi);
    }

    private void update() throws JSONException {
        PMSAppInfo ym;
        if (isValid() && (ym = com.baidu.swan.pms.database.a.bbh().ym(this.cTi)) != null) {
            this.cTj.put("app_name", ym.appName);
            this.cTj.put("pkg_vername", ym.versionName);
            this.cTj.put("pkg_vercode", ym.versionCode);
            this.cTj.put("create_time", ym.createTime);
            this.cTj.put("last_launch_time", ym.getLastLaunchTime());
            this.cTj.put("launch_count", ym.aMQ());
            this.cTj.put("install_src", ym.aqD());
        }
    }
}
