package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public abstract class h {
    private static final HashMap<String, h> aVM = new HashMap<>();
    private static final ConcurrentHashMap<String, a> aVN = new ConcurrentHashMap<>();

    public abstract IBinder EY();

    /* loaded from: classes.dex */
    private static class a {
        public IBinder aVO;
        public boolean aVP;

        private a() {
            this.aVP = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        h hVar = aVM.get(str);
        if (hVar != null) {
            hVar.EZ();
            return hVar.EY();
        }
        a aVar = aVN.get(str);
        if (aVar != null) {
            if (!aVar.aVP && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.aVO;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return aVN.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (aVM.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.aVO = iBinder;
        aVar.aVP = z;
        aVN.put(str, aVar);
    }

    public void EZ() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
