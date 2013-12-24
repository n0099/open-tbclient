package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends TimerTask {
    final /* synthetic */ View a;
    final /* synthetic */ Timer b;
    final /* synthetic */ f c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, View view, Timer timer) {
        this.c = fVar;
        this.a = view;
        this.b = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.a.post(new h(this));
    }
}
