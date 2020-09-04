package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public abstract class h {
    private static final HashMap<String, h> bMU = new HashMap<>();
    private static final ConcurrentHashMap<String, a> bMV = new ConcurrentHashMap<>();

    public abstract IBinder Ws();

    /* loaded from: classes7.dex */
    private static class a {
        public IBinder bMW;
        public boolean bMX;

        private a() {
            this.bMX = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        h hVar = bMU.get(str);
        if (hVar != null) {
            hVar.Wt();
            return hVar.Ws();
        }
        a aVar = bMV.get(str);
        if (aVar != null) {
            if (!aVar.bMX && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.bMW;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return bMV.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (bMU.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.bMW = iBinder;
        aVar.bMX = z;
        bMV.put(str, aVar);
    }

    public void Wt() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
