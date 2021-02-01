package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes15.dex */
public abstract class h {
    private static final HashMap<String, h> csN = new HashMap<>();
    private static final ConcurrentHashMap<String, a> csO = new ConcurrentHashMap<>();

    public abstract IBinder ael();

    /* loaded from: classes15.dex */
    private static class a {
        public IBinder csP;
        public boolean csQ;

        private a() {
            this.csQ = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        h hVar = csN.get(str);
        if (hVar != null) {
            hVar.aem();
            return hVar.ael();
        }
        a aVar = csO.get(str);
        if (aVar != null) {
            if (!aVar.csQ && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.csP;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return csO.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (csN.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.csP = iBinder;
        aVar.csQ = z;
        csO.put(str, aVar);
    }

    public void aem() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
