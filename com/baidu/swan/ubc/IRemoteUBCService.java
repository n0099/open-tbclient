package com.baidu.swan.ubc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes9.dex */
public interface IRemoteUBCService extends IInterface {
    void flowAddEvent(Flow flow, String str, String str2) throws RemoteException;

    void flowAddEventWithTime(Flow flow, String str, String str2, long j) throws RemoteException;

    void flowCancel(Flow flow) throws RemoteException;

    void flowEnd(Flow flow) throws RemoteException;

    void flowEndSlot(Flow flow, String str) throws RemoteException;

    void flowSetValue(Flow flow, String str) throws RemoteException;

    void flowSetValueWithDuration(Flow flow, String str) throws RemoteException;

    void flowStartSlot(Flow flow, String str, String str2) throws RemoteException;

    Flow ubcBeginFlow(String str, String str2, int i) throws RemoteException;

    void ubcOnEvent(String str, String str2, int i) throws RemoteException;

    /* loaded from: classes9.dex */
    public static abstract class Stub extends Binder implements IRemoteUBCService {
        private static final String DESCRIPTOR = "com.baidu.swan.ubc.IRemoteUBCService";
        static final int TRANSACTION_flowAddEvent = 3;
        static final int TRANSACTION_flowAddEventWithTime = 4;
        static final int TRANSACTION_flowCancel = 9;
        static final int TRANSACTION_flowEnd = 10;
        static final int TRANSACTION_flowEndSlot = 8;
        static final int TRANSACTION_flowSetValue = 5;
        static final int TRANSACTION_flowSetValueWithDuration = 6;
        static final int TRANSACTION_flowStartSlot = 7;
        static final int TRANSACTION_ubcBeginFlow = 2;
        static final int TRANSACTION_ubcOnEvent = 1;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRemoteUBCService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IRemoteUBCService)) {
                return (IRemoteUBCService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    ubcOnEvent(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    Flow ubcBeginFlow = ubcBeginFlow(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    if (ubcBeginFlow != null) {
                        parcel2.writeInt(1);
                        ubcBeginFlow.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    flowAddEvent(parcel.readInt() != 0 ? Flow.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    flowAddEventWithTime(parcel.readInt() != 0 ? Flow.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    flowSetValue(parcel.readInt() != 0 ? Flow.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    flowSetValueWithDuration(parcel.readInt() != 0 ? Flow.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    flowStartSlot(parcel.readInt() != 0 ? Flow.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    flowEndSlot(parcel.readInt() != 0 ? Flow.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    flowCancel(parcel.readInt() != 0 ? Flow.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    flowEnd(parcel.readInt() != 0 ? Flow.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* loaded from: classes9.dex */
        private static class Proxy implements IRemoteUBCService {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.baidu.swan.ubc.IRemoteUBCService
            public void ubcOnEvent(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.swan.ubc.IRemoteUBCService
            public Flow ubcBeginFlow(String str, String str2, int i) throws RemoteException {
                Flow flow;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        flow = Flow.CREATOR.createFromParcel(obtain2);
                    } else {
                        flow = null;
                    }
                    return flow;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.swan.ubc.IRemoteUBCService
            public void flowAddEvent(Flow flow, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (flow != null) {
                        obtain.writeInt(1);
                        flow.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.swan.ubc.IRemoteUBCService
            public void flowAddEventWithTime(Flow flow, String str, String str2, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (flow != null) {
                        obtain.writeInt(1);
                        flow.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeLong(j);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.swan.ubc.IRemoteUBCService
            public void flowSetValue(Flow flow, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (flow != null) {
                        obtain.writeInt(1);
                        flow.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.swan.ubc.IRemoteUBCService
            public void flowSetValueWithDuration(Flow flow, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (flow != null) {
                        obtain.writeInt(1);
                        flow.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.swan.ubc.IRemoteUBCService
            public void flowStartSlot(Flow flow, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (flow != null) {
                        obtain.writeInt(1);
                        flow.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.swan.ubc.IRemoteUBCService
            public void flowEndSlot(Flow flow, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (flow != null) {
                        obtain.writeInt(1);
                        flow.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.swan.ubc.IRemoteUBCService
            public void flowCancel(Flow flow) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (flow != null) {
                        obtain.writeInt(1);
                        flow.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.swan.ubc.IRemoteUBCService
            public void flowEnd(Flow flow) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (flow != null) {
                        obtain.writeInt(1);
                        flow.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
