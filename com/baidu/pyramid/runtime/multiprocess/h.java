package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public abstract class h {
    private static final HashMap<String, h> aiR = new HashMap<>();
    private static final ConcurrentHashMap<String, a> aiS = new ConcurrentHashMap<>();

    public abstract IBinder vk();

    /* loaded from: classes.dex */
    private static class a {
        public IBinder aiT;
        public boolean aiU;

        private a() {
            this.aiU = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        h hVar = aiR.get(str);
        if (hVar != null) {
            hVar.vl();
            return hVar.vk();
        }
        a aVar = aiS.get(str);
        if (aVar != null) {
            if (!aVar.aiU && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.aiT;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return aiS.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (aiR.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.aiT = iBinder;
        aVar.aiU = z;
        aiS.put(str, aVar);
    }

    public void vl() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
