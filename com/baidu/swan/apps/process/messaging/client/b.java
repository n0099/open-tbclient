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
/* loaded from: classes3.dex */
public class b implements a.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Deque<Message> cLz = new ArrayDeque();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void aye() {
        a ayl = a.ayl();
        while (ayl.ayp() && !this.cLz.isEmpty()) {
            Message peek = this.cLz.peek();
            if (peek == null || B(peek)) {
                this.cLz.poll();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void qh(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull c cVar) {
        Message ayf = cVar.ayf();
        ayf.arg1 = SwanAppProcessInfo.current().index;
        if (d.aAn().ayA() && (ayf.obj instanceof Bundle)) {
            Bundle bundle = (Bundle) ayf.obj;
            if (!bundle.containsKey("ai_apps_id")) {
                bundle.putString("ai_apps_id", d.aAn().getAppId());
            }
        }
        if (!B(ayf) && cVar.isSticky()) {
            this.cLz.offer(ayf);
            a.ayl().ayn();
        }
    }

    private boolean B(Message message) {
        a ayl = a.ayl();
        if (message != null && ayl.ayp()) {
            try {
                ayl.aym().send(message);
                return true;
            } catch (RemoteException e) {
                ayl.ayq();
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
