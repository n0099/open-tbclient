package com.baidu.swan.apps.env.c;

import android.text.TextUtils;
import com.baidu.swan.apps.env.c.b;
import com.baidu.swan.pms.model.PMSAppInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
class a implements b.a {
    private final String cqF;
    private JSONObject cqG = new JSONObject();

    private a(String str, boolean z) {
        this.cqF = str;
        try {
            this.cqG.put("pkg_id", this.cqF);
            if (z) {
                update();
            }
        } catch (JSONException e) {
            if (b.cqH) {
                e.printStackTrace();
            }
        }
    }

    public static a mv(String str) {
        return new a(str, true);
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public String alV() {
        return this.cqF;
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public JSONObject toJSONObject() {
        return this.cqG;
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.cqF);
    }

    private void update() throws JSONException {
        PMSAppInfo wA;
        if (isValid() && (wA = com.baidu.swan.pms.database.a.aTt().wA(this.cqF)) != null) {
            this.cqG.put("app_name", wA.appName);
            this.cqG.put("pkg_vername", wA.versionName);
            this.cqG.put("pkg_vercode", wA.versionCode);
            this.cqG.put("create_time", wA.createTime);
            this.cqG.put("last_launch_time", wA.getLastLaunchTime());
            this.cqG.put("launch_count", wA.aFd());
            this.cqG.put("install_src", wA.aiN());
        }
    }
}
