package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f502a;
    private final /* synthetic */ View b;
    private final /* synthetic */ Timer c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, View view, Timer timer) {
        this.f502a = dVar;
        this.b = view;
        this.c = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.b.post(new f(this, this.b, this.c));
    }
}
