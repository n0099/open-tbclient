package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public abstract class h {
    private static final HashMap<String, h> cqY = new HashMap<>();
    private static final ConcurrentHashMap<String, a> cqZ = new ConcurrentHashMap<>();

    public abstract IBinder adU();

    /* loaded from: classes6.dex */
    private static class a {
        public IBinder cra;
        public boolean crb;

        private a() {
            this.crb = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        h hVar = cqY.get(str);
        if (hVar != null) {
            hVar.adV();
            return hVar.adU();
        }
        a aVar = cqZ.get(str);
        if (aVar != null) {
            if (!aVar.crb && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.cra;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return cqZ.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (cqY.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.cra = iBinder;
        aVar.crb = z;
        cqZ.put(str, aVar);
    }

    public void adV() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
