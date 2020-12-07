package com.baidu.swan.apps.env.c;

import android.text.TextUtils;
import com.baidu.swan.apps.env.c.b;
import com.baidu.swan.pms.model.PMSAppInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
class a implements b.a {
    private final String cYr;
    private JSONObject cYs = new JSONObject();

    private a(String str, boolean z) {
        this.cYr = str;
        try {
            this.cYs.put("pkg_id", this.cYr);
            if (z) {
                update();
            }
        } catch (JSONException e) {
            if (b.cYt) {
                e.printStackTrace();
            }
        }
    }

    public static a oK(String str) {
        return new a(str, true);
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public String awm() {
        return this.cYr;
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public JSONObject toJSONObject() {
        return this.cYs;
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.cYr);
    }

    private void update() throws JSONException {
        PMSAppInfo yO;
        if (isValid() && (yO = com.baidu.swan.pms.database.a.bdF().yO(this.cYr)) != null) {
            this.cYs.put("app_name", yO.appName);
            this.cYs.put("pkg_vername", yO.versionName);
            this.cYs.put("pkg_vercode", yO.versionCode);
            this.cYs.put("create_time", yO.createTime);
            this.cYs.put("last_launch_time", yO.getLastLaunchTime());
            this.cYs.put("launch_count", yO.aPp());
            this.cYs.put("install_src", yO.atd());
        }
    }
}
