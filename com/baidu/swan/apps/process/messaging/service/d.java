package com.baidu.swan.apps.process.messaging.service;

import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
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
    private final Map<String, Deque<Message>> dvE = new HashMap();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void aFF() {
        for (String str : this.dvE.keySet()) {
            ri(str);
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void ri(String str) {
        Deque<Message> deque = this.dvE.get(str);
        com.baidu.swan.apps.process.messaging.a.log("flushMsg:: appid=" + str + " msgQueue=" + deque);
        if (deque != null && !deque.isEmpty()) {
            List<c> rp = e.aGq().rp(str);
            com.baidu.swan.apps.process.messaging.a.log("flushMsg:: msgQueue.size=" + deque.size() + " clients.size=" + rp.size());
            if (!rp.isEmpty()) {
                for (c cVar : rp) {
                    cVar.i(deque);
                }
                deque.clear();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
        this.dvE.remove(str);
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull com.baidu.swan.apps.process.messaging.c cVar) {
        Message aFG = cVar.aFG();
        if (cVar.aFK()) {
            M(aFG);
        }
        Set<SwanAppProcessInfo> aFI = cVar.aFI();
        Set<String> aFJ = cVar.aFJ();
        if (cVar.isSticky()) {
            Iterator<c> it = e.aGq().aGs().iterator();
            while (it.hasNext()) {
                c next = it.next();
                boolean a2 = a(next, aFJ);
                if (aFI.contains(next.dvs) || a2) {
                    next.L(aFG);
                    if (a2) {
                        aFJ.remove(next.getAppId());
                    }
                }
            }
            a(aFJ, aFG);
            return;
        }
        Iterator<c> it2 = e.aGq().aGs().iterator();
        while (it2.hasNext()) {
            c next2 = it2.next();
            if (next2 != null && next2.aGd() && (aFI.contains(next2.dvs) || a(next2, aFJ))) {
                next2.L(aFG);
            }
        }
    }

    private void M(Message message) {
        try {
            e.aGq().mMessenger.send(message);
        } catch (RemoteException e) {
            com.baidu.swan.apps.process.messaging.a.log(Log.getStackTraceString(e));
        }
    }

    boolean a(@NonNull c cVar, @NonNull Set<String> set) {
        return cVar.aGb() && set.contains(cVar.getAppId());
    }

    private void a(Set<String> set, @NonNull Message message) {
        for (String str : set) {
            a(str, message);
        }
    }

    private void a(String str, @NonNull Message message) {
        if (!TextUtils.isEmpty(str)) {
            Deque<Message> deque = this.dvE.get(str);
            if (deque == null) {
                deque = new ArrayDeque<>();
                this.dvE.put(str, deque);
            }
            deque.offer(message);
        }
    }
}
