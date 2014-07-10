package com.baidu.mobstat;

import android.content.Context;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends TimerTask {
    final /* synthetic */ Context a;
    final /* synthetic */ k b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar, Context context) {
        this.b = kVar;
        this.a = context;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        boolean z;
        if (DataCore.getInstance().isPartEmpty()) {
            return;
        }
        k kVar = this.b;
        Context context = this.a;
        z = this.b.b;
        kVar.a(context, z);
    }
}
