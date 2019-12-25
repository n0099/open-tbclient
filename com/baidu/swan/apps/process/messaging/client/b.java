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
/* loaded from: classes9.dex */
public class b implements a.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Deque<Message> bED = new ArrayDeque();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void Yb() {
        a Yi = a.Yi();
        while (Yi.Ym() && !this.bED.isEmpty()) {
            Message peek = this.bED.peek();
            if (peek == null || z(peek)) {
                this.bED.poll();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void kb(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull c cVar) {
        Message Yc = cVar.Yc();
        Yc.arg1 = SwanAppProcessInfo.current().index;
        if (d.ZP().Yw() && (Yc.obj instanceof Bundle)) {
            Bundle bundle = (Bundle) Yc.obj;
            if (!bundle.containsKey("ai_apps_id")) {
                bundle.putString("ai_apps_id", d.ZP().getAppId());
            }
        }
        if (!z(Yc) && cVar.isSticky()) {
            this.bED.offer(Yc);
            a.Yi().Yk();
        }
    }

    private boolean z(Message message) {
        a Yi = a.Yi();
        if (message != null && Yi.Ym()) {
            try {
                Yi.Yj().send(message);
                return true;
            } catch (RemoteException e) {
                Yi.Yn();
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
