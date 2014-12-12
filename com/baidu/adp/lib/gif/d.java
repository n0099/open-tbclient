package com.baidu.adp.lib.gif;

import android.graphics.BitmapFactory;
import android.os.SystemClock;
/* loaded from: classes.dex */
class d extends Thread {
    final /* synthetic */ GifView jj;

    private d(GifView gifView) {
        this.jj = gifView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(GifView gifView, d dVar) {
        this(gifView);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.jj.jb != null) {
            while (this.jj.jb.bK() != 1) {
                if (!this.jj.jd) {
                    c df = this.jj.jb.df();
                    if (df == null) {
                        SystemClock.sleep(50L);
                    } else {
                        if (df.iG != null) {
                            this.jj.jc = df.iG;
                        } else if (df.iZ != null) {
                            this.jj.jc = BitmapFactory.decodeFile(df.iZ);
                        }
                        long j = df.delay;
                        if (this.jj.jh != null) {
                            this.jj.dv();
                            SystemClock.sleep(j);
                        } else {
                            return;
                        }
                    }
                } else {
                    SystemClock.sleep(50L);
                }
            }
            this.jj.jc = this.jj.jb.df().iG;
            this.jj.jb.free();
            this.jj.dv();
        }
    }
}
