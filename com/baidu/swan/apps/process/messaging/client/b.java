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
    private final Deque<Message> bJG = new ArrayDeque();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void aaR() {
        a aaY = a.aaY();
        while (aaY.abc() && !this.bJG.isEmpty()) {
            Message peek = this.bJG.peek();
            if (peek == null || z(peek)) {
                this.bJG.poll();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void ks(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull c cVar) {
        Message aaS = cVar.aaS();
        aaS.arg1 = SwanAppProcessInfo.current().index;
        if (d.acF().abm() && (aaS.obj instanceof Bundle)) {
            Bundle bundle = (Bundle) aaS.obj;
            if (!bundle.containsKey("ai_apps_id")) {
                bundle.putString("ai_apps_id", d.acF().getAppId());
            }
        }
        if (!z(aaS) && cVar.isSticky()) {
            this.bJG.offer(aaS);
            a.aaY().aba();
        }
    }

    private boolean z(Message message) {
        a aaY = a.aaY();
        if (message != null && aaY.abc()) {
            try {
                aaY.aaZ().send(message);
                return true;
            } catch (RemoteException e) {
                aaY.abd();
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
