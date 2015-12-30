package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends TimerTask {
    final /* synthetic */ b Je;
    private final /* synthetic */ Timer Jf;
    private final /* synthetic */ View yO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, View view, Timer timer) {
        this.Je = bVar;
        this.yO = view;
        this.Jf = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.yO.post(new d(this, this.yO, this.Jf));
    }
}
