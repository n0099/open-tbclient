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
    private final Deque<Message> bJu = new ArrayDeque();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void aaO() {
        a aaV = a.aaV();
        while (aaV.aaZ() && !this.bJu.isEmpty()) {
            Message peek = this.bJu.peek();
            if (peek == null || z(peek)) {
                this.bJu.poll();
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
        Message aaP = cVar.aaP();
        aaP.arg1 = SwanAppProcessInfo.current().index;
        if (d.acC().abj() && (aaP.obj instanceof Bundle)) {
            Bundle bundle = (Bundle) aaP.obj;
            if (!bundle.containsKey("ai_apps_id")) {
                bundle.putString("ai_apps_id", d.acC().getAppId());
            }
        }
        if (!z(aaP) && cVar.isSticky()) {
            this.bJu.offer(aaP);
            a.aaV().aaX();
        }
    }

    private boolean z(Message message) {
        a aaV = a.aaV();
        if (message != null && aaV.aaZ()) {
            try {
                aaV.aaW().send(message);
                return true;
            } catch (RemoteException e) {
                aaV.aba();
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
