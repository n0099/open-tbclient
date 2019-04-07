package com.baidu.swan.apps.camera.d;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends com.baidu.swan.apps.model.a.a.a {
    public String akL;

    public b(String str) {
        super("cameraId", "camera");
        try {
            parseFromJson(new JSONObject(str));
        } catch (JSONException e) {
            com.baidu.swan.apps.console.c.e("Camera", "parsing CameraModel occurs exception", e);
        }
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        this.akL = jSONObject.optString("cameraId");
    }
}
