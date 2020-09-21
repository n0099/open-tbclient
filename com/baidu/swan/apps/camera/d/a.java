package com.baidu.swan.apps.camera.d;

import android.text.TextUtils;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends com.baidu.swan.apps.component.b.b {
    private String caM;
    public String caN;
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
        this.caM = jSONObject.optString("flash", "auto");
        this.caN = jSONObject.optString("cameraId");
    }

    public boolean isFrontCamera() {
        return TextUtils.equals(this.devicePosition, "front");
    }

    public String adn() {
        return C0363a.kK(this.caM);
    }

    public int getWidth() {
        if (this.cdd == null) {
            return 0;
        }
        return this.cdd.getWidth();
    }

    public int getHeight() {
        if (this.cdd == null) {
            return 0;
        }
        return this.cdd.getHeight();
    }

    /* renamed from: com.baidu.swan.apps.camera.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0363a {
        static String kK(String str) {
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
