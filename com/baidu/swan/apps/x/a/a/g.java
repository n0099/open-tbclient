package com.baidu.swan.apps.x.a.a;

import com.baidu.swan.apps.an.x;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g implements com.baidu.swan.apps.model.a {
    public int left = Integer.MIN_VALUE;
    public int top = Integer.MIN_VALUE;
    public int width = -1;
    public int height = -1;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has(CustomDialogData.POS_LEFT) && jSONObject.has("top")) {
            this.left = x.ad(jSONObject.optInt(CustomDialogData.POS_LEFT));
            this.top = x.ad(jSONObject.optInt("top"));
            this.width = jSONObject.has("width") ? Math.abs(x.ad(jSONObject.optInt("width"))) : -1;
            this.height = jSONObject.has("height") ? Math.abs(x.ad(jSONObject.optInt("height"))) : -1;
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (this.left == Integer.MIN_VALUE || this.top == Integer.MIN_VALUE) ? false : true;
    }
}
