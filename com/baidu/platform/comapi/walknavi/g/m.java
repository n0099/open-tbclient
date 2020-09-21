package com.baidu.platform.comapi.walknavi.g;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class m implements Runnable {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        Message obtain = Message.obtain();
        obtain.what = 1;
        handler = this.a.G;
        if (handler != null) {
            handler2 = this.a.G;
            handler2.dispatchMessage(obtain);
        }
    }
}
