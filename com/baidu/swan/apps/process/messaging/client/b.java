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
/* loaded from: classes7.dex */
public class b implements a.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Deque<Message> cBm = new ArrayDeque();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void apz() {
        a apG = a.apG();
        while (apG.apK() && !this.cBm.isEmpty()) {
            Message peek = this.cBm.peek();
            if (peek == null || A(peek)) {
                this.cBm.poll();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void nP(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull c cVar) {
        Message apA = cVar.apA();
        apA.arg1 = SwanAppProcessInfo.current().index;
        if (d.arr().apU() && (apA.obj instanceof Bundle)) {
            Bundle bundle = (Bundle) apA.obj;
            if (!bundle.containsKey("ai_apps_id")) {
                bundle.putString("ai_apps_id", d.arr().getAppId());
            }
        }
        if (!A(apA) && cVar.isSticky()) {
            this.cBm.offer(apA);
            a.apG().apI();
        }
    }

    private boolean A(Message message) {
        a apG = a.apG();
        if (message != null && apG.apK()) {
            try {
                apG.apH().send(message);
                return true;
            } catch (RemoteException e) {
                apG.apL();
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
