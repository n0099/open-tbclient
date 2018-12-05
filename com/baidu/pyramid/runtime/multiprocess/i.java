package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public abstract class i {
    private static final HashMap<String, i> ajk = new HashMap<>();
    private static final ConcurrentHashMap<String, a> ajl = new ConcurrentHashMap<>();

    public abstract IBinder uU();

    /* loaded from: classes2.dex */
    private static class a {
        public IBinder ajm;
        public boolean exported;

        private a() {
            this.exported = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        i iVar = ajk.get(str);
        if (iVar != null) {
            iVar.uV();
            return iVar.uU();
        }
        a aVar = ajl.get(str);
        if (aVar != null) {
            if (!aVar.exported && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.ajm;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return ajl.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (ajk.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.ajm = iBinder;
        aVar.exported = z;
        ajl.put(str, aVar);
    }

    public void uV() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
