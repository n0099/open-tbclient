package com.baidu.android.systemmonitor.devicestatistic;

import android.os.Handler;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f824a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f824a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnable;
        this.f824a.c();
        handler = this.f824a.c;
        runnable = this.f824a.e;
        handler.postDelayed(runnable, Util.MILLSECONDS_OF_MINUTE);
        this.f824a.g();
    }
}
