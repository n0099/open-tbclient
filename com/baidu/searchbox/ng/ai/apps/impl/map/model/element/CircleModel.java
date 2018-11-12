package com.baidu.searchbox.ng.ai.apps.impl.map.model.element;

import com.baidu.searchbox.ng.ai.apps.impl.map.utils.MapUtils;
import com.baidu.searchbox.ng.ai.apps.model.IModel;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CircleModel implements IModel {
    private static final String COLOR = "color";
    private static final boolean DEBUG = false;
    private static final String FILL_COLOR = "fillColor";
    private static final String RADIUS = "radius";
    private static final String STROKE_WIDTH = "strokeWidth";
    private static final String TAG = CircleModel.class.getSimpleName();
    public CoordinateModel coordinate;
    public int color = 0;
    public int fillColor = -16777216;
    public int radius = -1;
    public float strokeWidth = 0.0f;

    @Override // com.baidu.searchbox.ng.ai.apps.model.IModel
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has(RADIUS)) {
            this.coordinate = new CoordinateModel();
            this.coordinate.parseFromJson(jSONObject);
            if (this.coordinate.isValid()) {
                this.color = MapUtils.convertColorSafe(jSONObject.optString(COLOR), 0);
                this.fillColor = MapUtils.convertColorSafe(jSONObject.optString(FILL_COLOR), -16777216);
                this.radius = jSONObject.optInt(RADIUS, -1);
                this.strokeWidth = Math.abs(MapUtils.dp2px(jSONObject.optDouble(STROKE_WIDTH, 0.0d)));
            }
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.model.IModel
    public boolean isValid() {
        return (this.coordinate == null || !this.coordinate.isValid() || this.radius == -1) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("coordinate ->").append(this.coordinate).append("color ->").append(this.color).append("fillColor ->").append(this.fillColor).append("radius ->").append(this.radius).append("strokeWidth ->").append(this.strokeWidth);
        return sb.toString();
    }
}
