package com.baidu.pyramid.runtime.multiprocess.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public interface IPCServiceManagerAidl extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements IPCServiceManagerAidl {
        public static final String DESCRIPTOR = "com.baidu.pyramid.runtime.multiprocess.internal.IPCServiceManagerAidl";
        public static final int TRANSACTION_addService = 3;
        public static final int TRANSACTION_getService = 1;
        public static final int TRANSACTION_removeService = 2;

        /* loaded from: classes2.dex */
        public static class Proxy implements IPCServiceManagerAidl {
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.baidu.pyramid.runtime.multiprocess.internal.IPCServiceManagerAidl
            public void addService(String str, IBinder iBinder, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.baidu.pyramid.runtime.multiprocess.internal.IPCServiceManagerAidl
            public IBinder getService(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.pyramid.runtime.multiprocess.internal.IPCServiceManagerAidl
            public boolean removeService(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPCServiceManagerAidl asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IPCServiceManagerAidl)) {
                return (IPCServiceManagerAidl) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                IBinder service = getService(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(service);
                return true;
            } else if (i2 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean removeService = removeService(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(removeService ? 1 : 0);
                return true;
            } else if (i2 != 3) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            } else {
                parcel.enforceInterface(DESCRIPTOR);
                addService(parcel.readString(), parcel.readStrongBinder(), parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            }
        }
    }

    void addService(String str, IBinder iBinder, boolean z) throws RemoteException;

    IBinder getService(String str) throws RemoteException;

    boolean removeService(String str) throws RemoteException;
}
