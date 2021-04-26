package android.app;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public interface IProcessObserver extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IProcessObserver {
        public static final String DESCRIPTOR = "android.app.IProcessObserver";
        public static final int TRANSACTION_onForegroundActivitiesChanged = 1;
        public static final int TRANSACTION_onImportanceChanged = 2;
        public static final int TRANSACTION_onProcessDied = 3;

        /* loaded from: classes.dex */
        public static class Proxy implements IProcessObserver {
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.app.IProcessObserver
            public void onForegroundActivitiesChanged(int i2, int i3, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.app.IProcessObserver
            public void onImportanceChanged(int i2, int i3, int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    this.mRemote.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.app.IProcessObserver
            public void onProcessDied(int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    this.mRemote.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IProcessObserver asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IProcessObserver)) {
                return (IProcessObserver) queryLocalInterface;
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
                onForegroundActivitiesChanged(parcel.readInt(), parcel.readInt(), parcel.readInt() != 0);
                return true;
            } else if (i2 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onImportanceChanged(parcel.readInt(), parcel.readInt(), parcel.readInt());
                return true;
            } else if (i2 == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                onProcessDied(parcel.readInt(), parcel.readInt());
                return true;
            } else if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    void onForegroundActivitiesChanged(int i2, int i3, boolean z) throws RemoteException;

    void onImportanceChanged(int i2, int i3, int i4) throws RemoteException;

    void onProcessDied(int i2, int i3) throws RemoteException;
}
