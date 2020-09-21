package com.baidu.swan.apps.env.c;

import android.text.TextUtils;
import com.baidu.swan.apps.env.c.b;
import com.baidu.swan.pms.model.PMSAppInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
class a implements b.a {
    private final String csI;
    private JSONObject csJ = new JSONObject();

    private a(String str, boolean z) {
        this.csI = str;
        try {
            this.csJ.put("pkg_id", this.csI);
            if (z) {
                update();
            }
        } catch (JSONException e) {
            if (b.csK) {
                e.printStackTrace();
            }
        }
    }

    public static a mO(String str) {
        return new a(str, true);
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public String amF() {
        return this.csI;
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public JSONObject toJSONObject() {
        return this.csJ;
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.csI);
    }

    private void update() throws JSONException {
        PMSAppInfo wT;
        if (isValid() && (wT = com.baidu.swan.pms.database.a.aUf().wT(this.csI)) != null) {
            this.csJ.put("app_name", wT.appName);
            this.csJ.put("pkg_vername", wT.versionName);
            this.csJ.put("pkg_vercode", wT.versionCode);
            this.csJ.put("create_time", wT.createTime);
            this.csJ.put("last_launch_time", wT.getLastLaunchTime());
            this.csJ.put("launch_count", wT.aFN());
            this.csJ.put("install_src", wT.ajx());
        }
    }
}
