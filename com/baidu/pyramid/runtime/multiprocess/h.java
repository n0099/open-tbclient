package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public abstract class h {
    private static final HashMap<String, h> aQv = new HashMap<>();
    private static final ConcurrentHashMap<String, a> aQw = new ConcurrentHashMap<>();

    public abstract IBinder Cg();

    /* loaded from: classes.dex */
    private static class a {
        public IBinder aQx;
        public boolean aQy;

        private a() {
            this.aQy = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        h hVar = aQv.get(str);
        if (hVar != null) {
            hVar.Ch();
            return hVar.Cg();
        }
        a aVar = aQw.get(str);
        if (aVar != null) {
            if (!aVar.aQy && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.aQx;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return aQw.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (aQv.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.aQx = iBinder;
        aVar.aQy = z;
        aQw.put(str, aVar);
    }

    public void Ch() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
