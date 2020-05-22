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
    private final Map<String, Deque<Message>> cun = new HashMap();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void amJ() {
        for (String str : this.cun.keySet()) {
            na(str);
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void na(String str) {
        Deque<Message> deque = this.cun.get(str);
        com.baidu.swan.apps.process.messaging.a.log("flushMsg:: appid=" + str + " msgQueue=" + deque);
        if (deque != null && !deque.isEmpty()) {
            List<c> ng = e.anp().ng(str);
            com.baidu.swan.apps.process.messaging.a.log("flushMsg:: msgQueue.size=" + deque.size() + " clients.size=" + ng.size());
            if (!ng.isEmpty()) {
                for (c cVar : ng) {
                    cVar.g(deque);
                }
                deque.clear();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
        this.cun.remove(str);
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull com.baidu.swan.apps.process.messaging.c cVar) {
        Message amK = cVar.amK();
        if (cVar.amO()) {
            L(amK);
        }
        Set<SwanAppProcessInfo> amM = cVar.amM();
        Set<String> amN = cVar.amN();
        if (cVar.isSticky()) {
            Iterator<c> it = e.anp().anr().iterator();
            while (it.hasNext()) {
                c next = it.next();
                boolean a = a(next, amN);
                if (amM.contains(next.cud) || a) {
                    next.K(amK);
                    if (a) {
                        amN.remove(next.getAppId());
                    }
                }
            }
            a(amN, amK);
            return;
        }
        Iterator<c> it2 = e.anp().anr().iterator();
        while (it2.hasNext()) {
            c next2 = it2.next();
            if (next2 != null && next2.ang() && (amM.contains(next2.cud) || a(next2, amN))) {
                next2.K(amK);
            }
        }
    }

    private void L(Message message) {
        try {
            e.anp().mMessenger.send(message);
        } catch (RemoteException e) {
            com.baidu.swan.apps.process.messaging.a.log(Log.getStackTraceString(e));
        }
    }

    boolean a(@NonNull c cVar, @NonNull Set<String> set) {
        return cVar.ane() && set.contains(cVar.getAppId());
    }

    private void a(Set<String> set, @NonNull Message message) {
        for (String str : set) {
            a(str, message);
        }
    }

    private void a(String str, @NonNull Message message) {
        if (!TextUtils.isEmpty(str)) {
            Deque<Message> deque = this.cun.get(str);
            if (deque == null) {
                deque = new ArrayDeque<>();
                this.cun.put(str, deque);
            }
            deque.offer(message);
        }
    }
}
