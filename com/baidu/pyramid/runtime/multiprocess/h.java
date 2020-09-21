package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public abstract class h {
    private static final HashMap<String, h> bOU = new HashMap<>();
    private static final ConcurrentHashMap<String, a> bOV = new ConcurrentHashMap<>();

    public abstract IBinder Xb();

    /* loaded from: classes7.dex */
    private static class a {
        public IBinder bOW;
        public boolean bOX;

        private a() {
            this.bOX = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        h hVar = bOU.get(str);
        if (hVar != null) {
            hVar.Xc();
            return hVar.Xb();
        }
        a aVar = bOV.get(str);
        if (aVar != null) {
            if (!aVar.bOX && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.bOW;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return bOV.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (bOU.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.bOW = iBinder;
        aVar.bOX = z;
        bOV.put(str, aVar);
    }

    public void Xc() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
