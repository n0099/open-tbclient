package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public abstract class h {
    private static final HashMap<String, h> bHq = new HashMap<>();
    private static final ConcurrentHashMap<String, a> bHr = new ConcurrentHashMap<>();

    public abstract IBinder Qw();

    /* loaded from: classes4.dex */
    private static class a {
        public IBinder bHs;
        public boolean bHt;

        private a() {
            this.bHt = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        h hVar = bHq.get(str);
        if (hVar != null) {
            hVar.Qx();
            return hVar.Qw();
        }
        a aVar = bHr.get(str);
        if (aVar != null) {
            if (!aVar.bHt && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.bHs;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return bHr.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (bHq.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.bHs = iBinder;
        aVar.bHt = z;
        bHr.put(str, aVar);
    }

    public void Qx() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
