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
    private final Deque<Message> drB = new ArrayDeque();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void aFh() {
        a aFo = a.aFo();
        while (aFo.aFs() && !this.drB.isEmpty()) {
            Message peek = this.drB.peek();
            if (peek == null || B(peek)) {
                this.drB.poll();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void qJ(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull c cVar) {
        Message aFi = cVar.aFi();
        aFi.arg1 = SwanAppProcessInfo.current().index;
        if (d.aIn().aFD() && (aFi.obj instanceof Bundle)) {
            Bundle bundle = (Bundle) aFi.obj;
            if (!bundle.containsKey("ai_apps_id")) {
                bundle.putString("ai_apps_id", d.aIn().getAppId());
            }
        }
        if (!B(aFi) && cVar.isSticky()) {
            this.drB.offer(aFi);
            a.aFo().aFq();
        }
    }

    private boolean B(Message message) {
        a aFo = a.aFo();
        if (message != null && aFo.aFs()) {
            try {
                aFo.aFp().send(message);
                return true;
            } catch (RemoteException e) {
                aFo.aFt();
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
