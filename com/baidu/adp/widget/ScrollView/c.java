package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends TimerTask {
    final /* synthetic */ b Iu;
    private final /* synthetic */ Timer Iv;
    private final /* synthetic */ View yG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, View view, Timer timer) {
        this.Iu = bVar;
        this.yG = view;
        this.Iv = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.yG.post(new d(this, this.yG, this.Iv));
    }
}
