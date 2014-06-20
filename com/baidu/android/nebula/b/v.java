package com.baidu.android.nebula.b;
/* loaded from: classes.dex */
public class v implements g {
    private long a;

    @Override // com.baidu.android.nebula.b.g
    public void a(Runnable runnable) {
        this.a++;
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.setName("NanoHttpd Request Processor (#" + this.a + ")");
        thread.start();
    }
}
