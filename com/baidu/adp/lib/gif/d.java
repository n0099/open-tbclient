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
        if (this.jd.iV != null) {
            while (this.jd.iV.bj() != 1) {
                if (!this.jd.iX) {
                    c dg = this.jd.iV.dg();
                    if (dg == null) {
                        SystemClock.sleep(50L);
                    } else {
                        if (dg.iz != null) {
                            this.jd.iW = dg.iz;
                        } else if (dg.iT != null) {
                            this.jd.iW = BitmapFactory.decodeFile(dg.iT);
                        }
                        long j = dg.delay;
                        if (this.jd.jb != null) {
                            this.jd.dw();
                            SystemClock.sleep(j);
                        } else {
                            return;
                        }
                    }
                } else {
                    SystemClock.sleep(50L);
                }
            }
            this.jd.iW = this.jd.iV.dg().iz;
            this.jd.iV.dd();
            this.jd.dw();
        }
    }
}
