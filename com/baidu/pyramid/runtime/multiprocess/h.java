package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public abstract class h {
    private static final HashMap<String, h> aVO = new HashMap<>();
    private static final ConcurrentHashMap<String, a> aVP = new ConcurrentHashMap<>();

    public abstract IBinder Fa();

    /* loaded from: classes.dex */
    private static class a {
        public IBinder aVQ;
        public boolean aVR;

        private a() {
            this.aVR = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        h hVar = aVO.get(str);
        if (hVar != null) {
            hVar.Fb();
            return hVar.Fa();
        }
        a aVar = aVP.get(str);
        if (aVar != null) {
            if (!aVar.aVR && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.aVQ;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return aVP.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (aVO.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.aVQ = iBinder;
        aVar.aVR = z;
        aVP.put(str, aVar);
    }

    public void Fb() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
