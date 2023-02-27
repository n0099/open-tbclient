package com.baidu.swan.apps;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.swan.apps.IAsyncProcessCallback;
/* loaded from: classes3.dex */
public interface IProcessBridge extends IInterface {

    /* loaded from: classes3.dex */
    public static class Default implements IProcessBridge {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.baidu.swan.apps.IProcessBridge
        public void callMainProcessAsync(String str, int i, IAsyncProcessCallback iAsyncProcessCallback) throws RemoteException {
        }

        @Override // com.baidu.swan.apps.IProcessBridge
        public Bundle callMainProcessSync(String str, Bundle bundle) throws RemoteException {
            return null;
        }

        @Override // com.baidu.swan.apps.IProcessBridge
        public void send(Message message) throws RemoteException {
        }
    }

    void callMainProcessAsync(String str, int i, IAsyncProcessCallback iAsyncProcessCallback) throws RemoteException;

    Bundle callMainProcessSync(String str, Bundle bundle) throws RemoteException;

    void send(Message message) throws RemoteException;

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IProcessBridge {
        public static final String DESCRIPTOR = "com.baidu.swan.apps.IProcessBridge";
        public static final int TRANSACTION_callMainProcessAsync = 3;
        public static final int TRANSACTION_callMainProcessSync = 2;
        public static final int TRANSACTION_send = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        /* loaded from: classes3.dex */
        public static class Proxy implements IProcessBridge {
            public static IProcessBridge sDefaultImpl;
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

            @Override // com.baidu.swan.apps.IProcessBridge
            public void callMainProcessAsync(String str, int i, IAsyncProcessCallback iAsyncProcessCallback) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (iAsyncProcessCallback != null) {
                        iBinder = iAsyncProcessCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().callMainProcessAsync(str, i, iAsyncProcessCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.swan.apps.IProcessBridge
            public Bundle callMainProcessSync(String str, Bundle bundle) throws RemoteException {
                Bundle bundle2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().callMainProcessSync(str, bundle);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    } else {
                        bundle2 = null;
                    }
                    if (obtain2.readInt() != 0) {
                        bundle.readFromParcel(obtain2);
                    }
                    return bundle2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.swan.apps.IProcessBridge
            public void send(Message message) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (message != null) {
                        obtain.writeInt(1);
                        message.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().send(message);
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IProcessBridge getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IProcessBridge asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IProcessBridge)) {
                return (IProcessBridge) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static boolean setDefaultImpl(IProcessBridge iProcessBridge) {
            if (Proxy.sDefaultImpl == null && iProcessBridge != null) {
                Proxy.sDefaultImpl = iProcessBridge;
                return true;
            }
            return false;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            Message message = null;
            Bundle bundle = null;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 1598968902) {
                            return super.onTransact(i, parcel, parcel2, i2);
                        }
                        parcel2.writeString(DESCRIPTOR);
                        return true;
                    }
                    parcel.enforceInterface(DESCRIPTOR);
                    callMainProcessAsync(parcel.readString(), parcel.readInt(), IAsyncProcessCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                parcel.enforceInterface(DESCRIPTOR);
                String readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                Bundle callMainProcessSync = callMainProcessSync(readString, bundle);
                parcel2.writeNoException();
                if (callMainProcessSync != null) {
                    parcel2.writeInt(1);
                    callMainProcessSync.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                if (bundle != null) {
                    parcel2.writeInt(1);
                    bundle.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            if (parcel.readInt() != 0) {
                message = (Message) Message.CREATOR.createFromParcel(parcel);
            }
            send(message);
            return true;
        }
    }
}
