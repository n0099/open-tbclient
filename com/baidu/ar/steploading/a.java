package com.baidu.ar.steploading;

import com.baidu.ar.g.i;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
class a {
    private String wF;
    private Map<String, f> wG;

    public a(String str) {
        this.wF = str;
    }

    private Map<String, f> gv() {
        if (this.wG != null) {
            return this.wG;
        }
        this.wG = new HashMap();
        File file = new File(this.wF.concat(File.separator).concat("res_config.json"));
        if (file.exists()) {
            try {
                JSONArray optJSONArray = new JSONObject(i.f(file)).optJSONArray("res");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            f fVar = new f();
                            fVar.wW = optJSONObject.getString("resPath");
                            fVar.wX = optJSONObject.optString("resId");
                            fVar.wY = optJSONObject.optString("encoding");
                            fVar.wZ = optJSONObject.optString("md5");
                            this.wG.put(fVar.wW, fVar);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this.wG;
    }

    public f aK(String str) {
        Map<String, f> gv = gv();
        if (gv.containsKey(str)) {
            return gv.get(str);
        }
        return null;
    }
}
