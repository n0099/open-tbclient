package com.baidu.location.b;

import com.baidu.location.b.d;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class f extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Timer f2615a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ d.b f2616b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d.b bVar, Timer timer) {
        this.f2616b = bVar;
        this.f2615a = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (!this.f2616b.d) {
            this.f2616b.c();
        }
        this.f2615a.cancel();
        this.f2615a.purge();
    }
}
