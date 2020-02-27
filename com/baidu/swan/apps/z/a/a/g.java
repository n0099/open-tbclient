package com.baidu.swan.apps.z.a.a;

import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.swan.apps.as.af;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class g implements com.baidu.swan.apps.model.a {
    public int left = Integer.MIN_VALUE;

    /* renamed from: top  reason: collision with root package name */
    public int f1008top = Integer.MIN_VALUE;
    public int width = -1;
    public int height = -1;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("left") && jSONObject.has(VerticalTranslateLayout.TOP)) {
            this.left = af.S(jSONObject.optInt("left"));
            this.f1008top = af.S(jSONObject.optInt(VerticalTranslateLayout.TOP));
            this.width = jSONObject.has("width") ? Math.abs(af.S(jSONObject.optInt("width"))) : -1;
            this.height = jSONObject.has("height") ? Math.abs(af.S(jSONObject.optInt("height"))) : -1;
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (this.left == Integer.MIN_VALUE || this.f1008top == Integer.MIN_VALUE) ? false : true;
    }
}
