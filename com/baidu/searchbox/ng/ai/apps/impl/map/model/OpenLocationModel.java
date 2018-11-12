package com.baidu.searchbox.ng.ai.apps.impl.map.model;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class OpenLocationModel extends MapModel {
    public static final String ADDRESS = "address";
    public static final String NAME = "name";
    public String name = "";
    public String address = "";

    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.model.MapModel, com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("scale")) {
                this.scale = jSONObject.optDouble("scale", 18.0d);
            }
            if (jSONObject.has("name")) {
                this.name = jSONObject.optString("name");
            }
            if (jSONObject.has(ADDRESS)) {
                this.address = jSONObject.optString(ADDRESS);
            }
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
    public boolean isValid() {
        return (TextUtils.isEmpty(this.slaveId) || this.coordinate == null || !this.coordinate.isValid()) ? false : true;
    }
}
