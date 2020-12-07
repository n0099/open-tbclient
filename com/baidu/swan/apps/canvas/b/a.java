package com.baidu.swan.apps.canvas.b;

import android.text.TextUtils;
import com.baidu.searchbox.appframework.AppFrameworkConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class a extends com.baidu.swan.apps.component.b.b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean cIc;

    public a(String str) {
        super("canvas", "canvasId");
        this.cIc = false;
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
        this.cIc = !TextUtils.equals(jSONObject.optString("disableScroll"), "0");
        this.cIY = TextUtils.equals(jSONObject.optString(AppFrameworkConstants.VALUE_GESTURE_BACK), "0") ? false : true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.cIV) || TextUtils.isEmpty(this.cIW)) ? false : true;
    }
}
