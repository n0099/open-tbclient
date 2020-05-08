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
    private final Deque<Message> ciw = new ArrayDeque();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void aiV() {
        a ajc = a.ajc();
        while (ajc.ajg() && !this.ciw.isEmpty()) {
            Message peek = this.ciw.peek();
            if (peek == null || z(peek)) {
                this.ciw.poll();
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
        Message aiW = cVar.aiW();
        aiW.arg1 = SwanAppProcessInfo.current().index;
        if (d.akJ().ajq() && (aiW.obj instanceof Bundle)) {
            Bundle bundle = (Bundle) aiW.obj;
            if (!bundle.containsKey("ai_apps_id")) {
                bundle.putString("ai_apps_id", d.akJ().getAppId());
            }
        }
        if (!z(aiW) && cVar.isSticky()) {
            this.ciw.offer(aiW);
            a.ajc().aje();
        }
    }

    private boolean z(Message message) {
        a ajc = a.ajc();
        if (message != null && ajc.ajg()) {
            try {
                ajc.ajd().send(message);
                return true;
            } catch (RemoteException e) {
                ajc.ajh();
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
