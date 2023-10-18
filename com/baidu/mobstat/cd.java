package com.baidu.mobstat;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes3.dex */
public interface cd extends IInterface {
    String a() throws RemoteException;

    boolean b() throws RemoteException;

    /* loaded from: classes3.dex */
    public static abstract class a extends Binder implements cd {

        /* renamed from: com.baidu.mobstat.cd$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0115a implements cd {
            public IBinder a;

            public C0115a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.baidu.mobstat.cd
            public String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.baidu.mobstat.cd
            public boolean b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    boolean z = false;
                    this.a.transact(2, obtain, obtain2, 0);
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
        }

        public static cd a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof cd)) {
                return (cd) queryLocalInterface;
            }
            return new C0115a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 2) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    return true;
                }
                parcel.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                boolean b = b();
                parcel2.writeNoException();
                parcel2.writeInt(b ? 1 : 0);
                return true;
            }
            parcel.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            String a = a();
            parcel2.writeNoException();
            parcel2.writeString(a);
            return true;
        }
    }
}
