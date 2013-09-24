package com.baidu.android.pushservice;

import android.os.Handler;
import com.baidu.android.common.logging.Log;
import com.baidu.android.pushservice.jni.PushSocket;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f618a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar) {
        this.f618a = eVar;
        setName("PushService-PushConnection-SendThread");
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0006 */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        boolean z;
        LinkedList linkedList;
        LinkedList linkedList2;
        LinkedList linkedList3;
        LinkedList linkedList4;
        com.baidu.android.pushservice.message.b bVar;
        boolean z2;
        OutputStream outputStream;
        OutputStream outputStream2;
        Runnable runnable;
        Runnable runnable2;
        LinkedList linkedList5;
        while (!z) {
            linkedList = this.f618a.j;
            synchronized (linkedList) {
                linkedList2 = this.f618a.j;
                if (linkedList2.size() == 0) {
                    try {
                        linkedList3 = this.f618a.j;
                        linkedList3.wait();
                    } catch (InterruptedException e) {
                        Log.e("PushConnection", "SendThread wait exception: " + e);
                    }
                }
                linkedList4 = this.f618a.j;
                if (linkedList4.size() > 0) {
                    linkedList5 = this.f618a.j;
                    bVar = (com.baidu.android.pushservice.message.b) linkedList5.removeFirst();
                } else {
                    bVar = null;
                }
            }
            z2 = this.f618a.f;
            if (z2) {
                return;
            }
            if (bVar != null && bVar.c != null) {
                if (b.a()) {
                    Log.d("PushConnection", "SendThread send msg :" + bVar.toString());
                }
                if (bVar.d) {
                    if (bVar.a()) {
                        this.f618a.r = true;
                    } else {
                        this.f618a.r = false;
                    }
                    Handler handler = this.f618a.b;
                    runnable = this.f618a.t;
                    handler.removeCallbacks(runnable);
                    Handler handler2 = this.f618a.b;
                    runnable2 = this.f618a.t;
                    handler2.postDelayed(runnable2, Util.MILLSECONDS_OF_MINUTE);
                }
                if (!PushSocket.f619a) {
                    try {
                        outputStream = this.f618a.i;
                        outputStream.write(bVar.c);
                        outputStream2 = this.f618a.i;
                        outputStream2.flush();
                    } catch (IOException e2) {
                        Log.e("PushConnection", "SendThread exception: " + e2);
                        this.f618a.f();
                    }
                } else if (PushSocket.sendMsg(e.f613a, bVar.c, bVar.c.length) == -1) {
                    Log.e("PushConnection", "sendMsg err, errno:" + PushSocket.getLastSocketError());
                    this.f618a.f();
                }
            }
        }
    }
}
