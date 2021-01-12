package com.baidu.swan.apps.component.a.b;

import androidx.annotation.NonNull;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends com.baidu.swan.apps.component.a.d.b {
    public String cIE;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.cIE = "";
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.cIE = jSONObject.optString(UserAccountActionItem.KEY_SRC);
        }
    }
}
