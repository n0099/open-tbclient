package com.baidu.cyberplayer.sdk.remote;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes3.dex */
public interface IRemoteDownloaderListener extends IInterface {

    /* loaded from: classes3.dex */
    public static class Default implements IRemoteDownloaderListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloaderListener
        public void onCallback(String str, int i, int i2, Bundle bundle) throws RemoteException {
        }
    }

    void onCallback(String str, int i, int i2, Bundle bundle) throws RemoteException;

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IRemoteDownloaderListener {
        public static final String DESCRIPTOR = "com.baidu.cyberplayer.sdk.remote.IRemoteDownloaderListener";
        public static final int TRANSACTION_onCallback = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        /* loaded from: classes3.dex */
        public static class Proxy implements IRemoteDownloaderListener {
            public static IRemoteDownloaderListener sDefaultImpl;
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

            @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloaderListener
            public void onCallback(String str, int i, int i2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onCallback(str, i, i2, bundle);
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

        public static IRemoteDownloaderListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IRemoteDownloaderListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IRemoteDownloaderListener)) {
                return (IRemoteDownloaderListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static boolean setDefaultImpl(IRemoteDownloaderListener iRemoteDownloaderListener) {
            if (Proxy.sDefaultImpl == null) {
                if (iRemoteDownloaderListener != null) {
                    Proxy.sDefaultImpl = iRemoteDownloaderListener;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            Bundle bundle;
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            if (parcel.readInt() != 0) {
                bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
            } else {
                bundle = null;
            }
            onCallback(readString, readInt, readInt2, bundle);
            parcel2.writeNoException();
            return true;
        }
    }
}
