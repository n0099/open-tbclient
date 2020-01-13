package com.baidu.android.pushservice.d;

import android.content.Context;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class k extends c {
    private String[] d;

    public k(l lVar, Context context, String[] strArr) {
        super(lVar, context);
        this.d = strArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.d.a
    public void a(HashMap<String, String> hashMap) {
        super.a(hashMap);
        int length = this.d.length;
        if (length == 0) {
            a(30602);
            return;
        }
        hashMap.put("method", "delete");
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < length; i++) {
            jSONArray.put(this.d[i]);
        }
        hashMap.put("msg_ids", jSONArray.toString());
    }
}
