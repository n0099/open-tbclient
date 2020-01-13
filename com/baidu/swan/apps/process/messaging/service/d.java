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
    private final Map<String, Deque<Message>> bFD = new HashMap();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void Yy() {
        for (String str : this.bFD.keySet()) {
            ke(str);
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void ke(String str) {
        Deque<Message> deque = this.bFD.get(str);
        com.baidu.swan.apps.process.messaging.a.log("flushMsg:: appid=" + str + " msgQueue=" + deque);
        if (deque != null && !deque.isEmpty()) {
            List<c> kk = e.Ze().kk(str);
            com.baidu.swan.apps.process.messaging.a.log("flushMsg:: msgQueue.size=" + deque.size() + " clients.size=" + kk.size());
            if (!kk.isEmpty()) {
                for (c cVar : kk) {
                    cVar.e(deque);
                }
                deque.clear();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
        this.bFD.remove(str);
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull com.baidu.swan.apps.process.messaging.c cVar) {
        Message Yz = cVar.Yz();
        if (cVar.YD()) {
            K(Yz);
        }
        Set<SwanAppProcessInfo> YB = cVar.YB();
        Set<String> YC = cVar.YC();
        if (cVar.isSticky()) {
            Iterator<c> it = e.Ze().Zg().iterator();
            while (it.hasNext()) {
                c next = it.next();
                boolean a = a(next, YC);
                if (YB.contains(next.bFt) || a) {
                    next.J(Yz);
                    if (a) {
                        YC.remove(next.getAppId());
                    }
                }
            }
            a(YC, Yz);
            return;
        }
        Iterator<c> it2 = e.Ze().Zg().iterator();
        while (it2.hasNext()) {
            c next2 = it2.next();
            if (next2 != null && next2.YV() && (YB.contains(next2.bFt) || a(next2, YC))) {
                next2.J(Yz);
            }
        }
    }

    private void K(Message message) {
        try {
            e.Ze().mMessenger.send(message);
        } catch (RemoteException e) {
            com.baidu.swan.apps.process.messaging.a.log(Log.getStackTraceString(e));
        }
    }

    boolean a(@NonNull c cVar, @NonNull Set<String> set) {
        return cVar.YT() && set.contains(cVar.getAppId());
    }

    private void a(Set<String> set, @NonNull Message message) {
        for (String str : set) {
            a(str, message);
        }
    }

    private void a(String str, @NonNull Message message) {
        if (!TextUtils.isEmpty(str)) {
            Deque<Message> deque = this.bFD.get(str);
            if (deque == null) {
                deque = new ArrayDeque<>();
                this.bFD.put(str, deque);
            }
            deque.offer(message);
        }
    }
}
