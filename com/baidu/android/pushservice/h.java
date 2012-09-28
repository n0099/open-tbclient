package com.baidu.android.pushservice;

import android.os.Handler;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends Thread {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar, OutputStream outputStream) {
        this.a = cVar;
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
            linkedList = this.a.l;
            synchronized (linkedList) {
                linkedList2 = this.a.l;
                if (linkedList2.size() == 0) {
                    try {
                        linkedList3 = this.a.l;
                        linkedList3.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                linkedList4 = this.a.l;
                if (linkedList4.size() > 0) {
                    linkedList5 = this.a.l;
                    bVar = (com.baidu.android.pushservice.message.b) linkedList5.removeFirst();
                } else {
                    bVar = null;
                }
            }
            z2 = this.a.g;
            if (z2) {
                return;
            }
            if (bVar != null && bVar.c != null) {
                try {
                    if (bVar.d) {
                        Handler handler = this.a.a;
                        runnable = this.a.s;
                        handler.removeCallbacks(runnable);
                        Handler handler2 = this.a.a;
                        runnable2 = this.a.s;
                        handler2.postDelayed(runnable2, 20000L);
                    }
                    outputStream = this.a.k;
                    outputStream.write(bVar.c);
                    outputStream2 = this.a.k;
                    outputStream2.flush();
                } catch (IOException e2) {
                    this.a.g = true;
                    this.a.f();
                }
            }
        }
    }
}
