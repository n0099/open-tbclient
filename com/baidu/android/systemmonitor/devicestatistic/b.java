package com.baidu.android.systemmonitor.devicestatistic;

import android.os.Handler;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ i a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(i iVar) {
        this.a = iVar;
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
