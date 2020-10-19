package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes16.dex */
public abstract class h {
    private static final HashMap<String, h> bVD = new HashMap<>();
    private static final ConcurrentHashMap<String, a> bVE = new ConcurrentHashMap<>();

    public abstract IBinder YY();

    /* loaded from: classes16.dex */
    private static class a {
        public IBinder bVF;
        public boolean bVG;

        private a() {
            this.bVG = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        h hVar = bVD.get(str);
        if (hVar != null) {
            hVar.YZ();
            return hVar.YY();
        }
        a aVar = bVE.get(str);
        if (aVar != null) {
            if (!aVar.bVG && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.bVF;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return bVE.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (bVD.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.bVF = iBinder;
        aVar.bVG = z;
        bVE.put(str, aVar);
    }

    public void YZ() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
