package com.baidu.location.c;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ Location MD;
    final /* synthetic */ e Mv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Location location) {
        this.Mv = eVar;
        this.MD = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Mv.c(this.MD);
    }
}
