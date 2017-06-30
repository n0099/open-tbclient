package com.baidu.android.pushservice.e;

import android.content.Context;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class k extends c {
    String[] d;

    public k(l lVar, Context context, String[] strArr) {
        super(lVar, context);
        this.d = strArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.e.a
    public void a(HashMap<String, String> hashMap) {
        super.a(hashMap);
        int length = this.d.length;
        if (length == 0) {
            a(30602);
            com.baidu.android.pushservice.g.a.c("Delete", "Delete param -- msgIds == null");
            return;
        }
        hashMap.put(PushConstants.EXTRA_METHOD, WriteImageActivityConfig.DELET_FLAG);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < length; i++) {
            jSONArray.put(this.d[i]);
        }
        hashMap.put("msg_ids", jSONArray.toString());
        com.baidu.android.pushservice.g.a.c("Delete", "Delete param -- " + b.a(hashMap));
    }
}
