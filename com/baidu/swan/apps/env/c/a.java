package com.baidu.swan.apps.env.c;

import android.text.TextUtils;
import com.baidu.swan.apps.env.c.b;
import com.baidu.swan.pms.model.PMSAppInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
class a implements b.a {
    private final String dck;
    private JSONObject dcl = new JSONObject();

    private a(String str, boolean z) {
        this.dck = str;
        try {
            this.dcl.put("pkg_id", this.dck);
            if (z) {
                update();
            }
        } catch (JSONException e) {
            if (b.dcm) {
                e.printStackTrace();
            }
        }
    }

    public static a nP(String str) {
        return new a(str, true);
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public String aum() {
        return this.dck;
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public JSONObject toJSONObject() {
        return this.dcl;
    }

    @Override // com.baidu.swan.apps.env.c.b.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.dck);
    }

    private void update() throws JSONException {
        PMSAppInfo yc;
        if (isValid() && (yc = com.baidu.swan.pms.database.a.bcx().yc(this.dck)) != null) {
            this.dcl.put("app_name", yc.appName);
            this.dcl.put("pkg_vername", yc.versionName);
            this.dcl.put("pkg_vercode", yc.versionCode);
            this.dcl.put("create_time", yc.createTime);
            this.dcl.put("last_launch_time", yc.getLastLaunchTime());
            this.dcl.put("launch_count", yc.aOj());
            this.dcl.put("install_src", yc.arb());
        }
    }
}
