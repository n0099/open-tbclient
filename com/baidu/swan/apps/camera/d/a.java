package com.baidu.swan.apps.camera.d;

import android.text.TextUtils;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends com.baidu.swan.apps.component.b.b {
    private String cBz;
    public String cameraId;
    private String devicePosition;

    public a(String str) {
        super(PixelReadParams.DEFAULT_FILTER_ID, "cameraId");
        try {
            parseFromJson(new JSONObject(str));
        } catch (JSONException e) {
            com.baidu.swan.apps.console.c.e("Camera", "parsing CameraAttrModel occurs exception", e);
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        this.devicePosition = jSONObject.optString("devicePosition", "back");
        this.cBz = jSONObject.optString("flash", "auto");
        this.cameraId = jSONObject.optString("cameraId");
    }

    public boolean isFrontCamera() {
        return TextUtils.equals(this.devicePosition, "front");
    }

    public String akt() {
        return C0406a.me(this.cBz);
    }

    public int getWidth() {
        if (this.cDO == null) {
            return 0;
        }
        return this.cDO.getWidth();
    }

    public int getHeight() {
        if (this.cDO == null) {
            return 0;
        }
        return this.cDO.getHeight();
    }

    /* renamed from: com.baidu.swan.apps.camera.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private static class C0406a {
        static String me(String str) {
            char c = 65535;
            switch (str.hashCode()) {
                case 3551:
                    if (str.equals("on")) {
                        c = 2;
                        break;
                    }
                    break;
                case 109935:
                    if (str.equals("off")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3005871:
                    if (str.equals("auto")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                case 2:
                    return str;
                default:
                    return "auto";
            }
        }
    }
}
