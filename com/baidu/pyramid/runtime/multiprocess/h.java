package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes15.dex */
public abstract class h {
    private static final HashMap<String, h> coK = new HashMap<>();
    private static final ConcurrentHashMap<String, a> coL = new ConcurrentHashMap<>();

    public abstract IBinder afR();

    /* loaded from: classes15.dex */
    private static class a {
        public IBinder coM;
        public boolean coN;

        private a() {
            this.coN = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        h hVar = coK.get(str);
        if (hVar != null) {
            hVar.afS();
            return hVar.afR();
        }
        a aVar = coL.get(str);
        if (aVar != null) {
            if (!aVar.coN && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.coM;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return coL.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (coK.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.coM = iBinder;
        aVar.coN = z;
        coL.put(str, aVar);
    }

    public void afS() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
