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
    private final Deque<Message> dgd = new ArrayDeque();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void aCH() {
        a aCO = a.aCO();
        while (aCO.aCS() && !this.dgd.isEmpty()) {
            Message peek = this.dgd.peek();
            if (peek == null || B(peek)) {
                this.dgd.poll();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void rm(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull c cVar) {
        Message aCI = cVar.aCI();
        aCI.arg1 = SwanAppProcessInfo.current().index;
        if (d.aEQ().aDd() && (aCI.obj instanceof Bundle)) {
            Bundle bundle = (Bundle) aCI.obj;
            if (!bundle.containsKey("ai_apps_id")) {
                bundle.putString("ai_apps_id", d.aEQ().getAppId());
            }
        }
        if (!B(aCI) && cVar.isSticky()) {
            this.dgd.offer(aCI);
            a.aCO().aCQ();
        }
    }

    private boolean B(Message message) {
        a aCO = a.aCO();
        if (message != null && aCO.aCS()) {
            try {
                aCO.aCP().send(message);
                return true;
            } catch (RemoteException e) {
                aCO.aCT();
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
