package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public abstract class h {
    private static final HashMap<String, h> bCd = new HashMap<>();
    private static final ConcurrentHashMap<String, a> bCe = new ConcurrentHashMap<>();

    public abstract IBinder Pb();

    /* loaded from: classes.dex */
    private static class a {
        public IBinder bCf;
        public boolean bCg;

        private a() {
            this.bCg = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        h hVar = bCd.get(str);
        if (hVar != null) {
            hVar.Pc();
            return hVar.Pb();
        }
        a aVar = bCe.get(str);
        if (aVar != null) {
            if (!aVar.bCg && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.bCf;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return bCe.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (bCd.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.bCf = iBinder;
        aVar.bCg = z;
        bCe.put(str, aVar);
    }

    public void Pc() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
