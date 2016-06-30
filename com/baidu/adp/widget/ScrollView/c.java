package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends TimerTask {
    private final /* synthetic */ View py;
    final /* synthetic */ b zO;
    private final /* synthetic */ Timer zP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, View view, Timer timer) {
        this.zO = bVar;
        this.py = view;
        this.zP = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.py.post(new d(this, this.py, this.zP));
    }
}
