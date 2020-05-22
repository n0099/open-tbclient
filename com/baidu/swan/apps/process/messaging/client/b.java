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
    private final Deque<Message> ctZ = new ArrayDeque();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void amJ() {
        a amQ = a.amQ();
        while (amQ.amU() && !this.ctZ.isEmpty()) {
            Message peek = this.ctZ.peek();
            if (peek == null || A(peek)) {
                this.ctZ.poll();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void na(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull c cVar) {
        Message amK = cVar.amK();
        amK.arg1 = SwanAppProcessInfo.current().index;
        if (d.aoB().ane() && (amK.obj instanceof Bundle)) {
            Bundle bundle = (Bundle) amK.obj;
            if (!bundle.containsKey("ai_apps_id")) {
                bundle.putString("ai_apps_id", d.aoB().getAppId());
            }
        }
        if (!A(amK) && cVar.isSticky()) {
            this.ctZ.offer(amK);
            a.amQ().amS();
        }
    }

    private boolean A(Message message) {
        a amQ = a.amQ();
        if (message != null && amQ.amU()) {
            try {
                amQ.amR().send(message);
                return true;
            } catch (RemoteException e) {
                amQ.amV();
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
