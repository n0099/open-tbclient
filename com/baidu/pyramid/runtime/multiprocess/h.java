package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public abstract class h {
    private static final HashMap<String, h> aWb = new HashMap<>();
    private static final ConcurrentHashMap<String, a> aWc = new ConcurrentHashMap<>();

    public abstract IBinder Ff();

    /* loaded from: classes.dex */
    private static class a {
        public IBinder aWd;
        public boolean aWe;

        private a() {
            this.aWe = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        h hVar = aWb.get(str);
        if (hVar != null) {
            hVar.Fg();
            return hVar.Ff();
        }
        a aVar = aWc.get(str);
        if (aVar != null) {
            if (!aVar.aWe && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.aWd;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return aWc.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (aWb.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.aWd = iBinder;
        aVar.aWe = z;
        aWc.put(str, aVar);
    }

    public void Fg() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
