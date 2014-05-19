package com.baidu.adp.lib.gif;

import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.SystemClock;
/* loaded from: classes.dex */
class d extends Thread {
    final /* synthetic */ GifView a;

    private d(GifView gifView) {
        this.a = gifView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(GifView gifView, d dVar) {
        this(gifView);
    }

    /* JADX WARN: Incorrect condition in loop: B:11:0x002d */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4;
        boolean z;
        b bVar5;
        Handler handler;
        bVar = this.a.a;
        if (bVar != null) {
            while (bVar2.b() != 1) {
                z = this.a.c;
                if (!z) {
                    bVar5 = this.a.a;
                    c d = bVar5.d();
                    if (d == null) {
                        SystemClock.sleep(50L);
                    } else {
                        if (d.a != null) {
                            this.a.b = d.a;
                        } else if (d.c != null) {
                            this.a.b = BitmapFactory.decodeFile(d.c);
                        }
                        long j = d.b;
                        handler = this.a.g;
                        if (handler != null) {
                            this.a.b();
                            SystemClock.sleep(j);
                        } else {
                            return;
                        }
                    }
                } else {
                    SystemClock.sleep(50L);
                }
            }
            bVar3 = this.a.a;
            this.a.b = bVar3.d().a;
            bVar4 = this.a.a;
            bVar4.a();
            this.a.b();
        }
    }
}
