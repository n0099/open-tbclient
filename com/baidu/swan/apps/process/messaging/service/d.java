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
    private final Map<String, Deque<Message>> cBA = new HashMap();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void apz() {
        for (String str : this.cBA.keySet()) {
            nP(str);
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void nP(String str) {
        Deque<Message> deque = this.cBA.get(str);
        com.baidu.swan.apps.process.messaging.a.log("flushMsg:: appid=" + str + " msgQueue=" + deque);
        if (deque != null && !deque.isEmpty()) {
            List<c> nV = e.aqf().nV(str);
            com.baidu.swan.apps.process.messaging.a.log("flushMsg:: msgQueue.size=" + deque.size() + " clients.size=" + nV.size());
            if (!nV.isEmpty()) {
                for (c cVar : nV) {
                    cVar.g(deque);
                }
                deque.clear();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
        this.cBA.remove(str);
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull com.baidu.swan.apps.process.messaging.c cVar) {
        Message apA = cVar.apA();
        if (cVar.apE()) {
            L(apA);
        }
        Set<SwanAppProcessInfo> apC = cVar.apC();
        Set<String> apD = cVar.apD();
        if (cVar.isSticky()) {
            Iterator<c> it = e.aqf().aqh().iterator();
            while (it.hasNext()) {
                c next = it.next();
                boolean a = a(next, apD);
                if (apC.contains(next.cBq) || a) {
                    next.K(apA);
                    if (a) {
                        apD.remove(next.getAppId());
                    }
                }
            }
            a(apD, apA);
            return;
        }
        Iterator<c> it2 = e.aqf().aqh().iterator();
        while (it2.hasNext()) {
            c next2 = it2.next();
            if (next2 != null && next2.apW() && (apC.contains(next2.cBq) || a(next2, apD))) {
                next2.K(apA);
            }
        }
    }

    private void L(Message message) {
        try {
            e.aqf().mMessenger.send(message);
        } catch (RemoteException e) {
            com.baidu.swan.apps.process.messaging.a.log(Log.getStackTraceString(e));
        }
    }

    boolean a(@NonNull c cVar, @NonNull Set<String> set) {
        return cVar.apU() && set.contains(cVar.getAppId());
    }

    private void a(Set<String> set, @NonNull Message message) {
        for (String str : set) {
            a(str, message);
        }
    }

    private void a(String str, @NonNull Message message) {
        if (!TextUtils.isEmpty(str)) {
            Deque<Message> deque = this.cBA.get(str);
            if (deque == null) {
                deque = new ArrayDeque<>();
                this.cBA.put(str, deque);
            }
            deque.offer(message);
        }
    }
}
