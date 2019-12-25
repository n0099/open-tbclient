package com.baidu.android.pushservice.d;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class r extends c {
    protected String d;

    public r(l lVar, Context context, String str) {
        super(lVar, context);
        this.d = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.d.a
    public void a(HashMap<String, String> hashMap) {
        super.a(hashMap);
        hashMap.put("method", "gunbind");
        hashMap.put("gid", this.d);
    }
}
