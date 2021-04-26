package com.alipay.sdk.app.statistic;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.packet.impl.d;
import com.alipay.sdk.util.j;
import java.io.IOException;
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1804a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1805b;

    public b(Context context, String str) {
        this.f1804a = context;
        this.f1805b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar = new d();
        try {
            String b2 = j.b(this.f1804a, a.f1802a, null);
            if (!TextUtils.isEmpty(b2) && dVar.a(this.f1804a, b2) != null) {
                j.b(this.f1804a, a.f1802a);
            }
        } catch (Throwable unused) {
        }
        try {
            if (TextUtils.isEmpty(this.f1805b)) {
                return;
            }
            dVar.a(this.f1804a, this.f1805b);
        } catch (IOException unused2) {
            j.a(this.f1804a, a.f1802a, this.f1805b);
        } catch (Throwable unused3) {
        }
    }
}
