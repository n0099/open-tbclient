package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends TimerTask {
    final /* synthetic */ b CE;
    private final /* synthetic */ Timer CF;
    private final /* synthetic */ View sq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, View view, Timer timer) {
        this.CE = bVar;
        this.sq = view;
        this.CF = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.sq.post(new d(this, this.sq, this.CF));
    }
}
