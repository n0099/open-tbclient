package com.baidu.searchbox.ng.ai.apps.impl.map.model.element;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.model.IModel;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ControlModel implements IModel {
    private static final String CLICKABLE = "clickable";
    private static final boolean DEBUG = false;
    private static final String ICON_PATH = "iconPath";
    public static final String ID = "controlId";
    private static final String POSITION = "position";
    private static final String TAG = ControlModel.class.getSimpleName();
    public String id;
    public PositionModel position;
    public String iconPath = "";
    public boolean isClickable = false;

    @Override // com.baidu.searchbox.ng.ai.apps.model.IModel
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("position") && jSONObject.has(ICON_PATH)) {
            this.id = jSONObject.optString(ID);
            this.position = new PositionModel();
            this.position.parseFromJson(jSONObject.optJSONObject("position"));
            this.iconPath = jSONObject.optString(ICON_PATH);
            this.isClickable = jSONObject.optBoolean(CLICKABLE);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.model.IModel
    public boolean isValid() {
        return (this.position == null || !this.position.isValid() || TextUtils.isEmpty(this.iconPath)) ? false : true;
    }
}
