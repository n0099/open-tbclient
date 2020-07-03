package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public abstract class h {
    private static final HashMap<String, h> bGR = new HashMap<>();
    private static final ConcurrentHashMap<String, a> bGS = new ConcurrentHashMap<>();

    public abstract IBinder Qh();

    /* loaded from: classes.dex */
    private static class a {
        public IBinder bGT;
        public boolean bGU;

        private a() {
            this.bGU = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        h hVar = bGR.get(str);
        if (hVar != null) {
            hVar.Qi();
            return hVar.Qh();
        }
        a aVar = bGS.get(str);
        if (aVar != null) {
            if (!aVar.bGU && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.bGT;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return bGS.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (bGR.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.bGT = iBinder;
        aVar.bGU = z;
        bGS.put(str, aVar);
    }

    public void Qi() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
