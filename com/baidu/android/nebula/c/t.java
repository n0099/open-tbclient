package com.baidu.android.nebula.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {
    final /* synthetic */ i a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(i iVar) {
        this.a = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread thread = new Thread(new h(this));
        thread.setName("thread_diffapps_request");
        thread.start();
    }
}
