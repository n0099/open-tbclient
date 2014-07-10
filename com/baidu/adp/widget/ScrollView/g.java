package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends TimerTask {
    final /* synthetic */ f a;
    private final /* synthetic */ View b;
    private final /* synthetic */ Timer c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, View view, Timer timer) {
        this.a = fVar;
        this.b = view;
        this.c = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.b.post(new h(this, this.b, this.c));
    }
}
