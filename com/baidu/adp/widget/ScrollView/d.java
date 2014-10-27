package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends TimerTask {
    private final /* synthetic */ View nt;
    final /* synthetic */ c vX;
    private final /* synthetic */ Timer vY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, View view, Timer timer) {
        this.vX = cVar;
        this.nt = view;
        this.vY = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.nt.post(new e(this, this.nt, this.vY));
    }
}
