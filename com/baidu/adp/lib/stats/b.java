package com.baidu.adp.lib.stats;

import android.os.Handler;
import com.baidu.adp.lib.stats.b.j;
import com.baidu.adp.lib.stats.switchs.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements a.InterfaceC0006a {
    final /* synthetic */ BdStatisticsManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdStatisticsManager bdStatisticsManager) {
        this.this$0 = bdStatisticsManager;
    }

    @Override // com.baidu.adp.lib.stats.switchs.a.InterfaceC0006a
    public void fU() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        this.this$0.isSwitchReady = true;
        if (this.this$0.mIsMainProcess) {
            j.gK().gR();
        }
        handler = BdStatisticsManager.mHandler;
        handler.removeMessages(2);
        handler2 = BdStatisticsManager.mHandler;
        handler3 = BdStatisticsManager.mHandler;
        handler2.sendMessageDelayed(handler3.obtainMessage(2), 15000L);
    }
}
