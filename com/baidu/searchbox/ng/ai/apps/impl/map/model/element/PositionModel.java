package com.baidu.searchbox.ng.ai.apps.impl.map.model.element;

import com.baidu.searchbox.ng.ai.apps.model.IModel;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PositionModel implements IModel {
    private static final String HEIGHT = "height";
    private static final String LEFT = "left";
    private static final String TOP = "top";
    private static final String WIDTH = "width";
    public int left = Integer.MIN_VALUE;
    public int top = Integer.MIN_VALUE;
    public int width = -1;
    public int height = -1;

    @Override // com.baidu.searchbox.ng.ai.apps.model.IModel
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("left") && jSONObject.has("top")) {
            this.left = AiAppsUIUtils.dp2px(jSONObject.optInt("left"));
            this.top = AiAppsUIUtils.dp2px(jSONObject.optInt("top"));
            this.width = jSONObject.has("width") ? Math.abs(AiAppsUIUtils.dp2px(jSONObject.optInt("width"))) : -1;
            this.height = jSONObject.has("height") ? Math.abs(AiAppsUIUtils.dp2px(jSONObject.optInt("height"))) : -1;
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.model.IModel
    public boolean isValid() {
        return (this.left == Integer.MIN_VALUE || this.top == Integer.MIN_VALUE) ? false : true;
    }
}
