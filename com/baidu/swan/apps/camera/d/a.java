package com.baidu.swan.apps.camera.d;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends com.baidu.swan.apps.model.a.a.a {
    private String alA;
    private String alB;
    public String alC;

    public a(String str) {
        super("cameraId", "camera");
        try {
            parseFromJson(new JSONObject(str));
        } catch (JSONException e) {
            com.baidu.swan.apps.console.c.e("Camera", "parsing CameraAttrModel occurs exception", e);
        }
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        this.alA = jSONObject.optString("devicePosition", "back");
        this.alB = jSONObject.optString("flash", "auto");
        this.alC = jSONObject.optString("cameraId");
    }

    public boolean isFrontCamera() {
        return TextUtils.equals(this.alA, "front");
    }

    public String xJ() {
        return C0124a.dl(this.alB);
    }

    public int getWidth() {
        return this.aDW.getWidth();
    }

    public int getHeight() {
        return this.aDW.getHeight();
    }

    /* renamed from: com.baidu.swan.apps.camera.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0124a {
        static String dl(String str) {
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
