package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends TimerTask {
    final /* synthetic */ b IF;
    private final /* synthetic */ Timer IG;
    private final /* synthetic */ View zc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, View view, Timer timer) {
        this.IF = bVar;
        this.zc = view;
        this.IG = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.zc.post(new d(this, this.zc, this.IG));
    }
}
