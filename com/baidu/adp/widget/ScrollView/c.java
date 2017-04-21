package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends TimerTask {
    final /* synthetic */ b IH;
    private final /* synthetic */ Timer II;
    private final /* synthetic */ View zf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, View view, Timer timer) {
        this.IH = bVar;
        this.zf = view;
        this.II = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.zf.post(new d(this, this.zf, this.II));
    }
}
