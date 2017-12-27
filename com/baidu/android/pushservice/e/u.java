package com.baidu.android.pushservice.e;

import android.content.Context;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class u extends d {
    protected String e;

    public u(l lVar, Context context, String str) {
        super(lVar, context);
        this.e = null;
        this.e = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.e.a
    public void a(HashMap<String, String> hashMap) {
        super.a(hashMap);
        hashMap.put("method", "sendmsgtoserver");
        if (this.e != null) {
            try {
                JSONObject jSONObject = new JSONObject(this.e);
                if (jSONObject.has("to")) {
                    hashMap.put("cb_url", jSONObject.getString("to"));
                }
                if (jSONObject.has("data")) {
                    hashMap.put("cb_data", jSONObject.getString("data"));
                }
            } catch (JSONException e) {
            }
        }
    }
}
