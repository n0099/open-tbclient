package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public abstract class h {
    private static final HashMap<String, h> aCL = new HashMap<>();
    private static final ConcurrentHashMap<String, a> aCM = new ConcurrentHashMap<>();

    public abstract IBinder Ai();

    /* loaded from: classes.dex */
    private static class a {
        public IBinder aCN;
        public boolean aCO;

        private a() {
            this.aCO = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        h hVar = aCL.get(str);
        if (hVar != null) {
            hVar.Aj();
            return hVar.Ai();
        }
        a aVar = aCM.get(str);
        if (aVar != null) {
            if (!aVar.aCO && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.aCN;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return aCM.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (aCL.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.aCN = iBinder;
        aVar.aCO = z;
        aCM.put(str, aVar);
    }

    public void Aj() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
