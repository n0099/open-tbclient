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
/* loaded from: classes11.dex */
public class d implements a.b {
    private final Map<String, Deque<Message>> cza = new HashMap();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void anP() {
        for (String str : this.cza.keySet()) {
            ni(str);
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void ni(String str) {
        Deque<Message> deque = this.cza.get(str);
        com.baidu.swan.apps.process.messaging.a.log("flushMsg:: appid=" + str + " msgQueue=" + deque);
        if (deque != null && !deque.isEmpty()) {
            List<c> no = e.aov().no(str);
            com.baidu.swan.apps.process.messaging.a.log("flushMsg:: msgQueue.size=" + deque.size() + " clients.size=" + no.size());
            if (!no.isEmpty()) {
                for (c cVar : no) {
                    cVar.g(deque);
                }
                deque.clear();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
        this.cza.remove(str);
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull com.baidu.swan.apps.process.messaging.c cVar) {
        Message anQ = cVar.anQ();
        if (cVar.anU()) {
            L(anQ);
        }
        Set<SwanAppProcessInfo> anS = cVar.anS();
        Set<String> anT = cVar.anT();
        if (cVar.isSticky()) {
            Iterator<c> it = e.aov().aox().iterator();
            while (it.hasNext()) {
                c next = it.next();
                boolean a = a(next, anT);
                if (anS.contains(next.cyQ) || a) {
                    next.K(anQ);
                    if (a) {
                        anT.remove(next.getAppId());
                    }
                }
            }
            a(anT, anQ);
            return;
        }
        Iterator<c> it2 = e.aov().aox().iterator();
        while (it2.hasNext()) {
            c next2 = it2.next();
            if (next2 != null && next2.aom() && (anS.contains(next2.cyQ) || a(next2, anT))) {
                next2.K(anQ);
            }
        }
    }

    private void L(Message message) {
        try {
            e.aov().mMessenger.send(message);
        } catch (RemoteException e) {
            com.baidu.swan.apps.process.messaging.a.log(Log.getStackTraceString(e));
        }
    }

    boolean a(@NonNull c cVar, @NonNull Set<String> set) {
        return cVar.aok() && set.contains(cVar.getAppId());
    }

    private void a(Set<String> set, @NonNull Message message) {
        for (String str : set) {
            a(str, message);
        }
    }

    private void a(String str, @NonNull Message message) {
        if (!TextUtils.isEmpty(str)) {
            Deque<Message> deque = this.cza.get(str);
            if (deque == null) {
                deque = new ArrayDeque<>();
                this.cza.put(str, deque);
            }
            deque.offer(message);
        }
    }
}
