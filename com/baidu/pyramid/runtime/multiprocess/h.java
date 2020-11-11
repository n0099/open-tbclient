package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes16.dex */
public abstract class h {
    private static final HashMap<String, h> cjN = new HashMap<>();
    private static final ConcurrentHashMap<String, a> cjO = new ConcurrentHashMap<>();

    public abstract IBinder adq();

    /* loaded from: classes16.dex */
    private static class a {
        public IBinder cjP;
        public boolean cjQ;

        private a() {
            this.cjQ = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        h hVar = cjN.get(str);
        if (hVar != null) {
            hVar.adr();
            return hVar.adq();
        }
        a aVar = cjO.get(str);
        if (aVar != null) {
            if (!aVar.cjQ && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.cjP;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return cjO.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (cjN.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.cjP = iBinder;
        aVar.cjQ = z;
        cjO.put(str, aVar);
    }

    public void adr() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
