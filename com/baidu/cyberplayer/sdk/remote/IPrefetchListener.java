package com.baidu.cyberplayer.sdk.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes3.dex */
public interface IPrefetchListener extends IInterface {

    /* loaded from: classes3.dex */
    public static class Default implements IPrefetchListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IPrefetchListener
        public void onPrefetchStatusChanged(String str, boolean z, int i, String str2) throws RemoteException {
        }
    }

    void onPrefetchStatusChanged(String str, boolean z, int i, String str2) throws RemoteException;

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IPrefetchListener {
        public static final String DESCRIPTOR = "com.baidu.cyberplayer.sdk.remote.IPrefetchListener";
        public static final int TRANSACTION_onPrefetchStatusChanged = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        /* loaded from: classes3.dex */
        public static class Proxy implements IPrefetchListener {
            public static IPrefetchListener sDefaultImpl;
            public IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IPrefetchListener
            public void onPrefetchStatusChanged(String str, boolean z, int i, String str2) throws RemoteException {
                int i2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (z) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onPrefetchStatusChanged(str, z, i, str2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPrefetchListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IPrefetchListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IPrefetchListener)) {
                return (IPrefetchListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static boolean setDefaultImpl(IPrefetchListener iPrefetchListener) {
            if (Proxy.sDefaultImpl == null) {
                if (iPrefetchListener != null) {
                    Proxy.sDefaultImpl = iPrefetchListener;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            boolean z;
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                z = true;
            } else {
                z = false;
            }
            onPrefetchStatusChanged(readString, z, parcel.readInt(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }
}
