package com.baidu.swan.config.d;

import com.baidu.android.imsdk.db.TableDefine;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.config.core.b.a {
    @Override // com.baidu.swan.config.core.b.c
    public void bu(JSONObject jSONObject) {
        int optInt;
        JSONArray optJSONArray;
        JSONObject bt = bt(jSONObject);
        if (bt != null && (optInt = bt.optInt("version")) > 0 && (optJSONArray = bt.optJSONArray(TableDefine.MessageColumns.COLUME_TIPS)) != null) {
            HashMap<String, String> hashMap = new HashMap<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                hashMap.put(optJSONObject.optString("tipno"), optJSONObject.optString("tipmsg"));
            }
            c.art().c(hashMap, optInt);
        }
    }
}
