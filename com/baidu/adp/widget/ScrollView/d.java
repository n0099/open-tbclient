package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends TimerTask {
    final /* synthetic */ View a;
    final /* synthetic */ Timer b;
    final /* synthetic */ c c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, View view, Timer timer) {
        this.c = cVar;
        this.a = view;
        this.b = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.a.post(new e(this));
    }
}
