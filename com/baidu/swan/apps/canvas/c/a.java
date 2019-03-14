package com.baidu.swan.apps.canvas.c;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends com.baidu.swan.apps.model.a.a.a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean amm;

    public a(String str) {
        super("canvasId", "canvas");
        this.amm = false;
        try {
            parseFromJson(new JSONObject(str));
        } catch (JSONException e) {
            com.baidu.swan.apps.console.c.e("Canvas", "parsing CanvasBasicthis occurs exception", e);
        }
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        this.hidden = TextUtils.equals(jSONObject.optString("hide"), "1") || jSONObject.optBoolean("hide");
        this.amm = !TextUtils.equals(jSONObject.optString("disableScroll"), "0");
        this.aBG = TextUtils.equals(jSONObject.optString("gesture"), "0") ? false : true;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.id) || TextUtils.isEmpty(this.aBD)) ? false : true;
    }
}
