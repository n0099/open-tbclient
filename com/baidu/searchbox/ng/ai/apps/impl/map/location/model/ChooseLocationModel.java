package com.baidu.searchbox.ng.ai.apps.impl.map.location.model;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.MapModel;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ChooseLocationModel extends MapModel {
    private static final String CB = "cb";
    public String callBack = "";

    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.model.MapModel, com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.callBack = jSONObject.optString("cb");
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
    public boolean isValid() {
        return !TextUtils.isEmpty(this.callBack);
    }
}
