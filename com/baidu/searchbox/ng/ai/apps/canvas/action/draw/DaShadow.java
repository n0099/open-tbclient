package com.baidu.searchbox.ng.ai.apps.canvas.action.draw;

import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
class DaShadow implements Cloneable {
    int mBlur;
    DaColor mColor;
    int mOffsetX;
    int mOffsetY;

    public DaShadow() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DaShadow(JSONArray jSONArray) {
        parseFrom(jSONArray);
    }

    public boolean isValid() {
        return this.mColor != null && this.mColor.isValid();
    }

    public void parseFrom(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 3) {
                this.mOffsetX = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(0));
                this.mOffsetY = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(1));
                this.mBlur = jSONArray.optInt(2);
                this.mColor = new DaColor(jSONArray.optJSONArray(3));
            }
        } catch (Exception e) {
        }
    }
}
