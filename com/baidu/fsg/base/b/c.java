package com.baidu.fsg.base.b;

import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f1499a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.f1499a = aVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f1499a.a();
    }
}
