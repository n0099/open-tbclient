package com.baidu.android.systemmonitor.devicestatistic;

import android.os.Handler;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(j jVar) {
        this.a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnable;
        this.a.e();
        handler = this.a.e;
        runnable = this.a.i;
        handler.postDelayed(runnable, TbConfig.USE_TIME_INTERVAL);
    }
}
