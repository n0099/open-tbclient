package com.airbnb.lottie;

import com.baidu.mobstat.Config;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g {
    private final String fileName;
    private final int height;
    private final String id;
    private final String of;
    private final int width;

    private g(int i, int i2, String str, String str2, String str3) {
        this.width = i;
        this.height = i2;
        this.id = str;
        this.fileName = str2;
        this.of = str3;
    }

    /* loaded from: classes2.dex */
    static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static g i(JSONObject jSONObject) {
            return new g(jSONObject.optInt(Config.DEVICE_WIDTH), jSONObject.optInt("h"), jSONObject.optString("id"), jSONObject.optString("p"), jSONObject.optString("u"));
        }
    }

    public String getId() {
        return this.id;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String cX() {
        return this.of;
    }
}
