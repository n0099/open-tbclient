package com.baidu.android.pushservice.e;

import android.content.Context;
import com.baidu.android.pushservice.PushConstants;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class n extends c {
    int d;
    int e;
    String f;

    public n(l lVar, Context context, String str, int i, int i2) {
        super(lVar, context);
        this.d = 1;
        this.e = 1;
        this.f = str;
        this.d = i;
        this.e = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.e.a
    public void a(HashMap<String, String> hashMap) {
        super.a(hashMap);
        hashMap.put(PushConstants.EXTRA_METHOD, "fetchgmsg");
        hashMap.put("gid", this.f);
        hashMap.put("fetch_type", this.d + "");
        hashMap.put("fetch_num", this.e + "");
        com.baidu.android.pushservice.g.a.c("FetchGmsg", "FETCHGmsg param -- " + b.a(hashMap));
    }
}
