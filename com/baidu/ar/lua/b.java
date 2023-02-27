package com.baidu.ar.lua;

import android.content.Context;
import com.baidu.ar.arplay.core.message.ARPMessage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b extends com.baidu.ar.arplay.b.a {
    public boolean aJ;

    /* renamed from: if  reason: not valid java name */
    public d f2if;
    public List<WeakReference<c>> sV;

    public b(Context context) {
        super(context);
        this.sV = Collections.synchronizedList(new ArrayList());
        this.aJ = false;
        bh();
        d dVar = new d();
        this.f2if = dVar;
        c(dVar);
    }

    private synchronized boolean b(int i, int i2, HashMap<String, Object> hashMap) {
        if (i == 1001) {
            hashMap.put("audio_status", "audio_play");
            return true;
        } else if (i == 1003) {
            hashMap.put("audio_status", "audio_pause");
            return true;
        } else if (i == 1005) {
            hashMap.put("audio_status", "audio_resume");
            return true;
        } else if (i == 1007) {
            hashMap.put("audio_status", "audio_stop");
            return true;
        } else if (i != 1012) {
            return false;
        } else {
            hashMap.put("audio_status", "audio_reset");
            return true;
        }
    }

    public void aw(String str) {
        ARPMessage.getInstance().sendLuaScriptToEngine(str);
    }

    public void b(int i, HashMap<String, Object> hashMap) {
        ARPMessage.getInstance().sendMessage(i, hashMap);
    }

    public synchronized boolean c(c cVar) {
        if (this.sV == null) {
            return false;
        }
        for (WeakReference<c> weakReference : this.sV) {
            if (weakReference.get() != null && weakReference.get().equals(cVar)) {
                return false;
            }
        }
        com.baidu.ar.h.b.c("EngineMsgBridge", "addEngineMsgListener engineMsgListener = " + cVar.hashCode());
        return this.sV.add(new WeakReference<>(cVar));
    }

    public synchronized boolean d(c cVar) {
        if (this.sV == null) {
            return false;
        }
        for (WeakReference<c> weakReference : this.sV) {
            if (weakReference.get() != null && weakReference.get().equals(cVar)) {
                com.baidu.ar.h.b.c("EngineMsgBridge", "removeEngineMsgListener engineMsgListener = " + cVar.hashCode());
                boolean remove = this.sV.remove(weakReference);
                weakReference.clear();
                return remove;
            }
        }
        return false;
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

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    @Override // com.baidu.ar.arplay.b.a, com.baidu.ar.arplay.core.message.ARPMessage.MessageHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void handleMessage(int i, int i2, HashMap<String, Object> hashMap) {
        c cVar;
        com.baidu.ar.h.b.c("EngineMsgBridge", "handleMessage aMessageType = " + i + " && aMessageID = " + i2);
        if (this.aJ && b(i, i2, hashMap)) {
            i = 1901;
            if (this.sV != null) {
                return;
            }
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
            return;
        }
        super.handleMessage(i, i2, hashMap);
        if (this.sV != null) {
        }
    }

    public void setUserPlayAudio(boolean z) {
        this.aJ = z;
    }
}
