package com.baidu.searchbox.ng.ai.apps.impl.map.location.model;

import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.MapModel;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class WalkNavigationModel extends MapModel {
    private static final String CB = "cb";
    private static final String LATITUDE = "latitude";
    private static final String LONGITUDE = "longitude";
    public String callBack = "";
    public LatLng endPt;

    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.model.MapModel, com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.callBack = jSONObject.optString("cb");
            double optDouble = jSONObject.optDouble("latitude");
            double optDouble2 = jSONObject.optDouble("longitude");
            if (!Double.isNaN(optDouble) && !Double.isNaN(optDouble2) && optDouble >= -90.0d && optDouble <= 90.0d && optDouble2 >= -180.0d && optDouble2 <= 180.0d) {
                this.endPt = new LatLng(optDouble, optDouble2);
            }
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
    public boolean isValid() {
        return this.endPt != null;
    }
}
