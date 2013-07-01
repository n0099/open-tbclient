package com.baidu.android.pushservice;

import com.baidu.android.common.logging.Log;
import com.baidu.android.pushservice.jni.PushSocket;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f313a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.f313a = eVar;
        setName("PushService-PushConnection-readThread");
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0006 */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        boolean z;
        byte[] bArr;
        while (!z) {
            try {
                bArr = PushSocket.a(e.f310a, this.f313a.c);
            } catch (Exception e) {
                bArr = null;
                Log.e("PushConnection", "Get message exception");
            }
            if (bArr == null || bArr.length == 0) {
                Log.e("PushConnection", "Receive err,errno:" + PushSocket.getLastSocketError());
                this.f313a.e();
            } else {
                try {
                    try {
                        this.f313a.c.b(this.f313a.c.a(bArr, bArr.length));
                        this.f313a.k = 0;
                    } catch (Exception e2) {
                        Log.e("PushConnection", "Handle message exception " + com.baidu.android.pushservice.util.n.a(e2));
                        this.f313a.e();
                    }
                } catch (Exception e3) {
                    Log.e("PushConnection", "Read message exception " + com.baidu.android.pushservice.util.n.a(e3));
                    this.f313a.e();
                }
            }
        }
    }
}
