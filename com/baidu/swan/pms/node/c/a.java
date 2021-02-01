package com.baidu.swan.pms.node.c;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.pms.node.Node;
import com.tencent.open.SocialOperation;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
class a {
    final String dOr;
    final int evF;
    final int evG;
    final String evH;
    final Set<String> evI;
    final String evJ;
    final String mContentType;
    final String mVersion;

    public a(String str, int i, int i2, String str2, String str3, String str4, Set<String> set, String str5) {
        this.mContentType = str;
        this.evG = i2;
        this.evF = i;
        this.dOr = str2;
        this.evH = str3;
        this.mVersion = str4;
        this.evI = set;
        this.evJ = str5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a cV(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d(Node.TAG, "host info " + jSONObject.toString());
        }
        try {
            String optString = jSONObject.optString("version");
            if (!TextUtils.isEmpty(optString) && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                String optString2 = optJSONObject.optString("content_type");
                int optInt = optJSONObject.optInt("official_no");
                int optInt2 = optJSONObject.optInt("container_no");
                String optString3 = optJSONObject.optString("host_name");
                String optString4 = optJSONObject.optString("share_callback_url");
                JSONArray optJSONArray = optJSONObject.optJSONArray(SocialOperation.GAME_SIGNATURE);
                String optString5 = optJSONObject.optString("scheme_head");
                HashSet hashSet = new HashSet();
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        String optString6 = optJSONArray.optString(i);
                        if (!TextUtils.isEmpty(optString6)) {
                            hashSet.add(optString6);
                        }
                    }
                }
                if (hashSet.size() <= 0) {
                    hashSet = null;
                }
                return new a(optString2, optInt, optInt2, optString3, optString4, optString, hashSet, optString5);
            }
            return null;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }
}
