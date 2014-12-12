package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends TimerTask {
    private final /* synthetic */ View ns;
    final /* synthetic */ b xZ;
    private final /* synthetic */ Timer ya;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, View view, Timer timer) {
        this.xZ = bVar;
        this.ns = view;
        this.ya = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.ns.post(new d(this, this.ns, this.ya));
    }
}
