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
    private final Map<String, Deque<Message>> bJV = new HashMap();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void aaR() {
        for (String str : this.bJV.keySet()) {
            ks(str);
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void ks(String str) {
        Deque<Message> deque = this.bJV.get(str);
        com.baidu.swan.apps.process.messaging.a.log("flushMsg:: appid=" + str + " msgQueue=" + deque);
        if (deque != null && !deque.isEmpty()) {
            List<c> ky = e.abx().ky(str);
            com.baidu.swan.apps.process.messaging.a.log("flushMsg:: msgQueue.size=" + deque.size() + " clients.size=" + ky.size());
            if (!ky.isEmpty()) {
                for (c cVar : ky) {
                    cVar.e(deque);
                }
                deque.clear();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
        this.bJV.remove(str);
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull com.baidu.swan.apps.process.messaging.c cVar) {
        Message aaS = cVar.aaS();
        if (cVar.aaW()) {
            K(aaS);
        }
        Set<SwanAppProcessInfo> aaU = cVar.aaU();
        Set<String> aaV = cVar.aaV();
        if (cVar.isSticky()) {
            Iterator<c> it = e.abx().abz().iterator();
            while (it.hasNext()) {
                c next = it.next();
                boolean a = a(next, aaV);
                if (aaU.contains(next.bJL) || a) {
                    next.J(aaS);
                    if (a) {
                        aaV.remove(next.getAppId());
                    }
                }
            }
            a(aaV, aaS);
            return;
        }
        Iterator<c> it2 = e.abx().abz().iterator();
        while (it2.hasNext()) {
            c next2 = it2.next();
            if (next2 != null && next2.abo() && (aaU.contains(next2.bJL) || a(next2, aaV))) {
                next2.J(aaS);
            }
        }
    }

    private void K(Message message) {
        try {
            e.abx().mMessenger.send(message);
        } catch (RemoteException e) {
            com.baidu.swan.apps.process.messaging.a.log(Log.getStackTraceString(e));
        }
    }

    boolean a(@NonNull c cVar, @NonNull Set<String> set) {
        return cVar.abm() && set.contains(cVar.getAppId());
    }

    private void a(Set<String> set, @NonNull Message message) {
        for (String str : set) {
            a(str, message);
        }
    }

    private void a(String str, @NonNull Message message) {
        if (!TextUtils.isEmpty(str)) {
            Deque<Message> deque = this.bJV.get(str);
            if (deque == null) {
                deque = new ArrayDeque<>();
                this.bJV.put(str, deque);
            }
            deque.offer(message);
        }
    }
}
