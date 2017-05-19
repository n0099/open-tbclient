package com.baidu.android.pushservice.c;

import android.content.Context;
import com.baidu.android.pushservice.PushConstants;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class m extends c {
    int d;
    int e;

    public m(l lVar, Context context, int i, int i2) {
        super(lVar, context);
        this.d = 1;
        this.e = 1;
        this.d = i;
        this.e = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.c.a
    public void a(HashMap<String, String> hashMap) {
        super.a(hashMap);
        hashMap.put(PushConstants.EXTRA_METHOD, "fetch");
        hashMap.put("fetch_type", this.d + "");
        hashMap.put("fetch_num", this.e + "");
        com.baidu.android.pushservice.e.a.c("Fetch", "FETCH param -- " + b.a(hashMap));
    }
}
