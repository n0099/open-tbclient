package com.baidu.swan.apps.canvas.b;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends com.baidu.swan.apps.component.b.b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean cLX;

    public a(String str) {
        super("canvas", "canvasId");
        this.cLX = false;
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
        this.cLX = !TextUtils.equals(jSONObject.optString("disableScroll"), "0");
        this.cMT = TextUtils.equals(jSONObject.optString("gesture"), "0") ? false : true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.cMQ) || TextUtils.isEmpty(this.cMR)) ? false : true;
    }
}
