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
    private final Deque<Message> ciq = new ArrayDeque();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void aiW() {
        a ajd = a.ajd();
        while (ajd.ajh() && !this.ciq.isEmpty()) {
            Message peek = this.ciq.peek();
            if (peek == null || z(peek)) {
                this.ciq.poll();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void lF(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull c cVar) {
        Message aiX = cVar.aiX();
        aiX.arg1 = SwanAppProcessInfo.current().index;
        if (d.akK().ajr() && (aiX.obj instanceof Bundle)) {
            Bundle bundle = (Bundle) aiX.obj;
            if (!bundle.containsKey("ai_apps_id")) {
                bundle.putString("ai_apps_id", d.akK().getAppId());
            }
        }
        if (!z(aiX) && cVar.isSticky()) {
            this.ciq.offer(aiX);
            a.ajd().ajf();
        }
    }

    private boolean z(Message message) {
        a ajd = a.ajd();
        if (message != null && ajd.ajh()) {
            try {
                ajd.aje().send(message);
                return true;
            } catch (RemoteException e) {
                ajd.aji();
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
