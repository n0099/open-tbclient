package com.baidu.ar.steploading;

import com.baidu.ar.f.g;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
class a {
    private String wc;
    private Map<String, f> wd;

    public a(String str) {
        this.wc = str;
    }

    private Map<String, f> fh() {
        if (this.wd != null) {
            return this.wd;
        }
        this.wd = new HashMap();
        File file = new File(this.wc.concat(File.separator).concat("res_config.json"));
        if (file.exists()) {
            try {
                JSONArray optJSONArray = new JSONObject(g.f(file)).optJSONArray("res");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            f fVar = new f();
                            fVar.wt = optJSONObject.getString("resPath");
                            fVar.wu = optJSONObject.optString("resId");
                            fVar.wv = optJSONObject.optString("encoding");
                            fVar.ww = optJSONObject.optString("md5");
                            this.wd.put(fVar.wt, fVar);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this.wd;
    }

    public f aG(String str) {
        Map<String, f> fh = fh();
        if (fh.containsKey(str)) {
            return fh.get(str);
        }
        return null;
    }
}
