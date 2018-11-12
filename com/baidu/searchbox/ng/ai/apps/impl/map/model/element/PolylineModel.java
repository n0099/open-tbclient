package com.baidu.searchbox.ng.ai.apps.impl.map.model.element;

import com.baidu.searchbox.ng.ai.apps.impl.map.utils.MapUtils;
import com.baidu.searchbox.ng.ai.apps.model.IModel;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PolylineModel implements IModel {
    private static final String ARROW_ICON_PATH = "arrowIconPath";
    private static final String ARROW_LINE = "arrowLine";
    private static final String BORDER_COLOR = "borderColor";
    private static final String BORDER_WIDTH = "borderWidth";
    private static final String COLOR = "color";
    private static final boolean DEBUG = false;
    private static final String DOTTED_LINE = "dottedLine";
    private static final String POINTS = "points";
    private static final String TAG = PolylineModel.class.getSimpleName();
    private static final String WIDTH = "width";
    public ArrayList<CoordinateModel> coordinates;
    public int color = 0;
    public float width = 0.0f;
    public boolean isDottedLine = false;
    public boolean isArrowLine = false;
    public String arrowIconPath = "";
    public int borderColor = 0;
    public float borderWidth = 0.0f;

    @Override // com.baidu.searchbox.ng.ai.apps.model.IModel
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has(POINTS)) {
            JSONArray optJSONArray = jSONObject.optJSONArray(POINTS);
            int length = optJSONArray == null ? 0 : optJSONArray.length();
            if (length > 0) {
                this.coordinates = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        CoordinateModel coordinateModel = new CoordinateModel();
                        coordinateModel.parseFromJson(optJSONObject);
                        if (coordinateModel.isValid()) {
                            this.coordinates.add(coordinateModel);
                        }
                    }
                }
            }
            if (this.coordinates != null && this.coordinates.size() > 0) {
                this.color = MapUtils.convertColorSafe(jSONObject.optString(COLOR), 0);
                this.width = Math.abs(MapUtils.dp2px(jSONObject.optDouble("width", 0.0d)));
                this.isDottedLine = jSONObject.optBoolean(DOTTED_LINE, false);
                this.isArrowLine = jSONObject.optBoolean(ARROW_LINE, false);
                this.arrowIconPath = jSONObject.optString(ARROW_ICON_PATH);
                this.borderColor = MapUtils.convertColorSafe(jSONObject.optString(BORDER_COLOR), 0);
                this.borderWidth = Math.abs(MapUtils.dp2px(jSONObject.optDouble(BORDER_WIDTH, 0.0d)));
            }
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.model.IModel
    public boolean isValid() {
        return this.coordinates != null && this.coordinates.size() > 0;
    }
}
