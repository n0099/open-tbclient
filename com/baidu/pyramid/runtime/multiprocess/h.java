package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public abstract class h {
    private static final HashMap<String, h> aCt = new HashMap<>();
    private static final ConcurrentHashMap<String, a> aCu = new ConcurrentHashMap<>();

    public abstract IBinder Aj();

    /* loaded from: classes.dex */
    private static class a {
        public IBinder aCv;
        public boolean aCw;

        private a() {
            this.aCw = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        h hVar = aCt.get(str);
        if (hVar != null) {
            hVar.Ak();
            return hVar.Aj();
        }
        a aVar = aCu.get(str);
        if (aVar != null) {
            if (!aVar.aCw && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.aCv;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return aCu.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (aCt.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.aCv = iBinder;
        aVar.aCw = z;
        aCu.put(str, aVar);
    }

    public void Ak() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
