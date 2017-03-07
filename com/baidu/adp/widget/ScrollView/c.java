package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends TimerTask {
    final /* synthetic */ b Jf;
    private final /* synthetic */ Timer Jg;
    private final /* synthetic */ View zB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, View view, Timer timer) {
        this.Jf = bVar;
        this.zB = view;
        this.Jg = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.zB.post(new d(this, this.zB, this.Jg));
    }
}
