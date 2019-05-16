package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public abstract class h {
    private static final HashMap<String, h> air = new HashMap<>();
    private static final ConcurrentHashMap<String, a> ais = new ConcurrentHashMap<>();

    public abstract IBinder uK();

    /* loaded from: classes.dex */
    private static class a {
        public IBinder ait;
        public boolean exported;

        private a() {
            this.exported = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        h hVar = air.get(str);
        if (hVar != null) {
            hVar.uL();
            return hVar.uK();
        }
        a aVar = ais.get(str);
        if (aVar != null) {
            if (!aVar.exported && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.ait;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return ais.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (air.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.ait = iBinder;
        aVar.exported = z;
        ais.put(str, aVar);
    }

    public void uL() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
