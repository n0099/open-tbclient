package com.baidu.cyberplayer.sdk.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public interface IRemotePlayerListener extends IInterface {

    /* loaded from: classes3.dex */
    public static class Default implements IRemotePlayerListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener
        public void onBufferingUpdate(int i) throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener
        public void onCallback(String str, List<String> list) throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener
        public void onCompletion() throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener
        public boolean onError(int i, int i2, String str) throws RemoteException {
            return false;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener
        public boolean onInfo(int i, int i2, String str) throws RemoteException {
            return false;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener
        public void onMediaRuntimeInfo(String str) throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener
        public boolean onMediaSourceChanged(int i, int i2, String str) throws RemoteException {
            return false;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener
        public void onPrepared() throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener
        public void onSeekComplete() throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener
        public void onVideoSizeChanged(int i, int i2, int i3, int i4) throws RemoteException {
        }
    }

    void onBufferingUpdate(int i) throws RemoteException;

    void onCallback(String str, List<String> list) throws RemoteException;

    void onCompletion() throws RemoteException;

    boolean onError(int i, int i2, String str) throws RemoteException;

    boolean onInfo(int i, int i2, String str) throws RemoteException;

    void onMediaRuntimeInfo(String str) throws RemoteException;

    boolean onMediaSourceChanged(int i, int i2, String str) throws RemoteException;

    void onPrepared() throws RemoteException;

    void onSeekComplete() throws RemoteException;

    void onVideoSizeChanged(int i, int i2, int i3, int i4) throws RemoteException;

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IRemotePlayerListener {
        public static final String DESCRIPTOR = "com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener";
        public static final int TRANSACTION_onBufferingUpdate = 3;
        public static final int TRANSACTION_onCallback = 8;
        public static final int TRANSACTION_onCompletion = 2;
        public static final int TRANSACTION_onError = 6;
        public static final int TRANSACTION_onInfo = 7;
        public static final int TRANSACTION_onMediaRuntimeInfo = 10;
        public static final int TRANSACTION_onMediaSourceChanged = 9;
        public static final int TRANSACTION_onPrepared = 1;
        public static final int TRANSACTION_onSeekComplete = 4;
        public static final int TRANSACTION_onVideoSizeChanged = 5;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        /* loaded from: classes3.dex */
        public static class Proxy implements IRemotePlayerListener {
            public static IRemotePlayerListener sDefaultImpl;
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

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener
            public void onBufferingUpdate(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onBufferingUpdate(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener
            public void onMediaRuntimeInfo(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onMediaRuntimeInfo(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener
            public void onCallback(String str, List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStringList(list);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onCallback(str, list);
                        return;
                    }
                    obtain2.readException();
                    obtain2.readStringList(list);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener
            public void onCompletion() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onCompletion();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener
            public void onPrepared() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onPrepared();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener
            public void onSeekComplete() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onSeekComplete();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener
            public boolean onError(int i, int i2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    boolean z = false;
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().onError(i, i2, str);
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

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener
            public boolean onInfo(int i, int i2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    boolean z = false;
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().onInfo(i, i2, str);
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

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener
            public boolean onMediaSourceChanged(int i, int i2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    boolean z = false;
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().onMediaSourceChanged(i, i2, str);
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

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener
            public void onVideoSizeChanged(int i, int i2, int i3, int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onVideoSizeChanged(i, i2, i3, i4);
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

        public static IRemotePlayerListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IRemotePlayerListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IRemotePlayerListener)) {
                return (IRemotePlayerListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static boolean setDefaultImpl(IRemotePlayerListener iRemotePlayerListener) {
            if (Proxy.sDefaultImpl == null) {
                if (iRemotePlayerListener != null) {
                    Proxy.sDefaultImpl = iRemotePlayerListener;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        onPrepared();
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        onCompletion();
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        onBufferingUpdate(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        onSeekComplete();
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        onVideoSizeChanged(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean onError = onError(parcel.readInt(), parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(onError ? 1 : 0);
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean onInfo = onInfo(parcel.readInt(), parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(onInfo ? 1 : 0);
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        String readString = parcel.readString();
                        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
                        onCallback(readString, createStringArrayList);
                        parcel2.writeNoException();
                        parcel2.writeStringList(createStringArrayList);
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean onMediaSourceChanged = onMediaSourceChanged(parcel.readInt(), parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(onMediaSourceChanged ? 1 : 0);
                        return true;
                    case 10:
                        parcel.enforceInterface(DESCRIPTOR);
                        onMediaRuntimeInfo(parcel.readString());
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
