package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public abstract class j {
    private static final HashMap<String, j> ahU = new HashMap<>();
    private static final ConcurrentHashMap<String, a> ahV = new ConcurrentHashMap<>();

    public abstract IBinder ua();

    /* loaded from: classes.dex */
    private static class a {
        public IBinder ahW;
        public boolean exported;

        private a() {
            this.exported = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        j jVar = ahU.get(str);
        if (jVar != null) {
            jVar.ub();
            return jVar.ua();
        }
        a aVar = ahV.get(str);
        if (aVar != null) {
            if (!aVar.exported && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.ahW;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return ahV.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (ahU.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.ahW = iBinder;
        aVar.exported = z;
        ahV.put(str, aVar);
    }

    public void ub() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
