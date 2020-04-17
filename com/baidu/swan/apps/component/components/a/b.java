package com.baidu.swan.apps.component.components.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class b extends com.baidu.swan.apps.component.a.d.b {
    public String action;
    public boolean autoPlay;
    public boolean loop;
    public String path;

    public b() {
        super("animateview", "sanId");
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
        return (TextUtils.isEmpty(this.bGJ) || TextUtils.isEmpty(this.bGI)) ? false : true;
    }

    public boolean Ok() {
        return isValid() && !TextUtils.isEmpty(this.path);
    }
}
