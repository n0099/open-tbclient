package com.baidu.ar.lua;

import android.content.Context;
import com.baidu.ar.arplay.core.message.ARPMessage;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes12.dex */
public class b extends com.baidu.ar.arplay.b.a {
    private boolean aI;
    private d hQ;
    private List<WeakReference<c>> sE;

    public b(Context context) {
        super(context);
        this.sE = Collections.synchronizedList(new ArrayList());
        this.aI = false;
        bk();
        this.hQ = new d();
        c(this.hQ);
    }

    private synchronized boolean b(int i, int i2, HashMap<String, Object> hashMap) {
        boolean z = true;
        synchronized (this) {
            switch (i) {
                case 1001:
                    hashMap.put("audio_status", "audio_play");
                    break;
                case 1003:
                    hashMap.put("audio_status", "audio_pause");
                    break;
                case 1005:
                    hashMap.put("audio_status", "audio_resume");
                    break;
                case 1007:
                    hashMap.put("audio_status", "audio_stop");
                    break;
                case 1012:
                    hashMap.put("audio_status", "audio_reset");
                    break;
                default:
                    z = false;
                    break;
            }
        }
        return z;
    }

    public void b(int i, HashMap<String, Object> hashMap) {
        ARPMessage.getInstance().sendMessage(i, hashMap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
        com.baidu.ar.g.b.c("EngineMsgBridge", "addEngineMsgListener engineMsgListener = " + r5.hashCode());
        r0 = r4.sE.add(new java.lang.ref.WeakReference<>(r5));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean c(c cVar) {
        boolean add;
        if (this.sE != null) {
            Iterator<WeakReference<c>> it = this.sE.iterator();
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
        com.baidu.ar.g.b.c("EngineMsgBridge", "removeEngineMsgListener engineMsgListener = " + r5.hashCode());
        r1 = r4.sE.remove(r0);
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
        if (this.sE != null) {
            Iterator<WeakReference<c>> it = this.sE.iterator();
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

    public synchronized void destroy() {
        if (this.hQ != null) {
            this.hQ.destroy();
            this.hQ = null;
        }
        if (this.sE != null) {
            for (WeakReference<c> weakReference : this.sE) {
                weakReference.clear();
            }
            this.sE.clear();
            this.sE = null;
        }
    }

    public d fl() {
        return this.hQ;
    }

    @Override // com.baidu.ar.arplay.b.a, com.baidu.ar.arplay.core.message.ARPMessage.MessageHandler
    public synchronized void handleMessage(int i, int i2, HashMap<String, Object> hashMap) {
        c cVar;
        com.baidu.ar.g.b.c("EngineMsgBridge", "handleMessage aMessageType = " + i + " && aMessageID = " + i2);
        if (this.aI && b(i, i2, hashMap)) {
            i = ARPMessageType.MSG_TYPE_LUA_SDK_BRIDGE;
        } else {
            super.handleMessage(i, i2, hashMap);
        }
        if (this.sE != null) {
            for (int i3 = 0; i3 < this.sE.size(); i3++) {
                WeakReference<c> weakReference = this.sE.get(i3);
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

    public void setUserPlayAudio(boolean z) {
        this.aI = z;
    }
}
