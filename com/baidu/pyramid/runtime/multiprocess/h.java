package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public abstract class h {
    private static final HashMap<String, h> cib = new HashMap<>();
    private static final ConcurrentHashMap<String, a> cic = new ConcurrentHashMap<>();

    public abstract IBinder acH();

    /* loaded from: classes10.dex */
    private static class a {
        public IBinder cie;
        public boolean cif;

        private a() {
            this.cif = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        h hVar = cib.get(str);
        if (hVar != null) {
            hVar.acI();
            return hVar.acH();
        }
        a aVar = cic.get(str);
        if (aVar != null) {
            if (!aVar.cif && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.cie;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return cic.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (cib.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.cie = iBinder;
        aVar.cif = z;
        cic.put(str, aVar);
    }

    public void acI() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
