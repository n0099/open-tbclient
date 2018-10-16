package com.baidu.searchbox.ng.ai.apps.camera.model;

import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CameraModel extends AiAppsNaViewModel {
    private static final String KEY_CAMERA_ID = "cameraId";
    public String cameraId;

    public CameraModel(String str) {
        super(KEY_CAMERA_ID, "camera");
        try {
            parseFromJson(new JSONObject(str));
        } catch (JSONException e) {
            AiAppsLog.e("Camera", "parsing CameraModel occurs exception", e);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        this.cameraId = jSONObject.optString(KEY_CAMERA_ID);
    }
}
