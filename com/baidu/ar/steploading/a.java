package com.baidu.ar.steploading;

import com.baidu.ar.f.g;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
class a {
    private String vC;
    private Map<String, f> vD;

    public a(String str) {
        this.vC = str;
    }

    private Map<String, f> eR() {
        if (this.vD != null) {
            return this.vD;
        }
        this.vD = new HashMap();
        File file = new File(this.vC.concat(File.separator).concat("res_config.json"));
        if (file.exists()) {
            try {
                JSONArray optJSONArray = new JSONObject(g.f(file)).optJSONArray("res");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            f fVar = new f();
                            fVar.vT = optJSONObject.getString("resPath");
                            fVar.vU = optJSONObject.optString("resId");
                            fVar.vV = optJSONObject.optString("encoding");
                            fVar.vW = optJSONObject.optString("md5");
                            this.vD.put(fVar.vT, fVar);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this.vD;
    }

    public f aF(String str) {
        Map<String, f> eR = eR();
        if (eR.containsKey(str)) {
            return eR.get(str);
        }
        return null;
    }
}
