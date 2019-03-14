package com.baidu.pyramid.runtime.multiprocess;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes.dex */
public abstract class g implements IBinder, IBinder.DeathRecipient {
    private static final boolean DEBUG = h.DEBUG;
    private volatile IBinder ahR;
    private HashSet<IBinder.DeathRecipient> ahS = new HashSet<>();
    private Object mLock = new Object();

    protected abstract IBinder tY() throws RemoteException;

    private IBinder tZ() throws RemoteException {
        IBinder iBinder;
        synchronized (this.mLock) {
            iBinder = this.ahR;
            if (iBinder == null) {
                iBinder = tY();
                this.ahR = iBinder;
                if (iBinder != null) {
                    iBinder.linkToDeath(this, 0);
                } else {
                    throw new RemoteException();
                }
            }
        }
        return iBinder;
    }

    @Override // android.os.IBinder
    public String getInterfaceDescriptor() throws RemoteException {
        return tZ().getInterfaceDescriptor();
    }

    @Override // android.os.IBinder
    public boolean pingBinder() {
        try {
            return tZ().pingBinder();
        } catch (RemoteException e) {
            c("MultiProcess", e);
            return false;
        }
    }

    @Override // android.os.IBinder
    public boolean isBinderAlive() {
        try {
            return tZ().isBinderAlive();
        } catch (RemoteException e) {
            c("MultiProcess", e);
            return false;
        }
    }

    @Override // android.os.IBinder
    public IInterface queryLocalInterface(String str) {
        try {
            return tZ().queryLocalInterface(str);
        } catch (RemoteException e) {
            c("MultiProcess", e);
            return null;
        }
    }

    @Override // android.os.IBinder
    public void dump(FileDescriptor fileDescriptor, String[] strArr) throws RemoteException {
        tZ().dump(fileDescriptor, strArr);
    }

    @Override // android.os.IBinder
    public void dumpAsync(FileDescriptor fileDescriptor, String[] strArr) throws RemoteException {
        tZ().dumpAsync(fileDescriptor, strArr);
    }

    @Override // android.os.IBinder
    public boolean transact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        return tZ().transact(i, parcel, parcel2, i2);
    }

    @Override // android.os.IBinder
    public void linkToDeath(IBinder.DeathRecipient deathRecipient, int i) throws RemoteException {
        synchronized (this.ahS) {
            this.ahS.add(deathRecipient);
        }
    }

    @Override // android.os.IBinder
    public boolean unlinkToDeath(IBinder.DeathRecipient deathRecipient, int i) {
        synchronized (this.ahS) {
            this.ahS.remove(deathRecipient);
        }
        return this.ahR != null;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        if (DEBUG) {
            Log.d("MultiProcess", "Long Live Binder -> [binderDied]");
        }
        synchronized (this.mLock) {
            IBinder iBinder = this.ahR;
            if (iBinder != null) {
                iBinder.unlinkToDeath(this, 0);
                this.ahR = null;
            }
            ArrayList<IBinder.DeathRecipient> arrayList = new ArrayList();
            synchronized (this.ahS) {
                arrayList.addAll(this.ahS);
            }
            for (IBinder.DeathRecipient deathRecipient : arrayList) {
                deathRecipient.binderDied();
            }
        }
    }

    private static void c(String str, Exception exc) {
        if (DEBUG) {
            Log.e(str, "", exc);
        }
    }
}
