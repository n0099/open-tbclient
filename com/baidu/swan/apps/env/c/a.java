package com.baidu.swan.apps.env.c;

import android.text.TextUtils;
import com.baidu.swan.apps.env.c.b;
import com.baidu.swan.pms.model.PMSAppInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
class a implements b.a {
    private final String cRy;
    private JSONObject cRz = new JSONObject();

    private a(String str, boolean z) {
        this.cRy = str;
        try {
            this.cRz.put("pkg_id", this.cRy);
            if (z) {
                update();
            }
        } catch (JSONException e) {
            if (b.cRA) {
                e.printStackTrace();
            }
        }
    }

    public static a ob(String str) {
        return new a(str, true);
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public String ate() {
        return this.cRy;
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public JSONObject toJSONObject() {
        return this.cRz;
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.cRy);
    }

    private void update() throws JSONException {
        PMSAppInfo yh;
        if (isValid() && (yh = com.baidu.swan.pms.database.a.baA().yh(this.cRy)) != null) {
            this.cRz.put("app_name", yh.appName);
            this.cRz.put("pkg_vername", yh.versionName);
            this.cRz.put("pkg_vercode", yh.versionCode);
            this.cRz.put("create_time", yh.createTime);
            this.cRz.put("last_launch_time", yh.getLastLaunchTime());
            this.cRz.put("launch_count", yh.aMi());
            this.cRz.put("install_src", yh.apV());
        }
    }
}
