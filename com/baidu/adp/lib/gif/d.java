package com.baidu.adp.lib.gif;

import android.graphics.BitmapFactory;
import android.os.SystemClock;
/* loaded from: classes.dex */
class d extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GifView f431a;

    private d(GifView gifView) {
        this.f431a = gifView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(GifView gifView, d dVar) {
        this(gifView);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (GifView.a(this.f431a) != null) {
            while (GifView.b(this.f431a)) {
                if (GifView.a(this.f431a).b() == 1) {
                    GifView.a(this.f431a, GifView.a(this.f431a).d().f430a);
                    GifView.a(this.f431a).a();
                    GifView.c(this.f431a);
                    return;
                } else if (!GifView.d(this.f431a)) {
                    c d = GifView.a(this.f431a).d();
                    if (d == null) {
                        SystemClock.sleep(50L);
                    } else {
                        if (d.f430a != null) {
                            GifView.a(this.f431a, d.f430a);
                        } else if (d.c != null) {
                            GifView.a(this.f431a, BitmapFactory.decodeFile(d.c));
                        }
                        long j = d.b;
                        if (GifView.e(this.f431a) != null) {
                            GifView.c(this.f431a);
                            SystemClock.sleep(j);
                        } else {
                            return;
                        }
                    }
                } else {
                    SystemClock.sleep(50L);
                }
            }
        }
    }
}
