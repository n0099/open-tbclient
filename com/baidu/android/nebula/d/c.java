package com.baidu.android.nebula.d;

import android.content.Context;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends Thread {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        a aVar = this.a;
        context = this.a.c;
        String b = aVar.b(context);
        if (TextUtils.isEmpty(b)) {
            this.a.b = (byte) 0;
            return;
        }
        this.a.a = b;
        this.a.b = (byte) 2;
    }
}
