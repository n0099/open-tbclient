package com.baidu.android.pushservice.d;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class aa extends d {
    public aa(l lVar, Context context) {
        super(lVar, context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.d.a
    public void a(HashMap<String, String> hashMap) {
        b.a(hashMap);
        hashMap.put("method", "unbindapp");
        hashMap.put("appid", this.b.f);
    }
}
