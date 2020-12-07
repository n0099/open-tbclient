package com.baidu.mapframework.open.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.mapframework.open.aidl.b;
/* loaded from: classes26.dex */
public interface a extends IInterface {

    /* renamed from: com.baidu.mapframework.open.aidl.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static abstract class AbstractBinderC0261a extends Binder implements a {

        /* renamed from: com.baidu.mapframework.open.aidl.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        private static class C0262a implements a {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f2187a;

            C0262a(IBinder iBinder) {
                this.f2187a = iBinder;
            }

            @Override // com.baidu.mapframework.open.aidl.a
            public void a(b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.mapframework.open.aidl.IMapOpenService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.f2187a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2187a;
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.baidu.mapframework.open.aidl.IMapOpenService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0262a(iBinder) : (a) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.baidu.mapframework.open.aidl.IMapOpenService");
                    a(b.a.b(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.baidu.mapframework.open.aidl.IMapOpenService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(b bVar) throws RemoteException;
}
