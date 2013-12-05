package com.baidu.android.nebula.c;

import android.content.Context;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f669a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f669a = aVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        a aVar = this.f669a;
        context = this.f669a.c;
        String b = aVar.b(context);
        if (TextUtils.isEmpty(b)) {
            this.f669a.b = (byte) 0;
            return;
        }
        this.f669a.f666a = b;
        this.f669a.b = (byte) 2;
    }
}
