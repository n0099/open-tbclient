package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public abstract class h {
    private static final HashMap<String, h> aRn = new HashMap<>();
    private static final ConcurrentHashMap<String, a> aRo = new ConcurrentHashMap<>();

    public abstract IBinder CC();

    /* loaded from: classes.dex */
    private static class a {
        public IBinder aRp;
        public boolean aRq;

        private a() {
            this.aRq = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        h hVar = aRn.get(str);
        if (hVar != null) {
            hVar.CD();
            return hVar.CC();
        }
        a aVar = aRo.get(str);
        if (aVar != null) {
            if (!aVar.aRq && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.aRp;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return aRo.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (aRn.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.aRp = iBinder;
        aVar.aRq = z;
        aRo.put(str, aVar);
    }

    public void CD() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
