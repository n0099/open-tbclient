package com.baidu.swan.pms.node.b;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {
    private final Set<String> exd;
    private final String mVersion;

    public f(String str, Set<String> set) {
        this.mVersion = str;
        this.exd = set;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public Set<String> bdI() {
        return this.exd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f cW(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("version");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("appkeys");
                HashSet hashSet = new HashSet();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString2 = optJSONArray.optString(i);
                    if (!TextUtils.isEmpty(optString2)) {
                        hashSet.add(optString2);
                    }
                }
                return new f(optString, hashSet);
            }
        }
        return null;
    }
}
