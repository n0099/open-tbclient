package com.baidu.sofire.i;

import android.content.Context;
import android.content.ServiceConnection;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f10271a;

    /* renamed from: b  reason: collision with root package name */
    public c f10272b;

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f10273c;

    /* renamed from: d  reason: collision with root package name */
    public com.baidu.sofire.h.c f10274d;

    /* renamed from: e  reason: collision with root package name */
    public String f10275e;

    public a(Context context, com.baidu.sofire.h.c cVar) {
        this.f10271a = null;
        this.f10271a = context;
        this.f10274d = cVar;
    }

    public final String a() {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (TextUtils.isEmpty(this.f10275e)) {
            if (this.f10272b != null) {
                this.f10275e = this.f10272b.a();
            }
            return this.f10275e;
        }
        return this.f10275e;
    }
}
