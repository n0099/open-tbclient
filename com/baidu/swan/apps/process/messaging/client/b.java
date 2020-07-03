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
/* loaded from: classes11.dex */
public class b implements a.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Deque<Message> cyM = new ArrayDeque();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void anP() {
        a anW = a.anW();
        while (anW.aoa() && !this.cyM.isEmpty()) {
            Message peek = this.cyM.peek();
            if (peek == null || A(peek)) {
                this.cyM.poll();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void ni(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull c cVar) {
        Message anQ = cVar.anQ();
        anQ.arg1 = SwanAppProcessInfo.current().index;
        if (d.apI().aok() && (anQ.obj instanceof Bundle)) {
            Bundle bundle = (Bundle) anQ.obj;
            if (!bundle.containsKey("ai_apps_id")) {
                bundle.putString("ai_apps_id", d.apI().getAppId());
            }
        }
        if (!A(anQ) && cVar.isSticky()) {
            this.cyM.offer(anQ);
            a.anW().anY();
        }
    }

    private boolean A(Message message) {
        a anW = a.anW();
        if (message != null && anW.aoa()) {
            try {
                anW.anX().send(message);
                return true;
            } catch (RemoteException e) {
                anW.aob();
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
