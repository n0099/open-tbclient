package com.baidu.swan.apps.process.a;

import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.swan.apps.b;
/* loaded from: classes2.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;

    /* renamed from: com.baidu.swan.apps.process.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0152a {
        void Gl();
    }

    public static boolean a(final IBinder iBinder, final InterfaceC0152a interfaceC0152a) {
        if (iBinder == null) {
            return false;
        }
        try {
            iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.baidu.swan.apps.process.a.a.1
                @Override // android.os.IBinder.DeathRecipient
                public void binderDied() {
                    if (a.DEBUG) {
                        Log.d("BinderStatusHelper", "binder died pid: " + Process.myPid());
                    }
                    iBinder.unlinkToDeath(this, 0);
                    if (interfaceC0152a != null) {
                        interfaceC0152a.Gl();
                    }
                }
            }, 0);
            return true;
        } catch (RemoteException e) {
            if (DEBUG) {
                e.printStackTrace();
                return false;
            }
            return false;
        }
    }
}
