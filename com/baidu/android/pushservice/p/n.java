package com.baidu.android.pushservice.p;

import android.content.Context;
import com.baidu.android.pushservice.util.Utility;
import java.util.HashMap;
/* loaded from: classes.dex */
public class n extends d {
    public n(i iVar, Context context) {
        super(iVar, context);
    }

    @Override // com.baidu.android.pushservice.p.a
    public void b(HashMap<String, String> hashMap) {
        super.b(hashMap);
        hashMap.put("method", "unbind");
        hashMap.put("model", l.a(this.c) + "");
        if (com.baidu.android.pushservice.l.d.o(this.c)) {
            hashMap.put("new_channel_id", com.baidu.android.pushservice.j.a(this.c).c());
        }
        hashMap.put("app_alone_conn", (com.baidu.android.pushservice.l.d.s(this.c) ? 1 : 0) + "");
        hashMap.put("manufacture", Utility.a(this.c, false));
        hashMap.put("proxy_mode", (com.baidu.android.pushservice.l.d.q(this.c) ? 1 : 0) + "");
    }
}
