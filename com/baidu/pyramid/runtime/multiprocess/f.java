package com.baidu.pyramid.runtime.multiprocess;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes7.dex */
public abstract class f implements IBinder, IBinder.DeathRecipient {
    private volatile IBinder bMN;
    private HashSet<IBinder.DeathRecipient> bMO = new HashSet<>();
    private Object mLock = new Object();

    protected abstract IBinder Wq() throws RemoteException;

    private IBinder Wr() throws RemoteException {
        IBinder iBinder;
        synchronized (this.mLock) {
            iBinder = this.bMN;
            if (iBinder == null) {
                iBinder = Wq();
                this.bMN = iBinder;
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
        return Wr().getInterfaceDescriptor();
    }

    @Override // android.os.IBinder
    public boolean pingBinder() {
        try {
            return Wr().pingBinder();
        } catch (RemoteException e) {
            c("MultiProcess", e);
            return false;
        }
    }

    @Override // android.os.IBinder
    public boolean isBinderAlive() {
        try {
            return Wr().isBinderAlive();
        } catch (RemoteException e) {
            c("MultiProcess", e);
            return false;
        }
    }

    @Override // android.os.IBinder
    public IInterface queryLocalInterface(String str) {
        try {
            return Wr().queryLocalInterface(str);
        } catch (RemoteException e) {
            c("MultiProcess", e);
            return null;
        }
    }

    @Override // android.os.IBinder
    public void dump(FileDescriptor fileDescriptor, String[] strArr) throws RemoteException {
        Wr().dump(fileDescriptor, strArr);
    }

    @Override // android.os.IBinder
    public void dumpAsync(FileDescriptor fileDescriptor, String[] strArr) throws RemoteException {
        Wr().dumpAsync(fileDescriptor, strArr);
    }

    @Override // android.os.IBinder
    public boolean transact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        return Wr().transact(i, parcel, parcel2, i2);
    }

    @Override // android.os.IBinder
    public void linkToDeath(IBinder.DeathRecipient deathRecipient, int i) throws RemoteException {
        synchronized (this.bMO) {
            this.bMO.add(deathRecipient);
        }
    }

    @Override // android.os.IBinder
    public boolean unlinkToDeath(IBinder.DeathRecipient deathRecipient, int i) {
        synchronized (this.bMO) {
            this.bMO.remove(deathRecipient);
        }
        return this.bMN != null;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        synchronized (this.mLock) {
            IBinder iBinder = this.bMN;
            if (iBinder != null) {
                iBinder.unlinkToDeath(this, 0);
                this.bMN = null;
            }
            ArrayList<IBinder.DeathRecipient> arrayList = new ArrayList();
            synchronized (this.bMO) {
                arrayList.addAll(this.bMO);
            }
            for (IBinder.DeathRecipient deathRecipient : arrayList) {
                deathRecipient.binderDied();
            }
        }
    }

    private static void c(String str, Exception exc) {
    }
}
