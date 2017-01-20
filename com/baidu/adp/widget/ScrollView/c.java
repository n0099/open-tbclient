package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends TimerTask {
    final /* synthetic */ b BQ;
    private final /* synthetic */ Timer BR;
    private final /* synthetic */ View sg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, View view, Timer timer) {
        this.BQ = bVar;
        this.sg = view;
        this.BR = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.sg.post(new d(this, this.sg, this.BR));
    }
}
