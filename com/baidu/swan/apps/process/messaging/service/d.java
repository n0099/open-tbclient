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
    private final Map<String, Deque<Message>> bJI = new HashMap();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void aaM() {
        for (String str : this.bJI.keySet()) {
            kt(str);
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void kt(String str) {
        Deque<Message> deque = this.bJI.get(str);
        com.baidu.swan.apps.process.messaging.a.log("flushMsg:: appid=" + str + " msgQueue=" + deque);
        if (deque != null && !deque.isEmpty()) {
            List<c> kz = e.abs().kz(str);
            com.baidu.swan.apps.process.messaging.a.log("flushMsg:: msgQueue.size=" + deque.size() + " clients.size=" + kz.size());
            if (!kz.isEmpty()) {
                for (c cVar : kz) {
                    cVar.e(deque);
                }
                deque.clear();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
        this.bJI.remove(str);
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull com.baidu.swan.apps.process.messaging.c cVar) {
        Message aaN = cVar.aaN();
        if (cVar.aaR()) {
            K(aaN);
        }
        Set<SwanAppProcessInfo> aaP = cVar.aaP();
        Set<String> aaQ = cVar.aaQ();
        if (cVar.isSticky()) {
            Iterator<c> it = e.abs().abu().iterator();
            while (it.hasNext()) {
                c next = it.next();
                boolean a = a(next, aaQ);
                if (aaP.contains(next.bJy) || a) {
                    next.J(aaN);
                    if (a) {
                        aaQ.remove(next.getAppId());
                    }
                }
            }
            a(aaQ, aaN);
            return;
        }
        Iterator<c> it2 = e.abs().abu().iterator();
        while (it2.hasNext()) {
            c next2 = it2.next();
            if (next2 != null && next2.abj() && (aaP.contains(next2.bJy) || a(next2, aaQ))) {
                next2.J(aaN);
            }
        }
    }

    private void K(Message message) {
        try {
            e.abs().mMessenger.send(message);
        } catch (RemoteException e) {
            com.baidu.swan.apps.process.messaging.a.log(Log.getStackTraceString(e));
        }
    }

    boolean a(@NonNull c cVar, @NonNull Set<String> set) {
        return cVar.abh() && set.contains(cVar.getAppId());
    }

    private void a(Set<String> set, @NonNull Message message) {
        for (String str : set) {
            a(str, message);
        }
    }

    private void a(String str, @NonNull Message message) {
        if (!TextUtils.isEmpty(str)) {
            Deque<Message> deque = this.bJI.get(str);
            if (deque == null) {
                deque = new ArrayDeque<>();
                this.bJI.put(str, deque);
            }
            deque.offer(message);
        }
    }
}
