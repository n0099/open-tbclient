package com.baidu.swan.apps.w.a.a;

import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.swan.apps.ap.ah;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class g implements com.baidu.swan.apps.model.a {
    public int left = Integer.MIN_VALUE;
    public int top = Integer.MIN_VALUE;
    public int width = -1;
    public int height = -1;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("left") && jSONObject.has(VerticalTranslateLayout.TOP)) {
            this.left = ah.L(jSONObject.optInt("left"));
            this.top = ah.L(jSONObject.optInt(VerticalTranslateLayout.TOP));
            this.width = jSONObject.has("width") ? Math.abs(ah.L(jSONObject.optInt("width"))) : -1;
            this.height = jSONObject.has("height") ? Math.abs(ah.L(jSONObject.optInt("height"))) : -1;
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (this.left == Integer.MIN_VALUE || this.top == Integer.MIN_VALUE) ? false : true;
    }
}
