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
/* loaded from: classes25.dex */
public class b implements a.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Deque<Message> drq = new ArrayDeque();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void aHH() {
        a aHO = a.aHO();
        while (aHO.aHS() && !this.drq.isEmpty()) {
            Message peek = this.drq.peek();
            if (peek == null || B(peek)) {
                this.drq.poll();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void sb(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull c cVar) {
        Message aHI = cVar.aHI();
        aHI.arg1 = SwanAppProcessInfo.current().index;
        if (d.aJQ().aId() && (aHI.obj instanceof Bundle)) {
            Bundle bundle = (Bundle) aHI.obj;
            if (!bundle.containsKey("ai_apps_id")) {
                bundle.putString("ai_apps_id", d.aJQ().getAppId());
            }
        }
        if (!B(aHI) && cVar.isSticky()) {
            this.drq.offer(aHI);
            a.aHO().aHQ();
        }
    }

    private boolean B(Message message) {
        a aHO = a.aHO();
        if (message != null && aHO.aHS()) {
            try {
                aHO.aHP().send(message);
                return true;
            } catch (RemoteException e) {
                aHO.aHT();
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
