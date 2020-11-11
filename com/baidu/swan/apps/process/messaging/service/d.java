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
    private final Map<String, Deque<Message>> dmo = new HashMap();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void aFh() {
        for (String str : this.dmo.keySet()) {
            rA(str);
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void rA(String str) {
        Deque<Message> deque = this.dmo.get(str);
        com.baidu.swan.apps.process.messaging.a.log("flushMsg:: appid=" + str + " msgQueue=" + deque);
        if (deque != null && !deque.isEmpty()) {
            List<c> rG = e.aFS().rG(str);
            com.baidu.swan.apps.process.messaging.a.log("flushMsg:: msgQueue.size=" + deque.size() + " clients.size=" + rG.size());
            if (!rG.isEmpty()) {
                for (c cVar : rG) {
                    cVar.i(deque);
                }
                deque.clear();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
        this.dmo.remove(str);
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull com.baidu.swan.apps.process.messaging.c cVar) {
        Message aFi = cVar.aFi();
        if (cVar.aFm()) {
            M(aFi);
        }
        Set<SwanAppProcessInfo> aFk = cVar.aFk();
        Set<String> aFl = cVar.aFl();
        if (cVar.isSticky()) {
            Iterator<c> it = e.aFS().aFU().iterator();
            while (it.hasNext()) {
                c next = it.next();
                boolean a2 = a(next, aFl);
                if (aFk.contains(next.dmc) || a2) {
                    next.L(aFi);
                    if (a2) {
                        aFl.remove(next.getAppId());
                    }
                }
            }
            a(aFl, aFi);
            return;
        }
        Iterator<c> it2 = e.aFS().aFU().iterator();
        while (it2.hasNext()) {
            c next2 = it2.next();
            if (next2 != null && next2.aFF() && (aFk.contains(next2.dmc) || a(next2, aFl))) {
                next2.L(aFi);
            }
        }
    }

    private void M(Message message) {
        try {
            e.aFS().mMessenger.send(message);
        } catch (RemoteException e) {
            com.baidu.swan.apps.process.messaging.a.log(Log.getStackTraceString(e));
        }
    }

    boolean a(@NonNull c cVar, @NonNull Set<String> set) {
        return cVar.aFD() && set.contains(cVar.getAppId());
    }

    private void a(Set<String> set, @NonNull Message message) {
        for (String str : set) {
            a(str, message);
        }
    }

    private void a(String str, @NonNull Message message) {
        if (!TextUtils.isEmpty(str)) {
            Deque<Message> deque = this.dmo.get(str);
            if (deque == null) {
                deque = new ArrayDeque<>();
                this.dmo.put(str, deque);
            }
            deque.offer(message);
        }
    }
}
