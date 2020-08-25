package com.baidu.swan.apps.camera.d;

import android.text.TextUtils;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends com.baidu.swan.apps.component.b.b {
    private String bYH;
    public String bYI;
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
        this.bYH = jSONObject.optString("flash", "auto");
        this.bYI = jSONObject.optString("cameraId");
    }

    public boolean isFrontCamera() {
        return TextUtils.equals(this.devicePosition, "front");
    }

    public String acE() {
        return C0368a.kq(this.bYH);
    }

    public int getWidth() {
        if (this.caX == null) {
            return 0;
        }
        return this.caX.getWidth();
    }

    public int getHeight() {
        if (this.caX == null) {
            return 0;
        }
        return this.caX.getHeight();
    }

    /* renamed from: com.baidu.swan.apps.camera.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private static class C0368a {
        static String kq(String str) {
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
