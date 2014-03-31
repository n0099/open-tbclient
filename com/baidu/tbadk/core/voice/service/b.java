package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
final class b implements Runnable {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        d dVar;
        int i;
        int i2;
        Handler handler2;
        Runnable runnable;
        int i3;
        handler = this.a.d;
        if (handler == null) {
            return;
        }
        dVar = this.a.k;
        int a = dVar.a();
        i = this.a.e;
        int i4 = a + i;
        i2 = this.a.b;
        if (i4 != i2) {
            this.a.b = i4;
            Intent intent = new Intent("com.baidu.playElapsedTime");
            i3 = this.a.b;
            intent.putExtra("com.baidu.msg.playElapsedTime", i3);
            this.a.sendBroadcast(intent);
        }
        handler2 = this.a.d;
        runnable = this.a.h;
        handler2.postDelayed(runnable, 100L);
    }
}
