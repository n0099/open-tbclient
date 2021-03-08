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
/* loaded from: classes8.dex */
public class b implements a.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Deque<Message> dvo = new ArrayDeque();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void aFF() {
        a aFM = a.aFM();
        while (aFM.aFQ() && !this.dvo.isEmpty()) {
            Message peek = this.dvo.peek();
            if (peek == null || B(peek)) {
                this.dvo.poll();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void ri(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull c cVar) {
        Message aFG = cVar.aFG();
        aFG.arg1 = SwanAppProcessInfo.current().index;
        if (d.aIJ().aGb() && (aFG.obj instanceof Bundle)) {
            Bundle bundle = (Bundle) aFG.obj;
            if (!bundle.containsKey("ai_apps_id")) {
                bundle.putString("ai_apps_id", d.aIJ().getAppId());
            }
        }
        if (!B(aFG) && cVar.isSticky()) {
            this.dvo.offer(aFG);
            a.aFM().aFO();
        }
    }

    private boolean B(Message message) {
        a aFM = a.aFM();
        if (message != null && aFM.aFQ()) {
            try {
                aFM.aFN().send(message);
                return true;
            } catch (RemoteException e) {
                aFM.aFR();
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
