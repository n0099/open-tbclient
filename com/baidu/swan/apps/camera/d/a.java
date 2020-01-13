package com.baidu.swan.apps.camera.d;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends com.baidu.swan.apps.component.b.b {
    private String bbJ;
    public String bbK;
    private String devicePosition;

    public a(String str) {
        super("camera", "cameraId");
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
        this.bbJ = jSONObject.optString("flash", "auto");
        this.bbK = jSONObject.optString("cameraId");
    }

    public boolean isFrontCamera() {
        return TextUtils.equals(this.devicePosition, "front");
    }

    public String HS() {
        return C0220a.fW(this.bbJ);
    }

    public int getWidth() {
        if (this.bdZ == null) {
            return 0;
        }
        return this.bdZ.getWidth();
    }

    public int getHeight() {
        if (this.bdZ == null) {
            return 0;
        }
        return this.bdZ.getHeight();
    }

    /* renamed from: com.baidu.swan.apps.camera.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private static class C0220a {
        static String fW(String str) {
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
