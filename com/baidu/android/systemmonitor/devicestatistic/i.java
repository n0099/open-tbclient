package com.baidu.android.systemmonitor.devicestatistic;

import android.os.Handler;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f690a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f690a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnable;
        this.f690a.c();
        handler = this.f690a.c;
        runnable = this.f690a.e;
        handler.postDelayed(runnable, Util.MILLSECONDS_OF_MINUTE);
        this.f690a.g();
    }
}
