package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public abstract class h {
    private static final HashMap<String, h> aVN = new HashMap<>();
    private static final ConcurrentHashMap<String, a> aVO = new ConcurrentHashMap<>();

    public abstract IBinder Fa();

    /* loaded from: classes.dex */
    private static class a {
        public IBinder aVP;
        public boolean aVQ;

        private a() {
            this.aVQ = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        h hVar = aVN.get(str);
        if (hVar != null) {
            hVar.Fb();
            return hVar.Fa();
        }
        a aVar = aVO.get(str);
        if (aVar != null) {
            if (!aVar.aVQ && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.aVP;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return aVO.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (aVN.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.aVP = iBinder;
        aVar.aVQ = z;
        aVO.put(str, aVar);
    }

    public void Fb() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
