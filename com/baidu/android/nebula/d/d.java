package com.baidu.android.nebula.d;

import android.content.Context;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f557a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.f557a = aVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        a aVar = this.f557a;
        context = this.f557a.c;
        String b = aVar.b(context);
        if (TextUtils.isEmpty(b)) {
            this.f557a.b = (byte) 0;
            return;
        }
        this.f557a.f553a = b;
        this.f557a.b = (byte) 2;
    }
}
