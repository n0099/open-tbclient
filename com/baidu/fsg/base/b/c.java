package com.baidu.fsg.base.b;

import java.util.TimerTask;
/* loaded from: classes.dex */
public class c extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f5173a;

    public c(a aVar) {
        this.f5173a = aVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f5173a.a();
    }
}
