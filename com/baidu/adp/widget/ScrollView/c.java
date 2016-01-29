package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends TimerTask {
    final /* synthetic */ b Jt;
    private final /* synthetic */ Timer Ju;
    private final /* synthetic */ View yW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, View view, Timer timer) {
        this.Jt = bVar;
        this.yW = view;
        this.Ju = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.yW.post(new d(this, this.yW, this.Ju));
    }
}
