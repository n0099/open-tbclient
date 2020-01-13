package com.baidu.android.pushservice.d;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class i extends c {
    protected String d;

    public i(l lVar, Context context, String str) {
        super(lVar, context);
        this.d = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.d.a
    public void a(HashMap<String, String> hashMap) {
        super.a(hashMap);
        hashMap.put("method", "gmsgcount");
        hashMap.put("gid", this.d);
    }
}
