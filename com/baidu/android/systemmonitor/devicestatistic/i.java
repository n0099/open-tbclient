package com.baidu.android.systemmonitor.devicestatistic;

import android.os.Handler;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f713a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f713a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnable;
        this.f713a.c();
        handler = this.f713a.c;
        runnable = this.f713a.e;
        handler.postDelayed(runnable, Util.MILLSECONDS_OF_MINUTE);
        this.f713a.g();
    }
}
