package com.baidu.sofire.k;

import android.content.Context;
import android.content.ServiceConnection;
import android.text.TextUtils;
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    Context f5291a;

    /* renamed from: b  reason: collision with root package name */
    c f5292b;
    ServiceConnection c;
    private com.baidu.sofire.j.c d;
    private String e;

    public a(Context context, com.baidu.sofire.j.c cVar) {
        this.f5291a = null;
        this.f5291a = context;
        this.d = cVar;
    }

    public final String a() {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (TextUtils.isEmpty(this.e)) {
            if (this.f5292b != null) {
                this.e = this.f5292b.a();
            }
            return this.e;
        }
        return this.e;
    }
}
