package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f591a;
    final /* synthetic */ Timer b;
    final /* synthetic */ c c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, View view, Timer timer) {
        this.c = cVar;
        this.f591a = view;
        this.b = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f591a.post(new e(this));
    }
}
