package com.baidu.android.pushservice.e;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes3.dex */
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
    @Override // com.baidu.android.pushservice.e.a
    public void a(HashMap<String, String> hashMap) {
        super.a(hashMap);
        hashMap.put("method", "fetch");
        hashMap.put("fetch_type", this.d + "");
        hashMap.put("fetch_num", this.e + "");
    }
}
