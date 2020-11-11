package com.baidu.pyramid.runtime.multiprocess;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes16.dex */
public abstract class f implements IBinder, IBinder.DeathRecipient {
    private volatile IBinder cjK;
    private HashSet<IBinder.DeathRecipient> cjL = new HashSet<>();
    private Object mLock = new Object();

    protected abstract IBinder ado() throws RemoteException;

    private IBinder adp() throws RemoteException {
        IBinder iBinder;
        synchronized (this.mLock) {
            iBinder = this.cjK;
            if (iBinder == null) {
                iBinder = ado();
                this.cjK = iBinder;
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
        return adp().getInterfaceDescriptor();
    }

    @Override // android.os.IBinder
    public boolean pingBinder() {
        try {
            return adp().pingBinder();
        } catch (RemoteException e) {
            c("MultiProcess", e);
            return false;
        }
    }

    @Override // android.os.IBinder
    public boolean isBinderAlive() {
        try {
            return adp().isBinderAlive();
        } catch (RemoteException e) {
            c("MultiProcess", e);
            return false;
        }
    }

    @Override // android.os.IBinder
    public IInterface queryLocalInterface(String str) {
        try {
            return adp().queryLocalInterface(str);
        } catch (RemoteException e) {
            c("MultiProcess", e);
            return null;
        }
    }

    @Override // android.os.IBinder
    public void dump(FileDescriptor fileDescriptor, String[] strArr) throws RemoteException {
        adp().dump(fileDescriptor, strArr);
    }

    @Override // android.os.IBinder
    public void dumpAsync(FileDescriptor fileDescriptor, String[] strArr) throws RemoteException {
        adp().dumpAsync(fileDescriptor, strArr);
    }

    @Override // android.os.IBinder
    public boolean transact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        return adp().transact(i, parcel, parcel2, i2);
    }

    @Override // android.os.IBinder
    public void linkToDeath(IBinder.DeathRecipient deathRecipient, int i) throws RemoteException {
        synchronized (this.cjL) {
            this.cjL.add(deathRecipient);
        }
    }

    @Override // android.os.IBinder
    public boolean unlinkToDeath(IBinder.DeathRecipient deathRecipient, int i) {
        synchronized (this.cjL) {
            this.cjL.remove(deathRecipient);
        }
        return this.cjK != null;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        synchronized (this.mLock) {
            IBinder iBinder = this.cjK;
            if (iBinder != null) {
                iBinder.unlinkToDeath(this, 0);
                this.cjK = null;
            }
            ArrayList<IBinder.DeathRecipient> arrayList = new ArrayList();
            synchronized (this.cjL) {
                arrayList.addAll(this.cjL);
            }
            for (IBinder.DeathRecipient deathRecipient : arrayList) {
                deathRecipient.binderDied();
            }
        }
    }

    private static void c(String str, Exception exc) {
    }
}
