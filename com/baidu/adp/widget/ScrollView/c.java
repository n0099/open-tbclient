package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends TimerTask {
    final /* synthetic */ b It;
    private final /* synthetic */ Timer Iu;
    private final /* synthetic */ View yH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, View view, Timer timer) {
        this.It = bVar;
        this.yH = view;
        this.Iu = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.yH.post(new d(this, this.yH, this.Iu));
    }
}
