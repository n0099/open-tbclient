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
    private final Deque<Message> bJt = new ArrayDeque();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void aaM() {
        a aaT = a.aaT();
        while (aaT.aaX() && !this.bJt.isEmpty()) {
            Message peek = this.bJt.peek();
            if (peek == null || z(peek)) {
                this.bJt.poll();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void kt(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull c cVar) {
        Message aaN = cVar.aaN();
        aaN.arg1 = SwanAppProcessInfo.current().index;
        if (d.acA().abh() && (aaN.obj instanceof Bundle)) {
            Bundle bundle = (Bundle) aaN.obj;
            if (!bundle.containsKey("ai_apps_id")) {
                bundle.putString("ai_apps_id", d.acA().getAppId());
            }
        }
        if (!z(aaN) && cVar.isSticky()) {
            this.bJt.offer(aaN);
            a.aaT().aaV();
        }
    }

    private boolean z(Message message) {
        a aaT = a.aaT();
        if (message != null && aaT.aaX()) {
            try {
                aaT.aaU().send(message);
                return true;
            } catch (RemoteException e) {
                aaT.aaY();
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
