package com.baidu.swan.apps.process.messaging.client;

import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.messaging.a;
import com.baidu.swan.apps.process.messaging.c;
import com.baidu.swan.apps.runtime.d;
import java.util.ArrayDeque;
import java.util.Deque;
/* loaded from: classes8.dex */
public class b implements a.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Deque<Message> cJz = new ArrayDeque();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void axv() {
        a axC = a.axC();
        while (axC.axG() && !this.cJz.isEmpty()) {
            Message peek = this.cJz.peek();
            if (peek == null || B(peek)) {
                this.cJz.poll();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void pO(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull c cVar) {
        Message axw = cVar.axw();
        axw.arg1 = SwanAppProcessInfo.current().index;
        if (d.azE().axR() && (axw.obj instanceof Bundle)) {
            Bundle bundle = (Bundle) axw.obj;
            if (!bundle.containsKey("ai_apps_id")) {
                bundle.putString("ai_apps_id", d.azE().getAppId());
            }
        }
        if (!B(axw) && cVar.isSticky()) {
            this.cJz.offer(axw);
            a.axC().axE();
        }
    }

    private boolean B(Message message) {
        a axC = a.axC();
        if (message != null && axC.axG()) {
            try {
                axC.axD().send(message);
                return true;
            } catch (RemoteException e) {
                axC.axH();
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
