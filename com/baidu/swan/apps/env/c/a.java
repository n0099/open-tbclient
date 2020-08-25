package com.baidu.swan.apps.env.c;

import android.text.TextUtils;
import com.baidu.swan.apps.env.c.b;
import com.baidu.swan.pms.model.PMSAppInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
class a implements b.a {
    private final String cqB;
    private JSONObject cqC = new JSONObject();

    private a(String str, boolean z) {
        this.cqB = str;
        try {
            this.cqC.put("pkg_id", this.cqB);
            if (z) {
                update();
            }
        } catch (JSONException e) {
            if (b.cqD) {
                e.printStackTrace();
            }
        }
    }

    public static a mu(String str) {
        return new a(str, true);
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public String alV() {
        return this.cqB;
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public JSONObject toJSONObject() {
        return this.cqC;
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.cqB);
    }

    private void update() throws JSONException {
        PMSAppInfo wz;
        if (isValid() && (wz = com.baidu.swan.pms.database.a.aTt().wz(this.cqB)) != null) {
            this.cqC.put("app_name", wz.appName);
            this.cqC.put("pkg_vername", wz.versionName);
            this.cqC.put("pkg_vercode", wz.versionCode);
            this.cqC.put("create_time", wz.createTime);
            this.cqC.put("last_launch_time", wz.getLastLaunchTime());
            this.cqC.put("launch_count", wz.aFd());
            this.cqC.put("install_src", wz.aiN());
        }
    }
}
