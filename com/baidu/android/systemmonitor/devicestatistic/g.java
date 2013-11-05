package com.baidu.android.systemmonitor.devicestatistic;

import android.os.Handler;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f802a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.f802a = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnable;
        this.f802a.e();
        handler = this.f802a.e;
        runnable = this.f802a.i;
        handler.postDelayed(runnable, Util.MILLSECONDS_OF_MINUTE);
    }
}
