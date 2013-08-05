package com.baidu.adp.lib.gif;

import android.graphics.BitmapFactory;
import android.os.SystemClock;
/* loaded from: classes.dex */
class d extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GifView f423a;

    private d(GifView gifView) {
        this.f423a = gifView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(GifView gifView, d dVar) {
        this(gifView);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (GifView.a(this.f423a) != null) {
            while (GifView.b(this.f423a)) {
                if (GifView.a(this.f423a).b() == 1) {
                    GifView.a(this.f423a, GifView.a(this.f423a).d().f422a);
                    GifView.a(this.f423a).a();
                    GifView.c(this.f423a);
                    return;
                } else if (!GifView.d(this.f423a)) {
                    c d = GifView.a(this.f423a).d();
                    if (d == null) {
                        SystemClock.sleep(50L);
                    } else {
                        if (d.f422a != null) {
                            GifView.a(this.f423a, d.f422a);
                        } else if (d.c != null) {
                            GifView.a(this.f423a, BitmapFactory.decodeFile(d.c));
                        }
                        long j = d.b;
                        if (GifView.e(this.f423a) != null) {
                            GifView.c(this.f423a);
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
