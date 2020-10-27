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
    private final Map<String, Deque<Message>> dgt = new HashMap();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void aCH() {
        for (String str : this.dgt.keySet()) {
            rm(str);
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void rm(String str) {
        Deque<Message> deque = this.dgt.get(str);
        com.baidu.swan.apps.process.messaging.a.log("flushMsg:: appid=" + str + " msgQueue=" + deque);
        if (deque != null && !deque.isEmpty()) {
            List<c> rs = e.aDs().rs(str);
            com.baidu.swan.apps.process.messaging.a.log("flushMsg:: msgQueue.size=" + deque.size() + " clients.size=" + rs.size());
            if (!rs.isEmpty()) {
                for (c cVar : rs) {
                    cVar.i(deque);
                }
                deque.clear();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
        this.dgt.remove(str);
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull com.baidu.swan.apps.process.messaging.c cVar) {
        Message aCI = cVar.aCI();
        if (cVar.aCM()) {
            M(aCI);
        }
        Set<SwanAppProcessInfo> aCK = cVar.aCK();
        Set<String> aCL = cVar.aCL();
        if (cVar.isSticky()) {
            Iterator<c> it = e.aDs().aDu().iterator();
            while (it.hasNext()) {
                c next = it.next();
                boolean a2 = a(next, aCL);
                if (aCK.contains(next.dgh) || a2) {
                    next.L(aCI);
                    if (a2) {
                        aCL.remove(next.getAppId());
                    }
                }
            }
            a(aCL, aCI);
            return;
        }
        Iterator<c> it2 = e.aDs().aDu().iterator();
        while (it2.hasNext()) {
            c next2 = it2.next();
            if (next2 != null && next2.aDf() && (aCK.contains(next2.dgh) || a(next2, aCL))) {
                next2.L(aCI);
            }
        }
    }

    private void M(Message message) {
        try {
            e.aDs().mMessenger.send(message);
        } catch (RemoteException e) {
            com.baidu.swan.apps.process.messaging.a.log(Log.getStackTraceString(e));
        }
    }

    boolean a(@NonNull c cVar, @NonNull Set<String> set) {
        return cVar.aDd() && set.contains(cVar.getAppId());
    }

    private void a(Set<String> set, @NonNull Message message) {
        for (String str : set) {
            a(str, message);
        }
    }

    private void a(String str, @NonNull Message message) {
        if (!TextUtils.isEmpty(str)) {
            Deque<Message> deque = this.dgt.get(str);
            if (deque == null) {
                deque = new ArrayDeque<>();
                this.dgt.put(str, deque);
            }
            deque.offer(message);
        }
    }
}
