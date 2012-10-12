package com.baidu.android.pushservice;

import android.os.Handler;
import com.baidu.android.common.logging.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends Thread {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(d dVar) {
        this.a = dVar;
        setName("PushService-PushConnection-readThread");
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0006 */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        boolean z;
        Runnable runnable;
        while (!z) {
            try {
                com.baidu.android.pushservice.message.b a = this.a.b.a();
                Handler handler = this.a.a;
                runnable = this.a.s;
                handler.removeCallbacks(runnable);
                if (a != null) {
                    try {
                        this.a.b.b(a);
                        this.a.o = 0;
                    } catch (com.baidu.android.pushservice.message.d e) {
                        Log.e("PushConnection", "handleMessage exception.");
                        Log.e("PushConnection", e);
                        this.a.c();
                    }
                }
            } catch (Exception e2) {
                Log.e("PushConnection", e2);
                this.a.g = true;
                this.a.f();
            }
        }
    }
}
