package com.baidu.android.systemmonitor.devicestatistic;

import android.os.Handler;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f685a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(i iVar) {
        this.f685a = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnable;
        this.f685a.e();
        handler = this.f685a.e;
        runnable = this.f685a.i;
        handler.postDelayed(runnable, Util.MILLSECONDS_OF_MINUTE);
    }
}
