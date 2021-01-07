package com.baidu.location.b;

import com.baidu.location.b.d;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class f extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Timer f2616a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ d.b f2617b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d.b bVar, Timer timer) {
        this.f2617b = bVar;
        this.f2616a = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (!this.f2617b.d) {
            this.f2617b.c();
        }
        this.f2616a.cancel();
        this.f2616a.purge();
    }
}
