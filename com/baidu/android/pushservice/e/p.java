package com.baidu.android.pushservice.e;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class p extends c {
    protected String d;

    public p(l lVar, Context context, String str) {
        super(lVar, context);
        this.d = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.e.a
    public void a(HashMap<String, String> hashMap) {
        super.a(hashMap);
        hashMap.put("method", "ginfo");
        hashMap.put("gid", this.d);
    }
}
