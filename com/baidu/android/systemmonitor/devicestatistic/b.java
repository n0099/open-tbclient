package com.baidu.android.systemmonitor.devicestatistic;

import android.os.Handler;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(h hVar) {
        this.a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnable;
        this.a.c();
        handler = this.a.c;
        runnable = this.a.e;
        handler.postDelayed(runnable, TbConfig.USE_TIME_INTERVAL);
        this.a.g();
    }
}
