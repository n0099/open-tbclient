package com.baidu.swan.apps.env.c;

import android.text.TextUtils;
import com.baidu.swan.apps.env.c.b;
import com.baidu.swan.pms.model.PMSAppInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
class a implements b.a {
    private final String daJ;
    private JSONObject daK = new JSONObject();

    private a(String str, boolean z) {
        this.daJ = str;
        try {
            this.daK.put("pkg_id", this.daJ);
            if (z) {
                update();
            }
        } catch (JSONException e) {
            if (b.daL) {
                e.printStackTrace();
            }
        }
    }

    public static a nI(String str) {
        return new a(str, true);
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public String auj() {
        return this.daJ;
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public JSONObject toJSONObject() {
        return this.daK;
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.daJ);
    }

    private void update() throws JSONException {
        PMSAppInfo xV;
        if (isValid() && (xV = com.baidu.swan.pms.database.a.bcv().xV(this.daJ)) != null) {
            this.daK.put("app_name", xV.appName);
            this.daK.put("pkg_vername", xV.versionName);
            this.daK.put("pkg_vercode", xV.versionCode);
            this.daK.put("create_time", xV.createTime);
            this.daK.put("last_launch_time", xV.getLastLaunchTime());
            this.daK.put("launch_count", xV.aOg());
            this.daK.put("install_src", xV.aqY());
        }
    }
}
