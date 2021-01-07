package com.baidu.swan.apps.process.messaging.client;

import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.messaging.a;
import com.baidu.swan.apps.process.messaging.c;
import com.baidu.swan.apps.runtime.d;
import java.util.ArrayDeque;
import java.util.Deque;
/* loaded from: classes9.dex */
public class b implements a.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Deque<Message> dwp = new ArrayDeque();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void aJb() {
        a aJi = a.aJi();
        while (aJi.aJm() && !this.dwp.isEmpty()) {
            Message peek = this.dwp.peek();
            if (peek == null || B(peek)) {
                this.dwp.poll();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void rU(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull c cVar) {
        Message aJc = cVar.aJc();
        aJc.arg1 = SwanAppProcessInfo.current().index;
        if (d.aMh().aJx() && (aJc.obj instanceof Bundle)) {
            Bundle bundle = (Bundle) aJc.obj;
            if (!bundle.containsKey("ai_apps_id")) {
                bundle.putString("ai_apps_id", d.aMh().getAppId());
            }
        }
        if (!B(aJc) && cVar.isSticky()) {
            this.dwp.offer(aJc);
            a.aJi().aJk();
        }
    }

    private boolean B(Message message) {
        a aJi = a.aJi();
        if (message != null && aJi.aJm()) {
            try {
                aJi.aJj().send(message);
                return true;
            } catch (RemoteException e) {
                aJi.aJn();
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
