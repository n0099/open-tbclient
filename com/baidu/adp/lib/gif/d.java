package com.baidu.adp.lib.gif;

import android.graphics.BitmapFactory;
import android.os.SystemClock;
/* loaded from: classes.dex */
class d extends Thread {
    final /* synthetic */ GifView jd;

    private d(GifView gifView) {
        this.jd = gifView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(GifView gifView, d dVar) {
        this(gifView);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (GifView.a(this.jd) != null) {
            while (GifView.a(this.jd).bj() != 1) {
                if (!GifView.c(this.jd)) {
                    c dg = GifView.a(this.jd).dg();
                    if (dg == null) {
                        SystemClock.sleep(50L);
                    } else {
                        if (dg.iz != null) {
                            GifView.a(this.jd, dg.iz);
                        } else if (dg.iT != null) {
                            GifView.a(this.jd, BitmapFactory.decodeFile(dg.iT));
                        }
                        long j = dg.delay;
                        if (GifView.d(this.jd) != null) {
                            GifView.b(this.jd);
                            SystemClock.sleep(j);
                        } else {
                            return;
                        }
                    }
                } else {
                    SystemClock.sleep(50L);
                }
            }
            GifView.a(this.jd, GifView.a(this.jd).dg().iz);
            GifView.a(this.jd).dd();
            GifView.b(this.jd);
        }
    }
}
