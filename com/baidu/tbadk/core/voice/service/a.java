package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ MediaService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(MediaService mediaService) {
        this.a = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        c cVar;
        int i;
        int i2;
        Handler handler2;
        Runnable runnable;
        int i3;
        handler = this.a.d;
        if (handler == null) {
            return;
        }
        cVar = this.a.k;
        int a = cVar.a();
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
