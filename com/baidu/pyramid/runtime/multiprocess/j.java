package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public abstract class j {
    private static final HashMap<String, j> aia = new HashMap<>();
    private static final ConcurrentHashMap<String, a> aib = new ConcurrentHashMap<>();

    public abstract IBinder tZ();

    /* loaded from: classes.dex */
    private static class a {
        public IBinder aic;
        public boolean exported;

        private a() {
            this.exported = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        j jVar = aia.get(str);
        if (jVar != null) {
            jVar.ua();
            return jVar.tZ();
        }
        a aVar = aib.get(str);
        if (aVar != null) {
            if (!aVar.exported && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.aic;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return aib.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (aia.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.aic = iBinder;
        aVar.exported = z;
        aib.put(str, aVar);
    }

    public void ua() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
