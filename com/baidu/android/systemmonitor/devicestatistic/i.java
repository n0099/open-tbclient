package com.baidu.android.systemmonitor.devicestatistic;

import android.os.Handler;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f818a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f818a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnable;
        this.f818a.c();
        handler = this.f818a.c;
        runnable = this.f818a.e;
        handler.postDelayed(runnable, Util.MILLSECONDS_OF_MINUTE);
        this.f818a.g();
    }
}
