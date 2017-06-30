package com.baidu.android.pushservice.e;

import android.content.Context;
import com.baidu.android.pushservice.PushConstants;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class i extends c {
    protected String d;

    public i(l lVar, Context context, String str) {
        super(lVar, context);
        this.d = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.e.a
    public void a(HashMap<String, String> hashMap) {
        super.a(hashMap);
        hashMap.put(PushConstants.EXTRA_METHOD, "gmsgcount");
        hashMap.put("gid", this.d);
        com.baidu.android.pushservice.g.a.c("CountGmsg", "CountGmsg param -- " + b.a(hashMap));
    }
}
