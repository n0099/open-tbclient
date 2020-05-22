package com.baidu.swan.apps.canvas.b;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends com.baidu.swan.apps.component.b.b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean bOL;

    public a(String str) {
        super("canvas", "canvasId");
        this.bOL = false;
        try {
            parseFromJson(new JSONObject(str));
        } catch (JSONException e) {
            com.baidu.swan.apps.console.c.e("Canvas", "parsing CanvasBasicthis occurs exception", e);
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        this.hidden = TextUtils.equals(jSONObject.optString("hide"), "1") || jSONObject.optBoolean("hide");
        this.bOL = !TextUtils.equals(jSONObject.optString("disableScroll"), "0");
        this.bPI = TextUtils.equals(jSONObject.optString("gesture"), "0") ? false : true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.bPF) || TextUtils.isEmpty(this.bPG)) ? false : true;
    }
}
