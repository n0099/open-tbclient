package com.baidu.android.pushservice.d;

import android.content.Context;
import android.os.Build;
import java.util.HashMap;
/* loaded from: classes.dex */
public class n extends d {
    public n(i iVar, Context context) {
        super(iVar, context);
    }

    @Override // com.baidu.android.pushservice.d.a
    public void b(HashMap<String, String> hashMap) {
        super.b(hashMap);
        hashMap.put("method", "unbind");
        hashMap.put("model", l.a(((a) this).f2978a) + "");
        if (com.baidu.android.pushservice.b.d.b(((a) this).f2978a)) {
            hashMap.put("new_channel_id", com.baidu.android.pushservice.k.a(((a) this).f2978a).c());
        }
        hashMap.put("app_alone_conn", (com.baidu.android.pushservice.b.d.e(((a) this).f2978a) ? 1 : 0) + "");
        hashMap.put("manufacture", Build.MANUFACTURER);
        hashMap.put("proxy_mode", (com.baidu.android.pushservice.b.d.c(((a) this).f2978a) ? 1 : 0) + "");
    }
}
