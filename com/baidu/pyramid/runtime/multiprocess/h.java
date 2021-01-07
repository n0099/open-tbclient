package com.baidu.pyramid.runtime.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public abstract class h {
    private static final HashMap<String, h> cvQ = new HashMap<>();
    private static final ConcurrentHashMap<String, a> cvR = new ConcurrentHashMap<>();

    public abstract IBinder ahO();

    /* loaded from: classes6.dex */
    private static class a {
        public IBinder cvS;
        public boolean cvT;

        private a() {
            this.cvT = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder getService(String str) {
        h hVar = cvQ.get(str);
        if (hVar != null) {
            hVar.ahP();
            return hVar.ahO();
        }
        a aVar = cvR.get(str);
        if (aVar != null) {
            if (!aVar.cvT && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return aVar.cvS;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeService(String str) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        return cvR.remove(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addService(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
        if (cvQ.get(str) != null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a();
        aVar.cvS = iBinder;
        aVar.cvT = z;
        cvR.put(str, aVar);
    }

    public void ahP() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
