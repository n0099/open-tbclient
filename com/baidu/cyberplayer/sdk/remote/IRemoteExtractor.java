package com.baidu.cyberplayer.sdk.remote;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes3.dex */
public interface IRemoteExtractor extends IInterface {

    /* loaded from: classes3.dex */
    public static class Default implements IRemoteExtractor {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemoteExtractor
        public Bundle getMediaMeta() throws RemoteException {
            return null;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemoteExtractor
        public void release() throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemoteExtractor
        public void setDataSource(RemoteDataSource remoteDataSource) throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemoteExtractor
        public void setOption(int i, String str, long j) throws RemoteException {
        }
    }

    Bundle getMediaMeta() throws RemoteException;

    void release() throws RemoteException;

    void setDataSource(RemoteDataSource remoteDataSource) throws RemoteException;

    void setOption(int i, String str, long j) throws RemoteException;

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IRemoteExtractor {
        public static final String DESCRIPTOR = "com.baidu.cyberplayer.sdk.remote.IRemoteExtractor";
        public static final int TRANSACTION_getMediaMeta = 3;
        public static final int TRANSACTION_release = 4;
        public static final int TRANSACTION_setDataSource = 1;
        public static final int TRANSACTION_setOption = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        /* loaded from: classes3.dex */
        public static class Proxy implements IRemoteExtractor {
            public static IRemoteExtractor sDefaultImpl;
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

            @Override // com.baidu.cyberplayer.sdk.remote.IRemoteExtractor
            public Bundle getMediaMeta() throws RemoteException {
                Bundle bundle;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getMediaMeta();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    } else {
                        bundle = null;
                    }
                    return bundle;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemoteExtractor
            public void release() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().release();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemoteExtractor
            public void setDataSource(RemoteDataSource remoteDataSource) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (remoteDataSource != null) {
                        obtain.writeInt(1);
                        remoteDataSource.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setDataSource(remoteDataSource);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemoteExtractor
            public void setOption(int i, String str, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setOption(i, str, j);
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

        public static IRemoteExtractor getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IRemoteExtractor asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IRemoteExtractor)) {
                return (IRemoteExtractor) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static boolean setDefaultImpl(IRemoteExtractor iRemoteExtractor) {
            if (Proxy.sDefaultImpl == null) {
                if (iRemoteExtractor != null) {
                    Proxy.sDefaultImpl = iRemoteExtractor;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            RemoteDataSource remoteDataSource;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 1598968902) {
                                return super.onTransact(i, parcel, parcel2, i2);
                            }
                            parcel2.writeString(DESCRIPTOR);
                            return true;
                        }
                        parcel.enforceInterface(DESCRIPTOR);
                        release();
                        parcel2.writeNoException();
                        return true;
                    }
                    parcel.enforceInterface(DESCRIPTOR);
                    Bundle mediaMeta = getMediaMeta();
                    parcel2.writeNoException();
                    if (mediaMeta != null) {
                        parcel2.writeInt(1);
                        mediaMeta.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                }
                parcel.enforceInterface(DESCRIPTOR);
                setOption(parcel.readInt(), parcel.readString(), parcel.readLong());
                parcel2.writeNoException();
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            if (parcel.readInt() != 0) {
                remoteDataSource = RemoteDataSource.CREATOR.createFromParcel(parcel);
            } else {
                remoteDataSource = null;
            }
            setDataSource(remoteDataSource);
            parcel2.writeNoException();
            return true;
        }
    }
}
