package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends TimerTask {
    private final /* synthetic */ Timer JA;
    final /* synthetic */ b Jz;
    private final /* synthetic */ View zn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, View view, Timer timer) {
        this.Jz = bVar;
        this.zn = view;
        this.JA = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.zn.post(new d(this, this.zn, this.JA));
    }
}
