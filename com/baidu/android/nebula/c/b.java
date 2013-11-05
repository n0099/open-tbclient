package com.baidu.android.nebula.c;

import android.content.Context;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f654a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f654a = aVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        a aVar = this.f654a;
        context = this.f654a.c;
        String b = aVar.b(context);
        if (TextUtils.isEmpty(b)) {
            this.f654a.b = (byte) 0;
            return;
        }
        this.f654a.f651a = b;
        this.f654a.b = (byte) 2;
    }
}
