package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public abstract class j {
    private static final HashMap<String, j> ahZ = new HashMap<>();
    private static final ConcurrentHashMap<String, a> aia = new ConcurrentHashMap<>();

    public abstract IBinder tZ();

    /* loaded from: classes.dex */
    private static class a {
        public IBinder aib;
        public boolean exported;

        private a() {
            this.exported = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        j jVar = ahZ.get(str);
        if (jVar != null) {
            jVar.ua();
            return jVar.tZ();
        }
        a aVar = aia.get(str);
        if (aVar != null) {
            if (!aVar.exported && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.aib;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return aia.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (ahZ.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.aib = iBinder;
        aVar.exported = z;
        aia.put(str, aVar);
    }

    public void ua() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
