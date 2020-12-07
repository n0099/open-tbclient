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
/* loaded from: classes10.dex */
public class b extends com.baidu.ar.arplay.b.a {
    private boolean aJ;

    /* renamed from: if  reason: not valid java name */
    private d f2if;
    private List<WeakReference<c>> sV;

    public b(Context context) {
        super(context);
        this.sV = Collections.synchronizedList(new ArrayList());
        this.aJ = false;
        bh();
        this.f2if = new d();
        c(this.f2if);
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

    public void aw(String str) {
        ARPMessage.getInstance().sendLuaScriptToEngine(str);
    }

    public void b(int i, HashMap<String, Object> hashMap) {
        ARPMessage.getInstance().sendMessage(i, hashMap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
        com.baidu.ar.h.b.c("EngineMsgBridge", "addEngineMsgListener engineMsgListener = " + r5.hashCode());
        r0 = r4.sV.add(new java.lang.ref.WeakReference<>(r5));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean c(c cVar) {
        boolean add;
        if (this.sV != null) {
            Iterator<WeakReference<c>> it = this.sV.iterator();
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
        com.baidu.ar.h.b.c("EngineMsgBridge", "removeEngineMsgListener engineMsgListener = " + r5.hashCode());
        r1 = r4.sV.remove(r0);
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
        if (this.sV != null) {
            Iterator<WeakReference<c>> it = this.sV.iterator();
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
        if (this.f2if != null) {
            this.f2if.destroy();
            this.f2if = null;
        }
        if (this.sV != null) {
            for (WeakReference<c> weakReference : this.sV) {
                weakReference.clear();
            }
            this.sV.clear();
            this.sV = null;
        }
    }

    public d fk() {
        return this.f2if;
    }

    @Override // com.baidu.ar.arplay.b.a, com.baidu.ar.arplay.core.message.ARPMessage.MessageHandler
    public synchronized void handleMessage(int i, int i2, HashMap<String, Object> hashMap) {
        c cVar;
        com.baidu.ar.h.b.c("EngineMsgBridge", "handleMessage aMessageType = " + i + " && aMessageID = " + i2);
        if (this.aJ && b(i, i2, hashMap)) {
            i = ARPMessageType.MSG_TYPE_LUA_SDK_BRIDGE;
        } else {
            super.handleMessage(i, i2, hashMap);
        }
        if (this.sV != null) {
            for (int i3 = 0; i3 < this.sV.size(); i3++) {
                WeakReference<c> weakReference = this.sV.get(i3);
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
        this.aJ = z;
    }
}
