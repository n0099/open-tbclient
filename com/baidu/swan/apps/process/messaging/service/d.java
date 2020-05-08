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
    private final Map<String, Deque<Message>> ciL = new HashMap();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void aiV() {
        for (String str : this.ciL.keySet()) {
            lF(str);
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void lF(String str) {
        Deque<Message> deque = this.ciL.get(str);
        com.baidu.swan.apps.process.messaging.a.log("flushMsg:: appid=" + str + " msgQueue=" + deque);
        if (deque != null && !deque.isEmpty()) {
            List<c> lL = e.ajB().lL(str);
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
        this.ciL.remove(str);
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull com.baidu.swan.apps.process.messaging.c cVar) {
        Message aiW = cVar.aiW();
        if (cVar.aja()) {
            K(aiW);
        }
        Set<SwanAppProcessInfo> aiY = cVar.aiY();
        Set<String> aiZ = cVar.aiZ();
        if (cVar.isSticky()) {
            Iterator<c> it = e.ajB().ajD().iterator();
            while (it.hasNext()) {
                c next = it.next();
                boolean a = a(next, aiZ);
                if (aiY.contains(next.ciB) || a) {
                    next.J(aiW);
                    if (a) {
                        aiZ.remove(next.getAppId());
                    }
                }
            }
            a(aiZ, aiW);
            return;
        }
        Iterator<c> it2 = e.ajB().ajD().iterator();
        while (it2.hasNext()) {
            c next2 = it2.next();
            if (next2 != null && next2.ajs() && (aiY.contains(next2.ciB) || a(next2, aiZ))) {
                next2.J(aiW);
            }
        }
    }

    private void K(Message message) {
        try {
            e.ajB().mMessenger.send(message);
        } catch (RemoteException e) {
            com.baidu.swan.apps.process.messaging.a.log(Log.getStackTraceString(e));
        }
    }

    boolean a(@NonNull c cVar, @NonNull Set<String> set) {
        return cVar.ajq() && set.contains(cVar.getAppId());
    }

    private void a(Set<String> set, @NonNull Message message) {
        for (String str : set) {
            a(str, message);
        }
    }

    private void a(String str, @NonNull Message message) {
        if (!TextUtils.isEmpty(str)) {
            Deque<Message> deque = this.ciL.get(str);
            if (deque == null) {
                deque = new ArrayDeque<>();
                this.ciL.put(str, deque);
            }
            deque.offer(message);
        }
    }
}
