package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends TimerTask {
    final /* synthetic */ b Iy;
    private final /* synthetic */ Timer Iz;
    private final /* synthetic */ View yS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, View view, Timer timer) {
        this.Iy = bVar;
        this.yS = view;
        this.Iz = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.yS.post(new d(this, this.yS, this.Iz));
    }
}
