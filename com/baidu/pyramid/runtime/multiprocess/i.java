package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public abstract class i {
    private static final HashMap<String, i> ajt = new HashMap<>();
    private static final ConcurrentHashMap<String, a> aju = new ConcurrentHashMap<>();

    public abstract IBinder uY();

    /* loaded from: classes2.dex */
    private static class a {
        public IBinder ajv;
        public boolean exported;

        private a() {
            this.exported = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        i iVar = ajt.get(str);
        if (iVar != null) {
            iVar.uZ();
            return iVar.uY();
        }
        a aVar = aju.get(str);
        if (aVar != null) {
            if (!aVar.exported && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.ajv;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return aju.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (ajt.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.ajv = iBinder;
        aVar.exported = z;
        aju.put(str, aVar);
    }

    public void uZ() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
