package com.baidu.searchbox.ng.ai.apps.impl.map.model;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.element.CoordinateModel;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class TranslateMarkerModel extends MapModel {
    private static final String AUTO_ROTATE = "autoRotate";
    private static final String DESTINATION = "destination";
    private static final String DURATION = "duration";
    private static final String MARK_ID = "markerId";
    private static final String ROTATE = "rotate";
    public CoordinateModel coordinate;
    public boolean isAutoRotate;
    public double rotate;
    public String markId = "";
    public int duration = 1000;

    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.model.MapModel, com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.markId = jSONObject.optString("markerId");
            this.coordinate = new CoordinateModel();
            this.coordinate.parseFromJson(jSONObject.optJSONObject(DESTINATION));
            this.isAutoRotate = jSONObject.optBoolean(AUTO_ROTATE);
            this.rotate = jSONObject.optDouble("rotate");
            this.duration = Math.abs(jSONObject.optInt("duration", this.duration));
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
    public boolean isValid() {
        return (TextUtils.isEmpty(this.slaveId) || TextUtils.isEmpty(this.id) || TextUtils.isEmpty(this.markId) || this.coordinate == null || !this.coordinate.isValid()) ? false : true;
    }
}
