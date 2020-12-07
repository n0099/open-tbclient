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
/* loaded from: classes25.dex */
public class d implements a.b {
    private final Map<String, Deque<Message>> drH = new HashMap();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void aHH() {
        for (String str : this.drH.keySet()) {
            sb(str);
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void sb(String str) {
        Deque<Message> deque = this.drH.get(str);
        com.baidu.swan.apps.process.messaging.a.log("flushMsg:: appid=" + str + " msgQueue=" + deque);
        if (deque != null && !deque.isEmpty()) {
            List<c> sh = e.aIs().sh(str);
            com.baidu.swan.apps.process.messaging.a.log("flushMsg:: msgQueue.size=" + deque.size() + " clients.size=" + sh.size());
            if (!sh.isEmpty()) {
                for (c cVar : sh) {
                    cVar.i(deque);
                }
                deque.clear();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
        this.drH.remove(str);
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull com.baidu.swan.apps.process.messaging.c cVar) {
        Message aHI = cVar.aHI();
        if (cVar.aHM()) {
            M(aHI);
        }
        Set<SwanAppProcessInfo> aHK = cVar.aHK();
        Set<String> aHL = cVar.aHL();
        if (cVar.isSticky()) {
            Iterator<c> it = e.aIs().aIu().iterator();
            while (it.hasNext()) {
                c next = it.next();
                boolean a2 = a(next, aHL);
                if (aHK.contains(next.drv) || a2) {
                    next.L(aHI);
                    if (a2) {
                        aHL.remove(next.getAppId());
                    }
                }
            }
            a(aHL, aHI);
            return;
        }
        Iterator<c> it2 = e.aIs().aIu().iterator();
        while (it2.hasNext()) {
            c next2 = it2.next();
            if (next2 != null && next2.aIf() && (aHK.contains(next2.drv) || a(next2, aHL))) {
                next2.L(aHI);
            }
        }
    }

    private void M(Message message) {
        try {
            e.aIs().mMessenger.send(message);
        } catch (RemoteException e) {
            com.baidu.swan.apps.process.messaging.a.log(Log.getStackTraceString(e));
        }
    }

    boolean a(@NonNull c cVar, @NonNull Set<String> set) {
        return cVar.aId() && set.contains(cVar.getAppId());
    }

    private void a(Set<String> set, @NonNull Message message) {
        for (String str : set) {
            a(str, message);
        }
    }

    private void a(String str, @NonNull Message message) {
        if (!TextUtils.isEmpty(str)) {
            Deque<Message> deque = this.drH.get(str);
            if (deque == null) {
                deque = new ArrayDeque<>();
                this.drH.put(str, deque);
            }
            deque.offer(message);
        }
    }
}
