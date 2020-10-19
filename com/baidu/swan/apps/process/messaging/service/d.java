package com.baidu.swan.apps.process.messaging.service;

import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.messaging.a;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes10.dex */
public class d implements a.b {
    private final Map<String, Deque<Message>> cXS = new HashMap();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void aAN() {
        for (String str : this.cXS.keySet()) {
            qT(str);
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void qT(String str) {
        Deque<Message> deque = this.cXS.get(str);
        com.baidu.swan.apps.process.messaging.a.log("flushMsg:: appid=" + str + " msgQueue=" + deque);
        if (deque != null && !deque.isEmpty()) {
            List<c> qZ = e.aBy().qZ(str);
            com.baidu.swan.apps.process.messaging.a.log("flushMsg:: msgQueue.size=" + deque.size() + " clients.size=" + qZ.size());
            if (!qZ.isEmpty()) {
                for (c cVar : qZ) {
                    cVar.i(deque);
                }
                deque.clear();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
        this.cXS.remove(str);
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull com.baidu.swan.apps.process.messaging.c cVar) {
        Message aAO = cVar.aAO();
        if (cVar.aAS()) {
            M(aAO);
        }
        Set<SwanAppProcessInfo> aAQ = cVar.aAQ();
        Set<String> aAR = cVar.aAR();
        if (cVar.isSticky()) {
            Iterator<c> it = e.aBy().aBA().iterator();
            while (it.hasNext()) {
                c next = it.next();
                boolean a2 = a(next, aAR);
                if (aAQ.contains(next.cXG) || a2) {
                    next.L(aAO);
                    if (a2) {
                        aAR.remove(next.getAppId());
                    }
                }
            }
            a(aAR, aAO);
            return;
        }
        Iterator<c> it2 = e.aBy().aBA().iterator();
        while (it2.hasNext()) {
            c next2 = it2.next();
            if (next2 != null && next2.aBl() && (aAQ.contains(next2.cXG) || a(next2, aAR))) {
                next2.L(aAO);
            }
        }
    }

    private void M(Message message) {
        try {
            e.aBy().mMessenger.send(message);
        } catch (RemoteException e) {
            com.baidu.swan.apps.process.messaging.a.log(Log.getStackTraceString(e));
        }
    }

    boolean a(@NonNull c cVar, @NonNull Set<String> set) {
        return cVar.aBj() && set.contains(cVar.getAppId());
    }

    private void a(Set<String> set, @NonNull Message message) {
        for (String str : set) {
            a(str, message);
        }
    }

    private void a(String str, @NonNull Message message) {
        if (!TextUtils.isEmpty(str)) {
            Deque<Message> deque = this.cXS.get(str);
            if (deque == null) {
                deque = new ArrayDeque<>();
                this.cXS.put(str, deque);
            }
            deque.offer(message);
        }
    }
}
