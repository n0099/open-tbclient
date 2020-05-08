package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public abstract class h {
    private static final HashMap<String, h> buA = new HashMap<>();
    private static final ConcurrentHashMap<String, a> buB = new ConcurrentHashMap<>();

    public abstract IBinder MO();

    /* loaded from: classes.dex */
    private static class a {
        public IBinder buC;
        public boolean buD;

        private a() {
            this.buD = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        h hVar = buA.get(str);
        if (hVar != null) {
            hVar.MP();
            return hVar.MO();
        }
        a aVar = buB.get(str);
        if (aVar != null) {
            if (!aVar.buD && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.buC;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return buB.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (buA.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.buC = iBinder;
        aVar.buD = z;
        buB.put(str, aVar);
    }

    public void MP() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
