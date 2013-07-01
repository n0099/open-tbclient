package com.baidu.android.nebula.d;

import android.content.Context;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f287a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.f287a = aVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        a aVar = this.f287a;
        context = this.f287a.c;
        String b = aVar.b(context);
        if (TextUtils.isEmpty(b)) {
            this.f287a.b = (byte) 0;
            return;
        }
        this.f287a.f283a = b;
        this.f287a.b = (byte) 2;
    }
}
