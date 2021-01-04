package com.baidu.sofire.mutiprocess;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes15.dex */
public interface a extends IInterface {
    Bundle a(Bundle bundle) throws RemoteException;

    Bundle a(String str) throws RemoteException;

    Bundle b(Bundle bundle) throws RemoteException;

    /* renamed from: com.baidu.sofire.mutiprocess.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static abstract class AbstractBinderC0366a extends Binder implements a {
        public AbstractBinderC0366a() {
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
            return new C0367a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
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
                case 2:
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
                case 3:
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
                case 1598968902:
                    parcel2.writeString("com.baidu.sofire.mutiprocess.IMutiProcessHandler");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.baidu.sofire.mutiprocess.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes15.dex */
        public static class C0367a implements a {

            /* renamed from: a  reason: collision with root package name */
            public static a f5590a;

            /* renamed from: b  reason: collision with root package name */
            private IBinder f5591b;

            C0367a(IBinder iBinder) {
                this.f5591b = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f5591b;
            }

            @Override // com.baidu.sofire.mutiprocess.a
            public final Bundle a(Bundle bundle) throws RemoteException {
                Bundle bundle2;
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
                    if (!this.f5591b.transact(1, obtain, obtain2, 0) && AbstractBinderC0366a.a() != null) {
                        bundle2 = AbstractBinderC0366a.a().a(bundle);
                    } else {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                        } else {
                            bundle2 = null;
                        }
                    }
                    return bundle2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.sofire.mutiprocess.a
            public final Bundle b(Bundle bundle) throws RemoteException {
                Bundle bundle2;
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
                    if (!this.f5591b.transact(2, obtain, obtain2, 0) && AbstractBinderC0366a.a() != null) {
                        bundle2 = AbstractBinderC0366a.a().b(bundle);
                    } else {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                        } else {
                            bundle2 = null;
                        }
                    }
                    return bundle2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.sofire.mutiprocess.a
            public final Bundle a(String str) throws RemoteException {
                Bundle bundle;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.sofire.mutiprocess.IMutiProcessHandler");
                    obtain.writeString(str);
                    if (!this.f5591b.transact(3, obtain, obtain2, 0) && AbstractBinderC0366a.a() != null) {
                        bundle = AbstractBinderC0366a.a().a(str);
                    } else {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                        } else {
                            bundle = null;
                        }
                    }
                    return bundle;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static a a() {
            return C0367a.f5590a;
        }
    }
}
