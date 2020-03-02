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
    private final Map<String, Deque<Message>> bJJ = new HashMap();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void aaO() {
        for (String str : this.bJJ.keySet()) {
            kt(str);
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void kt(String str) {
        Deque<Message> deque = this.bJJ.get(str);
        com.baidu.swan.apps.process.messaging.a.log("flushMsg:: appid=" + str + " msgQueue=" + deque);
        if (deque != null && !deque.isEmpty()) {
            List<c> kz = e.abu().kz(str);
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
        this.bJJ.remove(str);
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull com.baidu.swan.apps.process.messaging.c cVar) {
        Message aaP = cVar.aaP();
        if (cVar.aaT()) {
            K(aaP);
        }
        Set<SwanAppProcessInfo> aaR = cVar.aaR();
        Set<String> aaS = cVar.aaS();
        if (cVar.isSticky()) {
            Iterator<c> it = e.abu().abw().iterator();
            while (it.hasNext()) {
                c next = it.next();
                boolean a = a(next, aaS);
                if (aaR.contains(next.bJz) || a) {
                    next.J(aaP);
                    if (a) {
                        aaS.remove(next.getAppId());
                    }
                }
            }
            a(aaS, aaP);
            return;
        }
        Iterator<c> it2 = e.abu().abw().iterator();
        while (it2.hasNext()) {
            c next2 = it2.next();
            if (next2 != null && next2.abl() && (aaR.contains(next2.bJz) || a(next2, aaS))) {
                next2.J(aaP);
            }
        }
    }

    private void K(Message message) {
        try {
            e.abu().mMessenger.send(message);
        } catch (RemoteException e) {
            com.baidu.swan.apps.process.messaging.a.log(Log.getStackTraceString(e));
        }
    }

    boolean a(@NonNull c cVar, @NonNull Set<String> set) {
        return cVar.abj() && set.contains(cVar.getAppId());
    }

    private void a(Set<String> set, @NonNull Message message) {
        for (String str : set) {
            a(str, message);
        }
    }

    private void a(String str, @NonNull Message message) {
        if (!TextUtils.isEmpty(str)) {
            Deque<Message> deque = this.bJJ.get(str);
            if (deque == null) {
                deque = new ArrayDeque<>();
                this.bJJ.put(str, deque);
            }
            deque.offer(message);
        }
    }
}
