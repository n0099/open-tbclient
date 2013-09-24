package com.baidu.android.systemmonitor.devicestatistic;

import android.os.Handler;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f723a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.f723a = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnable;
        this.f723a.e();
        handler = this.f723a.e;
        runnable = this.f723a.i;
        handler.postDelayed(runnable, Util.MILLSECONDS_OF_MINUTE);
    }
}
