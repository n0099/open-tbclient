package com.baidu.pyramid.runtime.multiprocess;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes4.dex */
public abstract class f implements IBinder, IBinder.DeathRecipient {
    private volatile IBinder bHn;
    private HashSet<IBinder.DeathRecipient> bHo = new HashSet<>();
    private Object mLock = new Object();

    protected abstract IBinder Qu() throws RemoteException;

    private IBinder Qv() throws RemoteException {
        IBinder iBinder;
        synchronized (this.mLock) {
            iBinder = this.bHn;
            if (iBinder == null) {
                iBinder = Qu();
                this.bHn = iBinder;
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
        return Qv().getInterfaceDescriptor();
    }

    @Override // android.os.IBinder
    public boolean pingBinder() {
        try {
            return Qv().pingBinder();
        } catch (RemoteException e) {
            c("MultiProcess", e);
            return false;
        }
    }

    @Override // android.os.IBinder
    public boolean isBinderAlive() {
        try {
            return Qv().isBinderAlive();
        } catch (RemoteException e) {
            c("MultiProcess", e);
            return false;
        }
    }

    @Override // android.os.IBinder
    public IInterface queryLocalInterface(String str) {
        try {
            return Qv().queryLocalInterface(str);
        } catch (RemoteException e) {
            c("MultiProcess", e);
            return null;
        }
    }

    @Override // android.os.IBinder
    public void dump(FileDescriptor fileDescriptor, String[] strArr) throws RemoteException {
        Qv().dump(fileDescriptor, strArr);
    }

    @Override // android.os.IBinder
    public void dumpAsync(FileDescriptor fileDescriptor, String[] strArr) throws RemoteException {
        Qv().dumpAsync(fileDescriptor, strArr);
    }

    @Override // android.os.IBinder
    public boolean transact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        return Qv().transact(i, parcel, parcel2, i2);
    }

    @Override // android.os.IBinder
    public void linkToDeath(IBinder.DeathRecipient deathRecipient, int i) throws RemoteException {
        synchronized (this.bHo) {
            this.bHo.add(deathRecipient);
        }
    }

    @Override // android.os.IBinder
    public boolean unlinkToDeath(IBinder.DeathRecipient deathRecipient, int i) {
        synchronized (this.bHo) {
            this.bHo.remove(deathRecipient);
        }
        return this.bHn != null;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        synchronized (this.mLock) {
            IBinder iBinder = this.bHn;
            if (iBinder != null) {
                iBinder.unlinkToDeath(this, 0);
                this.bHn = null;
            }
            ArrayList<IBinder.DeathRecipient> arrayList = new ArrayList();
            synchronized (this.bHo) {
                arrayList.addAll(this.bHo);
            }
            for (IBinder.DeathRecipient deathRecipient : arrayList) {
                deathRecipient.binderDied();
            }
        }
    }

    private static void c(String str, Exception exc) {
    }
}
