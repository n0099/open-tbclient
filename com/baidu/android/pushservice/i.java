package com.baidu.android.pushservice;

import android.os.Handler;
import com.baidu.android.common.logging.Log;
import com.baidu.android.pushservice.jni.PushSocket;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f718a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar) {
        this.f718a = eVar;
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
            if (PushSocket.f720a) {
                try {
                    bArr = PushSocket.a(e.f714a, this.f718a.c);
                } catch (Exception e) {
                    bArr = null;
                    Log.e("PushConnection", "Get message exception");
                }
                Handler handler = this.f718a.b;
                runnable2 = this.f718a.t;
                handler.removeCallbacks(runnable2);
                z3 = this.f718a.r;
                if (z3) {
                    this.f718a.r = false;
                    this.f718a.b(true);
                }
                if (bArr == null || bArr.length == 0) {
                    Log.i("PushConnection", "Receive err,errno:" + PushSocket.getLastSocketError());
                    this.f718a.g();
                } else {
                    try {
                        com.baidu.android.pushservice.message.b a2 = this.f718a.c.a(bArr, bArr.length);
                        if (a2 != null) {
                            try {
                                if (b.a()) {
                                    Log.d("PushConnection", "ReadThread receive msg :" + a2.toString());
                                }
                                this.f718a.c.b(a2);
                            } catch (Exception e2) {
                                Log.e("PushConnection", "Handle message exception " + com.baidu.android.pushservice.util.m.a(e2));
                                this.f718a.g();
                            }
                        }
                        this.f718a.n = 0;
                    } catch (Exception e3) {
                        Log.i("PushConnection", "Read message exception " + com.baidu.android.pushservice.util.m.a(e3));
                        this.f718a.g();
                    }
                }
            } else {
                try {
                    com.baidu.android.pushservice.message.b b = this.f718a.c.b();
                    Handler handler2 = this.f718a.b;
                    runnable = this.f718a.t;
                    handler2.removeCallbacks(runnable);
                    z2 = this.f718a.r;
                    if (z2) {
                        this.f718a.r = false;
                        this.f718a.b(true);
                    }
                    if (b != null) {
                        if (b.a()) {
                            Log.d("PushConnection", "ReadThread receive msg :" + b.toString());
                        }
                        try {
                            this.f718a.c.b(b);
                            this.f718a.n = 0;
                        } catch (com.baidu.android.pushservice.message.d e4) {
                            Log.e("PushConnection", "handleMessage exception.");
                            Log.e("PushConnection", e4);
                            this.f718a.g();
                        }
                    }
                } catch (Exception e5) {
                    Log.e("PushConnection", "ReadThread exception: " + e5);
                    this.f718a.g();
                }
            }
        }
    }
}
