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
        if (GifView.a(this.jl) != null) {
            while (GifView.a(this.jl).bI() != 1) {
                if (!GifView.c(this.jl)) {
                    c dd = GifView.a(this.jl).dd();
                    if (dd == null) {
                        SystemClock.sleep(50L);
                    } else {
                        if (dd.iI != null) {
                            GifView.a(this.jl, dd.iI);
                        } else if (dd.jb != null) {
                            GifView.a(this.jl, BitmapFactory.decodeFile(dd.jb));
                        }
                        long j = dd.delay;
                        if (GifView.d(this.jl) != null) {
                            GifView.b(this.jl);
                            SystemClock.sleep(j);
                        } else {
                            return;
                        }
                    }
                } else {
                    SystemClock.sleep(50L);
                }
            }
            GifView.a(this.jl, GifView.a(this.jl).dd().iI);
            GifView.a(this.jl).free();
            GifView.b(this.jl);
        }
    }
}
