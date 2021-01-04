package com.baidu.swan.apps.env.c;

import android.text.TextUtils;
import com.baidu.swan.apps.env.c.b;
import com.baidu.swan.pms.model.PMSAppInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
class a implements b.a {
    private final String ddm;
    private JSONObject ddn = new JSONObject();

    private a(String str, boolean z) {
        this.ddm = str;
        try {
            this.ddn.put("pkg_id", this.ddm);
            if (z) {
                update();
            }
        } catch (JSONException e) {
            if (b.ddo) {
                e.printStackTrace();
            }
        }
    }

    public static a oD(String str) {
        return new a(str, true);
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public String axE() {
        return this.ddm;
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public JSONObject toJSONObject() {
        return this.ddn;
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.ddm);
    }

    private void update() throws JSONException {
        PMSAppInfo yN;
        if (isValid() && (yN = com.baidu.swan.pms.database.a.bgb().yN(this.ddm)) != null) {
            this.ddn.put("app_name", yN.appName);
            this.ddn.put("pkg_vername", yN.versionName);
            this.ddn.put("pkg_vercode", yN.versionCode);
            this.ddn.put("create_time", yN.createTime);
            this.ddn.put("last_launch_time", yN.getLastLaunchTime());
            this.ddn.put("launch_count", yN.aRG());
            this.ddn.put("install_src", yN.auu());
        }
    }
}
