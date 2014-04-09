package com.baidu.adp.lib.gif;

import android.graphics.BitmapFactory;
import android.os.SystemClock;
/* loaded from: classes.dex */
final class d extends Thread {
    final /* synthetic */ GifView a;

    private d(GifView gifView) {
        this.a = gifView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(GifView gifView, byte b) {
        this(gifView);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (this.a.a != null) {
            while (this.a.a.b() != 1) {
                if (!this.a.c) {
                    c d = this.a.a.d();
                    if (d == null) {
                        SystemClock.sleep(50L);
                    } else {
                        if (d.a != null) {
                            this.a.b = d.a;
                        } else if (d.c != null) {
                            this.a.b = BitmapFactory.decodeFile(d.c);
                        }
                        long j = d.b;
                        if (this.a.g != null) {
                            this.a.a();
                            SystemClock.sleep(j);
                        } else {
                            return;
                        }
                    }
                } else {
                    SystemClock.sleep(50L);
                }
            }
            this.a.b = this.a.a.d().a;
            this.a.a.a();
            this.a.a();
        }
    }
}
