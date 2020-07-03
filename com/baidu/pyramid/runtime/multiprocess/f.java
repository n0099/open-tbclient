package com.baidu.pyramid.runtime.multiprocess;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes.dex */
public abstract class f implements IBinder, IBinder.DeathRecipient {
    private volatile IBinder bGO;
    private HashSet<IBinder.DeathRecipient> bGP = new HashSet<>();
    private Object mLock = new Object();

    protected abstract IBinder Qf() throws RemoteException;

    private IBinder Qg() throws RemoteException {
        IBinder iBinder;
        synchronized (this.mLock) {
            iBinder = this.bGO;
            if (iBinder == null) {
                iBinder = Qf();
                this.bGO = iBinder;
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
        return Qg().getInterfaceDescriptor();
    }

    @Override // android.os.IBinder
    public boolean pingBinder() {
        try {
            return Qg().pingBinder();
        } catch (RemoteException e) {
            c("MultiProcess", e);
            return false;
        }
    }

    @Override // android.os.IBinder
    public boolean isBinderAlive() {
        try {
            return Qg().isBinderAlive();
        } catch (RemoteException e) {
            c("MultiProcess", e);
            return false;
        }
    }

    @Override // android.os.IBinder
    public IInterface queryLocalInterface(String str) {
        try {
            return Qg().queryLocalInterface(str);
        } catch (RemoteException e) {
            c("MultiProcess", e);
            return null;
        }
    }

    @Override // android.os.IBinder
    public void dump(FileDescriptor fileDescriptor, String[] strArr) throws RemoteException {
        Qg().dump(fileDescriptor, strArr);
    }

    @Override // android.os.IBinder
    public void dumpAsync(FileDescriptor fileDescriptor, String[] strArr) throws RemoteException {
        Qg().dumpAsync(fileDescriptor, strArr);
    }

    @Override // android.os.IBinder
    public boolean transact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        return Qg().transact(i, parcel, parcel2, i2);
    }

    @Override // android.os.IBinder
    public void linkToDeath(IBinder.DeathRecipient deathRecipient, int i) throws RemoteException {
        synchronized (this.bGP) {
            this.bGP.add(deathRecipient);
        }
    }

    @Override // android.os.IBinder
    public boolean unlinkToDeath(IBinder.DeathRecipient deathRecipient, int i) {
        synchronized (this.bGP) {
            this.bGP.remove(deathRecipient);
        }
        return this.bGO != null;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        synchronized (this.mLock) {
            IBinder iBinder = this.bGO;
            if (iBinder != null) {
                iBinder.unlinkToDeath(this, 0);
                this.bGO = null;
            }
            ArrayList<IBinder.DeathRecipient> arrayList = new ArrayList();
            synchronized (this.bGP) {
                arrayList.addAll(this.bGP);
            }
            for (IBinder.DeathRecipient deathRecipient : arrayList) {
                deathRecipient.binderDied();
            }
        }
    }

    private static void c(String str, Exception exc) {
    }
}
