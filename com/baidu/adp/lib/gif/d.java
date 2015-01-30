package com.baidu.adp.lib.gif;

import android.graphics.BitmapFactory;
import android.os.SystemClock;
/* loaded from: classes.dex */
class d extends Thread {
    final /* synthetic */ GifView jl;

    private d(GifView gifView) {
        this.jl = gifView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(GifView gifView, d dVar) {
        this(gifView);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.jl.jd != null) {
            while (this.jl.jd.bI() != 1) {
                if (!this.jl.jf) {
                    c dd = this.jl.jd.dd();
                    if (dd == null) {
                        SystemClock.sleep(50L);
                    } else {
                        if (dd.iI != null) {
                            this.jl.je = dd.iI;
                        } else if (dd.jb != null) {
                            this.jl.je = BitmapFactory.decodeFile(dd.jb);
                        }
                        long j = dd.delay;
                        if (this.jl.jj != null) {
                            this.jl.dt();
                            SystemClock.sleep(j);
                        } else {
                            return;
                        }
                    }
                } else {
                    SystemClock.sleep(50L);
                }
            }
            this.jl.je = this.jl.jd.dd().iI;
            this.jl.jd.free();
            this.jl.dt();
        }
    }
}
