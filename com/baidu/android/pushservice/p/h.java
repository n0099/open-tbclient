package com.baidu.android.pushservice.p;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h extends c {
    public String f;

    public h(i iVar, Context context, String str) {
        super(iVar, context);
        this.f = str;
    }

    @Override // com.baidu.android.pushservice.p.a
    public void b(HashMap<String, String> hashMap) {
        super.b(hashMap);
        hashMap.put("method", "deltags");
        hashMap.put("tags", this.f);
    }
}
