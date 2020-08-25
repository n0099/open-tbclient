package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public abstract class h {
    private static final HashMap<String, h> bMQ = new HashMap<>();
    private static final ConcurrentHashMap<String, a> bMR = new ConcurrentHashMap<>();

    public abstract IBinder Ws();

    /* loaded from: classes7.dex */
    private static class a {
        public IBinder bMS;
        public boolean bMT;

        private a() {
            this.bMT = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        h hVar = bMQ.get(str);
        if (hVar != null) {
            hVar.Wt();
            return hVar.Ws();
        }
        a aVar = bMR.get(str);
        if (aVar != null) {
            if (!aVar.bMT && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.bMS;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return bMR.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (bMQ.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.bMS = iBinder;
        aVar.bMT = z;
        bMR.put(str, aVar);
    }

    public void Wt() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
