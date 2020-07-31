package com.baidu.swan.apps.env.b;

import android.text.TextUtils;
import com.baidu.swan.apps.env.b.b;
import com.baidu.swan.pms.model.PMSAppInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
class a implements b.a {
    private final String cjo;
    private JSONObject cjp = new JSONObject();

    private a(String str, boolean z) {
        this.cjo = str;
        try {
            this.cjp.put("pkg_id", this.cjo);
            if (z) {
                update();
            }
        } catch (JSONException e) {
            if (b.cjq) {
                e.printStackTrace();
            }
        }
    }

    public static a kF(String str) {
        return new a(str, true);
    }

    @Override // com.baidu.swan.apps.env.b.b.a
    public String aeP() {
        return this.cjo;
    }

    @Override // com.baidu.swan.apps.env.b.b.a
    public JSONObject toJSONObject() {
        return this.cjp;
    }

    @Override // com.baidu.swan.apps.env.b.b.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.cjo);
    }

    private void update() throws JSONException {
        PMSAppInfo uq;
        if (isValid() && (uq = com.baidu.swan.pms.database.a.aKS().uq(this.cjo)) != null) {
            this.cjp.put("app_name", uq.appName);
            this.cjp.put("pkg_vername", uq.versionName);
            this.cjp.put("pkg_vercode", uq.versionCode);
            this.cjp.put("create_time", uq.createTime);
            this.cjp.put("last_launch_time", uq.getLastLaunchTime());
            this.cjp.put("launch_count", uq.awU());
            this.cjp.put("install_src", uq.aco());
        }
    }
}
