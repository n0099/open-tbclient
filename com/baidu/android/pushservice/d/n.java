package com.baidu.android.pushservice.d;

import android.content.Context;
import android.os.Build;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class n extends d {
    public n(i iVar, Context context) {
        super(iVar, context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.d.a
    public void a(HashMap<String, String> hashMap) {
        super.a(hashMap);
        hashMap.put("method", "unbind");
        hashMap.put("model", l.a(this.f1257a) + "");
        if (com.baidu.android.pushservice.b.d.b(this.f1257a)) {
            hashMap.put("new_channel_id", com.baidu.android.pushservice.j.a(this.f1257a).c());
        }
        hashMap.put("app_alone_conn", (com.baidu.android.pushservice.b.d.e(this.f1257a) ? 1 : 0) + "");
        hashMap.put("manufacture", Build.MANUFACTURER);
        hashMap.put("proxy_mode", (com.baidu.android.pushservice.b.d.c(this.f1257a) ? 1 : 0) + "");
    }
}
