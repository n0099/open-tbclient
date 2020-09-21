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
/* loaded from: classes3.dex */
public class d implements a.b {
    private final Map<String, Deque<Message>> cLP = new HashMap();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void aye() {
        for (String str : this.cLP.keySet()) {
            qh(str);
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void qh(String str) {
        Deque<Message> deque = this.cLP.get(str);
        com.baidu.swan.apps.process.messaging.a.log("flushMsg:: appid=" + str + " msgQueue=" + deque);
        if (deque != null && !deque.isEmpty()) {
            List<c> qn = e.ayP().qn(str);
            com.baidu.swan.apps.process.messaging.a.log("flushMsg:: msgQueue.size=" + deque.size() + " clients.size=" + qn.size());
            if (!qn.isEmpty()) {
                for (c cVar : qn) {
                    cVar.i(deque);
                }
                deque.clear();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
        this.cLP.remove(str);
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull com.baidu.swan.apps.process.messaging.c cVar) {
        Message ayf = cVar.ayf();
        if (cVar.ayj()) {
            M(ayf);
        }
        Set<SwanAppProcessInfo> ayh = cVar.ayh();
        Set<String> ayi = cVar.ayi();
        if (cVar.isSticky()) {
            Iterator<c> it = e.ayP().ayR().iterator();
            while (it.hasNext()) {
                c next = it.next();
                boolean a = a(next, ayi);
                if (ayh.contains(next.cLD) || a) {
                    next.L(ayf);
                    if (a) {
                        ayi.remove(next.getAppId());
                    }
                }
            }
            a(ayi, ayf);
            return;
        }
        Iterator<c> it2 = e.ayP().ayR().iterator();
        while (it2.hasNext()) {
            c next2 = it2.next();
            if (next2 != null && next2.ayC() && (ayh.contains(next2.cLD) || a(next2, ayi))) {
                next2.L(ayf);
            }
        }
    }

    private void M(Message message) {
        try {
            e.ayP().mMessenger.send(message);
        } catch (RemoteException e) {
            com.baidu.swan.apps.process.messaging.a.log(Log.getStackTraceString(e));
        }
    }

    boolean a(@NonNull c cVar, @NonNull Set<String> set) {
        return cVar.ayA() && set.contains(cVar.getAppId());
    }

    private void a(Set<String> set, @NonNull Message message) {
        for (String str : set) {
            a(str, message);
        }
    }

    private void a(String str, @NonNull Message message) {
        if (!TextUtils.isEmpty(str)) {
            Deque<Message> deque = this.cLP.get(str);
            if (deque == null) {
                deque = new ArrayDeque<>();
                this.cLP.put(str, deque);
            }
            deque.offer(message);
        }
    }
}
