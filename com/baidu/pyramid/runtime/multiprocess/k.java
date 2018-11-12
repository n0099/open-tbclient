package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public abstract class k {
    private static final HashMap<String, k> ahz = new HashMap<>();
    private static final ConcurrentHashMap<String, a> ahA = new ConcurrentHashMap<>();

    public abstract IBinder uA();

    /* loaded from: classes2.dex */
    private static class a {
        public IBinder ahB;
        public boolean exported;

        private a() {
            this.exported = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        k kVar = ahz.get(str);
        if (kVar != null) {
            kVar.uB();
            return kVar.uA();
        }
        a aVar = ahA.get(str);
        if (aVar != null) {
            if (!aVar.exported && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.ahB;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return ahA.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (ahz.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.ahB = iBinder;
        aVar.exported = z;
        ahA.put(str, aVar);
    }

    public void uB() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
