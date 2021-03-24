package com.baidu.mapframework.open.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public interface b extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class a extends Binder implements b {

        /* renamed from: com.baidu.mapframework.open.aidl.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0097a implements b {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f7452a;

            public C0097a(IBinder iBinder) {
                this.f7452a = iBinder;
            }

            @Override // com.baidu.mapframework.open.aidl.b
            public void a(IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.mapframework.open.aidl.IOpenClientCallback");
                    obtain.writeStrongBinder(iBinder);
                    this.f7452a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7452a;
            }
        }

        public a() {
            attachInterface(this, "com.baidu.mapframework.open.aidl.IOpenClientCallback");
        }

        public static b b(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.baidu.mapframework.open.aidl.IOpenClientCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new C0097a(iBinder) : (b) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.baidu.mapframework.open.aidl.IOpenClientCallback");
                return true;
            }
            parcel.enforceInterface("com.baidu.mapframework.open.aidl.IOpenClientCallback");
            a(parcel.readStrongBinder());
            parcel2.writeNoException();
            return true;
        }
    }

    void a(IBinder iBinder) throws RemoteException;
}
