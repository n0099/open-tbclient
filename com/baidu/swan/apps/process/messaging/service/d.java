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
    private final Map<String, Deque<Message>> ciF = new HashMap();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void aiW() {
        for (String str : this.ciF.keySet()) {
            lF(str);
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void lF(String str) {
        Deque<Message> deque = this.ciF.get(str);
        com.baidu.swan.apps.process.messaging.a.log("flushMsg:: appid=" + str + " msgQueue=" + deque);
        if (deque != null && !deque.isEmpty()) {
            List<c> lL = e.ajC().lL(str);
            com.baidu.swan.apps.process.messaging.a.log("flushMsg:: msgQueue.size=" + deque.size() + " clients.size=" + lL.size());
            if (!lL.isEmpty()) {
                for (c cVar : lL) {
                    cVar.e(deque);
                }
                deque.clear();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
        this.ciF.remove(str);
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull com.baidu.swan.apps.process.messaging.c cVar) {
        Message aiX = cVar.aiX();
        if (cVar.ajb()) {
            K(aiX);
        }
        Set<SwanAppProcessInfo> aiZ = cVar.aiZ();
        Set<String> aja = cVar.aja();
        if (cVar.isSticky()) {
            Iterator<c> it = e.ajC().ajE().iterator();
            while (it.hasNext()) {
                c next = it.next();
                boolean a = a(next, aja);
                if (aiZ.contains(next.civ) || a) {
                    next.J(aiX);
                    if (a) {
                        aja.remove(next.getAppId());
                    }
                }
            }
            a(aja, aiX);
            return;
        }
        Iterator<c> it2 = e.ajC().ajE().iterator();
        while (it2.hasNext()) {
            c next2 = it2.next();
            if (next2 != null && next2.ajt() && (aiZ.contains(next2.civ) || a(next2, aja))) {
                next2.J(aiX);
            }
        }
    }

    private void K(Message message) {
        try {
            e.ajC().mMessenger.send(message);
        } catch (RemoteException e) {
            com.baidu.swan.apps.process.messaging.a.log(Log.getStackTraceString(e));
        }
    }

    boolean a(@NonNull c cVar, @NonNull Set<String> set) {
        return cVar.ajr() && set.contains(cVar.getAppId());
    }

    private void a(Set<String> set, @NonNull Message message) {
        for (String str : set) {
            a(str, message);
        }
    }

    private void a(String str, @NonNull Message message) {
        if (!TextUtils.isEmpty(str)) {
            Deque<Message> deque = this.ciF.get(str);
            if (deque == null) {
                deque = new ArrayDeque<>();
                this.ciF.put(str, deque);
            }
            deque.offer(message);
        }
    }
}
