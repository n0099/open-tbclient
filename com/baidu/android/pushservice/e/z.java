package com.baidu.android.pushservice.e;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class z extends d {
    public z(l lVar, Context context) {
        super(lVar, context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.e.a
    public void a(HashMap<String, String> hashMap) {
        super.a(hashMap);
        hashMap.put("method", "unbind");
        hashMap.put("model", t.a(this.a) + "");
        if (com.baidu.android.pushservice.c.e.b(this.a)) {
            hashMap.put("new_channel_id", com.baidu.android.pushservice.j.a(this.a).c());
        }
        hashMap.put("app_alone_conn", (com.baidu.android.pushservice.a.d(this.a) ? 1 : 0) + "");
    }
}
