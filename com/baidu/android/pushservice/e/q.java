package com.baidu.android.pushservice.e;

import android.content.Context;
import com.baidu.android.pushservice.PushConstants;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class q extends c {
    public q(l lVar, Context context) {
        super(lVar, context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.e.a
    public void a(HashMap<String, String> hashMap) {
        super.a(hashMap);
        hashMap.put(PushConstants.EXTRA_METHOD, "glist");
        com.baidu.android.pushservice.g.a.c("Glist", "Glist param -- " + b.a(hashMap));
    }
}
