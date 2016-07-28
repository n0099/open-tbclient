package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends TimerTask {
    final /* synthetic */ b Aq;
    private final /* synthetic */ Timer Ar;
    private final /* synthetic */ View qa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, View view, Timer timer) {
        this.Aq = bVar;
        this.qa = view;
        this.Ar = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.qa.post(new d(this, this.qa, this.Ar));
    }
}
