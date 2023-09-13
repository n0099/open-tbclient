package com.baidu.cyberplayer.sdk.remote;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.cyberplayer.sdk.remote.IRemoteDownloaderListener;
/* loaded from: classes3.dex */
public interface IRemoteDownloader extends IInterface {

    /* loaded from: classes3.dex */
    public static class Default implements IRemoteDownloader {
        @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
        public void addListener(IRemoteDownloaderListener iRemoteDownloaderListener) throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
        public void addTask(CyberDownloadItem cyberDownloadItem) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
        public void cancelAllTasks() throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
        public void cancelTask(String str) throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
        public void clearAllCaches() throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
        public void clearCacheFile(String str) throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
        public long getAllCacheSize() throws RemoteException {
            return 0L;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
        public Bundle getDownloadInfo(String str) throws RemoteException {
            return null;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
        public void pauseAllTasks() throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
        public void pauseTask(String str) throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
        public void release() throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
        public void removeListener(IRemoteDownloaderListener iRemoteDownloaderListener) throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
        public void resumeAllTasks() throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
        public void resumeTask(String str) throws RemoteException {
        }
    }

    void addListener(IRemoteDownloaderListener iRemoteDownloaderListener) throws RemoteException;

    void addTask(CyberDownloadItem cyberDownloadItem) throws RemoteException;

    void cancelAllTasks() throws RemoteException;

    void cancelTask(String str) throws RemoteException;

    void clearAllCaches() throws RemoteException;

    void clearCacheFile(String str) throws RemoteException;

    long getAllCacheSize() throws RemoteException;

    Bundle getDownloadInfo(String str) throws RemoteException;

    void pauseAllTasks() throws RemoteException;

    void pauseTask(String str) throws RemoteException;

    void release() throws RemoteException;

    void removeListener(IRemoteDownloaderListener iRemoteDownloaderListener) throws RemoteException;

    void resumeAllTasks() throws RemoteException;

    void resumeTask(String str) throws RemoteException;

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IRemoteDownloader {
        public static final String DESCRIPTOR = "com.baidu.cyberplayer.sdk.remote.IRemoteDownloader";
        public static final int TRANSACTION_addListener = 12;
        public static final int TRANSACTION_addTask = 1;
        public static final int TRANSACTION_cancelAllTasks = 5;
        public static final int TRANSACTION_cancelTask = 4;
        public static final int TRANSACTION_clearAllCaches = 8;
        public static final int TRANSACTION_clearCacheFile = 10;
        public static final int TRANSACTION_getAllCacheSize = 9;
        public static final int TRANSACTION_getDownloadInfo = 11;
        public static final int TRANSACTION_pauseAllTasks = 6;
        public static final int TRANSACTION_pauseTask = 2;
        public static final int TRANSACTION_release = 14;
        public static final int TRANSACTION_removeListener = 13;
        public static final int TRANSACTION_resumeAllTasks = 7;
        public static final int TRANSACTION_resumeTask = 3;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        /* loaded from: classes3.dex */
        public static class Proxy implements IRemoteDownloader {
            public static IRemoteDownloader sDefaultImpl;
            public IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
            public void addListener(IRemoteDownloaderListener iRemoteDownloaderListener) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iRemoteDownloaderListener != null) {
                        iBinder = iRemoteDownloaderListener.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().addListener(iRemoteDownloaderListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
            public void addTask(CyberDownloadItem cyberDownloadItem) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (cyberDownloadItem != null) {
                        obtain.writeInt(1);
                        cyberDownloadItem.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().addTask(cyberDownloadItem);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
            public Bundle getDownloadInfo(String str) throws RemoteException {
                Bundle bundle;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadInfo(str);
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

            @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
            public void removeListener(IRemoteDownloaderListener iRemoteDownloaderListener) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iRemoteDownloaderListener != null) {
                        iBinder = iRemoteDownloaderListener.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(13, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().removeListener(iRemoteDownloaderListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
            public void cancelAllTasks() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().cancelAllTasks();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
            public void clearAllCaches() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().clearAllCaches();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
            public long getAllCacheSize() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAllCacheSize();
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
            public void pauseAllTasks() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().pauseAllTasks();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
            public void release() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(14, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().release();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
            public void resumeAllTasks() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().resumeAllTasks();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
            public void cancelTask(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().cancelTask(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
            public void clearCacheFile(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().clearCacheFile(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
            public void pauseTask(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().pauseTask(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
            public void resumeTask(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().resumeTask(str);
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

        public static IRemoteDownloader getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IRemoteDownloader asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IRemoteDownloader)) {
                return (IRemoteDownloader) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static boolean setDefaultImpl(IRemoteDownloader iRemoteDownloader) {
            if (Proxy.sDefaultImpl == null) {
                if (iRemoteDownloader != null) {
                    Proxy.sDefaultImpl = iRemoteDownloader;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            CyberDownloadItem cyberDownloadItem;
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            cyberDownloadItem = CyberDownloadItem.CREATOR.createFromParcel(parcel);
                        } else {
                            cyberDownloadItem = null;
                        }
                        addTask(cyberDownloadItem);
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        pauseTask(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        resumeTask(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        cancelTask(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        cancelAllTasks();
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        pauseAllTasks();
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        resumeAllTasks();
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        clearAllCaches();
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        long allCacheSize = getAllCacheSize();
                        parcel2.writeNoException();
                        parcel2.writeLong(allCacheSize);
                        return true;
                    case 10:
                        parcel.enforceInterface(DESCRIPTOR);
                        clearCacheFile(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface(DESCRIPTOR);
                        Bundle downloadInfo = getDownloadInfo(parcel.readString());
                        parcel2.writeNoException();
                        if (downloadInfo != null) {
                            parcel2.writeInt(1);
                            downloadInfo.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 12:
                        parcel.enforceInterface(DESCRIPTOR);
                        addListener(IRemoteDownloaderListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface(DESCRIPTOR);
                        removeListener(IRemoteDownloaderListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel.enforceInterface(DESCRIPTOR);
                        release();
                        parcel2.writeNoException();
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
