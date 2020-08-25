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
/* loaded from: classes8.dex */
public class d implements a.b {
    private final Map<String, Deque<Message>> cJL = new HashMap();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void axv() {
        for (String str : this.cJL.keySet()) {
            pN(str);
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void pN(String str) {
        Deque<Message> deque = this.cJL.get(str);
        com.baidu.swan.apps.process.messaging.a.log("flushMsg:: appid=" + str + " msgQueue=" + deque);
        if (deque != null && !deque.isEmpty()) {
            List<c> pT = e.ayg().pT(str);
            com.baidu.swan.apps.process.messaging.a.log("flushMsg:: msgQueue.size=" + deque.size() + " clients.size=" + pT.size());
            if (!pT.isEmpty()) {
                for (c cVar : pT) {
                    cVar.i(deque);
                }
                deque.clear();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
        this.cJL.remove(str);
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull com.baidu.swan.apps.process.messaging.c cVar) {
        Message axw = cVar.axw();
        if (cVar.axA()) {
            M(axw);
        }
        Set<SwanAppProcessInfo> axy = cVar.axy();
        Set<String> axz = cVar.axz();
        if (cVar.isSticky()) {
            Iterator<c> it = e.ayg().ayi().iterator();
            while (it.hasNext()) {
                c next = it.next();
                boolean a = a(next, axz);
                if (axy.contains(next.cJz) || a) {
                    next.L(axw);
                    if (a) {
                        axz.remove(next.getAppId());
                    }
                }
            }
            a(axz, axw);
            return;
        }
        Iterator<c> it2 = e.ayg().ayi().iterator();
        while (it2.hasNext()) {
            c next2 = it2.next();
            if (next2 != null && next2.axT() && (axy.contains(next2.cJz) || a(next2, axz))) {
                next2.L(axw);
            }
        }
    }

    private void M(Message message) {
        try {
            e.ayg().mMessenger.send(message);
        } catch (RemoteException e) {
            com.baidu.swan.apps.process.messaging.a.log(Log.getStackTraceString(e));
        }
    }

    boolean a(@NonNull c cVar, @NonNull Set<String> set) {
        return cVar.axR() && set.contains(cVar.getAppId());
    }

    private void a(Set<String> set, @NonNull Message message) {
        for (String str : set) {
            a(str, message);
        }
    }

    private void a(String str, @NonNull Message message) {
        if (!TextUtils.isEmpty(str)) {
            Deque<Message> deque = this.cJL.get(str);
            if (deque == null) {
                deque = new ArrayDeque<>();
                this.cJL.put(str, deque);
            }
            deque.offer(message);
        }
    }
}
