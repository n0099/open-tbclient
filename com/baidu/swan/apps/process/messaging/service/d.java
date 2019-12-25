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
/* loaded from: classes9.dex */
public class d implements a.b {
    private final Map<String, Deque<Message>> bES = new HashMap();

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void Yb() {
        for (String str : this.bES.keySet()) {
            kb(str);
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void kb(String str) {
        Deque<Message> deque = this.bES.get(str);
        com.baidu.swan.apps.process.messaging.a.log("flushMsg:: appid=" + str + " msgQueue=" + deque);
        if (deque != null && !deque.isEmpty()) {
            List<c> kh = e.YH().kh(str);
            com.baidu.swan.apps.process.messaging.a.log("flushMsg:: msgQueue.size=" + deque.size() + " clients.size=" + kh.size());
            if (!kh.isEmpty()) {
                for (c cVar : kh) {
                    cVar.e(deque);
                }
                deque.clear();
            }
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void clear(String str) {
        this.bES.remove(str);
    }

    @Override // com.baidu.swan.apps.process.messaging.a.b
    public void a(@NonNull com.baidu.swan.apps.process.messaging.c cVar) {
        Message Yc = cVar.Yc();
        if (cVar.Yg()) {
            K(Yc);
        }
        Set<SwanAppProcessInfo> Ye = cVar.Ye();
        Set<String> Yf = cVar.Yf();
        if (cVar.isSticky()) {
            Iterator<c> it = e.YH().YJ().iterator();
            while (it.hasNext()) {
                c next = it.next();
                boolean a = a(next, Yf);
                if (Ye.contains(next.bEI) || a) {
                    next.J(Yc);
                    if (a) {
                        Yf.remove(next.getAppId());
                    }
                }
            }
            a(Yf, Yc);
            return;
        }
        Iterator<c> it2 = e.YH().YJ().iterator();
        while (it2.hasNext()) {
            c next2 = it2.next();
            if (next2 != null && next2.Yy() && (Ye.contains(next2.bEI) || a(next2, Yf))) {
                next2.J(Yc);
            }
        }
    }

    private void K(Message message) {
        try {
            e.YH().mMessenger.send(message);
        } catch (RemoteException e) {
            com.baidu.swan.apps.process.messaging.a.log(Log.getStackTraceString(e));
        }
    }

    boolean a(@NonNull c cVar, @NonNull Set<String> set) {
        return cVar.Yw() && set.contains(cVar.getAppId());
    }

    private void a(Set<String> set, @NonNull Message message) {
        for (String str : set) {
            a(str, message);
        }
    }

    private void a(String str, @NonNull Message message) {
        if (!TextUtils.isEmpty(str)) {
            Deque<Message> deque = this.bES.get(str);
            if (deque == null) {
                deque = new ArrayDeque<>();
                this.bES.put(str, deque);
            }
            deque.offer(message);
        }
    }
}
