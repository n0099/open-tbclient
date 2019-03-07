package com.baidu.swan.apps.process.a;

import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.swan.apps.c;
/* loaded from: classes2.dex */
public final class a {
    private static final boolean DEBUG = c.DEBUG;

    /* renamed from: com.baidu.swan.apps.process.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0123a {
        void Gl();
    }

    public static boolean a(final IBinder iBinder, final InterfaceC0123a interfaceC0123a) {
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
                    if (interfaceC0123a != null) {
                        interfaceC0123a.Gl();
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
