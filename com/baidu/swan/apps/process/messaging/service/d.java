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
/* loaded from: classes7.dex */
public class d implements a.b {
    private final Map<String, Deque<Message>> dkH = new HashMap();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void aEz() {
        for (String str : this.dkH.keySet()) {
            ru(str);
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void ru(String str) {
        Deque<Message> deque = this.dkH.get(str);
        com.baidu.swan.apps.process.messaging.a.log("flushMsg:: appid=" + str + " msgQueue=" + deque);
        if (deque != null && !deque.isEmpty()) {
            List<c> rA = e.aFk().rA(str);
            com.baidu.swan.apps.process.messaging.a.log("flushMsg:: msgQueue.size=" + deque.size() + " clients.size=" + rA.size());
            if (!rA.isEmpty()) {
                for (c cVar : rA) {
                    cVar.i(deque);
                }
                deque.clear();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
        this.dkH.remove(str);
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull com.baidu.swan.apps.process.messaging.c cVar) {
        Message aEA = cVar.aEA();
        if (cVar.aEE()) {
            M(aEA);
        }
        Set<SwanAppProcessInfo> aEC = cVar.aEC();
        Set<String> aED = cVar.aED();
        if (cVar.isSticky()) {
            Iterator<c> it = e.aFk().aFm().iterator();
            while (it.hasNext()) {
                c next = it.next();
                boolean a2 = a(next, aED);
                if (aEC.contains(next.dkv) || a2) {
                    next.L(aEA);
                    if (a2) {
                        aED.remove(next.getAppId());
                    }
                }
            }
            a(aED, aEA);
            return;
        }
        Iterator<c> it2 = e.aFk().aFm().iterator();
        while (it2.hasNext()) {
            c next2 = it2.next();
            if (next2 != null && next2.aEX() && (aEC.contains(next2.dkv) || a(next2, aED))) {
                next2.L(aEA);
            }
        }
    }

    private void M(Message message) {
        try {
            e.aFk().mMessenger.send(message);
        } catch (RemoteException e) {
            com.baidu.swan.apps.process.messaging.a.log(Log.getStackTraceString(e));
        }
    }

    boolean a(@NonNull c cVar, @NonNull Set<String> set) {
        return cVar.aEV() && set.contains(cVar.getAppId());
    }

    private void a(Set<String> set, @NonNull Message message) {
        for (String str : set) {
            a(str, message);
        }
    }

    private void a(String str, @NonNull Message message) {
        if (!TextUtils.isEmpty(str)) {
            Deque<Message> deque = this.dkH.get(str);
            if (deque == null) {
                deque = new ArrayDeque<>();
                this.dkH.put(str, deque);
            }
            deque.offer(message);
        }
    }
}
