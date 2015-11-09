package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends TimerTask {
    final /* synthetic */ b Iv;
    private final /* synthetic */ Timer Iw;
    private final /* synthetic */ View yG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, View view, Timer timer) {
        this.Iv = bVar;
        this.yG = view;
        this.Iw = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.yG.post(new d(this, this.yG, this.Iw));
    }
}
