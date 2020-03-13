package com.baidu.l.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends com.baidu.swan.apps.component.a.d.b {
    public String action;
    public boolean autoPlay;
    public boolean loop;
    public String path;

    public b() {
        super("svgaAnimView", "sanId");
        this.loop = false;
        this.autoPlay = true;
        this.action = null;
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.path = jSONObject.optString("path");
            this.loop = jSONObject.optBoolean("loop");
            this.autoPlay = jSONObject.optBoolean("autoPlay");
            this.action = jSONObject.optString("action");
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.bin) || TextUtils.isEmpty(this.bim)) ? false : true;
    }

    public boolean Gs() {
        return isValid() && !TextUtils.isEmpty(this.path);
    }
}
