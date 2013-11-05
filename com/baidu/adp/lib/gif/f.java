package com.baidu.adp.lib.gif;

import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.SystemClock;
/* loaded from: classes.dex */
class f extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GifView f493a;

    private f(GifView gifView) {
        this.f493a = gifView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(GifView gifView, d dVar) {
        this(gifView);
    }

    /* JADX WARN: Incorrect condition in loop: B:11:0x0028 */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        b bVar;
        boolean z;
        b bVar2;
        b bVar3;
        b bVar4;
        boolean z2;
        b bVar5;
        Handler handler;
        bVar = this.f493a.f487a;
        if (bVar == null) {
            return;
        }
        while (z) {
            bVar2 = this.f493a.f487a;
            if (bVar2.b() == 1) {
                bVar3 = this.f493a.f487a;
                this.f493a.b = bVar3.d().f490a;
                bVar4 = this.f493a.f487a;
                bVar4.a();
                this.f493a.a();
                return;
            }
            z2 = this.f493a.d;
            if (!z2) {
                bVar5 = this.f493a.f487a;
                c d = bVar5.d();
                if (d == null) {
                    SystemClock.sleep(50L);
                } else {
                    if (d.f490a != null) {
                        this.f493a.b = d.f490a;
                    } else if (d.c != null) {
                        this.f493a.b = BitmapFactory.decodeFile(d.c);
                    }
                    long j = d.b;
                    handler = this.f493a.h;
                    if (handler != null) {
                        this.f493a.a();
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
