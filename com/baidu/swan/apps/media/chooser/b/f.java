package com.baidu.swan.apps.media.chooser.b;

import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f {
    public String callback;
    public int sourceType = 3;
    public boolean bCY = true;
    public String bCZ = "back";
    public int bDa = 60;

    public static f an(JSONObject jSONObject) {
        f fVar = new f();
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                int i = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    String optString = optJSONArray.optString(i2);
                    char c = 65535;
                    switch (optString.hashCode()) {
                        case -1367751899:
                            if (optString.equals("camera")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 92896879:
                            if (optString.equals("album")) {
                                c = 0;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            i |= 1;
                            break;
                        case 1:
                            i |= 2;
                            break;
                    }
                }
                fVar.sourceType = i;
            }
            fVar.bCY = jSONObject.optBoolean("compressed", true);
            int optInt = jSONObject.optInt("maxDuration", 60);
            if (optInt > 60) {
                optInt = 60;
            }
            fVar.bDa = optInt;
            fVar.bCZ = jSONObject.optString("camera");
            fVar.callback = jSONObject.optString("cb");
        }
        return fVar;
    }
}
