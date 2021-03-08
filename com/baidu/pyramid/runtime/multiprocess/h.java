package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes14.dex */
public abstract class h {
    private static final HashMap<String, h> cuq = new HashMap<>();
    private static final ConcurrentHashMap<String, a> cus = new ConcurrentHashMap<>();

    public abstract IBinder aeo();

    /* loaded from: classes14.dex */
    private static class a {
        public IBinder cuu;
        public boolean cuv;

        private a() {
            this.cuv = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        h hVar = cuq.get(str);
        if (hVar != null) {
            hVar.aep();
            return hVar.aeo();
        }
        a aVar = cus.get(str);
        if (aVar != null) {
            if (!aVar.cuv && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.cuu;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return cus.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (cuq.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.cuu = iBinder;
        aVar.cuv = z;
        cus.put(str, aVar);
    }

    public void aep() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
