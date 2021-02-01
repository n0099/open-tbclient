package com.baidu.swan.apps.process.messaging.service;

import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.messaging.a;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes9.dex */
public class d implements a.b {
    private final Map<String, Deque<Message>> dud = new HashMap();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void aFC() {
        for (String str : this.dud.keySet()) {
            rb(str);
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void rb(String str) {
        Deque<Message> deque = this.dud.get(str);
        com.baidu.swan.apps.process.messaging.a.log("flushMsg:: appid=" + str + " msgQueue=" + deque);
        if (deque != null && !deque.isEmpty()) {
            List<c> rh = e.aGn().rh(str);
            com.baidu.swan.apps.process.messaging.a.log("flushMsg:: msgQueue.size=" + deque.size() + " clients.size=" + rh.size());
            if (!rh.isEmpty()) {
                for (c cVar : rh) {
                    cVar.i(deque);
                }
                deque.clear();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
        this.dud.remove(str);
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull com.baidu.swan.apps.process.messaging.c cVar) {
        Message aFD = cVar.aFD();
        if (cVar.aFH()) {
            M(aFD);
        }
        Set<SwanAppProcessInfo> aFF = cVar.aFF();
        Set<String> aFG = cVar.aFG();
        if (cVar.isSticky()) {
            Iterator<c> it = e.aGn().aGp().iterator();
            while (it.hasNext()) {
                c next = it.next();
                boolean a2 = a(next, aFG);
                if (aFF.contains(next.dtR) || a2) {
                    next.L(aFD);
                    if (a2) {
                        aFG.remove(next.getAppId());
                    }
                }
            }
            a(aFG, aFD);
            return;
        }
        Iterator<c> it2 = e.aGn().aGp().iterator();
        while (it2.hasNext()) {
            c next2 = it2.next();
            if (next2 != null && next2.aGa() && (aFF.contains(next2.dtR) || a(next2, aFG))) {
                next2.L(aFD);
            }
        }
    }

    private void M(Message message) {
        try {
            e.aGn().mMessenger.send(message);
        } catch (RemoteException e) {
            com.baidu.swan.apps.process.messaging.a.log(Log.getStackTraceString(e));
        }
    }

    boolean a(@NonNull c cVar, @NonNull Set<String> set) {
        return cVar.aFY() && set.contains(cVar.getAppId());
    }

    private void a(Set<String> set, @NonNull Message message) {
        for (String str : set) {
            a(str, message);
        }
    }

    private void a(String str, @NonNull Message message) {
        if (!TextUtils.isEmpty(str)) {
            Deque<Message> deque = this.dud.get(str);
            if (deque == null) {
                deque = new ArrayDeque<>();
                this.dud.put(str, deque);
            }
            deque.offer(message);
        }
    }
}
