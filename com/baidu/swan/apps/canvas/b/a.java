package com.baidu.swan.apps.canvas.b;

import android.text.TextUtils;
import com.baidu.searchbox.appframework.AppFrameworkConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends com.baidu.swan.apps.component.b.b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean cov;

    public a(String str) {
        super("canvas", "canvasId");
        this.cov = false;
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
        this.cov = !TextUtils.equals(jSONObject.optString("disableScroll"), "0");
        this.cps = TextUtils.equals(jSONObject.optString(AppFrameworkConstants.VALUE_GESTURE_BACK), "0") ? false : true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.cpp) || TextUtils.isEmpty(this.cpq)) ? false : true;
    }
}
