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
    private volatile IBinder aVY;
    private HashSet<IBinder.DeathRecipient> aVZ = new HashSet<>();
    private Object mLock = new Object();

    protected abstract IBinder Fd() throws RemoteException;

    private IBinder Fe() throws RemoteException {
        IBinder iBinder;
        synchronized (this.mLock) {
            iBinder = this.aVY;
            if (iBinder == null) {
                iBinder = Fd();
                this.aVY = iBinder;
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
        return Fe().getInterfaceDescriptor();
    }

    @Override // android.os.IBinder
    public boolean pingBinder() {
        try {
            return Fe().pingBinder();
        } catch (RemoteException e) {
            d("MultiProcess", e);
            return false;
        }
    }

    @Override // android.os.IBinder
    public boolean isBinderAlive() {
        try {
            return Fe().isBinderAlive();
        } catch (RemoteException e) {
            d("MultiProcess", e);
            return false;
        }
    }

    @Override // android.os.IBinder
    public IInterface queryLocalInterface(String str) {
        try {
            return Fe().queryLocalInterface(str);
        } catch (RemoteException e) {
            d("MultiProcess", e);
            return null;
        }
    }

    @Override // android.os.IBinder
    public void dump(FileDescriptor fileDescriptor, String[] strArr) throws RemoteException {
        Fe().dump(fileDescriptor, strArr);
    }

    @Override // android.os.IBinder
    public void dumpAsync(FileDescriptor fileDescriptor, String[] strArr) throws RemoteException {
        Fe().dumpAsync(fileDescriptor, strArr);
    }

    @Override // android.os.IBinder
    public boolean transact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        return Fe().transact(i, parcel, parcel2, i2);
    }

    @Override // android.os.IBinder
    public void linkToDeath(IBinder.DeathRecipient deathRecipient, int i) throws RemoteException {
        synchronized (this.aVZ) {
            this.aVZ.add(deathRecipient);
        }
    }

    @Override // android.os.IBinder
    public boolean unlinkToDeath(IBinder.DeathRecipient deathRecipient, int i) {
        synchronized (this.aVZ) {
            this.aVZ.remove(deathRecipient);
        }
        return this.aVY != null;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        synchronized (this.mLock) {
            IBinder iBinder = this.aVY;
            if (iBinder != null) {
                iBinder.unlinkToDeath(this, 0);
                this.aVY = null;
            }
            ArrayList<IBinder.DeathRecipient> arrayList = new ArrayList();
            synchronized (this.aVZ) {
                arrayList.addAll(this.aVZ);
            }
            for (IBinder.DeathRecipient deathRecipient : arrayList) {
                deathRecipient.binderDied();
            }
        }
    }

    private static void d(String str, Exception exc) {
    }
}
