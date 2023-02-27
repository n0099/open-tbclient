package com.baidu.ar.steploading;

import com.baidu.ar.h.i;
import com.baidu.searchbox.pms.db.PackageTable;
import com.facebook.common.util.UriUtil;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import okhttp3.internal.http2.Http2Codec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public String xt;
    public Map<String, f> xu;

    public a(String str) {
        this.xt = str;
    }

    private Map<String, f> gv() {
        Map<String, f> map = this.xu;
        if (map != null) {
            return map;
        }
        this.xu = new HashMap();
        File file = new File(this.xt.concat(File.separator).concat("res_config.json"));
        if (file.exists()) {
            try {
                JSONArray optJSONArray = new JSONObject(i.f(file)).optJSONArray(UriUtil.LOCAL_RESOURCE_SCHEME);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            f fVar = new f();
                            fVar.xK = optJSONObject.getString("resPath");
                            fVar.xL = optJSONObject.optString("resId");
                            fVar.xM = optJSONObject.optString(Http2Codec.ENCODING);
                            fVar.xN = optJSONObject.optString(PackageTable.MD5);
                            this.xu.put(fVar.xK, fVar);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this.xu;
    }

    public f aN(String str) {
        Map<String, f> gv = gv();
        if (gv.containsKey(str)) {
            return gv.get(str);
        }
        return null;
    }
}
