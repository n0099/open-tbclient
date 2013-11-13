package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f590a;
    final /* synthetic */ Timer b;
    final /* synthetic */ f c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, View view, Timer timer) {
        this.c = fVar;
        this.f590a = view;
        this.b = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f590a.post(new h(this));
    }
}
