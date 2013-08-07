package com.baidu.android.pushservice;

import android.os.Handler;
import com.baidu.android.common.logging.Log;
import com.baidu.android.pushservice.jni.PushSocket;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f582a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar) {
        this.f582a = eVar;
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
            if (PushSocket.f584a) {
                try {
                    bArr = PushSocket.a(e.f578a, this.f582a.c);
                } catch (Exception e) {
                    bArr = null;
                    Log.e("PushConnection", "Get message exception");
                }
                Handler handler = this.f582a.b;
                runnable2 = this.f582a.t;
                handler.removeCallbacks(runnable2);
                z3 = this.f582a.r;
                if (z3) {
                    this.f582a.r = false;
                    this.f582a.b(true);
                }
                if (bArr == null || bArr.length == 0) {
                    Log.i("PushConnection", "Receive err,errno:" + PushSocket.getLastSocketError());
                    this.f582a.f();
                } else {
                    try {
                        com.baidu.android.pushservice.message.b a2 = this.f582a.c.a(bArr, bArr.length);
                        if (a2 != null) {
                            try {
                                if (b.a()) {
                                    Log.d("PushConnection", "ReadThread receive msg :" + a2.toString());
                                }
                                this.f582a.c.b(a2);
                            } catch (Exception e2) {
                                Log.e("PushConnection", "Handle message exception " + com.baidu.android.pushservice.util.n.a(e2));
                                this.f582a.f();
                            }
                        }
                        this.f582a.n = 0;
                    } catch (Exception e3) {
                        Log.i("PushConnection", "Read message exception " + com.baidu.android.pushservice.util.n.a(e3));
                        this.f582a.f();
                    }
                }
            } else {
                try {
                    com.baidu.android.pushservice.message.b b = this.f582a.c.b();
                    Handler handler2 = this.f582a.b;
                    runnable = this.f582a.t;
                    handler2.removeCallbacks(runnable);
                    z2 = this.f582a.r;
                    if (z2) {
                        this.f582a.r = false;
                        this.f582a.b(true);
                    }
                    if (b != null) {
                        if (b.a()) {
                            Log.d("PushConnection", "ReadThread receive msg :" + b.toString());
                        }
                        try {
                            this.f582a.c.b(b);
                            this.f582a.n = 0;
                        } catch (com.baidu.android.pushservice.message.d e4) {
                            Log.e("PushConnection", "handleMessage exception.");
                            Log.e("PushConnection", e4);
                            this.f582a.f();
                        }
                    }
                } catch (Exception e5) {
                    Log.e("PushConnection", "ReadThread exception: " + e5);
                    this.f582a.f();
                }
            }
        }
    }
}
