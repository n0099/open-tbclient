package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public abstract class j {
    private static final HashMap<String, j> ahT = new HashMap<>();
    private static final ConcurrentHashMap<String, a> ahU = new ConcurrentHashMap<>();

    public abstract IBinder ua();

    /* loaded from: classes.dex */
    private static class a {
        public IBinder ahV;
        public boolean exported;

        private a() {
            this.exported = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        j jVar = ahT.get(str);
        if (jVar != null) {
            jVar.ub();
            return jVar.ua();
        }
        a aVar = ahU.get(str);
        if (aVar != null) {
            if (!aVar.exported && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.ahV;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return ahU.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (ahT.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.ahV = iBinder;
        aVar.exported = z;
        ahU.put(str, aVar);
    }

    public void ub() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
