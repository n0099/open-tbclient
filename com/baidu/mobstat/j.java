package com.baidu.mobstat;

import android.content.Context;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f949a;
    final /* synthetic */ g b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar, Context context) {
        this.b = gVar;
        this.f949a = context;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        boolean z;
        if (b.a().c()) {
            return;
        }
        b a2 = b.a();
        Context context = this.f949a;
        z = this.b.b;
        a2.a(context, z);
    }
}
