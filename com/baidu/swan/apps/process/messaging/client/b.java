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
    private final Deque<Message> dtN = new ArrayDeque();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void aFC() {
        a aFJ = a.aFJ();
        while (aFJ.aFN() && !this.dtN.isEmpty()) {
            Message peek = this.dtN.peek();
            if (peek == null || B(peek)) {
                this.dtN.poll();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void rb(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull c cVar) {
        Message aFD = cVar.aFD();
        aFD.arg1 = SwanAppProcessInfo.current().index;
        if (d.aIG().aFY() && (aFD.obj instanceof Bundle)) {
            Bundle bundle = (Bundle) aFD.obj;
            if (!bundle.containsKey("ai_apps_id")) {
                bundle.putString("ai_apps_id", d.aIG().getAppId());
            }
        }
        if (!B(aFD) && cVar.isSticky()) {
            this.dtN.offer(aFD);
            a.aFJ().aFL();
        }
    }

    private boolean B(Message message) {
        a aFJ = a.aFJ();
        if (message != null && aFJ.aFN()) {
            try {
                aFJ.aFK().send(message);
                return true;
            } catch (RemoteException e) {
                aFJ.aFO();
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
