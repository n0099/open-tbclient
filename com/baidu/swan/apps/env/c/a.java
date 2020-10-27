package com.baidu.swan.apps.env.c;

import android.text.TextUtils;
import com.baidu.swan.apps.env.c.b;
import com.baidu.swan.pms.model.PMSAppInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
class a implements b.a {
    private final String cNp;
    private JSONObject cNq = new JSONObject();

    private a(String str, boolean z) {
        this.cNp = str;
        try {
            this.cNq.put("pkg_id", this.cNp);
            if (z) {
                update();
            }
        } catch (JSONException e) {
            if (b.cNr) {
                e.printStackTrace();
            }
        }
    }

    public static a nT(String str) {
        return new a(str, true);
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public String arl() {
        return this.cNp;
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public JSONObject toJSONObject() {
        return this.cNq;
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.cNp);
    }

    private void update() throws JSONException {
        PMSAppInfo xY;
        if (isValid() && (xY = com.baidu.swan.pms.database.a.aYH().xY(this.cNp)) != null) {
            this.cNq.put("app_name", xY.appName);
            this.cNq.put("pkg_vername", xY.versionName);
            this.cNq.put("pkg_vercode", xY.versionCode);
            this.cNq.put("create_time", xY.createTime);
            this.cNq.put("last_launch_time", xY.getLastLaunchTime());
            this.cNq.put("launch_count", xY.aKq());
            this.cNq.put("install_src", xY.aoc());
        }
    }
}
