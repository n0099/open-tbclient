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
        if (GifView.a(this.a) != null) {
            while (GifView.a(this.a).b() != 1) {
                if (!GifView.c(this.a)) {
                    c d = GifView.a(this.a).d();
                    if (d == null) {
                        SystemClock.sleep(50L);
                    } else {
                        if (d.a != null) {
                            GifView.a(this.a, d.a);
                        } else if (d.c != null) {
                            GifView.a(this.a, BitmapFactory.decodeFile(d.c));
                        }
                        long j = d.b;
                        if (GifView.d(this.a) != null) {
                            GifView.b(this.a);
                            SystemClock.sleep(j);
                        } else {
                            return;
                        }
                    }
                } else {
                    SystemClock.sleep(50L);
                }
            }
            GifView.a(this.a, GifView.a(this.a).d().a);
            GifView.a(this.a).a();
            GifView.b(this.a);
        }
    }
}
