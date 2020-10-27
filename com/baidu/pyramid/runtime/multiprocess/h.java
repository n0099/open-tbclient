package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes16.dex */
public abstract class h {
    private static final HashMap<String, h> cec = new HashMap<>();
    private static final ConcurrentHashMap<String, a> ced = new ConcurrentHashMap<>();

    public abstract IBinder aaR();

    /* loaded from: classes16.dex */
    private static class a {
        public IBinder cee;
        public boolean cef;

        private a() {
            this.cef = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        h hVar = cec.get(str);
        if (hVar != null) {
            hVar.aaS();
            return hVar.aaR();
        }
        a aVar = ced.get(str);
        if (aVar != null) {
            if (!aVar.cef && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.cee;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return ced.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (cec.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.cee = iBinder;
        aVar.cef = z;
        ced.put(str, aVar);
    }

    public void aaS() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
