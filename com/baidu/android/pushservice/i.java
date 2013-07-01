package com.baidu.android.pushservice;

import com.baidu.android.common.logging.Log;
import com.baidu.android.pushservice.jni.PushSocket;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f314a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar) {
        this.f314a = eVar;
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
        LinkedList linkedList5;
        while (!z) {
            linkedList = this.f314a.g;
            synchronized (linkedList) {
                linkedList2 = this.f314a.g;
                if (linkedList2.size() == 0) {
                    try {
                        linkedList3 = this.f314a.g;
                        linkedList3.wait();
                    } catch (InterruptedException e) {
                        Log.e("PushConnection", "SendThread wait exception: " + e);
                    }
                }
                linkedList4 = this.f314a.g;
                if (linkedList4.size() > 0) {
                    linkedList5 = this.f314a.g;
                    bVar = (com.baidu.android.pushservice.message.b) linkedList5.removeFirst();
                } else {
                    bVar = null;
                }
            }
            z2 = this.f314a.f;
            if (z2) {
                return;
            }
            if (bVar != null && bVar.c != null && PushSocket.sendMsg(e.f310a, bVar.c, bVar.c.length) == -1) {
                Log.e("PushConnection", "sendMsg err, errno:" + PushSocket.getLastSocketError());
                this.f314a.e();
            }
        }
    }
}
