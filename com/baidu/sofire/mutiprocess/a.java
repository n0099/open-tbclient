package com.baidu.sofire.mutiprocess;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public interface a extends IInterface {
    Bundle a(Bundle bundle) throws RemoteException;

    Bundle a(String str) throws RemoteException;

    Bundle b(Bundle bundle) throws RemoteException;

    /* renamed from: com.baidu.sofire.mutiprocess.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractBinderC0144a extends Binder implements a {
        public AbstractBinderC0144a() {
            attachInterface(this, "com.baidu.sofire.mutiprocess.IMutiProcessHandler");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.baidu.sofire.mutiprocess.IMutiProcessHandler");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C0145a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface("com.baidu.sofire.mutiprocess.IMutiProcessHandler");
                Bundle a2 = a(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                if (a2 != null) {
                    parcel2.writeInt(1);
                    a2.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i2 == 2) {
                parcel.enforceInterface("com.baidu.sofire.mutiprocess.IMutiProcessHandler");
                Bundle b2 = b(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                if (b2 != null) {
                    parcel2.writeInt(1);
                    b2.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i2 != 3) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString("com.baidu.sofire.mutiprocess.IMutiProcessHandler");
                return true;
            } else {
                parcel.enforceInterface("com.baidu.sofire.mutiprocess.IMutiProcessHandler");
                Bundle a3 = a(parcel.readString());
                parcel2.writeNoException();
                if (a3 != null) {
                    parcel2.writeInt(1);
                    a3.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
        }

        public static a a() {
            return C0145a.f10314a;
        }

        /* renamed from: com.baidu.sofire.mutiprocess.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0145a implements a {

            /* renamed from: a  reason: collision with root package name */
            public static a f10314a;

            /* renamed from: b  reason: collision with root package name */
            public IBinder f10315b;

            public C0145a(IBinder iBinder) {
                this.f10315b = iBinder;
            }

            @Override // com.baidu.sofire.mutiprocess.a
            public final Bundle a(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.sofire.mutiprocess.IMutiProcessHandler");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f10315b.transact(1, obtain, obtain2, 0) && AbstractBinderC0144a.a() != null) {
                        return AbstractBinderC0144a.a().a(bundle);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f10315b;
            }

            @Override // com.baidu.sofire.mutiprocess.a
            public final Bundle b(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.sofire.mutiprocess.IMutiProcessHandler");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f10315b.transact(2, obtain, obtain2, 0) && AbstractBinderC0144a.a() != null) {
                        return AbstractBinderC0144a.a().b(bundle);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.sofire.mutiprocess.a
            public final Bundle a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.sofire.mutiprocess.IMutiProcessHandler");
                    obtain.writeString(str);
                    if (!this.f10315b.transact(3, obtain, obtain2, 0) && AbstractBinderC0144a.a() != null) {
                        return AbstractBinderC0144a.a().a(str);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
