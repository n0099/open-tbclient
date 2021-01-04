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
/* loaded from: classes9.dex */
public class d implements a.b {
    private final Map<String, Deque<Message>> dwF = new HashMap();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void aJa() {
        for (String str : this.dwF.keySet()) {
            rU(str);
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void rU(String str) {
        Deque<Message> deque = this.dwF.get(str);
        com.baidu.swan.apps.process.messaging.a.log("flushMsg:: appid=" + str + " msgQueue=" + deque);
        if (deque != null && !deque.isEmpty()) {
            List<c> sa = e.aJL().sa(str);
            com.baidu.swan.apps.process.messaging.a.log("flushMsg:: msgQueue.size=" + deque.size() + " clients.size=" + sa.size());
            if (!sa.isEmpty()) {
                for (c cVar : sa) {
                    cVar.i(deque);
                }
                deque.clear();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
        this.dwF.remove(str);
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull com.baidu.swan.apps.process.messaging.c cVar) {
        Message aJb = cVar.aJb();
        if (cVar.aJf()) {
            M(aJb);
        }
        Set<SwanAppProcessInfo> aJd = cVar.aJd();
        Set<String> aJe = cVar.aJe();
        if (cVar.isSticky()) {
            Iterator<c> it = e.aJL().aJN().iterator();
            while (it.hasNext()) {
                c next = it.next();
                boolean a2 = a(next, aJe);
                if (aJd.contains(next.dwt) || a2) {
                    next.L(aJb);
                    if (a2) {
                        aJe.remove(next.getAppId());
                    }
                }
            }
            a(aJe, aJb);
            return;
        }
        Iterator<c> it2 = e.aJL().aJN().iterator();
        while (it2.hasNext()) {
            c next2 = it2.next();
            if (next2 != null && next2.aJy() && (aJd.contains(next2.dwt) || a(next2, aJe))) {
                next2.L(aJb);
            }
        }
    }

    private void M(Message message) {
        try {
            e.aJL().mMessenger.send(message);
        } catch (RemoteException e) {
            com.baidu.swan.apps.process.messaging.a.log(Log.getStackTraceString(e));
        }
    }

    boolean a(@NonNull c cVar, @NonNull Set<String> set) {
        return cVar.aJw() && set.contains(cVar.getAppId());
    }

    private void a(Set<String> set, @NonNull Message message) {
        for (String str : set) {
            a(str, message);
        }
    }

    private void a(String str, @NonNull Message message) {
        if (!TextUtils.isEmpty(str)) {
            Deque<Message> deque = this.dwF.get(str);
            if (deque == null) {
                deque = new ArrayDeque<>();
                this.dwF.put(str, deque);
            }
            deque.offer(message);
        }
    }
}
