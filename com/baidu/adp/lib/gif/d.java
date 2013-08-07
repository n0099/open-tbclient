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
        if (this.f423a.f419a != null) {
            while (this.f423a.c) {
                if (this.f423a.f419a.b() == 1) {
                    this.f423a.b = this.f423a.f419a.d().f422a;
                    this.f423a.f419a.a();
                    this.f423a.b();
                    return;
                } else if (!this.f423a.d) {
                    c d = this.f423a.f419a.d();
                    if (d == null) {
                        SystemClock.sleep(50L);
                    } else {
                        if (d.f422a != null) {
                            this.f423a.b = d.f422a;
                        } else if (d.c != null) {
                            this.f423a.b = BitmapFactory.decodeFile(d.c);
                        }
                        long j = d.b;
                        if (this.f423a.h != null) {
                            this.f423a.b();
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
