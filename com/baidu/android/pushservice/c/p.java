package com.baidu.android.pushservice.c;

import android.content.Context;
import com.baidu.android.pushservice.PushConstants;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class p extends c {
    protected String d;

    public p(l lVar, Context context, String str) {
        super(lVar, context);
        this.d = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.c.a
    public void a(HashMap<String, String> hashMap) {
        super.a(hashMap);
        hashMap.put(PushConstants.EXTRA_METHOD, "ginfo");
        hashMap.put("gid", this.d);
        com.baidu.android.pushservice.e.a.c("Ginfo", "Ginfo param -- " + b.a(hashMap));
    }
}
