package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends TimerTask {
    private final /* synthetic */ View nv;
    final /* synthetic */ b xW;
    private final /* synthetic */ Timer xX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, View view, Timer timer) {
        this.xW = bVar;
        this.nv = view;
        this.xX = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.nv.post(new d(this, this.nv, this.xX));
    }
}
