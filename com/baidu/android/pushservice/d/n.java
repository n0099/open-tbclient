package com.baidu.android.pushservice.d;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes3.dex */
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
    @Override // com.baidu.android.pushservice.d.a
    public void a(HashMap<String, String> hashMap) {
        super.a(hashMap);
        hashMap.put("method", "fetchgmsg");
        hashMap.put("gid", this.f);
        hashMap.put("fetch_type", this.d + "");
        hashMap.put("fetch_num", this.e + "");
    }
}
