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
        c d;
        if (GifView.a(this.a) != null) {
            while (GifView.b(this.a)) {
                if (GifView.a(this.a).b() == 1) {
                    GifView.a(this.a, GifView.a(this.a).d().a);
                    GifView.a(this.a).a();
                    GifView.c(this.a);
                    return;
                } else if (!GifView.d(this.a) && (d = GifView.a(this.a).d()) != null) {
                    if (d.a != null) {
                        GifView.a(this.a, d.a);
                    } else if (d.c != null) {
                        GifView.a(this.a, BitmapFactory.decodeFile(d.c));
                    }
                    long j = d.b;
                    if (GifView.e(this.a) != null) {
                        GifView.c(this.a);
                        SystemClock.sleep(j);
                    } else {
                        return;
                    }
                } else {
                    SystemClock.sleep(50L);
                }
            }
        }
    }
}
