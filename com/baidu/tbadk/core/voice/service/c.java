package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
import com.baidu.location.LocationClientOption;
/* loaded from: classes.dex */
final class c implements Runnable {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j;
        int i;
        Handler handler;
        Runnable runnable;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.a.c;
        int i3 = (int) (currentTimeMillis - j);
        i = this.a.b;
        if (i != i3) {
            this.a.b = i3 / LocationClientOption.MIN_SCAN_SPAN;
            Intent intent = new Intent("com.baidu.recordElapsedTime");
            i2 = this.a.b;
            intent.putExtra("com.baidu.msg.recordElapsedTime", i2);
            this.a.sendBroadcast(intent);
        }
        handler = this.a.d;
        runnable = this.a.i;
        handler.postDelayed(runnable, 200L);
    }
}
