package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f585a;
    final /* synthetic */ Timer b;
    final /* synthetic */ g c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, View view, Timer timer) {
        this.c = gVar;
        this.f585a = view;
        this.b = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f585a.post(new i(this));
    }
}
