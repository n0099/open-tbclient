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
/* loaded from: classes10.dex */
public class b implements a.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Deque<Message> bFo = new ArrayDeque();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void Yy() {
        a YF = a.YF();
        while (YF.YJ() && !this.bFo.isEmpty()) {
            Message peek = this.bFo.peek();
            if (peek == null || z(peek)) {
                this.bFo.poll();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void ke(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull c cVar) {
        Message Yz = cVar.Yz();
        Yz.arg1 = SwanAppProcessInfo.current().index;
        if (d.aam().YT() && (Yz.obj instanceof Bundle)) {
            Bundle bundle = (Bundle) Yz.obj;
            if (!bundle.containsKey("ai_apps_id")) {
                bundle.putString("ai_apps_id", d.aam().getAppId());
            }
        }
        if (!z(Yz) && cVar.isSticky()) {
            this.bFo.offer(Yz);
            a.YF().YH();
        }
    }

    private boolean z(Message message) {
        a YF = a.YF();
        if (message != null && YF.YJ()) {
            try {
                YF.YG().send(message);
                return true;
            } catch (RemoteException e) {
                YF.YK();
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
