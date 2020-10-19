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
/* loaded from: classes10.dex */
public class b implements a.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Deque<Message> cXC = new ArrayDeque();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void aAN() {
        a aAU = a.aAU();
        while (aAU.aAY() && !this.cXC.isEmpty()) {
            Message peek = this.cXC.peek();
            if (peek == null || B(peek)) {
                this.cXC.poll();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void qT(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull c cVar) {
        Message aAO = cVar.aAO();
        aAO.arg1 = SwanAppProcessInfo.current().index;
        if (d.aCW().aBj() && (aAO.obj instanceof Bundle)) {
            Bundle bundle = (Bundle) aAO.obj;
            if (!bundle.containsKey("ai_apps_id")) {
                bundle.putString("ai_apps_id", d.aCW().getAppId());
            }
        }
        if (!B(aAO) && cVar.isSticky()) {
            this.cXC.offer(aAO);
            a.aAU().aAW();
        }
    }

    private boolean B(Message message) {
        a aAU = a.aAU();
        if (message != null && aAU.aAY()) {
            try {
                aAU.aAV().send(message);
                return true;
            } catch (RemoteException e) {
                aAU.aAZ();
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
