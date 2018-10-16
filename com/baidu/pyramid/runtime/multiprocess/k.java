package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public abstract class k {
    private static final HashMap<String, k> agM = new HashMap<>();
    private static final ConcurrentHashMap<String, a> agN = new ConcurrentHashMap<>();

    public abstract IBinder uq();

    /* loaded from: classes2.dex */
    private static class a {
        public IBinder agO;
        public boolean exported;

        private a() {
            this.exported = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        k kVar = agM.get(str);
        if (kVar != null) {
            kVar.ur();
            return kVar.uq();
        }
        a aVar = agN.get(str);
        if (aVar != null) {
            if (!aVar.exported && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.agO;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return agN.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (agM.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.agO = iBinder;
        aVar.exported = z;
        agN.put(str, aVar);
    }

    public void ur() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
