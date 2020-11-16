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
/* loaded from: classes7.dex */
public class b implements a.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Deque<Message> dkr = new ArrayDeque();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void aEz() {
        a aEG = a.aEG();
        while (aEG.aEK() && !this.dkr.isEmpty()) {
            Message peek = this.dkr.peek();
            if (peek == null || B(peek)) {
                this.dkr.poll();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void ru(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull c cVar) {
        Message aEA = cVar.aEA();
        aEA.arg1 = SwanAppProcessInfo.current().index;
        if (d.aGI().aEV() && (aEA.obj instanceof Bundle)) {
            Bundle bundle = (Bundle) aEA.obj;
            if (!bundle.containsKey("ai_apps_id")) {
                bundle.putString("ai_apps_id", d.aGI().getAppId());
            }
        }
        if (!B(aEA) && cVar.isSticky()) {
            this.dkr.offer(aEA);
            a.aEG().aEI();
        }
    }

    private boolean B(Message message) {
        a aEG = a.aEG();
        if (message != null && aEG.aEK()) {
            try {
                aEG.aEH().send(message);
                return true;
            } catch (RemoteException e) {
                aEG.aEL();
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
