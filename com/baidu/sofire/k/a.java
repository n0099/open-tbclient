package com.baidu.sofire.k;

import android.content.Context;
import android.content.ServiceConnection;
import android.text.TextUtils;
/* loaded from: classes15.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    Context f5573a;

    /* renamed from: b  reason: collision with root package name */
    c f5574b;
    ServiceConnection c;
    private com.baidu.sofire.j.c d;
    private String e;

    public a(Context context, com.baidu.sofire.j.c cVar) {
        this.f5573a = null;
        this.f5573a = context;
        this.d = cVar;
    }

    public final String a() {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (TextUtils.isEmpty(this.e)) {
            if (this.f5574b != null) {
                this.e = this.f5574b.a();
            }
            return this.e;
        }
        return this.e;
    }
}
