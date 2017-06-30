package com.baidu.android.pushservice.e;

import android.content.Context;
import com.baidu.android.pushservice.PushConstants;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class z extends d {
    public z(l lVar, Context context) {
        super(lVar, context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.e.a
    public void a(HashMap<String, String> hashMap) {
        b.b(hashMap);
        hashMap.put(PushConstants.EXTRA_METHOD, "unbindapp");
        hashMap.put("appid", this.b.f);
        com.baidu.android.pushservice.g.a.c("UnbindApp", "UNBINDAPP param -- " + b.a(hashMap));
    }
}
