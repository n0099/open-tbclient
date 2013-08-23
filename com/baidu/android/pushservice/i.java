package com.baidu.android.pushservice;

import android.os.Handler;
import com.baidu.android.common.logging.Log;
import com.baidu.android.pushservice.jni.PushSocket;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f605a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar) {
        this.f605a = eVar;
        setName("PushService-PushConnection-readThread");
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0008 */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        boolean z;
        Runnable runnable;
        boolean z2;
        byte[] bArr;
        Runnable runnable2;
        boolean z3;
        while (!z) {
            if (PushSocket.f607a) {
                try {
                    bArr = PushSocket.a(e.f601a, this.f605a.c);
                } catch (Exception e) {
                    bArr = null;
                    Log.e("PushConnection", "Get message exception");
                }
                Handler handler = this.f605a.b;
                runnable2 = this.f605a.t;
                handler.removeCallbacks(runnable2);
                z3 = this.f605a.r;
                if (z3) {
                    this.f605a.r = false;
                    this.f605a.b(true);
                }
                if (bArr == null || bArr.length == 0) {
                    Log.i("PushConnection", "Receive err,errno:" + PushSocket.getLastSocketError());
                    this.f605a.f();
                } else {
                    try {
                        com.baidu.android.pushservice.message.b a2 = this.f605a.c.a(bArr, bArr.length);
                        if (a2 != null) {
                            try {
                                if (b.a()) {
                                    Log.d("PushConnection", "ReadThread receive msg :" + a2.toString());
                                }
                                this.f605a.c.b(a2);
                            } catch (Exception e2) {
                                Log.e("PushConnection", "Handle message exception " + com.baidu.android.pushservice.util.n.a(e2));
                                this.f605a.f();
                            }
                        }
                        this.f605a.n = 0;
                    } catch (Exception e3) {
                        Log.i("PushConnection", "Read message exception " + com.baidu.android.pushservice.util.n.a(e3));
                        this.f605a.f();
                    }
                }
            } else {
                try {
                    com.baidu.android.pushservice.message.b b = this.f605a.c.b();
                    Handler handler2 = this.f605a.b;
                    runnable = this.f605a.t;
                    handler2.removeCallbacks(runnable);
                    z2 = this.f605a.r;
                    if (z2) {
                        this.f605a.r = false;
                        this.f605a.b(true);
                    }
                    if (b != null) {
                        if (b.a()) {
                            Log.d("PushConnection", "ReadThread receive msg :" + b.toString());
                        }
                        try {
                            this.f605a.c.b(b);
                            this.f605a.n = 0;
                        } catch (com.baidu.android.pushservice.message.d e4) {
                            Log.e("PushConnection", "handleMessage exception.");
                            Log.e("PushConnection", e4);
                            this.f605a.f();
                        }
                    }
                } catch (Exception e5) {
                    Log.e("PushConnection", "ReadThread exception: " + e5);
                    this.f605a.f();
                }
            }
        }
    }
}
