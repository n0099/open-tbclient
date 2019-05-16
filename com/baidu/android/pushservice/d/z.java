package com.baidu.android.pushservice.d;

import android.content.Context;
import android.os.Build;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class z extends d {
    public z(l lVar, Context context) {
        super(lVar, context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.d.a
    public void a(HashMap<String, String> hashMap) {
        super.a(hashMap);
        hashMap.put("method", "unbind");
        hashMap.put("model", t.a(this.a) + "");
        if (com.baidu.android.pushservice.b.d.b(this.a)) {
            hashMap.put("new_channel_id", com.baidu.android.pushservice.i.a(this.a).c());
        }
        hashMap.put("app_alone_conn", (com.baidu.android.pushservice.a.d(this.a) ? 1 : 0) + "");
        hashMap.put("manufacture", Build.MANUFACTURER);
        hashMap.put("proxy_mode", (com.baidu.android.pushservice.b.d.c(this.a) ? 1 : 0) + "");
    }
}
