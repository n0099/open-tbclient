package com.baidu.cyberplayer.sdk.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.cyberplayer.sdk.remote.IPrefetchListener;
/* loaded from: classes3.dex */
public interface IRemotePlayerFactory extends IInterface {

    /* loaded from: classes3.dex */
    public static class Default implements IRemotePlayerFactory {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory
        public long calculateVideoCacheSizeCanBeCleared() throws RemoteException {
            return 0L;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory
        public IBinder createDownloader(int i, String str, PrefetchOptions prefetchOptions) throws RemoteException {
            return null;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory
        public IBinder createExtractor() throws RemoteException {
            return null;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory
        public IBinder createPlayer(int i) throws RemoteException {
            return null;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory
        public boolean hasCacheFile(String str) throws RemoteException {
            return false;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory
        public void prefetch(String str, String str2, String str3, int i, int i2, int i3, String str4, int i4, int i5, int i6, int i7, PrefetchOptions prefetchOptions) throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory
        public void remoteInstallNewType(int i) throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory
        public void sendGlobalCommond(String str, int i, long j, String str2, PrefetchOptions prefetchOptions) throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory
        public void setPrefetchListener(IPrefetchListener iPrefetchListener) throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory
        public boolean updatePlayerConfig(String str) throws RemoteException {
            return false;
        }
    }

    long calculateVideoCacheSizeCanBeCleared() throws RemoteException;

    IBinder createDownloader(int i, String str, PrefetchOptions prefetchOptions) throws RemoteException;

    IBinder createExtractor() throws RemoteException;

    IBinder createPlayer(int i) throws RemoteException;

    boolean hasCacheFile(String str) throws RemoteException;

    void prefetch(String str, String str2, String str3, int i, int i2, int i3, String str4, int i4, int i5, int i6, int i7, PrefetchOptions prefetchOptions) throws RemoteException;

    void remoteInstallNewType(int i) throws RemoteException;

    void sendGlobalCommond(String str, int i, long j, String str2, PrefetchOptions prefetchOptions) throws RemoteException;

    void setPrefetchListener(IPrefetchListener iPrefetchListener) throws RemoteException;

    boolean updatePlayerConfig(String str) throws RemoteException;

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IRemotePlayerFactory {
        public static final String DESCRIPTOR = "com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory";
        public static final int TRANSACTION_calculateVideoCacheSizeCanBeCleared = 9;
        public static final int TRANSACTION_createDownloader = 10;
        public static final int TRANSACTION_createExtractor = 2;
        public static final int TRANSACTION_createPlayer = 1;
        public static final int TRANSACTION_hasCacheFile = 5;
        public static final int TRANSACTION_prefetch = 3;
        public static final int TRANSACTION_remoteInstallNewType = 8;
        public static final int TRANSACTION_sendGlobalCommond = 7;
        public static final int TRANSACTION_setPrefetchListener = 4;
        public static final int TRANSACTION_updatePlayerConfig = 6;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        /* loaded from: classes3.dex */
        public static class Proxy implements IRemotePlayerFactory {
            public static IRemotePlayerFactory sDefaultImpl;
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

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory
            public long calculateVideoCacheSizeCanBeCleared() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().calculateVideoCacheSizeCanBeCleared();
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory
            public IBinder createExtractor() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().createExtractor();
                    }
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory
            public IBinder createDownloader(int i, String str, PrefetchOptions prefetchOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (prefetchOptions != null) {
                        obtain.writeInt(1);
                        prefetchOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().createDownloader(i, str, prefetchOptions);
                    }
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory
            public IBinder createPlayer(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().createPlayer(i);
                    }
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory
            public void remoteInstallNewType(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().remoteInstallNewType(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory
            public boolean hasCacheFile(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    boolean z = false;
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().hasCacheFile(str);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory
            public void setPrefetchListener(IPrefetchListener iPrefetchListener) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iPrefetchListener != null) {
                        iBinder = iPrefetchListener.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setPrefetchListener(iPrefetchListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory
            public boolean updatePlayerConfig(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    boolean z = false;
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().updatePlayerConfig(str);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory
            public void prefetch(String str, String str2, String str3, int i, int i2, int i3, String str4, int i4, int i5, int i6, int i7, PrefetchOptions prefetchOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str4);
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    obtain.writeInt(i6);
                    obtain.writeInt(i7);
                    if (prefetchOptions != null) {
                        obtain.writeInt(1);
                        prefetchOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().prefetch(str, str2, str3, i, i2, i3, str4, i4, i5, i6, i7, prefetchOptions);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory
            public void sendGlobalCommond(String str, int i, long j, String str2, PrefetchOptions prefetchOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    obtain.writeString(str2);
                    if (prefetchOptions != null) {
                        obtain.writeInt(1);
                        prefetchOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    try {
                        if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().sendGlobalCommond(str, i, j, str2, prefetchOptions);
                            obtain2.recycle();
                            obtain.recycle();
                            return;
                        }
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } catch (Throwable th) {
                        th = th;
                        obtain2.recycle();
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRemotePlayerFactory getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IRemotePlayerFactory asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IRemotePlayerFactory)) {
                return (IRemotePlayerFactory) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static boolean setDefaultImpl(IRemotePlayerFactory iRemotePlayerFactory) {
            if (Proxy.sDefaultImpl == null) {
                if (iRemotePlayerFactory != null) {
                    Proxy.sDefaultImpl = iRemotePlayerFactory;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            PrefetchOptions prefetchOptions;
            PrefetchOptions prefetchOptions2;
            if (i != 1598968902) {
                PrefetchOptions prefetchOptions3 = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        IBinder createPlayer = createPlayer(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(createPlayer);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        IBinder createExtractor = createExtractor();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(createExtractor);
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        String readString = parcel.readString();
                        String readString2 = parcel.readString();
                        String readString3 = parcel.readString();
                        int readInt = parcel.readInt();
                        int readInt2 = parcel.readInt();
                        int readInt3 = parcel.readInt();
                        String readString4 = parcel.readString();
                        int readInt4 = parcel.readInt();
                        int readInt5 = parcel.readInt();
                        int readInt6 = parcel.readInt();
                        int readInt7 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            prefetchOptions = PrefetchOptions.CREATOR.createFromParcel(parcel);
                        } else {
                            prefetchOptions = null;
                        }
                        prefetch(readString, readString2, readString3, readInt, readInt2, readInt3, readString4, readInt4, readInt5, readInt6, readInt7, prefetchOptions);
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        setPrefetchListener(IPrefetchListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean hasCacheFile = hasCacheFile(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(hasCacheFile ? 1 : 0);
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean updatePlayerConfig = updatePlayerConfig(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(updatePlayerConfig ? 1 : 0);
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        String readString5 = parcel.readString();
                        int readInt8 = parcel.readInt();
                        long readLong = parcel.readLong();
                        String readString6 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            prefetchOptions2 = PrefetchOptions.CREATOR.createFromParcel(parcel);
                        } else {
                            prefetchOptions2 = null;
                        }
                        sendGlobalCommond(readString5, readInt8, readLong, readString6, prefetchOptions2);
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        remoteInstallNewType(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        long calculateVideoCacheSizeCanBeCleared = calculateVideoCacheSizeCanBeCleared();
                        parcel2.writeNoException();
                        parcel2.writeLong(calculateVideoCacheSizeCanBeCleared);
                        return true;
                    case 10:
                        parcel.enforceInterface(DESCRIPTOR);
                        int readInt9 = parcel.readInt();
                        String readString7 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            prefetchOptions3 = PrefetchOptions.CREATOR.createFromParcel(parcel);
                        }
                        IBinder createDownloader = createDownloader(readInt9, readString7, prefetchOptions3);
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(createDownloader);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
    }
}
