package com.baidu.android.nebula.util;

import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends TimerTask {
    final /* synthetic */ BDLocationManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BDLocationManager bDLocationManager) {
        this.a = bDLocationManager;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        BDLocationManager.a();
    }
}
