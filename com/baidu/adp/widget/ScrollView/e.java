package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f582a;
    final /* synthetic */ Timer b;
    final /* synthetic */ d c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, View view, Timer timer) {
        this.c = dVar;
        this.f582a = view;
        this.b = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f582a.post(new f(this));
    }
}
