package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends TimerTask {
    final /* synthetic */ b IN;
    private final /* synthetic */ Timer IO;
    private final /* synthetic */ View yM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, View view, Timer timer) {
        this.IN = bVar;
        this.yM = view;
        this.IO = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.yM.post(new d(this, this.yM, this.IO));
    }
}
