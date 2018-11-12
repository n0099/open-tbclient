package com.baidu.searchbox.ng.ai.apps.impl.map.model;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.element.CoordinateModel;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class IncludePointsModel extends MapModel {
    private static final String PADDING = "padding";
    private static final String POINTS = "points";
    public int[] padding = {0, 0, 0, 0};
    public ArrayList<CoordinateModel> points;

    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.model.MapModel, com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has(POINTS) && (jSONArray2 = jSONObject.getJSONArray(POINTS)) != null && jSONArray2.length() > 0) {
                int length = jSONArray2.length();
                this.points = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i);
                    if (jSONObject2 != null) {
                        CoordinateModel coordinateModel = new CoordinateModel();
                        coordinateModel.parseFromJson(jSONObject2);
                        if (coordinateModel.isValid()) {
                            this.points.add(coordinateModel);
                        }
                    }
                }
            }
            if (jSONObject.has(PADDING) && (jSONArray = jSONObject.getJSONArray(PADDING)) != null && jSONArray.length() > 0) {
                int min = Math.min(jSONArray.length(), 4);
                for (int i2 = 0; i2 < min; i2++) {
                    this.padding[i2] = AiAppsUIUtils.dp2px(jSONArray.optInt(i2));
                }
            }
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
    public boolean isValid() {
        return (TextUtils.isEmpty(this.slaveId) || TextUtils.isEmpty(this.id) || this.points == null || this.points.size() <= 0) ? false : true;
    }
}
