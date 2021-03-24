package com.alipay.sdk.app.statistic;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.packet.impl.d;
import com.alipay.sdk.util.j;
import java.io.IOException;
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1833a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1834b;

    public b(Context context, String str) {
        this.f1833a = context;
        this.f1834b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar = new d();
        try {
            String b2 = j.b(this.f1833a, a.f1831a, null);
            if (!TextUtils.isEmpty(b2) && dVar.a(this.f1833a, b2) != null) {
                j.b(this.f1833a, a.f1831a);
            }
        } catch (Throwable unused) {
        }
        try {
            if (TextUtils.isEmpty(this.f1834b)) {
                return;
            }
            dVar.a(this.f1833a, this.f1834b);
        } catch (IOException unused2) {
            j.a(this.f1833a, a.f1831a, this.f1834b);
        } catch (Throwable unused3) {
        }
    }
}
