package com.baidu.ar.lua;

import android.content.Context;
import com.baidu.ar.arplay.core.message.ARPMessage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends com.baidu.ar.arplay.b.a {
    private d rA;
    private List<WeakReference<c>> rz;

    public b(Context context) {
        super(context);
        this.rz = Collections.synchronizedList(new ArrayList());
        aO();
        this.rA = new d();
        c(this.rA);
    }

    public void b(int i, HashMap<String, Object> hashMap) {
        ARPMessage.getInstance().sendMessage(i, hashMap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
        com.baidu.ar.f.b.c("EngineMsgBridge", "addEngineMsgListener engineMsgListener = " + r5.hashCode());
        r0 = r4.rz.add(new java.lang.ref.WeakReference<>(r5));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean c(c cVar) {
        boolean add;
        if (this.rz != null) {
            Iterator<WeakReference<c>> it = this.rz.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WeakReference<c> next = it.next();
                if (next.get() != null && next.get().equals(cVar)) {
                    add = false;
                    break;
                }
            }
        } else {
            add = false;
        }
        return add;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
        com.baidu.ar.f.b.c("EngineMsgBridge", "removeEngineMsgListener engineMsgListener = " + r5.hashCode());
        r1 = r4.rz.remove(r0);
        r0.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0054, code lost:
        r0 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean d(c cVar) {
        boolean z;
        if (this.rz != null) {
            Iterator<WeakReference<c>> it = this.rz.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                WeakReference<c> next = it.next();
                if (next.get() != null && next.get().equals(cVar)) {
                    break;
                }
            }
        } else {
            z = false;
        }
        return z;
    }

    public d dJ() {
        return this.rA;
    }

    public synchronized void destroy() {
        if (this.rA != null) {
            this.rA.destroy();
            this.rA = null;
        }
        if (this.rz != null) {
            for (WeakReference<c> weakReference : this.rz) {
                weakReference.clear();
            }
            this.rz.clear();
            this.rz = null;
        }
    }

    @Override // com.baidu.ar.arplay.b.a, com.baidu.ar.arplay.core.message.ARPMessage.MessageHandler
    public synchronized void handleMessage(int i, int i2, HashMap<String, Object> hashMap) {
        c cVar;
        com.baidu.ar.f.b.c("EngineMsgBridge", "handleMessage aMessageType = " + i + " && aMessageID = " + i2);
        super.handleMessage(i, i2, hashMap);
        if (this.rz != null) {
            for (int i3 = 0; i3 < this.rz.size(); i3++) {
                WeakReference<c> weakReference = this.rz.get(i3);
                if (weakReference != null && (cVar = weakReference.get()) != null && cVar.n() != null) {
                    for (Integer num : cVar.n()) {
                        if (i == num.intValue()) {
                            cVar.a(i, i2, hashMap);
                        }
                    }
                }
            }
        }
    }
}
