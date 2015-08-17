package com;

import com.baidu.cloudsdk.common.util.PositionManager;
/* loaded from: classes.dex */
public class am implements Runnable {
    final /* synthetic */ PositionManager a;

    public am(PositionManager positionManager) {
        this.a = positionManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        PositionManager.a aVar;
        PositionManager.a aVar2;
        aVar = this.a.c;
        if (aVar.isCancelled()) {
            return;
        }
        aVar2 = this.a.c;
        aVar2.cancel(true);
    }
}
