package com.baidu.location.b;

import com.baidu.location.b.d;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class f extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Timer f1881a;
    final /* synthetic */ d.b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d.b bVar, Timer timer) {
        this.b = bVar;
        this.f1881a = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (!this.b.d) {
            this.b.c();
        }
        this.f1881a.cancel();
        this.f1881a.purge();
    }
}
