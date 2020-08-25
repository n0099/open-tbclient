package com.baidu.sofire.k;

import android.content.Context;
import android.content.ServiceConnection;
import android.text.TextUtils;
/* loaded from: classes20.dex */
public final class a {
    Context a;
    c b;
    ServiceConnection c;
    private com.baidu.sofire.j.c d;
    private String e;

    public a(Context context, com.baidu.sofire.j.c cVar) {
        this.a = null;
        this.a = context;
        this.d = cVar;
    }

    public final String a() {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (TextUtils.isEmpty(this.e)) {
            if (this.b != null) {
                this.e = this.b.a();
            }
            return this.e;
        }
        return this.e;
    }
}
