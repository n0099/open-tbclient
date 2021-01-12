package com.baidu.swan.apps.camera.d;

import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    public String cGN;
    public String cameraId;

    public c(String str) {
        super(PixelReadParams.DEFAULT_FILTER_ID, "cameraId");
        try {
            parseFromJson(new JSONObject(str));
        } catch (JSONException e) {
            com.baidu.swan.apps.console.c.e("Camera", "parsing CameraTakePhotoModel occurs exception", e);
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        this.cameraId = jSONObject.optString("cameraId");
        this.cGN = jSONObject.optString("quality");
    }
}
