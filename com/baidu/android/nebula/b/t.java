package com.baidu.android.nebula.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(c cVar) {
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread thread = new Thread(new b(this));
        thread.setName("thread_diffapps_request");
        thread.start();
    }
}
