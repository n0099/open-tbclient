package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public abstract class h {
    private static final HashMap<String, h> ajp = new HashMap<>();
    private static final ConcurrentHashMap<String, a> ajq = new ConcurrentHashMap<>();

    public abstract IBinder vo();

    /* loaded from: classes.dex */
    private static class a {
        public IBinder ajr;
        public boolean ajs;

        private a() {
            this.ajs = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        h hVar = ajp.get(str);
        if (hVar != null) {
            hVar.vp();
            return hVar.vo();
        }
        a aVar = ajq.get(str);
        if (aVar != null) {
            if (!aVar.ajs && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.ajr;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return ajq.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (ajp.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.ajr = iBinder;
        aVar.ajs = z;
        ajq.put(str, aVar);
    }

    public void vp() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
