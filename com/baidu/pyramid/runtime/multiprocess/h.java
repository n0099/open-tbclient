package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public abstract class h {
    private static final HashMap<String, h> buv = new HashMap<>();
    private static final ConcurrentHashMap<String, a> buw = new ConcurrentHashMap<>();

    public abstract IBinder MP();

    /* loaded from: classes.dex */
    private static class a {
        public IBinder bux;
        public boolean buy;

        private a() {
            this.buy = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        h hVar = buv.get(str);
        if (hVar != null) {
            hVar.MQ();
            return hVar.MP();
        }
        a aVar = buw.get(str);
        if (aVar != null) {
            if (!aVar.buy && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.bux;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return buw.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (buv.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.bux = iBinder;
        aVar.buy = z;
        buw.put(str, aVar);
    }

    public void MQ() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
