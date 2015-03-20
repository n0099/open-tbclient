package com.baidu.adp.lib.gif;

import android.graphics.BitmapFactory;
import android.os.SystemClock;
/* loaded from: classes.dex */
class d extends Thread {
    final /* synthetic */ GifView uC;

    private d(GifView gifView) {
        this.uC = gifView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(GifView gifView, d dVar) {
        this(gifView);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (GifView.a(this.uC) != null) {
            while (GifView.a(this.uC).fg() != 1) {
                if (!GifView.c(this.uC)) {
                    c gC = GifView.a(this.uC).gC();
                    if (gC == null) {
                        SystemClock.sleep(50L);
                    } else {
                        if (gC.tY != null) {
                            GifView.a(this.uC, gC.tY);
                        } else if (gC.us != null) {
                            GifView.a(this.uC, BitmapFactory.decodeFile(gC.us));
                        }
                        long j = gC.delay;
                        if (GifView.d(this.uC) != null) {
                            GifView.b(this.uC);
                            SystemClock.sleep(j);
                        } else {
                            return;
                        }
                    }
                } else {
                    SystemClock.sleep(50L);
                }
            }
            GifView.a(this.uC, GifView.a(this.uC).gC().tY);
            GifView.a(this.uC).free();
            GifView.b(this.uC);
        }
    }
}
