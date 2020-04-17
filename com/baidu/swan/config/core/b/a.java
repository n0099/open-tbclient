package com.baidu.swan.config.core.b;

import com.baidu.android.util.io.BaseJsonData;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public abstract class a implements c {
    /* JADX INFO: Access modifiers changed from: protected */
    public JSONObject bt(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.optInt(BaseJsonData.TAG_ERRNO, -1) == 0) {
            return jSONObject.optJSONObject("data");
        }
        return null;
    }
}
