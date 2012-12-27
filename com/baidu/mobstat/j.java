package com.baidu.mobstat;

import android.content.Context;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends TimerTask {
    final /* synthetic */ Context a;
    final /* synthetic */ g b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar, Context context) {
        this.b = gVar;
        this.a = context;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        boolean z;
        if (b.a().c()) {
            return;
        }
        b a = b.a();
        Context context = this.a;
        z = this.b.b;
        a.a(context, z);
    }
}
